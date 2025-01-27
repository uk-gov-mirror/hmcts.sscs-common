package uk.gov.hmcts.reform.sscs.model.dwp;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class DwpMappings {

    private OfficeMapping[] pip;
    private OfficeMapping[] esa;
    private OfficeMapping uc;
    private OfficeMapping[] dla;
    private OfficeMapping carersAllowance;
    private OfficeMapping testHmctsAddress;
}

