package com.example.a1_10_2025;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
String TAG="zdarzenia";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onStart(){
        super.onStart();
        Log.d(TAG,"onStart()");
    }
    public void onRestart(){
        super.onRestart();
        Log.d(TAG, "onRestart()");
    }

    public void onResume(){
        super.onResume();
        Log.d(TAG, "onResume()");
    }

    public void onPause(){
        super.onPause();
        Log.d(TAG, "onPause()");
    }

    public void onStop(){
        super.onStop();
        Log.d(TAG, "onStop()");
    }

    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "onDestroy()");
    }
}