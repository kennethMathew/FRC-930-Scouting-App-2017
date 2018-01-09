package org.team930.bears.database;

import android.content.Context;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

@SuppressWarnings("InfiniteLoopStatement")
public class testdb extends AppCompatActivity {
    Button submitMessage, viewMessage;
    EditText messageInput, search;
    String[] chuck;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testdb);
        submitMessage = (Button) findViewById(R.id.submitMessage);
        viewMessage = (Button) findViewById(R.id.viewMessage);
        messageInput = (EditText) findViewById(R.id.messageInput);
        search = (EditText) findViewById(R.id.search);
        result = (TextView)findViewById(R.id.result);
        chuck = new String[10];
        seeResults();

    }

    public void writeMessage(View v) {

        String filename = "thefile";
        String outputString = messageInput.getText().toString();
        messageInput.setText("");

        try {
            FileOutputStream os = openFileOutput(filename, Context.MODE_PRIVATE);
            os.write(outputString.getBytes());
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void readMessage(View v) {
        String filename = "thefile";
        try {
            FileInputStream inputStream = openFileInput(filename);
            BufferedReader r = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder total = new StringBuilder();
            String line;
            while ((line = r.readLine()) != null) {
                total.append(line);
            }
            r.close();
            inputStream.close();
            String stuff = total.toString();

            chuck = stuff.split(",");


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void seeResults() {
        if (Integer.parseInt(chuck[0]) == 1) {
            result.setText(chuck[Integer.parseInt(search.getText().toString())]);

        }
    }
}

