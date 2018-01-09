package org.team930.bears.base_app_ngs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ScouterMenu extends AppCompatActivity {
    Button startMatch, backScouterMenu;
    String [] teamArray;
    Intent scouterArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scouter_menu);
        scouterArray = getIntent();
        teamArray = scouterArray.getStringArrayExtra("PostMatchArray");
        onClickListenerScouterMenu();

    }

    public void onClickListenerScouterMenu() {

        startMatch = (Button) findViewById(R.id.startScouting);

        backScouterMenu = (Button) findViewById(R.id.backScouterMenu);

        startMatch.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(ScouterMenu.this, PreMatchMenu.class);
                        startActivity(intent);

                    }
                }

        );
        backScouterMenu.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(ScouterMenu.this, MainMenu.class);
                        startActivity(intent);

                    }
                }

        );

    }
}
