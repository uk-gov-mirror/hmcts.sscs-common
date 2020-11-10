package uk.gov.hmcts.reform.sscs.ccd.domain;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
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
import org.apache.commons.lang3.StringUtils;
import uk.gov.hmcts.reform.sscs.ccd.callback.DocumentType;
import uk.gov.hmcts.reform.sscs.ccd.validation.documentlink.DocumentLinkMustBePdf;
import uk.gov.hmcts.reform.sscs.ccd.validation.groups.UniversalCreditValidationGroup;
import uk.gov.hmcts.reform.sscs.ccd.validation.localdate.LocalDateMustBeInFuture;
import uk.gov.hmcts.reform.sscs.ccd.validation.localdate.LocalDateMustNotBeInFuture;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SscsCaseData implements CaseData {

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

    @JsonCreator
    public SscsCaseData(@JsonProperty(value = "ccdCaseId", access = JsonProperty.Access.WRITE_ONLY) String ccdCaseId,
                        @JsonProperty(value = "state") State state,
                        @JsonProperty(value = "previousState") State previousState,
                        @JsonProperty("caseReference") String caseReference,
                        @JsonProperty("caseCreated") String caseCreated,
                        @JsonProperty("infoRequests") InfoRequests infoRequests,
                        @JsonProperty("region") String region,
                        @JsonProperty("appeal") Appeal appeal,
                        @JsonProperty("hearings") List<Hearing> hearings,
                        @JsonProperty("evidence") Evidence evidence,
                        @JsonProperty("dwpTimeExtension") List<DwpTimeExtension> dwpTimeExtension,
                        @JsonProperty("events") List<Event> events,
                        @JsonProperty("subscriptions") Subscriptions subscriptions,
                        @JsonProperty("regionalProcessingCenter") RegionalProcessingCenter regionalProcessingCenter,
                        @JsonProperty("caseBundles") List<Bundle> caseBundles,
                        @JsonProperty("sscsDocument") List<SscsDocument> sscsDocument,
                        @JsonProperty("draftSscsDocument") List<SscsDocument> draftSscsDocument,
                        @JsonProperty("draftSscsFurtherEvidenceDocument") List<SscsFurtherEvidenceDoc> draftSscsFurtherEvidenceDocument,
                        @JsonProperty("corDocument") List<CorDocument> corDocument,
                        @JsonProperty("draftCorDocument") List<CorDocument> draftCorDocument,
                        @JsonProperty("sscsInterlocDecisionDocument") SscsInterlocDecisionDocument sscsInterlocDecisionDocument,
                        @JsonProperty("sscsInterlocDirectionDocument") SscsInterlocDirectionDocument sscsInterlocDirectionDocument,
                        @JsonProperty("sscsStrikeOutDocument") SscsStrikeOutDocument sscsStrikeOutDocument,
                        @JsonProperty("generatedNino") String generatedNino,
                        @JsonProperty("generatedSurname") String generatedSurname,
                        @JsonProperty("generatedEmail") String generatedEmail,
                        @JsonProperty("generatedMobile") String generatedMobile,
                        @JsonProperty("generatedDOB") String generatedDob,
                        @JsonProperty("directionResponse") DirectionResponse directionResponse,
                        @JsonProperty("evidencePresent") String evidencePresent,
                        @JsonProperty("bulkScanCaseReference") String bulkScanCaseReference,
                        @JsonProperty("decisionNotes") String decisionNotes,
                        @JsonProperty("isCorDecision") String isCorDecision,
                        @JsonProperty("relistingReason") String relistingReason,
                        @JsonProperty("dateSentToDwp") String dateSentToDwp,
                        @JsonProperty("interlocReviewState") String interlocReviewState,
                        @JsonProperty("hmctsDwpState") String hmctsDwpState,
                        @JsonProperty("dwpFurtherEvidenceStates") String dwpFurtherEvidenceStates,
                        @JsonProperty("originalSender") DynamicList originalSender,
                        @JsonProperty("furtherEvidenceAction") DynamicList furtherEvidenceAction,
                        @JsonProperty("scannedDocuments") List<ScannedDocument> scannedDocuments,
                        @JsonProperty("informationFromAppellant") String informationFromAppellant,
                        @JsonProperty("outcome") String outcome,
                        @JsonProperty("evidenceHandled") String evidenceHandled,
                        @JsonProperty("assignedToJudge") String assignedToJudge,
                        @JsonProperty("assignedToDisabilityMember") String assignedToDisabilityMember,
                        @JsonProperty("assignedToMedicalMember") String assignedToMedicalMember,
                        @JsonProperty("reissueFurtherEvidenceDocument") DynamicList reissueFurtherEvidenceDocument,
                        @JsonProperty("resendToAppellant") String resendToAppellant,
                        @JsonProperty("resendToRepresentative") String resendToRepresentative,
                        @JsonProperty("resendToDwp") String resendToDwp,
                        @JsonProperty("caseCode") String caseCode,
                        @JsonProperty("benefitCode") String benefitCode,
                        @JsonProperty("issueCode") String issueCode,
                        @JsonProperty("dwpOriginatingOffice") DynamicList dwpOriginatingOffice,
                        @JsonProperty("dwpPresentingOffice") DynamicList dwpPresentingOffice,
                        @JsonProperty("dwpIsOfficerAttending") String dwpIsOfficerAttending,
                        @JsonProperty("dwpUCB") String dwpUcb,
                        @JsonProperty("dwpPHME") String dwpPhme,
                        @JsonProperty("dwpComplexAppeal") String dwpComplexAppeal,
                        @JsonProperty("dwpFurtherInfo") String dwpFurtherInfo,
                        @JsonProperty("correspondence") List<Correspondence> correspondence,
                        @JsonProperty("interlocReferralDate") String interlocReferralDate,
                        @JsonProperty("interlocReferralReason") String interlocReferralReason,
                        @JsonProperty("dwpRegionalCentre") String dwpRegionalCentre,
                        @JsonProperty("generateNotice") String generateNotice,
                        @JsonProperty("previewDocument") DocumentLink previewDocument,
                        @JsonProperty("bodyContent") String bodyContent,
                        @JsonProperty("signedBy") String signedBy,
                        @JsonProperty("signedRole") String signedRole,
                        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
                        @JsonSerialize(using = LocalDateSerializer.class)
                        @JsonProperty("dateAdded") LocalDate dateAdded,
                        @JsonProperty("historicSscsInterlocDirectionDocs") List<SscsInterlocDirectionDocuments> historicSscsInterlocDirectionDocs,
                        @JsonProperty("dwpState") String dwpState,
                        @JsonProperty("appealNotePad") NotePad appealNotePad,
                        @JsonProperty("dwpStateFeNoAction") DynamicList dwpStateFeNoAction,
                        @JsonProperty("createdInGapsFrom") String createdInGapsFrom,
                        @JsonProperty("dateCaseSentToGaps") String dateCaseSentToGaps,
                        @JsonProperty("associatedCase") List<CaseLink> associatedCase,
                        @JsonProperty("dwpAT38Document") DwpResponseDocument dwpAT38Document,
                        @JsonProperty("dwpEvidenceBundleDocument") DwpResponseDocument dwpEvidenceBundleDocument,
                        @JsonProperty("dwpResponseDocument") DwpResponseDocument dwpResponseDocument,
                        @JsonProperty("dwpSupplementaryResponseDoc") DwpResponseDocument dwpSupplementaryResponseDoc,
                        @JsonProperty("dwpOtherDoc") DwpResponseDocument dwpOtherDoc,
                        @JsonProperty("dwpLT203") DwpLT203 dwpLT203,
                        @JsonProperty("dwpLapseLetter") DwpLapseLetter dwpLapseLetter,
                        @JsonProperty("dwpResponseDate") String dwpResponseDate,
                        @JsonProperty("linkedCasesBoolean") String linkedCasesBoolean,
                        @JsonProperty("decisionType") String decisionType,
                        @JsonProperty("selectWhoReviewsCase") DynamicList selectWhoReviewsCase,
                        @JsonProperty("directionType") DirectionType directionType,
                        @JsonProperty("directionTypeDl") DynamicList directionTypeDl,
                        @JsonProperty("extensionNextEvent") ExtensionNextEvent extensionNextEvent,
                        @JsonProperty("extensionNextEventDl") DynamicList extensionNextEventDl,
                        @JsonProperty("tl1Form") DwpResponseDocument tl1Form,
                        @JsonProperty("isInterlocRequired") String isInterlocRequired,
                        @JsonProperty("panel") Panel panel,
                        @JsonProperty("evidenceReceivedCF") EvidenceReceived evidenceReceived,
                        @JsonProperty("urgentCase") String urgentCase,
                        @JsonProperty("urgentHearingRegistered") String urgentHearingRegistered,
                        @JsonProperty("urgentHearingOutcome") String urgentHearingOutcome,
                        @JsonProperty("documentSentToDwp") String documentSentToDwp,
                        @JsonProperty("directionDueDate") String directionDueDate,
                        @JsonProperty("reservedToJudge") String reservedToJudge,
                        @JsonProperty("linkedCase") List<CaseLink> linkedCase,
                        @JsonProperty("isWaiverNeeded") String isWaiverNeeded,
                        @JsonProperty("waiverDeclaration") List<String> waiverDeclaration,
                        @JsonProperty("waiverReason") List<String> waiverReason,
                        @JsonProperty("waiverReasonOther") String waiverReasonOther,
                        @JsonProperty("clerkDelegatedAuthority") List<String> clerkDelegatedAuthority,
                        @JsonProperty("clerkAppealSatisfactionText") List<String> clerkAppealSatisfactionText,
                        @JsonProperty("pipWriteFinalDecisionDailyLivingActivitiesQuestion") List<String> pipWriteFinalDecisionDailyLivingActivitiesQuestion,
                        @JsonProperty("pipWriteFinalDecisionMobilityActivitiesQuestion") List<String> pipWriteFinalDecisionMobilityActivitiesQuestion,
                        @JsonProperty("clerkConfirmationOfMRN") String clerkConfirmationOfMrn,
                        @JsonProperty("clerkOtherReason") String clerkOtherReason,
                        @JsonProperty("clerkConfirmationOther") String clerkConfirmationOther,
                        @JsonProperty("responseRequired") String responseRequired,
                        @JsonProperty("timeExtensionRequested") String timeExtensionRequested,
                        @JsonProperty("bundleConfiguration") String bundleConfiguration,
                        @JsonProperty("pcqId") String pcqId,
                        @JsonProperty("writeFinalDecisionIsDescriptorFlow") String writeFinalDecisionIsDescriptorFlow,
                        @JsonProperty("writeFinalDecisionGenerateNotice") String writeFinalDecisionGenerateNotice,
                        @JsonProperty("writeFinalDecisionAllowedOrRefused") String writeFinalDecisionAllowedOrRefused,
                        @JsonProperty("writeFinalDecisionTypeOfHearing") String writeFinalDecisionTypeOfHearing,
                        @JsonProperty("writeFinalDecisionPresentingOfficerAttendedQuestion") String writeFinalDecisionPresentingOfficerAttendedQuestion,
                        @JsonProperty("writeFinalDecisionAppellantAttendedQuestion") String writeFinalDecisionAppellantAttendedQuestion,
                        @JsonProperty("pipWriteFinalDecisionDailyLivingQuestion") String pipWriteFinalDecisionDailyLivingQuestion,
                        @JsonProperty("pipWriteFinalDecisionComparedToDWPDailyLivingQuestion") String pipWriteFinalDecisionComparedToDwpDailyLivingQuestion,
                        @JsonProperty("pipWriteFinalDecisionMobilityQuestion") String pipWriteFinalDecisionMobilityQuestion,
                        @JsonProperty("pipWriteFinalDecisionComparedToDWPMobilityQuestion") String pipWriteFinalDecisionComparedToDwpMobilityQuestion,
                        @JsonProperty("writeFinalDecisionStartDate") String writeFinalDecisionStartDate,
                        @JsonProperty("writeFinalDecisionEndDateType") String writeFinalDecisionEndDateType,
                        @JsonProperty("writeFinalDecisionEndDate") String writeFinalDecisionEndDate,
                        @JsonProperty("writeFinalDecisionDisabilityQualifiedPanelMemberName") String writeFinalDecisionDisabilityQualifiedPanelMemberName,
                        @JsonProperty("writeFinalDecisionMedicallyQualifiedPanelMemberName") String writeFinalDecisionMedicallyQualifiedPanelMemberName,
                        @JsonProperty("writeFinalDecisionOtherPanelMemberName") String writeFinalDecisionOtherPanelMemberName,
                        @JsonProperty("writeFinalDecisionDateOfDecision") String writeFinalDecisionDateOfDecision,
                        @JsonProperty("writeFinalDecisionDetailsOfDecision") String writeFinalDecisionDetailsOfDecision,
                        @JsonProperty("writeFinalDecisionReasons") List<CollectionItem<String>> writeFinalDecisionReasons,
                        @JsonProperty("pipWriteFinalDecisionPreparingFoodQuestion") String pipWriteFinalDecisionPreparingFoodQuestion,
                        @JsonProperty("pipWriteFinalDecisionTakingNutritionQuestion") String pipWriteFinalDecisionTakingNutritionQuestion,
                        @JsonProperty("pipWriteFinalDecisionManagingTherapyQuestion") String pipWriteFinalDecisionManagingTherapyQuestion,
                        @JsonProperty("pipWriteFinalDecisionWashAndBatheQuestion") String pipWriteFinalDecisionWashAndBatheQuestion,
                        @JsonProperty("pipWriteFinalDecisionManagingToiletNeedsQuestion") String pipWriteFinalDecisionManagingToiletNeedsQuestion,
                        @JsonProperty("pipWriteFinalDecisionDressingAndUndressingQuestion") String pipWriteFinalDecisionDressingAndUndressingQuestion,
                        @JsonProperty("pipWriteFinalDecisionCommunicatingQuestion") String pipWriteFinalDecisionCommunicatingQuestion,
                        @JsonProperty("pipWriteFinalDecisionReadingUnderstandingQuestion") String pipWriteFinalDecisionReadingUnderstandingQuestion,
                        @JsonProperty("pipWriteFinalDecisionEngagingWithOthersQuestion") String pipWriteFinalDecisionEngagingWithOthersQuestion,
                        @JsonProperty("pipWriteFinalDecisionBudgetingDecisionsQuestion") String pipWriteFinalDecisionBudgetingDecisionsQuestion,
                        @JsonProperty("pipWriteFinalDecisionPlanningAndFollowingQuestion") String pipWriteFinalDecisionPlanningAndFollowingQuestion,
                        @JsonProperty("pipWriteFinalDecisionMovingAroundQuestion") String pipWriteFinalDecisionMovingAroundQuestion,
                        @JsonProperty("writeFinalDecisionPageSectionReference") String writeFinalDecisionPageSectionReference,
                        @JsonProperty("writeFinalDecisionAnythingElse") String writeFinalDecisionAnythingElse,
                        @JsonProperty("writeFinalDecisionPreviewDocument") DocumentLink writeFinalDecisionPreviewDocument,
                        @JsonProperty("writeFinalDecisionGeneratedDate") String writeFinalDecisionGeneratedDate,
                        @JsonProperty("adjournCaseGenerateNotice") String adjournCaseGenerateNotice,
                        @JsonProperty("adjournCaseTypeOfHearing") String adjournCaseTypeOfHearing,
                        @JsonProperty("adjournCaseCanCaseBeListedRightAway") String adjournCaseCanCaseBeListedRightAway,
                        @JsonProperty("adjournCaseAreDirectionsBeingMadeToParties") String adjournCaseAreDirectionsBeingMadeToParties,
                        @JsonProperty("adjournCaseDirectionsDueDateDaysOffset") String adjournCaseDirectionsDueDateDaysOffset,
                        @JsonProperty("adjournCaseDirectionsDueDate") String adjournCaseDirectionsDueDate,
                        @JsonProperty("adjournCaseTypeOfNextHearing") String adjournCaseTypeOfNextHearing,
                        @JsonProperty("adjournCaseNextHearingVenue") String adjournCaseNextHearingVenue,
                        @JsonProperty("adjournCaseNextHearingVenueSelected") DynamicList adjournCaseNextHearingVenueSelected,
                        @JsonProperty("adjournCasePanelMembersExcluded") String adjournCasePanelMembersExcluded,
                        @JsonProperty("adjournCaseDisabilityQualifiedPanelMemberName") String adjournCaseDisabilityQualifiedPanelMemberName,
                        @JsonProperty("adjournCaseMedicallyQualifiedPanelMemberName") String adjournCaseMedicallyQualifiedPanelMemberName,
                        @JsonProperty("adjournCaseOtherPanelMemberName") String adjournCaseOtherPanelMemberName,
                        @JsonProperty("adjournCaseNextHearingListingDurationType") String adjournCaseNextHearingListingDurationType,
                        @JsonProperty("adjournCaseNextHearingListingDuration") String adjournCaseNextHearingListingDuration,
                        @JsonProperty("adjournCaseNextHearingListingDurationUnits") String adjournCaseNextHearingListingDurationUnits,
                        @JsonProperty("adjournCaseInterpreterRequired") String adjournCaseInterpreterRequired,
                        @JsonProperty("adjournCaseInterpreterLanguage") String adjournCaseInterpreterLanguage,
                        @JsonProperty("adjournCaseNextHearingDateType") String adjournCaseNextHearingDateType,
                        @JsonProperty("adjournCaseNextHearingDateOrPeriod") String adjournCaseNextHearingDateOrPeriod,
                        @JsonProperty("adjournCaseNextHearingDateOrTime") String adjournCaseNextHearingDateOrTime,
                        @JsonProperty("adjournCaseNextHearingFirstAvailableDateAfterDate") String adjournCaseNextHearingFirstAvailableDateAfterDate,
                        @JsonProperty("adjournCaseNextHearingFirstAvailableDateAfterPeriod") String adjournCaseNextHearingFirstAvailableDateAfterPeriod,
                        @JsonProperty("adjournCaseTime") AdjournCaseTime adjournCaseTime,
                        @JsonProperty("adjournCaseReasons") List<CollectionItem<String>> adjournCaseReasons,
                        @JsonProperty("adjournCaseAdditionalDirections") List<CollectionItem<String>> adjournCaseAdditionalDirections,
                        @JsonProperty("adjournCasePreviewDocument") DocumentLink adjournCasePreviewDocument,
                        @JsonProperty("adjournCaseGeneratedDate") String adjournCaseGeneratedDate,
                        @JsonProperty("notListableProvideReasons") String notListableProvideReasons,
                        @JsonProperty("notListableDueDate") String notListableDueDate,
                        @JsonProperty("updateNotListableDirectionsFulfilled") String updateNotListableDirectionsFulfilled,
                        @JsonProperty("updateNotListableInterlocReview") String updateNotListableInterlocReview,
                        @JsonProperty("updateNotListableWhoReviewsCase") String updateNotListableWhoReviewsCase,
                        @JsonProperty("updateNotListableSetNewDueDate") String updateNotListableSetNewDueDate,
                        @JsonProperty("updateNotListableDueDate") String updateNotListableDueDate,
                        @JsonProperty("updateNotListableWhereShouldCaseMoveTo") String updateNotListableWhereShouldCaseMoveTo,
                        @JsonProperty("languagePreferenceWelsh") String languagePreferenceWelsh,
                        @JsonProperty("elementsDisputedList") List<String> elementsDisputedList,
                        @JsonProperty("elementsDisputedGeneral") List<ElementDisputed> elementsDisputedGeneral,
                        @JsonProperty("elementsDisputedSanctions") List<ElementDisputed> elementsDisputedSanctions,
                        @JsonProperty("elementsDisputedOverpayment") List<ElementDisputed> elementsDisputedOverpayment,
                        @JsonProperty("elementsDisputedHousing") List<ElementDisputed> elementsDisputedHousing,
                        @JsonProperty("elementsDisputedChildCare") List<ElementDisputed> elementsDisputedChildCare,
                        @JsonProperty("elementsDisputedCare") List<ElementDisputed> elementsDisputedCare,
                        @JsonProperty("elementsDisputedChildElement") List<ElementDisputed> elementsDisputedChildElement,
                        @JsonProperty("elementsDisputedChildDisabled") List<ElementDisputed> elementsDisputedChildDisabled,
                        @JsonProperty("elementsDisputedIsDecisionDisputedByOthers") String elementsDisputedIsDecisionDisputedByOthers,
                        @JsonProperty("elementsDisputedLinkedAppealRef") String elementsDisputedLinkedAppealRef,
                        @JsonProperty("jointParty") String jointParty,
                        @JsonProperty("jointPartyName") JointPartyName jointPartyName,
                        @JsonProperty("jointPartyIdentity") Identity jointPartyIdentity,
                        @JsonProperty("jointPartyAddressSameAsAppellant") String jointPartyAddressSameAsAppellant,
                        @JsonProperty("jointPartyAddress") Address jointPartyAddress,
                        @JsonProperty("translationWorkOutstanding") String translationWorkOutstanding,
                        @JsonProperty("sscsWelshDocuments") List<SscsWelshDocument> sscsWelshDocuments,
                        @JsonProperty("sscsWelshPreviewDocuments") List<SscsWelshDocument> sscsWelshPreviewDocuments,
                        @JsonProperty("sscsWelshPreviewNextEvent") String sscsWelshPreviewNextEvent,
                        @JsonProperty("originalDocuments") DynamicList originalDocuments,
                        @JsonProperty("originalNoticeDocuments") DynamicList originalNoticeDocuments,
                        @JsonProperty("documentTypes") DynamicList documentTypes,
                        @JsonProperty("welshBodyContent") String welshBodyContent,
                        @JsonProperty("englishBodyContent") String englishBodyContent,
                        @JsonProperty("isScottishCase") String isScottishCase,
                        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
                            @JsonSerialize(using = LocalDateSerializer.class)
                            @JsonProperty("reinstatementRegistered") LocalDate reinstatementRegistered,
                        @JsonProperty("reinstatementOutcome") RequestOutcome reinstatementOutcome,
                        @JsonProperty("welshInterlocNextReviewState") String welshInterlocNextReviewState,
                        @JsonProperty("confidentialityRequestOutcomeAppellant") DatedRequestOutcome confidentialityRequestOutcomeAppellant,
                        @JsonProperty("confidentialityRequestOutcomeJointParty") DatedRequestOutcome confidentialityRequestOutcomeJointParty,
                        @JsonProperty("confidentialityRequestAppellantGrantedOrRefused") String confidentialityRequestAppellantGrantedOrRefused,
                        @JsonProperty("confidentialityRequestJointPartyGrantedOrRefused") String confidentialityRequestJointPartyGrantedOrRefused,
                        @JsonProperty(value = "formType") FormType formType,
                        @JsonProperty("isProgressingViaGaps") String isProgressingViaGaps,
                        @JsonProperty("wcaAppeal") String wcaAppeal,
                        @JsonProperty("supportGroupOnlyAppeal") String supportGroupOnlyAppeal,
                        @JsonProperty("esaWriteFinalDecisionPhysicalDisabilitiesQuestion") List<String> esaWriteFinalDecisionPhysicalDisabilitiesQuestion,
                        @JsonProperty("esaWriteFinalDecisionMentalAssessmentQuestion") List<String> esaWriteFinalDecisionMentalAssessmentQuestion,
                        @JsonProperty("esaWriteFinalDecisionMobilisingUnaidedQuestion") String esaWriteFinalDecisionMobilisingUnaidedQuestion,
                        @JsonProperty("esaWriteFinalDecisionStandingAndSittingQuestion") String esaWriteFinalDecisionStandingAndSittingQuestion,
                        @JsonProperty("esaWriteFinalDecisionReachingQuestion") String esaWriteFinalDecisionReachingQuestion,
                        @JsonProperty("esaWriteFinalDecisionPickingUpQuestion") String esaWriteFinalDecisionPickingUpQuestion,
                        @JsonProperty("esaWriteFinalDecisionManualDexterityQuestion") String esaWriteFinalDecisionManualDexterityQuestion,
                        @JsonProperty("esaWriteFinalDecisionMakingSelfUnderstoodQuestion") String esaWriteFinalDecisionMakingSelfUnderstoodQuestion,
                        @JsonProperty("esaWriteFinalDecisionCommunicationQuestion") String esaWriteFinalDecisionCommunicationQuestion,
                        @JsonProperty("esaWriteFinalDecisionNavigationQuestion") String esaWriteFinalDecisionNavigationQuestion,
                        @JsonProperty("esaWriteFinalDecisionLossOfControlQuestion") String esaWriteFinalDecisionLossOfControlQuestion,
                        @JsonProperty("esaWriteFinalDecisionConsciousnessQuestion") String esaWriteFinalDecisionConsciousnessQuestion,
                        @JsonProperty("esaWriteFinalDecisionLearningTasksQuestion") String esaWriteFinalDecisionLearningTasksQuestion,
                        @JsonProperty("esaWriteFinalDecisionAwarenessOfHazardsQuestion") String esaWriteFinalDecisionAwarenessOfHazardsQuestion,
                        @JsonProperty("esaWriteFinalDecisionPersonalActionQuestion") String esaWriteFinalDecisionPersonalActionQuestion,
                        @JsonProperty("esaWriteFinalDecisionCopingWithChangeQuestion") String esaWriteFinalDecisionCopingWithChangeQuestion,
                        @JsonProperty("esaWriteFinalDecisionGettingAboutQuestion") String esaWriteFinalDecisionGettingAboutQuestion,
                        @JsonProperty("esaWriteFinalDecisionSocialEngagementQuestion") String esaWriteFinalDecisionSocialEngagementQuestion,
                        @JsonProperty("esaWriteFinalDecisionAppropriatenessOfBehaviourQuestion") String esaWriteFinalDecisionAppropriatenessOfBehaviourQuestion,
                        @JsonProperty("doesRegulation29Apply") YesNo doesRegulation29Apply,
                        @JsonProperty("showRegulation29Page") YesNo showRegulation29Page,
                        @JsonProperty("showSchedule3ActivitiesPage") YesNo showSchedule3ActivitiesPage,
                        @JsonProperty("esaWriteFinalDecisionSchedule3ActivitiesApply") String esaWriteFinalDecisionSchedule3ActivitiesApply,
                        @JsonProperty("esaWriteFinalDecisionSchedule3ActivitiesQuestion") List<String> esaWriteFinalDecisionSchedule3ActivitiesQuestion,
                        @JsonProperty("doesRegulation35Apply") YesNo doesRegulation35Apply,
                        @JsonProperty("showFinalDecisionNoticeSummaryOfOutcomePage") YesNo showFinalDecisionNoticeSummaryOfOutcomePage,
                        @JsonProperty("test1") String test1,
                        @JsonProperty("test2") String test2) {

        this.ccdCaseId = ccdCaseId;
        this.state = state;
        this.previousState = previousState;
        this.caseReference = caseReference;
        this.caseCreated = caseCreated;
        this.infoRequests = infoRequests;
        this.region = region;
        this.appeal = appeal;
        this.hearings = hearings;
        this.evidence = evidence;
        this.dwpTimeExtension = dwpTimeExtension;
        this.events = events;
        this.subscriptions = subscriptions;
        this.regionalProcessingCenter = regionalProcessingCenter;
        this.caseBundles = caseBundles;
        this.sscsDocument = sscsDocument;
        this.draftSscsDocument = draftSscsDocument;
        this.draftSscsFurtherEvidenceDocument = draftSscsFurtherEvidenceDocument;
        this.corDocument = corDocument;
        this.draftCorDocument = draftCorDocument;
        this.generatedNino = generatedNino;
        this.generatedSurname = generatedSurname;
        this.generatedEmail = generatedEmail;
        this.generatedMobile = generatedMobile;
        this.generatedDob = generatedDob;
        this.directionResponse = directionResponse;
        this.evidencePresent = evidencePresent;
        this.bulkScanCaseReference = bulkScanCaseReference;
        this.decisionNotes = decisionNotes;
        this.isCorDecision = isCorDecision;
        this.relistingReason = relistingReason;
        this.dateSentToDwp = dateSentToDwp;
        this.interlocReviewState = interlocReviewState;
        this.hmctsDwpState = hmctsDwpState;
        this.dwpFurtherEvidenceStates = dwpFurtherEvidenceStates;
        this.originalSender = originalSender;
        this.furtherEvidenceAction = furtherEvidenceAction;
        this.scannedDocuments = scannedDocuments;
        this.outcome = outcome;
        this.sscsInterlocDirectionDocument = sscsInterlocDirectionDocument;
        this.sscsInterlocDecisionDocument = sscsInterlocDecisionDocument;
        this.sscsStrikeOutDocument = sscsStrikeOutDocument;
        this.informationFromAppellant = informationFromAppellant;
        this.evidenceHandled = evidenceHandled;
        this.assignedToJudge = assignedToJudge;
        this.assignedToDisabilityMember = assignedToDisabilityMember;
        this.assignedToMedicalMember = assignedToMedicalMember;
        this.reissueFurtherEvidenceDocument = reissueFurtherEvidenceDocument;
        this.resendToAppellant = resendToAppellant;
        this.resendToRepresentative = resendToRepresentative;
        this.resendToDwp = resendToDwp;
        this.caseCode = caseCode;
        this.benefitCode = benefitCode;
        this.issueCode = issueCode;
        this.dwpOriginatingOffice = dwpOriginatingOffice;
        this.dwpPresentingOffice = dwpPresentingOffice;
        this.dwpIsOfficerAttending = dwpIsOfficerAttending;
        this.dwpUcb = dwpUcb;
        this.dwpPhme = dwpPhme;
        this.dwpComplexAppeal = dwpComplexAppeal;
        this.dwpFurtherInfo = dwpFurtherInfo;
        this.correspondence = correspondence;
        this.interlocReferralDate = interlocReferralDate;
        this.interlocReferralReason = interlocReferralReason;
        this.dwpRegionalCentre = dwpRegionalCentre;
        this.generateNotice = generateNotice;
        this.previewDocument = previewDocument;
        this.bodyContent = bodyContent;
        this.signedBy = signedBy;
        this.signedRole = signedRole;
        this.dateAdded = dateAdded;
        this.historicSscsInterlocDirectionDocs = historicSscsInterlocDirectionDocs;
        this.dwpState = dwpState;
        this.appealNotePad = appealNotePad;
        this.dwpStateFeNoAction = dwpStateFeNoAction;
        this.createdInGapsFrom = createdInGapsFrom;
        this.dateCaseSentToGaps = dateCaseSentToGaps;
        this.associatedCase = associatedCase;
        this.dwpAT38Document = dwpAT38Document;
        this.dwpEvidenceBundleDocument = dwpEvidenceBundleDocument;
        this.dwpResponseDocument = dwpResponseDocument;
        this.dwpSupplementaryResponseDoc = dwpSupplementaryResponseDoc;
        this.dwpOtherDoc = dwpOtherDoc;
        this.dwpLT203 = dwpLT203;
        this.dwpLapseLetter = dwpLapseLetter;
        this.dwpResponseDate = dwpResponseDate;
        this.linkedCasesBoolean = linkedCasesBoolean;
        this.decisionType = decisionType;
        this.selectWhoReviewsCase = selectWhoReviewsCase;
        this.directionType = directionType;
        this.directionTypeDl = directionTypeDl;
        this.extensionNextEvent = extensionNextEvent;
        this.extensionNextEventDl = extensionNextEventDl;
        this.tl1Form = tl1Form;
        this.isInterlocRequired = isInterlocRequired;
        this.panel = panel;
        this.evidenceReceived = evidenceReceived;
        this.urgentCase = urgentCase;
        this.urgentHearingRegistered = urgentHearingRegistered;
        this.urgentHearingOutcome = urgentHearingOutcome;
        this.documentSentToDwp = documentSentToDwp;
        this.directionDueDate = directionDueDate;
        this.reservedToJudge = reservedToJudge;
        this.linkedCase = linkedCase;
        this.isWaiverNeeded = isWaiverNeeded;
        this.waiverDeclaration = waiverDeclaration;
        this.waiverReason = waiverReason;
        this.waiverReasonOther = waiverReasonOther;
        this.clerkDelegatedAuthority = clerkDelegatedAuthority;
        this.clerkAppealSatisfactionText = clerkAppealSatisfactionText;
        this.clerkConfirmationOfMrn = clerkConfirmationOfMrn;
        this.clerkOtherReason = clerkOtherReason;
        this.clerkConfirmationOther = clerkConfirmationOther;
        this.responseRequired = responseRequired;
        this.timeExtensionRequested = timeExtensionRequested;
        this.bundleConfiguration = bundleConfiguration;
        this.pcqId = pcqId;
        this.writeFinalDecisionIsDescriptorFlow = writeFinalDecisionIsDescriptorFlow;
        this.writeFinalDecisionGenerateNotice = writeFinalDecisionGenerateNotice;
        this.writeFinalDecisionAllowedOrRefused = writeFinalDecisionAllowedOrRefused;
        this.writeFinalDecisionTypeOfHearing = writeFinalDecisionTypeOfHearing;
        this.writeFinalDecisionPresentingOfficerAttendedQuestion = writeFinalDecisionPresentingOfficerAttendedQuestion;
        this.writeFinalDecisionAppellantAttendedQuestion = writeFinalDecisionAppellantAttendedQuestion;
        this.pipWriteFinalDecisionDailyLivingQuestion = pipWriteFinalDecisionDailyLivingQuestion;
        this.pipWriteFinalDecisionComparedToDwpDailyLivingQuestion = pipWriteFinalDecisionComparedToDwpDailyLivingQuestion;
        this.pipWriteFinalDecisionMobilityQuestion = pipWriteFinalDecisionMobilityQuestion;
        this.pipWriteFinalDecisionComparedToDwpMobilityQuestion = pipWriteFinalDecisionComparedToDwpMobilityQuestion;
        this.writeFinalDecisionStartDate = writeFinalDecisionStartDate;
        this.writeFinalDecisionEndDateType = writeFinalDecisionEndDateType;
        this.writeFinalDecisionEndDate = writeFinalDecisionEndDate;
        this.writeFinalDecisionDisabilityQualifiedPanelMemberName = writeFinalDecisionDisabilityQualifiedPanelMemberName;
        this.writeFinalDecisionMedicallyQualifiedPanelMemberName = writeFinalDecisionMedicallyQualifiedPanelMemberName;
        this.writeFinalDecisionOtherPanelMemberName = writeFinalDecisionOtherPanelMemberName;
        this.writeFinalDecisionDateOfDecision = writeFinalDecisionDateOfDecision;
        this.writeFinalDecisionDetailsOfDecision = writeFinalDecisionDetailsOfDecision;
        this.writeFinalDecisionReasons = writeFinalDecisionReasons;
        this.pipWriteFinalDecisionDailyLivingActivitiesQuestion = pipWriteFinalDecisionDailyLivingActivitiesQuestion;
        this.pipWriteFinalDecisionMobilityActivitiesQuestion = pipWriteFinalDecisionMobilityActivitiesQuestion;
        this.pipWriteFinalDecisionPreparingFoodQuestion = pipWriteFinalDecisionPreparingFoodQuestion;
        this.pipWriteFinalDecisionTakingNutritionQuestion = pipWriteFinalDecisionTakingNutritionQuestion;
        this.pipWriteFinalDecisionManagingTherapyQuestion = pipWriteFinalDecisionManagingTherapyQuestion;
        this.pipWriteFinalDecisionWashAndBatheQuestion = pipWriteFinalDecisionWashAndBatheQuestion;
        this.pipWriteFinalDecisionManagingToiletNeedsQuestion = pipWriteFinalDecisionManagingToiletNeedsQuestion;
        this.pipWriteFinalDecisionDressingAndUndressingQuestion = pipWriteFinalDecisionDressingAndUndressingQuestion;
        this.pipWriteFinalDecisionCommunicatingQuestion = pipWriteFinalDecisionCommunicatingQuestion;
        this.pipWriteFinalDecisionReadingUnderstandingQuestion = pipWriteFinalDecisionReadingUnderstandingQuestion;
        this.pipWriteFinalDecisionEngagingWithOthersQuestion = pipWriteFinalDecisionEngagingWithOthersQuestion;
        this.pipWriteFinalDecisionBudgetingDecisionsQuestion = pipWriteFinalDecisionBudgetingDecisionsQuestion;
        this.pipWriteFinalDecisionPlanningAndFollowingQuestion = pipWriteFinalDecisionPlanningAndFollowingQuestion;
        this.pipWriteFinalDecisionMovingAroundQuestion = pipWriteFinalDecisionMovingAroundQuestion;
        this.writeFinalDecisionPageSectionReference = writeFinalDecisionPageSectionReference;
        this.writeFinalDecisionAnythingElse = writeFinalDecisionAnythingElse;
        this.writeFinalDecisionPreviewDocument = writeFinalDecisionPreviewDocument;
        this.writeFinalDecisionGeneratedDate = writeFinalDecisionGeneratedDate;
        this.adjournCaseGenerateNotice = adjournCaseGenerateNotice;
        this.adjournCaseTypeOfHearing = adjournCaseTypeOfHearing;
        this.adjournCaseCanCaseBeListedRightAway = adjournCaseCanCaseBeListedRightAway;
        this.adjournCaseAreDirectionsBeingMadeToParties = adjournCaseAreDirectionsBeingMadeToParties;
        this.adjournCaseDirectionsDueDateDaysOffset = adjournCaseDirectionsDueDateDaysOffset;
        this.adjournCaseDirectionsDueDate = adjournCaseDirectionsDueDate;
        this.adjournCaseTypeOfNextHearing = adjournCaseTypeOfNextHearing;
        this.adjournCaseNextHearingVenue = adjournCaseNextHearingVenue;
        this.adjournCaseNextHearingVenueSelected = adjournCaseNextHearingVenueSelected;
        this.adjournCasePanelMembersExcluded = adjournCasePanelMembersExcluded;
        this.adjournCaseDisabilityQualifiedPanelMemberName = adjournCaseDisabilityQualifiedPanelMemberName;
        this.adjournCaseMedicallyQualifiedPanelMemberName = adjournCaseMedicallyQualifiedPanelMemberName;
        this.adjournCaseOtherPanelMemberName = adjournCaseOtherPanelMemberName;
        this.adjournCaseNextHearingListingDurationType = adjournCaseNextHearingListingDurationType;
        this.adjournCaseNextHearingListingDuration = adjournCaseNextHearingListingDuration;
        this.adjournCaseNextHearingListingDurationUnits = adjournCaseNextHearingListingDurationUnits;
        this.adjournCaseInterpreterRequired = adjournCaseInterpreterRequired;
        this.adjournCaseInterpreterLanguage = adjournCaseInterpreterLanguage;
        this.adjournCaseNextHearingDateType = adjournCaseNextHearingDateType;
        this.adjournCaseNextHearingDateOrPeriod = adjournCaseNextHearingDateOrPeriod;
        this.adjournCaseNextHearingDateOrTime = adjournCaseNextHearingDateOrTime;
        this.adjournCaseNextHearingFirstAvailableDateAfterDate = adjournCaseNextHearingFirstAvailableDateAfterDate;
        this.adjournCaseNextHearingFirstAvailableDateAfterPeriod = adjournCaseNextHearingFirstAvailableDateAfterPeriod;
        this.adjournCaseTime = adjournCaseTime;
        this.adjournCaseReasons = adjournCaseReasons;
        this.adjournCaseAdditionalDirections = adjournCaseAdditionalDirections;
        this.adjournCasePreviewDocument = adjournCasePreviewDocument;
        this.adjournCaseGeneratedDate = adjournCaseGeneratedDate;
        this.notListableProvideReasons = notListableProvideReasons;
        this.notListableDueDate = notListableDueDate;
        this.updateNotListableDirectionsFulfilled = updateNotListableDirectionsFulfilled;
        this.updateNotListableInterlocReview = updateNotListableInterlocReview;
        this.updateNotListableWhoReviewsCase = updateNotListableWhoReviewsCase;
        this.updateNotListableSetNewDueDate = updateNotListableSetNewDueDate;
        this.updateNotListableDueDate = updateNotListableDueDate;
        this.updateNotListableWhereShouldCaseMoveTo = updateNotListableWhereShouldCaseMoveTo;
        this.languagePreferenceWelsh = languagePreferenceWelsh;
        this.elementsDisputedList = elementsDisputedList;
        this.elementsDisputedGeneral = elementsDisputedGeneral;
        this.elementsDisputedSanctions = elementsDisputedSanctions;
        this.elementsDisputedOverpayment = elementsDisputedOverpayment;
        this.elementsDisputedHousing = elementsDisputedHousing;
        this.elementsDisputedChildCare = elementsDisputedChildCare;
        this.elementsDisputedCare = elementsDisputedCare;
        this.elementsDisputedChildElement = elementsDisputedChildElement;
        this.elementsDisputedChildDisabled = elementsDisputedChildDisabled;
        this.elementsDisputedIsDecisionDisputedByOthers = elementsDisputedIsDecisionDisputedByOthers;
        this.elementsDisputedLinkedAppealRef = elementsDisputedLinkedAppealRef;
        this.jointParty = jointParty;
        this.jointPartyName = jointPartyName;
        this.jointPartyIdentity = jointPartyIdentity;
        this.jointPartyAddressSameAsAppellant = jointPartyAddressSameAsAppellant;
        this.jointPartyAddress = jointPartyAddress;
        this.translationWorkOutstanding = translationWorkOutstanding;
        this.sscsWelshDocuments = sscsWelshDocuments;
        this.sscsWelshPreviewDocuments = sscsWelshPreviewDocuments;
        this.sscsWelshPreviewNextEvent = sscsWelshPreviewNextEvent;
        this.originalDocuments = originalDocuments;
        this.originalNoticeDocuments = originalNoticeDocuments;
        this.documentTypes = documentTypes;
        this.welshBodyContent = welshBodyContent;
        this.englishBodyContent = englishBodyContent;
        this.isScottishCase = isScottishCase;
        this.reinstatementRegistered = reinstatementRegistered;
        this.reinstatementOutcome = reinstatementOutcome;
        this.welshInterlocNextReviewState = welshInterlocNextReviewState;
        this.confidentialityRequestOutcomeAppellant = confidentialityRequestOutcomeAppellant;
        this.confidentialityRequestOutcomeJointParty = confidentialityRequestOutcomeJointParty;
        this.confidentialityRequestAppellantGrantedOrRefused = confidentialityRequestAppellantGrantedOrRefused;
        this.confidentialityRequestJointPartyGrantedOrRefused =  confidentialityRequestJointPartyGrantedOrRefused;
        this.formType = formType;
        this.isProgressingViaGaps =  isProgressingViaGaps;
        this.wcaAppeal = wcaAppeal;
        this.supportGroupOnlyAppeal = supportGroupOnlyAppeal;
        this.esaWriteFinalDecisionPhysicalDisabilitiesQuestion = esaWriteFinalDecisionPhysicalDisabilitiesQuestion;
        this.esaWriteFinalDecisionMentalAssessmentQuestion = esaWriteFinalDecisionMentalAssessmentQuestion;
        this.esaWriteFinalDecisionMobilisingUnaidedQuestion = esaWriteFinalDecisionMobilisingUnaidedQuestion;
        this.esaWriteFinalDecisionStandingAndSittingQuestion = esaWriteFinalDecisionStandingAndSittingQuestion;
        this.esaWriteFinalDecisionReachingQuestion = esaWriteFinalDecisionReachingQuestion;
        this.esaWriteFinalDecisionPickingUpQuestion = esaWriteFinalDecisionPickingUpQuestion;
        this.esaWriteFinalDecisionManualDexterityQuestion = esaWriteFinalDecisionManualDexterityQuestion;
        this.esaWriteFinalDecisionMakingSelfUnderstoodQuestion = esaWriteFinalDecisionMakingSelfUnderstoodQuestion;
        this.esaWriteFinalDecisionCommunicationQuestion = esaWriteFinalDecisionCommunicationQuestion;
        this.esaWriteFinalDecisionNavigationQuestion = esaWriteFinalDecisionNavigationQuestion;
        this.esaWriteFinalDecisionLossOfControlQuestion = esaWriteFinalDecisionLossOfControlQuestion;
        this.esaWriteFinalDecisionConsciousnessQuestion = esaWriteFinalDecisionConsciousnessQuestion;
        this.esaWriteFinalDecisionLearningTasksQuestion = esaWriteFinalDecisionLearningTasksQuestion;
        this.esaWriteFinalDecisionAwarenessOfHazardsQuestion = esaWriteFinalDecisionAwarenessOfHazardsQuestion;
        this.esaWriteFinalDecisionPersonalActionQuestion = esaWriteFinalDecisionPersonalActionQuestion;
        this.esaWriteFinalDecisionCopingWithChangeQuestion = esaWriteFinalDecisionCopingWithChangeQuestion;
        this.esaWriteFinalDecisionGettingAboutQuestion = esaWriteFinalDecisionGettingAboutQuestion;
        this.esaWriteFinalDecisionSocialEngagementQuestion = esaWriteFinalDecisionSocialEngagementQuestion;
        this.esaWriteFinalDecisionAppropriatenessOfBehaviourQuestion = esaWriteFinalDecisionAppropriatenessOfBehaviourQuestion;
        this.doesRegulation29Apply = doesRegulation29Apply;
        this.showRegulation29Page = showRegulation29Page;
        this.showSchedule3ActivitiesPage = showSchedule3ActivitiesPage;
        this.esaWriteFinalDecisionSchedule3ActivitiesApply = esaWriteFinalDecisionSchedule3ActivitiesApply;
        this.esaWriteFinalDecisionSchedule3ActivitiesQuestion = esaWriteFinalDecisionSchedule3ActivitiesQuestion;
        this.doesRegulation35Apply = doesRegulation35Apply;
        this.showFinalDecisionNoticeSummaryOfOutcomePage = showFinalDecisionNoticeSummaryOfOutcomePage;
        this.test1 = test1;
        this.test2 = test2;
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
    public boolean isLanguagePreferenceWelsh() {
        return stringToBoolean(languagePreferenceWelsh);
    }

    @JsonIgnore
    public LanguagePreference getLanguagePreference() {
        return isLanguagePreferenceWelsh() ? LanguagePreference.WELSH : LanguagePreference.ENGLISH;
    }

    @JsonIgnore
    public boolean isTranslationWorkOutstanding() {
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
        if (getSscsDocument().stream().noneMatch(sd -> Arrays.asList(SscsDocumentTranslationStatus.TRANSLATION_REQUESTED, SscsDocumentTranslationStatus.TRANSLATION_REQUIRED).contains(sd.getValue().getDocumentTranslationStatus()))) {
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

    public String getCcdCaseId() {
        return ccdCaseId;
    }

    public void setCcdCaseId(String ccdCaseId) {
        this.ccdCaseId = ccdCaseId;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getPreviousState() {
        return previousState;
    }

    public void setPreviousState(State previousState) {
        this.previousState = previousState;
    }

    public String getCaseReference() {
        return caseReference;
    }

    public void setCaseReference(String caseReference) {
        this.caseReference = caseReference;
    }

    public String getCaseCreated() {
        return caseCreated;
    }

    public void setCaseCreated(String caseCreated) {
        this.caseCreated = caseCreated;
    }

    public InfoRequests getInfoRequests() {
        return infoRequests;
    }

    public void setInfoRequests(InfoRequests infoRequests) {
        this.infoRequests = infoRequests;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Appeal getAppeal() {
        return appeal;
    }

    public void setAppeal(Appeal appeal) {
        this.appeal = appeal;
    }

    public List<Hearing> getHearings() {
        return hearings;
    }

    public void setHearings(List<Hearing> hearings) {
        this.hearings = hearings;
    }

    public Evidence getEvidence() {
        return evidence;
    }

    public void setEvidence(Evidence evidence) {
        this.evidence = evidence;
    }

    public List<DwpTimeExtension> getDwpTimeExtension() {
        return dwpTimeExtension;
    }

    public void setDwpTimeExtension(List<DwpTimeExtension> dwpTimeExtension) {
        this.dwpTimeExtension = dwpTimeExtension;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public void setSubscriptions(Subscriptions subscriptions) {
        this.subscriptions = subscriptions;
    }

    public RegionalProcessingCenter getRegionalProcessingCenter() {
        return regionalProcessingCenter;
    }

    public void setRegionalProcessingCenter(RegionalProcessingCenter regionalProcessingCenter) {
        this.regionalProcessingCenter = regionalProcessingCenter;
    }

    public List<Bundle> getCaseBundles() {
        return caseBundles;
    }

    public void setCaseBundles(List<Bundle> caseBundles) {
        this.caseBundles = caseBundles;
    }

    public List<SscsDocument> getSscsDocument() {
        return sscsDocument;
    }

    public void setSscsDocument(List<SscsDocument> sscsDocument) {
        this.sscsDocument = sscsDocument;
    }

    public List<SscsDocument> getDraftSscsDocument() {
        return draftSscsDocument;
    }

    public void setDraftSscsDocument(List<SscsDocument> draftSscsDocument) {
        this.draftSscsDocument = draftSscsDocument;
    }

    public List<SscsFurtherEvidenceDoc> getDraftSscsFurtherEvidenceDocument() {
        return draftSscsFurtherEvidenceDocument;
    }

    public void setDraftSscsFurtherEvidenceDocument(List<SscsFurtherEvidenceDoc> draftSscsFurtherEvidenceDocument) {
        this.draftSscsFurtherEvidenceDocument = draftSscsFurtherEvidenceDocument;
    }

    public List<CorDocument> getCorDocument() {
        return corDocument;
    }

    public void setCorDocument(List<CorDocument> corDocument) {
        this.corDocument = corDocument;
    }

    public List<CorDocument> getDraftCorDocument() {
        return draftCorDocument;
    }

    public void setDraftCorDocument(List<CorDocument> draftCorDocument) {
        this.draftCorDocument = draftCorDocument;
    }

    public SscsInterlocDecisionDocument getSscsInterlocDecisionDocument() {
        return sscsInterlocDecisionDocument;
    }

    public void setSscsInterlocDecisionDocument(SscsInterlocDecisionDocument sscsInterlocDecisionDocument) {
        this.sscsInterlocDecisionDocument = sscsInterlocDecisionDocument;
    }

    public SscsInterlocDirectionDocument getSscsInterlocDirectionDocument() {
        return sscsInterlocDirectionDocument;
    }

    public void setSscsInterlocDirectionDocument(SscsInterlocDirectionDocument sscsInterlocDirectionDocument) {
        this.sscsInterlocDirectionDocument = sscsInterlocDirectionDocument;
    }

    public SscsStrikeOutDocument getSscsStrikeOutDocument() {
        return sscsStrikeOutDocument;
    }

    public void setSscsStrikeOutDocument(SscsStrikeOutDocument sscsStrikeOutDocument) {
        this.sscsStrikeOutDocument = sscsStrikeOutDocument;
    }

    public String getGeneratedNino() {
        return generatedNino;
    }

    public void setGeneratedNino(String generatedNino) {
        this.generatedNino = generatedNino;
    }

    public String getGeneratedSurname() {
        return generatedSurname;
    }

    public void setGeneratedSurname(String generatedSurname) {
        this.generatedSurname = generatedSurname;
    }

    public String getGeneratedEmail() {
        return generatedEmail;
    }

    public void setGeneratedEmail(String generatedEmail) {
        this.generatedEmail = generatedEmail;
    }

    public String getGeneratedMobile() {
        return generatedMobile;
    }

    public void setGeneratedMobile(String generatedMobile) {
        this.generatedMobile = generatedMobile;
    }

    public String getGeneratedDob() {
        return generatedDob;
    }

    public void setGeneratedDob(String generatedDob) {
        this.generatedDob = generatedDob;
    }

    public DirectionResponse getDirectionResponse() {
        return directionResponse;
    }

    public void setDirectionResponse(DirectionResponse directionResponse) {
        this.directionResponse = directionResponse;
    }

    public String getEvidencePresent() {
        return evidencePresent;
    }

    public void setEvidencePresent(String evidencePresent) {
        this.evidencePresent = evidencePresent;
    }

    public String getBulkScanCaseReference() {
        return bulkScanCaseReference;
    }

    public void setBulkScanCaseReference(String bulkScanCaseReference) {
        this.bulkScanCaseReference = bulkScanCaseReference;
    }

    public String getDecisionNotes() {
        return decisionNotes;
    }

    public void setDecisionNotes(String decisionNotes) {
        this.decisionNotes = decisionNotes;
    }

    public String getIsCorDecision() {
        return isCorDecision;
    }

    public void setIsCorDecision(String isCorDecision) {
        this.isCorDecision = isCorDecision;
    }

    public String getRelistingReason() {
        return relistingReason;
    }

    public void setRelistingReason(String relistingReason) {
        this.relistingReason = relistingReason;
    }

    public String getDateSentToDwp() {
        return dateSentToDwp;
    }

    public void setDateSentToDwp(String dateSentToDwp) {
        this.dateSentToDwp = dateSentToDwp;
    }

    public String getInterlocReviewState() {
        return interlocReviewState;
    }

    public void setInterlocReviewState(String interlocReviewState) {
        this.interlocReviewState = interlocReviewState;
    }

    public String getHmctsDwpState() {
        return hmctsDwpState;
    }

    public void setHmctsDwpState(String hmctsDwpState) {
        this.hmctsDwpState = hmctsDwpState;
    }

    public String getDwpFurtherEvidenceStates() {
        return dwpFurtherEvidenceStates;
    }

    public void setDwpFurtherEvidenceStates(String dwpFurtherEvidenceStates) {
        this.dwpFurtherEvidenceStates = dwpFurtherEvidenceStates;
    }

    public DynamicList getOriginalSender() {
        return originalSender;
    }

    public void setOriginalSender(DynamicList originalSender) {
        this.originalSender = originalSender;
    }

    public DynamicList getFurtherEvidenceAction() {
        return furtherEvidenceAction;
    }

    public void setFurtherEvidenceAction(DynamicList furtherEvidenceAction) {
        this.furtherEvidenceAction = furtherEvidenceAction;
    }

    public List<ScannedDocument> getScannedDocuments() {
        return scannedDocuments;
    }

    public void setScannedDocuments(List<ScannedDocument> scannedDocuments) {
        this.scannedDocuments = scannedDocuments;
    }

    public String getInformationFromAppellant() {
        return informationFromAppellant;
    }

    public void setInformationFromAppellant(String informationFromAppellant) {
        this.informationFromAppellant = informationFromAppellant;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public String getEvidenceHandled() {
        return evidenceHandled;
    }

    public void setEvidenceHandled(String evidenceHandled) {
        this.evidenceHandled = evidenceHandled;
    }

    public String getAssignedToJudge() {
        return assignedToJudge;
    }

    public void setAssignedToJudge(String assignedToJudge) {
        this.assignedToJudge = assignedToJudge;
    }

    public String getAssignedToDisabilityMember() {
        return assignedToDisabilityMember;
    }

    public void setAssignedToDisabilityMember(String assignedToDisabilityMember) {
        this.assignedToDisabilityMember = assignedToDisabilityMember;
    }

    public String getAssignedToMedicalMember() {
        return assignedToMedicalMember;
    }

    public void setAssignedToMedicalMember(String assignedToMedicalMember) {
        this.assignedToMedicalMember = assignedToMedicalMember;
    }

    public DynamicList getReissueFurtherEvidenceDocument() {
        return reissueFurtherEvidenceDocument;
    }

    public void setReissueFurtherEvidenceDocument(DynamicList reissueFurtherEvidenceDocument) {
        this.reissueFurtherEvidenceDocument = reissueFurtherEvidenceDocument;
    }

    public String getResendToAppellant() {
        return resendToAppellant;
    }

    public void setResendToAppellant(String resendToAppellant) {
        this.resendToAppellant = resendToAppellant;
    }

    public String getResendToRepresentative() {
        return resendToRepresentative;
    }

    public void setResendToRepresentative(String resendToRepresentative) {
        this.resendToRepresentative = resendToRepresentative;
    }

    public String getResendToDwp() {
        return resendToDwp;
    }

    public void setResendToDwp(String resendToDwp) {
        this.resendToDwp = resendToDwp;
    }

    public String getCaseCode() {
        return caseCode;
    }

    public void setCaseCode(String caseCode) {
        this.caseCode = caseCode;
    }

    public String getBenefitCode() {
        return benefitCode;
    }

    public void setBenefitCode(String benefitCode) {
        this.benefitCode = benefitCode;
    }

    public String getIssueCode() {
        return issueCode;
    }

    public void setIssueCode(String issueCode) {
        this.issueCode = issueCode;
    }

    public DynamicList getDwpOriginatingOffice() {
        return dwpOriginatingOffice;
    }

    public void setDwpOriginatingOffice(DynamicList dwpOriginatingOffice) {
        this.dwpOriginatingOffice = dwpOriginatingOffice;
    }

    public DynamicList getDwpPresentingOffice() {
        return dwpPresentingOffice;
    }

    public void setDwpPresentingOffice(DynamicList dwpPresentingOffice) {
        this.dwpPresentingOffice = dwpPresentingOffice;
    }

    public String getDwpIsOfficerAttending() {
        return dwpIsOfficerAttending;
    }

    public void setDwpIsOfficerAttending(String dwpIsOfficerAttending) {
        this.dwpIsOfficerAttending = dwpIsOfficerAttending;
    }

    public String getDwpUcb() {
        return dwpUcb;
    }

    public void setDwpUcb(String dwpUcb) {
        this.dwpUcb = dwpUcb;
    }

    public String getDwpPhme() {
        return dwpPhme;
    }

    public void setDwpPhme(String dwpPhme) {
        this.dwpPhme = dwpPhme;
    }

    public String getDwpComplexAppeal() {
        return dwpComplexAppeal;
    }

    public void setDwpComplexAppeal(String dwpComplexAppeal) {
        this.dwpComplexAppeal = dwpComplexAppeal;
    }

    public String getDwpFurtherInfo() {
        return dwpFurtherInfo;
    }

    public void setDwpFurtherInfo(String dwpFurtherInfo) {
        this.dwpFurtherInfo = dwpFurtherInfo;
    }

    public List<Correspondence> getCorrespondence() {
        return correspondence;
    }

    public void setCorrespondence(List<Correspondence> correspondence) {
        this.correspondence = correspondence;
    }

    public String getInterlocReferralDate() {
        return interlocReferralDate;
    }

    public void setInterlocReferralDate(String interlocReferralDate) {
        this.interlocReferralDate = interlocReferralDate;
    }

    public String getInterlocReferralReason() {
        return interlocReferralReason;
    }

    public void setInterlocReferralReason(String interlocReferralReason) {
        this.interlocReferralReason = interlocReferralReason;
    }

    public String getDwpRegionalCentre() {
        return dwpRegionalCentre;
    }

    public void setDwpRegionalCentre(String dwpRegionalCentre) {
        this.dwpRegionalCentre = dwpRegionalCentre;
    }

    public String getGenerateNotice() {
        return generateNotice;
    }

    public void setGenerateNotice(String generateNotice) {
        this.generateNotice = generateNotice;
    }

    public DocumentLink getPreviewDocument() {
        return previewDocument;
    }

    public void setPreviewDocument(DocumentLink previewDocument) {
        this.previewDocument = previewDocument;
    }

    public String getBodyContent() {
        return bodyContent;
    }

    public void setBodyContent(String bodyContent) {
        this.bodyContent = bodyContent;
    }

    public String getSignedBy() {
        return signedBy;
    }

    public void setSignedBy(String signedBy) {
        this.signedBy = signedBy;
    }

    public String getSignedRole() {
        return signedRole;
    }

    public void setSignedRole(String signedRole) {
        this.signedRole = signedRole;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }

    public List<SscsInterlocDirectionDocuments> getHistoricSscsInterlocDirectionDocs() {
        return historicSscsInterlocDirectionDocs;
    }

    public void setHistoricSscsInterlocDirectionDocs(List<SscsInterlocDirectionDocuments> historicSscsInterlocDirectionDocs) {
        this.historicSscsInterlocDirectionDocs = historicSscsInterlocDirectionDocs;
    }

    public String getDwpState() {
        return dwpState;
    }

    public void setDwpState(String dwpState) {
        this.dwpState = dwpState;
    }

    public NotePad getAppealNotePad() {
        return appealNotePad;
    }

    public void setAppealNotePad(NotePad appealNotePad) {
        this.appealNotePad = appealNotePad;
    }

    public DynamicList getDwpStateFeNoAction() {
        return dwpStateFeNoAction;
    }

    public void setDwpStateFeNoAction(DynamicList dwpStateFeNoAction) {
        this.dwpStateFeNoAction = dwpStateFeNoAction;
    }

    public String getCreatedInGapsFrom() {
        return createdInGapsFrom;
    }

    public void setCreatedInGapsFrom(String createdInGapsFrom) {
        this.createdInGapsFrom = createdInGapsFrom;
    }

    public String getDateCaseSentToGaps() {
        return dateCaseSentToGaps;
    }

    public void setDateCaseSentToGaps(String dateCaseSentToGaps) {
        this.dateCaseSentToGaps = dateCaseSentToGaps;
    }

    public List<CaseLink> getAssociatedCase() {
        return associatedCase;
    }

    public void setAssociatedCase(List<CaseLink> associatedCase) {
        this.associatedCase = associatedCase;
    }

    public DwpResponseDocument getDwpAT38Document() {
        return dwpAT38Document;
    }

    public void setDwpAT38Document(DwpResponseDocument dwpAT38Document) {
        this.dwpAT38Document = dwpAT38Document;
    }

    public DwpResponseDocument getDwpEvidenceBundleDocument() {
        return dwpEvidenceBundleDocument;
    }

    public void setDwpEvidenceBundleDocument(DwpResponseDocument dwpEvidenceBundleDocument) {
        this.dwpEvidenceBundleDocument = dwpEvidenceBundleDocument;
    }

    public DwpResponseDocument getDwpResponseDocument() {
        return dwpResponseDocument;
    }

    public void setDwpResponseDocument(DwpResponseDocument dwpResponseDocument) {
        this.dwpResponseDocument = dwpResponseDocument;
    }

    public DwpResponseDocument getDwpSupplementaryResponseDoc() {
        return dwpSupplementaryResponseDoc;
    }

    public void setDwpSupplementaryResponseDoc(DwpResponseDocument dwpSupplementaryResponseDoc) {
        this.dwpSupplementaryResponseDoc = dwpSupplementaryResponseDoc;
    }

    public DwpResponseDocument getDwpOtherDoc() {
        return dwpOtherDoc;
    }

    public void setDwpOtherDoc(DwpResponseDocument dwpOtherDoc) {
        this.dwpOtherDoc = dwpOtherDoc;
    }

    public DwpLT203 getDwpLT203() {
        return dwpLT203;
    }

    public void setDwpLT203(DwpLT203 dwpLT203) {
        this.dwpLT203 = dwpLT203;
    }

    public DwpLapseLetter getDwpLapseLetter() {
        return dwpLapseLetter;
    }

    public void setDwpLapseLetter(DwpLapseLetter dwpLapseLetter) {
        this.dwpLapseLetter = dwpLapseLetter;
    }

    public String getDwpResponseDate() {
        return dwpResponseDate;
    }

    public void setDwpResponseDate(String dwpResponseDate) {
        this.dwpResponseDate = dwpResponseDate;
    }

    public String getLinkedCasesBoolean() {
        return linkedCasesBoolean;
    }

    public void setLinkedCasesBoolean(String linkedCasesBoolean) {
        this.linkedCasesBoolean = linkedCasesBoolean;
    }

    public String getDecisionType() {
        return decisionType;
    }

    public void setDecisionType(String decisionType) {
        this.decisionType = decisionType;
    }

    public DynamicList getSelectWhoReviewsCase() {
        return selectWhoReviewsCase;
    }

    public void setSelectWhoReviewsCase(DynamicList selectWhoReviewsCase) {
        this.selectWhoReviewsCase = selectWhoReviewsCase;
    }

    public DirectionType getDirectionType() {
        return directionType;
    }

    public void setDirectionType(DirectionType directionType) {
        this.directionType = directionType;
    }

    public DynamicList getDirectionTypeDl() {
        return directionTypeDl;
    }

    public void setDirectionTypeDl(DynamicList directionTypeDl) {
        this.directionTypeDl = directionTypeDl;
    }

    public ExtensionNextEvent getExtensionNextEvent() {
        return extensionNextEvent;
    }

    public void setExtensionNextEvent(ExtensionNextEvent extensionNextEvent) {
        this.extensionNextEvent = extensionNextEvent;
    }

    public DynamicList getExtensionNextEventDl() {
        return extensionNextEventDl;
    }

    public void setExtensionNextEventDl(DynamicList extensionNextEventDl) {
        this.extensionNextEventDl = extensionNextEventDl;
    }

    public DwpResponseDocument getTl1Form() {
        return tl1Form;
    }

    public void setTl1Form(DwpResponseDocument tl1Form) {
        this.tl1Form = tl1Form;
    }

    public String getIsInterlocRequired() {
        return isInterlocRequired;
    }

    public void setIsInterlocRequired(String isInterlocRequired) {
        this.isInterlocRequired = isInterlocRequired;
    }

    public Panel getPanel() {
        return panel;
    }

    public void setPanel(Panel panel) {
        this.panel = panel;
    }

    public EvidenceReceived getEvidenceReceived() {
        return evidenceReceived;
    }

    public void setEvidenceReceived(EvidenceReceived evidenceReceived) {
        this.evidenceReceived = evidenceReceived;
    }

    public String getUrgentCase() {
        return urgentCase;
    }

    public void setUrgentCase(String urgentCase) {
        this.urgentCase = urgentCase;
    }

    public String getUrgentHearingRegistered() {
        return urgentHearingRegistered;
    }

    public void setUrgentHearingRegistered(String urgentHearingRegistered) {
        this.urgentHearingRegistered = urgentHearingRegistered;
    }

    public String getUrgentHearingOutcome() {
        return urgentHearingOutcome;
    }

    public void setUrgentHearingOutcome(String urgentHearingOutcome) {
        this.urgentHearingOutcome = urgentHearingOutcome;
    }

    public String getDocumentSentToDwp() {
        return documentSentToDwp;
    }

    public void setDocumentSentToDwp(String documentSentToDwp) {
        this.documentSentToDwp = documentSentToDwp;
    }

    public String getDirectionDueDate() {
        return directionDueDate;
    }

    public void setDirectionDueDate(String directionDueDate) {
        this.directionDueDate = directionDueDate;
    }

    public String getReservedToJudge() {
        return reservedToJudge;
    }

    public void setReservedToJudge(String reservedToJudge) {
        this.reservedToJudge = reservedToJudge;
    }

    public List<CaseLink> getLinkedCase() {
        return linkedCase;
    }

    public void setLinkedCase(List<CaseLink> linkedCase) {
        this.linkedCase = linkedCase;
    }

    public String getIsWaiverNeeded() {
        return isWaiverNeeded;
    }

    public void setIsWaiverNeeded(String isWaiverNeeded) {
        this.isWaiverNeeded = isWaiverNeeded;
    }

    public List<String> getWaiverDeclaration() {
        return waiverDeclaration;
    }

    public void setWaiverDeclaration(List<String> waiverDeclaration) {
        this.waiverDeclaration = waiverDeclaration;
    }

    public List<String> getWaiverReason() {
        return waiverReason;
    }

    public void setWaiverReason(List<String> waiverReason) {
        this.waiverReason = waiverReason;
    }

    public String getWaiverReasonOther() {
        return waiverReasonOther;
    }

    public void setWaiverReasonOther(String waiverReasonOther) {
        this.waiverReasonOther = waiverReasonOther;
    }

    public List<String> getClerkDelegatedAuthority() {
        return clerkDelegatedAuthority;
    }

    public void setClerkDelegatedAuthority(List<String> clerkDelegatedAuthority) {
        this.clerkDelegatedAuthority = clerkDelegatedAuthority;
    }

    public List<String> getClerkAppealSatisfactionText() {
        return clerkAppealSatisfactionText;
    }

    public void setClerkAppealSatisfactionText(List<String> clerkAppealSatisfactionText) {
        this.clerkAppealSatisfactionText = clerkAppealSatisfactionText;
    }

    public List<String> getPipWriteFinalDecisionDailyLivingActivitiesQuestion() {
        return pipWriteFinalDecisionDailyLivingActivitiesQuestion;
    }

    public void setPipWriteFinalDecisionDailyLivingActivitiesQuestion(List<String> pipWriteFinalDecisionDailyLivingActivitiesQuestion) {
        this.pipWriteFinalDecisionDailyLivingActivitiesQuestion = pipWriteFinalDecisionDailyLivingActivitiesQuestion;
    }

    public List<String> getPipWriteFinalDecisionMobilityActivitiesQuestion() {
        return pipWriteFinalDecisionMobilityActivitiesQuestion;
    }

    public void setPipWriteFinalDecisionMobilityActivitiesQuestion(List<String> pipWriteFinalDecisionMobilityActivitiesQuestion) {
        this.pipWriteFinalDecisionMobilityActivitiesQuestion = pipWriteFinalDecisionMobilityActivitiesQuestion;
    }

    public String getClerkConfirmationOfMrn() {
        return clerkConfirmationOfMrn;
    }

    public void setClerkConfirmationOfMrn(String clerkConfirmationOfMrn) {
        this.clerkConfirmationOfMrn = clerkConfirmationOfMrn;
    }

    public String getClerkOtherReason() {
        return clerkOtherReason;
    }

    public void setClerkOtherReason(String clerkOtherReason) {
        this.clerkOtherReason = clerkOtherReason;
    }

    public String getClerkConfirmationOther() {
        return clerkConfirmationOther;
    }

    public void setClerkConfirmationOther(String clerkConfirmationOther) {
        this.clerkConfirmationOther = clerkConfirmationOther;
    }

    public String getResponseRequired() {
        return responseRequired;
    }

    public void setResponseRequired(String responseRequired) {
        this.responseRequired = responseRequired;
    }

    public String getTimeExtensionRequested() {
        return timeExtensionRequested;
    }

    public void setTimeExtensionRequested(String timeExtensionRequested) {
        this.timeExtensionRequested = timeExtensionRequested;
    }

    public String getBundleConfiguration() {
        return bundleConfiguration;
    }

    public void setBundleConfiguration(String bundleConfiguration) {
        this.bundleConfiguration = bundleConfiguration;
    }

    public String getPcqId() {
        return pcqId;
    }

    public void setPcqId(String pcqId) {
        this.pcqId = pcqId;
    }

    public String getWriteFinalDecisionIsDescriptorFlow() {
        return writeFinalDecisionIsDescriptorFlow;
    }

    public void setWriteFinalDecisionIsDescriptorFlow(String writeFinalDecisionIsDescriptorFlow) {
        this.writeFinalDecisionIsDescriptorFlow = writeFinalDecisionIsDescriptorFlow;
    }

    public String getWriteFinalDecisionGenerateNotice() {
        return writeFinalDecisionGenerateNotice;
    }

    public void setWriteFinalDecisionGenerateNotice(String writeFinalDecisionGenerateNotice) {
        this.writeFinalDecisionGenerateNotice = writeFinalDecisionGenerateNotice;
    }

    public String getWriteFinalDecisionAllowedOrRefused() {
        return writeFinalDecisionAllowedOrRefused;
    }

    public void setWriteFinalDecisionAllowedOrRefused(String writeFinalDecisionAllowedOrRefused) {
        this.writeFinalDecisionAllowedOrRefused = writeFinalDecisionAllowedOrRefused;
    }

    public String getWriteFinalDecisionTypeOfHearing() {
        return writeFinalDecisionTypeOfHearing;
    }

    public void setWriteFinalDecisionTypeOfHearing(String writeFinalDecisionTypeOfHearing) {
        this.writeFinalDecisionTypeOfHearing = writeFinalDecisionTypeOfHearing;
    }

    public String getWriteFinalDecisionPresentingOfficerAttendedQuestion() {
        return writeFinalDecisionPresentingOfficerAttendedQuestion;
    }

    public void setWriteFinalDecisionPresentingOfficerAttendedQuestion(String writeFinalDecisionPresentingOfficerAttendedQuestion) {
        this.writeFinalDecisionPresentingOfficerAttendedQuestion = writeFinalDecisionPresentingOfficerAttendedQuestion;
    }

    public String getWriteFinalDecisionAppellantAttendedQuestion() {
        return writeFinalDecisionAppellantAttendedQuestion;
    }

    public void setWriteFinalDecisionAppellantAttendedQuestion(String writeFinalDecisionAppellantAttendedQuestion) {
        this.writeFinalDecisionAppellantAttendedQuestion = writeFinalDecisionAppellantAttendedQuestion;
    }

    public String getPipWriteFinalDecisionDailyLivingQuestion() {
        return pipWriteFinalDecisionDailyLivingQuestion;
    }

    public void setPipWriteFinalDecisionDailyLivingQuestion(String pipWriteFinalDecisionDailyLivingQuestion) {
        this.pipWriteFinalDecisionDailyLivingQuestion = pipWriteFinalDecisionDailyLivingQuestion;
    }

    public String getPipWriteFinalDecisionComparedToDwpDailyLivingQuestion() {
        return pipWriteFinalDecisionComparedToDwpDailyLivingQuestion;
    }

    public void setPipWriteFinalDecisionComparedToDwpDailyLivingQuestion(String pipWriteFinalDecisionComparedToDwpDailyLivingQuestion) {
        this.pipWriteFinalDecisionComparedToDwpDailyLivingQuestion = pipWriteFinalDecisionComparedToDwpDailyLivingQuestion;
    }

    public String getPipWriteFinalDecisionMobilityQuestion() {
        return pipWriteFinalDecisionMobilityQuestion;
    }

    public void setPipWriteFinalDecisionMobilityQuestion(String pipWriteFinalDecisionMobilityQuestion) {
        this.pipWriteFinalDecisionMobilityQuestion = pipWriteFinalDecisionMobilityQuestion;
    }

    public String getPipWriteFinalDecisionComparedToDwpMobilityQuestion() {
        return pipWriteFinalDecisionComparedToDwpMobilityQuestion;
    }

    public void setPipWriteFinalDecisionComparedToDwpMobilityQuestion(String pipWriteFinalDecisionComparedToDwpMobilityQuestion) {
        this.pipWriteFinalDecisionComparedToDwpMobilityQuestion = pipWriteFinalDecisionComparedToDwpMobilityQuestion;
    }

    public String getWriteFinalDecisionStartDate() {
        return writeFinalDecisionStartDate;
    }

    public void setWriteFinalDecisionStartDate(String writeFinalDecisionStartDate) {
        this.writeFinalDecisionStartDate = writeFinalDecisionStartDate;
    }

    public String getWriteFinalDecisionEndDateType() {
        return writeFinalDecisionEndDateType;
    }

    public void setWriteFinalDecisionEndDateType(String writeFinalDecisionEndDateType) {
        this.writeFinalDecisionEndDateType = writeFinalDecisionEndDateType;
    }

    public String getWriteFinalDecisionEndDate() {
        return writeFinalDecisionEndDate;
    }

    public void setWriteFinalDecisionEndDate(String writeFinalDecisionEndDate) {
        this.writeFinalDecisionEndDate = writeFinalDecisionEndDate;
    }

    public String getWriteFinalDecisionDisabilityQualifiedPanelMemberName() {
        return writeFinalDecisionDisabilityQualifiedPanelMemberName;
    }

    public void setWriteFinalDecisionDisabilityQualifiedPanelMemberName(String writeFinalDecisionDisabilityQualifiedPanelMemberName) {
        this.writeFinalDecisionDisabilityQualifiedPanelMemberName = writeFinalDecisionDisabilityQualifiedPanelMemberName;
    }

    public String getWriteFinalDecisionMedicallyQualifiedPanelMemberName() {
        return writeFinalDecisionMedicallyQualifiedPanelMemberName;
    }

    public void setWriteFinalDecisionMedicallyQualifiedPanelMemberName(String writeFinalDecisionMedicallyQualifiedPanelMemberName) {
        this.writeFinalDecisionMedicallyQualifiedPanelMemberName = writeFinalDecisionMedicallyQualifiedPanelMemberName;
    }

    public String getWriteFinalDecisionOtherPanelMemberName() {
        return writeFinalDecisionOtherPanelMemberName;
    }

    public void setWriteFinalDecisionOtherPanelMemberName(String writeFinalDecisionOtherPanelMemberName) {
        this.writeFinalDecisionOtherPanelMemberName = writeFinalDecisionOtherPanelMemberName;
    }

    public String getWriteFinalDecisionDateOfDecision() {
        return writeFinalDecisionDateOfDecision;
    }

    public void setWriteFinalDecisionDateOfDecision(String writeFinalDecisionDateOfDecision) {
        this.writeFinalDecisionDateOfDecision = writeFinalDecisionDateOfDecision;
    }

    public String getWriteFinalDecisionDetailsOfDecision() {
        return writeFinalDecisionDetailsOfDecision;
    }

    public void setWriteFinalDecisionDetailsOfDecision(String writeFinalDecisionDetailsOfDecision) {
        this.writeFinalDecisionDetailsOfDecision = writeFinalDecisionDetailsOfDecision;
    }

    public List<CollectionItem<String>> getWriteFinalDecisionReasons() {
        return writeFinalDecisionReasons;
    }

    public void setWriteFinalDecisionReasons(List<CollectionItem<String>> writeFinalDecisionReasons) {
        this.writeFinalDecisionReasons = writeFinalDecisionReasons;
    }

    public String getPipWriteFinalDecisionPreparingFoodQuestion() {
        return pipWriteFinalDecisionPreparingFoodQuestion;
    }

    public void setPipWriteFinalDecisionPreparingFoodQuestion(String pipWriteFinalDecisionPreparingFoodQuestion) {
        this.pipWriteFinalDecisionPreparingFoodQuestion = pipWriteFinalDecisionPreparingFoodQuestion;
    }

    public String getPipWriteFinalDecisionTakingNutritionQuestion() {
        return pipWriteFinalDecisionTakingNutritionQuestion;
    }

    public void setPipWriteFinalDecisionTakingNutritionQuestion(String pipWriteFinalDecisionTakingNutritionQuestion) {
        this.pipWriteFinalDecisionTakingNutritionQuestion = pipWriteFinalDecisionTakingNutritionQuestion;
    }

    public String getPipWriteFinalDecisionManagingTherapyQuestion() {
        return pipWriteFinalDecisionManagingTherapyQuestion;
    }

    public void setPipWriteFinalDecisionManagingTherapyQuestion(String pipWriteFinalDecisionManagingTherapyQuestion) {
        this.pipWriteFinalDecisionManagingTherapyQuestion = pipWriteFinalDecisionManagingTherapyQuestion;
    }

    public String getPipWriteFinalDecisionWashAndBatheQuestion() {
        return pipWriteFinalDecisionWashAndBatheQuestion;
    }

    public void setPipWriteFinalDecisionWashAndBatheQuestion(String pipWriteFinalDecisionWashAndBatheQuestion) {
        this.pipWriteFinalDecisionWashAndBatheQuestion = pipWriteFinalDecisionWashAndBatheQuestion;
    }

    public String getPipWriteFinalDecisionManagingToiletNeedsQuestion() {
        return pipWriteFinalDecisionManagingToiletNeedsQuestion;
    }

    public void setPipWriteFinalDecisionManagingToiletNeedsQuestion(String pipWriteFinalDecisionManagingToiletNeedsQuestion) {
        this.pipWriteFinalDecisionManagingToiletNeedsQuestion = pipWriteFinalDecisionManagingToiletNeedsQuestion;
    }

    public String getPipWriteFinalDecisionDressingAndUndressingQuestion() {
        return pipWriteFinalDecisionDressingAndUndressingQuestion;
    }

    public void setPipWriteFinalDecisionDressingAndUndressingQuestion(String pipWriteFinalDecisionDressingAndUndressingQuestion) {
        this.pipWriteFinalDecisionDressingAndUndressingQuestion = pipWriteFinalDecisionDressingAndUndressingQuestion;
    }

    public String getPipWriteFinalDecisionCommunicatingQuestion() {
        return pipWriteFinalDecisionCommunicatingQuestion;
    }

    public void setPipWriteFinalDecisionCommunicatingQuestion(String pipWriteFinalDecisionCommunicatingQuestion) {
        this.pipWriteFinalDecisionCommunicatingQuestion = pipWriteFinalDecisionCommunicatingQuestion;
    }

    public String getPipWriteFinalDecisionReadingUnderstandingQuestion() {
        return pipWriteFinalDecisionReadingUnderstandingQuestion;
    }

    public void setPipWriteFinalDecisionReadingUnderstandingQuestion(String pipWriteFinalDecisionReadingUnderstandingQuestion) {
        this.pipWriteFinalDecisionReadingUnderstandingQuestion = pipWriteFinalDecisionReadingUnderstandingQuestion;
    }

    public String getPipWriteFinalDecisionEngagingWithOthersQuestion() {
        return pipWriteFinalDecisionEngagingWithOthersQuestion;
    }

    public void setPipWriteFinalDecisionEngagingWithOthersQuestion(String pipWriteFinalDecisionEngagingWithOthersQuestion) {
        this.pipWriteFinalDecisionEngagingWithOthersQuestion = pipWriteFinalDecisionEngagingWithOthersQuestion;
    }

    public String getPipWriteFinalDecisionBudgetingDecisionsQuestion() {
        return pipWriteFinalDecisionBudgetingDecisionsQuestion;
    }

    public void setPipWriteFinalDecisionBudgetingDecisionsQuestion(String pipWriteFinalDecisionBudgetingDecisionsQuestion) {
        this.pipWriteFinalDecisionBudgetingDecisionsQuestion = pipWriteFinalDecisionBudgetingDecisionsQuestion;
    }

    public String getPipWriteFinalDecisionPlanningAndFollowingQuestion() {
        return pipWriteFinalDecisionPlanningAndFollowingQuestion;
    }

    public void setPipWriteFinalDecisionPlanningAndFollowingQuestion(String pipWriteFinalDecisionPlanningAndFollowingQuestion) {
        this.pipWriteFinalDecisionPlanningAndFollowingQuestion = pipWriteFinalDecisionPlanningAndFollowingQuestion;
    }

    public String getPipWriteFinalDecisionMovingAroundQuestion() {
        return pipWriteFinalDecisionMovingAroundQuestion;
    }

    public void setPipWriteFinalDecisionMovingAroundQuestion(String pipWriteFinalDecisionMovingAroundQuestion) {
        this.pipWriteFinalDecisionMovingAroundQuestion = pipWriteFinalDecisionMovingAroundQuestion;
    }

    public String getWriteFinalDecisionPageSectionReference() {
        return writeFinalDecisionPageSectionReference;
    }

    public void setWriteFinalDecisionPageSectionReference(String writeFinalDecisionPageSectionReference) {
        this.writeFinalDecisionPageSectionReference = writeFinalDecisionPageSectionReference;
    }

    public String getWriteFinalDecisionAnythingElse() {
        return writeFinalDecisionAnythingElse;
    }

    public void setWriteFinalDecisionAnythingElse(String writeFinalDecisionAnythingElse) {
        this.writeFinalDecisionAnythingElse = writeFinalDecisionAnythingElse;
    }

    public DocumentLink getWriteFinalDecisionPreviewDocument() {
        return writeFinalDecisionPreviewDocument;
    }

    public void setWriteFinalDecisionPreviewDocument(DocumentLink writeFinalDecisionPreviewDocument) {
        this.writeFinalDecisionPreviewDocument = writeFinalDecisionPreviewDocument;
    }

    public String getWriteFinalDecisionGeneratedDate() {
        return writeFinalDecisionGeneratedDate;
    }

    public void setWriteFinalDecisionGeneratedDate(String writeFinalDecisionGeneratedDate) {
        this.writeFinalDecisionGeneratedDate = writeFinalDecisionGeneratedDate;
    }

    public String getAdjournCaseGenerateNotice() {
        return adjournCaseGenerateNotice;
    }

    public void setAdjournCaseGenerateNotice(String adjournCaseGenerateNotice) {
        this.adjournCaseGenerateNotice = adjournCaseGenerateNotice;
    }

    public String getAdjournCaseTypeOfHearing() {
        return adjournCaseTypeOfHearing;
    }

    public void setAdjournCaseTypeOfHearing(String adjournCaseTypeOfHearing) {
        this.adjournCaseTypeOfHearing = adjournCaseTypeOfHearing;
    }

    public String getAdjournCaseCanCaseBeListedRightAway() {
        return adjournCaseCanCaseBeListedRightAway;
    }

    public void setAdjournCaseCanCaseBeListedRightAway(String adjournCaseCanCaseBeListedRightAway) {
        this.adjournCaseCanCaseBeListedRightAway = adjournCaseCanCaseBeListedRightAway;
    }

    public String getAdjournCaseAreDirectionsBeingMadeToParties() {
        return adjournCaseAreDirectionsBeingMadeToParties;
    }

    public void setAdjournCaseAreDirectionsBeingMadeToParties(String adjournCaseAreDirectionsBeingMadeToParties) {
        this.adjournCaseAreDirectionsBeingMadeToParties = adjournCaseAreDirectionsBeingMadeToParties;
    }

    public String getAdjournCaseDirectionsDueDateDaysOffset() {
        return adjournCaseDirectionsDueDateDaysOffset;
    }

    public void setAdjournCaseDirectionsDueDateDaysOffset(String adjournCaseDirectionsDueDateDaysOffset) {
        this.adjournCaseDirectionsDueDateDaysOffset = adjournCaseDirectionsDueDateDaysOffset;
    }

    public String getAdjournCaseDirectionsDueDate() {
        return adjournCaseDirectionsDueDate;
    }

    public void setAdjournCaseDirectionsDueDate(String adjournCaseDirectionsDueDate) {
        this.adjournCaseDirectionsDueDate = adjournCaseDirectionsDueDate;
    }

    public String getAdjournCaseTypeOfNextHearing() {
        return adjournCaseTypeOfNextHearing;
    }

    public void setAdjournCaseTypeOfNextHearing(String adjournCaseTypeOfNextHearing) {
        this.adjournCaseTypeOfNextHearing = adjournCaseTypeOfNextHearing;
    }

    public String getAdjournCaseNextHearingVenue() {
        return adjournCaseNextHearingVenue;
    }

    public void setAdjournCaseNextHearingVenue(String adjournCaseNextHearingVenue) {
        this.adjournCaseNextHearingVenue = adjournCaseNextHearingVenue;
    }

    public DynamicList getAdjournCaseNextHearingVenueSelected() {
        return adjournCaseNextHearingVenueSelected;
    }

    public void setAdjournCaseNextHearingVenueSelected(DynamicList adjournCaseNextHearingVenueSelected) {
        this.adjournCaseNextHearingVenueSelected = adjournCaseNextHearingVenueSelected;
    }

    public String getAdjournCasePanelMembersExcluded() {
        return adjournCasePanelMembersExcluded;
    }

    public void setAdjournCasePanelMembersExcluded(String adjournCasePanelMembersExcluded) {
        this.adjournCasePanelMembersExcluded = adjournCasePanelMembersExcluded;
    }

    public String getAdjournCaseDisabilityQualifiedPanelMemberName() {
        return adjournCaseDisabilityQualifiedPanelMemberName;
    }

    public void setAdjournCaseDisabilityQualifiedPanelMemberName(String adjournCaseDisabilityQualifiedPanelMemberName) {
        this.adjournCaseDisabilityQualifiedPanelMemberName = adjournCaseDisabilityQualifiedPanelMemberName;
    }

    public String getAdjournCaseMedicallyQualifiedPanelMemberName() {
        return adjournCaseMedicallyQualifiedPanelMemberName;
    }

    public void setAdjournCaseMedicallyQualifiedPanelMemberName(String adjournCaseMedicallyQualifiedPanelMemberName) {
        this.adjournCaseMedicallyQualifiedPanelMemberName = adjournCaseMedicallyQualifiedPanelMemberName;
    }

    public String getAdjournCaseOtherPanelMemberName() {
        return adjournCaseOtherPanelMemberName;
    }

    public void setAdjournCaseOtherPanelMemberName(String adjournCaseOtherPanelMemberName) {
        this.adjournCaseOtherPanelMemberName = adjournCaseOtherPanelMemberName;
    }

    public String getAdjournCaseNextHearingListingDurationType() {
        return adjournCaseNextHearingListingDurationType;
    }

    public void setAdjournCaseNextHearingListingDurationType(String adjournCaseNextHearingListingDurationType) {
        this.adjournCaseNextHearingListingDurationType = adjournCaseNextHearingListingDurationType;
    }

    public String getAdjournCaseNextHearingListingDuration() {
        return adjournCaseNextHearingListingDuration;
    }

    public void setAdjournCaseNextHearingListingDuration(String adjournCaseNextHearingListingDuration) {
        this.adjournCaseNextHearingListingDuration = adjournCaseNextHearingListingDuration;
    }

    public String getAdjournCaseNextHearingListingDurationUnits() {
        return adjournCaseNextHearingListingDurationUnits;
    }

    public void setAdjournCaseNextHearingListingDurationUnits(String adjournCaseNextHearingListingDurationUnits) {
        this.adjournCaseNextHearingListingDurationUnits = adjournCaseNextHearingListingDurationUnits;
    }

    public String getAdjournCaseInterpreterRequired() {
        return adjournCaseInterpreterRequired;
    }

    public void setAdjournCaseInterpreterRequired(String adjournCaseInterpreterRequired) {
        this.adjournCaseInterpreterRequired = adjournCaseInterpreterRequired;
    }

    public String getAdjournCaseInterpreterLanguage() {
        return adjournCaseInterpreterLanguage;
    }

    public void setAdjournCaseInterpreterLanguage(String adjournCaseInterpreterLanguage) {
        this.adjournCaseInterpreterLanguage = adjournCaseInterpreterLanguage;
    }

    public String getAdjournCaseNextHearingDateType() {
        return adjournCaseNextHearingDateType;
    }

    public void setAdjournCaseNextHearingDateType(String adjournCaseNextHearingDateType) {
        this.adjournCaseNextHearingDateType = adjournCaseNextHearingDateType;
    }

    public String getAdjournCaseNextHearingDateOrPeriod() {
        return adjournCaseNextHearingDateOrPeriod;
    }

    public void setAdjournCaseNextHearingDateOrPeriod(String adjournCaseNextHearingDateOrPeriod) {
        this.adjournCaseNextHearingDateOrPeriod = adjournCaseNextHearingDateOrPeriod;
    }

    public String getAdjournCaseNextHearingDateOrTime() {
        return adjournCaseNextHearingDateOrTime;
    }

    public void setAdjournCaseNextHearingDateOrTime(String adjournCaseNextHearingDateOrTime) {
        this.adjournCaseNextHearingDateOrTime = adjournCaseNextHearingDateOrTime;
    }

    public String getAdjournCaseNextHearingFirstAvailableDateAfterDate() {
        return adjournCaseNextHearingFirstAvailableDateAfterDate;
    }

    public void setAdjournCaseNextHearingFirstAvailableDateAfterDate(String adjournCaseNextHearingFirstAvailableDateAfterDate) {
        this.adjournCaseNextHearingFirstAvailableDateAfterDate = adjournCaseNextHearingFirstAvailableDateAfterDate;
    }

    public String getAdjournCaseNextHearingFirstAvailableDateAfterPeriod() {
        return adjournCaseNextHearingFirstAvailableDateAfterPeriod;
    }

    public void setAdjournCaseNextHearingFirstAvailableDateAfterPeriod(String adjournCaseNextHearingFirstAvailableDateAfterPeriod) {
        this.adjournCaseNextHearingFirstAvailableDateAfterPeriod = adjournCaseNextHearingFirstAvailableDateAfterPeriod;
    }

    public AdjournCaseTime getAdjournCaseTime() {
        return adjournCaseTime;
    }

    public void setAdjournCaseTime(AdjournCaseTime adjournCaseTime) {
        this.adjournCaseTime = adjournCaseTime;
    }

    public List<CollectionItem<String>> getAdjournCaseReasons() {
        return adjournCaseReasons;
    }

    public void setAdjournCaseReasons(List<CollectionItem<String>> adjournCaseReasons) {
        this.adjournCaseReasons = adjournCaseReasons;
    }

    public List<CollectionItem<String>> getAdjournCaseAdditionalDirections() {
        return adjournCaseAdditionalDirections;
    }

    public void setAdjournCaseAdditionalDirections(List<CollectionItem<String>> adjournCaseAdditionalDirections) {
        this.adjournCaseAdditionalDirections = adjournCaseAdditionalDirections;
    }

    public DocumentLink getAdjournCasePreviewDocument() {
        return adjournCasePreviewDocument;
    }

    public void setAdjournCasePreviewDocument(DocumentLink adjournCasePreviewDocument) {
        this.adjournCasePreviewDocument = adjournCasePreviewDocument;
    }

    public String getAdjournCaseGeneratedDate() {
        return adjournCaseGeneratedDate;
    }

    public void setAdjournCaseGeneratedDate(String adjournCaseGeneratedDate) {
        this.adjournCaseGeneratedDate = adjournCaseGeneratedDate;
    }

    public String getNotListableProvideReasons() {
        return notListableProvideReasons;
    }

    public void setNotListableProvideReasons(String notListableProvideReasons) {
        this.notListableProvideReasons = notListableProvideReasons;
    }

    public String getNotListableDueDate() {
        return notListableDueDate;
    }

    public void setNotListableDueDate(String notListableDueDate) {
        this.notListableDueDate = notListableDueDate;
    }

    public String getUpdateNotListableDirectionsFulfilled() {
        return updateNotListableDirectionsFulfilled;
    }

    public void setUpdateNotListableDirectionsFulfilled(String updateNotListableDirectionsFulfilled) {
        this.updateNotListableDirectionsFulfilled = updateNotListableDirectionsFulfilled;
    }

    public String getUpdateNotListableInterlocReview() {
        return updateNotListableInterlocReview;
    }

    public void setUpdateNotListableInterlocReview(String updateNotListableInterlocReview) {
        this.updateNotListableInterlocReview = updateNotListableInterlocReview;
    }

    public String getUpdateNotListableWhoReviewsCase() {
        return updateNotListableWhoReviewsCase;
    }

    public void setUpdateNotListableWhoReviewsCase(String updateNotListableWhoReviewsCase) {
        this.updateNotListableWhoReviewsCase = updateNotListableWhoReviewsCase;
    }

    public String getUpdateNotListableSetNewDueDate() {
        return updateNotListableSetNewDueDate;
    }

    public void setUpdateNotListableSetNewDueDate(String updateNotListableSetNewDueDate) {
        this.updateNotListableSetNewDueDate = updateNotListableSetNewDueDate;
    }

    public String getUpdateNotListableDueDate() {
        return updateNotListableDueDate;
    }

    public void setUpdateNotListableDueDate(String updateNotListableDueDate) {
        this.updateNotListableDueDate = updateNotListableDueDate;
    }

    public String getUpdateNotListableWhereShouldCaseMoveTo() {
        return updateNotListableWhereShouldCaseMoveTo;
    }

    public void setUpdateNotListableWhereShouldCaseMoveTo(String updateNotListableWhereShouldCaseMoveTo) {
        this.updateNotListableWhereShouldCaseMoveTo = updateNotListableWhereShouldCaseMoveTo;
    }

    public String getLanguagePreferenceWelsh() {
        return languagePreferenceWelsh;
    }

    public void setLanguagePreferenceWelsh(String languagePreferenceWelsh) {
        this.languagePreferenceWelsh = languagePreferenceWelsh;
    }

    public List<String> getElementsDisputedList() {
        return elementsDisputedList;
    }

    public void setElementsDisputedList(List<String> elementsDisputedList) {
        this.elementsDisputedList = elementsDisputedList;
    }

    public List<ElementDisputed> getElementsDisputedGeneral() {
        return elementsDisputedGeneral;
    }

    public void setElementsDisputedGeneral(List<ElementDisputed> elementsDisputedGeneral) {
        this.elementsDisputedGeneral = elementsDisputedGeneral;
    }

    public List<ElementDisputed> getElementsDisputedSanctions() {
        return elementsDisputedSanctions;
    }

    public void setElementsDisputedSanctions(List<ElementDisputed> elementsDisputedSanctions) {
        this.elementsDisputedSanctions = elementsDisputedSanctions;
    }

    public List<ElementDisputed> getElementsDisputedOverpayment() {
        return elementsDisputedOverpayment;
    }

    public void setElementsDisputedOverpayment(List<ElementDisputed> elementsDisputedOverpayment) {
        this.elementsDisputedOverpayment = elementsDisputedOverpayment;
    }

    public List<ElementDisputed> getElementsDisputedHousing() {
        return elementsDisputedHousing;
    }

    public void setElementsDisputedHousing(List<ElementDisputed> elementsDisputedHousing) {
        this.elementsDisputedHousing = elementsDisputedHousing;
    }

    public List<ElementDisputed> getElementsDisputedChildCare() {
        return elementsDisputedChildCare;
    }

    public void setElementsDisputedChildCare(List<ElementDisputed> elementsDisputedChildCare) {
        this.elementsDisputedChildCare = elementsDisputedChildCare;
    }

    public List<ElementDisputed> getElementsDisputedCare() {
        return elementsDisputedCare;
    }

    public void setElementsDisputedCare(List<ElementDisputed> elementsDisputedCare) {
        this.elementsDisputedCare = elementsDisputedCare;
    }

    public List<ElementDisputed> getElementsDisputedChildElement() {
        return elementsDisputedChildElement;
    }

    public void setElementsDisputedChildElement(List<ElementDisputed> elementsDisputedChildElement) {
        this.elementsDisputedChildElement = elementsDisputedChildElement;
    }

    public List<ElementDisputed> getElementsDisputedChildDisabled() {
        return elementsDisputedChildDisabled;
    }

    public void setElementsDisputedChildDisabled(List<ElementDisputed> elementsDisputedChildDisabled) {
        this.elementsDisputedChildDisabled = elementsDisputedChildDisabled;
    }

    public String getElementsDisputedIsDecisionDisputedByOthers() {
        return elementsDisputedIsDecisionDisputedByOthers;
    }

    public void setElementsDisputedIsDecisionDisputedByOthers(String elementsDisputedIsDecisionDisputedByOthers) {
        this.elementsDisputedIsDecisionDisputedByOthers = elementsDisputedIsDecisionDisputedByOthers;
    }

    public String getElementsDisputedLinkedAppealRef() {
        return elementsDisputedLinkedAppealRef;
    }

    public void setElementsDisputedLinkedAppealRef(String elementsDisputedLinkedAppealRef) {
        this.elementsDisputedLinkedAppealRef = elementsDisputedLinkedAppealRef;
    }

    public String getJointParty() {
        return jointParty;
    }

    public void setJointParty(String jointParty) {
        this.jointParty = jointParty;
    }

    public JointPartyName getJointPartyName() {
        return jointPartyName;
    }

    public void setJointPartyName(JointPartyName jointPartyName) {
        this.jointPartyName = jointPartyName;
    }

    public Identity getJointPartyIdentity() {
        return jointPartyIdentity;
    }

    public void setJointPartyIdentity(Identity jointPartyIdentity) {
        this.jointPartyIdentity = jointPartyIdentity;
    }

    public String getJointPartyAddressSameAsAppellant() {
        return jointPartyAddressSameAsAppellant;
    }

    public void setJointPartyAddressSameAsAppellant(String jointPartyAddressSameAsAppellant) {
        this.jointPartyAddressSameAsAppellant = jointPartyAddressSameAsAppellant;
    }

    public Address getJointPartyAddress() {
        return jointPartyAddress;
    }

    public void setJointPartyAddress(Address jointPartyAddress) {
        this.jointPartyAddress = jointPartyAddress;
    }

    public String getTranslationWorkOutstanding() {
        return translationWorkOutstanding;
    }

    public void setTranslationWorkOutstanding(String translationWorkOutstanding) {
        this.translationWorkOutstanding = translationWorkOutstanding;
    }

    public List<SscsWelshDocument> getSscsWelshDocuments() {
        return sscsWelshDocuments;
    }

    public void setSscsWelshDocuments(List<SscsWelshDocument> sscsWelshDocuments) {
        this.sscsWelshDocuments = sscsWelshDocuments;
    }

    public List<SscsWelshDocument> getSscsWelshPreviewDocuments() {
        return sscsWelshPreviewDocuments;
    }

    public void setSscsWelshPreviewDocuments(List<SscsWelshDocument> sscsWelshPreviewDocuments) {
        this.sscsWelshPreviewDocuments = sscsWelshPreviewDocuments;
    }

    public String getSscsWelshPreviewNextEvent() {
        return sscsWelshPreviewNextEvent;
    }

    public void setSscsWelshPreviewNextEvent(String sscsWelshPreviewNextEvent) {
        this.sscsWelshPreviewNextEvent = sscsWelshPreviewNextEvent;
    }

    public DynamicList getOriginalDocuments() {
        return originalDocuments;
    }

    public void setOriginalDocuments(DynamicList originalDocuments) {
        this.originalDocuments = originalDocuments;
    }

    public DynamicList getOriginalNoticeDocuments() {
        return originalNoticeDocuments;
    }

    public void setOriginalNoticeDocuments(DynamicList originalNoticeDocuments) {
        this.originalNoticeDocuments = originalNoticeDocuments;
    }

    public DynamicList getDocumentTypes() {
        return documentTypes;
    }

    public void setDocumentTypes(DynamicList documentTypes) {
        this.documentTypes = documentTypes;
    }

    public String getWelshBodyContent() {
        return welshBodyContent;
    }

    public void setWelshBodyContent(String welshBodyContent) {
        this.welshBodyContent = welshBodyContent;
    }

    public String getEnglishBodyContent() {
        return englishBodyContent;
    }

    public void setEnglishBodyContent(String englishBodyContent) {
        this.englishBodyContent = englishBodyContent;
    }

    public String getIsScottishCase() {
        return isScottishCase;
    }

    public void setIsScottishCase(String isScottishCase) {
        this.isScottishCase = isScottishCase;
    }

    public LocalDate getReinstatementRegistered() {
        return reinstatementRegistered;
    }

    public void setReinstatementRegistered(LocalDate reinstatementRegistered) {
        this.reinstatementRegistered = reinstatementRegistered;
    }

    public RequestOutcome getReinstatementOutcome() {
        return reinstatementOutcome;
    }

    public void setReinstatementOutcome(RequestOutcome reinstatementOutcome) {
        this.reinstatementOutcome = reinstatementOutcome;
    }

    public String getWelshInterlocNextReviewState() {
        return welshInterlocNextReviewState;
    }

    public void setWelshInterlocNextReviewState(String welshInterlocNextReviewState) {
        this.welshInterlocNextReviewState = welshInterlocNextReviewState;
    }

    public DatedRequestOutcome getConfidentialityRequestOutcomeAppellant() {
        return confidentialityRequestOutcomeAppellant;
    }

    public void setConfidentialityRequestOutcomeAppellant(DatedRequestOutcome confidentialityRequestOutcomeAppellant) {
        this.confidentialityRequestOutcomeAppellant = confidentialityRequestOutcomeAppellant;
    }

    public DatedRequestOutcome getConfidentialityRequestOutcomeJointParty() {
        return confidentialityRequestOutcomeJointParty;
    }

    public void setConfidentialityRequestOutcomeJointParty(DatedRequestOutcome confidentialityRequestOutcomeJointParty) {
        this.confidentialityRequestOutcomeJointParty = confidentialityRequestOutcomeJointParty;
    }

    public String getConfidentialityRequestAppellantGrantedOrRefused() {
        return confidentialityRequestAppellantGrantedOrRefused;
    }

    public void setConfidentialityRequestAppellantGrantedOrRefused(String confidentialityRequestAppellantGrantedOrRefused) {
        this.confidentialityRequestAppellantGrantedOrRefused = confidentialityRequestAppellantGrantedOrRefused;
    }

    public String getConfidentialityRequestJointPartyGrantedOrRefused() {
        return confidentialityRequestJointPartyGrantedOrRefused;
    }

    public void setConfidentialityRequestJointPartyGrantedOrRefused(String confidentialityRequestJointPartyGrantedOrRefused) {
        this.confidentialityRequestJointPartyGrantedOrRefused = confidentialityRequestJointPartyGrantedOrRefused;
    }

    public FormType getFormType() {
        return formType;
    }

    public void setFormType(FormType formType) {
        this.formType = formType;
    }

    public String getIsProgressingViaGaps() {
        return isProgressingViaGaps;
    }

    public void setIsProgressingViaGaps(String isProgressingViaGaps) {
        this.isProgressingViaGaps = isProgressingViaGaps;
    }

    public String getWcaAppeal() {
        return wcaAppeal;
    }

    public void setWcaAppeal(String wcaAppeal) {
        this.wcaAppeal = wcaAppeal;
    }

    public String getSupportGroupOnlyAppeal() {
        return supportGroupOnlyAppeal;
    }

    public void setSupportGroupOnlyAppeal(String supportGroupOnlyAppeal) {
        this.supportGroupOnlyAppeal = supportGroupOnlyAppeal;
    }

    public List<String> getEsaWriteFinalDecisionPhysicalDisabilitiesQuestion() {
        return esaWriteFinalDecisionPhysicalDisabilitiesQuestion;
    }

    public void setEsaWriteFinalDecisionPhysicalDisabilitiesQuestion(List<String> esaWriteFinalDecisionPhysicalDisabilitiesQuestion) {
        this.esaWriteFinalDecisionPhysicalDisabilitiesQuestion = esaWriteFinalDecisionPhysicalDisabilitiesQuestion;
    }

    public List<String> getEsaWriteFinalDecisionMentalAssessmentQuestion() {
        return esaWriteFinalDecisionMentalAssessmentQuestion;
    }

    public void setEsaWriteFinalDecisionMentalAssessmentQuestion(List<String> esaWriteFinalDecisionMentalAssessmentQuestion) {
        this.esaWriteFinalDecisionMentalAssessmentQuestion = esaWriteFinalDecisionMentalAssessmentQuestion;
    }

    public String getEsaWriteFinalDecisionMobilisingUnaidedQuestion() {
        return esaWriteFinalDecisionMobilisingUnaidedQuestion;
    }

    public void setEsaWriteFinalDecisionMobilisingUnaidedQuestion(String esaWriteFinalDecisionMobilisingUnaidedQuestion) {
        this.esaWriteFinalDecisionMobilisingUnaidedQuestion = esaWriteFinalDecisionMobilisingUnaidedQuestion;
    }

    public String getEsaWriteFinalDecisionStandingAndSittingQuestion() {
        return esaWriteFinalDecisionStandingAndSittingQuestion;
    }

    public void setEsaWriteFinalDecisionStandingAndSittingQuestion(String esaWriteFinalDecisionStandingAndSittingQuestion) {
        this.esaWriteFinalDecisionStandingAndSittingQuestion = esaWriteFinalDecisionStandingAndSittingQuestion;
    }

    public String getEsaWriteFinalDecisionReachingQuestion() {
        return esaWriteFinalDecisionReachingQuestion;
    }

    public void setEsaWriteFinalDecisionReachingQuestion(String esaWriteFinalDecisionReachingQuestion) {
        this.esaWriteFinalDecisionReachingQuestion = esaWriteFinalDecisionReachingQuestion;
    }

    public String getEsaWriteFinalDecisionPickingUpQuestion() {
        return esaWriteFinalDecisionPickingUpQuestion;
    }

    public void setEsaWriteFinalDecisionPickingUpQuestion(String esaWriteFinalDecisionPickingUpQuestion) {
        this.esaWriteFinalDecisionPickingUpQuestion = esaWriteFinalDecisionPickingUpQuestion;
    }

    public String getEsaWriteFinalDecisionManualDexterityQuestion() {
        return esaWriteFinalDecisionManualDexterityQuestion;
    }

    public void setEsaWriteFinalDecisionManualDexterityQuestion(String esaWriteFinalDecisionManualDexterityQuestion) {
        this.esaWriteFinalDecisionManualDexterityQuestion = esaWriteFinalDecisionManualDexterityQuestion;
    }

    public String getEsaWriteFinalDecisionMakingSelfUnderstoodQuestion() {
        return esaWriteFinalDecisionMakingSelfUnderstoodQuestion;
    }

    public void setEsaWriteFinalDecisionMakingSelfUnderstoodQuestion(String esaWriteFinalDecisionMakingSelfUnderstoodQuestion) {
        this.esaWriteFinalDecisionMakingSelfUnderstoodQuestion = esaWriteFinalDecisionMakingSelfUnderstoodQuestion;
    }

    public String getEsaWriteFinalDecisionCommunicationQuestion() {
        return esaWriteFinalDecisionCommunicationQuestion;
    }

    public void setEsaWriteFinalDecisionCommunicationQuestion(String esaWriteFinalDecisionCommunicationQuestion) {
        this.esaWriteFinalDecisionCommunicationQuestion = esaWriteFinalDecisionCommunicationQuestion;
    }

    public String getEsaWriteFinalDecisionNavigationQuestion() {
        return esaWriteFinalDecisionNavigationQuestion;
    }

    public void setEsaWriteFinalDecisionNavigationQuestion(String esaWriteFinalDecisionNavigationQuestion) {
        this.esaWriteFinalDecisionNavigationQuestion = esaWriteFinalDecisionNavigationQuestion;
    }

    public String getEsaWriteFinalDecisionLossOfControlQuestion() {
        return esaWriteFinalDecisionLossOfControlQuestion;
    }

    public void setEsaWriteFinalDecisionLossOfControlQuestion(String esaWriteFinalDecisionLossOfControlQuestion) {
        this.esaWriteFinalDecisionLossOfControlQuestion = esaWriteFinalDecisionLossOfControlQuestion;
    }

    public String getEsaWriteFinalDecisionConsciousnessQuestion() {
        return esaWriteFinalDecisionConsciousnessQuestion;
    }

    public void setEsaWriteFinalDecisionConsciousnessQuestion(String esaWriteFinalDecisionConsciousnessQuestion) {
        this.esaWriteFinalDecisionConsciousnessQuestion = esaWriteFinalDecisionConsciousnessQuestion;
    }

    public String getEsaWriteFinalDecisionLearningTasksQuestion() {
        return esaWriteFinalDecisionLearningTasksQuestion;
    }

    public void setEsaWriteFinalDecisionLearningTasksQuestion(String esaWriteFinalDecisionLearningTasksQuestion) {
        this.esaWriteFinalDecisionLearningTasksQuestion = esaWriteFinalDecisionLearningTasksQuestion;
    }

    public String getEsaWriteFinalDecisionAwarenessOfHazardsQuestion() {
        return esaWriteFinalDecisionAwarenessOfHazardsQuestion;
    }

    public void setEsaWriteFinalDecisionAwarenessOfHazardsQuestion(String esaWriteFinalDecisionAwarenessOfHazardsQuestion) {
        this.esaWriteFinalDecisionAwarenessOfHazardsQuestion = esaWriteFinalDecisionAwarenessOfHazardsQuestion;
    }

    public String getEsaWriteFinalDecisionPersonalActionQuestion() {
        return esaWriteFinalDecisionPersonalActionQuestion;
    }

    public void setEsaWriteFinalDecisionPersonalActionQuestion(String esaWriteFinalDecisionPersonalActionQuestion) {
        this.esaWriteFinalDecisionPersonalActionQuestion = esaWriteFinalDecisionPersonalActionQuestion;
    }

    public String getEsaWriteFinalDecisionCopingWithChangeQuestion() {
        return esaWriteFinalDecisionCopingWithChangeQuestion;
    }

    public void setEsaWriteFinalDecisionCopingWithChangeQuestion(String esaWriteFinalDecisionCopingWithChangeQuestion) {
        this.esaWriteFinalDecisionCopingWithChangeQuestion = esaWriteFinalDecisionCopingWithChangeQuestion;
    }

    public String getEsaWriteFinalDecisionGettingAboutQuestion() {
        return esaWriteFinalDecisionGettingAboutQuestion;
    }

    public void setEsaWriteFinalDecisionGettingAboutQuestion(String esaWriteFinalDecisionGettingAboutQuestion) {
        this.esaWriteFinalDecisionGettingAboutQuestion = esaWriteFinalDecisionGettingAboutQuestion;
    }

    public String getEsaWriteFinalDecisionSocialEngagementQuestion() {
        return esaWriteFinalDecisionSocialEngagementQuestion;
    }

    public void setEsaWriteFinalDecisionSocialEngagementQuestion(String esaWriteFinalDecisionSocialEngagementQuestion) {
        this.esaWriteFinalDecisionSocialEngagementQuestion = esaWriteFinalDecisionSocialEngagementQuestion;
    }

    public String getEsaWriteFinalDecisionAppropriatenessOfBehaviourQuestion() {
        return esaWriteFinalDecisionAppropriatenessOfBehaviourQuestion;
    }

    public void setEsaWriteFinalDecisionAppropriatenessOfBehaviourQuestion(String esaWriteFinalDecisionAppropriatenessOfBehaviourQuestion) {
        this.esaWriteFinalDecisionAppropriatenessOfBehaviourQuestion = esaWriteFinalDecisionAppropriatenessOfBehaviourQuestion;
    }

    public YesNo getDoesRegulation29Apply() {
        return doesRegulation29Apply;
    }

    public void setDoesRegulation29Apply(YesNo doesRegulation29Apply) {
        this.doesRegulation29Apply = doesRegulation29Apply;
    }

    public YesNo getShowRegulation29Page() {
        return showRegulation29Page;
    }

    public void setShowRegulation29Page(YesNo showRegulation29Page) {
        this.showRegulation29Page = showRegulation29Page;
    }

    public YesNo getShowSchedule3ActivitiesPage() {
        return showSchedule3ActivitiesPage;
    }

    public void setShowSchedule3ActivitiesPage(YesNo showSchedule3ActivitiesPage) {
        this.showSchedule3ActivitiesPage = showSchedule3ActivitiesPage;
    }

    public String getEsaWriteFinalDecisionSchedule3ActivitiesApply() {
        return esaWriteFinalDecisionSchedule3ActivitiesApply;
    }

    public void setEsaWriteFinalDecisionSchedule3ActivitiesApply(String esaWriteFinalDecisionSchedule3ActivitiesApply) {
        this.esaWriteFinalDecisionSchedule3ActivitiesApply = esaWriteFinalDecisionSchedule3ActivitiesApply;
    }

    public List<String> getEsaWriteFinalDecisionSchedule3ActivitiesQuestion() {
        return esaWriteFinalDecisionSchedule3ActivitiesQuestion;
    }

    public void setEsaWriteFinalDecisionSchedule3ActivitiesQuestion(List<String> esaWriteFinalDecisionSchedule3ActivitiesQuestion) {
        this.esaWriteFinalDecisionSchedule3ActivitiesQuestion = esaWriteFinalDecisionSchedule3ActivitiesQuestion;
    }

    public YesNo getDoesRegulation35Apply() {
        return doesRegulation35Apply;
    }

    public void setDoesRegulation35Apply(YesNo doesRegulation35Apply) {
        this.doesRegulation35Apply = doesRegulation35Apply;
    }

    public YesNo getShowFinalDecisionNoticeSummaryOfOutcomePage() {
        return showFinalDecisionNoticeSummaryOfOutcomePage;
    }

    public void setShowFinalDecisionNoticeSummaryOfOutcomePage(YesNo showFinalDecisionNoticeSummaryOfOutcomePage) {
        this.showFinalDecisionNoticeSummaryOfOutcomePage = showFinalDecisionNoticeSummaryOfOutcomePage;
    }

    public String getTest1() {
        return test1;
    }

    public void setTest1(String test1) {
        this.test1 = test1;
    }

    public String getTest2() {
        return test2;
    }

    public void setTest2(String test2) {
        this.test2 = test2;
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
            return new SscsCaseData(this.ccdCaseId, this.state, this.previousState, this.caseReference, this.caseCreated, this.infoRequests, this.region, this.appeal, this.hearings, this.evidence, this.dwpTimeExtension, this.events, this.subscriptions, this.regionalProcessingCenter, this.caseBundles, this.sscsDocument, this.draftSscsDocument, this.draftSscsFurtherEvidenceDocument, this.corDocument, this.draftCorDocument, this.sscsInterlocDecisionDocument, this.sscsInterlocDirectionDocument, this.sscsStrikeOutDocument, this.generatedNino, this.generatedSurname, this.generatedEmail, this.generatedMobile, this.generatedDob, this.directionResponse, this.evidencePresent, this.bulkScanCaseReference, this.decisionNotes, this.isCorDecision, this.relistingReason, this.dateSentToDwp, this.interlocReviewState, this.hmctsDwpState, this.dwpFurtherEvidenceStates, this.originalSender, this.furtherEvidenceAction, this.scannedDocuments, this.informationFromAppellant, this.outcome, this.evidenceHandled, this.assignedToJudge, this.assignedToDisabilityMember, this.assignedToMedicalMember, this.reissueFurtherEvidenceDocument, this.resendToAppellant, this.resendToRepresentative, this.resendToDwp, this.caseCode, this.benefitCode, this.issueCode, this.dwpOriginatingOffice, this.dwpPresentingOffice, this.dwpIsOfficerAttending, this.dwpUcb, this.dwpPhme, this.dwpComplexAppeal, this.dwpFurtherInfo, this.correspondence, this.interlocReferralDate, this.interlocReferralReason, this.dwpRegionalCentre, this.generateNotice, this.previewDocument, this.bodyContent, this.signedBy, this.signedRole, this.dateAdded, this.historicSscsInterlocDirectionDocs, this.dwpState, this.appealNotePad, this.dwpStateFeNoAction, this.createdInGapsFrom, this.dateCaseSentToGaps, this.associatedCase, this.dwpAT38Document, this.dwpEvidenceBundleDocument, this.dwpResponseDocument, this.dwpSupplementaryResponseDoc, this.dwpOtherDoc, this.dwpLT203, this.dwpLapseLetter, this.dwpResponseDate, this.linkedCasesBoolean, this.decisionType, this.selectWhoReviewsCase, this.directionType, this.directionTypeDl, this.extensionNextEvent, this.extensionNextEventDl, this.tl1Form, this.isInterlocRequired, this.panel, this.evidenceReceived, this.urgentCase, this.urgentHearingRegistered, this.urgentHearingOutcome, this.documentSentToDwp, this.directionDueDate, this.reservedToJudge, this.linkedCase, this.isWaiverNeeded, this.waiverDeclaration, this.waiverReason, this.waiverReasonOther, this.clerkDelegatedAuthority, this.clerkAppealSatisfactionText, this.pipWriteFinalDecisionDailyLivingActivitiesQuestion, this.pipWriteFinalDecisionMobilityActivitiesQuestion, this.clerkConfirmationOfMrn, this.clerkOtherReason, this.clerkConfirmationOther, this.responseRequired, this.timeExtensionRequested, this.bundleConfiguration, this.pcqId, this.writeFinalDecisionIsDescriptorFlow, this.writeFinalDecisionGenerateNotice, this.writeFinalDecisionAllowedOrRefused, this.writeFinalDecisionTypeOfHearing, this.writeFinalDecisionPresentingOfficerAttendedQuestion, this.writeFinalDecisionAppellantAttendedQuestion, this.pipWriteFinalDecisionDailyLivingQuestion, this.pipWriteFinalDecisionComparedToDwpDailyLivingQuestion, this.pipWriteFinalDecisionMobilityQuestion, this.pipWriteFinalDecisionComparedToDwpMobilityQuestion, this.writeFinalDecisionStartDate, this.writeFinalDecisionEndDateType, this.writeFinalDecisionEndDate, this.writeFinalDecisionDisabilityQualifiedPanelMemberName, this.writeFinalDecisionMedicallyQualifiedPanelMemberName, this.writeFinalDecisionOtherPanelMemberName, this.writeFinalDecisionDateOfDecision, this.writeFinalDecisionDetailsOfDecision, this.writeFinalDecisionReasons, this.pipWriteFinalDecisionPreparingFoodQuestion, this.pipWriteFinalDecisionTakingNutritionQuestion, this.pipWriteFinalDecisionManagingTherapyQuestion, this.pipWriteFinalDecisionWashAndBatheQuestion, this.pipWriteFinalDecisionManagingToiletNeedsQuestion, this.pipWriteFinalDecisionDressingAndUndressingQuestion, this.pipWriteFinalDecisionCommunicatingQuestion, this.pipWriteFinalDecisionReadingUnderstandingQuestion, this.pipWriteFinalDecisionEngagingWithOthersQuestion, this.pipWriteFinalDecisionBudgetingDecisionsQuestion, this.pipWriteFinalDecisionPlanningAndFollowingQuestion, this.pipWriteFinalDecisionMovingAroundQuestion, this.writeFinalDecisionPageSectionReference, this.writeFinalDecisionAnythingElse, this.writeFinalDecisionPreviewDocument, this.writeFinalDecisionGeneratedDate, this.adjournCaseGenerateNotice, this.adjournCaseTypeOfHearing, this.adjournCaseCanCaseBeListedRightAway, this.adjournCaseAreDirectionsBeingMadeToParties, this.adjournCaseDirectionsDueDateDaysOffset, this.adjournCaseDirectionsDueDate, this.adjournCaseTypeOfNextHearing, this.adjournCaseNextHearingVenue, this.adjournCaseNextHearingVenueSelected, this.adjournCasePanelMembersExcluded, this.adjournCaseDisabilityQualifiedPanelMemberName, this.adjournCaseMedicallyQualifiedPanelMemberName, this.adjournCaseOtherPanelMemberName, this.adjournCaseNextHearingListingDurationType, this.adjournCaseNextHearingListingDuration, this.adjournCaseNextHearingListingDurationUnits, this.adjournCaseInterpreterRequired, this.adjournCaseInterpreterLanguage, this.adjournCaseNextHearingDateType, this.adjournCaseNextHearingDateOrPeriod, this.adjournCaseNextHearingDateOrTime, this.adjournCaseNextHearingFirstAvailableDateAfterDate, this.adjournCaseNextHearingFirstAvailableDateAfterPeriod, this.adjournCaseTime, this.adjournCaseReasons, this.adjournCaseAdditionalDirections, this.adjournCasePreviewDocument, this.adjournCaseGeneratedDate, this.notListableProvideReasons, this.notListableDueDate, this.updateNotListableDirectionsFulfilled, this.updateNotListableInterlocReview, this.updateNotListableWhoReviewsCase, this.updateNotListableSetNewDueDate, this.updateNotListableDueDate, this.updateNotListableWhereShouldCaseMoveTo, this.languagePreferenceWelsh, this.elementsDisputedList, this.elementsDisputedGeneral, this.elementsDisputedSanctions, this.elementsDisputedOverpayment, this.elementsDisputedHousing, this.elementsDisputedChildCare, this.elementsDisputedCare, this.elementsDisputedChildElement, this.elementsDisputedChildDisabled, this.elementsDisputedIsDecisionDisputedByOthers, this.elementsDisputedLinkedAppealRef, this.jointParty, this.jointPartyName, this.jointPartyIdentity, this.jointPartyAddressSameAsAppellant, this.jointPartyAddress, this.translationWorkOutstanding, this.sscsWelshDocuments, this.sscsWelshPreviewDocuments, this.sscsWelshPreviewNextEvent, this.originalDocuments, this.originalNoticeDocuments, this.documentTypes, this.welshBodyContent, this.englishBodyContent, this.isScottishCase, this.reinstatementRegistered, this.reinstatementOutcome, this.welshInterlocNextReviewState, this.confidentialityRequestOutcomeAppellant, this.confidentialityRequestOutcomeJointParty, this.confidentialityRequestAppellantGrantedOrRefused, this.confidentialityRequestJointPartyGrantedOrRefused, this.formType, this.isProgressingViaGaps, this.wcaAppeal, this.supportGroupOnlyAppeal, this.esaWriteFinalDecisionPhysicalDisabilitiesQuestion, this.esaWriteFinalDecisionMentalAssessmentQuestion, this.esaWriteFinalDecisionMobilisingUnaidedQuestion, this.esaWriteFinalDecisionStandingAndSittingQuestion, this.esaWriteFinalDecisionReachingQuestion, this.esaWriteFinalDecisionPickingUpQuestion, this.esaWriteFinalDecisionManualDexterityQuestion, this.esaWriteFinalDecisionMakingSelfUnderstoodQuestion, this.esaWriteFinalDecisionCommunicationQuestion, this.esaWriteFinalDecisionNavigationQuestion, this.esaWriteFinalDecisionLossOfControlQuestion, this.esaWriteFinalDecisionConsciousnessQuestion, this.esaWriteFinalDecisionLearningTasksQuestion, this.esaWriteFinalDecisionAwarenessOfHazardsQuestion, this.esaWriteFinalDecisionPersonalActionQuestion, this.esaWriteFinalDecisionCopingWithChangeQuestion, this.esaWriteFinalDecisionGettingAboutQuestion, this.esaWriteFinalDecisionSocialEngagementQuestion, this.esaWriteFinalDecisionAppropriatenessOfBehaviourQuestion, this.doesRegulation29Apply, this.showRegulation29Page, this.showSchedule3ActivitiesPage, this.esaWriteFinalDecisionSchedule3ActivitiesApply, this.esaWriteFinalDecisionSchedule3ActivitiesQuestion, this.doesRegulation35Apply, this.showFinalDecisionNoticeSummaryOfOutcomePage, this.test1, this.test2);
        }
    }

    public static SscsCaseData.SscsCaseDataBuilder builder() {
        return new SscsCaseData.SscsCaseDataBuilder();
    }

    public SscsCaseData.SscsCaseDataBuilder toBuilder() {
        return (new SscsCaseData.SscsCaseDataBuilder()).ccdCaseId(this.ccdCaseId).state(this.state).previousState(this.previousState).caseReference(this.caseReference).caseCreated(this.caseCreated).infoRequests(this.infoRequests).region(this.region).appeal(this.appeal).hearings(this.hearings).evidence(this.evidence).dwpTimeExtension(this.dwpTimeExtension).events(this.events).subscriptions(this.subscriptions).regionalProcessingCenter(this.regionalProcessingCenter).caseBundles(this.caseBundles).sscsDocument(this.sscsDocument).draftSscsDocument(this.draftSscsDocument).draftSscsFurtherEvidenceDocument(this.draftSscsFurtherEvidenceDocument).corDocument(this.corDocument).draftCorDocument(this.draftCorDocument).sscsInterlocDecisionDocument(this.sscsInterlocDecisionDocument).sscsInterlocDirectionDocument(this.sscsInterlocDirectionDocument).sscsStrikeOutDocument(this.sscsStrikeOutDocument).generatedNino(this.generatedNino).generatedSurname(this.generatedSurname).generatedEmail(this.generatedEmail).generatedMobile(this.generatedMobile).generatedDob(this.generatedDob).directionResponse(this.directionResponse).evidencePresent(this.evidencePresent).bulkScanCaseReference(this.bulkScanCaseReference).decisionNotes(this.decisionNotes).isCorDecision(this.isCorDecision).relistingReason(this.relistingReason).dateSentToDwp(this.dateSentToDwp).interlocReviewState(this.interlocReviewState).hmctsDwpState(this.hmctsDwpState).dwpFurtherEvidenceStates(this.dwpFurtherEvidenceStates).originalSender(this.originalSender).furtherEvidenceAction(this.furtherEvidenceAction).scannedDocuments(this.scannedDocuments).informationFromAppellant(this.informationFromAppellant).outcome(this.outcome).evidenceHandled(this.evidenceHandled).assignedToJudge(this.assignedToJudge).assignedToDisabilityMember(this.assignedToDisabilityMember).assignedToMedicalMember(this.assignedToMedicalMember).reissueFurtherEvidenceDocument(this.reissueFurtherEvidenceDocument).resendToAppellant(this.resendToAppellant).resendToRepresentative(this.resendToRepresentative).resendToDwp(this.resendToDwp).caseCode(this.caseCode).benefitCode(this.benefitCode).issueCode(this.issueCode).dwpOriginatingOffice(this.dwpOriginatingOffice).dwpPresentingOffice(this.dwpPresentingOffice).dwpIsOfficerAttending(this.dwpIsOfficerAttending).dwpUcb(this.dwpUcb).dwpPhme(this.dwpPhme).dwpComplexAppeal(this.dwpComplexAppeal).dwpFurtherInfo(this.dwpFurtherInfo).correspondence(this.correspondence).interlocReferralDate(this.interlocReferralDate).interlocReferralReason(this.interlocReferralReason).dwpRegionalCentre(this.dwpRegionalCentre).generateNotice(this.generateNotice).previewDocument(this.previewDocument).bodyContent(this.bodyContent).signedBy(this.signedBy).signedRole(this.signedRole).dateAdded(this.dateAdded).historicSscsInterlocDirectionDocs(this.historicSscsInterlocDirectionDocs).dwpState(this.dwpState).appealNotePad(this.appealNotePad).dwpStateFeNoAction(this.dwpStateFeNoAction).createdInGapsFrom(this.createdInGapsFrom).dateCaseSentToGaps(this.dateCaseSentToGaps).associatedCase(this.associatedCase).dwpAT38Document(this.dwpAT38Document).dwpEvidenceBundleDocument(this.dwpEvidenceBundleDocument).dwpResponseDocument(this.dwpResponseDocument).dwpSupplementaryResponseDoc(this.dwpSupplementaryResponseDoc).dwpOtherDoc(this.dwpOtherDoc).dwpLT203(this.dwpLT203).dwpLapseLetter(this.dwpLapseLetter).dwpResponseDate(this.dwpResponseDate).linkedCasesBoolean(this.linkedCasesBoolean).decisionType(this.decisionType).selectWhoReviewsCase(this.selectWhoReviewsCase).directionType(this.directionType).directionTypeDl(this.directionTypeDl).extensionNextEvent(this.extensionNextEvent).extensionNextEventDl(this.extensionNextEventDl).tl1Form(this.tl1Form).isInterlocRequired(this.isInterlocRequired).panel(this.panel).evidenceReceived(this.evidenceReceived).urgentCase(this.urgentCase).urgentHearingRegistered(this.urgentHearingRegistered).urgentHearingOutcome(this.urgentHearingOutcome).documentSentToDwp(this.documentSentToDwp).directionDueDate(this.directionDueDate).reservedToJudge(this.reservedToJudge).linkedCase(this.linkedCase).isWaiverNeeded(this.isWaiverNeeded).waiverDeclaration(this.waiverDeclaration).waiverReason(this.waiverReason).waiverReasonOther(this.waiverReasonOther).clerkDelegatedAuthority(this.clerkDelegatedAuthority).clerkAppealSatisfactionText(this.clerkAppealSatisfactionText).pipWriteFinalDecisionDailyLivingActivitiesQuestion(this.pipWriteFinalDecisionDailyLivingActivitiesQuestion).pipWriteFinalDecisionMobilityActivitiesQuestion(this.pipWriteFinalDecisionMobilityActivitiesQuestion).clerkConfirmationOfMrn(this.clerkConfirmationOfMrn).clerkOtherReason(this.clerkOtherReason).clerkConfirmationOther(this.clerkConfirmationOther).responseRequired(this.responseRequired).timeExtensionRequested(this.timeExtensionRequested).bundleConfiguration(this.bundleConfiguration).pcqId(this.pcqId).writeFinalDecisionIsDescriptorFlow(this.writeFinalDecisionIsDescriptorFlow).writeFinalDecisionGenerateNotice(this.writeFinalDecisionGenerateNotice).writeFinalDecisionAllowedOrRefused(this.writeFinalDecisionAllowedOrRefused).writeFinalDecisionTypeOfHearing(this.writeFinalDecisionTypeOfHearing).writeFinalDecisionPresentingOfficerAttendedQuestion(this.writeFinalDecisionPresentingOfficerAttendedQuestion).writeFinalDecisionAppellantAttendedQuestion(this.writeFinalDecisionAppellantAttendedQuestion).pipWriteFinalDecisionDailyLivingQuestion(this.pipWriteFinalDecisionDailyLivingQuestion).pipWriteFinalDecisionComparedToDwpDailyLivingQuestion(this.pipWriteFinalDecisionComparedToDwpDailyLivingQuestion).pipWriteFinalDecisionMobilityQuestion(this.pipWriteFinalDecisionMobilityQuestion).pipWriteFinalDecisionComparedToDwpMobilityQuestion(this.pipWriteFinalDecisionComparedToDwpMobilityQuestion).writeFinalDecisionStartDate(this.writeFinalDecisionStartDate).writeFinalDecisionEndDateType(this.writeFinalDecisionEndDateType).writeFinalDecisionEndDate(this.writeFinalDecisionEndDate).writeFinalDecisionDisabilityQualifiedPanelMemberName(this.writeFinalDecisionDisabilityQualifiedPanelMemberName).writeFinalDecisionMedicallyQualifiedPanelMemberName(this.writeFinalDecisionMedicallyQualifiedPanelMemberName).writeFinalDecisionOtherPanelMemberName(this.writeFinalDecisionOtherPanelMemberName).writeFinalDecisionDateOfDecision(this.writeFinalDecisionDateOfDecision).writeFinalDecisionDetailsOfDecision(this.writeFinalDecisionDetailsOfDecision).writeFinalDecisionReasons(this.writeFinalDecisionReasons).pipWriteFinalDecisionPreparingFoodQuestion(this.pipWriteFinalDecisionPreparingFoodQuestion).pipWriteFinalDecisionTakingNutritionQuestion(this.pipWriteFinalDecisionTakingNutritionQuestion).pipWriteFinalDecisionManagingTherapyQuestion(this.pipWriteFinalDecisionManagingTherapyQuestion).pipWriteFinalDecisionWashAndBatheQuestion(this.pipWriteFinalDecisionWashAndBatheQuestion).pipWriteFinalDecisionManagingToiletNeedsQuestion(this.pipWriteFinalDecisionManagingToiletNeedsQuestion).pipWriteFinalDecisionDressingAndUndressingQuestion(this.pipWriteFinalDecisionDressingAndUndressingQuestion).pipWriteFinalDecisionCommunicatingQuestion(this.pipWriteFinalDecisionCommunicatingQuestion).pipWriteFinalDecisionReadingUnderstandingQuestion(this.pipWriteFinalDecisionReadingUnderstandingQuestion).pipWriteFinalDecisionEngagingWithOthersQuestion(this.pipWriteFinalDecisionEngagingWithOthersQuestion).pipWriteFinalDecisionBudgetingDecisionsQuestion(this.pipWriteFinalDecisionBudgetingDecisionsQuestion).pipWriteFinalDecisionPlanningAndFollowingQuestion(this.pipWriteFinalDecisionPlanningAndFollowingQuestion).pipWriteFinalDecisionMovingAroundQuestion(this.pipWriteFinalDecisionMovingAroundQuestion).writeFinalDecisionPageSectionReference(this.writeFinalDecisionPageSectionReference).writeFinalDecisionAnythingElse(this.writeFinalDecisionAnythingElse).writeFinalDecisionPreviewDocument(this.writeFinalDecisionPreviewDocument).writeFinalDecisionGeneratedDate(this.writeFinalDecisionGeneratedDate).adjournCaseGenerateNotice(this.adjournCaseGenerateNotice).adjournCaseTypeOfHearing(this.adjournCaseTypeOfHearing).adjournCaseCanCaseBeListedRightAway(this.adjournCaseCanCaseBeListedRightAway).adjournCaseAreDirectionsBeingMadeToParties(this.adjournCaseAreDirectionsBeingMadeToParties).adjournCaseDirectionsDueDateDaysOffset(this.adjournCaseDirectionsDueDateDaysOffset).adjournCaseDirectionsDueDate(this.adjournCaseDirectionsDueDate).adjournCaseTypeOfNextHearing(this.adjournCaseTypeOfNextHearing).adjournCaseNextHearingVenue(this.adjournCaseNextHearingVenue).adjournCaseNextHearingVenueSelected(this.adjournCaseNextHearingVenueSelected).adjournCasePanelMembersExcluded(this.adjournCasePanelMembersExcluded).adjournCaseDisabilityQualifiedPanelMemberName(this.adjournCaseDisabilityQualifiedPanelMemberName).adjournCaseMedicallyQualifiedPanelMemberName(this.adjournCaseMedicallyQualifiedPanelMemberName).adjournCaseOtherPanelMemberName(this.adjournCaseOtherPanelMemberName).adjournCaseNextHearingListingDurationType(this.adjournCaseNextHearingListingDurationType).adjournCaseNextHearingListingDuration(this.adjournCaseNextHearingListingDuration).adjournCaseNextHearingListingDurationUnits(this.adjournCaseNextHearingListingDurationUnits).adjournCaseInterpreterRequired(this.adjournCaseInterpreterRequired).adjournCaseInterpreterLanguage(this.adjournCaseInterpreterLanguage).adjournCaseNextHearingDateType(this.adjournCaseNextHearingDateType).adjournCaseNextHearingDateOrPeriod(this.adjournCaseNextHearingDateOrPeriod).adjournCaseNextHearingDateOrTime(this.adjournCaseNextHearingDateOrTime).adjournCaseNextHearingFirstAvailableDateAfterDate(this.adjournCaseNextHearingFirstAvailableDateAfterDate).adjournCaseNextHearingFirstAvailableDateAfterPeriod(this.adjournCaseNextHearingFirstAvailableDateAfterPeriod).adjournCaseTime(this.adjournCaseTime).adjournCaseReasons(this.adjournCaseReasons).adjournCaseAdditionalDirections(this.adjournCaseAdditionalDirections).adjournCasePreviewDocument(this.adjournCasePreviewDocument).adjournCaseGeneratedDate(this.adjournCaseGeneratedDate).notListableProvideReasons(this.notListableProvideReasons).notListableDueDate(this.notListableDueDate).updateNotListableDirectionsFulfilled(this.updateNotListableDirectionsFulfilled).updateNotListableInterlocReview(this.updateNotListableInterlocReview).updateNotListableWhoReviewsCase(this.updateNotListableWhoReviewsCase).updateNotListableSetNewDueDate(this.updateNotListableSetNewDueDate).updateNotListableDueDate(this.updateNotListableDueDate).updateNotListableWhereShouldCaseMoveTo(this.updateNotListableWhereShouldCaseMoveTo).languagePreferenceWelsh(this.languagePreferenceWelsh).elementsDisputedList(this.elementsDisputedList).elementsDisputedGeneral(this.elementsDisputedGeneral).elementsDisputedSanctions(this.elementsDisputedSanctions).elementsDisputedOverpayment(this.elementsDisputedOverpayment).elementsDisputedHousing(this.elementsDisputedHousing).elementsDisputedChildCare(this.elementsDisputedChildCare).elementsDisputedCare(this.elementsDisputedCare).elementsDisputedChildElement(this.elementsDisputedChildElement).elementsDisputedChildDisabled(this.elementsDisputedChildDisabled).elementsDisputedIsDecisionDisputedByOthers(this.elementsDisputedIsDecisionDisputedByOthers).elementsDisputedLinkedAppealRef(this.elementsDisputedLinkedAppealRef).jointParty(this.jointParty).jointPartyName(this.jointPartyName).jointPartyIdentity(this.jointPartyIdentity).jointPartyAddressSameAsAppellant(this.jointPartyAddressSameAsAppellant).jointPartyAddress(this.jointPartyAddress).translationWorkOutstanding(this.translationWorkOutstanding).sscsWelshDocuments(this.sscsWelshDocuments).sscsWelshPreviewDocuments(this.sscsWelshPreviewDocuments).sscsWelshPreviewNextEvent(this.sscsWelshPreviewNextEvent).originalDocuments(this.originalDocuments).originalNoticeDocuments(this.originalNoticeDocuments).documentTypes(this.documentTypes).welshBodyContent(this.welshBodyContent).englishBodyContent(this.englishBodyContent).isScottishCase(this.isScottishCase).reinstatementRegistered(this.reinstatementRegistered).reinstatementOutcome(this.reinstatementOutcome).welshInterlocNextReviewState(this.welshInterlocNextReviewState).confidentialityRequestOutcomeAppellant(this.confidentialityRequestOutcomeAppellant).confidentialityRequestOutcomeJointParty(this.confidentialityRequestOutcomeJointParty).confidentialityRequestAppellantGrantedOrRefused(this.confidentialityRequestAppellantGrantedOrRefused).confidentialityRequestJointPartyGrantedOrRefused(this.confidentialityRequestJointPartyGrantedOrRefused).formType(this.formType).isProgressingViaGaps(this.isProgressingViaGaps).wcaAppeal(this.wcaAppeal).supportGroupOnlyAppeal(this.supportGroupOnlyAppeal).esaWriteFinalDecisionPhysicalDisabilitiesQuestion(this.esaWriteFinalDecisionPhysicalDisabilitiesQuestion).esaWriteFinalDecisionMentalAssessmentQuestion(this.esaWriteFinalDecisionMentalAssessmentQuestion).esaWriteFinalDecisionMobilisingUnaidedQuestion(this.esaWriteFinalDecisionMobilisingUnaidedQuestion).esaWriteFinalDecisionStandingAndSittingQuestion(this.esaWriteFinalDecisionStandingAndSittingQuestion).esaWriteFinalDecisionReachingQuestion(this.esaWriteFinalDecisionReachingQuestion).esaWriteFinalDecisionPickingUpQuestion(this.esaWriteFinalDecisionPickingUpQuestion).esaWriteFinalDecisionManualDexterityQuestion(this.esaWriteFinalDecisionManualDexterityQuestion).esaWriteFinalDecisionMakingSelfUnderstoodQuestion(this.esaWriteFinalDecisionMakingSelfUnderstoodQuestion).esaWriteFinalDecisionCommunicationQuestion(this.esaWriteFinalDecisionCommunicationQuestion).esaWriteFinalDecisionNavigationQuestion(this.esaWriteFinalDecisionNavigationQuestion).esaWriteFinalDecisionLossOfControlQuestion(this.esaWriteFinalDecisionLossOfControlQuestion).esaWriteFinalDecisionConsciousnessQuestion(this.esaWriteFinalDecisionConsciousnessQuestion).esaWriteFinalDecisionLearningTasksQuestion(this.esaWriteFinalDecisionLearningTasksQuestion).esaWriteFinalDecisionAwarenessOfHazardsQuestion(this.esaWriteFinalDecisionAwarenessOfHazardsQuestion).esaWriteFinalDecisionPersonalActionQuestion(this.esaWriteFinalDecisionPersonalActionQuestion).esaWriteFinalDecisionCopingWithChangeQuestion(this.esaWriteFinalDecisionCopingWithChangeQuestion).esaWriteFinalDecisionGettingAboutQuestion(this.esaWriteFinalDecisionGettingAboutQuestion).esaWriteFinalDecisionSocialEngagementQuestion(this.esaWriteFinalDecisionSocialEngagementQuestion).esaWriteFinalDecisionAppropriatenessOfBehaviourQuestion(this.esaWriteFinalDecisionAppropriatenessOfBehaviourQuestion).doesRegulation29Apply(this.doesRegulation29Apply).showRegulation29Page(this.showRegulation29Page).showSchedule3ActivitiesPage(this.showSchedule3ActivitiesPage).esaWriteFinalDecisionSchedule3ActivitiesApply(this.esaWriteFinalDecisionSchedule3ActivitiesApply).esaWriteFinalDecisionSchedule3ActivitiesQuestion(this.esaWriteFinalDecisionSchedule3ActivitiesQuestion).doesRegulation35Apply(this.doesRegulation35Apply).showFinalDecisionNoticeSummaryOfOutcomePage(this.showFinalDecisionNoticeSummaryOfOutcomePage).test1(this.test1).test2(this.test2);
    }

}
