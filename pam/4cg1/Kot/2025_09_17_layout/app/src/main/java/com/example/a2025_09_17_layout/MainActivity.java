 package com.example.a2025_09_17_layout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

 public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView komunikat = (TextView) findViewById(R.id.textView);
        komunikat.setText("Witaj w ZSE");
    }

     public void przywitaj(View view) {
        TextView imie = (TextView)findViewById(R.id.editTextText2);
        String imieString = imie.getText().toString();
        String komunikat = String.format("Witaj %s w ZSE", imieString);

        TextView komunikatView = (TextView) findViewById(R.id.textView);
        komunikatView.setText(komunikat);
     }

     public void resetuj(View view) {
         TextView komunikatView = (TextView) findViewById(R.id.textView);
         komunikatView.setText("");

         TextView editView = (TextView)findViewById(R.id.editTextText2);
         editView.setText("");
     }

     public void Zamknij(View view) {
        finish();
     }
 }