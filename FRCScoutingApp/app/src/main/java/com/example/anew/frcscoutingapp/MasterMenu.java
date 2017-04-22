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
    Intent postMatchArray, masterFillArray;
    String [] teamArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_menu);
        onClickListenerMasterMenu();
        masterFillArray = getIntent();
        teamArray = masterFillArray.getStringArrayExtra("PostMatchArray");
    }

    public void onClickListenerMasterMenu() {

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
                        Intent intent = new Intent(MasterMenu.this, MasterStager.class);
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
            for (int i = 0; i < re.length; i++)

            // Display String for TESTING PURPOSES
            Toast.makeText(getApplicationContext(), re, Toast.LENGTH_LONG).show();

            // TODO arrays storage
        }
    }
}
