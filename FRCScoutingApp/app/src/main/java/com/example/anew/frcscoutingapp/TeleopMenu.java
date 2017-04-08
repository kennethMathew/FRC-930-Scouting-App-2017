package com.example.anew.frcscoutingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ToggleButton;

public class TeleopMenu extends AppCompatActivity {
    Button backTeleopMenu, goToTeleop2, mainMenu;
    ImageButton subtractBallsTeleop, addBallsTeleop, subtractGearsTeleop, addGearsTeleop;
    ToggleButton ballsTimer, gearsTimer;
    Integer numBallsTeleop, numGearsTeleop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teleop_menu);
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
        ballsTimer = (ToggleButton) findViewById(R.id.ballsTimer);
        gearsTimer = (ToggleButton) findViewById(R.id.gearsTimer);



        goToTeleop2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(TeleopMenu.this,TeleopMenu2.class);
                        startActivity(intent);

                    }
                }

        );
        backTeleopMenu.setOnClickListener(
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
                        numBallsTeleop = numBallsTeleop - 1;
                    }
                }

        );
        addBallsTeleop.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        numBallsTeleop = numBallsTeleop + 1;
                    }
                }

        );
        subtractGearsTeleop.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        numGearsTeleop = numGearsTeleop - 1;
                    }
                }

        );
        addGearsTeleop.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        numGearsTeleop = numGearsTeleop + 1;
                    }
                }

        );
        ballsTimer.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                    }
                }

        );
        gearsTimer.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                    }
                }

        );
    }
}
