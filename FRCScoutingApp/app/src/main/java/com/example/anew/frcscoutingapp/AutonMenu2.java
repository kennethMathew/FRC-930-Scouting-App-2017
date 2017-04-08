package com.example.anew.frcscoutingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AutonMenu2 extends AppCompatActivity {
    Button backAutonMenu2, goToTeleop, mainMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auton_menu2);
        onClickListenerAutonMenu2();
    }
    public void onClickListenerAutonMenu2() {

        backAutonMenu2 = (Button) findViewById(R.id.backAutonMenu2);
        goToTeleop = (Button) findViewById(R.id.goToTeleop);
        mainMenu = (Button) findViewById(R.id.mainMenu);



        goToTeleop.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent (AutonMenu2.this,TeleopMenu.class);
                        startActivity(intent);

                    }
                }

        );
        backAutonMenu2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(AutonMenu2.this, PreMatchMenu.class);
                        startActivity(intent);

                    }
                }

        );
        mainMenu.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(AutonMenu2.this, MainMenu.class);
                        startActivity(intent);

                    }
                }

        );
    }
}
