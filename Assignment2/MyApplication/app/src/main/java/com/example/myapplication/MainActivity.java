package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final String MSG = "com.course.CUSTOM_INTENT";
    private MyReceiver myReceiver = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("", "Android App: On Create");
    }
    @Override
    protected void onResume(){
        super.onResume();
        registerReceiver();
    }
    @Override
    protected void onPause(){
        super.onPause();
    }
    public void broadcastIntent(View v) {
        Intent intent = new Intent();
        intent.setAction("com.course.CUSTOM_INTENT");
        sendBroadcast(intent);
    }
    private void registerReceiver(){
        if(myReceiver != null) return;
        final IntentFilter filter = new IntentFilter();
        filter.addAction(MSG);

        this.myReceiver = new MyReceiver();
        this.registerReceiver(this.myReceiver, filter);
    }

    private void unregisterReceiver(){
        if(myReceiver!=null){
            this.unregisterReceiver(myReceiver);
            myReceiver = null;
        }
    }
}