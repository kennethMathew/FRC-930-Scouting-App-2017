package org.team930.bears.base_app_ngs;

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
    Button goToTeleop2;
    ImageButton subtractBallsTeleop, addBallsTeleop, subtractGearsTeleop, addGearsTeleop;
    Integer ballsTeleop, gearsTeleop;
    TextView numBallsTeleop, numGearsTeleop;
    RadioButton ballLowGoalTeleop, ballHighGoalTeleop;
    RadioGroup ballGroupTeleop;
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
        ballsTeleop = 0;
        gearsTeleop = 0;
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

        ballGroupTeleop = (RadioGroup) findViewById(R.id.ballGroupTeleop);
        ballHighGoalTeleop = (RadioButton) findViewById(R.id.highGoalTeleop);
        ballLowGoalTeleop = (RadioButton) findViewById(R.id.lowGoalTeleop);

        goToTeleop2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(ballLowGoalTeleop.isChecked()){
                            teamArray [7] = Integer.toString(ballsTeleop);
                            teamArray [8] = "0";
                        } else if(ballHighGoalTeleop.isChecked()){
                            teamArray [7] = "0";
                            teamArray [8] = Integer.toString(ballsTeleop);

                        } else{
                            teamArray [7] = "0";
                            teamArray [8] = "0";
                        }



                        teamArray [6] = Integer.toString(gearsTeleop);



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

       }
}
