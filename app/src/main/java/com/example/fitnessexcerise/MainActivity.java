package com.example.fitnessexcerise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fitnessexcerise.Adapters.ExercisesAdapter;
import com.example.fitnessexcerise.GlobalClasses.GlobalData;
import com.example.fitnessexcerise.Models.Exercise;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    //Recycler View of Exercises
    RecyclerView exercise_rv;
    List<Exercise> exercisesList;
    ExercisesAdapter adapter;

    //Users Number
    EditText et_users;


    //Buttons
    TextView btn_continue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Home");

        getReferences();

        setExercises();

        setRecyclerViewData();

        setBtnClicks();


    }

    //All Btn clicks
    private void setBtnClicks() {

        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (GlobalData.list.size() < 1) {
                    Toast.makeText(MainActivity.this, "Add Some Exercises first !!!", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("list",GlobalData.list);
                startActivity(intent);

            }
        });


    }


    //Setting Exercises Recycler View
    private void setRecyclerViewData() {

        exercise_rv.setHasFixedSize(true);
        exercise_rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        exercise_rv.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }


    //Setting Exercises for custom layout
    private void setExercises() {

        int[] drawablesArray = {
                R.drawable.img_1, R.drawable.img_2, R.drawable.img_3,
                R.drawable.img_4, R.drawable.img_5, R.drawable.img_6,};

        ArrayList<String> exerciseNames = new ArrayList<>();
        exerciseNames.add("A Skip");
        exerciseNames.add("B Skip");
        exerciseNames.add("High Knees");
        exerciseNames.add("Icky Shuffle");
        exerciseNames.add("Two Feet In");
        exerciseNames.add("4 Cone Drill");
        exerciseNames.add("40 Yard Dash");
        exerciseNames.add("Shuttle Run");
        exerciseNames.add("One on One");
        exerciseNames.add("Half Gassers");

        int i = 0;
        for (String s : exerciseNames) {
            Exercise exercise = new Exercise();
            if (i == 6) {
                i = 0;
            }
            exercise.setImg(drawablesArray[i++]);
            exercise.setName(s);
            exercisesList.add(exercise);
        }
    }


    //Getting references of components
    private void getReferences() {
        exercise_rv = findViewById(R.id.exercise_rv);
        exercisesList = new ArrayList<>();
        btn_continue = findViewById(R.id.btn_continue);
        et_users = findViewById(R.id.et_users);
        adapter = new ExercisesAdapter(this, exercisesList);
    }
}