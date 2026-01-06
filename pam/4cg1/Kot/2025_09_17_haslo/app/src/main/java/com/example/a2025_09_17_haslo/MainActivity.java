package com.example.a2025_09_17_haslo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void zmien(View view) {
        String textFind="@";

        TextView obecne = (TextView)findViewById(R.id.editText_obecneHaslo);
        String ObecneHaslo = obecne.getText().toString();

        TextView nowe = (TextView)findViewById(R.id.editText_noweHaslo);
        String NoweHaslo = nowe.getText().toString();

        TextView powtorzNowe = (TextView)findViewById(R.id.editText_obecneHaslo);
        String powtorzNoweHaslo = powtorzNowe.getText().toString();

        if(obecne.equals("MojeHaslo!")){
            if(nowe.contains(textFind)) {
            }
            }
        }
        else{

        }
    }
}