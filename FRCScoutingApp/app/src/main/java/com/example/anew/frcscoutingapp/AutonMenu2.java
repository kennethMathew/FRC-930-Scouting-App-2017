package com.example.anew.frcscoutingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;


public class AutonMenu2 extends AppCompatActivity {
    Button backAutonMenu2, goToTeleop, mainMenuAuton2;
    CheckBox crossBaseline;
    ImageButton subtractFoulsAuton, addFoulsAuton, subtractTechFoulsAuton, addTechFoulsAuton, subtractRoboErrorsAuton, addRoboErrorsAuton;
    Integer numFouls, numTechFouls, numRoboErrors;
    TextView numFoulsAuton, numTechFoulsAuton, numRoboErrorsAuton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auton_menu2);
        numFouls = 0;
        numTechFouls = 0;
        numRoboErrors = 0;
        AutonMenu2Run();
    }
    public void AutonMenu2Run() {

        goToTeleop = (Button) findViewById(R.id.goToTeleop);
        mainMenuAuton2 = (Button) findViewById(R.id.mainMenuAuton2);

        subtractFoulsAuton = (ImageButton) findViewById(R.id.subtractFoulsAuton);
        addFoulsAuton = (ImageButton) findViewById(R.id.addFoulsAuton);

        subtractTechFoulsAuton = (ImageButton) findViewById(R.id.subtractTechFoulsAuton);
        addTechFoulsAuton = (ImageButton) findViewById(R.id.addTechFoulsAuton);

        subtractRoboErrorsAuton = (ImageButton) findViewById(R.id.subtractRoboErrorsAuton);
        addRoboErrorsAuton = (ImageButton) findViewById(R.id.addRoboErrorsAuton);

        numFoulsAuton = (TextView)findViewById(R.id.numFoulsAuton);
        numTechFoulsAuton = (TextView)findViewById(R.id.numTechFoulsAuton);
        numRoboErrorsAuton = (TextView)findViewById(R.id.numRoboErrorsAuton);

        crossBaseline = (CheckBox) findViewById(R.id.crossBaseline);


        goToTeleop.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String numfoulAuton = numFoulsAuton.toString() + ",";
                        String numTechFoulAuton = numTechFoulsAuton.toString() + ",";
                        String numRoboErrorAuton = numRoboErrorsAuton.toString() + ",";

                        if (crossBaseline.isChecked()) {
                            String crossedBaseline = "fo'shizzle,";
                        } else {
                            String crossedBaseline = "no deal home zlice,";
                        }

                        Intent intent = new Intent (AutonMenu2.this,TeleopMenu.class);
                        startActivity(intent);

                    }
                }

        );




        backAutonMenu2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(AutonMenu2.this, AutonMenu.class);
                        startActivity(intent);


                    }
                }

        );
        mainMenuAuton2.setOnClickListener(
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
                        numFoulsAuton.setText(Integer.toString(numFouls));

                    }
                }

        );
        addFoulsAuton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        numFouls = numFouls + 1;
                        numFoulsAuton.setText(Integer.toString(numFouls));
                    }
                }

        );
        subtractTechFoulsAuton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        numTechFouls = numTechFouls - 1;
                        numTechFoulsAuton.setText(Integer.toString(numTechFouls));
                    }
                }

        );
        addTechFoulsAuton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        numTechFouls = numTechFouls + 1;
                        numTechFoulsAuton.setText(Integer.toString(numTechFouls));
                    }
                }

        );
        subtractRoboErrorsAuton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        numRoboErrors = numRoboErrors - 1;
                        numRoboErrorsAuton.setText(Integer.toString(numRoboErrors));
                    }
                }

        );
        addRoboErrorsAuton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        numRoboErrors = numRoboErrors + 1;
                        numRoboErrorsAuton.setText(Integer.toString(numRoboErrors));
                    }
                }

        );

    }
}

