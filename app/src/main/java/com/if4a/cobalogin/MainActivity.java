package com.if4a.cobalogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    KendaliLogin KL = new KendaliLogin();
    private TextView tvSesi,tvName;
    private Button btnLogut;
    public static String keySPusername = "W1c5exmvLLmvnvPAZi4VCVp68uUcsK/jfU6yy6ktYgU=_Username";
    public static String keySPname = "W1c5exmvLLmvnvPAZi4VCVp68uUcsK/jfU6yy6ktYgU=_name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(KL.isLogin(MainActivity.this,keySPusername)==true){
            setContentView(R.layout.activity_main);

            tvSesi = findViewById(R.id.tv_sesi);
            tvName = findViewById(R.id.tv_name);
            btnLogut = findViewById(R.id.btn_logout);

            tvSesi.setText(KL.getPref(MainActivity.this,keySPusername));
            tvName.setText(KL.getPref(MainActivity.this,keySPname));
            btnLogut.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    KL.setPref(MainActivity.this,keySPusername,null);
                    KL.setPref(MainActivity.this,keySPname,null);
                    startActivity(new Intent(MainActivity.this,LoginActivity.class));
                    finish();

                }
            });
        }
        else{
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            finish();
        }
    }
}