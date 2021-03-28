package fr.esiea.ex4A.meetify;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MeetifyRepository {
    final List<UserData> users = new ArrayList<>();

    int getNumberOfUsers(){
        return this.users.size();
    }

    void addNewUser(UserData userData){
        this.users.add(userData);
    }
}
