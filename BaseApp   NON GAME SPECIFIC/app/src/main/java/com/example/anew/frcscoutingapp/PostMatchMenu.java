package com.example.anew.frcscoutingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PostMatchMenu extends AppCompatActivity {
        Button backPostMatchMenu, submitMatchData, mainMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_match_menu);
        onClickListenerPostMatchMenu();
    }
    public void onClickListenerPostMatchMenu() {

        backPostMatchMenu = (Button) findViewById(R.id.backPostMatchMenu);
        submitMatchData = (Button) findViewById(R.id.submitMatchData);
        mainMenu = (Button) findViewById(R.id.mainMenu);



        submitMatchData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(PostMatchMenu.this,ScouterMenu.class);
                        startActivity(intent);

                    }
                }

        );
        backPostMatchMenu.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(PostMatchMenu.this, TeleopMenu.class);
                        startActivity(intent);

                    }
                }

        );
        mainMenu.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(PostMatchMenu.this, MainMenu.class);
                        startActivity(intent);

                    }
                }

        );
    }
}
