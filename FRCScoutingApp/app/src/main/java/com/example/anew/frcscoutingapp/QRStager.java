package com.example.anew.frcscoutingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.widget.ImageView;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.integration.android.IntentResult;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.integration.android.IntentIntegrator;

public class QRStager extends AppCompatActivity {
    Button backQRStager, genQRCode, mainMenu, next;
    Intent inputData;
    String [] teamArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrstager);
        inputData = getIntent();
        teamArray = inputData.getStringArrayExtra("PostMatchArray");
        onClickListenerQRStager();
    }
    public void onClickListenerQRStager() {

        backQRStager = (Button) findViewById(R.id.backQRStager);
        genQRCode = (Button) findViewById(R.id.genQRCode);
        mainMenu = (Button) findViewById(R.id.mainMenu);
        next = (Button) findViewById(R.id.next);

        genQRCode.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        
                        // Generate QR
                        QRCodeWriter writer = new QRCodeWriter();
                        try{
                            BitMatrix bitMatrix = writer.encode("content", BarcodeFormat.QR_CODE, 512, 512);
                            int width = bitMatrix.getWidth();
                            int height = bitMatrix.getHeight();
                            Bitmap bmp = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
                            for (int x  = 0; x < width; x++) {
                                for (int y = 0; y < height; y++) {
                                    bmp.setPixel(x, y, bitMatrix.get(x, y) ? Color.BLACK : Color.WHITE);
                                }
                            }
                            ((ImageView) findViewById(R.id.img_result_qr)).setImageBitmap(bmp);
                            System.out.print("GENERATING ***");
                        }
                        catch (WriterException e) {
                            e.printStackTrace();
                            System.out.print("Caught WriterException !!!");
                        }
                    }
                }

        );
        backQRStager.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(QRStager.this, ScouterMenu.class);
                        startActivity(intent);

                    }
                }

        );
        mainMenu.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(QRStager.this, MainMenu.class);
                        startActivity(intent);

                    }
                }

        );

        next.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(QRStager.this, QRDeployer.class);
                        startActivity(intent);
                    }
                }

        );
    }
}
