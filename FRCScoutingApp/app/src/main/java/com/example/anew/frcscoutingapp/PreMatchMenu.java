package com.example.anew.frcscoutingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PreMatchMenu extends AppCompatActivity {
    Button backPreMatchMenu, startScouting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_match_menu);
        onClickListenerPreMatchMenu();
    }

    public void onClickListenerPreMatchMenu() {

        backPreMatchMenu = (Button) findViewById(R.id.backPreMatchMenu);
        startScouting = (Button) findViewById(R.id.startScouting);


        startScouting.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(PreMatchMenu.this, AutonMenu.class);
                        startActivity(intent);

                    }
                }

        );
        backPreMatchMenu.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(PreMatchMenu.this, ScouterMenu.class);
                        startActivity(intent);

                    }
                }

        );
    }
}