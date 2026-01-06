package com.example.czcionka2_29_10;

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

    int idCytatu = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar = findViewById(R.id.seekBarRozmiar);
        textRozmiar = findViewById(R.id.textViewRozmiar);
        textCytat = findViewById(R.id.textViewCytaty);

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

    public void btnZmien(View view) {
        idCytatu += 1;
        if(idCytatu == 3){
            idCytatu = 0;
        }
        textCytat.setText(cytaty[idCytatu]);
    }
}