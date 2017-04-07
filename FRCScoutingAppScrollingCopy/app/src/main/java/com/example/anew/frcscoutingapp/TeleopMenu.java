package com.example.anew.frcscoutingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TeleopMenu extends AppCompatActivity {
        Button backTeleopMenu, goToPostMatch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teleop_menu);
        onClickListenerTeleopMenu();
    }
    public void onClickListenerTeleopMenu() {

        backTeleopMenu = (Button) findViewById(R.id.backTeleopMenu);
        goToPostMatch = (Button) findViewById(R.id.goToPostMatch);


       goToPostMatch.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(TeleopMenu.this,PostMatchMenu.class);
                        startActivity(intent);

                    }
                }

        );
        backTeleopMenu.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(TeleopMenu.this, AutonMenu.class);
                        startActivity(intent);

                    }
                }

        );
    }
}
