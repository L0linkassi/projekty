package com.example.a2025_09_17_cwiczenie;

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

    public void wypisz(View view) {
        TextView imie = (TextView)findViewById(R.id.editTextText);
        String imieString = imie.getText().toString();
        String komunikat1 = String.format("Witaj %s w ZSE ", imieString);


        TextView numerTel = (TextView)findViewById(R.id.editTextPhone);
        String numerTelString = numerTel.getText().toString();
        String komunikat2 = String.format("twój numer telefonu to %s ", numerTelString);

        TextView srednia = (TextView)findViewById(R.id.editTextNumberDecimal);
        String sredniaString = srednia.getText().toString();
        String komunikat3 = String.format(" Twoja srednia wynosi %s ", sredniaString);

        TextView data = (TextView)findViewById(R.id.editTextDate);
        String dataString = data.getText().toString();
        String komunikat4 = String.format(" Urodziłes się %s ", dataString);

        TextView ksywka = (TextView)findViewById(R.id.editTextText2);
        String ksywkaString = ksywka.getText().toString();
        String komunikat5 = String.format(" Nazywają cię %s ", ksywkaString);

        TextView mail = (TextView)findViewById(R.id.editTextTextEmailAddress);
        String mailString = mail.getText().toString();
        String komunikat6 = String.format(" twoj mail to %s", mailString);

        TextView wiek = (TextView)findViewById(R.id.editTextNumber);
        String wiekString = wiek.getText().toString();
        String komunikat7 = String.format(" Masz %s lat ", wiekString);

        TextView haslo = (TextView)findViewById(R.id.editTextTextPassword);
        String hasloString = haslo.getText().toString();
        String komunikat8 = String.format(" Twoje haslo to %s ", hasloString);

        TextView godzina = (TextView)findViewById(R.id.editTextTime);
        String godzinaString = godzina.getText().toString();
        String komunikat9 = String.format(" Musisz wstac o  %s  ", godzinaString);

        TextView hobby = (TextView)findViewById(R.id.editTextText3);
        String hobbyString = hobby.getText().toString();
        String komunikat10 = String.format(" Twoje zainteresowania to  %s  ", hobbyString);


        String komunikat = komunikat1 + komunikat2 + komunikat3 + komunikat4 + komunikat5 + komunikat6 + komunikat7 + komunikat8 + komunikat9 + komunikat10;


        TextView komunikatView = (TextView) findViewById(R.id.textView);
        komunikatView.setText(komunikat);
    }
}