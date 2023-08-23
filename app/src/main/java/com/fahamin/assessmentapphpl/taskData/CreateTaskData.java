package com.fahamin.assessmentapphpl.taskData;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.fahamin.assessmentapphpl.HomeActivity;
import com.fahamin.assessmentapphpl.R;
import com.fahamin.assessmentapphpl.databinding.ActivityCreateTaskDataBinding;
import com.fahamin.assessmentapphpl.registration.RegistrationActivity;
import com.fahamin.assessmentapphpl.registration.RegistrationViewModel;
import com.fahamin.assessmentapphpl.utils.TinyDB;

public class CreateTaskData extends AppCompatActivity {

    ActivityCreateTaskDataBinding binding;

    TinyDB tinyDB;
    TaskViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCreateTaskDataBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        viewModel = new ViewModelProvider(this).get(TaskViewModel.class);

        tinyDB = new TinyDB(this);
        binding.btnTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!(binding.txtTitle.getText().toString().equals("") ||
                        binding.txtDetails.getText().toString().equals(""))) {

                    viewModel.createTask(binding.txtTitle.getText().toString(),
                            binding.txtDetails.getText().toString(),
                            tinyDB.getString("num")).observe(CreateTaskData.this, new Observer<String>() {
                        @Override
                        public void onChanged(String response) {
                            Log.e("fahamin", response);
                            startActivity(new Intent(CreateTaskData.this, HomeActivity.class));
                        }

                    });
                }


            }
        });


    }
}