package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);


        Button btnconnectjava = findViewById(R.id.btnconnect1);
        btnconnectjava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText txtuserjava = findViewById(R.id.txtuser);
                EditText txtpwdjava = findViewById(R.id.txtpwd);
                String msg = txtuserjava.getText().toString() + " " + txtpwdjava.getText().toString();

                TextView txterroruserjava = findViewById(R.id.txterroruser);
                TextView txterrorpwdjava = findViewById(R.id.txterrorpwd);
                if(txtuserjava.getText().toString().matches("")){
                    txterroruserjava.setText("Ce champ est requis.");
                    //txterroruserjava.setPadding(0,5,0,10);
                }else{
                    txterroruserjava.setText("");
                }

                Intent Activity2Intent = new Intent(MainActivity.this, Activity2.class);

                startActivity(Activity2Intent);
                finish();

            }
        });




    }
}