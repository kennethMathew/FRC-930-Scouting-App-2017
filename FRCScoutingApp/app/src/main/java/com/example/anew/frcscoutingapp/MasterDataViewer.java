package com.example.anew.frcscoutingapp;

import android.content.Intent;
import android.support.annotation.RequiresPermission;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.io.RandomAccessFile;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import static com.example.anew.frcscoutingapp.FileIO.writeToFile;

public class MasterDataViewer extends AppCompatActivity {
    Integer arrayIndexer, dataFoundIndexer;
    String[] teamArray;
    Intent getInfo;
    int [] dataFound;
    Button search, match1, match2, match3, match4, match5, match6, match7, match8, match9, match10;
    EditText insertTeamNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_data_viewer);
        getInfo = getIntent();
        teamArray = getInfo.getStringArrayExtra("PostMatchArray");
        dataFound = new int [10];
        dataFoundIndexer = 0;
        searchForTeams();

    }

    public void searchForTeams() {
        insertTeamNum = (EditText)findViewById(R.id.insertTeamNum);
        match1 = (Button)findViewById(R.id.match1) ;
        match1.setText("Match " + teamArray [arrayIndexer + 1]);

        for (arrayIndexer = 0; arrayIndexer < teamArray.length + 1; ) {
            if (Integer.parseInt(teamArray [arrayIndexer]) == Integer.parseInt(insertTeamNum.getText().toString())) {
                dataFound [0] = arrayIndexer;
                if(dataFound.length == 1 ) {
                    match1.setText("Match " + teamArray [arrayIndexer + 1]);

                }
            }
            else if (dataFound.length == 2) {
            }


        }
    }
}