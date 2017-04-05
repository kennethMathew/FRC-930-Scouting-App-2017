package com.example.anew.frcscoutingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

    }

        public void onButtonClickListener() {
        Button scouter, master, settings;
        scouter = (Button)findViewById(R.id.scouter);
        master = (Button)findViewById(R.id.master);
        settings = (Button)findViewById(R.id.settings);
        scouter.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                }

        );


    }
}

