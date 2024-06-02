package com.example.fithub.network;

import com.example.fithub.model.Exercise;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface ApiService {
    @Headers({
            "X-RapidAPI-Key: a72e40f78dmshf411ffd01166e41p175003jsn0b4e3c5",
            "X-RapidAPI-Host: exercise-db-fitness-workout-gym.p.rapidapi.com"
    })
    @GET("exercises")
    Call<List<Exercise>> getExercises();
}
