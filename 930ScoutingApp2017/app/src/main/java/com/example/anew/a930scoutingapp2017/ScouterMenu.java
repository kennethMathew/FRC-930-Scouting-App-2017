package com.example.anew.a930scoutingapp2017;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ScouterMenu extends AppCompatActivity {
    Button startMatch, genQR, backScouterMenu;
    String [] teamArray;
    Intent scouterArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scouter_menu);
        scouterArray = getIntent();
        teamArray = scouterArray.getStringArrayExtra("PostMatchArray");
        onClickListenerScouterMenu();

    }

    public void onClickListenerScouterMenu() {

        startMatch = (Button) findViewById(R.id.startScouting);
        genQR = (Button) findViewById(R.id.viewDatabase);
        backScouterMenu = (Button) findViewById(R.id.backScouterMenu);

        startMatch.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(ScouterMenu.this, PreMatchMenu.class);
                        startActivity(intent);

                    }
                }

        );
        genQR.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent startActivityScouterMenu = new Intent(ScouterMenu.this, QRStager.class);
                        startActivityScouterMenu.putExtra("ScouterArray", teamArray);
                        startActivity(startActivityScouterMenu);

                    }
                }

        );
        backScouterMenu.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(ScouterMenu.this, MainMenu.class);
                        startActivity(intent);

                    }
                }

        );

    }
}
