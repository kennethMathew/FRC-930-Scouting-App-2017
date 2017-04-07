package com.example.anew.frcscoutingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AutonMenu extends AppCompatActivity {
    Button backAutonMenu, goToTeleop, mainMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auton_menu);
        onClickListenerAutonMenu();
    }
    public void onClickListenerAutonMenu() {

        backAutonMenu = (Button) findViewById(R.id.backAutonMenu);
        goToTeleop = (Button) findViewById(R.id.goToTeleop);
        mainMenu = (Button) findViewById(R.id.mainMenu);


        goToTeleop.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(AutonMenu.this,TeleopMenu.class);
                        startActivity(intent);

                    }
                }

        );
        backAutonMenu.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(AutonMenu.this, PreMatchMenu.class);
                        startActivity(intent);

                    }
                }

        );

        mainMenu.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(AutonMenu.this, MainMenu.class);
                        startActivity(intent);

                    }
                }

        );
    }
}

