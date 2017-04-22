package com.example.anew.frcscoutingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MasterDataViewer extends AppCompatActivity {
    Integer arrayIndexer, dataFoundIndexer;
    String[] teamArray;
    int[] dataFound;
    Button performSearch, match1, match2, match3, match4, match5, match6, match7, match8, match9, match10;
    EditText insertTeamNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_data_viewer);
        teamArray = new String[3024];
        dataFound = new int[10];
        dataFoundIndexer = 0;
        arrayIndexer = 0;
        //searchForTeams();
    }
    public void searchForTeams() {
        insertTeamNum = (EditText) findViewById(R.id.insertTeamNum);
        performSearch = (Button) findViewById(R.id.performSearch);

        match1 = (Button) findViewById(R.id.match1);
        match2 = (Button) findViewById(R.id.match2);
        match3 = (Button) findViewById(R.id.match3);
        match4 = (Button) findViewById(R.id.match4);
        match5 = (Button) findViewById(R.id.match5);
        match6 = (Button) findViewById(R.id.match6);
        match7 = (Button) findViewById(R.id.match7);
        match8 = (Button) findViewById(R.id.match8);
        match9 = (Button) findViewById(R.id.match9);
        match10 = (Button) findViewById(R.id.match10);


        for (arrayIndexer = 0; arrayIndexer < teamArray.length + 1; ) {
            if (Integer.parseInt(teamArray[arrayIndexer]) == Integer.parseInt(insertTeamNum.getText().toString())) {
                dataFound[dataFoundIndexer] = arrayIndexer;
                if (dataFound.length == 1) {
                    match1.setText("Match " + teamArray[arrayIndexer + 1]);

                } else if (dataFound.length == 2) {
                    match2.setText("Match " + teamArray[arrayIndexer + 1]);

                } else if (dataFound.length == 2) {
                    match3.setText("Match " + teamArray[arrayIndexer + 1]);

                } else if (dataFound.length == 2) {
                    match4.setText("Match " + teamArray[arrayIndexer + 1]);

                } else if (dataFound.length == 2) {
                    match5.setText("Match " + teamArray[arrayIndexer + 1]);

                } else if (dataFound.length == 2) {
                    match6.setText("Match " + teamArray[arrayIndexer + 1]);

                } else if (dataFound.length == 2) {
                    match7.setText("Match " + teamArray[arrayIndexer + 1]);

                } else if (dataFound.length == 2) {
                    match8.setText("Match " + teamArray[arrayIndexer + 1]);

                } else if (dataFound.length == 2) {
                    match9.setText("Match " + teamArray[arrayIndexer + 1]);

                } else if (dataFound.length == 2) {
                    match10.setText("Match " + teamArray[arrayIndexer + 1]);


                }
            }
        }
    }
}

