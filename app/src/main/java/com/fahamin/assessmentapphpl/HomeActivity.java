package com.fahamin.assessmentapphpl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.fahamin.assessmentapphpl.databinding.ActivityHomeBinding;
import com.fahamin.assessmentapphpl.taskData.CreateTaskData;
import com.fahamin.assessmentapphpl.taskData.HistoryActivity;
import com.fahamin.assessmentapphpl.utils.TinyDB;

public class HomeActivity extends AppCompatActivity {

    ActivityHomeBinding binding;
    TinyDB tinyDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        tinyDB = new TinyDB(this);
        binding.txtName.setText(tinyDB.getString("name"));
        binding.txtEmail.setText(tinyDB.getString("email"));
        binding.txtPwd.setText(tinyDB.getString("num"));

        binding.btnCreateNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, CreateTaskData.class));
            }
        });

        binding.btnhistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, HistoryActivity.class));
            }
        });

    }
}