package com.if4a.cobalogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    KendaliLogin KL = new KendaliLogin();
    private TextView tvSesi;
    private Button btnLogut;
    public static String keySPusername = "W1c5exmvLLmvnvPAZi4VCVp68uUcsK/jfU6yy6ktYgU=_Username";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(KL.isLogin(MainActivity.this,keySPusername)==true){
            setContentView(R.layout.activity_main);

            tvSesi = findViewById(R.id.tv_sesi);
            btnLogut = findViewById(R.id.btn_logout);
        }
        else{
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            finish();
        }
    }
}