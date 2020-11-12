package com.example.pardus_point;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class activity_login extends AppCompatActivity {

    Button btnLogin;
    EditText etUsername , etPassword;
    ProgressBar progressBar;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        mAuth = FirebaseAuth.getInstance();
        btnLogin = findViewById(R.id.btn_login);
        etPassword =findViewById(R.id.et_password);
        etUsername = findViewById(R.id.et_username);
        progressBar=findViewById(R.id.progressbar);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                userLogin();
                Intent loginIntent = new Intent(activity_login.this, menu.class);
                startActivity(loginIntent);
            }
        });
    }

    private void userLogin() {

        String email = etUsername.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if (email.isEmpty()){
            etUsername.setError("Email is required");
            etUsername.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            etUsername.setError("Please enter a valid email");
            etUsername.requestFocus();
            return;
        }
        if (password.isEmpty()){
            etPassword.setError("Password is Required");
            etPassword.requestFocus();
            return;
        }
        progressBar.setVisibility(View.VISIBLE);
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

            }
        });


    }
}
