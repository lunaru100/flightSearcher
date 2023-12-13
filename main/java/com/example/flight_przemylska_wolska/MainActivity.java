package com.example.flight_przemylska_wolska;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.example.flight_przemylska_wolska.Threads.PostThread;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    String[] airports = {"JFK - John F. Kennedy International Airport","LHR - London Heathrow Airport","CDG - Charles de Gaulle Airport","SFO - San Francisco International Airport","HND - Haneda Airport","DXB - Dubai International Airport","PEK - Beijing Capital International Airport","SYD - Sydney Airport","ICN - Incheon International Airport","AMS - Amsterdam Airport Schiphol"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Arrays.sort(airports);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line,airports);

        AutoCompleteTextView departureTextView = findViewById(R.id.departure);
        AutoCompleteTextView arrivalTextView = findViewById(R.id.arrival);

        departureTextView.setAdapter(adapter);
        arrivalTextView.setAdapter(adapter);

        View.OnClickListener dropDownClickListener = v -> {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) v;
            autoCompleteTextView.showDropDown();
        };

        departureTextView.setOnClickListener(dropDownClickListener);
        arrivalTextView.setOnClickListener(dropDownClickListener);

        Button searchBtn = findViewById(R.id.search);
        searchBtn.setOnClickListener(view -> {
            String deprartureValue = departureTextView.getText().toString();
            String arrivalValue = arrivalTextView.getText().toString();
            Toast.makeText(this,"Deprature: " + deprartureValue + " Arrival: " + arrivalValue,Toast.LENGTH_SHORT).show();
        });
    }

    public void getVal(View v) {
        PostThread postThread = new PostThread();
        postThread.start();
    }

    public void getFlight(View v){

    }
}
