package com.example.anew.frcscoutingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class QRStager extends AppCompatActivity {
        Button backQRStager, genQRCode, mainMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrstager);
        onClickListenerQRStager();
    }
    public void onClickListenerQRStager() {

        backQRStager = (Button) findViewById(R.id.backQRStager);
        genQRCode = (Button) findViewById(R.id.genQRCode);
        mainMenu = (Button) findViewById(R.id.mainMenu);


        genQRCode.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(QRStager.this, QRDeployer.class);
                        startActivity(intent);

                    }
                }

        );
        backQRStager.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(QRStager.this, ScouterMenu.class);
                        startActivity(intent);

                    }
                }

        );
        mainMenu.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(QRStager.this, MainMenu.class);
                        startActivity(intent);

                    }
                }

        );
    }
}
