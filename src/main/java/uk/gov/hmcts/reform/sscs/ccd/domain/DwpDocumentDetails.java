package uk.gov.hmcts.reform.sscs.ccd.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;


@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@SuperBuilder(toBuilder = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = false)
public class DwpDocumentDetails extends AbstractDocumentDetails {

    private final LocalDateTime documentDateTimeAdded;
    private String dwpEditedEvidenceReason;
    private DocumentLink rip1DocumentLink;

    @JsonCreator
    public DwpDocumentDetails(@JsonProperty("documentType") String documentType,
                              @JsonProperty("documentFileName") String documentFileName,
                              @Deprecated(since = "02/2021 - use documentDateTimeAdded") @JsonProperty("documentDateAdded") String documentDateAdded,
                              @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
                                  @JsonSerialize(using = LocalDateTimeSerializer.class)
                              @JsonProperty("documentDateTimeAdded") LocalDateTime documentDateTimeAdded,
                              @JsonProperty("documentLink") DocumentLink documentLink,
                              @JsonProperty("editedDocumentLink") DocumentLink editedDocumentLink,
                              @JsonProperty("dwpEditedEvidenceReason") String dwpEditedEvidenceReason,
                              @JsonProperty("documentComment") String documentComment,
                              @JsonProperty("evidenceIssued") String evidenceIssued,
                              @JsonProperty("bundleAddition") String bundleAddition,
                              @JsonProperty("documentTranslationStatus") SscsDocumentTranslationStatus documentTranslationStatus,
                              @JsonProperty("partyUploaded") UploadParty partyUploaded,
                              @JsonProperty("dateApproved") String dateApproved,
                              @JsonProperty("rip1DocumentLink") DocumentLink rip1DocumentLink) {

        super(documentType, documentFileName, documentDateAdded, documentLink, editedDocumentLink, documentComment, evidenceIssued, bundleAddition, documentTranslationStatus, partyUploaded, dateApproved, null);

        this.dwpEditedEvidenceReason = dwpEditedEvidenceReason;
        this.documentDateTimeAdded = documentDateTimeAdded;
        this.rip1DocumentLink = rip1DocumentLink;
    }

    @JsonIgnore
    @Override
    public LocalDateTime getDateTimeFormatted() {
        if (documentDateTimeAdded != null) {
            return documentDateTimeAdded;
        }
        return super.getDateTimeFormatted();
    }
}
