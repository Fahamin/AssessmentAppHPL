package com.fahamin.assessmentapphpl.taskData;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.fahamin.assessmentapphpl.R;
import com.fahamin.assessmentapphpl.adapter.ExchangeAdapter;
import com.fahamin.assessmentapphpl.databinding.ActivityCreateTaskDataBinding;
import com.fahamin.assessmentapphpl.databinding.ActivityHistoryBinding;
import com.fahamin.assessmentapphpl.model.TaskModel;
import com.fahamin.assessmentapphpl.model.TaskModelItem;
import com.fahamin.assessmentapphpl.utils.TinyDB;

import java.util.List;

public class HistoryActivity extends AppCompatActivity {
    ActivityHistoryBinding binding;

    TinyDB tinyDB;
    HistoryViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHistoryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        viewModel = new ViewModelProvider(this).get(HistoryViewModel.class);
        tinyDB = new TinyDB(this);
        binding.btnGetTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.getTask(tinyDB.getString("num")).observe(HistoryActivity.this, new Observer<List<TaskModelItem>>() {
                    @Override
                    public void onChanged(List<TaskModelItem> taskModelItems) {
                        ExchangeAdapter adapter = new ExchangeAdapter(taskModelItems);
                        LinearLayoutManager manager = new LinearLayoutManager(HistoryActivity.this);
                        binding.rvLatestRate.setLayoutManager(manager);
                        binding.rvLatestRate.setAdapter(adapter);
                    }
                });
            }

        });
    }
}