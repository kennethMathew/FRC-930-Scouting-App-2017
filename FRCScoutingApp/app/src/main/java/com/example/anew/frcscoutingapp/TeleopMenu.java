package com.example.anew.frcscoutingapp;

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
    Button backTeleopMenu, goToTeleop2, mainMenu, submitBallsTime, submitGearsTime;
    ImageButton subtractBallsTeleop, addBallsTeleop, subtractGearsTeleop, addGearsTeleop;
    Integer ballsTeleop, gearsTeleop, gearTimesIndexer, ballTimesIndexer, ballStatus, indexStandard, gearTime, ballTime, avgGearTime, avgBallTime, arrayIndexer;
    TextView numBallsTeleop, numGearsTeleop;
    EditText ballCycleTime, gearCycleTime;
    RadioButton ballRadioButtonTeleop;
    RadioGroup ballGroupTeleop;
    String ballStatusTeleop, numGearTeleop, numBallTeleop;
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
        arrayIndexer = 10;
        teleopArray = getIntent();
        teamArray = teleopArray.getStringArrayExtra("Auton2Array");
        TeleopMenu();


    }
    public void TeleopMenu() {

        goToTeleop2 = (Button) findViewById(R.id.goToTeleop2);
        mainMenu = (Button) findViewById(R.id.mainMenu);

        subtractBallsTeleop = (ImageButton) findViewById(R.id.subtractBallsTeleop);
        addBallsTeleop = (ImageButton) findViewById(R.id.addBallsTeleop);

        subtractGearsTeleop = (ImageButton) findViewById(R.id.subtractGearsTeleop);
        addGearsTeleop = (ImageButton) findViewById(R.id.addGearsTeleop);

        numBallsTeleop = (TextView) findViewById(R.id.numBallsTeleop);
        numGearsTeleop = (TextView) findViewById(R.id.numGearsTeleop);

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
                        teamArray [arrayIndexer] = ballGroupTeleop.toString();
                        arrayIndexer = addOne(arrayIndexer);

                        teamArray [arrayIndexer] = Integer.toString(ballsTeleop);
                        arrayIndexer = addOne(arrayIndexer);

                        teamArray [arrayIndexer] = Integer.toString(gearsTeleop);
                        arrayIndexer = addOne(arrayIndexer);


                        indexStandard = ballCycleTimes.length;
                        if(indexStandard != 0){
                            for (int i = 0; i <= indexStandard - 1; i++) {
                                ballTime = (ballCycleTimes[i]) + ballTime;

                            }
                            avgBallTime = ballTime / indexStandard;

                            teamArray [arrayIndexer] = Integer.toString(indexStandard);
                            arrayIndexer = addOne(arrayIndexer);

                            teamArray [arrayIndexer] = Integer.toString(avgBallTime);
                            arrayIndexer = addOne(arrayIndexer);
                        }

                        indexStandard = gearCycleTimes.length;
                        if(indexStandard != 0){
                            for (int i = 0; i <= indexStandard - 1; i++) {
                                gearTime = (gearCycleTimes[i]) + gearTime;

                            }
                            avgGearTime = gearTime / indexStandard;

                            teamArray [arrayIndexer] = Integer.toString(indexStandard);
                            arrayIndexer = addOne(arrayIndexer);

                            teamArray [arrayIndexer] = Integer.toString(avgGearTime);
                            arrayIndexer = addOne(arrayIndexer);
                        }

                        Intent startActivityTeleopMenu = new Intent(TeleopMenu.this, TeleopMenu2.class);
                        startActivityTeleopMenu.putExtra("TeleopArray", teamArray);
                        startActivity(startActivityTeleopMenu);


                    }
                }

        );
        mainMenu.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(TeleopMenu.this, MainMenu.class);
                        startActivity(intent);

                    }
                }

        );



        subtractBallsTeleop.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ballsTeleop = ballsTeleop - 1;
                        numBallsTeleop.setText(Integer.toString(ballsTeleop));
                    }
                }

        );
        addBallsTeleop.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ballsTeleop = ballsTeleop + 1;
                        numBallsTeleop.setText(Integer.toString(ballsTeleop));
                    }
                }

        );
        subtractGearsTeleop.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        gearsTeleop = gearsTeleop - 1;
                        numGearsTeleop.setText(Integer.toString(gearsTeleop));
                    }
                }

        );
        addGearsTeleop.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        gearsTeleop = gearsTeleop + 1;
                        numGearsTeleop.setText(Integer.toString(gearsTeleop));
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
