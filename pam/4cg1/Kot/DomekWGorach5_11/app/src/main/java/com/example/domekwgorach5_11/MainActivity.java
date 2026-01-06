package com.example.domekwgorach5_11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn_click, btn_usun, btn_zablokuj;
    TextView polubienia;
    Integer licznik = 0;
    Boolean Blokada = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        polubienia = findViewById(R.id.polubienia);


    }

    public void btn_click(View view) {
        if(Blokada==false){
            licznik++;
            polubienia.setText(licznik + " polubień");
        }
    }

    public void btn_usun(View view) {
        if(Blokada==false) {
            if (!(licznik == 0)) {
                licznik--;
                polubienia.setText(licznik + " polunień");
            }
        }
    }

    public void btn_zablokuj(View view) {
        if(Blokada == false){
            Blokada = true;
            polubienia.setText("oferta zablokowana, " + licznik + " polubień");
        }else{
            Blokada = false;
            polubienia.setText(licznik + " polubień");
        }
    }
}