package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class Inscription extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_inscription);

        Button btninscriptionjava= findViewById(R.id.btninscription);
        Button btnconnect1java= findViewById(R.id.btnconnect1);
        btnconnect1java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Activity2Intent = new Intent(Inscription.this, MainActivity.class);
                startActivity(Activity2Intent);
                finish();
            }
        });
        btninscriptionjava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText firstnamejava = findViewById(R.id.firstname);
                EditText lastnamejava = findViewById(R.id.lastname);
                EditText usernamejava = findViewById(R.id.username);
                EditText cinjava = findViewById(R.id.cin);
                EditText pwdjava = findViewById(R.id.pwd);
                User usertoinsert = new User(usernamejava.getText().toString(), pwdjava.getText().toString(), cinjava.getText().toString(), firstnamejava.getText().toString(), lastnamejava.getText().toString());
                UserDB userbdd = new UserDB(getApplicationContext());
                userbdd.open();
                userbdd.insertUser(usertoinsert);
                userbdd.close();
                Intent Activity2Intent = new Intent(Inscription.this, MainActivity.class);
                startActivity(Activity2Intent);


            }
        });

    }
}