package com.example.chat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private Toolbar toolbar1;
    private ViewPager viewPager;
    private Sectionadapter sectionadapter;
    private TabLayout tabb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        toolbar1 = findViewById(R.id.tbar);
        setSupportActionBar(toolbar1);
        setTitle("cHaT aPP");
       viewPager=findViewById(R.id.mainpage);
         sectionadapter=new Sectionadapter(getSupportFragmentManager());

         viewPager.setAdapter(sectionadapter);

        tabb=(TabLayout)findViewById(R.id.tabmain);
     tabb.setupWithViewPager(viewPager);
    }
   /* @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
     //if(currentUser == null)
     //{
        // Intent intent=new Intent(MainActivity.this,registerActivity.class);
        // startActivity(intent);
       //  finish();
     }
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         super.onCreateOptionsMenu(menu);
    getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
       super.onOptionsItemSelected(item);
       if(item.getItemId()==R.id.logbtn)
       {
           FirebaseAuth.getInstance().signOut();

            Intent intent=new Intent(MainActivity.this,startActivity.class);
            startActivity(intent);
            finish();

       }

        return true;
    }
}


