package uk.gov.hmcts.reform.sscs.service;

import static org.apache.commons.lang3.StringUtils.equalsIgnoreCase;
import static uk.gov.hmcts.reform.sscs.ccd.domain.Benefit.*;

import com.google.gson.Gson;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import uk.gov.hmcts.reform.sscs.ccd.domain.Address;
import uk.gov.hmcts.reform.sscs.ccd.domain.Benefit;
import uk.gov.hmcts.reform.sscs.ccd.domain.SscsCaseData;
import uk.gov.hmcts.reform.sscs.exception.DwpAddressLookupException;
import uk.gov.hmcts.reform.sscs.exception.NoMrnDetailsException;
import uk.gov.hmcts.reform.sscs.model.dwp.DwpMappings;
import uk.gov.hmcts.reform.sscs.model.dwp.OfficeAddress;
import uk.gov.hmcts.reform.sscs.model.dwp.OfficeMapping;

@Service
@Slf4j
public class DwpAddressLookupService {

    private static final String TEST_HMCTS_ADDRESS = "test-hmcts-address";

    private static DwpMappings dwpMappings;
    private static OfficeMapping[] allDwpBenefitOffices;

    static {
        try {
            String json = IOUtils.resourceToString("reference-data/dwpAddresses.json",
                StandardCharsets.UTF_8, Thread.currentThread().getContextClassLoader());
            Gson gson = new Gson();
            dwpMappings = gson.fromJson(json, DwpMappings.class);

            allDwpBenefitOffices = Stream.of(dwpMappings.getPip(), dwpMappings.getEsa(), dwpMappings.getDla())
                    .flatMap(Stream::of)
                    .toArray(OfficeMapping[]::new);

            allDwpBenefitOffices = Arrays.copyOf(allDwpBenefitOffices, allDwpBenefitOffices.length + 1);
            allDwpBenefitOffices[allDwpBenefitOffices.length - 1] = dwpMappings.getUc();

        } catch (Exception exception) {
            log.error("Cannot parse dwp addresses. " + exception.getMessage(), exception);
            throw new RuntimeException("cannot parse dwp addresses", exception);
        }
    }


    public Address lookupDwpAddress(SscsCaseData caseData) {
        if (Objects.nonNull(caseData.getAppeal()) && Objects.nonNull(caseData.getAppeal().getMrnDetails())
            && Objects.nonNull(caseData.getAppeal().getMrnDetails().getDwpIssuingOffice())) {

            final OfficeAddress dwpAddress = lookup(caseData.getAppeal().getBenefitType().getCode(),
                caseData.getAppeal().getMrnDetails().getDwpIssuingOffice());

            return buildAddress(dwpAddress);
        } else {
            throw new NoMrnDetailsException(caseData);
        }
    }

    private OfficeAddress lookup(String benefitType, String dwpIssuingOffice) {
        Optional<OfficeMapping> officeMapping = getDwpMappingByOffice(benefitType, dwpIssuingOffice);

        if (officeMapping.isEmpty()) {
            throw new DwpAddressLookupException(String.format("could not find dwp officeAddress for benefitType %s and dwpIssuingOffice %s",
                    benefitType, dwpIssuingOffice));
        }
        return officeMapping.get().getAddress();
    }

    private Address buildAddress(OfficeAddress dwpAddress) {
        return Address.builder()
            .line1(dwpAddress.getLine1())
            .town(dwpAddress.getLine2())
            .county(dwpAddress.getLine3())
            .postcode(dwpAddress.getPostCode())
            .build();
    }

    public String getDwpRegionalCenterByBenefitTypeAndOffice(String benefitType, String dwpIssuingOffice) {

        Optional<OfficeMapping> officeMapping = getDwpMappingByOffice(benefitType, dwpIssuingOffice);

        return PIP.name().equalsIgnoreCase(benefitType)
                ? officeMapping.map(mapping -> mapping.getMapping().getDwpRegionCentre()).orElse(null) :
                officeMapping.map(mapping -> mapping.getMapping().getCcd()).orElse(null);
    }

    public String getDefaultDwpRegionalCenterByBenefitTypeAndOffice(String benefitType) {

        Optional<OfficeMapping> officeMapping = getDefaultDwpMappingByBenefitType(benefitType);

        return PIP.name().equalsIgnoreCase(benefitType)
                ? officeMapping.map(mapping -> mapping.getMapping().getDwpRegionCentre()).orElse(null) :
                officeMapping.map(mapping -> mapping.getMapping().getCcd()).orElse(null);
    }

    public Optional<OfficeMapping> getDwpMappingByOffice(String benefitType, String dwpIssuingOffice) {
        log.info("looking up officeAddress for benefitType {} and dwpIssuingOffice {}", benefitType, dwpIssuingOffice);

        if (equalsIgnoreCase(dwpIssuingOffice, TEST_HMCTS_ADDRESS)) {
            return Optional.of(dwpMappings.getTestHmctsAddress());
        }
        return  findBenefitByShortName(benefitType)
                .flatMap(b -> b.getOfficeMappings().apply(this, dwpIssuingOffice));
    }

    public Optional<OfficeMapping> carersAllowanceOfficeMapping(String dwpIssuingOffice) {
        return Optional.of(dwpMappings.getCarersAllowance());
    }

    public Optional<OfficeMapping> dlaOfficeMapping(String dwpIssuingOffice) {
        return getOfficeMappingByDwpIssuingOffice(dwpIssuingOffice, dwpMappings.getDla());
    }

    public Optional<OfficeMapping> ucOfficeMapping(String dwpIssuingOffice) {
        return Optional.of(dwpMappings.getUc());
    }

    public Optional<OfficeMapping> esaOfficeMapping(String dwpIssuingOffice) {
        return getOfficeMappingByDwpIssuingOffice(dwpIssuingOffice, dwpMappings.getEsa());
    }

    public Optional<OfficeMapping> pipOfficeMapping(String dwpIssuingOffice) {
        Optional<OfficeMapping> officeMapping;
        String dwpIssuingOfficeStripped = Optional.ofNullable(StringUtils
                .substringBetween(dwpIssuingOffice,"(", ")"))
                .orElse(dwpIssuingOffice.replaceAll("\\D+",""));

        if (StringUtils.isEmpty(dwpIssuingOfficeStripped)) {
            dwpIssuingOfficeStripped = dwpIssuingOffice;
        }

        officeMapping = getOfficeMappingByDwpIssuingOffice(dwpIssuingOfficeStripped, dwpMappings.getPip());
        return officeMapping;
    }

    public Optional<OfficeMapping> getDefaultDwpMappingByBenefitType(String benefitType) {
        return Benefit.findBenefitByShortName(benefitType)
                .flatMap(benefit -> benefit.getDefaultOfficeMapping().apply(this));
    }

    public Optional<OfficeMapping> esaDefaultMapping() {
        return Stream.of(dwpMappings.getEsa()).filter(OfficeMapping::isDefault).findFirst();
    }

    public Optional<OfficeMapping> ucDefaultMapping() {
        return Stream.of(dwpMappings.getUc()).filter(OfficeMapping::isDefault).findFirst();
    }

    public Optional<OfficeMapping> carersAllowanceDefaultMapping() {
        return Stream.of(dwpMappings.getCarersAllowance()).filter(OfficeMapping::isDefault).findFirst();
    }

    public Optional<OfficeMapping> dlaDefaultMapping() {
        return Stream.of(dwpMappings.getDla()).filter(OfficeMapping::isDefault).findFirst();
    }

    public Optional<OfficeMapping> pipDefaultMapping() {
        return Stream.of(dwpMappings.getPip()).filter(OfficeMapping::isDefault).findFirst();
    }

    private Optional<OfficeMapping> getOfficeMappingByDwpIssuingOffice(String dwpIssuingOffice, OfficeMapping[] mappings) {
        for (OfficeMapping office : mappings) {
            if (StringUtils.stripToEmpty(dwpIssuingOffice).equalsIgnoreCase(office.getCode())) {
                return Optional.of(office);
            }
        }
        return Optional.empty();
    }

    public OfficeMapping[] allDwpBenefitOffices() {
        return allDwpBenefitOffices;
    }
}
