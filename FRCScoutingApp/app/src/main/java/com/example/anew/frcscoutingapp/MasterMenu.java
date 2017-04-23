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


public class MasterMenu extends AppCompatActivity {
    Button backMasterMenu, scanCode, viewDatabase, next;
    Intent masterFillArray;
    ArrayList<ArrayList<String>> largeArray = new ArrayList<ArrayList<String>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_menu);
        masterMenuRun();
        masterFillArray = getIntent();
        teamArray = masterFillArray.getStringArrayExtra("PostMatchArray");
    }

    public void masterMenuRun() {

        backMasterMenu = (Button)findViewById(R.id.backMasterMenu);
        scanCode = (Button)findViewById(R.id.scanCode);
        viewDatabase = (Button)findViewById(R.id.viewDatabase);
        next = (Button)findViewById(R.id.poopNext);

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
                        Intent intent = new Intent(MasterMenu.this, MasterDataViewer.class);
                        startActivity(intent);

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

        next.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MasterMenu.this, MasterScanner.class);
                        startActivity(intent);
                    }
                }
        );
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (scanResult != null) {
            // handle scan result
            String re = scanResult.getContents();

            // String => array
            ArrayList<String> teamStatsArr = new ArrayList<String>(); // has each value for a team
            int i = 0;
            while (i < re.length() - 1) {
                int end = re.indexOf(",", i);
                teamStatsArr.add(re.substring(i, end));
                i = end + 1;
            }

            largeArray.add(teamStatsArr); // appends a team's data to overall matchArray

            // Display String for TESTING PURPOSES
            Toast.makeText(getApplicationContext(), re, Toast.LENGTH_LONG).show();

            // TODO arrays storage
        }
    }
}
