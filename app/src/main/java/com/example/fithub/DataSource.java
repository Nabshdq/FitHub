package com.example.fithub;

import com.example.fithub.model.Exercise;
import java.util.ArrayList;

public class DataSource {
    public static ArrayList<Exercise> getExercises() {
        ArrayList<Exercise> exercises = new ArrayList<>();
        exercises.add(new Exercise("Bands", "Exercise using resistance bands", R.drawable.bands));
        exercises.add(new Exercise("Barbell", "Exercise using barbell", R.drawable.barbell));
        exercises.add(new Exercise("Body Only", "Exercise with body weight", R.drawable.body_only));
        exercises.add(new Exercise("Cable", "Exercise using cable machines", R.drawable.cable));
        exercises.add(new Exercise("Dumbbell", "Exercise using dumbbells", R.drawable.dumbell));
        exercises.add(new Exercise("E-Z Curl Bar", "Exercise using E-Z curl bar", R.drawable.e_z_curl_bar));
        exercises.add(new Exercise("Exercise Ball", "Exercise using exercise ball", R.drawable.exercise_ball));
        exercises.add(new Exercise("Foam Roll", "Exercise using foam roll", R.drawable.foam_roll));
        exercises.add(new Exercise("Kettlebells", "Exercise using kettlebells", R.drawable.kettlebells));
        exercises.add(new Exercise("Machine", "Exercise using machines", R.drawable.machine));
        exercises.add(new Exercise("Medicine Ball", "Exercise using medicine ball", R.drawable.medicine_ball));
        return exercises;
    }
}
