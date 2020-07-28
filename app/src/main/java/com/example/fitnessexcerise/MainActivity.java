package com.example.fitnessexcerise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.example.fitnessexcerise.Adapters.ExercisesAdapter;
import com.example.fitnessexcerise.Models.Exercise;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    
    RecyclerView exercise_rv;
    List<Exercise> exercisesList;
    ExercisesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getReferences();
        setExercises();

        setRecyclerViewData();

        
        
    }

    private void setRecyclerViewData() {

        exercise_rv.setHasFixedSize(true);
        exercise_rv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        exercise_rv.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    private void setExercises() {

        ArrayList<String> exerciseNames = new ArrayList<>();
        exerciseNames.add("A Skip"); exerciseNames.add("B Skip");
        exerciseNames.add("High Knees"); exerciseNames.add("Icky Shuffle");
        exerciseNames.add("Two Feet In"); exerciseNames.add("4 Cone Drill");
        exerciseNames.add("40 Yard Dash"); exerciseNames.add("Shuttle Run");
        exerciseNames.add("One on One"); exerciseNames.add("Half Gassers");

        for(String s : exerciseNames){
            Exercise exercise = new Exercise();
            exercise.setName(s);

            exercisesList.add(exercise);
        }

    }

    private void getReferences() {

        exercise_rv = findViewById(R.id.exercise_rv);
        exercisesList = new ArrayList<>();
        adapter = new ExercisesAdapter(this,exercisesList);
    }
}