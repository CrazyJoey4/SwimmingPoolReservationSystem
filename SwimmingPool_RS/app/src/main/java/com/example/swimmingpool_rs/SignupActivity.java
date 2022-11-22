package com.example.swimmingpool_rs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignupActivity extends AppCompatActivity {

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://swimmingpoolreservation-f5910-default-rtdb.asia-southeast1.firebasedatabase.app/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        final EditText username = findViewById(R.id.editTextTextUsername);
        final EditText fullname = findViewById(R.id.editTextTextFullname);
        final EditText email = findViewById(R.id.editTextTextEmailAddress);
        final EditText password = findViewById(R.id.editTextTextPassword);

        final Button signup = findViewById(R.id.btnSignup);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //get input data from user
                final String usernameTxt = username.getText().toString();
                final String fullnameTxt = fullname.getText().toString();
                final String emailTxt = email.getText().toString();
                final String passwordTxt = password.getText().toString();

                if(usernameTxt.isEmpty() || fullnameTxt.isEmpty() || emailTxt.isEmpty() || passwordTxt.isEmpty()) {
                    Toast.makeText(SignupActivity.this, "Please enter your details", Toast.LENGTH_SHORT).show();
                }
                else{

                    databaseReference.child("users").addListenerForSingleValueEvent((new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {

                            //check if the email is not registered
                            if(snapshot.hasChild(emailTxt)) {
                                Toast.makeText(SignupActivity.this, "This email already registered before", Toast.LENGTH_SHORT).show();
                            }
                            else {

                                //send data to firebase
                                //use email as unique identity
                                databaseReference.child("users").child(emailTxt).child("username").setValue(usernameTxt);
                                databaseReference.child("users").child(emailTxt).child("fullname").setValue(fullnameTxt);
                                databaseReference.child("users").child(emailTxt).child("email").setValue(emailTxt);
                                databaseReference.child("users").child(emailTxt).child("password").setValue(passwordTxt);

                                //show a success message
                                Toast.makeText(SignupActivity.this, "Sign Up successfully", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    }));
                }
            }
        });
    }
}