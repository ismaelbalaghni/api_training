package fr.esiea.ex4A.meetify;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

class AgifyClientIT {
    private final AgifyClient agifyClient;

    AgifyClientIT() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.agify.io")
            .addConverterFactory(JacksonConverterFactory.create()).build();
        this.agifyClient = retrofit.create(AgifyClient.class);
    }

    @ParameterizedTest
    @CsvSource({
        "michael, US, 69",
        "josh, CA, 41",
        "franck, FR, 48",
        "ramon, ES, 65"
    })
    void getAgeFromNames(String userName, String userCountry, int expectedAge){
        Call<AgifyUser> call = this.agifyClient.getUserAge(userName, userCountry);
        call.enqueue(new Callback<>() {
            @Override
            public void onResponse(Call<AgifyUser> call, Response<AgifyUser> response) {
                if (response.isSuccessful() && response.body() != null) {
                    AgifyUser agifyUser = response.body();
                    getAge(agifyUser, expectedAge);
                }
            }

            @Override
            public void onFailure(Call<AgifyUser> call, Throwable throwable) {
                System.out.println("Error on API");
            }
        });
    }

    private void getAge(AgifyUser agifyUser, int expectedAge){
        Assertions.assertThat(agifyUser.getAge()).isEqualTo(expectedAge);
    }
}
