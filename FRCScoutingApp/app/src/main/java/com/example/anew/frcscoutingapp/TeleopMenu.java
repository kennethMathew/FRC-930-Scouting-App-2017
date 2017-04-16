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
    Integer ballsTeleop, gearsTeleop, gearTimesIndexer, ballTimesIndexer, ballStatus, indexStandard, gearTime, ballTime, avgGearTime, avgBallTime;
    TextView numBallsTeleop, numGearsTeleop;
    EditText ballCycleTime, gearCycleTime;
    RadioButton ballRadioButtonTeleop;
    RadioGroup ballGroupTeleop;
    String ballStatusTeleop, numGearTeleop, numBallTeleop, ballTimes, gearTimes;
    int [] ballCycleTimes, gearCycleTimes;
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

        onClickListenerTeleopMenu();


    }
    public void onClickListenerTeleopMenu() {

        backTeleopMenu = (Button) findViewById(R.id.backTeleopMenu);
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
                        ballStatusTeleop  = ballGroupTeleop.toString();

                        numBallTeleop = Integer.toString(ballsTeleop);
                        numGearTeleop = Integer.toString(gearsTeleop);

                        indexStandard = gearCycleTimes.length;
                        if(indexStandard != 0) {
                            for (int i = 0; i <= indexStandard - 1; i++) {
                                gearTime = (gearCycleTimes[i]) + gearTime;

                            }
                            avgGearTime = gearTime / indexStandard;
                            String numOfCyclesGears = Integer.toString(indexStandard);
                            String avgGearTimes = Integer.toString(avgGearTime);
                        }



                        indexStandard = ballCycleTimes.length;
                        if(indexStandard != 0){
                            for (int i = 0; i <= indexStandard - 1; i++) {
                                ballTime = (ballCycleTimes[i]) + ballTime;

                            }
                            avgBallTime = ballTime / indexStandard;
                            String numOfCyclesBalls = Integer.toString(indexStandard);
                            String avgBallTimes = Integer.toString(avgBallTime);

                        }
                        Intent intent = new Intent(TeleopMenu.this, TeleopMenu2.class);
                        startActivity(intent);


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
