package fr.esiea.ex4A.meetify;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;

@Service
public class AgifyService {

    public final AgifyClient agifyClient;
    public final MeetifyRepository meetifyRepository = new MeetifyRepository();

    public AgifyService(AgifyClient agifyClient) {
        this.agifyClient = agifyClient;
    }

    public void addUser(UserData user) throws IOException {
        AgifyUser agifyUser;
        if(!meetifyRepository.seeIfUserExists(user)){
            agifyUser = this.agifyClient.getUserAge(user.name, user.country).execute().body();
            meetifyRepository.addNewUser(user, agifyUser);
        }
    }

    public ArrayList<UserData> matchUser(String userName, String userCountry){
        UserData userRequestingMatch = meetifyRepository.getUser(userName, userCountry);
        if(userRequestingMatch != null){
            return meetifyRepository.matchUser(userRequestingMatch);
        } else {
            return new ArrayList<>();
        }
    }
}
