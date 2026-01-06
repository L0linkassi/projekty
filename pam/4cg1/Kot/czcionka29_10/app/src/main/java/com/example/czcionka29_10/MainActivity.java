package com.example.czcionka29_10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SeekBar seekBar;
    TextView textRozmiar, textCytat;
    Button btnZmien;
    String[] cytaty = {
            "Dzień dobry", "Good morning", "Buenos dias"
    };

    int nrCytatu = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar = findViewById(R.id.seekBarRozmiar);
        textRozmiar = findViewById(R.id.textViewRozmiar);
        textCytat = findViewById(R.id.textViewCytat);
        btnZmien = findViewById(R.id.buttonKlik);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                textRozmiar.setText("Rozmiar: " + i);
                textCytat.setTextSize(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }


    public void btnKlik(View view) {
        nrCytatu += 1;
        if(nrCytatu == 3){
            nrCytatu = 0;
        }

        textCytat.setText(cytaty[nrCytatu]);
    }
}