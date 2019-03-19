package uk.gov.hmcts.reform.sscs.ccd.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Builder(toBuilder = true)
public class Name {
    private String title;
    private String firstName;
    private String lastName;

    @JsonCreator
    public Name(@JsonProperty("title") String title,
                @JsonProperty("firstName") String firstName,
                @JsonProperty("lastName") String lastName) {
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @JsonIgnore
    public String getFullName() {
        return title + " " + firstName + " " + lastName;
    }

    @JsonIgnore
    public String getFullNameNoTitle() {
        return firstName + " " + lastName;
    }

    @JsonIgnore
    public String getAbbreviatedFullName() {
        return title + " " + firstName.substring(0, 1) + " " + lastName;
    }
}
