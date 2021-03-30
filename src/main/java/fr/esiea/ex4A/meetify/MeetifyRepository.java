package fr.esiea.ex4A.meetify;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class MeetifyRepository {
    final HashMap<String, UserData> userList = new HashMap<>();
    final HashMap<String, AgifyUser> userListWithAge = new HashMap<>();

    int getNumberOfUsers(){
        return this.userList.size();
    }

    void addNewUser(UserData userData, AgifyUser userDataWithAge){
        this.userList.put(userData.getUserId(), userData);
        this.userListWithAge.put(userData.getUserId(), userDataWithAge);
    }

    boolean seeIfUserExists(UserData userData){
        return this.userList.containsKey(userData.getUserId());
    }

    UserData getUser(String userName, String countryId){
        return this.userList.get(userName.concat(countryId));
    }

    ArrayList<UserData> matchUser(UserData userData){
        ArrayList<UserData> matchingUsers = new ArrayList<>();
        for(Map.Entry<String, AgifyUser> userEntry : this.userListWithAge.entrySet()){
            if(Math.abs(userEntry.getValue().getAge() - this.userListWithAge.get(userData.getUserId()).getAge()) <= 4){
                UserData possiblyMatchingUser = this.userList.get(userEntry.getValue().getUserId());
                if(possiblyMatchingUser.getSex().equals(userData.getSexPref()) && userData.getSex().equals(possiblyMatchingUser.getSexPref())) {
                    matchingUsers.add(this.userList.get(userEntry.getValue().getUserId()));
                }
            }
        }
        return matchingUsers;
    }
}
