package com.example.anew.a930scoutingapp2017;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentResult;
import com.google.zxing.integration.android.IntentIntegrator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class MasterMenu extends AppCompatActivity {
    Button backMasterMenu, scanCode, viewDatabase;
    ArrayList<String> matchDataArray, teamStatsArr;
    Integer matchDataIndexer, teamDataIndexer;
    String allData, matchNum, dataLabels, fullMatchData;
    FileOutputStream fWriter;
    File findDir, directory, fileName;
    boolean createCSV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_menu);
        matchDataArray = new ArrayList<String>();
        teamStatsArr = new ArrayList<String>();
        matchDataIndexer = 0;
        teamDataIndexer = 0;
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
                        dataLabels = "teamNum,matchNum,crossedBaseline,gearsAuton,fuelLowAuton,fuelHighAuton," +
                                "gearsTeleop,fuelLowTeleop,fuelHighTeleop,climbYesNo,disabled,techFouls," +
                                "yellowCards,comments\n";

                        if (teamStatsArr.size() >= 2) {
                            matchNum = teamStatsArr.get(1);

                        } else {
                            matchNum = "";
                        }
                        if (isDataAvailable(fullMatchData)) {
                            try {
                                findDir = Environment.getExternalStorageDirectory(); // Finds external storage Directory
                                directory = new File(findDir.getAbsolutePath()); //sets the path to save the file to
                                directory.mkdirs();// gets access to the directory
                                fileName = new File(directory, "Match" + matchNum + "Data.csv"); //sets the file name and puts it into the directory
                                fWriter = new FileOutputStream(fileName);//creates a FOS to write to file
                                try {
                                    fWriter.write(dataLabels.getBytes()); // writes
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
                        } else {
                            Toast.makeText(getApplicationContext(), "No Data", Toast.LENGTH_LONG).show();
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
            matchDataArray.add(matchDataIndexer, scanResult.getContents());

            // String => array

            Toast.makeText(getApplicationContext(), "Data Saved", Toast.LENGTH_LONG).show();
           /*if(matchDataIndexer == 0){
               int i = 0;
              while (i < matchDataArray.get(0).length() - 1) {
                  int end = matchDataArray.get(0).indexOf(",", i);
                  teamStatsArr.add(matchDataArray.get(0).substring(i, end));
                    i = end + 1;
               }
            }
                // TODO arrays storage
                matchDataIndexer = addOne(matchDataIndexer); */
        }

    }

    public String matchDataReturn() {
        if (matchDataArray.size() == 0){
            allData = "";
            Toast.makeText(getApplicationContext(), "No Data", Toast.LENGTH_LONG).show();

        } else if(matchDataArray.size() == 1) {
            allData = matchDataArray.get(0) + "\n";
            Toast.makeText(getApplicationContext(), "1 Team", Toast.LENGTH_LONG).show();

        }else if(matchDataArray.size() == 2) {
            allData = matchDataArray.get(0) + "\n" + matchDataArray.get(1) + "\n";
            Toast.makeText(getApplicationContext(), "2 Teams", Toast.LENGTH_LONG).show();

        }else if(matchDataArray.size() == 3) {
            allData = matchDataArray.get(0) + "\n" + matchDataArray.get(1) + "\n" + matchDataArray.get(2) + "\n";
            Toast.makeText(getApplicationContext(), "3 Teams", Toast.LENGTH_LONG).show();

        }else if(matchDataArray.size() == 4) {
            allData = matchDataArray.get(0) + "\n" + matchDataArray.get(1) + "\n" + matchDataArray.get(2) + "\n" +
                    matchDataArray.get(3) + "\n";
            Toast.makeText(getApplicationContext(), "4 Teams", Toast.LENGTH_LONG).show();

        }else if(matchDataArray.size() == 5) {
            allData = matchDataArray.get(0) + "\n" + matchDataArray.get(1) + "\n" + matchDataArray.get(2) + "\n" +
                    matchDataArray.get(3) + "\n" + matchDataArray.get(4) + "\n";
            Toast.makeText(getApplicationContext(), "5 Teams", Toast.LENGTH_LONG).show();

        }else {
            allData = matchDataArray.get(0) + "\n" + matchDataArray.get(1) + "\n" + matchDataArray.get(2) + "\n" +
                    matchDataArray.get(3) + "\n" + matchDataArray.get(4) + "\n" + matchDataArray.get(5) + "\n";
            Toast.makeText(getApplicationContext(), "6 Teams", Toast.LENGTH_LONG).show();

        }
        return allData;
    }

    public Integer addOne(int baseValue) {
        baseValue = baseValue + 1;
        return baseValue;

    }
    public boolean isDataAvailable(String matchData){
        if(fullMatchData.isEmpty()){
        return false;
        } else {
        return true;
        }

    }
}
