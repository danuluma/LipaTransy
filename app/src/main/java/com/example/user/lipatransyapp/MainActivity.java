package com.example.user.lipatransyapp;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText till_number;
    EditText seat_number;
    public EditText fare_charge;
    Button pay_button;

    int fare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        till_number = findViewById(R.id.till_number);

        seat_number = findViewById(R.id.seat_number);

        fare_charge = findViewById(R.id.fare_charge);
        fare = fare_charge.getInputType();

        pay_button = findViewById(R.id.pay_button);


        View.OnClickListener Listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (!till_number.getText().toString().trim().replaceAll("[^0-9]", "").equals("") && !seat_number.getText().toString().trim().equals("") && !fare_charge.getText().toString().trim().equals("") )
                {
                    Intent intent = new Intent(MainActivity.this, com.example.user.lipatransyapp.EnterPinActivity.class);
                    startActivity(intent);
                }

                    else
                {
                    Toast.makeText(MainActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                }
            }
        };
        pay_button.setOnClickListener(Listener);
    }


//    private String fare = fare_charge.getText().toString();
//    
//    public getFare( S)

}