package com.example.swimmingpool_rs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        final EditText username = findViewById(R.id.et_username);
        final EditText password = findViewById(R.id.et_password);

        final Button login = findViewById(R.id.btnLogin);
        final Button signup = findViewById(R.id.btnSignup);

        dbHandler = new DBHandler(LoginActivity.this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameTxt = username.getText().toString();
                String passwordTxt = password.getText().toString();

                if (usernameTxt.isEmpty() || passwordTxt.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Please enter your details", Toast.LENGTH_SHORT).show();
                } else {
                    Boolean checkuser = dbHandler.checkUsername(usernameTxt);
                    if (checkuser) {
                        Boolean verify = dbHandler.verifyUser(usernameTxt, passwordTxt);
                        if (verify) {
                            String name = username.getText().toString();

                            Intent intent = new Intent(getBaseContext(), MainActivity.class);
                            intent.putExtra("EXTRA_SESSION_NAME", name);
                            startActivity(intent);

                            Toast.makeText(LoginActivity.this, "You can Log in now !", Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(LoginActivity.this, "Wrong Password !", Toast.LENGTH_SHORT).show();
                            password.setText("");
                        }
                    } else {
                        Toast.makeText(LoginActivity.this, "No Username Found", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });
    }
}