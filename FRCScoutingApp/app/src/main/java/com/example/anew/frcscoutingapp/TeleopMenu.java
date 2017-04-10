package com.example.anew.frcscoutingapp;

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
import android.widget.ToggleButton;

public class TeleopMenu extends AppCompatActivity {
    Button backTeleop2Menu, goToTeleop2, mainMenu, submitBallsTime, submitGearsTime;
    ImageButton subtractBallsTeleop, addBallsTeleop, subtractGearsTeleop, addGearsTeleop;
    Integer ballsTeleop = 0, gearsTeleop = 0, gearTimesIndexer, ballTimesIndexer, ballStatus;
    TextView numBallsTeleop, numGearsTeleop;
    EditText ballCycleTime, gearCycleTime;
    RadioButton ballRadioButtonTeleop;
    RadioGroup ballGroupTeleop;
    String ballStatusAuton, numGearTeleop, numBallTeleop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teleop_menu);
        ballTimesIndexer = 0;
        gearTimesIndexer = 0;
        onClickListenerTeleopMenu();


    }
    public void onClickListenerTeleopMenu() {

        backTeleop2Menu = (Button) findViewById(R.id.backTeleopMenu);
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
                        ballStatusAuton  = ballGroupTeleop.toString();

                        numBallTeleop = Integer.toString(ballsTeleop);
                        numGearTeleop = Integer.toString(gearsTeleop);

                        Intent intent = new Intent(TeleopMenu.this, TeleopMenu2.class);
                        startActivity(intent);


                    }
                }

        );
        backTeleop2Menu.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(TeleopMenu.this, AutonMenu.class);
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
                        String []  ballCycleTimes = new String [10];
                        ballCycleTimes [ballTimesIndexer] = ballCycleTime.getText().toString();
                        ballTimesIndexer = ballTimesIndexer + 1;
                        ballCycleTime.setText("");
                    }
                }

        );
        submitGearsTime.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String []  gearCycleTimes = new String [10];
                        gearCycleTimes [gearTimesIndexer] = ballCycleTime.getText().toString();
                        gearTimesIndexer = gearTimesIndexer + 1;
                        gearCycleTime.setText("");
                    }
                }

        );
    }
}
