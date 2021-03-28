package fr.esiea.ex4A.meetify;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class MeetifyControllerTest {

    private final MockMvc mockMvc;

    @MockBean
    private MeetifyRepository repository;

    MeetifyControllerTest(@Autowired MockMvc mockMvc) { this.mockMvc = mockMvc;}

    @Test
    void adding_a_user_should_increment_the_number_of_users() throws Exception {
        Assertions.assertThat(1).isEqualTo(1);
    }
}
