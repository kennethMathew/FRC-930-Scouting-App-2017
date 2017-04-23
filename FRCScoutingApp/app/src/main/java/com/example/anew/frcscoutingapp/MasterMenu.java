package com.example.anew.frcscoutingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.integration.android.IntentResult;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.integration.android.IntentIntegrator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class MasterMenu extends AppCompatActivity {
    Button backMasterMenu, scanCode, viewDatabase;
    Intent masterFillArray;
    ArrayList<String> matchDataArray, teamStatsArr;
    File teamMatchData;
    BufferedWriter bwriter;
    Integer matchDataIndexer;

    public Integer addOne(int baseValue){
        baseValue = baseValue + 1;
        return baseValue;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_menu);
        matchDataArray = new ArrayList<String>();
        matchDataIndexer = 0;
        masterMenuRun();
      }

    public void masterMenuRun() {

        backMasterMenu = (Button)findViewById(R.id.backMasterMenu);
        scanCode = (Button)findViewById(R.id.scanCode);
        viewDatabase = (Button)findViewById(R.id.viewDatabase);



        scanCode.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        IntentIntegrator integrator = new IntentIntegrator(MasterMenu.this);
                        integrator.initiateScan();
                        System.out.print("SCANNING ***");
                    }
                }
        );
        viewDatabase.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        try {
                            teamMatchData = new File("Internal shared storage\\FRCScoutingData" + File.separator + "Match" + teamStatsArr.get(1) + "Data");
                            bwriter = new BufferedWriter(new FileWriter(teamMatchData));
                            teamMatchData.createNewFile();

                            bwriter.write("teamNum, matchNum, allianceColor, ballGoalAuton, gearStatusAuton, numBallsAuton, numFoulsAuton, " +
                                    "numTechFoulsAuton, numRobotErrorsAuton, crossedBaselineYorN, ballGoalTeleop, numBallsTeleop, numGearsTeleop, " +
                                    "numBallCycles, avgBallCycleTime, numGearCycles, avgGearCycleTime, numFoulsTeleop, numTechFoulsTeleop, " +
                                    "numHumanErrorsTeleop, numRobotErrorsTeleop, climbYorN, climbTime, winLoss, comments");

                            bwriter.write(matchDataArray.get(0));
                            bwriter.newLine();
                            bwriter.write(matchDataArray.get(1));
                            bwriter.newLine();
                            bwriter.write(matchDataArray.get(2));
                            bwriter.newLine();
                            bwriter.write(matchDataArray.get(3));
                            bwriter.newLine();
                            bwriter.write(matchDataArray.get(4));
                            bwriter.newLine();
                            bwriter.write(matchDataArray.get(5));
                            bwriter.newLine();


                        }catch(
                                IOException e)
                        {
                            // e.printStackTrace();
                            System.err.println(e);
                        }

                    }
                }
        );
        backMasterMenu.setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                        Intent intent = new Intent(MasterMenu.this, MainMenu.class);
                        startActivity(intent);

                    }
                }
        );

    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (scanResult != null) {
            // handle scan result
            String teamData = scanResult.getContents();

            // String => array
            teamStatsArr = new ArrayList<String>(); // has each value for a team
            int i = 0;
            while (i < teamData.length() - 1) {
                int end = teamData.indexOf(",", i);
                teamStatsArr.add(teamData.substring(i, end));
                i = end + 1;
                matchDataArray.add(matchDataIndexer, teamData);
                matchDataIndexer = addOne(matchDataIndexer);
            }



            // TODO arrays storage
        }
    }
}
