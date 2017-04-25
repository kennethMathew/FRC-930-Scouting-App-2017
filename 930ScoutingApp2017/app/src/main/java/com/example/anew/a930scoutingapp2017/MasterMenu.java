package com.example.anew.a930scoutingapp2017;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.integration.android.IntentResult;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.integration.android.IntentIntegrator;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class MasterMenu extends AppCompatActivity {
    Button backMasterMenu, scanCode, viewDatabase;
    Intent masterFillArray;
    ArrayList<String> matchDataArray, teamStatsArr;
    Integer matchDataIndexer;
    String allData, matchNum, dataLabels, fullMatchData;
    FileOutputStream fWriter;
    File findDir, directory, fileName;

    public Integer addOne(int baseValue) {
        baseValue = baseValue + 1;
        return baseValue;
    }

    public String matchDataReturn() {
        if (matchDataArray.size() == 0){
            allData = "";

        } else if(matchDataArray.size() == 1) {
            allData = matchDataArray.get(0) + "\n";

        }else if(matchDataArray.size() == 2) {
            allData = matchDataArray.get(0) + "\n" + matchDataArray.get(0) + "\n";

        }else if(matchDataArray.size() == 3) {
            allData = matchDataArray.get(0) + "\n" + matchDataArray.get(0) + "\n" + matchDataArray.get(0) + "\n";

        }else if(matchDataArray.size() == 4) {
            allData = matchDataArray.get(0) + "\n" + matchDataArray.get(0) + "\n" + matchDataArray.get(0) + "\n" +
                    matchDataArray.get(0) + "\n";

        }else if(matchDataArray.size() == 5) {
            allData = matchDataArray.get(0) + "\n" + matchDataArray.get(0) + "\n" + matchDataArray.get(0) + "\n" +
                    matchDataArray.get(0) + "\n" + matchDataArray.get(0) + "\n";
        }else {
            allData = matchDataArray.get(0) + "\n" + matchDataArray.get(0) + "\n" + matchDataArray.get(0) + "\n" +
                    matchDataArray.get(0) + "\n" + matchDataArray.get(0) + "\n" + matchDataArray.get(0) + "\n";
        }
        return allData;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_menu);
        matchDataArray = new ArrayList<String>();
        teamStatsArr = new ArrayList<String>();
        matchDataIndexer = 0;
        masterMenuRun();

    }

    public void masterMenuRun() {

        backMasterMenu = (Button) findViewById(R.id.backMasterMenu);
        scanCode = (Button) findViewById(R.id.scanCode);
        viewDatabase = (Button) findViewById(R.id.viewDatabase);


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
                        fullMatchData = matchDataReturn();
                        dataLabels = "teamNum,matchNum,allianceColor,ballGoalAuton,gearStatusAuton,numBallsAuton,foulsAuton," +
                                "techFoulsAuton,robotErrorsAuton,crossedBaseline,ballGoalTeleop,numBalls,numGears,numBallCycles," +
                                "avgBallCycleTime,numGearCycles,avgGearCycleTime,foulsTeleop,techFoulsTeleop,humanErrorsTeleop," +
                                "robotErrorsTeleop,climbYesNo,climbTime,winYesNo,comments\n";

                        if(teamStatsArr.size() >= 2){
                            matchNum = teamStatsArr.get(1);

                        }else {
                            matchNum = "";
                        }

                        try {
                            findDir = Environment.getExternalStorageDirectory();
                            directory = new File(findDir.getAbsolutePath());
                            directory.mkdirs();
                            fileName = new File(directory, "Match" + matchNum + "Data.csv");
                            fWriter = new FileOutputStream(fileName);
                            try {
                                fWriter.write(dataLabels.getBytes());
                                fWriter.write(fullMatchData.getBytes());
                                fWriter.flush();
                                fWriter.close();
                                Toast.makeText(getBaseContext(), "[Match" + matchNum + "Data.csv] successfully created", Toast.LENGTH_LONG).show();
                            } catch (IOException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        } catch (FileNotFoundException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
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

            Toast.makeText(getApplicationContext(), teamData, Toast.LENGTH_LONG).show();

            int i = 0;
            while (i < teamData.length() - 1) {
                int end = teamData.indexOf(",", i);
                teamStatsArr.add(teamData.substring(i, end));
                i = end + 1;

                matchDataArray.add(matchDataIndexer, teamData);
                matchDataIndexer = addOne(matchDataIndexer);
                // TODO arrays storage


            }
        }

    }
}
