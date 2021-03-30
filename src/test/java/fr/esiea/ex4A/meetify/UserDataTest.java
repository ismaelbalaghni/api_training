package fr.esiea.ex4A.meetify;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class UserDataTest {

    @ParameterizedTest
    @CsvSource({
        "Marlon, Marlon",
        "Juan, Juan",
        "Fabrice, Fabrice"
    })
    void creating_a_new_user_with_a_name_should_give_the_same_name(String wantedName, String expectedName){
        UserData userData = new UserData("",wantedName,"","","","");
        Assertions.assertThat(userData.getName()).isEqualTo(expectedName);
    }

    @ParameterizedTest
    @CsvSource({
        "a@a.com, a@a.com",
        "b@b.us, b@b.us",
        "c@gmail.com, c@gmail.com"
    })
    void creating_a_new_user_with_an_email_should_give_the_same_email(String wantedValue, String expectedValue){
        UserData userData = new UserData(wantedValue, "test", "","","","");
        Assertions.assertThat(userData.getEmail()).isEqualTo(expectedValue);
    }

    @ParameterizedTest
    @CsvSource({
        "jack, jack",
        "ElonMusk, ElonMusk"
    })
    void creating_a_new_user_with_a_count_should_give_the_same_count(String wantedValue, String expectedValue){
        UserData userData = new UserData("", "test", wantedValue,"","","");
        Assertions.assertThat(userData.getTwitter()).isEqualTo(expectedValue);
    }

    @ParameterizedTest
    @CsvSource({
        "US, US",
        "AR, AR",
        "FR, FR"
    })
    void creating_a_new_user_with_a_country_should_give_the_same_country(String wantedValue, String expectedValue){
        UserData userData = new UserData(wantedValue, "test", "",wantedValue,"","");
        Assertions.assertThat(userData.getCountry()).isEqualTo(expectedValue);
    }

    @ParameterizedTest
    @CsvSource({
        "M, M",
        "F, F"
    })
    void creating_a_new_user_with_a_sex_should_give_the_same(String wantedValue, String expectedValue){
        UserData userData = new UserData(wantedValue, "test", "","",wantedValue,"");
        Assertions.assertThat(userData.getSex()).isEqualTo(expectedValue);
    }

    @ParameterizedTest
    @CsvSource({
        "F, F",
        "M, M"
    })
    void creating_a_new_user_with_a_sexpref_should_give_the_same(String wantedValue, String expectedValue){
        UserData userData = new UserData("wantedValue", "test", "","","",wantedValue);
        Assertions.assertThat(userData.getSexPref()).isEqualTo(expectedValue);
    }
}
