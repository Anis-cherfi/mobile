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


        Button btninscription = findViewById(R.id.btninscription);
        btninscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Activity2Intent = new Intent(MainActivity.this, Inscription.class);
                startActivity(Activity2Intent);
            }
        });

        Button btnconnectjava = findViewById(R.id.btnconnect1);
        btnconnectjava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText txtuserjava = findViewById(R.id.txtuser);
                EditText txtpwdjava = findViewById(R.id.txtpwd);
                String msg = txtuserjava.getText().toString() + " " + txtpwdjava.getText().toString();

                Boolean valid = Boolean.TRUE;
                TextView txterroruserjava = findViewById(R.id.txterroruser);
                TextView txterrorpwdjava = findViewById(R.id.txterrorpwd);
                if(txtuserjava.getText().toString().matches("")){
                    txterroruserjava.setText("Ce champ est requis.");
                    valid=Boolean.FALSE;
                }else {
                    txterroruserjava.setText("");
                }

                if(txtpwdjava.getText().toString().matches("")){
                    txterrorpwdjava.setText("Ce champ est requis.");
                    valid=Boolean.FALSE;
                }else {
                    txterrorpwdjava.setText("");
                }

                if(valid) {

                    UserDB userbdd = new UserDB(getApplicationContext());
                    userbdd.open();
                    int res= userbdd.getUserWithlog(txtuserjava.getText().toString(), txtpwdjava.getText().toString());


                    userbdd.close();


                    if(res>0){
                        Intent Activity2Intent = new Intent(MainActivity.this, Activity2.class);
                        startActivity(Activity2Intent);
                        finish();
                    }
                    else{
                        TextView txtuserexitjava = findViewById(R.id.txtuserexit);
                        txtuserexitjava.setText("Nom d'utilisateur ou mot de passe incorrect!");
                    }

                }







            }
        });




    }
}