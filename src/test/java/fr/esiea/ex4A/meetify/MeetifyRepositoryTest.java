package fr.esiea.ex4A.meetify;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MeetifyRepositoryTest {
    private final MeetifyRepository meetifyRepository = new MeetifyRepository();

    @Test
    void having_no_users_should_return_no_users(){
        Assertions.assertThat(meetifyRepository.getNumberOfUsers()).isEqualTo(0);
    }

    @Test
    void adding_a_user_to_repository_increments_number_of_users(){
        UserData userData = new UserData("test", "test", "test", "test", "test", "test");
        meetifyRepository.addNewUser(userData);
        Assertions.assertThat(meetifyRepository.getNumberOfUsers()).isEqualTo(1);
    }

    @Test
    void adding_multiple_users_should_increment_the_number_of_users(){
        UserData userData1 = new UserData("test1", "test1", "test1", "test1", "test1", "test1");
        UserData userData2 = new UserData("test2", "test2", "test2", "test2", "test2", "test2");
        UserData userData3 = new UserData("test3", "test3", "test3", "test3", "test3", "test3");
        UserData userData4 = new UserData("test4", "test4", "test4", "test4", "test4", "test4");
        meetifyRepository.addNewUser(userData1);
        meetifyRepository.addNewUser(userData2);
        meetifyRepository.addNewUser(userData3);
        meetifyRepository.addNewUser(userData4);
        Assertions.assertThat(meetifyRepository.getNumberOfUsers()).isEqualTo(4);
    }
}
