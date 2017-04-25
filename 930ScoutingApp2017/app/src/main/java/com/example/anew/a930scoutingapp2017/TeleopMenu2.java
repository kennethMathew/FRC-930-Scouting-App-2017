package com.example.anew.a930scoutingapp2017;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class TeleopMenu2 extends AppCompatActivity {
    Button goToPostMatch;
    ImageButton subtractFoulsTeleop, addFoulsTeleop, subtractTechFoulsTeleop, addTechFoulsTeleop, subtractHumanErrors, addHumanErrors, subtractRoboErrorsTeleop, addRoboErrorsTeleop;
    Integer foulsTeleop, techFoulsTeleop, humanErrorsTeleop, roboErrorsTeleop;
    TextView numFoulsTeleop, numTechFoulsTeleop, numHumanErrorsTeleop, numRoboErrorsTeleop;
    Switch climbYesNo;
    Intent teleop2Array;
    String [] teamArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teleop_menu2);
        foulsTeleop = 0;
        techFoulsTeleop = 0;
        humanErrorsTeleop = 0;
        roboErrorsTeleop = 0;
        teleop2Array = getIntent();
        teamArray = teleop2Array.getStringArrayExtra("TeleopArray");
        teleopMenu2Run();



    }
    public void teleopMenu2Run() {

        goToPostMatch = (Button) findViewById(R.id.goToPostMatch);

        subtractFoulsTeleop = (ImageButton) findViewById(R.id.subtractFoulsTeleop);
        addFoulsTeleop = (ImageButton) findViewById(R.id.addFoulsTeleop);
        numFoulsTeleop = (TextView)findViewById(R.id.foulsTeleop);

        subtractTechFoulsTeleop = (ImageButton) findViewById(R.id.subtractTechFoulsTeleop);
        addTechFoulsTeleop = (ImageButton) findViewById(R.id.addTechFoulsTeleop);
        numTechFoulsTeleop = (TextView)findViewById(R.id.techFoulsTeleop);

        subtractHumanErrors = (ImageButton) findViewById(R.id.subtractHumanErrors);
        addHumanErrors = (ImageButton) findViewById(R.id.addHumanErrors);
        numHumanErrorsTeleop = (TextView)findViewById(R.id.humanErrorsTeleop);

        subtractRoboErrorsTeleop = (ImageButton) findViewById(R.id.subtractRoboErrorsTeleop);
        addRoboErrorsTeleop = (ImageButton) findViewById(R.id.addRoboErrorsTeleop);
        numRoboErrorsTeleop = (TextView)findViewById(R.id.roboErrorsTeleop);


        climbYesNo = (Switch)findViewById(R.id.climbYesNo);

        goToPostMatch.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        teamArray [14] = Integer.toString(foulsTeleop);
                        teamArray [15] = Integer.toString(techFoulsTeleop);
                        teamArray [16] = Integer.toString(humanErrorsTeleop);
                        teamArray [17] = Integer.toString(roboErrorsTeleop);

                        if (climbYesNo.isChecked()) {
                            teamArray [18] = "1";
                        } else {
                            teamArray [19] = "0";
                        }



                        Intent startActivityTeleop2Menu = new Intent(TeleopMenu2.this, PostMatchMenu.class);
                        startActivityTeleop2Menu.putExtra("Teleop2Array", teamArray);
                        startActivity(startActivityTeleop2Menu);

                    }
                }

        );

        subtractFoulsTeleop.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        foulsTeleop = foulsTeleop - 1;
                        numFoulsTeleop.setTextSize(25);
                        numFoulsTeleop.setText("# Fouls: " + Integer.toString(foulsTeleop));
                    }
                }



        );
        addFoulsTeleop.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        foulsTeleop = foulsTeleop + 1;
                        numFoulsTeleop.setTextSize(25);
                        numFoulsTeleop.setText("# Fouls: " + Integer.toString(foulsTeleop));
                    }
                }

        );
        subtractTechFoulsTeleop.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        techFoulsTeleop = techFoulsTeleop - 1;
                        numTechFoulsTeleop.setTextSize(25);
                        numTechFoulsTeleop.setText("# Tech Fouls: " + Integer.toString(techFoulsTeleop));
                    }
                }

        );
        addTechFoulsTeleop.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        techFoulsTeleop = techFoulsTeleop + 1;
                        numTechFoulsTeleop.setTextSize(25);
                        numTechFoulsTeleop.setText("# Tech Fouls: " + Integer.toString(techFoulsTeleop));
                    }
                }

        );
        subtractHumanErrors.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        humanErrorsTeleop = humanErrorsTeleop - 1;
                        numHumanErrorsTeleop.setTextSize(25);
                        numHumanErrorsTeleop.setText("   # H Errors: " + Integer.toString(humanErrorsTeleop));
                    }
                }

        );
        addHumanErrors.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        humanErrorsTeleop = humanErrorsTeleop + 1;
                        numHumanErrorsTeleop.setTextSize(25);
                        numHumanErrorsTeleop.setText("   # H Errors: " + Integer.toString(humanErrorsTeleop));
                    }
                }

        );
        subtractRoboErrorsTeleop.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        roboErrorsTeleop = roboErrorsTeleop - 1;
                        numRoboErrorsTeleop.setTextSize(25);
                        numRoboErrorsTeleop.setText("   # R Errors: " + Integer.toString(roboErrorsTeleop));
                    }
                }

        );
        addRoboErrorsTeleop.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        roboErrorsTeleop = roboErrorsTeleop + 1;
                        numRoboErrorsTeleop.setTextSize(25);
                        numRoboErrorsTeleop.setText("   # R Errors: " + Integer.toString(roboErrorsTeleop));
                    }
                }

        );
        climbYesNo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(getApplicationContext(), "Robot Climbed Rope", Toast.LENGTH_LONG).show();

                }else{
                    Toast.makeText(getApplicationContext(), "They told us we would never amount to anything. They told us we were terrible and could never climb the rope. Never shoot balls. Never place gears. They told us we would just move around slowly and sound like 5552. Boy, were those people right.", Toast.LENGTH_LONG).show();

                }
            }
        });






    }
}