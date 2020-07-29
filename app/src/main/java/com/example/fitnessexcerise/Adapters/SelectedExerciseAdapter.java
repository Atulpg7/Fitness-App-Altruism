package com.example.fitnessexcerise.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.fitnessexcerise.Models.Exercise;
import com.example.fitnessexcerise.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class SelectedExerciseAdapter extends RecyclerView.Adapter<SelectedExerciseAdapter.ViewHolder> {

    Context context;
    List<Exercise> list;

    public SelectedExerciseAdapter(Context context, List<Exercise> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.selected_exercise_rv, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Exercise exercise = list.get(position);
        holder.exercise_name.setText(exercise.getName());
        Glide.with(context).load(exercise.getImg()).into(holder.exercise_image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView exercise_image;
        TextView exercise_name;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            exercise_image = itemView.findViewById(R.id.excercise_image);
            exercise_name = itemView.findViewById(R.id.excercise_name);
        }
    }
}
