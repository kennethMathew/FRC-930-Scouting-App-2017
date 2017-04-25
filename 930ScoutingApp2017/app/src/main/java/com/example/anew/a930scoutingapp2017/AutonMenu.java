package com.example.anew.a930scoutingapp2017;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AutonMenu extends AppCompatActivity {


    Button goToAuton2;
    ImageButton addBallsAuton, subtractBallsAuton;
    Integer numBallsAuton, gearStatus, ballStatus;
    RadioButton ballRadioButtonAuton, gearRadioButtonAuton;
    RadioGroup ballGroupAuton, gearGroupAuton;
    TextView ballsAuton;
    String [] teamArray;
    Intent autonArray, startActivityAutonMenu;

    public Integer addOne(int baseValue){
        baseValue = baseValue + 1;
        return baseValue;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auton_menu);
        numBallsAuton = 0;
        autonArray = getIntent();
        teamArray = autonArray.getStringArrayExtra("PreMatchArray");

        autonMenu();

    }
    public void autonMenu() {


        goToAuton2 = (Button) findViewById(R.id.goToAuton2);

        addBallsAuton = (ImageButton) findViewById(R.id.addBallsAuton);
        subtractBallsAuton = (ImageButton) findViewById(R.id.subtractBallsAuton);

        ballGroupAuton = (RadioGroup) findViewById(R.id.ballGroupAuton);
        ballRadioButtonAuton = (RadioButton) findViewById(R.id.lowGoalAuton);

        gearGroupAuton = (RadioGroup) findViewById(R.id.gearGroupAuton);
        gearRadioButtonAuton = (RadioButton) findViewById(R.id.notScoredGearsAuton);

        ballsAuton = (TextView) findViewById(R.id.ballsAuton);

        goToAuton2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ballStatus = ballGroupAuton.getCheckedRadioButtonId();
                        ballRadioButtonAuton = (RadioButton)findViewById(ballStatus);

                        teamArray [3] = ballGroupAuton.toString();

                        gearStatus = gearGroupAuton.getCheckedRadioButtonId();
                        gearRadioButtonAuton = (RadioButton)findViewById(gearStatus);

                        teamArray [4] = gearGroupAuton.toString();

                        teamArray [5] =  Integer.toString(numBallsAuton);

                        startActivityAutonMenu = new Intent(AutonMenu.this, AutonMenu2.class);
                        startActivityAutonMenu.putExtra("AutonArray", teamArray);
                        startActivity(startActivityAutonMenu);


                    }
                }

        );
        addBallsAuton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        numBallsAuton = numBallsAuton + 1;
                        ballsAuton.setTextSize(30);
                        ballsAuton.setText("# Balls: " + Integer.toString(numBallsAuton));

                    }
                }

        );
        subtractBallsAuton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        numBallsAuton = numBallsAuton - 1;
                        ballsAuton.setTextSize(30);
                        ballsAuton.setText("# Balls: " + Integer.toString(numBallsAuton));

                    }
                }

        );
    }
}
