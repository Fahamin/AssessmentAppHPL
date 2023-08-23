package com.fahamin.assessmentapphpl.registration;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.fahamin.assessmentapphpl.HomeActivity;
import com.fahamin.assessmentapphpl.R;
import com.fahamin.assessmentapphpl.databinding.ActivityMainBinding;
import com.fahamin.assessmentapphpl.databinding.ActivityRegistrationBinding;
import com.fahamin.assessmentapphpl.utils.TinyDB;

public class RegistrationActivity extends AppCompatActivity {

    ActivityRegistrationBinding binding;
    RegistrationViewModel viewModel;

    String name, email, number;
    TinyDB tinyDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegistrationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(RegistrationViewModel.class);
        number = getIntent().getStringExtra("num");
        tinyDB = new TinyDB(this);
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!(binding.txtName.getText().toString().equals("") ||
                        binding.txtEmail.getText().toString().equals("") ||
                        binding.txtPwd.getText().toString().equals(""))) {

                    tinyDB.putString("name", binding.txtName.getText().toString());
                    tinyDB.putString("email", binding.txtEmail.getText().toString());
                    tinyDB.putString("num", binding.txtPwd.getText().toString());

                    viewModel.registration(binding.txtName.getText().toString(),
                            binding.txtEmail.getText().toString(),
                            binding.txtPwd.getText().toString()).observe(RegistrationActivity.this, new Observer<String>() {
                        @Override
                        public void onChanged(String response) {
                            Log.e("fahamin", response);
                            startActivity(new Intent(RegistrationActivity.this, HomeActivity.class));
                        }

                    });
                }


            }
        });
    }
}