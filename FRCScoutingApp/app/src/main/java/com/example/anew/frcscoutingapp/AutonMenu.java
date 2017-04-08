package com.example.anew.frcscoutingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class AutonMenu extends AppCompatActivity {
    Button backAutonMenu, goToAuton2, mainMenu;
    ImageButton addBallsAuton, subtractBallsAuton;
    Integer numBallsAuton;
    RadioButton ballRadioButton, gearRadioButton;
    RadioGroup ballGroupAuton, gearGroupAuton;
    SeekBar setAccuracy;
    TextView shootAccuracy, numBallAccuracy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auton_menu);
        numBallsAuton = 0;
        autonMenu();

    }
    public void autonMenu() {

        backAutonMenu = (Button) findViewById(R.id.backAutonMenu);
        goToAuton2 = (Button) findViewById(R.id.goToAuton2);
        mainMenu = (Button) findViewById(R.id.mainMenu);

        addBallsAuton = (ImageButton) findViewById(R.id.addBallsAuton);
        subtractBallsAuton = (ImageButton) findViewById(R.id.subtractBallsAuton);
        numBallAccuracy= (TextView) findViewById(R.id.numBallsAuton);

        ballGroupAuton = (RadioGroup) findViewById(R.id.ballGroupAuton);
        ballRadioButton = (RadioButton) findViewById(R.id.highGoalAuton);

        gearGroupAuton = (RadioGroup) findViewById(R.id.gearGroupAuton);
        gearRadioButton = (RadioButton) findViewById(R.id.scoredGearsAuton);

        setAccuracy = (SeekBar)findViewById(R.id.ballAccuracy);
        shootAccuracy= (TextView) findViewById(R.id.shootAccuracy);

        shootAccuracy.setText(Integer.toString(setAccuracy.getProgress()));





        goToAuton2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int ballStatus = ballGroupAuton.getCheckedRadioButtonId();
                        ballRadioButton = (RadioButton)findViewById(ballStatus);
                        String ballStatusAuton = ballRadioButton.getText().toString() + ",";

                        int gearStatus = gearGroupAuton.getCheckedRadioButtonId();
                        gearRadioButton = (RadioButton)findViewById(gearStatus);
                        String gearStatusAuton = gearRadioButton.getText().toString() + ",";

                        Intent intent = new Intent (AutonMenu.this, AutonMenu2.class);
                        startActivity(intent);

                    }
                }

        );
        backAutonMenu.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(AutonMenu.this, PreMatchMenu.class);
                        startActivity(intent);

                    }
                }

        );
        mainMenu.setOnClickListener(
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
                        numBallAccuracy.setText(Integer.toString(numBallsAuton));
                    }
                }

        );
        subtractBallsAuton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        numBallsAuton = numBallsAuton - 1;
                        numBallAccuracy.setText(Integer.toString(numBallsAuton));
                    }
                }

        );
    }
}
