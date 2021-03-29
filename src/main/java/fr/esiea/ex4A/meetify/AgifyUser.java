package fr.esiea.ex4A.meetify;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AgifyUser {

    public final String name;
    public final int age;
    public final int count;
    public final String country_id;

    public AgifyUser(@JsonProperty("name") String name, @JsonProperty("age") int age, @JsonProperty("count") int count, @JsonProperty("country_id") String country_id) {
        this.name = name;
        this.age = age;
        this.count = count;
        this.country_id = country_id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getCount() {
        return count;
    }

    public String getCountry_id() {
        return country_id;
    }



}
