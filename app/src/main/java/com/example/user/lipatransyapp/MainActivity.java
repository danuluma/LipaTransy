package com.example.user.lipatransyapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText till_number;
    EditText seat_number;
    EditText fare_charge;
    Button pay_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        till_number = findViewById(R.id.till_number);
        int till = till_number.getInputType();


        seat_number = findViewById(R.id.seat_number);
        fare_charge = findViewById(R.id.fare_charge);
        pay_button = findViewById(R.id.pay_button);


    }
}
