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
    Button goToTeleop;
    CheckBox crossBaseline;
    ImageButton subtractFoulsAuton, addFoulsAuton, subtractTechFoulsAuton, addTechFoulsAuton, subtractRoboErrorsAuton, addRoboErrorsAuton;
    Integer numFouls, numTechFouls, numRoboErrors;
    TextView numFoulsAuton, numTechFoulsAuton, numRoboErrorsAuton;
    Intent auton2Array, startActivityAutonMenu2;
    String [] teamArray;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auton_menu2);
        numFouls = 0;
        numTechFouls = 0;
        numRoboErrors = 0;
        auton2Array = getIntent();
        teamArray = auton2Array.getStringArrayExtra("AutonArray");
        autonMenu2Run();

    }
    public void autonMenu2Run() {

        goToTeleop = (Button) findViewById(R.id.goToTeleop);

        subtractFoulsAuton = (ImageButton) findViewById(R.id.subtractFoulsAuton);
        addFoulsAuton = (ImageButton) findViewById(R.id.addFoulsAuton);

        subtractTechFoulsAuton = (ImageButton) findViewById(R.id.subtractTechFoulsAuton);
        addTechFoulsAuton = (ImageButton) findViewById(R.id.addTechFoulsAuton);

        subtractRoboErrorsAuton = (ImageButton) findViewById(R.id.subtractRoboErrorsAuton);
        addRoboErrorsAuton = (ImageButton) findViewById(R.id.addRoboErrorsAuton);

        numFoulsAuton = (TextView)findViewById(R.id.foulsAuton);
        numTechFoulsAuton = (TextView)findViewById(R.id.techFoulsAuton);
        numRoboErrorsAuton = (TextView)findViewById(R.id.robotErrorsAuton);

        crossBaseline = (CheckBox) findViewById(R.id.crossBaseline);


        goToTeleop.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        teamArray [6] = numFoulsAuton.toString();


                        teamArray [7] = numTechFoulsAuton.toString();


                        teamArray [8] = numRoboErrorsAuton.toString();


                        if (crossBaseline.isChecked()) {
                            teamArray [9] = "fo'shizzle";

                        } else {
                            teamArray [10] =  "no deal home zlice";

                        }

                        startActivityAutonMenu2 = new Intent(AutonMenu2.this, TeleopMenu.class);
                        startActivityAutonMenu2.putExtra("Auton2Array", teamArray);
                        startActivity(startActivityAutonMenu2);

                    }
                }

        );
        subtractFoulsAuton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        numFouls = numFouls - 1;
                        numFoulsAuton.setText(" # Fouls: " + Integer.toString(numFouls));

                    }
                }

        );
        addFoulsAuton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        numFouls = numFouls + 1;
                        numFoulsAuton.setText(" # Fouls: " + Integer.toString(numFouls));
                    }
                }

        );
        subtractTechFoulsAuton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        numTechFouls = numTechFouls - 1;
                        numTechFoulsAuton.setText(" # Tech Fouls: " + Integer.toString(numFouls));
                    }
                }

        );
        addTechFoulsAuton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        numTechFouls = numTechFouls + 1;
                        numTechFoulsAuton.setText(" # Tech Fouls: " + Integer.toString(numFouls));
                    }
                }

        );
        subtractRoboErrorsAuton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        numRoboErrors = numRoboErrors - 1;
                        numRoboErrorsAuton.setText(" # R Errors: " + Integer.toString(numFouls));
                    }
                }

        );
        addRoboErrorsAuton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        numRoboErrors = numRoboErrors + 1;
                        numRoboErrorsAuton.setText(" # R Errors: " + Integer.toString(numFouls));
                    }
                }

        );

    }
}

