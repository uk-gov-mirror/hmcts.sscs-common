package uk.gov.hmcts.reform.sscs.ccd.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.validation.Valid;
import javax.validation.groups.ConvertGroup;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import uk.gov.hmcts.reform.sscs.ccd.callback.DocumentType;
import uk.gov.hmcts.reform.sscs.ccd.validation.documentlink.DocumentLinkMustBePdf;
import uk.gov.hmcts.reform.sscs.ccd.validation.groups.UniversalCreditValidationGroup;
import uk.gov.hmcts.reform.sscs.ccd.validation.localdate.LocalDateMustBeInFuture;
import uk.gov.hmcts.reform.sscs.ccd.validation.localdate.LocalDateMustNotBeInFuture;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SscsCaseData  implements CaseData {

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String ccdCaseId;

    private State state;
    private State previousState;
    private String caseReference;
    private String caseCreated;
    private InfoRequests infoRequests;
    private String region;
    private Appeal appeal;
    private List<Hearing> hearings;
    private Evidence evidence;
    private List<DwpTimeExtension> dwpTimeExtension;
    private List<Event> events;
    @Getter(AccessLevel.NONE)
    private Subscriptions subscriptions;
    private RegionalProcessingCenter regionalProcessingCenter;
    private List<Bundle> caseBundles;
    private List<SscsDocument> sscsDocument;
    private List<SscsDocument> draftSscsDocument;
    private List<SscsFurtherEvidenceDoc> draftSscsFurtherEvidenceDocument;
    private List<CorDocument> corDocument;
    private List<CorDocument> draftCorDocument;
    private SscsInterlocDecisionDocument sscsInterlocDecisionDocument;
    private SscsInterlocDirectionDocument sscsInterlocDirectionDocument;
    private SscsStrikeOutDocument sscsStrikeOutDocument;
    private String generatedNino;
    private String generatedSurname;
    private String generatedEmail;
    private String generatedMobile;
    @JsonProperty("generatedDOB")
    private String generatedDob;
    private DirectionResponse directionResponse;
    private String evidencePresent;
    private String bulkScanCaseReference;
    private String decisionNotes;
    private String isCorDecision;
    private String relistingReason;
    private String dateSentToDwp;
    private String interlocReviewState;
    private String hmctsDwpState;
    private String dwpFurtherEvidenceStates;
    private DynamicList originalSender;
    private DynamicList furtherEvidenceAction;
    private List<ScannedDocument> scannedDocuments;
    private String informationFromAppellant;
    private String outcome;
    private String evidenceHandled;
    private String assignedToJudge;
    private String assignedToDisabilityMember;
    private String assignedToMedicalMember;
    private DynamicList reissueFurtherEvidenceDocument;
    private String resendToAppellant;
    private String resendToRepresentative;
    private String resendToDwp;
    private String caseCode;
    private String benefitCode;
    private String issueCode;
    private DynamicList dwpOriginatingOffice;
    private DynamicList dwpPresentingOffice;
    private String dwpIsOfficerAttending;
    @JsonProperty("dwpUCB")
    private String dwpUcb;
    @JsonProperty("dwpPHME")
    private String dwpPhme;
    private String dwpComplexAppeal;
    private String dwpFurtherInfo;
    private List<Correspondence> correspondence;
    private String interlocReferralDate;
    private String interlocReferralReason;
    private String dwpRegionalCentre;
    private String generateNotice;
    private DocumentLink previewDocument;
    private String bodyContent;
    private String signedBy;
    private String signedRole;
    private LocalDate dateAdded;
    private List<SscsInterlocDirectionDocuments> historicSscsInterlocDirectionDocs;
    private String dwpState;
    private NotePad appealNotePad;
    private DynamicList dwpStateFeNoAction;
    private String createdInGapsFrom;
    private String dateCaseSentToGaps;
    private List<CaseLink> associatedCase;
    private DwpResponseDocument dwpAT38Document;
    private DwpResponseDocument dwpEvidenceBundleDocument;
    private DwpResponseDocument dwpResponseDocument;
    private DwpResponseDocument dwpSupplementaryResponseDoc;
    private DwpResponseDocument dwpOtherDoc;
    private DwpLT203 dwpLT203;
    private DwpLapseLetter dwpLapseLetter;
    private String dwpResponseDate;
    private String linkedCasesBoolean;
    private String decisionType;
    private DynamicList selectWhoReviewsCase;
    @Deprecated
    private DirectionType directionType;
    private DynamicList directionTypeDl;
    @Deprecated
    private ExtensionNextEvent extensionNextEvent;
    private DynamicList extensionNextEventDl;
    private DwpResponseDocument tl1Form;
    private String isInterlocRequired;
    private Panel panel;
    @JsonProperty("evidenceReceivedCF")
    private EvidenceReceived evidenceReceived;
    private String urgentCase;
    private String urgentHearingRegistered;
    private String urgentHearingOutcome;
    private String documentSentToDwp;
    private String directionDueDate;
    private String reservedToJudge;
    private List<CaseLink> linkedCase;
    private String isWaiverNeeded;
    private List<String> waiverDeclaration;
    private List<String> waiverReason;
    private String waiverReasonOther;
    private List<String> clerkDelegatedAuthority;
    private List<String> clerkAppealSatisfactionText;
    private List<String> pipWriteFinalDecisionDailyLivingActivitiesQuestion;
    private List<String> pipWriteFinalDecisionMobilityActivitiesQuestion;
    @JsonProperty("clerkConfirmationOfMRN")
    private String clerkConfirmationOfMrn;
    private String clerkOtherReason;
    private String clerkConfirmationOther;
    private String responseRequired;
    private String timeExtensionRequested;
    private String bundleConfiguration;
    private String pcqId;
    //Final decision notice fields
    private String writeFinalDecisionIsDescriptorFlow;
    private String writeFinalDecisionGenerateNotice;
    private String writeFinalDecisionAllowedOrRefused;
    private String writeFinalDecisionTypeOfHearing;
    private String writeFinalDecisionPresentingOfficerAttendedQuestion;
    private String writeFinalDecisionAppellantAttendedQuestion;
    private String pipWriteFinalDecisionDailyLivingQuestion;
    @JsonProperty("pipWriteFinalDecisionComparedToDWPDailyLivingQuestion")
    private String pipWriteFinalDecisionComparedToDwpDailyLivingQuestion;
    private String pipWriteFinalDecisionMobilityQuestion;
    @JsonProperty("pipWriteFinalDecisionComparedToDWPMobilityQuestion")
    private String pipWriteFinalDecisionComparedToDwpMobilityQuestion;
    private String writeFinalDecisionStartDate;
    private String writeFinalDecisionEndDateType;
    private String writeFinalDecisionEndDate;
    private String writeFinalDecisionDisabilityQualifiedPanelMemberName;
    private String writeFinalDecisionMedicallyQualifiedPanelMemberName;
    private String writeFinalDecisionOtherPanelMemberName;
    @LocalDateMustNotBeInFuture(message = "Decision notice date of decision must not be in the future")
    private String writeFinalDecisionDateOfDecision;
    private String writeFinalDecisionDetailsOfDecision;
    private List<CollectionItem<String>> writeFinalDecisionReasons;
    private String pipWriteFinalDecisionPreparingFoodQuestion;
    private String pipWriteFinalDecisionTakingNutritionQuestion;
    private String pipWriteFinalDecisionManagingTherapyQuestion;
    private String pipWriteFinalDecisionWashAndBatheQuestion;
    private String pipWriteFinalDecisionManagingToiletNeedsQuestion;
    private String pipWriteFinalDecisionDressingAndUndressingQuestion;
    private String pipWriteFinalDecisionCommunicatingQuestion;
    private String pipWriteFinalDecisionReadingUnderstandingQuestion;
    private String pipWriteFinalDecisionEngagingWithOthersQuestion;
    private String pipWriteFinalDecisionBudgetingDecisionsQuestion;
    private String pipWriteFinalDecisionPlanningAndFollowingQuestion;
    private String pipWriteFinalDecisionMovingAroundQuestion;
    private String writeFinalDecisionPageSectionReference;
    private String writeFinalDecisionAnythingElse;
    @DocumentLinkMustBePdf(message = "You need to upload PDF documents only")
    private DocumentLink writeFinalDecisionPreviewDocument;
    private String writeFinalDecisionGeneratedDate;
    private String adjournCaseGenerateNotice;
    private String adjournCaseTypeOfHearing;
    private String adjournCaseCanCaseBeListedRightAway;
    private String adjournCaseAreDirectionsBeingMadeToParties;
    private String adjournCaseDirectionsDueDateDaysOffset;
    @LocalDateMustBeInFuture(message = "Directions due date must be in the future")
    private String adjournCaseDirectionsDueDate;
    private String adjournCaseTypeOfNextHearing;
    private String adjournCaseNextHearingVenue;
    private DynamicList adjournCaseNextHearingVenueSelected;
    private String adjournCasePanelMembersExcluded;
    private String adjournCaseDisabilityQualifiedPanelMemberName;
    private String adjournCaseMedicallyQualifiedPanelMemberName;
    private String adjournCaseOtherPanelMemberName;
    private String adjournCaseNextHearingListingDurationType;
    private String adjournCaseNextHearingListingDuration;
    private String adjournCaseNextHearingListingDurationUnits;
    private String adjournCaseInterpreterRequired;
    private String adjournCaseInterpreterLanguage;
    private String adjournCaseNextHearingDateType;
    private String adjournCaseNextHearingDateOrPeriod;
    private String adjournCaseNextHearingDateOrTime;
    private String adjournCaseNextHearingFirstAvailableDateAfterDate;
    private String adjournCaseNextHearingFirstAvailableDateAfterPeriod;
    private AdjournCaseTime adjournCaseTime;
    private List<CollectionItem<String>> adjournCaseReasons;
    private List<CollectionItem<String>> adjournCaseAdditionalDirections;
    @DocumentLinkMustBePdf(message = "You need to upload PDF documents only")
    private DocumentLink adjournCasePreviewDocument;
    private String adjournCaseGeneratedDate;
    private String notListableProvideReasons;
    @LocalDateMustBeInFuture(message = "Directions due date must be in the future")
    private String notListableDueDate;
    private String updateNotListableDirectionsFulfilled;
    private String updateNotListableInterlocReview;
    private String updateNotListableWhoReviewsCase;
    private String updateNotListableSetNewDueDate;
    @LocalDateMustBeInFuture(message = "Directions due date must be in the future")
    private String updateNotListableDueDate;
    private String updateNotListableWhereShouldCaseMoveTo;
    private String languagePreferenceWelsh;
    private List<String> elementsDisputedList;
    private List<ElementDisputed> elementsDisputedGeneral;
    private List<ElementDisputed> elementsDisputedSanctions;
    private List<ElementDisputed> elementsDisputedOverpayment;
    private List<ElementDisputed> elementsDisputedHousing;
    private List<ElementDisputed> elementsDisputedChildCare;
    private List<ElementDisputed> elementsDisputedCare;
    private List<ElementDisputed> elementsDisputedChildElement;
    private List<ElementDisputed> elementsDisputedChildDisabled;
    private String elementsDisputedIsDecisionDisputedByOthers;
    private String elementsDisputedLinkedAppealRef;
    private String jointParty;
    private JointPartyName jointPartyName;
    @Valid
    @ConvertGroup(to = UniversalCreditValidationGroup.class)
    private Identity jointPartyIdentity;
    private String jointPartyAddressSameAsAppellant;
    @Valid
    @ConvertGroup(to = UniversalCreditValidationGroup.class)
    private Address jointPartyAddress;
    private String translationWorkOutstanding;
    private List<SscsWelshDocument> sscsWelshDocuments;
    private List<SscsWelshDocument> sscsWelshPreviewDocuments;
    private String sscsWelshPreviewNextEvent;
    private DynamicList originalDocuments;
    private DynamicList originalNoticeDocuments;
    private DynamicList documentTypes;
    private String welshBodyContent;
    private String englishBodyContent;
    private String isScottishCase;
    private LocalDate reinstatementRegistered;
    private RequestOutcome reinstatementOutcome;
    private String welshInterlocNextReviewState;
    private DatedRequestOutcome confidentialityRequestOutcomeAppellant;
    private DatedRequestOutcome confidentialityRequestOutcomeJointParty;
    private String confidentialityRequestAppellantGrantedOrRefused;
    private String confidentialityRequestJointPartyGrantedOrRefused;
    private FormType formType;
    private String isProgressingViaGaps;
    private String wcaAppeal;
    private String supportGroupOnlyAppeal;
    private List<String> esaWriteFinalDecisionPhysicalDisabilitiesQuestion;
    private List<String> esaWriteFinalDecisionMentalAssessmentQuestion;
    private String esaWriteFinalDecisionMobilisingUnaidedQuestion;
    private String esaWriteFinalDecisionStandingAndSittingQuestion;
    private String esaWriteFinalDecisionReachingQuestion;
    private String esaWriteFinalDecisionPickingUpQuestion;
    private String esaWriteFinalDecisionManualDexterityQuestion;
    private String esaWriteFinalDecisionMakingSelfUnderstoodQuestion;
    private String esaWriteFinalDecisionCommunicationQuestion;
    private String esaWriteFinalDecisionNavigationQuestion;
    private String esaWriteFinalDecisionLossOfControlQuestion;
    private String esaWriteFinalDecisionConsciousnessQuestion;
    private String esaWriteFinalDecisionLearningTasksQuestion;
    private String esaWriteFinalDecisionAwarenessOfHazardsQuestion;
    private String esaWriteFinalDecisionPersonalActionQuestion;
    private String esaWriteFinalDecisionCopingWithChangeQuestion;
    private String esaWriteFinalDecisionGettingAboutQuestion;
    private String esaWriteFinalDecisionSocialEngagementQuestion;
    private String esaWriteFinalDecisionAppropriatenessOfBehaviourQuestion;
    private YesNo doesRegulation29Apply;
    private YesNo showRegulation29Page;
    private YesNo showSchedule3ActivitiesPage;
    private String esaWriteFinalDecisionSchedule3ActivitiesApply;
    private List<String> esaWriteFinalDecisionSchedule3ActivitiesQuestion;
    private YesNo doesRegulation35Apply;
    private YesNo showFinalDecisionNoticeSummaryOfOutcomePage;
    private String test1;
    private String test2;

    public static SscsCaseData.SscsCaseDataBuilder builder() {
        return new SscsCaseData.SscsCaseDataBuilder();
    }

    @JsonIgnore
    private EventDetails getLatestEvent() {
        return events != null && !events.isEmpty() ? events.get(0).getValue() : null;
    }

    @JsonIgnore
    public boolean isCorDecision() {
        return isCorDecision != null && isCorDecision.toUpperCase().equals("YES");
    }

    @JsonIgnore
    public boolean isDailyLivingAndOrMobilityDecision() {
        return stringToBoolean(writeFinalDecisionIsDescriptorFlow);
    }

    @JsonIgnore
    public boolean isResendToAppellant() {
        return stringToBoolean(resendToAppellant);
    }

    @JsonIgnore
    public boolean isResendToRepresentative() {
        return stringToBoolean(resendToRepresentative);
    }

    @JsonIgnore
    public boolean isResendToDwp() {
        return stringToBoolean(resendToDwp);
    }

    @JsonIgnore
    public boolean isAdjournCaseGenerateNotice() {
        return stringToBoolean(adjournCaseGenerateNotice);
    }

    @JsonIgnore
    public boolean isAdjournCaseAbleToBeListedRightAway() {
        return stringToBoolean(adjournCaseCanCaseBeListedRightAway);
    }

    @JsonIgnore
    public boolean isAdjournCaseDirectionsMadeToParties() {
        return stringToBoolean(adjournCaseAreDirectionsBeingMadeToParties);
    }

    @JsonIgnore
    public boolean isGenerateNotice() {
        return stringToBoolean(generateNotice);
    }

    @JsonIgnore
    public boolean isWcaAppeal() {
        return stringToBoolean(wcaAppeal);
    }

    @JsonIgnore
    public boolean isSupportGroupOnlyAppeal() {
        return stringToBoolean(supportGroupOnlyAppeal);
    }

    @JsonIgnore
    public boolean isThereAJointParty() {
        return stringToBoolean(jointParty);
    }

    @JsonIgnore
    public boolean isJointPartyAddressSameAsAppeallant() {
        return stringToBoolean(jointPartyAddressSameAsAppellant);
    }

    @JsonIgnore
    public String getLatestEventType() {
        EventDetails latestEvent = getLatestEvent();
        return latestEvent != null ? latestEvent.getType() : null;
    }

    @JsonIgnore
    public boolean isLanguagePreferenceWelshAsBoolean() {
        return stringToBoolean(languagePreferenceWelsh);
    }

    @JsonIgnore
    public LanguagePreference getLanguagePreference() {
        return isLanguagePreferenceWelshAsBoolean() ? LanguagePreference.WELSH : LanguagePreference.ENGLISH;
    }

    @JsonIgnore
    public boolean isTranslationWorkOutstandingAsBoolean() {
        return stringToBoolean(translationWorkOutstanding);
    }

    @JsonIgnore
    public void sortCollections() {

        if (getCorrespondence() != null) {
            Collections.sort(getCorrespondence(), Collections.reverseOrder());
        }
        if (getEvents() != null) {
            getEvents().sort(Collections.reverseOrder());
        }

        if (getHearings() != null) {
            getHearings().sort(Collections.reverseOrder());
        }

        if (getEvidence() != null && getEvidence().getDocuments() != null) {
            getEvidence().getDocuments().sort(Collections.reverseOrder());
        }

        if (getSscsDocument() != null) {
            Collections.sort(getSscsDocument());
        }
    }

    public Subscriptions getSubscriptions() {
        return null != subscriptions ? subscriptions : Subscriptions.builder().build();
    }

    @JsonIgnore
    private boolean stringToBoolean(String value) {
        return StringUtils.equalsIgnoreCase("yes", value);
    }

    @JsonIgnore
    public SscsDocument getLatestDocumentForDocumentType(DocumentType documentType) {

        if (getSscsDocument() != null && getSscsDocument().size() > 0) {
            Stream<SscsDocument> filteredStream = getSscsDocument().stream()
                .filter(f -> documentType.getValue().equals(f.getValue().getDocumentType()));

            List<SscsDocument> filteredList = filteredStream.collect(Collectors.toList());

            Collections.sort(filteredList, (one, two) -> {
                if (two.getValue().getDocumentDateAdded() == null) {
                    return -1;
                }
                if (one.getValue().getDocumentDateAdded() == null) {
                    return 0;
                }
                if (one.getValue().getDocumentDateAdded().equals(two.getValue().getDocumentDateAdded())) {
                    return -1;
                }
                return -1 * one.getValue().getDocumentDateAdded().compareTo(two.getValue().getDocumentDateAdded());
            });
            if (filteredList.size() > 0) {
                return filteredList.get(0);
            }
        }
        return null;
    }

    @JsonIgnore
    public Optional<SscsWelshDocument> getLatestWelshDocumentForDocumentType(DocumentType documentType) {
        return Optional.ofNullable(getSscsWelshDocuments()).map(Collection::stream).orElseGet(Stream::empty)
            .filter(wd -> wd.getValue().getDocumentType().equals(documentType.getValue()))
            .sorted()
            .findFirst();
    }

    @JsonIgnore
    public void updateTranslationWorkOutstandingFlag() {
        if (getSscsDocument().stream().noneMatch(
            sd -> Arrays.asList(SscsDocumentTranslationStatus.TRANSLATION_REQUESTED, SscsDocumentTranslationStatus.TRANSLATION_REQUIRED).contains(sd.getValue().getDocumentTranslationStatus()))) {
            this.translationWorkOutstanding = "No";
        } else {
            this.translationWorkOutstanding = "Yes";
        }
    }

    @JsonIgnore
    public YesNo getRegulation35Selection() {
        if ("No".equalsIgnoreCase(getEsaWriteFinalDecisionSchedule3ActivitiesApply())) {
            return doesRegulation35Apply;
        } else {
            return null;
        }
    }

    @JsonIgnore
    public List<String> getSchedule3Selections() {
        if ("Yes".equalsIgnoreCase(getEsaWriteFinalDecisionSchedule3ActivitiesApply())) {
            return esaWriteFinalDecisionSchedule3ActivitiesQuestion;
        } else if ("No".equalsIgnoreCase(getEsaWriteFinalDecisionSchedule3ActivitiesApply())) {
            return new ArrayList<>();
        } else {
            return null;
        }
    }

    public SscsCaseData.SscsCaseDataBuilder toBuilder() {
        return (new SscsCaseData.SscsCaseDataBuilder()).ccdCaseId(this.ccdCaseId).state(this.state).previousState(this.previousState).caseReference(this.caseReference).caseCreated(this.caseCreated)
        .infoRequests(this.infoRequests).region(this.region).appeal(this.appeal).hearings(this.hearings).evidence(this.evidence).dwpTimeExtension(this.dwpTimeExtension).events(this.events)
        .subscriptions(this.subscriptions).regionalProcessingCenter(this.regionalProcessingCenter).caseBundles(this.caseBundles).sscsDocument(this.sscsDocument)
        .draftSscsDocument(this.draftSscsDocument).draftSscsFurtherEvidenceDocument(this.draftSscsFurtherEvidenceDocument).corDocument(this.corDocument).draftCorDocument(this.draftCorDocument)
        .sscsInterlocDecisionDocument(this.sscsInterlocDecisionDocument).sscsInterlocDirectionDocument(this.sscsInterlocDirectionDocument).sscsStrikeOutDocument(this.sscsStrikeOutDocument)
        .generatedNino(this.generatedNino).generatedSurname(this.generatedSurname).generatedEmail(this.generatedEmail).generatedMobile(this.generatedMobile).generatedDob(this.generatedDob)
        .directionResponse(this.directionResponse).evidencePresent(this.evidencePresent).bulkScanCaseReference(this.bulkScanCaseReference).decisionNotes(this.decisionNotes)
        .isCorDecision(this.isCorDecision).relistingReason(this.relistingReason).dateSentToDwp(this.dateSentToDwp).interlocReviewState(this.interlocReviewState).hmctsDwpState(this.hmctsDwpState)
        .dwpFurtherEvidenceStates(this.dwpFurtherEvidenceStates).originalSender(this.originalSender).furtherEvidenceAction(this.furtherEvidenceAction).scannedDocuments(this.scannedDocuments)
        .informationFromAppellant(this.informationFromAppellant).outcome(this.outcome).evidenceHandled(this.evidenceHandled).assignedToJudge(this.assignedToJudge)
        .assignedToDisabilityMember(this.assignedToDisabilityMember).assignedToMedicalMember(this.assignedToMedicalMember).reissueFurtherEvidenceDocument(this.reissueFurtherEvidenceDocument)
        .resendToAppellant(this.resendToAppellant).resendToRepresentative(this.resendToRepresentative).resendToDwp(this.resendToDwp).caseCode(this.caseCode).benefitCode(this.benefitCode)
        .issueCode(this.issueCode).dwpOriginatingOffice(this.dwpOriginatingOffice).dwpPresentingOffice(this.dwpPresentingOffice).dwpIsOfficerAttending(this.dwpIsOfficerAttending)
        .dwpUcb(this.dwpUcb).dwpPhme(this.dwpPhme).dwpComplexAppeal(this.dwpComplexAppeal).dwpFurtherInfo(this.dwpFurtherInfo).correspondence(this.correspondence)
        .interlocReferralDate(this.interlocReferralDate).interlocReferralReason(this.interlocReferralReason).dwpRegionalCentre(this.dwpRegionalCentre).generateNotice(this.generateNotice)
        .previewDocument(this.previewDocument).bodyContent(this.bodyContent).signedBy(this.signedBy).signedRole(this.signedRole).dateAdded(this.dateAdded)
        .historicSscsInterlocDirectionDocs(this.historicSscsInterlocDirectionDocs).dwpState(this.dwpState).appealNotePad(this.appealNotePad).dwpStateFeNoAction(this.dwpStateFeNoAction)
        .createdInGapsFrom(this.createdInGapsFrom).dateCaseSentToGaps(this.dateCaseSentToGaps).associatedCase(this.associatedCase).dwpAT38Document(this.dwpAT38Document)
        .dwpEvidenceBundleDocument(this.dwpEvidenceBundleDocument).dwpResponseDocument(this.dwpResponseDocument).dwpSupplementaryResponseDoc(this.dwpSupplementaryResponseDoc)
        .dwpOtherDoc(this.dwpOtherDoc).dwpLT203(this.dwpLT203).dwpLapseLetter(this.dwpLapseLetter).dwpResponseDate(this.dwpResponseDate).linkedCasesBoolean(this.linkedCasesBoolean)
        .decisionType(this.decisionType).selectWhoReviewsCase(this.selectWhoReviewsCase).directionType(this.directionType).directionTypeDl(this.directionTypeDl)
        .extensionNextEvent(this.extensionNextEvent).extensionNextEventDl(this.extensionNextEventDl).tl1Form(this.tl1Form).isInterlocRequired(this.isInterlocRequired).panel(this.panel)
        .evidenceReceived(this.evidenceReceived).urgentCase(this.urgentCase).urgentHearingRegistered(this.urgentHearingRegistered).urgentHearingOutcome(this.urgentHearingOutcome)
        .documentSentToDwp(this.documentSentToDwp).directionDueDate(this.directionDueDate).reservedToJudge(this.reservedToJudge).linkedCase(this.linkedCase).isWaiverNeeded(this.isWaiverNeeded)
        .waiverDeclaration(this.waiverDeclaration).waiverReason(this.waiverReason).waiverReasonOther(this.waiverReasonOther).clerkDelegatedAuthority(this.clerkDelegatedAuthority)
        .clerkAppealSatisfactionText(this.clerkAppealSatisfactionText).pipWriteFinalDecisionDailyLivingActivitiesQuestion(this.pipWriteFinalDecisionDailyLivingActivitiesQuestion)
        .pipWriteFinalDecisionMobilityActivitiesQuestion(this.pipWriteFinalDecisionMobilityActivitiesQuestion).clerkConfirmationOfMrn(this.clerkConfirmationOfMrn)
        .clerkOtherReason(this.clerkOtherReason).clerkConfirmationOther(this.clerkConfirmationOther).responseRequired(this.responseRequired).timeExtensionRequested(this.timeExtensionRequested)
        .bundleConfiguration(this.bundleConfiguration).pcqId(this.pcqId).writeFinalDecisionIsDescriptorFlow(this.writeFinalDecisionIsDescriptorFlow)
        .writeFinalDecisionGenerateNotice(this.writeFinalDecisionGenerateNotice).writeFinalDecisionAllowedOrRefused(this.writeFinalDecisionAllowedOrRefused)
        .writeFinalDecisionTypeOfHearing(this.writeFinalDecisionTypeOfHearing).writeFinalDecisionPresentingOfficerAttendedQuestion(this.writeFinalDecisionPresentingOfficerAttendedQuestion)
        .writeFinalDecisionAppellantAttendedQuestion(this.writeFinalDecisionAppellantAttendedQuestion).pipWriteFinalDecisionDailyLivingQuestion(this.pipWriteFinalDecisionDailyLivingQuestion)
        .pipWriteFinalDecisionComparedToDwpDailyLivingQuestion(this.pipWriteFinalDecisionComparedToDwpDailyLivingQuestion)
        .pipWriteFinalDecisionMobilityQuestion(this.pipWriteFinalDecisionMobilityQuestion)
        .pipWriteFinalDecisionComparedToDwpMobilityQuestion(this.pipWriteFinalDecisionComparedToDwpMobilityQuestion).writeFinalDecisionStartDate(this.writeFinalDecisionStartDate)
        .writeFinalDecisionEndDateType(this.writeFinalDecisionEndDateType).writeFinalDecisionEndDate(this.writeFinalDecisionEndDate)
        .writeFinalDecisionDisabilityQualifiedPanelMemberName(this.writeFinalDecisionDisabilityQualifiedPanelMemberName)
        .writeFinalDecisionMedicallyQualifiedPanelMemberName(this.writeFinalDecisionMedicallyQualifiedPanelMemberName)
        .writeFinalDecisionOtherPanelMemberName(this.writeFinalDecisionOtherPanelMemberName).writeFinalDecisionDateOfDecision(this.writeFinalDecisionDateOfDecision)
        .writeFinalDecisionDetailsOfDecision(this.writeFinalDecisionDetailsOfDecision).writeFinalDecisionReasons(this.writeFinalDecisionReasons)
        .pipWriteFinalDecisionPreparingFoodQuestion(this.pipWriteFinalDecisionPreparingFoodQuestion).pipWriteFinalDecisionTakingNutritionQuestion(this.pipWriteFinalDecisionTakingNutritionQuestion)
        .pipWriteFinalDecisionManagingTherapyQuestion(this.pipWriteFinalDecisionManagingTherapyQuestion).pipWriteFinalDecisionWashAndBatheQuestion(this.pipWriteFinalDecisionWashAndBatheQuestion)
        .pipWriteFinalDecisionManagingToiletNeedsQuestion(this.pipWriteFinalDecisionManagingToiletNeedsQuestion)
        .pipWriteFinalDecisionDressingAndUndressingQuestion(this.pipWriteFinalDecisionDressingAndUndressingQuestion)
        .pipWriteFinalDecisionCommunicatingQuestion(this.pipWriteFinalDecisionCommunicatingQuestion)
        .pipWriteFinalDecisionReadingUnderstandingQuestion(this.pipWriteFinalDecisionReadingUnderstandingQuestion)
        .pipWriteFinalDecisionEngagingWithOthersQuestion(this.pipWriteFinalDecisionEngagingWithOthersQuestion)
        .pipWriteFinalDecisionBudgetingDecisionsQuestion(this.pipWriteFinalDecisionBudgetingDecisionsQuestion)
        .pipWriteFinalDecisionPlanningAndFollowingQuestion(this.pipWriteFinalDecisionPlanningAndFollowingQuestion)
        .pipWriteFinalDecisionMovingAroundQuestion(this.pipWriteFinalDecisionMovingAroundQuestion).writeFinalDecisionPageSectionReference(this.writeFinalDecisionPageSectionReference)
        .writeFinalDecisionAnythingElse(this.writeFinalDecisionAnythingElse).writeFinalDecisionPreviewDocument(this.writeFinalDecisionPreviewDocument)
        .writeFinalDecisionGeneratedDate(this.writeFinalDecisionGeneratedDate).adjournCaseGenerateNotice(this.adjournCaseGenerateNotice).adjournCaseTypeOfHearing(this.adjournCaseTypeOfHearing)
        .adjournCaseCanCaseBeListedRightAway(this.adjournCaseCanCaseBeListedRightAway).adjournCaseAreDirectionsBeingMadeToParties(this.adjournCaseAreDirectionsBeingMadeToParties)
        .adjournCaseDirectionsDueDateDaysOffset(this.adjournCaseDirectionsDueDateDaysOffset).adjournCaseDirectionsDueDate(this.adjournCaseDirectionsDueDate)
        .adjournCaseTypeOfNextHearing(this.adjournCaseTypeOfNextHearing).adjournCaseNextHearingVenue(this.adjournCaseNextHearingVenue)
        .adjournCaseNextHearingVenueSelected(this.adjournCaseNextHearingVenueSelected).adjournCasePanelMembersExcluded(this.adjournCasePanelMembersExcluded)
        .adjournCaseDisabilityQualifiedPanelMemberName(this.adjournCaseDisabilityQualifiedPanelMemberName)
        .adjournCaseMedicallyQualifiedPanelMemberName(this.adjournCaseMedicallyQualifiedPanelMemberName).adjournCaseOtherPanelMemberName(this.adjournCaseOtherPanelMemberName)
        .adjournCaseNextHearingListingDurationType(this.adjournCaseNextHearingListingDurationType).adjournCaseNextHearingListingDuration(this.adjournCaseNextHearingListingDuration)
        .adjournCaseNextHearingListingDurationUnits(this.adjournCaseNextHearingListingDurationUnits).adjournCaseInterpreterRequired(this.adjournCaseInterpreterRequired)
        .adjournCaseInterpreterLanguage(this.adjournCaseInterpreterLanguage).adjournCaseNextHearingDateType(this.adjournCaseNextHearingDateType)
        .adjournCaseNextHearingDateOrPeriod(this.adjournCaseNextHearingDateOrPeriod).adjournCaseNextHearingDateOrTime(this.adjournCaseNextHearingDateOrTime)
        .adjournCaseNextHearingFirstAvailableDateAfterDate(this.adjournCaseNextHearingFirstAvailableDateAfterDate)
        .adjournCaseNextHearingFirstAvailableDateAfterPeriod(this.adjournCaseNextHearingFirstAvailableDateAfterPeriod).adjournCaseTime(this.adjournCaseTime)
        .adjournCaseReasons(this.adjournCaseReasons).adjournCaseAdditionalDirections(this.adjournCaseAdditionalDirections).adjournCasePreviewDocument(this.adjournCasePreviewDocument)
        .adjournCaseGeneratedDate(this.adjournCaseGeneratedDate).notListableProvideReasons(this.notListableProvideReasons).notListableDueDate(this.notListableDueDate)
        .updateNotListableDirectionsFulfilled(this.updateNotListableDirectionsFulfilled).updateNotListableInterlocReview(this.updateNotListableInterlocReview)
        .updateNotListableWhoReviewsCase(this.updateNotListableWhoReviewsCase).updateNotListableSetNewDueDate(this.updateNotListableSetNewDueDate)
        .updateNotListableDueDate(this.updateNotListableDueDate).updateNotListableWhereShouldCaseMoveTo(this.updateNotListableWhereShouldCaseMoveTo)
        .languagePreferenceWelsh(this.languagePreferenceWelsh).elementsDisputedList(this.elementsDisputedList).elementsDisputedGeneral(this.elementsDisputedGeneral)
        .elementsDisputedSanctions(this.elementsDisputedSanctions).elementsDisputedOverpayment(this.elementsDisputedOverpayment).elementsDisputedHousing(this.elementsDisputedHousing)
        .elementsDisputedChildCare(this.elementsDisputedChildCare).elementsDisputedCare(this.elementsDisputedCare).elementsDisputedChildElement(this.elementsDisputedChildElement)
        .elementsDisputedChildDisabled(this.elementsDisputedChildDisabled).elementsDisputedIsDecisionDisputedByOthers(this.elementsDisputedIsDecisionDisputedByOthers)
        .elementsDisputedLinkedAppealRef(this.elementsDisputedLinkedAppealRef).jointParty(this.jointParty).jointPartyName(this.jointPartyName).jointPartyIdentity(this.jointPartyIdentity)
        .jointPartyAddressSameAsAppellant(this.jointPartyAddressSameAsAppellant).jointPartyAddress(this.jointPartyAddress).translationWorkOutstanding(this.translationWorkOutstanding)
        .sscsWelshDocuments(this.sscsWelshDocuments).sscsWelshPreviewDocuments(this.sscsWelshPreviewDocuments).sscsWelshPreviewNextEvent(this.sscsWelshPreviewNextEvent)
        .originalDocuments(this.originalDocuments).originalNoticeDocuments(this.originalNoticeDocuments).documentTypes(this.documentTypes).welshBodyContent(this.welshBodyContent)
        .englishBodyContent(this.englishBodyContent).isScottishCase(this.isScottishCase).reinstatementRegistered(this.reinstatementRegistered).reinstatementOutcome(this.reinstatementOutcome)
        .welshInterlocNextReviewState(this.welshInterlocNextReviewState).confidentialityRequestOutcomeAppellant(this.confidentialityRequestOutcomeAppellant)
        .confidentialityRequestOutcomeJointParty(this.confidentialityRequestOutcomeJointParty).confidentialityRequestAppellantGrantedOrRefused(this.confidentialityRequestAppellantGrantedOrRefused)
        .confidentialityRequestJointPartyGrantedOrRefused(this.confidentialityRequestJointPartyGrantedOrRefused).formType(this.formType).isProgressingViaGaps(this.isProgressingViaGaps)
        .wcaAppeal(this.wcaAppeal).supportGroupOnlyAppeal(this.supportGroupOnlyAppeal).esaWriteFinalDecisionPhysicalDisabilitiesQuestion(this.esaWriteFinalDecisionPhysicalDisabilitiesQuestion)
        .esaWriteFinalDecisionMentalAssessmentQuestion(this.esaWriteFinalDecisionMentalAssessmentQuestion)
        .esaWriteFinalDecisionMobilisingUnaidedQuestion(this.esaWriteFinalDecisionMobilisingUnaidedQuestion)
        .esaWriteFinalDecisionStandingAndSittingQuestion(this.esaWriteFinalDecisionStandingAndSittingQuestion).esaWriteFinalDecisionReachingQuestion(this.esaWriteFinalDecisionReachingQuestion)
        .esaWriteFinalDecisionPickingUpQuestion(this.esaWriteFinalDecisionPickingUpQuestion).esaWriteFinalDecisionManualDexterityQuestion(this.esaWriteFinalDecisionManualDexterityQuestion)
        .esaWriteFinalDecisionMakingSelfUnderstoodQuestion(this.esaWriteFinalDecisionMakingSelfUnderstoodQuestion)
        .esaWriteFinalDecisionCommunicationQuestion(this.esaWriteFinalDecisionCommunicationQuestion).esaWriteFinalDecisionNavigationQuestion(this.esaWriteFinalDecisionNavigationQuestion)
        .esaWriteFinalDecisionLossOfControlQuestion(this.esaWriteFinalDecisionLossOfControlQuestion).esaWriteFinalDecisionConsciousnessQuestion(this.esaWriteFinalDecisionConsciousnessQuestion)
        .esaWriteFinalDecisionLearningTasksQuestion(this.esaWriteFinalDecisionLearningTasksQuestion)
        .esaWriteFinalDecisionAwarenessOfHazardsQuestion(this.esaWriteFinalDecisionAwarenessOfHazardsQuestion)
        .esaWriteFinalDecisionPersonalActionQuestion(this.esaWriteFinalDecisionPersonalActionQuestion)
        .esaWriteFinalDecisionCopingWithChangeQuestion(this.esaWriteFinalDecisionCopingWithChangeQuestion).esaWriteFinalDecisionGettingAboutQuestion(this.esaWriteFinalDecisionGettingAboutQuestion)
        .esaWriteFinalDecisionSocialEngagementQuestion(this.esaWriteFinalDecisionSocialEngagementQuestion)
        .esaWriteFinalDecisionAppropriatenessOfBehaviourQuestion(this.esaWriteFinalDecisionAppropriatenessOfBehaviourQuestion).doesRegulation29Apply(this.doesRegulation29Apply)
        .showRegulation29Page(this.showRegulation29Page).showSchedule3ActivitiesPage(this.showSchedule3ActivitiesPage)
        .esaWriteFinalDecisionSchedule3ActivitiesApply(this.esaWriteFinalDecisionSchedule3ActivitiesApply)
        .esaWriteFinalDecisionSchedule3ActivitiesQuestion(this.esaWriteFinalDecisionSchedule3ActivitiesQuestion).doesRegulation35Apply(this.doesRegulation35Apply)
        .showFinalDecisionNoticeSummaryOfOutcomePage(this.showFinalDecisionNoticeSummaryOfOutcomePage).test1(this.test1).test2(this.test2);
    }


    public static class SscsCaseDataBuilder {

        private String ccdCaseId;
        private State state;
        private State previousState;
        private String caseReference;
        private String caseCreated;
        private InfoRequests infoRequests;
        private String region;
        private Appeal appeal;
        private List<Hearing> hearings;
        private Evidence evidence;
        private List<DwpTimeExtension> dwpTimeExtension;
        private List<Event> events;
        private Subscriptions subscriptions;
        private RegionalProcessingCenter regionalProcessingCenter;
        private List<Bundle> caseBundles;
        private List<SscsDocument> sscsDocument;
        private List<SscsDocument> draftSscsDocument;
        private List<SscsFurtherEvidenceDoc> draftSscsFurtherEvidenceDocument;
        private List<CorDocument> corDocument;
        private List<CorDocument> draftCorDocument;
        private SscsInterlocDecisionDocument sscsInterlocDecisionDocument;
        private SscsInterlocDirectionDocument sscsInterlocDirectionDocument;
        private SscsStrikeOutDocument sscsStrikeOutDocument;
        private String generatedNino;
        private String generatedSurname;
        private String generatedEmail;
        private String generatedMobile;
        private String generatedDob;
        private DirectionResponse directionResponse;
        private String evidencePresent;
        private String bulkScanCaseReference;
        private String decisionNotes;
        private String isCorDecision;
        private String relistingReason;
        private String dateSentToDwp;
        private String interlocReviewState;
        private String hmctsDwpState;
        private String dwpFurtherEvidenceStates;
        private DynamicList originalSender;
        private DynamicList furtherEvidenceAction;
        private List<ScannedDocument> scannedDocuments;
        private String informationFromAppellant;
        private String outcome;
        private String evidenceHandled;
        private String assignedToJudge;
        private String assignedToDisabilityMember;
        private String assignedToMedicalMember;
        private DynamicList reissueFurtherEvidenceDocument;
        private String resendToAppellant;
        private String resendToRepresentative;
        private String resendToDwp;
        private String caseCode;
        private String benefitCode;
        private String issueCode;
        private DynamicList dwpOriginatingOffice;
        private DynamicList dwpPresentingOffice;
        private String dwpIsOfficerAttending;
        private String dwpUcb;
        private String dwpPhme;
        private String dwpComplexAppeal;
        private String dwpFurtherInfo;
        private List<Correspondence> correspondence;
        private String interlocReferralDate;
        private String interlocReferralReason;
        private String dwpRegionalCentre;
        private String generateNotice;
        private DocumentLink previewDocument;
        private String bodyContent;
        private String signedBy;
        private String signedRole;
        private LocalDate dateAdded;
        private List<SscsInterlocDirectionDocuments> historicSscsInterlocDirectionDocs;
        private String dwpState;
        private NotePad appealNotePad;
        private DynamicList dwpStateFeNoAction;
        private String createdInGapsFrom;
        private String dateCaseSentToGaps;
        private List<CaseLink> associatedCase;
        private DwpResponseDocument dwpAT38Document;
        private DwpResponseDocument dwpEvidenceBundleDocument;
        private DwpResponseDocument dwpResponseDocument;
        private DwpResponseDocument dwpSupplementaryResponseDoc;
        private DwpResponseDocument dwpOtherDoc;
        private DwpLT203 dwpLT203;
        private DwpLapseLetter dwpLapseLetter;
        private String dwpResponseDate;
        private String linkedCasesBoolean;
        private String decisionType;
        private DynamicList selectWhoReviewsCase;
        private DirectionType directionType;
        private DynamicList directionTypeDl;
        private ExtensionNextEvent extensionNextEvent;
        private DynamicList extensionNextEventDl;
        private DwpResponseDocument tl1Form;
        private String isInterlocRequired;
        private Panel panel;
        private EvidenceReceived evidenceReceived;
        private String urgentCase;
        private String urgentHearingRegistered;
        private String urgentHearingOutcome;
        private String documentSentToDwp;
        private String directionDueDate;
        private String reservedToJudge;
        private List<CaseLink> linkedCase;
        private String isWaiverNeeded;
        private List<String> waiverDeclaration;
        private List<String> waiverReason;
        private String waiverReasonOther;
        private List<String> clerkDelegatedAuthority;
        private List<String> clerkAppealSatisfactionText;
        private List<String> pipWriteFinalDecisionDailyLivingActivitiesQuestion;
        private List<String> pipWriteFinalDecisionMobilityActivitiesQuestion;
        private String clerkConfirmationOfMrn;
        private String clerkOtherReason;
        private String clerkConfirmationOther;
        private String responseRequired;
        private String timeExtensionRequested;
        private String bundleConfiguration;
        private String pcqId;
        private String writeFinalDecisionIsDescriptorFlow;
        private String writeFinalDecisionGenerateNotice;
        private String writeFinalDecisionAllowedOrRefused;
        private String writeFinalDecisionTypeOfHearing;
        private String writeFinalDecisionPresentingOfficerAttendedQuestion;
        private String writeFinalDecisionAppellantAttendedQuestion;
        private String pipWriteFinalDecisionDailyLivingQuestion;
        private String pipWriteFinalDecisionComparedToDwpDailyLivingQuestion;
        private String pipWriteFinalDecisionMobilityQuestion;
        private String pipWriteFinalDecisionComparedToDwpMobilityQuestion;
        private String writeFinalDecisionStartDate;
        private String writeFinalDecisionEndDateType;
        private String writeFinalDecisionEndDate;
        private String writeFinalDecisionDisabilityQualifiedPanelMemberName;
        private String writeFinalDecisionMedicallyQualifiedPanelMemberName;
        private String writeFinalDecisionOtherPanelMemberName;
        private String writeFinalDecisionDateOfDecision;
        private String writeFinalDecisionDetailsOfDecision;
        private List<CollectionItem<String>> writeFinalDecisionReasons;
        private String pipWriteFinalDecisionPreparingFoodQuestion;
        private String pipWriteFinalDecisionTakingNutritionQuestion;
        private String pipWriteFinalDecisionManagingTherapyQuestion;
        private String pipWriteFinalDecisionWashAndBatheQuestion;
        private String pipWriteFinalDecisionManagingToiletNeedsQuestion;
        private String pipWriteFinalDecisionDressingAndUndressingQuestion;
        private String pipWriteFinalDecisionCommunicatingQuestion;
        private String pipWriteFinalDecisionReadingUnderstandingQuestion;
        private String pipWriteFinalDecisionEngagingWithOthersQuestion;
        private String pipWriteFinalDecisionBudgetingDecisionsQuestion;
        private String pipWriteFinalDecisionPlanningAndFollowingQuestion;
        private String pipWriteFinalDecisionMovingAroundQuestion;
        private String writeFinalDecisionPageSectionReference;
        private String writeFinalDecisionAnythingElse;
        private DocumentLink writeFinalDecisionPreviewDocument;
        private String writeFinalDecisionGeneratedDate;
        private String adjournCaseGenerateNotice;
        private String adjournCaseTypeOfHearing;
        private String adjournCaseCanCaseBeListedRightAway;
        private String adjournCaseAreDirectionsBeingMadeToParties;
        private String adjournCaseDirectionsDueDateDaysOffset;
        private String adjournCaseDirectionsDueDate;
        private String adjournCaseTypeOfNextHearing;
        private String adjournCaseNextHearingVenue;
        private DynamicList adjournCaseNextHearingVenueSelected;
        private String adjournCasePanelMembersExcluded;
        private String adjournCaseDisabilityQualifiedPanelMemberName;
        private String adjournCaseMedicallyQualifiedPanelMemberName;
        private String adjournCaseOtherPanelMemberName;
        private String adjournCaseNextHearingListingDurationType;
        private String adjournCaseNextHearingListingDuration;
        private String adjournCaseNextHearingListingDurationUnits;
        private String adjournCaseInterpreterRequired;
        private String adjournCaseInterpreterLanguage;
        private String adjournCaseNextHearingDateType;
        private String adjournCaseNextHearingDateOrPeriod;
        private String adjournCaseNextHearingDateOrTime;
        private String adjournCaseNextHearingFirstAvailableDateAfterDate;
        private String adjournCaseNextHearingFirstAvailableDateAfterPeriod;
        private AdjournCaseTime adjournCaseTime;
        private List<CollectionItem<String>> adjournCaseReasons;
        private List<CollectionItem<String>> adjournCaseAdditionalDirections;
        private DocumentLink adjournCasePreviewDocument;
        private String adjournCaseGeneratedDate;
        private String notListableProvideReasons;
        private String notListableDueDate;
        private String updateNotListableDirectionsFulfilled;
        private String updateNotListableInterlocReview;
        private String updateNotListableWhoReviewsCase;
        private String updateNotListableSetNewDueDate;
        private String updateNotListableDueDate;
        private String updateNotListableWhereShouldCaseMoveTo;
        private String languagePreferenceWelsh;
        private List<String> elementsDisputedList;
        private List<ElementDisputed> elementsDisputedGeneral;
        private List<ElementDisputed> elementsDisputedSanctions;
        private List<ElementDisputed> elementsDisputedOverpayment;
        private List<ElementDisputed> elementsDisputedHousing;
        private List<ElementDisputed> elementsDisputedChildCare;
        private List<ElementDisputed> elementsDisputedCare;
        private List<ElementDisputed> elementsDisputedChildElement;
        private List<ElementDisputed> elementsDisputedChildDisabled;
        private String elementsDisputedIsDecisionDisputedByOthers;
        private String elementsDisputedLinkedAppealRef;
        private String jointParty;
        private JointPartyName jointPartyName;
        private Identity jointPartyIdentity;
        private String jointPartyAddressSameAsAppellant;
        private Address jointPartyAddress;
        private String translationWorkOutstanding;
        private List<SscsWelshDocument> sscsWelshDocuments;
        private List<SscsWelshDocument> sscsWelshPreviewDocuments;
        private String sscsWelshPreviewNextEvent;
        private DynamicList originalDocuments;
        private DynamicList originalNoticeDocuments;
        private DynamicList documentTypes;
        private String welshBodyContent;
        private String englishBodyContent;
        private String isScottishCase;
        private LocalDate reinstatementRegistered;
        private RequestOutcome reinstatementOutcome;
        private String welshInterlocNextReviewState;
        private DatedRequestOutcome confidentialityRequestOutcomeAppellant;
        private DatedRequestOutcome confidentialityRequestOutcomeJointParty;
        private String confidentialityRequestAppellantGrantedOrRefused;
        private String confidentialityRequestJointPartyGrantedOrRefused;
        private FormType formType;
        private String isProgressingViaGaps;
        private String wcaAppeal;
        private String supportGroupOnlyAppeal;
        private List<String> esaWriteFinalDecisionPhysicalDisabilitiesQuestion;
        private List<String> esaWriteFinalDecisionMentalAssessmentQuestion;
        private String esaWriteFinalDecisionMobilisingUnaidedQuestion;
        private String esaWriteFinalDecisionStandingAndSittingQuestion;
        private String esaWriteFinalDecisionReachingQuestion;
        private String esaWriteFinalDecisionPickingUpQuestion;
        private String esaWriteFinalDecisionManualDexterityQuestion;
        private String esaWriteFinalDecisionMakingSelfUnderstoodQuestion;
        private String esaWriteFinalDecisionCommunicationQuestion;
        private String esaWriteFinalDecisionNavigationQuestion;
        private String esaWriteFinalDecisionLossOfControlQuestion;
        private String esaWriteFinalDecisionConsciousnessQuestion;
        private String esaWriteFinalDecisionLearningTasksQuestion;
        private String esaWriteFinalDecisionAwarenessOfHazardsQuestion;
        private String esaWriteFinalDecisionPersonalActionQuestion;
        private String esaWriteFinalDecisionCopingWithChangeQuestion;
        private String esaWriteFinalDecisionGettingAboutQuestion;
        private String esaWriteFinalDecisionSocialEngagementQuestion;
        private String esaWriteFinalDecisionAppropriatenessOfBehaviourQuestion;
        private YesNo doesRegulation29Apply;
        private YesNo showRegulation29Page;
        private YesNo showSchedule3ActivitiesPage;
        private String esaWriteFinalDecisionSchedule3ActivitiesApply;
        private List<String> esaWriteFinalDecisionSchedule3ActivitiesQuestion;
        private YesNo doesRegulation35Apply;
        private YesNo showFinalDecisionNoticeSummaryOfOutcomePage;
        private String test1;
        private String test2;

        SscsCaseDataBuilder() {
        }

        @JsonProperty(
            access = JsonProperty.Access.WRITE_ONLY
        )
        public SscsCaseData.SscsCaseDataBuilder ccdCaseId(String ccdCaseId) {
            this.ccdCaseId = ccdCaseId;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder state(State state) {
            this.state = state;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder previousState(State previousState) {
            this.previousState = previousState;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder caseReference(String caseReference) {
            this.caseReference = caseReference;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder caseCreated(String caseCreated) {
            this.caseCreated = caseCreated;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder infoRequests(InfoRequests infoRequests) {
            this.infoRequests = infoRequests;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder region(String region) {
            this.region = region;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder appeal(Appeal appeal) {
            this.appeal = appeal;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder hearings(List<Hearing> hearings) {
            this.hearings = hearings;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder evidence(Evidence evidence) {
            this.evidence = evidence;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder dwpTimeExtension(List<DwpTimeExtension> dwpTimeExtension) {
            this.dwpTimeExtension = dwpTimeExtension;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder events(List<Event> events) {
            this.events = events;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder subscriptions(Subscriptions subscriptions) {
            this.subscriptions = subscriptions;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder regionalProcessingCenter(RegionalProcessingCenter regionalProcessingCenter) {
            this.regionalProcessingCenter = regionalProcessingCenter;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder caseBundles(List<Bundle> caseBundles) {
            this.caseBundles = caseBundles;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder sscsDocument(List<SscsDocument> sscsDocument) {
            this.sscsDocument = sscsDocument;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder draftSscsDocument(List<SscsDocument> draftSscsDocument) {
            this.draftSscsDocument = draftSscsDocument;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder draftSscsFurtherEvidenceDocument(List<SscsFurtherEvidenceDoc> draftSscsFurtherEvidenceDocument) {
            this.draftSscsFurtherEvidenceDocument = draftSscsFurtherEvidenceDocument;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder corDocument(List<CorDocument> corDocument) {
            this.corDocument = corDocument;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder draftCorDocument(List<CorDocument> draftCorDocument) {
            this.draftCorDocument = draftCorDocument;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder sscsInterlocDecisionDocument(SscsInterlocDecisionDocument sscsInterlocDecisionDocument) {
            this.sscsInterlocDecisionDocument = sscsInterlocDecisionDocument;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder sscsInterlocDirectionDocument(SscsInterlocDirectionDocument sscsInterlocDirectionDocument) {
            this.sscsInterlocDirectionDocument = sscsInterlocDirectionDocument;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder sscsStrikeOutDocument(SscsStrikeOutDocument sscsStrikeOutDocument) {
            this.sscsStrikeOutDocument = sscsStrikeOutDocument;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder generatedNino(String generatedNino) {
            this.generatedNino = generatedNino;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder generatedSurname(String generatedSurname) {
            this.generatedSurname = generatedSurname;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder generatedEmail(String generatedEmail) {
            this.generatedEmail = generatedEmail;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder generatedMobile(String generatedMobile) {
            this.generatedMobile = generatedMobile;
            return this;
        }

        @JsonProperty("generatedDOB")
        public SscsCaseData.SscsCaseDataBuilder generatedDob(String generatedDob) {
            this.generatedDob = generatedDob;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder directionResponse(DirectionResponse directionResponse) {
            this.directionResponse = directionResponse;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder evidencePresent(String evidencePresent) {
            this.evidencePresent = evidencePresent;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder bulkScanCaseReference(String bulkScanCaseReference) {
            this.bulkScanCaseReference = bulkScanCaseReference;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder decisionNotes(String decisionNotes) {
            this.decisionNotes = decisionNotes;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder isCorDecision(String isCorDecision) {
            this.isCorDecision = isCorDecision;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder relistingReason(String relistingReason) {
            this.relistingReason = relistingReason;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder dateSentToDwp(String dateSentToDwp) {
            this.dateSentToDwp = dateSentToDwp;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder interlocReviewState(String interlocReviewState) {
            this.interlocReviewState = interlocReviewState;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder hmctsDwpState(String hmctsDwpState) {
            this.hmctsDwpState = hmctsDwpState;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder dwpFurtherEvidenceStates(String dwpFurtherEvidenceStates) {
            this.dwpFurtherEvidenceStates = dwpFurtherEvidenceStates;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder originalSender(DynamicList originalSender) {
            this.originalSender = originalSender;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder furtherEvidenceAction(DynamicList furtherEvidenceAction) {
            this.furtherEvidenceAction = furtherEvidenceAction;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder scannedDocuments(List<ScannedDocument> scannedDocuments) {
            this.scannedDocuments = scannedDocuments;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder informationFromAppellant(String informationFromAppellant) {
            this.informationFromAppellant = informationFromAppellant;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder outcome(String outcome) {
            this.outcome = outcome;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder evidenceHandled(String evidenceHandled) {
            this.evidenceHandled = evidenceHandled;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder assignedToJudge(String assignedToJudge) {
            this.assignedToJudge = assignedToJudge;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder assignedToDisabilityMember(String assignedToDisabilityMember) {
            this.assignedToDisabilityMember = assignedToDisabilityMember;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder assignedToMedicalMember(String assignedToMedicalMember) {
            this.assignedToMedicalMember = assignedToMedicalMember;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder reissueFurtherEvidenceDocument(DynamicList reissueFurtherEvidenceDocument) {
            this.reissueFurtherEvidenceDocument = reissueFurtherEvidenceDocument;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder resendToAppellant(String resendToAppellant) {
            this.resendToAppellant = resendToAppellant;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder resendToRepresentative(String resendToRepresentative) {
            this.resendToRepresentative = resendToRepresentative;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder resendToDwp(String resendToDwp) {
            this.resendToDwp = resendToDwp;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder caseCode(String caseCode) {
            this.caseCode = caseCode;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder benefitCode(String benefitCode) {
            this.benefitCode = benefitCode;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder issueCode(String issueCode) {
            this.issueCode = issueCode;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder dwpOriginatingOffice(DynamicList dwpOriginatingOffice) {
            this.dwpOriginatingOffice = dwpOriginatingOffice;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder dwpPresentingOffice(DynamicList dwpPresentingOffice) {
            this.dwpPresentingOffice = dwpPresentingOffice;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder dwpIsOfficerAttending(String dwpIsOfficerAttending) {
            this.dwpIsOfficerAttending = dwpIsOfficerAttending;
            return this;
        }

        @JsonProperty("dwpUCB")
        public SscsCaseData.SscsCaseDataBuilder dwpUcb(String dwpUcb) {
            this.dwpUcb = dwpUcb;
            return this;
        }

        @JsonProperty("dwpPHME")
        public SscsCaseData.SscsCaseDataBuilder dwpPhme(String dwpPhme) {
            this.dwpPhme = dwpPhme;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder dwpComplexAppeal(String dwpComplexAppeal) {
            this.dwpComplexAppeal = dwpComplexAppeal;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder dwpFurtherInfo(String dwpFurtherInfo) {
            this.dwpFurtherInfo = dwpFurtherInfo;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder correspondence(List<Correspondence> correspondence) {
            this.correspondence = correspondence;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder interlocReferralDate(String interlocReferralDate) {
            this.interlocReferralDate = interlocReferralDate;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder interlocReferralReason(String interlocReferralReason) {
            this.interlocReferralReason = interlocReferralReason;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder dwpRegionalCentre(String dwpRegionalCentre) {
            this.dwpRegionalCentre = dwpRegionalCentre;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder generateNotice(String generateNotice) {
            this.generateNotice = generateNotice;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder previewDocument(DocumentLink previewDocument) {
            this.previewDocument = previewDocument;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder bodyContent(String bodyContent) {
            this.bodyContent = bodyContent;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder signedBy(String signedBy) {
            this.signedBy = signedBy;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder signedRole(String signedRole) {
            this.signedRole = signedRole;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder dateAdded(LocalDate dateAdded) {
            this.dateAdded = dateAdded;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder historicSscsInterlocDirectionDocs(List<SscsInterlocDirectionDocuments> historicSscsInterlocDirectionDocs) {
            this.historicSscsInterlocDirectionDocs = historicSscsInterlocDirectionDocs;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder dwpState(String dwpState) {
            this.dwpState = dwpState;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder appealNotePad(NotePad appealNotePad) {
            this.appealNotePad = appealNotePad;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder dwpStateFeNoAction(DynamicList dwpStateFeNoAction) {
            this.dwpStateFeNoAction = dwpStateFeNoAction;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder createdInGapsFrom(String createdInGapsFrom) {
            this.createdInGapsFrom = createdInGapsFrom;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder dateCaseSentToGaps(String dateCaseSentToGaps) {
            this.dateCaseSentToGaps = dateCaseSentToGaps;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder associatedCase(List<CaseLink> associatedCase) {
            this.associatedCase = associatedCase;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder dwpAT38Document(DwpResponseDocument dwpAT38Document) {
            this.dwpAT38Document = dwpAT38Document;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder dwpEvidenceBundleDocument(DwpResponseDocument dwpEvidenceBundleDocument) {
            this.dwpEvidenceBundleDocument = dwpEvidenceBundleDocument;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder dwpResponseDocument(DwpResponseDocument dwpResponseDocument) {
            this.dwpResponseDocument = dwpResponseDocument;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder dwpSupplementaryResponseDoc(DwpResponseDocument dwpSupplementaryResponseDoc) {
            this.dwpSupplementaryResponseDoc = dwpSupplementaryResponseDoc;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder dwpOtherDoc(DwpResponseDocument dwpOtherDoc) {
            this.dwpOtherDoc = dwpOtherDoc;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder dwpLT203(DwpLT203 dwpLT203) {
            this.dwpLT203 = dwpLT203;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder dwpLapseLetter(DwpLapseLetter dwpLapseLetter) {
            this.dwpLapseLetter = dwpLapseLetter;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder dwpResponseDate(String dwpResponseDate) {
            this.dwpResponseDate = dwpResponseDate;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder linkedCasesBoolean(String linkedCasesBoolean) {
            this.linkedCasesBoolean = linkedCasesBoolean;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder decisionType(String decisionType) {
            this.decisionType = decisionType;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder selectWhoReviewsCase(DynamicList selectWhoReviewsCase) {
            this.selectWhoReviewsCase = selectWhoReviewsCase;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder directionType(DirectionType directionType) {
            this.directionType = directionType;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder directionTypeDl(DynamicList directionTypeDl) {
            this.directionTypeDl = directionTypeDl;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder extensionNextEvent(ExtensionNextEvent extensionNextEvent) {
            this.extensionNextEvent = extensionNextEvent;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder extensionNextEventDl(DynamicList extensionNextEventDl) {
            this.extensionNextEventDl = extensionNextEventDl;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder tl1Form(DwpResponseDocument tl1Form) {
            this.tl1Form = tl1Form;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder isInterlocRequired(String isInterlocRequired) {
            this.isInterlocRequired = isInterlocRequired;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder panel(Panel panel) {
            this.panel = panel;
            return this;
        }

        @JsonProperty("evidenceReceivedCF")
        public SscsCaseData.SscsCaseDataBuilder evidenceReceived(EvidenceReceived evidenceReceived) {
            this.evidenceReceived = evidenceReceived;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder urgentCase(String urgentCase) {
            this.urgentCase = urgentCase;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder urgentHearingRegistered(String urgentHearingRegistered) {
            this.urgentHearingRegistered = urgentHearingRegistered;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder urgentHearingOutcome(String urgentHearingOutcome) {
            this.urgentHearingOutcome = urgentHearingOutcome;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder documentSentToDwp(String documentSentToDwp) {
            this.documentSentToDwp = documentSentToDwp;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder directionDueDate(String directionDueDate) {
            this.directionDueDate = directionDueDate;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder reservedToJudge(String reservedToJudge) {
            this.reservedToJudge = reservedToJudge;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder linkedCase(List<CaseLink> linkedCase) {
            this.linkedCase = linkedCase;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder isWaiverNeeded(String isWaiverNeeded) {
            this.isWaiverNeeded = isWaiverNeeded;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder waiverDeclaration(List<String> waiverDeclaration) {
            this.waiverDeclaration = waiverDeclaration;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder waiverReason(List<String> waiverReason) {
            this.waiverReason = waiverReason;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder waiverReasonOther(String waiverReasonOther) {
            this.waiverReasonOther = waiverReasonOther;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder clerkDelegatedAuthority(List<String> clerkDelegatedAuthority) {
            this.clerkDelegatedAuthority = clerkDelegatedAuthority;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder clerkAppealSatisfactionText(List<String> clerkAppealSatisfactionText) {
            this.clerkAppealSatisfactionText = clerkAppealSatisfactionText;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder pipWriteFinalDecisionDailyLivingActivitiesQuestion(List<String> pipWriteFinalDecisionDailyLivingActivitiesQuestion) {
            this.pipWriteFinalDecisionDailyLivingActivitiesQuestion = pipWriteFinalDecisionDailyLivingActivitiesQuestion;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder pipWriteFinalDecisionMobilityActivitiesQuestion(List<String> pipWriteFinalDecisionMobilityActivitiesQuestion) {
            this.pipWriteFinalDecisionMobilityActivitiesQuestion = pipWriteFinalDecisionMobilityActivitiesQuestion;
            return this;
        }

        @JsonProperty("clerkConfirmationOfMRN")
        public SscsCaseData.SscsCaseDataBuilder clerkConfirmationOfMrn(String clerkConfirmationOfMrn) {
            this.clerkConfirmationOfMrn = clerkConfirmationOfMrn;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder clerkOtherReason(String clerkOtherReason) {
            this.clerkOtherReason = clerkOtherReason;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder clerkConfirmationOther(String clerkConfirmationOther) {
            this.clerkConfirmationOther = clerkConfirmationOther;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder responseRequired(String responseRequired) {
            this.responseRequired = responseRequired;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder timeExtensionRequested(String timeExtensionRequested) {
            this.timeExtensionRequested = timeExtensionRequested;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder bundleConfiguration(String bundleConfiguration) {
            this.bundleConfiguration = bundleConfiguration;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder pcqId(String pcqId) {
            this.pcqId = pcqId;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder writeFinalDecisionIsDescriptorFlow(String writeFinalDecisionIsDescriptorFlow) {
            this.writeFinalDecisionIsDescriptorFlow = writeFinalDecisionIsDescriptorFlow;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder writeFinalDecisionGenerateNotice(String writeFinalDecisionGenerateNotice) {
            this.writeFinalDecisionGenerateNotice = writeFinalDecisionGenerateNotice;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder writeFinalDecisionAllowedOrRefused(String writeFinalDecisionAllowedOrRefused) {
            this.writeFinalDecisionAllowedOrRefused = writeFinalDecisionAllowedOrRefused;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder writeFinalDecisionTypeOfHearing(String writeFinalDecisionTypeOfHearing) {
            this.writeFinalDecisionTypeOfHearing = writeFinalDecisionTypeOfHearing;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder writeFinalDecisionPresentingOfficerAttendedQuestion(String writeFinalDecisionPresentingOfficerAttendedQuestion) {
            this.writeFinalDecisionPresentingOfficerAttendedQuestion = writeFinalDecisionPresentingOfficerAttendedQuestion;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder writeFinalDecisionAppellantAttendedQuestion(String writeFinalDecisionAppellantAttendedQuestion) {
            this.writeFinalDecisionAppellantAttendedQuestion = writeFinalDecisionAppellantAttendedQuestion;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder pipWriteFinalDecisionDailyLivingQuestion(String pipWriteFinalDecisionDailyLivingQuestion) {
            this.pipWriteFinalDecisionDailyLivingQuestion = pipWriteFinalDecisionDailyLivingQuestion;
            return this;
        }

        @JsonProperty("pipWriteFinalDecisionComparedToDWPDailyLivingQuestion")
        public SscsCaseData.SscsCaseDataBuilder pipWriteFinalDecisionComparedToDwpDailyLivingQuestion(String pipWriteFinalDecisionComparedToDwpDailyLivingQuestion) {
            this.pipWriteFinalDecisionComparedToDwpDailyLivingQuestion = pipWriteFinalDecisionComparedToDwpDailyLivingQuestion;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder pipWriteFinalDecisionMobilityQuestion(String pipWriteFinalDecisionMobilityQuestion) {
            this.pipWriteFinalDecisionMobilityQuestion = pipWriteFinalDecisionMobilityQuestion;
            return this;
        }

        @JsonProperty("pipWriteFinalDecisionComparedToDWPMobilityQuestion")
        public SscsCaseData.SscsCaseDataBuilder pipWriteFinalDecisionComparedToDwpMobilityQuestion(String pipWriteFinalDecisionComparedToDwpMobilityQuestion) {
            this.pipWriteFinalDecisionComparedToDwpMobilityQuestion = pipWriteFinalDecisionComparedToDwpMobilityQuestion;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder writeFinalDecisionStartDate(String writeFinalDecisionStartDate) {
            this.writeFinalDecisionStartDate = writeFinalDecisionStartDate;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder writeFinalDecisionEndDateType(String writeFinalDecisionEndDateType) {
            this.writeFinalDecisionEndDateType = writeFinalDecisionEndDateType;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder writeFinalDecisionEndDate(String writeFinalDecisionEndDate) {
            this.writeFinalDecisionEndDate = writeFinalDecisionEndDate;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder writeFinalDecisionDisabilityQualifiedPanelMemberName(String writeFinalDecisionDisabilityQualifiedPanelMemberName) {
            this.writeFinalDecisionDisabilityQualifiedPanelMemberName = writeFinalDecisionDisabilityQualifiedPanelMemberName;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder writeFinalDecisionMedicallyQualifiedPanelMemberName(String writeFinalDecisionMedicallyQualifiedPanelMemberName) {
            this.writeFinalDecisionMedicallyQualifiedPanelMemberName = writeFinalDecisionMedicallyQualifiedPanelMemberName;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder writeFinalDecisionOtherPanelMemberName(String writeFinalDecisionOtherPanelMemberName) {
            this.writeFinalDecisionOtherPanelMemberName = writeFinalDecisionOtherPanelMemberName;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder writeFinalDecisionDateOfDecision(String writeFinalDecisionDateOfDecision) {
            this.writeFinalDecisionDateOfDecision = writeFinalDecisionDateOfDecision;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder writeFinalDecisionDetailsOfDecision(String writeFinalDecisionDetailsOfDecision) {
            this.writeFinalDecisionDetailsOfDecision = writeFinalDecisionDetailsOfDecision;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder writeFinalDecisionReasons(List<CollectionItem<String>> writeFinalDecisionReasons) {
            this.writeFinalDecisionReasons = writeFinalDecisionReasons;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder pipWriteFinalDecisionPreparingFoodQuestion(String pipWriteFinalDecisionPreparingFoodQuestion) {
            this.pipWriteFinalDecisionPreparingFoodQuestion = pipWriteFinalDecisionPreparingFoodQuestion;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder pipWriteFinalDecisionTakingNutritionQuestion(String pipWriteFinalDecisionTakingNutritionQuestion) {
            this.pipWriteFinalDecisionTakingNutritionQuestion = pipWriteFinalDecisionTakingNutritionQuestion;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder pipWriteFinalDecisionManagingTherapyQuestion(String pipWriteFinalDecisionManagingTherapyQuestion) {
            this.pipWriteFinalDecisionManagingTherapyQuestion = pipWriteFinalDecisionManagingTherapyQuestion;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder pipWriteFinalDecisionWashAndBatheQuestion(String pipWriteFinalDecisionWashAndBatheQuestion) {
            this.pipWriteFinalDecisionWashAndBatheQuestion = pipWriteFinalDecisionWashAndBatheQuestion;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder pipWriteFinalDecisionManagingToiletNeedsQuestion(String pipWriteFinalDecisionManagingToiletNeedsQuestion) {
            this.pipWriteFinalDecisionManagingToiletNeedsQuestion = pipWriteFinalDecisionManagingToiletNeedsQuestion;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder pipWriteFinalDecisionDressingAndUndressingQuestion(String pipWriteFinalDecisionDressingAndUndressingQuestion) {
            this.pipWriteFinalDecisionDressingAndUndressingQuestion = pipWriteFinalDecisionDressingAndUndressingQuestion;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder pipWriteFinalDecisionCommunicatingQuestion(String pipWriteFinalDecisionCommunicatingQuestion) {
            this.pipWriteFinalDecisionCommunicatingQuestion = pipWriteFinalDecisionCommunicatingQuestion;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder pipWriteFinalDecisionReadingUnderstandingQuestion(String pipWriteFinalDecisionReadingUnderstandingQuestion) {
            this.pipWriteFinalDecisionReadingUnderstandingQuestion = pipWriteFinalDecisionReadingUnderstandingQuestion;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder pipWriteFinalDecisionEngagingWithOthersQuestion(String pipWriteFinalDecisionEngagingWithOthersQuestion) {
            this.pipWriteFinalDecisionEngagingWithOthersQuestion = pipWriteFinalDecisionEngagingWithOthersQuestion;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder pipWriteFinalDecisionBudgetingDecisionsQuestion(String pipWriteFinalDecisionBudgetingDecisionsQuestion) {
            this.pipWriteFinalDecisionBudgetingDecisionsQuestion = pipWriteFinalDecisionBudgetingDecisionsQuestion;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder pipWriteFinalDecisionPlanningAndFollowingQuestion(String pipWriteFinalDecisionPlanningAndFollowingQuestion) {
            this.pipWriteFinalDecisionPlanningAndFollowingQuestion = pipWriteFinalDecisionPlanningAndFollowingQuestion;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder pipWriteFinalDecisionMovingAroundQuestion(String pipWriteFinalDecisionMovingAroundQuestion) {
            this.pipWriteFinalDecisionMovingAroundQuestion = pipWriteFinalDecisionMovingAroundQuestion;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder writeFinalDecisionPageSectionReference(String writeFinalDecisionPageSectionReference) {
            this.writeFinalDecisionPageSectionReference = writeFinalDecisionPageSectionReference;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder writeFinalDecisionAnythingElse(String writeFinalDecisionAnythingElse) {
            this.writeFinalDecisionAnythingElse = writeFinalDecisionAnythingElse;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder writeFinalDecisionPreviewDocument(DocumentLink writeFinalDecisionPreviewDocument) {
            this.writeFinalDecisionPreviewDocument = writeFinalDecisionPreviewDocument;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder writeFinalDecisionGeneratedDate(String writeFinalDecisionGeneratedDate) {
            this.writeFinalDecisionGeneratedDate = writeFinalDecisionGeneratedDate;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder adjournCaseGenerateNotice(String adjournCaseGenerateNotice) {
            this.adjournCaseGenerateNotice = adjournCaseGenerateNotice;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder adjournCaseTypeOfHearing(String adjournCaseTypeOfHearing) {
            this.adjournCaseTypeOfHearing = adjournCaseTypeOfHearing;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder adjournCaseCanCaseBeListedRightAway(String adjournCaseCanCaseBeListedRightAway) {
            this.adjournCaseCanCaseBeListedRightAway = adjournCaseCanCaseBeListedRightAway;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder adjournCaseAreDirectionsBeingMadeToParties(String adjournCaseAreDirectionsBeingMadeToParties) {
            this.adjournCaseAreDirectionsBeingMadeToParties = adjournCaseAreDirectionsBeingMadeToParties;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder adjournCaseDirectionsDueDateDaysOffset(String adjournCaseDirectionsDueDateDaysOffset) {
            this.adjournCaseDirectionsDueDateDaysOffset = adjournCaseDirectionsDueDateDaysOffset;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder adjournCaseDirectionsDueDate(String adjournCaseDirectionsDueDate) {
            this.adjournCaseDirectionsDueDate = adjournCaseDirectionsDueDate;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder adjournCaseTypeOfNextHearing(String adjournCaseTypeOfNextHearing) {
            this.adjournCaseTypeOfNextHearing = adjournCaseTypeOfNextHearing;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder adjournCaseNextHearingVenue(String adjournCaseNextHearingVenue) {
            this.adjournCaseNextHearingVenue = adjournCaseNextHearingVenue;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder adjournCaseNextHearingVenueSelected(DynamicList adjournCaseNextHearingVenueSelected) {
            this.adjournCaseNextHearingVenueSelected = adjournCaseNextHearingVenueSelected;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder adjournCasePanelMembersExcluded(String adjournCasePanelMembersExcluded) {
            this.adjournCasePanelMembersExcluded = adjournCasePanelMembersExcluded;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder adjournCaseDisabilityQualifiedPanelMemberName(String adjournCaseDisabilityQualifiedPanelMemberName) {
            this.adjournCaseDisabilityQualifiedPanelMemberName = adjournCaseDisabilityQualifiedPanelMemberName;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder adjournCaseMedicallyQualifiedPanelMemberName(String adjournCaseMedicallyQualifiedPanelMemberName) {
            this.adjournCaseMedicallyQualifiedPanelMemberName = adjournCaseMedicallyQualifiedPanelMemberName;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder adjournCaseOtherPanelMemberName(String adjournCaseOtherPanelMemberName) {
            this.adjournCaseOtherPanelMemberName = adjournCaseOtherPanelMemberName;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder adjournCaseNextHearingListingDurationType(String adjournCaseNextHearingListingDurationType) {
            this.adjournCaseNextHearingListingDurationType = adjournCaseNextHearingListingDurationType;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder adjournCaseNextHearingListingDuration(String adjournCaseNextHearingListingDuration) {
            this.adjournCaseNextHearingListingDuration = adjournCaseNextHearingListingDuration;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder adjournCaseNextHearingListingDurationUnits(String adjournCaseNextHearingListingDurationUnits) {
            this.adjournCaseNextHearingListingDurationUnits = adjournCaseNextHearingListingDurationUnits;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder adjournCaseInterpreterRequired(String adjournCaseInterpreterRequired) {
            this.adjournCaseInterpreterRequired = adjournCaseInterpreterRequired;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder adjournCaseInterpreterLanguage(String adjournCaseInterpreterLanguage) {
            this.adjournCaseInterpreterLanguage = adjournCaseInterpreterLanguage;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder adjournCaseNextHearingDateType(String adjournCaseNextHearingDateType) {
            this.adjournCaseNextHearingDateType = adjournCaseNextHearingDateType;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder adjournCaseNextHearingDateOrPeriod(String adjournCaseNextHearingDateOrPeriod) {
            this.adjournCaseNextHearingDateOrPeriod = adjournCaseNextHearingDateOrPeriod;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder adjournCaseNextHearingDateOrTime(String adjournCaseNextHearingDateOrTime) {
            this.adjournCaseNextHearingDateOrTime = adjournCaseNextHearingDateOrTime;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder adjournCaseNextHearingFirstAvailableDateAfterDate(String adjournCaseNextHearingFirstAvailableDateAfterDate) {
            this.adjournCaseNextHearingFirstAvailableDateAfterDate = adjournCaseNextHearingFirstAvailableDateAfterDate;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder adjournCaseNextHearingFirstAvailableDateAfterPeriod(String adjournCaseNextHearingFirstAvailableDateAfterPeriod) {
            this.adjournCaseNextHearingFirstAvailableDateAfterPeriod = adjournCaseNextHearingFirstAvailableDateAfterPeriod;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder adjournCaseTime(AdjournCaseTime adjournCaseTime) {
            this.adjournCaseTime = adjournCaseTime;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder adjournCaseReasons(List<CollectionItem<String>> adjournCaseReasons) {
            this.adjournCaseReasons = adjournCaseReasons;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder adjournCaseAdditionalDirections(List<CollectionItem<String>> adjournCaseAdditionalDirections) {
            this.adjournCaseAdditionalDirections = adjournCaseAdditionalDirections;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder adjournCasePreviewDocument(DocumentLink adjournCasePreviewDocument) {
            this.adjournCasePreviewDocument = adjournCasePreviewDocument;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder adjournCaseGeneratedDate(String adjournCaseGeneratedDate) {
            this.adjournCaseGeneratedDate = adjournCaseGeneratedDate;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder notListableProvideReasons(String notListableProvideReasons) {
            this.notListableProvideReasons = notListableProvideReasons;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder notListableDueDate(String notListableDueDate) {
            this.notListableDueDate = notListableDueDate;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder updateNotListableDirectionsFulfilled(String updateNotListableDirectionsFulfilled) {
            this.updateNotListableDirectionsFulfilled = updateNotListableDirectionsFulfilled;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder updateNotListableInterlocReview(String updateNotListableInterlocReview) {
            this.updateNotListableInterlocReview = updateNotListableInterlocReview;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder updateNotListableWhoReviewsCase(String updateNotListableWhoReviewsCase) {
            this.updateNotListableWhoReviewsCase = updateNotListableWhoReviewsCase;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder updateNotListableSetNewDueDate(String updateNotListableSetNewDueDate) {
            this.updateNotListableSetNewDueDate = updateNotListableSetNewDueDate;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder updateNotListableDueDate(String updateNotListableDueDate) {
            this.updateNotListableDueDate = updateNotListableDueDate;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder updateNotListableWhereShouldCaseMoveTo(String updateNotListableWhereShouldCaseMoveTo) {
            this.updateNotListableWhereShouldCaseMoveTo = updateNotListableWhereShouldCaseMoveTo;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder languagePreferenceWelsh(String languagePreferenceWelsh) {
            this.languagePreferenceWelsh = languagePreferenceWelsh;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder elementsDisputedList(List<String> elementsDisputedList) {
            this.elementsDisputedList = elementsDisputedList;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder elementsDisputedGeneral(List<ElementDisputed> elementsDisputedGeneral) {
            this.elementsDisputedGeneral = elementsDisputedGeneral;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder elementsDisputedSanctions(List<ElementDisputed> elementsDisputedSanctions) {
            this.elementsDisputedSanctions = elementsDisputedSanctions;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder elementsDisputedOverpayment(List<ElementDisputed> elementsDisputedOverpayment) {
            this.elementsDisputedOverpayment = elementsDisputedOverpayment;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder elementsDisputedHousing(List<ElementDisputed> elementsDisputedHousing) {
            this.elementsDisputedHousing = elementsDisputedHousing;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder elementsDisputedChildCare(List<ElementDisputed> elementsDisputedChildCare) {
            this.elementsDisputedChildCare = elementsDisputedChildCare;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder elementsDisputedCare(List<ElementDisputed> elementsDisputedCare) {
            this.elementsDisputedCare = elementsDisputedCare;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder elementsDisputedChildElement(List<ElementDisputed> elementsDisputedChildElement) {
            this.elementsDisputedChildElement = elementsDisputedChildElement;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder elementsDisputedChildDisabled(List<ElementDisputed> elementsDisputedChildDisabled) {
            this.elementsDisputedChildDisabled = elementsDisputedChildDisabled;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder elementsDisputedIsDecisionDisputedByOthers(String elementsDisputedIsDecisionDisputedByOthers) {
            this.elementsDisputedIsDecisionDisputedByOthers = elementsDisputedIsDecisionDisputedByOthers;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder elementsDisputedLinkedAppealRef(String elementsDisputedLinkedAppealRef) {
            this.elementsDisputedLinkedAppealRef = elementsDisputedLinkedAppealRef;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder jointParty(String jointParty) {
            this.jointParty = jointParty;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder jointPartyName(JointPartyName jointPartyName) {
            this.jointPartyName = jointPartyName;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder jointPartyIdentity(Identity jointPartyIdentity) {
            this.jointPartyIdentity = jointPartyIdentity;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder jointPartyAddressSameAsAppellant(String jointPartyAddressSameAsAppellant) {
            this.jointPartyAddressSameAsAppellant = jointPartyAddressSameAsAppellant;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder jointPartyAddress(Address jointPartyAddress) {
            this.jointPartyAddress = jointPartyAddress;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder translationWorkOutstanding(String translationWorkOutstanding) {
            this.translationWorkOutstanding = translationWorkOutstanding;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder sscsWelshDocuments(List<SscsWelshDocument> sscsWelshDocuments) {
            this.sscsWelshDocuments = sscsWelshDocuments;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder sscsWelshPreviewDocuments(List<SscsWelshDocument> sscsWelshPreviewDocuments) {
            this.sscsWelshPreviewDocuments = sscsWelshPreviewDocuments;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder sscsWelshPreviewNextEvent(String sscsWelshPreviewNextEvent) {
            this.sscsWelshPreviewNextEvent = sscsWelshPreviewNextEvent;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder originalDocuments(DynamicList originalDocuments) {
            this.originalDocuments = originalDocuments;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder originalNoticeDocuments(DynamicList originalNoticeDocuments) {
            this.originalNoticeDocuments = originalNoticeDocuments;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder documentTypes(DynamicList documentTypes) {
            this.documentTypes = documentTypes;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder welshBodyContent(String welshBodyContent) {
            this.welshBodyContent = welshBodyContent;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder englishBodyContent(String englishBodyContent) {
            this.englishBodyContent = englishBodyContent;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder isScottishCase(String isScottishCase) {
            this.isScottishCase = isScottishCase;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder reinstatementRegistered(LocalDate reinstatementRegistered) {
            this.reinstatementRegistered = reinstatementRegistered;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder reinstatementOutcome(RequestOutcome reinstatementOutcome) {
            this.reinstatementOutcome = reinstatementOutcome;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder welshInterlocNextReviewState(String welshInterlocNextReviewState) {
            this.welshInterlocNextReviewState = welshInterlocNextReviewState;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder confidentialityRequestOutcomeAppellant(DatedRequestOutcome confidentialityRequestOutcomeAppellant) {
            this.confidentialityRequestOutcomeAppellant = confidentialityRequestOutcomeAppellant;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder confidentialityRequestOutcomeJointParty(DatedRequestOutcome confidentialityRequestOutcomeJointParty) {
            this.confidentialityRequestOutcomeJointParty = confidentialityRequestOutcomeJointParty;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder confidentialityRequestAppellantGrantedOrRefused(String confidentialityRequestAppellantGrantedOrRefused) {
            this.confidentialityRequestAppellantGrantedOrRefused = confidentialityRequestAppellantGrantedOrRefused;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder confidentialityRequestJointPartyGrantedOrRefused(String confidentialityRequestJointPartyGrantedOrRefused) {
            this.confidentialityRequestJointPartyGrantedOrRefused = confidentialityRequestJointPartyGrantedOrRefused;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder formType(FormType formType) {
            this.formType = formType;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder isProgressingViaGaps(String isProgressingViaGaps) {
            this.isProgressingViaGaps = isProgressingViaGaps;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder wcaAppeal(String wcaAppeal) {
            this.wcaAppeal = wcaAppeal;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder supportGroupOnlyAppeal(String supportGroupOnlyAppeal) {
            this.supportGroupOnlyAppeal = supportGroupOnlyAppeal;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder esaWriteFinalDecisionPhysicalDisabilitiesQuestion(List<String> esaWriteFinalDecisionPhysicalDisabilitiesQuestion) {
            this.esaWriteFinalDecisionPhysicalDisabilitiesQuestion = esaWriteFinalDecisionPhysicalDisabilitiesQuestion;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder esaWriteFinalDecisionMentalAssessmentQuestion(List<String> esaWriteFinalDecisionMentalAssessmentQuestion) {
            this.esaWriteFinalDecisionMentalAssessmentQuestion = esaWriteFinalDecisionMentalAssessmentQuestion;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder esaWriteFinalDecisionMobilisingUnaidedQuestion(String esaWriteFinalDecisionMobilisingUnaidedQuestion) {
            this.esaWriteFinalDecisionMobilisingUnaidedQuestion = esaWriteFinalDecisionMobilisingUnaidedQuestion;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder esaWriteFinalDecisionStandingAndSittingQuestion(String esaWriteFinalDecisionStandingAndSittingQuestion) {
            this.esaWriteFinalDecisionStandingAndSittingQuestion = esaWriteFinalDecisionStandingAndSittingQuestion;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder esaWriteFinalDecisionReachingQuestion(String esaWriteFinalDecisionReachingQuestion) {
            this.esaWriteFinalDecisionReachingQuestion = esaWriteFinalDecisionReachingQuestion;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder esaWriteFinalDecisionPickingUpQuestion(String esaWriteFinalDecisionPickingUpQuestion) {
            this.esaWriteFinalDecisionPickingUpQuestion = esaWriteFinalDecisionPickingUpQuestion;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder esaWriteFinalDecisionManualDexterityQuestion(String esaWriteFinalDecisionManualDexterityQuestion) {
            this.esaWriteFinalDecisionManualDexterityQuestion = esaWriteFinalDecisionManualDexterityQuestion;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder esaWriteFinalDecisionMakingSelfUnderstoodQuestion(String esaWriteFinalDecisionMakingSelfUnderstoodQuestion) {
            this.esaWriteFinalDecisionMakingSelfUnderstoodQuestion = esaWriteFinalDecisionMakingSelfUnderstoodQuestion;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder esaWriteFinalDecisionCommunicationQuestion(String esaWriteFinalDecisionCommunicationQuestion) {
            this.esaWriteFinalDecisionCommunicationQuestion = esaWriteFinalDecisionCommunicationQuestion;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder esaWriteFinalDecisionNavigationQuestion(String esaWriteFinalDecisionNavigationQuestion) {
            this.esaWriteFinalDecisionNavigationQuestion = esaWriteFinalDecisionNavigationQuestion;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder esaWriteFinalDecisionLossOfControlQuestion(String esaWriteFinalDecisionLossOfControlQuestion) {
            this.esaWriteFinalDecisionLossOfControlQuestion = esaWriteFinalDecisionLossOfControlQuestion;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder esaWriteFinalDecisionConsciousnessQuestion(String esaWriteFinalDecisionConsciousnessQuestion) {
            this.esaWriteFinalDecisionConsciousnessQuestion = esaWriteFinalDecisionConsciousnessQuestion;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder esaWriteFinalDecisionLearningTasksQuestion(String esaWriteFinalDecisionLearningTasksQuestion) {
            this.esaWriteFinalDecisionLearningTasksQuestion = esaWriteFinalDecisionLearningTasksQuestion;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder esaWriteFinalDecisionAwarenessOfHazardsQuestion(String esaWriteFinalDecisionAwarenessOfHazardsQuestion) {
            this.esaWriteFinalDecisionAwarenessOfHazardsQuestion = esaWriteFinalDecisionAwarenessOfHazardsQuestion;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder esaWriteFinalDecisionPersonalActionQuestion(String esaWriteFinalDecisionPersonalActionQuestion) {
            this.esaWriteFinalDecisionPersonalActionQuestion = esaWriteFinalDecisionPersonalActionQuestion;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder esaWriteFinalDecisionCopingWithChangeQuestion(String esaWriteFinalDecisionCopingWithChangeQuestion) {
            this.esaWriteFinalDecisionCopingWithChangeQuestion = esaWriteFinalDecisionCopingWithChangeQuestion;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder esaWriteFinalDecisionGettingAboutQuestion(String esaWriteFinalDecisionGettingAboutQuestion) {
            this.esaWriteFinalDecisionGettingAboutQuestion = esaWriteFinalDecisionGettingAboutQuestion;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder esaWriteFinalDecisionSocialEngagementQuestion(String esaWriteFinalDecisionSocialEngagementQuestion) {
            this.esaWriteFinalDecisionSocialEngagementQuestion = esaWriteFinalDecisionSocialEngagementQuestion;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder esaWriteFinalDecisionAppropriatenessOfBehaviourQuestion(String esaWriteFinalDecisionAppropriatenessOfBehaviourQuestion) {
            this.esaWriteFinalDecisionAppropriatenessOfBehaviourQuestion = esaWriteFinalDecisionAppropriatenessOfBehaviourQuestion;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder doesRegulation29Apply(YesNo doesRegulation29Apply) {
            this.doesRegulation29Apply = doesRegulation29Apply;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder showRegulation29Page(YesNo showRegulation29Page) {
            this.showRegulation29Page = showRegulation29Page;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder showSchedule3ActivitiesPage(YesNo showSchedule3ActivitiesPage) {
            this.showSchedule3ActivitiesPage = showSchedule3ActivitiesPage;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder esaWriteFinalDecisionSchedule3ActivitiesApply(String esaWriteFinalDecisionSchedule3ActivitiesApply) {
            this.esaWriteFinalDecisionSchedule3ActivitiesApply = esaWriteFinalDecisionSchedule3ActivitiesApply;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder esaWriteFinalDecisionSchedule3ActivitiesQuestion(List<String> esaWriteFinalDecisionSchedule3ActivitiesQuestion) {
            this.esaWriteFinalDecisionSchedule3ActivitiesQuestion = esaWriteFinalDecisionSchedule3ActivitiesQuestion;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder doesRegulation35Apply(YesNo doesRegulation35Apply) {
            this.doesRegulation35Apply = doesRegulation35Apply;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder showFinalDecisionNoticeSummaryOfOutcomePage(YesNo showFinalDecisionNoticeSummaryOfOutcomePage) {
            this.showFinalDecisionNoticeSummaryOfOutcomePage = showFinalDecisionNoticeSummaryOfOutcomePage;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder test1(String test1) {
            this.test1 = test1;
            return this;
        }

        public SscsCaseData.SscsCaseDataBuilder test2(String test2) {
            this.test2 = test2;
            return this;
        }

        public SscsCaseData build() {
            SscsCaseData caseData = new SscsCaseData();
            caseData.ccdCaseId = this.ccdCaseId;
            caseData.state = this.state;
            caseData.previousState = this.previousState;
            caseData.caseReference = this.caseReference;
            caseData.caseCreated = this.caseCreated;
            caseData.infoRequests = this.infoRequests;
            caseData.region = this.region;
            caseData.appeal = this.appeal;
            caseData.hearings = this.hearings;
            caseData.evidence = this.evidence;
            caseData.dwpTimeExtension = this.dwpTimeExtension;
            caseData.events = this.events;
            caseData.subscriptions = this.subscriptions;
            caseData.regionalProcessingCenter = this.regionalProcessingCenter;
            caseData.caseBundles = this.caseBundles;
            caseData.sscsDocument = this.sscsDocument;
            caseData.draftSscsDocument = this.draftSscsDocument;
            caseData.draftSscsFurtherEvidenceDocument = this.draftSscsFurtherEvidenceDocument;
            caseData.corDocument = this.corDocument;
            caseData.draftCorDocument = this.draftCorDocument;
            caseData.generatedNino = this.generatedNino;
            caseData.generatedSurname = this.generatedSurname;
            caseData.generatedEmail = this.generatedEmail;
            caseData.generatedMobile = this.generatedMobile;
            caseData.generatedDob = this.generatedDob;
            caseData.directionResponse = this.directionResponse;
            caseData.evidencePresent = this.evidencePresent;
            caseData.bulkScanCaseReference = this.bulkScanCaseReference;
            caseData.decisionNotes = this.decisionNotes;
            caseData.isCorDecision = this.isCorDecision;
            caseData.relistingReason = this.relistingReason;
            caseData.dateSentToDwp = this.dateSentToDwp;
            caseData.interlocReviewState = this.interlocReviewState;
            caseData.hmctsDwpState = this.hmctsDwpState;
            caseData.dwpFurtherEvidenceStates = this.dwpFurtherEvidenceStates;
            caseData.originalSender = this.originalSender;
            caseData.furtherEvidenceAction = this.furtherEvidenceAction;
            caseData.scannedDocuments = this.scannedDocuments;
            caseData.outcome = this.outcome;
            caseData.sscsInterlocDirectionDocument = this.sscsInterlocDirectionDocument;
            caseData.sscsInterlocDecisionDocument = this.sscsInterlocDecisionDocument;
            caseData.sscsStrikeOutDocument = this.sscsStrikeOutDocument;
            caseData.informationFromAppellant = this.informationFromAppellant;
            caseData.evidenceHandled = this.evidenceHandled;
            caseData.assignedToJudge = this.assignedToJudge;
            caseData.assignedToDisabilityMember = this.assignedToDisabilityMember;
            caseData.assignedToMedicalMember = this.assignedToMedicalMember;
            caseData.reissueFurtherEvidenceDocument = this.reissueFurtherEvidenceDocument;
            caseData.resendToAppellant = this.resendToAppellant;
            caseData.resendToRepresentative = this.resendToRepresentative;
            caseData.resendToDwp = this.resendToDwp;
            caseData.caseCode = this.caseCode;
            caseData.benefitCode = this.benefitCode;
            caseData.issueCode = this.issueCode;
            caseData.dwpOriginatingOffice = this.dwpOriginatingOffice;
            caseData.dwpPresentingOffice = this.dwpPresentingOffice;
            caseData.dwpIsOfficerAttending = this.dwpIsOfficerAttending;
            caseData.dwpUcb = this.dwpUcb;
            caseData.dwpPhme = this.dwpPhme;
            caseData.dwpComplexAppeal = this.dwpComplexAppeal;
            caseData.dwpFurtherInfo = this.dwpFurtherInfo;
            caseData.correspondence = this.correspondence;
            caseData.interlocReferralDate = this.interlocReferralDate;
            caseData.interlocReferralReason = this.interlocReferralReason;
            caseData.dwpRegionalCentre = this.dwpRegionalCentre;
            caseData.generateNotice = this.generateNotice;
            caseData.previewDocument = this.previewDocument;
            caseData.bodyContent = this.bodyContent;
            caseData.signedBy = this.signedBy;
            caseData.signedRole = this.signedRole;
            caseData.dateAdded = this.dateAdded;
            caseData.historicSscsInterlocDirectionDocs = this.historicSscsInterlocDirectionDocs;
            caseData.dwpState = this.dwpState;
            caseData.appealNotePad = this.appealNotePad;
            caseData.dwpStateFeNoAction = this.dwpStateFeNoAction;
            caseData.createdInGapsFrom = this.createdInGapsFrom;
            caseData.dateCaseSentToGaps = this.dateCaseSentToGaps;
            caseData.associatedCase = this.associatedCase;
            caseData.dwpAT38Document = this.dwpAT38Document;
            caseData.dwpEvidenceBundleDocument = this.dwpEvidenceBundleDocument;
            caseData.dwpResponseDocument = this.dwpResponseDocument;
            caseData.dwpSupplementaryResponseDoc = this.dwpSupplementaryResponseDoc;
            caseData.dwpOtherDoc = this.dwpOtherDoc;
            caseData.dwpLT203 = this.dwpLT203;
            caseData.dwpLapseLetter = this.dwpLapseLetter;
            caseData.dwpResponseDate = this.dwpResponseDate;
            caseData.linkedCasesBoolean = this.linkedCasesBoolean;
            caseData.decisionType = this.decisionType;
            caseData.selectWhoReviewsCase = this.selectWhoReviewsCase;
            caseData.directionType = this.directionType;
            caseData.directionTypeDl = this.directionTypeDl;
            caseData.extensionNextEvent = this.extensionNextEvent;
            caseData.extensionNextEventDl = this.extensionNextEventDl;
            caseData.tl1Form = this.tl1Form;
            caseData.isInterlocRequired = this.isInterlocRequired;
            caseData.panel = this.panel;
            caseData.evidenceReceived = this.evidenceReceived;
            caseData.urgentCase = this.urgentCase;
            caseData.urgentHearingRegistered = this.urgentHearingRegistered;
            caseData.urgentHearingOutcome = this.urgentHearingOutcome;
            caseData.documentSentToDwp = this.documentSentToDwp;
            caseData.directionDueDate = this.directionDueDate;
            caseData.reservedToJudge = this.reservedToJudge;
            caseData.linkedCase = this.linkedCase;
            caseData.isWaiverNeeded = this.isWaiverNeeded;
            caseData.waiverDeclaration = this.waiverDeclaration;
            caseData.waiverReason = this.waiverReason;
            caseData.waiverReasonOther = this.waiverReasonOther;
            caseData.clerkDelegatedAuthority = this.clerkDelegatedAuthority;
            caseData.clerkAppealSatisfactionText = this.clerkAppealSatisfactionText;
            caseData.clerkConfirmationOfMrn = this.clerkConfirmationOfMrn;
            caseData.clerkOtherReason = this.clerkOtherReason;
            caseData.clerkConfirmationOther = this.clerkConfirmationOther;
            caseData.responseRequired = this.responseRequired;
            caseData.timeExtensionRequested = this.timeExtensionRequested;
            caseData.bundleConfiguration = this.bundleConfiguration;
            caseData.pcqId = this.pcqId;
            caseData.writeFinalDecisionIsDescriptorFlow = this.writeFinalDecisionIsDescriptorFlow;
            caseData.writeFinalDecisionGenerateNotice = this.writeFinalDecisionGenerateNotice;
            caseData.writeFinalDecisionAllowedOrRefused = this.writeFinalDecisionAllowedOrRefused;
            caseData.writeFinalDecisionTypeOfHearing = this.writeFinalDecisionTypeOfHearing;
            caseData.writeFinalDecisionPresentingOfficerAttendedQuestion = this.writeFinalDecisionPresentingOfficerAttendedQuestion;
            caseData.writeFinalDecisionAppellantAttendedQuestion = this.writeFinalDecisionAppellantAttendedQuestion;
            caseData.pipWriteFinalDecisionDailyLivingQuestion = this.pipWriteFinalDecisionDailyLivingQuestion;
            caseData.pipWriteFinalDecisionComparedToDwpDailyLivingQuestion = this.pipWriteFinalDecisionComparedToDwpDailyLivingQuestion;
            caseData.pipWriteFinalDecisionMobilityQuestion = this.pipWriteFinalDecisionMobilityQuestion;
            caseData.pipWriteFinalDecisionComparedToDwpMobilityQuestion = this.pipWriteFinalDecisionComparedToDwpMobilityQuestion;
            caseData.writeFinalDecisionStartDate = this.writeFinalDecisionStartDate;
            caseData.writeFinalDecisionEndDateType = this.writeFinalDecisionEndDateType;
            caseData.writeFinalDecisionEndDate = this.writeFinalDecisionEndDate;
            caseData.writeFinalDecisionDisabilityQualifiedPanelMemberName = this.writeFinalDecisionDisabilityQualifiedPanelMemberName;
            caseData.writeFinalDecisionMedicallyQualifiedPanelMemberName = this.writeFinalDecisionMedicallyQualifiedPanelMemberName;
            caseData.writeFinalDecisionOtherPanelMemberName = this.writeFinalDecisionOtherPanelMemberName;
            caseData.writeFinalDecisionDateOfDecision = this.writeFinalDecisionDateOfDecision;
            caseData.writeFinalDecisionDetailsOfDecision = this.writeFinalDecisionDetailsOfDecision;
            caseData.writeFinalDecisionReasons = this.writeFinalDecisionReasons;
            caseData.pipWriteFinalDecisionDailyLivingActivitiesQuestion = this.pipWriteFinalDecisionDailyLivingActivitiesQuestion;
            caseData.pipWriteFinalDecisionMobilityActivitiesQuestion = this.pipWriteFinalDecisionMobilityActivitiesQuestion;
            caseData.pipWriteFinalDecisionPreparingFoodQuestion = this.pipWriteFinalDecisionPreparingFoodQuestion;
            caseData.pipWriteFinalDecisionTakingNutritionQuestion = this.pipWriteFinalDecisionTakingNutritionQuestion;
            caseData.pipWriteFinalDecisionManagingTherapyQuestion = this.pipWriteFinalDecisionManagingTherapyQuestion;
            caseData.pipWriteFinalDecisionWashAndBatheQuestion = this.pipWriteFinalDecisionWashAndBatheQuestion;
            caseData.pipWriteFinalDecisionManagingToiletNeedsQuestion = this.pipWriteFinalDecisionManagingToiletNeedsQuestion;
            caseData.pipWriteFinalDecisionDressingAndUndressingQuestion = this.pipWriteFinalDecisionDressingAndUndressingQuestion;
            caseData.pipWriteFinalDecisionCommunicatingQuestion = this.pipWriteFinalDecisionCommunicatingQuestion;
            caseData.pipWriteFinalDecisionReadingUnderstandingQuestion = this.pipWriteFinalDecisionReadingUnderstandingQuestion;
            caseData.pipWriteFinalDecisionEngagingWithOthersQuestion = this.pipWriteFinalDecisionEngagingWithOthersQuestion;
            caseData.pipWriteFinalDecisionBudgetingDecisionsQuestion = this.pipWriteFinalDecisionBudgetingDecisionsQuestion;
            caseData.pipWriteFinalDecisionPlanningAndFollowingQuestion = this.pipWriteFinalDecisionPlanningAndFollowingQuestion;
            caseData.pipWriteFinalDecisionMovingAroundQuestion = this.pipWriteFinalDecisionMovingAroundQuestion;
            caseData.writeFinalDecisionPageSectionReference = this.writeFinalDecisionPageSectionReference;
            caseData.writeFinalDecisionAnythingElse = this.writeFinalDecisionAnythingElse;
            caseData.writeFinalDecisionPreviewDocument = this.writeFinalDecisionPreviewDocument;
            caseData.writeFinalDecisionGeneratedDate = this.writeFinalDecisionGeneratedDate;
            caseData.adjournCaseGenerateNotice = this.adjournCaseGenerateNotice;
            caseData.adjournCaseTypeOfHearing = this.adjournCaseTypeOfHearing;
            caseData.adjournCaseCanCaseBeListedRightAway = this.adjournCaseCanCaseBeListedRightAway;
            caseData.adjournCaseAreDirectionsBeingMadeToParties = this.adjournCaseAreDirectionsBeingMadeToParties;
            caseData.adjournCaseDirectionsDueDateDaysOffset = this.adjournCaseDirectionsDueDateDaysOffset;
            caseData.adjournCaseDirectionsDueDate = this.adjournCaseDirectionsDueDate;
            caseData.adjournCaseTypeOfNextHearing = this.adjournCaseTypeOfNextHearing;
            caseData.adjournCaseNextHearingVenue = this.adjournCaseNextHearingVenue;
            caseData.adjournCaseNextHearingVenueSelected = this.adjournCaseNextHearingVenueSelected;
            caseData.adjournCasePanelMembersExcluded = this.adjournCasePanelMembersExcluded;
            caseData.adjournCaseDisabilityQualifiedPanelMemberName = this.adjournCaseDisabilityQualifiedPanelMemberName;
            caseData.adjournCaseMedicallyQualifiedPanelMemberName = this.adjournCaseMedicallyQualifiedPanelMemberName;
            caseData.adjournCaseOtherPanelMemberName = this.adjournCaseOtherPanelMemberName;
            caseData.adjournCaseNextHearingListingDurationType = this.adjournCaseNextHearingListingDurationType;
            caseData.adjournCaseNextHearingListingDuration = this.adjournCaseNextHearingListingDuration;
            caseData.adjournCaseNextHearingListingDurationUnits = this.adjournCaseNextHearingListingDurationUnits;
            caseData.adjournCaseInterpreterRequired = this.adjournCaseInterpreterRequired;
            caseData.adjournCaseInterpreterLanguage = this.adjournCaseInterpreterLanguage;
            caseData.adjournCaseNextHearingDateType = this.adjournCaseNextHearingDateType;
            caseData.adjournCaseNextHearingDateOrPeriod = this.adjournCaseNextHearingDateOrPeriod;
            caseData.adjournCaseNextHearingDateOrTime = this.adjournCaseNextHearingDateOrTime;
            caseData.adjournCaseNextHearingFirstAvailableDateAfterDate = this.adjournCaseNextHearingFirstAvailableDateAfterDate;
            caseData.adjournCaseNextHearingFirstAvailableDateAfterPeriod = this.adjournCaseNextHearingFirstAvailableDateAfterPeriod;
            caseData.adjournCaseTime = this.adjournCaseTime;
            caseData.adjournCaseReasons = this.adjournCaseReasons;
            caseData.adjournCaseAdditionalDirections = this.adjournCaseAdditionalDirections;
            caseData.adjournCasePreviewDocument = this.adjournCasePreviewDocument;
            caseData.adjournCaseGeneratedDate = this.adjournCaseGeneratedDate;
            caseData.notListableProvideReasons = this.notListableProvideReasons;
            caseData.notListableDueDate = this.notListableDueDate;
            caseData.updateNotListableDirectionsFulfilled = this.updateNotListableDirectionsFulfilled;
            caseData.updateNotListableInterlocReview = this.updateNotListableInterlocReview;
            caseData.updateNotListableWhoReviewsCase = this.updateNotListableWhoReviewsCase;
            caseData.updateNotListableSetNewDueDate = this.updateNotListableSetNewDueDate;
            caseData.updateNotListableDueDate = this.updateNotListableDueDate;
            caseData.updateNotListableWhereShouldCaseMoveTo = this.updateNotListableWhereShouldCaseMoveTo;
            caseData.languagePreferenceWelsh = this.languagePreferenceWelsh;
            caseData.elementsDisputedList = this.elementsDisputedList;
            caseData.elementsDisputedGeneral = this.elementsDisputedGeneral;
            caseData.elementsDisputedSanctions = this.elementsDisputedSanctions;
            caseData.elementsDisputedOverpayment = this.elementsDisputedOverpayment;
            caseData.elementsDisputedHousing = this.elementsDisputedHousing;
            caseData.elementsDisputedChildCare = this.elementsDisputedChildCare;
            caseData.elementsDisputedCare = this.elementsDisputedCare;
            caseData.elementsDisputedChildElement = this.elementsDisputedChildElement;
            caseData.elementsDisputedChildDisabled = this.elementsDisputedChildDisabled;
            caseData.elementsDisputedIsDecisionDisputedByOthers = this.elementsDisputedIsDecisionDisputedByOthers;
            caseData.elementsDisputedLinkedAppealRef = this.elementsDisputedLinkedAppealRef;
            caseData.jointParty = this.jointParty;
            caseData.jointPartyName = this.jointPartyName;
            caseData.jointPartyIdentity = this.jointPartyIdentity;
            caseData.jointPartyAddressSameAsAppellant = this.jointPartyAddressSameAsAppellant;
            caseData.jointPartyAddress = this.jointPartyAddress;
            caseData.translationWorkOutstanding = this.translationWorkOutstanding;
            caseData.sscsWelshDocuments = this.sscsWelshDocuments;
            caseData.sscsWelshPreviewDocuments = this.sscsWelshPreviewDocuments;
            caseData.sscsWelshPreviewNextEvent = this.sscsWelshPreviewNextEvent;
            caseData.originalDocuments = this.originalDocuments;
            caseData.originalNoticeDocuments = this.originalNoticeDocuments;
            caseData.documentTypes = this.documentTypes;
            caseData.welshBodyContent = this.welshBodyContent;
            caseData.englishBodyContent = this.englishBodyContent;
            caseData.isScottishCase = this.isScottishCase;
            caseData.reinstatementRegistered = this.reinstatementRegistered;
            caseData.reinstatementOutcome = this.reinstatementOutcome;
            caseData.welshInterlocNextReviewState = this.welshInterlocNextReviewState;
            caseData.confidentialityRequestOutcomeAppellant = this.confidentialityRequestOutcomeAppellant;
            caseData.confidentialityRequestOutcomeJointParty = this.confidentialityRequestOutcomeJointParty;
            caseData.confidentialityRequestAppellantGrantedOrRefused = this.confidentialityRequestAppellantGrantedOrRefused;
            caseData.confidentialityRequestJointPartyGrantedOrRefused = this.confidentialityRequestJointPartyGrantedOrRefused;
            caseData.formType = this.formType;
            caseData.isProgressingViaGaps = this.isProgressingViaGaps;
            caseData.wcaAppeal = this.wcaAppeal;
            caseData.supportGroupOnlyAppeal = this.supportGroupOnlyAppeal;
            caseData.esaWriteFinalDecisionPhysicalDisabilitiesQuestion = this.esaWriteFinalDecisionPhysicalDisabilitiesQuestion;
            caseData.esaWriteFinalDecisionMentalAssessmentQuestion = this.esaWriteFinalDecisionMentalAssessmentQuestion;
            caseData.esaWriteFinalDecisionMobilisingUnaidedQuestion = this.esaWriteFinalDecisionMobilisingUnaidedQuestion;
            caseData.esaWriteFinalDecisionStandingAndSittingQuestion = this.esaWriteFinalDecisionStandingAndSittingQuestion;
            caseData.esaWriteFinalDecisionReachingQuestion = this.esaWriteFinalDecisionReachingQuestion;
            caseData.esaWriteFinalDecisionPickingUpQuestion = this.esaWriteFinalDecisionPickingUpQuestion;
            caseData.esaWriteFinalDecisionManualDexterityQuestion = this.esaWriteFinalDecisionManualDexterityQuestion;
            caseData.esaWriteFinalDecisionMakingSelfUnderstoodQuestion = this.esaWriteFinalDecisionMakingSelfUnderstoodQuestion;
            caseData.esaWriteFinalDecisionCommunicationQuestion = this.esaWriteFinalDecisionCommunicationQuestion;
            caseData.esaWriteFinalDecisionNavigationQuestion = this.esaWriteFinalDecisionNavigationQuestion;
            caseData.esaWriteFinalDecisionLossOfControlQuestion = this.esaWriteFinalDecisionLossOfControlQuestion;
            caseData.esaWriteFinalDecisionConsciousnessQuestion = this.esaWriteFinalDecisionConsciousnessQuestion;
            caseData.esaWriteFinalDecisionLearningTasksQuestion = this.esaWriteFinalDecisionLearningTasksQuestion;
            caseData.esaWriteFinalDecisionAwarenessOfHazardsQuestion = this.esaWriteFinalDecisionAwarenessOfHazardsQuestion;
            caseData.esaWriteFinalDecisionPersonalActionQuestion = this.esaWriteFinalDecisionPersonalActionQuestion;
            caseData.esaWriteFinalDecisionCopingWithChangeQuestion = this.esaWriteFinalDecisionCopingWithChangeQuestion;
            caseData.esaWriteFinalDecisionGettingAboutQuestion = this.esaWriteFinalDecisionGettingAboutQuestion;
            caseData.esaWriteFinalDecisionSocialEngagementQuestion = this.esaWriteFinalDecisionSocialEngagementQuestion;
            caseData.esaWriteFinalDecisionAppropriatenessOfBehaviourQuestion = this.esaWriteFinalDecisionAppropriatenessOfBehaviourQuestion;
            caseData.doesRegulation29Apply = this.doesRegulation29Apply;
            caseData.showRegulation29Page = this.showRegulation29Page;
            caseData.showSchedule3ActivitiesPage = this.showSchedule3ActivitiesPage;
            caseData.esaWriteFinalDecisionSchedule3ActivitiesApply = this.esaWriteFinalDecisionSchedule3ActivitiesApply;
            caseData.esaWriteFinalDecisionSchedule3ActivitiesQuestion = this.esaWriteFinalDecisionSchedule3ActivitiesQuestion;
            caseData.doesRegulation35Apply = this.doesRegulation35Apply;
            caseData.showFinalDecisionNoticeSummaryOfOutcomePage = this.showFinalDecisionNoticeSummaryOfOutcomePage;
            caseData.test1 = this.test1;
            caseData.test2 = this.test2;
            return caseData;
        }
    }


}

