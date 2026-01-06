package com.example.aktywnosci_ii_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickMainActivity2(View view) {
        // startActivity(new Intent(this, MainActivity2.class));
        Intent i = new Intent(this, MainActivity2.class);
        i.putExtra("Imie", "Adam");
        i.putExtra("Wiek", 18);
        startActivity(i);
    }
}