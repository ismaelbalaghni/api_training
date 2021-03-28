package fr.esiea.ex4A.meetify;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserData {
    public final String email;
    public final String name;
    public final String twitter;
    public final String country;
    public final String sex;
    public final String sexPref;

    public UserData(@JsonProperty("userEmail") String email, @JsonProperty("userName") String name, @JsonProperty("userTweeter") String twitter, @JsonProperty("userCountry") String country, @JsonProperty("userSex") String sex, @JsonProperty("userSexPref") String sexPref) {
        this.email = email;
        this.name = name;
        this.twitter = twitter;
        this.country = country;
        this.sex = sex;
        this.sexPref = sexPref;
    }

    public UserData(String name, String twitter) {
        this.email = "";
        this.country = "";
        this.sex = "";
        this.sexPref = "";
        this.name = name;
        this.twitter = twitter;
    }

    @Override
    public String toString() {
        return "UserData{" +
            "userEmail='" + email + '\'' +
            ", userName='" + name + '\'' +
            ", userTweeter='" + twitter + '\'' +
            ", userCountry='" + country + '\'' +
            ", userSex='" + sex + '\'' +
            ", userSexPref='" + sexPref + '\'' +
            '}';
    }
}
