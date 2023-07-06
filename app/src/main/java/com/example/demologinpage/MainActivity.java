package com.example.demologinpage;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);

        Button loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if (isValidCredentials(username, password)) {
//                        if (password.equals("Fin@123")) {
   //                 if(username.trim().equalsIgnoreCase("Shaheen")) {
                    if(username.trim().equalsIgnoreCase("Fininfocom")) {


                        if (password.length() >= 7) {
                            if (Pattern.compile("[A-Z]").matcher(password).find()) {
                                if (Pattern.compile("[^a-zA-Z0-9]").matcher(password).find()) {
                                    if (Pattern.compile("[0-9]").matcher(password).find()) {
                            //            if (password.equals("Shaheen@123")) {
                                        if (password.equals("Fin@123")) {

                                            displayDummyData();
                                        }else{
                                            Toast.makeText(MainActivity.this, "UserName OR Password is wrong", Toast.LENGTH_SHORT).show();

                                        }
                                    }else{
                                        Toast.makeText(MainActivity.this, "Password must be 7 Characters with 1 UpperCase Alphabet and 1 Special Character and Numeric", Toast.LENGTH_SHORT).show();

                                    }

                                }else{
                                    Toast.makeText(MainActivity.this, "Password must be 7 Characters with 1 UpperCase Alphabet and 1Special Character and Numeric", Toast.LENGTH_SHORT).show();

                                }
                            }else{
                                Toast.makeText(MainActivity.this, "Password must be 7 Characters with 1 UpperCase Alphabet and 1Special Character and Numeric", Toast.LENGTH_SHORT).show();

                            }

                        } else {
                            Toast.makeText(MainActivity.this, "Password must be 7 Characters with 1 UpperCase Alphabet and 1 Special Character and Numeric", Toast.LENGTH_SHORT).show();

                        }

                    } else {
                        Toast.makeText(MainActivity.this, "UserName OR Password is wrong", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean isValidCredentials(String username, String password) {
        return !TextUtils.isEmpty(username) && !TextUtils.isEmpty(password);
    }

    private void displayDummyData() {
        Intent intent = new Intent(MainActivity.this, DummyDataActivity.class);
        startActivity(intent);
        finish();
    }
}