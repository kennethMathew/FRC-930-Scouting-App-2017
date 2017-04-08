package com.example.anew.frcscoutingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class AutonMenu extends AppCompatActivity {
    Button backAutonMenu, goToAuton2, mainMenu;
    ImageButton addBallsAuton, subtractBallsAuton;
    Integer numBallsAuton = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auton_menu);
        onClickListenerAutonMenu();
    }
    public void onClickListenerAutonMenu() {

        backAutonMenu = (Button) findViewById(R.id.backAutonMenu);
        goToAuton2 = (Button) findViewById(R.id.goToAuton2);
        mainMenu = (Button) findViewById(R.id.mainMenu);
        addBallsAuton = (ImageButton) findViewById(R.id.addBallsAuton);
        subtractBallsAuton = (ImageButton) findViewById(R.id.subtractBallsAuton);


        goToAuton2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent (AutonMenu.this,AutonMenu2.class);
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
        addBallsAuton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        numBallsAuton = numBallsAuton + 1;
                    }
                }

        );
        subtractBallsAuton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        numBallsAuton = numBallsAuton - 1;
                    }
                }

        );
    }
}
