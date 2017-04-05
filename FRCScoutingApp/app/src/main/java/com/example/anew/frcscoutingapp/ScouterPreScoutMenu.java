package com.example.anew.frcscoutingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ScouterPreScoutMenu extends AppCompatActivity {
        Button backPreScout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scouter_pre_scout_menu);
        onClickBackButtonListener();
    }
    public void onClickBackButtonListener() {
        backPreScout = (Button)findViewById(R.id.backPreScout);
        backPreScout.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(ScouterPreScoutMenu.this, MainMenu.class);
                        startActivity(intent);

                    }
                }

        );
    }
}
