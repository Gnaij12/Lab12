package com.example.lab12;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

    public class MainActivity extends AppCompatActivity {
        private FirebaseAuth mAuth;
        private EditText email;
        private EditText password;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            mAuth = FirebaseAuth.getInstance();
            email = findViewById(R.id.email);
            password = findViewById(R.id.password);
        }

        public void createAccount(View view) {
            String emailStr = email.getText().toString();
            String passwordStr = password.getText().toString();
            mAuth.createUserWithEmailAndPassword(emailStr, passwordStr)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                System.out.println("Testing: "+mAuth.getCurrentUser().getEmail());
                            } else {
                                // If sign in fails, display a message to the user.
                                System.out.println("Testing: failed to create account");
                            }

                            // ...
                        }
                    });
        }

        public void signIn(View view) {
            String emailStr = email.getText().toString();
            String passwordStr = password.getText().toString();
            mAuth.signInWithEmailAndPassword(emailStr, passwordStr)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                System.out.println("Testing: "+mAuth.getCurrentUser().getEmail());
                            } else {
                                // If sign in fails, display a message to the user.
                                System.out.println("Testing: failed to create account");
                            }
                        }
                    });
        }
    }