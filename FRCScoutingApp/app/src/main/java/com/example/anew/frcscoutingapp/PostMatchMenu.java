package com.example.anew.frcscoutingapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;


import static com.example.anew.frcscoutingapp.R.id.redAlliance;

public class PostMatchMenu extends AppCompatActivity {
    Button submitMatchData;
    TextView loss, win;
    Switch winLoss;
    EditText comments;
    Intent postMatchArray;
    String [] teamArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_match_menu);
        postMatchArray = getIntent();
        teamArray = postMatchArray.getStringArrayExtra("Teleop2Array");
        postMatchMenu();
    }
    public void postMatchMenu() {

        submitMatchData = (Button) findViewById(R.id.submitMatchData);

        winLoss = (Switch)findViewById(R.id.winLoss);

        loss = (TextView)findViewById(R.id.loss);
        win = (TextView)findViewById(R.id.win);

        comments = (EditText)findViewById(R.id.comments);



        submitMatchData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (winLoss.isChecked()) {
                            teamArray [24]= "LOOOOOOOOOSERRRRR";
                        } else {
                            teamArray [24] = "930";
                        }
                        teamArray [25] = comments.getText().toString();

                        Intent startActivityPostMatchMenu = new Intent(PostMatchMenu.this, ScouterMenu.class);
                        startActivityPostMatchMenu.putExtra("PostMatchArray", teamArray);
                        startActivity(startActivityPostMatchMenu);

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
