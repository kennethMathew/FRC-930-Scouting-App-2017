package com.example.anew.frcscoutingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MasterScanner extends AppCompatActivity {
        Button backMasterScanner, doneScanning;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_scanner);
        onClickListenerMasterScanner();
    }
    public void onClickListenerMasterScanner() {

        backMasterScanner = (Button)findViewById(R.id.backMasterScanner);
        doneScanning = (Button)findViewById(R.id.doneScanning);


        doneScanning.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MasterScanner.this, PreMatchMenu.class);
                        startActivity(intent);

                    }
                }

        );

        backMasterScanner.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MasterScanner.this, MasterMenu.class);
                        startActivity(intent);

                    }
                }

        );


    }
}
