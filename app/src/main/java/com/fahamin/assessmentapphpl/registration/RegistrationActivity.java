package com.fahamin.assessmentapphpl.registration;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.Toast;

import com.fahamin.assessmentapphpl.R;
import com.fahamin.assessmentapphpl.databinding.ActivityMainBinding;
import com.fahamin.assessmentapphpl.databinding.ActivityRegistrationBinding;

public class RegistrationActivity extends AppCompatActivity {

    ActivityRegistrationBinding binding;
    RegistrationViewModel viewModel;

    String name, email, number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegistrationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(RegistrationViewModel.class);
        number = getIntent().getStringExtra("num");
        binding.txtPwd.setText("+8801639467698");

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.registration(binding.txtName.getText().toString()
                        , binding.txtEmail.getText().toString(),
                        binding.txtPwd.getText().toString());

            }
        });
    }
}