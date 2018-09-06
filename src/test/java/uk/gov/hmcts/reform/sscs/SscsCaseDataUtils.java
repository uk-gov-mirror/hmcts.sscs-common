package uk.gov.hmcts.reform.sscs;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import uk.gov.hmcts.reform.sscs.ccd.domain.*;

public final class SscsCaseDataUtils {

    public static final String CASE_ID = "1234";

    private SscsCaseDataUtils() {
    }

    public static SscsCaseData buildSscsCaseData(String caseReference, String subscribeEmail, String subscribeSms) {
        return buildSscsCaseData(
            caseReference,
            subscribeEmail,
            subscribeSms,
            EventType.APPEAL_RECEIVED
        );
    }

    public static SscsCaseData buildSscsCaseData(
        String caseReference,
        String subscribeEmail,
        String subscribeSms,
        EventType eventType
    ) {
        Name name = Name.builder()
            .title("Mr")
            .firstName("User")
            .lastName("Test")
            .build();
        Contact contact = Contact.builder()
            .email("mail@email.com")
            .phone("01234567890")
            .build();
        Identity identity = Identity.builder()
            .dob("1904-03-10")
            .nino("AB 22 55 66 B")
            .build();
        Appellant appellant = Appellant.builder()
            .name(name)
            .contact(contact)
            .identity(identity)
            .build();

        HearingOptions hearingOptions = HearingOptions.builder()
            .wantsToAttend("Yes")
            .wantsSupport("Yes")
            .languageInterpreter("Yes")
            .other("No")
            .build();

        final Appeal appeal = Appeal.builder()
            .appellant(appellant)
            .benefitType(BenefitType.builder().code("ESA").build())
            .hearingOptions(hearingOptions)
            .build();

        Event events = Event.builder()
            .value(EventDetails.builder()
                .type(eventType.getCcdType())
                .description("Some Events")
                .date("2017-05-24T14:01:18.243")
                .build())
            .build();

        Subscription appellantSubscription = Subscription.builder()
            .tya("")
            .email("sscstest+notify@greencroftconsulting.com")
            .mobile("07398785050")
            .subscribeEmail(subscribeEmail)
            .subscribeSms(subscribeSms)
            .build();
        Subscription supporterSubscription = Subscription.builder()
            .tya("")
            .email("")
            .mobile("")
            .subscribeEmail("No")
            .subscribeSms("No")
            .build();
        Subscriptions subscriptions = Subscriptions.builder()
            .appellantSubscription(appellantSubscription)
            .supporterSubscription(supporterSubscription)
            .build();

        return SscsCaseData.builder()
            .caseReference(caseReference)
            .appeal(appeal)
            .events(Collections.singletonList(events))
            .subscriptions(subscriptions)
            .build();
    }

    public static SscsCaseData buildBasicSscsCaseData(EventType notificationType) {
        return SscsCaseData.builder()
            .caseId(CASE_ID)
            .events(Collections.emptyList())
            .hearings(Collections.emptyList())
            .build();
    }

    public static SscsCaseData buildBasicSscsCaseDataWithEvent(
        EventType notificationType,
        EventType eventType,
        String eventDate
    ) {
        Event event = Event
            .builder()
            .value(EventDetails
                .builder()
                .date(eventDate)
                .type(eventType.getCcdType())
                .build()
            )
            .build();

        return SscsCaseData.builder()
            .caseId(CASE_ID)
            .events(Collections.singletonList(event))
            .hearings(Collections.emptyList())
            .build();
    }

    public static SscsCaseData buildBasicSscsCaseDataWithHearing(
        EventType notificationType,
        String hearingDate,
        String hearingTime
    ) {
        Hearing hearing = Hearing
            .builder()
            .value(HearingDetails
                .builder()
                .hearingDate(hearingDate)
                .time(hearingTime)
                .build()
            )
            .build();

        return SscsCaseData.builder()
            .caseId(CASE_ID)
            .events(Collections.emptyList())
            .hearings(Collections.singletonList(hearing))
            .build();
    }

    public static void addEventTypeToCase(SscsCaseData response, EventType eventType) {
        Date now = new Date();
        SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.SSS");

        Event events = Event.builder()
            .value(EventDetails.builder()
                .type(eventType.getCcdType())
                .description(eventType.getCcdType())
                .date(dt1.format(now))
                .build())
            .build();

        List<Event> addedEvents = new ArrayList<>(response.getEvents());
        addedEvents.add(events);
        response.setEvents(addedEvents);
    }

    public static void addEvidence(SscsCaseData response) {
        List<Document> documents = new ArrayList<>();

        Document doc = Document.builder().value(DocumentDetails.builder()
            .dateReceived("2016-01-01")
            .evidenceType("Medical")
            .evidenceProvidedBy("Caseworker").build()).build();

        documents.add(doc);

        Evidence evidence = Evidence.builder().documents(documents).build();

        response.setEvidence(evidence);
    }

    public static List<Hearing> addHearing(SscsCaseData response, Integer hearingDaysFromNow) {
        Hearing hearing = Hearing.builder().value(HearingDetails.builder()
            .hearingDate(LocalDate.now().plusDays(hearingDaysFromNow).toString())
            .time("23:59")
            .venue(Venue.builder()
                .name("The venue")
                .address(Address.builder()
                    .line1("12 The Road Avenue")
                    .line2("Village")
                    .town("Aberdeen")
                    .county("Aberdeenshire")
                    .postcode("AB12 0HN").build())
                .googleMapLink("http://www.googlemaps.com/aberdeenvenue")
                .build()).build()).build();

        List<Hearing> hearingsList = new ArrayList<>();
        hearingsList.add(hearing);
        response.setHearings(hearingsList);

        return hearingsList;
    }

}