package com.example.sportzassignment.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sportzassignment.R;

public class DashBoardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        Button apiBtn1 = findViewById(R.id.apiBtn1);
        Button apiBtn2 = findViewById(R.id.apiBtn2);

        apiBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashBoardActivity.this,MainActivity.class);
                intent.putExtra("api","https://demo.sportz.io/nzin01312019187360.json");
                startActivity(intent);
            }
        });
        apiBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashBoardActivity.this,MainActivity.class);
                intent.putExtra("api","https://demo.sportz.io/sapk01222019186652.json");
                startActivity(intent);
            }
        });
    }
}