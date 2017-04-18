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

public class AutonMenu extends AppCompatActivity {


    Button backAutonMenu, goToAuton2, mainMenuAuton;
    ImageButton addBallsAuton, subtractBallsAuton;
    Integer numBallsAuton, gearStatus, ballStatus;
    RadioButton ballRadioButtonAuton, gearRadioButtonAuton;
    RadioGroup ballGroupAuton, gearGroupAuton;
    TextView numBallAccuracy;
    EditText shooterAccuracy;
    String ballStatusAuton, gearStatusAuton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auton_menu);
        numBallsAuton = 0;
        autonMenu();

    }
    public void autonMenu() {


        goToAuton2 = (Button) findViewById(R.id.goToAuton2);
        mainMenuAuton = (Button) findViewById(R.id.mainMenu);

        addBallsAuton = (ImageButton) findViewById(R.id.addBallsAuton);
        subtractBallsAuton = (ImageButton) findViewById(R.id.subtractBallsAuton);

        ballGroupAuton = (RadioGroup) findViewById(R.id.ballGroupAuton);
        ballRadioButtonAuton = (RadioButton) findViewById(R.id.lowGoalAuton);

        gearGroupAuton = (RadioGroup) findViewById(R.id.gearGroupAuton);
        gearRadioButtonAuton = (RadioButton) findViewById(R.id.notScoredGearsAuton);

        numBallAccuracy = (TextView) findViewById(R.id.numBallsAuton);

        goToAuton2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ballStatus = ballGroupAuton.getCheckedRadioButtonId();
                        ballRadioButtonAuton = (RadioButton)findViewById(ballStatus);
                        ballStatusAuton  = ballGroupAuton.toString();

                        gearStatus = gearGroupAuton.getCheckedRadioButtonId();
                        gearRadioButtonAuton = (RadioButton)findViewById(gearStatus);
                        gearStatusAuton  = gearGroupAuton.toString();

                        String numOfBalls = Integer.toString(numBallsAuton);

                        Intent intent = new Intent (AutonMenu.this, AutonMenu2.class);
                        startActivity(intent);


                    }
                }

        );
        mainMenuAuton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(AutonMenu.this, MainMenu.class);
                        startActivity(intent);

                    }
                }

        );
        addBallsAuton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        numBallsAuton = numBallsAuton + 1;
                        numBallAccuracy.setTextSize(20);
                        numBallAccuracy.setText(Integer.toString(numBallsAuton));

                    }
                }

        );
        subtractBallsAuton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        numBallsAuton = numBallsAuton - 1;
                        numBallAccuracy.setTextSize(20);
                        numBallAccuracy.setText(Integer.toString(numBallsAuton));

                    }
                }

        );
    }
}
