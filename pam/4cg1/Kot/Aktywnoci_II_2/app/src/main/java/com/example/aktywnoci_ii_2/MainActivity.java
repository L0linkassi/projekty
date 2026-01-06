package com.example.aktywnoci_ii_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnClickMainActivity2(View view) {
        //startActivity(new Intent(this, MainActivity2.class));

        TextView tmpImie = (TextView)findViewById(R.id.TVImie);
        String inputImie = tmpImie.getText().toString();

        TextView tmpWiek = findViewById(R.id.TVWiek);
        String inputWiekString = tmpWiek.getText().toString();
        Integer inputWiek = Integer.parseInt(inputWiekString);

        Intent i = new Intent(this, MainActivity2.class);
        i.putExtra("Imie", inputImie);
        i.putExtra("Wiek", inputWiek);
        startActivity(i);
    }
}