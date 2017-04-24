package com.example.anew.frcscoutingapp;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;


public class MasterMenu extends AppCompatActivity {
    Button backMasterMenu, scanCode, viewDatabase;
    Intent masterFillArray;
    ArrayList<String> matchDataArray, teamStatsArr;
    FileWriter fwriter;
    Integer matchDataIndexer;


    public Integer addOne(int baseValue) {
        baseValue = baseValue + 1;
        return baseValue;
    }

    public String matchData0Return() {
        try {
            String matchData0 = matchDataArray.get(0) + "\n";
            return matchData0;
        } catch (ArrayIndexOutOfBoundsException e) {
            e.getMessage();
            String matchData0 = "";
            return matchData0;
        }
    }

    public String matchData1Return() {
        try {
            String matchData1 = matchDataArray.get(1) + "\n";
            return matchData1;
        } catch (ArrayIndexOutOfBoundsException e) {
            e.getMessage();
            String matchData1 = "";
            return matchData1;
        }
    }

    public String matchData2Return() {
        try {
            String matchData2 = matchDataArray.get(2) + "\n";
            return matchData2;
        } catch (ArrayIndexOutOfBoundsException e) {
            e.getMessage();
            String matchData2 = "";
            return matchData2;
        }
    }

    public String matchData3Return() {
        try {
            String matchData3 = matchDataArray.get(3) + "\n";
            return matchData3;
        } catch (ArrayIndexOutOfBoundsException e) {
            e.getMessage();
            String matchData3 = "";
            return matchData3;
        }
    }

    public String matchData4Return() {
        try {
            String matchData4 = matchDataArray.get(4) + "\n";
            return matchData4;
        } catch (ArrayIndexOutOfBoundsException e) {
            e.getMessage();
            String matchData4 = "";
            return matchData4;
        }
    }

    public String matchData5Return() {
        try {
            String matchData5 = matchDataArray.get(5) + "\n";
            return matchData5;
        } catch (ArrayIndexOutOfBoundsException e) {
            e.getMessage();
            String matchData5 = "";
            return matchData5;
        }
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
                        String fullMatchData = matchData0Return() + matchData1Return() + matchData2Return() +
                                matchData3Return() + matchData4Return() + matchData5Return();
                        try {
                            File sdcard = Environment.getExternalStorageDirectory();
                            File directory = new File(sdcard.getAbsolutePath());
                            directory.mkdirs();
                            File file = new File(directory, "MatchData.csv");
                            FileOutputStream fou = new FileOutputStream(file);
                            try {
                                fou.write(fullMatchData.getBytes());
                                fou.flush();
                                fou.close();
                                Toast.makeText(getBaseContext(), "Data saved", Toast.LENGTH_LONG).show();
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
            teamStatsArr = new ArrayList<String>(); // has each value for a team
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
