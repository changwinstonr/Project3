package com.companyname.ceramicgod;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    DetailView mDetailButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);}

        public void sendDetailView(View view){
            Intent intent = new Intent(this, DetailView.class);
            startActivity(intent);

        }

    }

