package com.example.chat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.TooManyListenersException;

public class loginActivity extends AppCompatActivity {
    private Toolbar toolbar3;
    TextInputLayout lemail;
    TextInputLayout lpass;
    Button btnl;
    private ProgressDialog gpro;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.login);
        mAuth = FirebaseAuth.getInstance();
        toolbar3 = findViewById(R.id.lbar);
        setSupportActionBar(toolbar3);
        setTitle("<-LOGIN ACCOUNT");
    }
    public void mainpage(View v){
            Intent jintent = new Intent(loginActivity.this, MainActivity.class);
            startActivity(jintent);
            finish();

        }
    }
/*
        lemail = findViewById(R.id.loge);
        lpass = findViewById(R.id.logp);
        btnl = findViewById(R.id.logbtn);
        gpro = new ProgressDialog(this);

        btnl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String logmail = lemail.getEditText().getText().toString();
                String logpass = lpass.getEditText().getText().toString();
                if (TextUtils.isEmpty(logmail) || TextUtils.isEmpty(logpass)) {
                    gpro.setTitle("Logging in");
                    gpro.setMessage("PLEASE WAIT ");
                   // gpro.set.CanceledOnTouchOutside(false);
                    gpro.show();
                    log_user(logmail, logpass);
                }

            }


        });
    }

    private void log_user(String logmail, String logpass) {

        mAuth.signInWithEmailAndPassword(logmail, logpass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    gpro.dismiss();
                    Intent jintent = new Intent(loginActivity.this, MainActivity.class);
                     jintent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(jintent);
                    finish();
                } else {
                    gpro.hide();
                    Toast.makeText(loginActivity.this, "cancel sign in and please check form and try again", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    }

*/