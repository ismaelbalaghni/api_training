package fr.esiea.ex4A.meetify;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MeetifyController {
    private final MeetifyRepository meetifyRepository;

    public MeetifyController(MeetifyRepository meetifyRepository) { this.meetifyRepository = meetifyRepository; }

    @PostMapping("/api/inscription")
    public void inscription(@RequestBody UserData userData) throws InterruptedException {
        System.out.println(userData);
        meetifyRepository.addNewUser(userData);
    }

    @GetMapping(path = "/api/matches", produces = MediaType.APPLICATION_JSON_VALUE)
    List<UserData> getMatchingUsers(@RequestParam(name = "userName", required = true) String name, @RequestParam(name = "userCountry", required = true) String country) {
        List<UserData> userList = List.of(
            new UserData("Alberto", "berto45")
        );
        return userList;
    }
}
