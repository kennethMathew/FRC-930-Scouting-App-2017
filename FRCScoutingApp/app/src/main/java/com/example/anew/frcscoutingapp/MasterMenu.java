package com.example.anew.frcscoutingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MasterMenu extends AppCompatActivity {
    Button backMasterMenu, scanCode, viewDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_menu);
        onClickListenerMasterMenu();
    }
    public void onClickListenerMasterMenu() {

        backMasterMenu = (Button)findViewById(R.id.backMasterMenu);
        scanCode = (Button)findViewById(R.id.scanCode);
        viewDatabase = (Button)findViewById(R.id.viewDatabase);

        scanCode.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MasterMenu.this, MasterScanner.class);
                        startActivity(intent);

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


    }
}
