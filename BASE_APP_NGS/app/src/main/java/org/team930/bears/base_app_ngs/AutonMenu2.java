package org.team930.bears.base_app_ngs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;


public class AutonMenu2 extends AppCompatActivity {
    Button goToTeleop;
    CheckBox crossBaseline;
    ImageButton subtractYCardsAuton, addYCardsAuton, subtractTechFoulsAuton, addTechFoulsAuton;
    Integer numYellowCards, numTechFouls;
    TextView numFoulsAuton, numTechFoulsAuton, numRoboErrorsAuton;
    Intent auton2Array, startActivityAutonMenu2;
    String [] teamArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auton_menu2);
        numYellowCards= 0;
        numTechFouls = 0;
        auton2Array = getIntent();
        teamArray = auton2Array.getStringArrayExtra("AutonArray");
        autonMenu2Run();

    }
    public void autonMenu2Run() {

        goToTeleop = (Button) findViewById(R.id.goToTeleop);

        subtractYCardsAuton = (ImageButton) findViewById(R.id.subtractFoulsAuton);
        addYCardsAuton = (ImageButton) findViewById(R.id.addFoulsAuton);

        subtractTechFoulsAuton = (ImageButton) findViewById(R.id.subtractTechFoulsAuton);
        addTechFoulsAuton = (ImageButton) findViewById(R.id.addTechFoulsAuton);

        numFoulsAuton = (TextView)findViewById(R.id.foulsAuton);
        numTechFoulsAuton = (TextView)findViewById(R.id.techFoulsAuton);

        crossBaseline = (CheckBox) findViewById(R.id.crossBaseline);


        goToTeleop.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        teamArray [13] = numTechFouls.toString();

                        teamArray [14] = numYellowCards.toString();


                        if (crossBaseline.isChecked()) {
                            teamArray [2] = "1";

                        } else {
                            teamArray [2] =  "0";

                        }

                        startActivityAutonMenu2 = new Intent(AutonMenu2.this, TeleopMenu.class);
                        startActivityAutonMenu2.putExtra("Auton2Array", teamArray);
                        startActivity(startActivityAutonMenu2);

                    }
                }

        );
        subtractYCardsAuton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        numYellowCards= numYellowCards- 1;
                        numFoulsAuton.setText("     # Fouls: " + Integer.toString(numYellowCards));

                    }
                }

        );
        addYCardsAuton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        numYellowCards= numYellowCards+ 1;
                        numFoulsAuton.setText("     # Fouls: " + Integer.toString(numYellowCards));
                    }
                }

        );
        subtractTechFoulsAuton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        numTechFouls = numTechFouls - 1;
                        numTechFoulsAuton.setText("     # Tech Fouls: " + Integer.toString(numTechFouls));
                    }
                }

        );
        addTechFoulsAuton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        numTechFouls = numTechFouls + 1;
                        numTechFoulsAuton.setText("     # Tech Fouls: " + Integer.toString(numTechFouls));
                    }
                }

        );
    }
}


