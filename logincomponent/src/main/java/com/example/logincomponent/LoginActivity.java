package com.example.logincomponent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        String userId = getIntent().getStringExtra("userId");
        Toast.makeText(this,
                "从壳工程传递进行来的userId：" + userId,
                Toast.LENGTH_LONG).show();
    }
}
