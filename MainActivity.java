package com.example.flight_przemylska_wolska;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.flight_przemylska_wolska.Threads.PostThread;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getVal(View v) {
        PostThread postThread = new PostThread();
        postThread.start();
    }
}
