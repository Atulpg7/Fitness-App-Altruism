package com.example.fitnessexcerise.Adapters;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.fitnessexcerise.GlobalClasses.GlobalData;
import com.example.fitnessexcerise.Models.Exercise;
import com.example.fitnessexcerise.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ExercisesAdapter extends RecyclerView.Adapter<ExercisesAdapter.ViewHolder> {

    Context context;
    List<Exercise> list;

    public ExercisesAdapter(Context context, List<Exercise> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_v_exercise, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        final Exercise exercise = list.get(position);

        //Setting Image and Exercise name
        holder.exercise_name.setText(exercise.getName());
        Glide.with(context).load(exercise.getImg()).into(holder.exercise_image);


        //When user enter no of users in edit text box then to change the no
        // of users accordingly in Exercise Class
        holder.et_users.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                if (!editable.toString().equals("")) {
                    if (Integer.parseInt(editable.toString()) < 1) {
                        Toast.makeText(context, "Minimum 1 Required !", Toast.LENGTH_SHORT).show();
                        holder.et_users.setText(String.valueOf(1));
                        return;
                    }
                    exercise.setNoOfusers(Integer.parseInt(editable.toString()));
                }
            }
        });


        //Button for add selected exercise
        holder.btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.btn_add.setVisibility(View.GONE);
                holder.btn_delete.setVisibility(View.VISIBLE);
                GlobalData.list.add(exercise);
                exercise.setNoOfusers(Integer.parseInt(holder.et_users.getText().toString()));
            }
        });


        //Button for delete selected exercise
        holder.btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.btn_add.setVisibility(View.VISIBLE);
                holder.btn_delete.setVisibility(View.GONE);
                GlobalData.list.remove(exercise);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView exercise_image;
        TextView exercise_name, btn_add, btn_delete;
        EditText et_users;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            exercise_image = itemView.findViewById(R.id.excercise_image);
            exercise_name = itemView.findViewById(R.id.excercise_name);
            btn_add = itemView.findViewById(R.id.btn_add);
            btn_delete = itemView.findViewById(R.id.btn_delete);
            et_users = itemView.findViewById(R.id.et_users);

        }
    }
}
