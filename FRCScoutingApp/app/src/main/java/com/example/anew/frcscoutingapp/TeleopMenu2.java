package com.example.anew.frcscoutingapp;

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
    Button backTeleopMenu2, goToPostMatch, mainMenu;
    ImageButton subtractFoulsTeleop, addFoulsTeleop, subtractTechFoulsTeleop, addTechFoulsTeleop, subtractHumanErrors, addHumanErrors, subtractRoboErrorsTeleop, addRoboErrorsTeleop;
    ToggleButton rope;
    Integer foulsTeleop = 0, techFoulsTeleop = 0, humanErrors = 0, roboErrorsTeleop = 0;
    TextView numFoulsTeleop, numTechFoulsTeleop, numHumanErrorsTeleop, numRoboErrorsTeleop;
    Switch climbYesNo;
    EditText climbTime;
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

        subtractFoulsTeleop = (ImageButton) findViewById(R.id.subtractFoulsTeleop);
        addFoulsTeleop = (ImageButton) findViewById(R.id.addFoulsTeleop);
        numFoulsTeleop = (TextView)findViewById(R.id.numFoulsTeleop);

        subtractTechFoulsTeleop = (ImageButton) findViewById(R.id.subtractTechFoulsTeleop);
        addTechFoulsTeleop = (ImageButton) findViewById(R.id.addTechFoulsTeleop);
        numTechFoulsTeleop = (TextView)findViewById(R.id.numTechFoulsTeleop);

        subtractHumanErrors = (ImageButton) findViewById(R.id.subtractHumanErrors);
        addHumanErrors = (ImageButton) findViewById(R.id.addHumanErrors);
        numHumanErrorsTeleop = (TextView)findViewById(R.id.numHumanErrors);

        subtractRoboErrorsTeleop = (ImageButton) findViewById(R.id.subtractRoboErrorsTeleop);
        addRoboErrorsTeleop = (ImageButton) findViewById(R.id.addRoboErrorsTeleop);
        numRoboErrorsTeleop = (TextView)findViewById(R.id.numRoboErrorsTeleop);

        climbYesNo = (Switch)findViewById(R.id.climbYesNo);



        goToPostMatch.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String numFoulTeleop = Integer.toString(foulsTeleop);
                        String numTechFoulTeleop = Integer.toString(techFoulsTeleop);
                        String numHumanErrorTeleop = Integer.toString(humanErrors);
                        String numRoboErrorTeleop = Integer.toString(roboErrorsTeleop);

                        String tToClimb = climbTime.getText().toString();

                        if (climbYesNo.isChecked()) {
                            String climbedYesNo = "fo'shizzle,";
                        } else {
                            String climbedYesNo = "no deal home zlice,";
                        }




                        Intent intent = new Intent(TeleopMenu2.this,PostMatchMenu.class);
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


        subtractFoulsTeleop.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        foulsTeleop = foulsTeleop - 1;
                        numFoulsTeleop.setText(Integer.toString(foulsTeleop));
                    }
                }



        );
        addFoulsTeleop.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        foulsTeleop = foulsTeleop + 1;
                        numFoulsTeleop.setText(Integer.toString(foulsTeleop));
                    }
                }

        );
        subtractTechFoulsTeleop.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        techFoulsTeleop = techFoulsTeleop - 1;
                        numTechFoulsTeleop.setText(Integer.toString(techFoulsTeleop));
                    }
                }

        );
        addTechFoulsTeleop.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        techFoulsTeleop = techFoulsTeleop + 1;
                        numTechFoulsTeleop.setText(Integer.toString(techFoulsTeleop));
                    }
                }

        );
        subtractHumanErrors.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        humanErrors = humanErrors - 1;
                        numHumanErrorsTeleop.setText(Integer.toString(humanErrors));
                    }
                }

        );
        addHumanErrors.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        humanErrors = humanErrors + 1;
                        numHumanErrorsTeleop.setText(Integer.toString(humanErrors));
                    }
                }

        );
        subtractRoboErrorsTeleop.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        roboErrorsTeleop = roboErrorsTeleop - 1;
                        numRoboErrorsTeleop.setText(Integer.toString(roboErrorsTeleop));
                    }
                }

        );
        addRoboErrorsTeleop.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        roboErrorsTeleop = roboErrorsTeleop + 1;
                        numRoboErrorsTeleop.setText(Integer.toString(roboErrorsTeleop));
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
