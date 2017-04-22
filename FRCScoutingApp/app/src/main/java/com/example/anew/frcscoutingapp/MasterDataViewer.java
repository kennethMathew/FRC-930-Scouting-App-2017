package com.example.anew.frcscoutingapp;

import android.support.annotation.RequiresPermission;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import java.io.RandomAccessFile;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import static com.example.anew.frcscoutingapp.FileIO.writeToFile;

public class MasterDataViewer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_data_viewer);
        ArrayList<String> taArray = new ArrayList<String>(2); //2 needs to be set as number of entries so that the array is the correct size.
        File file = getBaseContext().getFileStreamPath("Homework.dat");
        taArray.set(0, "HelloWorld");  //index 0 of the array
        taArray.set(1, "GoodBye"); //index 1 in the array
       // writeToFile(taArray, file, 2); //Pass the array and 2 entires are contained
//HelloWorld and GoodBye are now written to file.
    }
}