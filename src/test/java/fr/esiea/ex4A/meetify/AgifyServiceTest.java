package fr.esiea.ex4A.meetify;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;

class AgifyServiceTest {



    AgifyClient agifyClient() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.agify.io/").addConverterFactory(JacksonConverterFactory.create()).build();
        return retrofit.create(AgifyClient.class);
    }

    AgifyClient mockAgifyClient = agifyClient();

    AgifyService agifyService = new AgifyService(mockAgifyClient);

    @Test
    void adding_a_user_should_increment_the_number_of_users() throws IOException {
        UserData userData = new UserData("marlon@mail.com", "Marlon", "marlon14", "US", "M", "F");
        agifyService.addUser(userData);
        Assertions.assertThat(agifyService.meetifyRepository.userList.get("MarlonUS")).isEqualTo(userData);
        Assertions.assertThat(agifyService.meetifyRepository.getNumberOfUsers()).isEqualTo(1);
    }

    @Test
    void adding_multiple_users_should_increment_the_number_of_users() throws IOException {
        UserData userData1 = new UserData("henri@mail.fr", "Henri", "bHenri", "FR", "M", "M");
        UserData userData2 = new UserData("juan@movistar.es", "Juan", "juanjuan", "ES", "M", "F");
        UserData userData3 = new UserData("elena@mail.ru", "Elena", "elenaaa", "RU", "F", "F");
        UserData userData4 = new UserData("marlon@mail.com", "Marlon", "marlon14", "US", "M", "F");
        agifyService.addUser(userData1);
        agifyService.addUser(userData2);
        agifyService.addUser(userData3);
        agifyService.addUser(userData4);
        Assertions.assertThat(agifyService.meetifyRepository.userList.get("HenriFR")).isEqualTo(userData1);
        Assertions.assertThat(agifyService.meetifyRepository.userList.get("JuanES")).isEqualTo(userData2);
        Assertions.assertThat(agifyService.meetifyRepository.userList.get("ElenaRU")).isEqualTo(userData3);
        Assertions.assertThat(agifyService.meetifyRepository.userList.get("MarlonUS")).isEqualTo(userData4);
        Assertions.assertThat(agifyService.meetifyRepository.getNumberOfUsers()).isEqualTo(4);
    }
}
