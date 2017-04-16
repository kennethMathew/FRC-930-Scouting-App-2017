package com.example.anew.frcscoutingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MasterStager extends AppCompatActivity {
    Button backMasterStager, storeData, mainMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_stager);
        onClickListenerMasterStager();
    }
    public void onClickListenerMasterStager() {

        backMasterStager = (Button)findViewById(R.id.backMasterStager);
        storeData = (Button)findViewById(R.id.storeData);
        mainMenu = (Button) findViewById(R.id.mainMenu);

        backMasterStager.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MasterStager.this, MasterScanner.class);
                        startActivity(intent);

                    }
                }

        );
        storeData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MasterStager.this, MasterMenu.class);
                        startActivity(intent);

                    }
                }

        );
        mainMenu.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MasterStager.this, MainMenu.class);
                        startActivity(intent);

                    }
                }

        );
    }
}
