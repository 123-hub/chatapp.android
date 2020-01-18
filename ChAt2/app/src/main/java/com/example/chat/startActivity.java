package com.example.chat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class startActivity extends AppCompatActivity
{
  private Button btn;
  private Button btnn;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        btn=findViewById(R.id.start_reg_btn);
        btnn=findViewById(R.id.btn2);
        btn.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view) {

                Intent rintent = new Intent(startActivity.this,registerActivity.class);
                 startActivity(rintent);
                 finish();
            }
        });



    btnn.setOnClickListener(new View.OnClickListener()
    {

        @Override
        public void onClick(View view) {

        Intent rkintent = new Intent(startActivity.this,loginActivity.class);
        startActivity(rkintent);
        finish();
    }
    });
}
}
