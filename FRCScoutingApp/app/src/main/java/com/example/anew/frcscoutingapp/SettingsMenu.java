package com.example.anew.frcscoutingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SettingsMenu extends AppCompatActivity {
    Button backSettingsMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_menu);
        onClickListenerSettingsMenu();
    }
    public void onClickListenerSettingsMenu() {

        backSettingsMenu = (Button)findViewById(R.id.backSettingsMenu);

        backSettingsMenu.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(SettingsMenu.this, MainMenu.class);
                        startActivity(intent);

                    }
                }

        );


    }
}
