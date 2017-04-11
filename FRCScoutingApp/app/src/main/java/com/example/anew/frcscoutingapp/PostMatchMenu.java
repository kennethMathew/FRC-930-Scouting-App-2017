package com.example.anew.frcscoutingapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;


import static com.example.anew.frcscoutingapp.R.id.redAlliance;

public class PostMatchMenu extends AppCompatActivity {
        Button backPostMatchMenu, submitMatchData, mainMenu;
        TextView loss, win;
        Switch winLoss;

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

        winLoss = (Switch)findViewById(R.id.winLoss);
        loss = (TextView)findViewById(R.id.loss);
        win = (TextView)findViewById(R.id.win);



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
        winLoss.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    loss.setBackgroundColor(Color.parseColor("#FF0000"));
                    loss.setTextSize(25);
                    win.setBackgroundColor(Color.parseColor("#ffffff"));

                }else{
                    win.setBackgroundColor(Color.parseColor("#0000ff"));
                    win.setTextSize(25);
                    loss.setBackgroundColor(Color.parseColor("#ffffff"));
                }
            }
        });
    }
}
