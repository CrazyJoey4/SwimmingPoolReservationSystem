package com.example.swimmingpool_rs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignupActivity extends AppCompatActivity {

    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        final EditText username = findViewById(R.id.et_username);
        final EditText fullname = findViewById(R.id.et_fullname);
        final EditText email = findViewById(R.id.et_email);
        final EditText password = findViewById(R.id.et_password);

        final Button signup = findViewById(R.id.btnSignup);

        dbHandler = new DBHandler(SignupActivity.this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //get input data from user
                String usernameTxt = username.getText().toString();
                String fullnameTxt = fullname.getText().toString();
                String emailTxt = email.getText().toString();
                String passwordTxt = password.getText().toString();
                String userType = "User";

                if (usernameTxt.isEmpty() || fullnameTxt.isEmpty() || emailTxt.isEmpty() || passwordTxt.isEmpty()) {
                    Toast.makeText(SignupActivity.this, "Please enter your details", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    dbHandler.addNewUser(usernameTxt, fullnameTxt, emailTxt, passwordTxt, userType);
                    Toast.makeText(SignupActivity.this, "You have Sign Up!", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}