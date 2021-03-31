package fr.esiea.ex4A.meetify;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class AgifyUserTest {


    @ParameterizedTest
    @CsvSource({
        "Marlon, Marlon",
        "Juan, Juan",
        "Fabrice, Fabrice"
    })
    void creating_a_new_agifyuser_with_a_name_should_give_the_same_name(String wantedName, String expectedName){
        AgifyUser agifyUser = new AgifyUser(wantedName, 10, 10, "US");
        Assertions.assertThat(agifyUser.getName()).isEqualTo(expectedName);
    }

    @ParameterizedTest
    @CsvSource({
        "44, 44",
        "56, 56",
        "49, 49"
    })
    void creating_a_new_agifyuser_with_an_age_should_give_the_same_age(int wantedAge, int expectedAge){
        AgifyUser agifyUser = new AgifyUser("test", wantedAge, 10, "US");
        Assertions.assertThat(agifyUser.getAge()).isEqualTo(expectedAge);
    }

    @ParameterizedTest
    @CsvSource({
        "1477, 1477",
        "569, 569",
        "4049, 4049"
    })
    void creating_a_new_agifyuser_with_a_count_should_give_the_same_count(int wantedCount, int expectedCount){
        AgifyUser agifyUser = new AgifyUser("test", 10, wantedCount, "US");
        Assertions.assertThat(agifyUser.getCount()).isEqualTo(expectedCount);
    }

    @ParameterizedTest
    @CsvSource({
        "US, US",
        "AR, AR",
        "FR, FR"
    })
    void creating_a_new_agifyuser_with_a_country_should_give_the_same_country(String wantedCountry, String expectedCountry){
        AgifyUser agifyUser = new AgifyUser("test", 10, 100, wantedCountry);
        Assertions.assertThat(agifyUser.getCountry_id()).isEqualTo(expectedCountry);
    }

    @ParameterizedTest
    @CsvSource({
        "Marco, IT, MarcoIT",
        "Karim, DZ, KarimDZ",
        "Jean, FR, JeanFR"
    })
    void testUserId(String name, String country, String userId) {
        AgifyUser agifyUser = new AgifyUser(name, 51, 144, country);
        Assertions.assertThat(agifyUser.getUserId()).isEqualTo(userId);
    }
}
