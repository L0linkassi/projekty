package com.example.testandroid;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        Bundle bundle = getIntent().getExtras();
        TextView textView = findViewById(R.id.komunikat);
        if(bundle!=null)
        {
            String mail2 = bundle.getString("email");
            String powtorzHaslo2 = bundle.getString("haslo");
            String data2 = bundle.getString("data");
            textView.setText("Utworzono nowe konto " + mail2 + " z hasłem :" + powtorzHaslo2 + ".Data urodzenia " + data2);
        }
    }
}