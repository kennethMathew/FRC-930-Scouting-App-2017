package com.example.anew.frcscoutingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class QRDeployer extends AppCompatActivity {
        Button backQRDeployer, doneWithCode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrdeployer);
        onClickListenerQRDeployer();
    }
    public void onClickListenerQRDeployer() {

        backQRDeployer = (Button) findViewById(R.id.backQRDeployer);
        doneWithCode = (Button) findViewById(R.id.doneWithCode);


        doneWithCode.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(QRDeployer.this,ScouterMenu.class);
                        startActivity(intent);

                    }
                }

        );
        backQRDeployer.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(QRDeployer.this, QRStager.class);
                        startActivity(intent);

                    }
                }

        );
    }
}
