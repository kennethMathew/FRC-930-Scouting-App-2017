package com.example.anew.a930scoutingapp2017;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class RunMenu extends AppCompatActivity {


    Button goToAuton2;
    ImageButton addItemsAuton, subtractItemsAuton;
    Integer numItemsAuton, arrayIndexer;
    TextView itemsDisplayerAuton;
    String [] teamArray;
    Intent autonArray, startActivityAutonMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auton_menu);
        numItemsAuton = 0;
        autonArray = getIntent();
        teamArray = autonArray.getStringArrayExtra("PreMatchArray");
        runMenu();

    }
    public void runMenu() {


        goToAuton2 = (Button) findViewById(R.id.goToAuton2);

        addItemsAuton = (ImageButton) findViewById(R.id.addItemsAuton);
        subtractItemsAuton = (ImageButton) findViewById(R.id.subtractItemsAuton);

        itemsDisplayerAuton = (TextView) findViewById(R.id.itemsDisplayerAuton);

        goToAuton2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                            teamArray [arrayIndexer] = Integer.toString(numItemsAuton);
                            teamArray [arrayIndexer] = "0";

                        startActivityAutonMenu = new Intent(AutonMenu.this, AutonMenu2.class);
                        startActivityAutonMenu.putExtra("RunArray", teamArray);
                        startActivity(startActivityAutonMenu);


                    }
                }

        );
        addItemsAuton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        numItemsAuton = numItemsAuton + 1;
                        itemsDisplayerAuton.setTextSize(30);
                        itemsDisplayerAuton.setText("# Items: " + Integer.toString(numItemsAuton));

                    }
                }

        );
        subtractItemsAuton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        numItemsAuton = numItemsAuton - 1;
                        itemsDisplayerAuton.setTextSize(30);
                        itemsDisplayerAuton.setText("# Items: " + Integer.toString(numItemsAuton));

                    }
                }

        );
    }

    public Integer addOne(int baseValue){
        baseValue = baseValue + 1;
        return baseValue;
    }

}
