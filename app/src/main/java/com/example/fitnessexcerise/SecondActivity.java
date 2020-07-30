package com.example.fitnessexcerise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fitnessexcerise.Adapters.SelectedExerciseAdapter;
import com.example.fitnessexcerise.Models.Exercise;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    
    TextView btn_submit;
    
    //Recycler View Data
    RecyclerView selected_exercises_rv;
    ArrayList<Exercise> list;
    SelectedExerciseAdapter adapter;
    
    
    //No of users
    int numberOfUsers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        
        getSupportActionBar().setTitle("Today's Workout");
        
        getIntents();
        
        getReferences();
        
        setRecyclerView();

        setBtnClicks();
        
    }

    //Button Click Functions
    private void setBtnClicks() {
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(SecondActivity.this, "Submitted", Toast.LENGTH_SHORT).show();
                
            }
        });
    }


    //Setting Selected Excersises
    private void setRecyclerView() {
        selected_exercises_rv.setHasFixedSize(true);
        selected_exercises_rv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        selected_exercises_rv.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    //Getting data passed from previous activity
    private void getIntents() {

        Intent intent = getIntent();
        list = (ArrayList<Exercise>) intent.getSerializableExtra("list");
        //Toast.makeText(this, "List: "+list+" Users: "+numberOfUsers, Toast.LENGTH_SHORT).show();
    }


    //Function for getting references
    private void getReferences() {

        selected_exercises_rv = findViewById(R.id.selected_exercises_rv);
        btn_submit = findViewById(R.id.btn_submit);
        adapter=new SelectedExerciseAdapter(this,list);
    }
}