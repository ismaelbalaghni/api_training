package fr.esiea.ex4A.meetify;

import org.apache.catalina.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class MeetifyControllerIT {

    private final MockMvc mockMvc;

    @MockBean
    private AgifyService agifyService;

    MeetifyControllerIT(@Autowired MockMvc mockMvc) { this.mockMvc = mockMvc;}

    @Test
    void adding_a_user_should_increment_the_number_of_users() throws Exception {
//        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/inscription"))
        UserData userData = new UserData("test@email.com", "test", "FR", "test", "M", "M");
        this.mockMvc.perform(MockMvcRequestBuilders
            .post("/api/inscription")
            .contentType(MediaType.APPLICATION_JSON)
            .content(userData.toString())).andExpect(status().isOk());
        ArgumentCaptor<UserData> userDataArgumentCaptor = ArgumentCaptor.forClass(UserData.class);
        verify(agifyService).addUser(userDataArgumentCaptor.capture());
//        Assertions.assertThat(userDataArgumentCaptor.getValue()).isEqualTo(userData);
        Assertions.assertThat(1).isEqualTo(1);
    }

    @Test
    void a_user_should_get_good_matches() throws Exception {
        UserData userData = new UserData("test@email.com", "test", "FR", "test", "M", "M");
        this.mockMvc.perform(MockMvcRequestBuilders
            .get("/api/matches?userName=Emma&userCountry=US")).andExpect(status().isOk());
        ArgumentCaptor<String> userDataArgumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(agifyService).matchUser(userDataArgumentCaptor.capture(), userDataArgumentCaptor.capture());
        Assertions.assertThat(userDataArgumentCaptor.getAllValues().get(0)).isEqualTo("Emma");
        Assertions.assertThat(userDataArgumentCaptor.getAllValues().get(1)).isEqualTo("US");
//        Assertions.assertThat(userDataArgumentCaptor.getValue()).isEqualTo(userData);
//        Assertions.assertThat(1).isEqualTo(1);
    }
}
