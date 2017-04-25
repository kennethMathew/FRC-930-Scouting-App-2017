package com.example.anew.a930scoutingapp2017;

import android.content.Intent;
import android.support.annotation.MainThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.lang.reflect.Array;
import java.util.Timer;

public class TeleopMenu extends AppCompatActivity {
    Button goToTeleop2, submitBallsTime, submitGearsTime;
    ImageButton subtractBallsTeleop, addBallsTeleop, subtractGearsTeleop, addGearsTeleop;
    Integer ballsTeleop, gearsTeleop, gearTimesIndexer, ballTimesIndexer, ballStatus, indexStandard, gearTime, ballTime, avgGearTime, avgBallTime;
    TextView numBallsTeleop, numGearsTeleop;
    EditText ballCycleTime, gearCycleTime;
    RadioButton ballRadioButtonTeleop;
    RadioGroup ballGroupTeleop;
    int [] ballCycleTimes, gearCycleTimes;
    Intent teleopArray;
    String [] teamArray;

    public Integer addOne(int baseValue){
        baseValue = baseValue + 1;
        return baseValue;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teleop_menu);
        ballTimesIndexer = 0;
        gearTimesIndexer = 0;
        ballsTeleop = 0;
        gearsTeleop = 0;
        ballCycleTimes = new int [10];
        gearCycleTimes = new int [10];
        ballTime = 0;
        gearTime = 0;
        teleopArray = getIntent();
        teamArray = teleopArray.getStringArrayExtra("Auton2Array");
        TeleopMenu();


    }
    public void TeleopMenu() {

        goToTeleop2 = (Button) findViewById(R.id.goToTeleop2);

        subtractBallsTeleop = (ImageButton) findViewById(R.id.subtractBallsTeleop);
        addBallsTeleop = (ImageButton) findViewById(R.id.addBallsTeleop);

        subtractGearsTeleop = (ImageButton) findViewById(R.id.subtractGearsTeleop);
        addGearsTeleop = (ImageButton) findViewById(R.id.addGearsTeleop);

        numBallsTeleop = (TextView) findViewById(R.id.ballsTeleop);
        numGearsTeleop = (TextView) findViewById(R.id.gearsTeleop);

        submitBallsTime = (Button) findViewById(R.id.submitBallsTime);
        submitGearsTime = (Button) findViewById(R.id.submitGearsTime);

        ballCycleTime = (EditText) findViewById(R.id.ballsTimer);
        gearCycleTime = (EditText) findViewById(R.id.gearsTimer);

        ballGroupTeleop = (RadioGroup) findViewById(R.id.ballGroupTeleop);
        ballRadioButtonTeleop = (RadioButton) findViewById(R.id.highGoalTeleop);

        goToTeleop2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ballStatus = ballGroupTeleop.getCheckedRadioButtonId();
                        ballRadioButtonTeleop = (RadioButton)findViewById(ballStatus);
                        teamArray [11] = ballRadioButtonTeleop.getText().toString();

                        teamArray [12] = Integer.toString(ballsTeleop);

                        teamArray [13] = Integer.toString(gearsTeleop);

                        indexStandard = ballCycleTimes.length;
                        if(indexStandard != 0) {
                            for (int i = 0; i <= indexStandard - 1; i++) {
                                ballTime = (ballCycleTimes[i]) + ballTime;

                            }
                            avgBallTime = ballTime / indexStandard;

                            teamArray[14] = Integer.toString(indexStandard);


                            teamArray[15] = Integer.toString(avgBallTime);
                        }

                        indexStandard = gearCycleTimes.length;
                        if(indexStandard != 0){
                            for (int i = 0; i <= indexStandard - 1; i++) {
                                gearTime = (gearCycleTimes[i]) + gearTime;

                            }
                            avgGearTime = gearTime / indexStandard;

                            teamArray [16] = Integer.toString(indexStandard);

                            teamArray [17] = Integer.toString(avgGearTime);
                        }

                        Intent startActivityTeleopMenu = new Intent(TeleopMenu.this, TeleopMenu2.class);
                        startActivityTeleopMenu.putExtra("TeleopArray", teamArray);
                        startActivity(startActivityTeleopMenu);


                    }
                }

        );

        subtractBallsTeleop.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ballsTeleop = ballsTeleop - 1;
                        numBallsTeleop.setTextSize(30);
                        numBallsTeleop.setText("# Balls: " + Integer.toString(ballsTeleop));
                    }
                }

        );
        addBallsTeleop.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ballsTeleop = ballsTeleop + 1;
                        numBallsTeleop.setTextSize(30);
                        numBallsTeleop.setText("# Balls: " + Integer.toString(ballsTeleop));
                    }
                }

        );
        subtractGearsTeleop.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        gearsTeleop = gearsTeleop - 1;
                        numGearsTeleop.setTextSize(30);
                        numGearsTeleop.setText("# Gears: " + Integer.toString(gearsTeleop));
                    }
                }

        );
        addGearsTeleop.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        gearsTeleop = gearsTeleop + 1;
                        numGearsTeleop.setTextSize(30);
                        numGearsTeleop.setText("# Gears: " + Integer.toString(gearsTeleop));
                    }
                }

        );
        submitBallsTime.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (Integer.parseInt(ballCycleTime.getText().toString()) == 0) {

                        } else {
                            ballCycleTimes[ballTimesIndexer] = Integer.parseInt(ballCycleTime.getText().toString());
                            ballTimesIndexer = ballTimesIndexer + 1;
                            ballCycleTime.setText("0");

                        }
                    }
                }

        );
        submitGearsTime.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (Integer.parseInt(gearCycleTime.getText().toString()) == 0) {

                        } else {
                            gearCycleTimes[gearTimesIndexer] = Integer.parseInt(gearCycleTime.getText().toString());
                            gearTimesIndexer = gearTimesIndexer + 1;
                            gearCycleTime.setText("0");
                        }
                    }
                }
        );
    }
}
