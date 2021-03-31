package fr.esiea.ex4A.meetify;

import org.apache.catalina.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
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

    @ParameterizedTest
    @CsvSource({
        "Josh, US, JoshUS",
        "Marlon, ES, MarlonES",
        "Elena, IT, ElenaIT",
        "Marc, FR, MarcFR"
    })
    void creating_a_new_user_should_give_the_good_id(String name, String country, String expectedId){
        UserData userData = new UserData("", name, "",country,"","");
        Assertions.assertThat(userData.getUserId()).isEqualTo(expectedId);
    }

    @Test
    void testToString() {
        String expectedString = "{\"userEmail\":\"test@test.com\",\"userName\":\"test\",\"userTweeter\":\"@test\",\"userCountry\":\"US\",\"userSex\":\"F\",\"userSexPref\":\"M\"}";
        UserData userData = new UserData("test@test.com", "test", "@test", "US", "F", "M");
        Assertions.assertThat(userData.toString()).isEqualTo(expectedString);
    }

    @ParameterizedTest
    @CsvSource({
        "Josh, @josh12, Josh, @josh12",
        "Marlon, @maarlon, Marlon, @maarlon"
    })
    void creating_a_new_user_using_second_constructor_should_be_ok(String name, String twitter, String expectedName, String expectedTwitter){
        UserData userData = new UserData(name, twitter);
        Assertions.assertThat(userData.getName()).isEqualTo(expectedName);
        Assertions.assertThat(userData.getTwitter()).isEqualTo(expectedTwitter);
    }
}
