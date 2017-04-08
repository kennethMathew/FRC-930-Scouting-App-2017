package com.example.anew.frcscoutingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TeleopMenu2 extends AppCompatActivity {
    Button backTeleopMenu2, goToPostMatch, mainMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teleop_menu2);
        onClickListenerTeleopMenu2();
    }
    public void onClickListenerTeleopMenu2() {

        backTeleopMenu2 = (Button) findViewById(R.id.backTeleopMenu2);
        goToPostMatch = (Button) findViewById(R.id.goToPostMatch);
        mainMenu = (Button) findViewById(R.id.mainMenu);



        goToPostMatch.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(TeleopMenu2.this,PostMatchMenu.class);
                        startActivity(intent);

                    }
                }

        );
        backTeleopMenu2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(TeleopMenu2.this, AutonMenu.class);
                        startActivity(intent);

                    }
                }

        );
        mainMenu.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(TeleopMenu2.this, MainMenu.class);
                        startActivity(intent);

                    }
                }

        );
    }
}
