package com.example.anew.frcscoutingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ToggleButton;

public class AutonMenu2 extends AppCompatActivity {
    Button backAutonMenu2, goToTeleop, mainMenu;
    ToggleButton crossBaseline;
    ImageButton subtractFoulsAuton, addFoulsAuton, subtractTechFoulsAuton, addTechFoulsAuton, subtractRoboErrorsAuton, addRoboErrorsAuton;
    Integer numFouls = 0, numTechFouls = 0, numRoboErrors = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auton_menu2);
        onClickListenerAutonMenu2();
    }
    public void onClickListenerAutonMenu2() {

        backAutonMenu2 = (Button) findViewById(R.id.backAutonMenu2);
        goToTeleop = (Button) findViewById(R.id.goToTeleop);
        mainMenu = (Button) findViewById(R.id.mainMenu);
        subtractFoulsAuton = (ImageButton) findViewById(R.id.subtractFoulsAuton);
        addFoulsAuton = (ImageButton) findViewById(R.id.addFoulsAuton);
        subtractTechFoulsAuton = (ImageButton) findViewById(R.id.subtractTechFoulsAuton);
        addTechFoulsAuton = (ImageButton) findViewById(R.id.addTechFoulsAuton);
        subtractRoboErrorsAuton = (ImageButton) findViewById(R.id.subtractRoboErrorsAuton);
        addRoboErrorsAuton = (ImageButton) findViewById(R.id.addRoboErrorsAuton);
        crossBaseline = (ToggleButton) findViewById(R.id.crossBaseline);



        goToTeleop.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent (AutonMenu2.this,TeleopMenu.class);
                        startActivity(intent);

                    }
                }

        );
        backAutonMenu2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(AutonMenu2.this, PreMatchMenu.class);
                        startActivity(intent);

                    }
                }

        );
        mainMenu.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(AutonMenu2.this, MainMenu.class);
                        startActivity(intent);

                    }
                }

        );
        subtractFoulsAuton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        numFouls = numFouls - 1;
                    }
                }

        );
        addFoulsAuton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        numFouls = numFouls + 1;
                    }
                }

        );
        subtractTechFoulsAuton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        numTechFouls = numTechFouls - 1;
                    }
                }

        );
        addTechFoulsAuton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        numTechFouls = numTechFouls + 1;
                    }
                }

        );
        subtractRoboErrorsAuton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        numRoboErrors = numRoboErrors - 1;
                    }
                }

        );
        addRoboErrorsAuton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        numRoboErrors = numRoboErrors + 1;
                    }
                }

        );
        crossBaseline.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                }

        );
    }
}
