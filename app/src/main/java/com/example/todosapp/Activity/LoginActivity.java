package com.example.todosapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.todosapp.R;

public class LoginActivity extends AppCompatActivity {

    TextView toRegisterBtn, toForgotBtn;
    EditText username, password;
    Button btnlogin;
    DBLogin DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.login_username1);
        password = findViewById(R.id.login_password1);
        toRegisterBtn = findViewById(R.id.to_register_button);
        btnlogin = findViewById(R.id.login_button);
        toForgotBtn = findViewById(R.id.to_forgot_button);
        DB = new DBLogin(this);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username.getText().toString();
                String pass = password.getText().toString();

                if (user.equals("") || pass.equals(""))
                    Toast.makeText(LoginActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass = DB.checkusernamepassword(user, pass);
                    Toast.makeText(LoginActivity.this, checkuserpass.toString(), Toast.LENGTH_SHORT).show();
                    if (checkuserpass == true){
                        Toast.makeText(LoginActivity.this, "Sign In Successfully", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(i);

                        overridePendingTransition(R.anim.phaiquatrai1,R.anim.phaiquatrai2);
                    } else {
                        Toast.makeText(LoginActivity.this, "Username or Password Error", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        toRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(i);

                overridePendingTransition(R.anim.phaiquatrai1,R.anim.phaiquatrai2);
            }
        });


    }


}