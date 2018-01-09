package com.example.anew.a930scoutingapp2017;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class AutonMenu extends AppCompatActivity {


    Button goToAuton2;
    ImageButton aBallsAuton, sBallsAuton;
    Integer numBallsAuton, gearStatus, ballStatus;
    RadioButton ballLowGoalAuton, ballHighGoalAuton, gearScoredAuton;
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

        aBallsAuton = (ImageButton) findViewById(R.id.aBallsAuton);
        sBallsAuton = (ImageButton) findViewById(R.id.sBallsAuton);

        ballGroupAuton = (RadioGroup) findViewById(R.id.ballGroupAuton);
        ballLowGoalAuton = (RadioButton) findViewById(R.id.lowGoalAuton);
        ballHighGoalAuton = (RadioButton) findViewById(R.id.highGoalAuton);

        gearGroupAuton = (RadioGroup) findViewById(R.id.gearGroupAuton);
        gearScoredAuton = (RadioButton) findViewById(R.id.scoredGearsAuton);

        ballsAuton = (TextView) findViewById(R.id.ballsAuton);

        goToAuton2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ballLowGoalAuton.isChecked()) {
                            teamArray[4] = Integer.toString(numBallsAuton);
                            teamArray[5] = "0";
                        } else if (ballHighGoalAuton.isChecked()) {
                            teamArray[4] = "0";
                            teamArray[5] = Integer.toString(numBallsAuton);

                        } else {
                            teamArray[5] = "0";
                            teamArray[6] = "0";
                        }
                        if(gearScoredAuton.isChecked()){
                            teamArray [3] = "1";
                        } else{
                            teamArray [3] = "0";
                        }
                            startActivityAutonMenu = new Intent(AutonMenu.this, AutonMenu2.class);
                            startActivityAutonMenu.putExtra("AutonArray", teamArray);
                            startActivity(startActivityAutonMenu);


                        }
                }
        );
        aBallsAuton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        numBallsAuton = numBallsAuton + 1;
                        ballsAuton.setTextSize(30);
                        ballsAuton.setText("# Balls: " + Integer.toString(numBallsAuton));

                    }
                }

        );
        sBallsAuton.setOnClickListener(
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
