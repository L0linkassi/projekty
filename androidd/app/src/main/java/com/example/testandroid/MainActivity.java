package com.example.testandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.testandroid.MainActivity2;
import com.example.testandroid.R;

public class MainActivity extends AppCompatActivity {
    CalendarView calendarView;
    Button button;
    EditText emailview;
    EditText hasloview;
    EditText powtorzHasloView;
    TextView dataurodzeniaview;





    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        calendarView = findViewById(R.id.kalendarz);
        button = findViewById(R.id.rejestruj);
        emailview = findViewById(R.id.mail);
        hasloview = findViewById(R.id.haslo);
        powtorzHasloView = findViewById(R.id.powtorzHaslo);
        dataurodzeniaview = findViewById(R.id.poleShow);



        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String dataurodzenia = year+"-"+(month+1)+"-"+dayOfMonth;
                dataurodzeniaview.setText(dataurodzenia);
            }
        });


        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String mail2 = emailview.getText().toString();
                String haslo2 = powtorzHasloView.getText().toString();
                String dataurodzenia2 = dataurodzeniaview.getText().toString();
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("email",mail2);
                intent.putExtra("haslo",haslo2);
                intent.putExtra("data",dataurodzenia2);




                startActivity(intent);



            }

        });


    }}
