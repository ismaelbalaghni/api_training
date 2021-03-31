package fr.esiea.ex4A.meetify;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class MeetifyRepositoryTest {
    private final MeetifyRepository meetifyRepository = new MeetifyRepository();

    @Test
    void having_no_users_should_return_no_users(){
        Assertions.assertThat(meetifyRepository.getNumberOfUsers()).isEqualTo(0);
    }

    @Test
    void adding_a_user_to_repository_increments_number_of_users(){
        UserData userData = new UserData("test", "test", "test", "test", "test", "test");
        AgifyUser agifyUser = new AgifyUser("test", 50, 500, "US");
        meetifyRepository.addNewUser(userData, agifyUser);
        Assertions.assertThat(meetifyRepository.getNumberOfUsers()).isEqualTo(1);
    }

    @Test
    void adding_multiple_users_should_increment_the_number_of_users(){
        UserData userData1 = new UserData("test1", "test1", "test1", "test1", "test1", "test1");
        UserData userData2 = new UserData("test2", "test2", "test2", "test2", "test2", "test2");
        UserData userData3 = new UserData("test3", "test3", "test3", "test3", "test3", "test3");
        UserData userData4 = new UserData("test4", "test4", "test4", "test4", "test4", "test4");
        AgifyUser agifyUser1 = new AgifyUser("test", 50, 500, "US");
        AgifyUser agifyUser2 = new AgifyUser("test", 50, 500, "US");
        AgifyUser agifyUser3 = new AgifyUser("test", 50, 500, "US");
        AgifyUser agifyUser4 = new AgifyUser("test", 50, 500, "US");
        meetifyRepository.addNewUser(userData1, agifyUser1);
        meetifyRepository.addNewUser(userData2, agifyUser2);
        meetifyRepository.addNewUser(userData3, agifyUser3);
        meetifyRepository.addNewUser(userData4, agifyUser4);
        Assertions.assertThat(meetifyRepository.getNumberOfUsers()).isEqualTo(4);
        Assertions.assertThat(4).isEqualTo(4);
    }

    @Test
    void searching_if_a_user_exists(){
        UserData userData1 = new UserData("test1", "test1", "test1", "test1", "test1", "test1");
        UserData userData2 = new UserData("test2", "test2", "test2", "test2", "test2", "test2");
        AgifyUser agifyUser1 = new AgifyUser("test", 50, 500, "US");
        AgifyUser agifyUser2 = new AgifyUser("test", 50, 500, "US");
        meetifyRepository.addNewUser(userData1, agifyUser1);
        meetifyRepository.addNewUser(userData2, agifyUser2);
        UserData requestedUser1 = meetifyRepository.getUser(userData1.name, userData1.country);
        UserData requestedUser2 = meetifyRepository.getUser(userData2.name, userData2.country);
        Assertions.assertThat(requestedUser1).isEqualTo(userData1);
        Assertions.assertThat(requestedUser2).isEqualTo(userData2);
    }

    @Test
    void list_of_matching_users_should_give_users(){
        UserData userData1 = new UserData("test1", "test1", "test1", "US", "M", "F");
        UserData userData2 = new UserData("test2", "test2", "test2", "US", "F", "M");
        UserData userData3 = new UserData("test3", "test3", "test3", "US", "F", "M");
        AgifyUser agifyUser1 = new AgifyUser("test1", 50, 500, "US");
        AgifyUser agifyUser2 = new AgifyUser("test2", 48, 500, "US");
        AgifyUser agifyUser3 = new AgifyUser("test3", 53, 500, "US");
        meetifyRepository.addNewUser(userData1, agifyUser1);
        meetifyRepository.addNewUser(userData2, agifyUser2);
        meetifyRepository.addNewUser(userData3, agifyUser3);
        ArrayList<UserData> userDataArrayList = meetifyRepository.matchUser(userData1);
        ArrayList<UserData> expectedArrayList = new ArrayList<>();
        expectedArrayList.add(userData2);
        expectedArrayList.add(userData3);
        Assertions.assertThat(userDataArrayList).isEqualTo(expectedArrayList);
    }
}
