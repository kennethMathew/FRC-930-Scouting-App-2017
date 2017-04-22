package com.example.anew.frcscoutingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import java.io.File;

public class MasterDataViewer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_data_viewer);
        String [] DataArray = new String [2]; //2 needs to be set as number of entries so that the array is the correct size.
        File file = getBaseContext().getFileStreamPath("Homework.dat");
        DataArray [0] = "yoyo"; //index 0 of the array
        DataArray [1] = "yoyo2"; //index 1 in the array
        //WriteToFile(DataArray, file, 2); //Pass the array and 2 entires are contained
//HelloWorld and GoodBye are now written to file.
    }
}