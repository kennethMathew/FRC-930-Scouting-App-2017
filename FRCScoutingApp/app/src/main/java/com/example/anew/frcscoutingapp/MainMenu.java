package com.example.anew.frcscoutingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.Intent;

public class MainMenu extends AppCompatActivity {
    Button scouter, master, settings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        onClickListenerMainMenu();

    }

    public void onClickListenerMainMenu() {

        scouter = (Button)findViewById(R.id.scouter);
        master = (Button)findViewById(R.id.master);
        settings = (Button)findViewById(R.id.settings);

            scouter.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainMenu.this, ScouterMenu.class);
                        startActivity(intent);

                    }
                }

        );
            master.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainMenu.this, MasterMenu.class);
                            startActivity(intent);

                        }
                    }

            );
            settings.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainMenu.this, SettingsMenu.class);
                            startActivity(intent);

                        }
                    }

            );


    }
}

