package com.example.chat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import androidx.appcompat.widget.Toolbar;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK;

public class registerActivity extends AppCompatActivity {
    TextInputLayout dname;
    TextInputLayout demail;
    TextInputLayout dpass;
    Button rbtn;
    FirebaseAuth mAuth;
    private Toolbar toolbar2;
    private ProgressDialog mpro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        toolbar2 = findViewById(R.id.tbar);
        setSupportActionBar(toolbar2);
        toolbar2.setTitle("<-CREATE ACCOUNT");
        mpro=new ProgressDialog(this);

    }
    public void loginpage(View v){
        Intent jintent = new Intent(registerActivity.this, loginActivity.class);
        startActivity(jintent);
        finish();





          mAuth = FirebaseAuth.getInstance();
        dname = (TextInputLayout) findViewById(R.id.regdisplay);
        demail = (TextInputLayout) findViewById(R.id.regemail);
        dpass = (TextInputLayout) findViewById(R.id.regpass);
        rbtn = (Button) findViewById(R.id.btncre);



       rbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = dname.getEditText().getText().toString();
                String email = demail.getEditText().getText().toString();
                String password = dpass.getEditText().getText().toString();
                if(TextUtils.isEmpty(name) || TextUtils.isEmpty(email) || TextUtils.isEmpty(password) )
                {
                mpro.setTitle("REGISTERING USER");
                mpro.setMessage("PLEASE WAIT");
                //mpro.set.CanceledOnTouchOutside(false);
                 mpro.show();
                register_user(name, email, password);
                }

            }


        });
    }

    private void register_user(String name, String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                mpro.dismiss();
                    Intent pintent = new Intent(registerActivity.this, MainActivity.class);
                    pintent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(pintent);
                    finish();
                } else {
                mpro.hide();
                    Toast.makeText(registerActivity.this, "cancel sign in and please check form and try again", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


}


