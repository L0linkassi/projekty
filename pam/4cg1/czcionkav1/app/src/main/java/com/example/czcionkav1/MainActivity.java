package com.example.czcionkav1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView cytat, rozmiar;
    Button btn_cytat;
    SeekBar seekbar;

    String[] cytaty = {
            "Dzień dobry",
            "Good morning",
            "Buenos Dias"
    };

    int nr_cytatu=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cytat = findViewById(R.id.cyytat_view);
        rozmiar = findViewById(R.id.rozmiar_view);
        btn_cytat = findViewById(R.id.button);
        seekbar = findViewById(R.id.seekBar);
        cytat.setText(cytaty[nr_cytatu]);

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                rozmiar.setText("Rozmiar: " + i);
                cytat.setTextSize((float)i);
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
        cytat.setText(cytaty[nr_cytatu]);
    }
}