package com.example.fithub;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.Toast;

import com.example.fithub.adapter.ExerciseAdapter;
import com.example.fithub.model.Exercise;
import com.example.fithub.network.ApiService;
import com.example.fithub.network.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
    private RecyclerView recyclerView;
    private ExerciseAdapter adapter;
    private List<Exercise> exerciseList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = view.findViewById(R.id.rv_post);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new ExerciseAdapter(exerciseList);
        recyclerView.setAdapter(adapter);
        fetchExercises();
        return view;
    }

    private void fetchExercises() {
        exerciseList = DataSource.getExercises();
        adapter.setExercises(exerciseList);
    }
}
