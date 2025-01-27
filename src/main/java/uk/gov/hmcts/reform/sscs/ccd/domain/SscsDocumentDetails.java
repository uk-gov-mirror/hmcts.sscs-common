package uk.gov.hmcts.reform.sscs.ccd.domain;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@SuperBuilder(toBuilder = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = false)
public class SscsDocumentDetails extends AbstractDocumentDetails {

    private String documentEmailContent;
    private String controlNumber;
    private DocumentLink editedDocumentLink;
    private UploadParty partyUploaded;
    private String dateApproved;

    @JsonCreator
    public SscsDocumentDetails(@JsonProperty("documentType") String documentType,
                               @JsonProperty("documentFileName") String documentFileName,
                               @JsonProperty("documentEmailContent") String documentEmailContent,
                               @JsonProperty("documentDateAdded") String documentDateAdded,
                               @JsonProperty("documentLink") DocumentLink documentLink,
                               @JsonProperty("editedDocumentLink") DocumentLink editedDocumentLink,
                               @JsonProperty("documentComment") String documentComment,
                               @JsonProperty("controlNumber") String controlNumber,
                               @JsonProperty("evidenceIssued") String evidenceIssued,
                               @JsonProperty("bundleAddition") String bundleAddition,
                               @JsonProperty("documentTranslationStatus") SscsDocumentTranslationStatus documentTranslationStatus,
                               @JsonProperty("partyUploaded") UploadParty partyUploaded,
                               @JsonProperty("dateApproved") String dateApproved,
                               @JsonProperty("resizedDocumentLink") DocumentLink resizedDocumentLink) {
        super(documentType, documentFileName, documentDateAdded, documentLink, editedDocumentLink, documentComment, evidenceIssued, bundleAddition, documentTranslationStatus, partyUploaded, dateApproved, resizedDocumentLink);
        this.documentEmailContent = documentEmailContent;
        this.controlNumber = controlNumber;
        this.editedDocumentLink = editedDocumentLink;
        this.partyUploaded = partyUploaded;
        this.dateApproved = dateApproved;
    }
}
