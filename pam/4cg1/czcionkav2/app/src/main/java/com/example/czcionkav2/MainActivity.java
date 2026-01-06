package com.example.czcionkav2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView ROZMIAR, CYTAT;
    Button btn;
    SeekBar seekbar;

    String[] cytaty = {
            "Dzień dobry",
            "Good Morning",
            "Buenos Dias"
    };

    int nr_cytatu = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ROZMIAR = findViewById(R.id.rozmiar_view);
        CYTAT = findViewById(R.id.cytaty_view);
        seekbar = findViewById(R.id.seekBar);
        btn = findViewById(R.id.button);

        CYTAT.setText(cytaty[nr_cytatu]);

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                ROZMIAR.setText("Rozmiar: " + i);
                CYTAT.setTextSize((float)i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void btn_cytat(View view) {
        nr_cytatu++;
        if(nr_cytatu==cytaty.length){
            nr_cytatu=0;
        }
        CYTAT.setText(cytaty[nr_cytatu]);
    }
}