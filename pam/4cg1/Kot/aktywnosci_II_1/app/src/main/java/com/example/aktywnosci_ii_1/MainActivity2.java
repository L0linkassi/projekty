package com.example.aktywnosci_ii_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            String napis = bundle.getString("Imie");
            int liczba = bundle.getInt("Wiek");
            TextView komunikat = findViewById(R.id.textView);
            String komunikat_string = String.format("%s ma %i  lat", napis, liczba);
            komunikat.setText(komunikat_string);
        }
    }
}