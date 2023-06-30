package com.example.solfacare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText edUsername, edPassword;
    Button btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edUsername = findViewById(R.id.editTextLoginUsername);
        edPassword = findViewById(R.id.editTextLoginPassword);
        btn = findViewById(R.id.buttonLogin);
        tv = findViewById(R.id.textViewNewUser);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                /*String username = edUsername.getText().toString();
                String password = edPassword.getText().toString();
                Database db = new Database(getApplicationContext(), "SolfaCare", null, 1);
                if(username.length()==0 || password.length()==0){
                    Toast.makeText(getApplicationContext(), "Please fill All details", Toast.LENGTH_SHORT).show();
                }else {
                    if(db.Login(username, password)==1){
                        Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();
                        SharedPreferences sharedPreferences = getSharedPreferences("shared prefs", Context.MODE_PRIVATE );
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("username", username);
                        //To save our data with key and value
                        editor.apply();
                        startActivity(new Intent(LoginActivity.this,HomeActivity.class));
                    }else{
                        Toast.makeText(getApplicationContext(), "Invalid username and password", Toast.LENGTH_SHORT).show();
                    }

                 }*/
            }
        });

        tv.setOnClickListener(view -> startActivity(new Intent(LoginActivity.this,RegisterActivity.class)));

    }
}