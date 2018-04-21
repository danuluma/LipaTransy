package com.example.user.lipatransyapp;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.lipatransyapp.MainActivity;

public class EnterPinActivity extends AppCompatActivity {

    TextView enter_pin;
    EditText pin;
    Button ok_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_pin);

            pin = findViewById(R.id.user_pin);



            ok_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    Account user = new Account();
//                    if(pin.length() == 4){
//                        if(pin.getText().toString() == "2018"){

                            Toast.makeText(EnterPinActivity.this, "Payment Successfull", Toast.LENGTH_SHORT).show();
//                            AlertDialog confirm = new AlertDialog.Builder(EnterPinActivity.this).create();
//                            confirm.setTitle("Please confirm Transaction");
//                            confirm.setMessage("Confirm you are sending " );

                        }
//                        else{
//                            Toast.makeText(EnterPinActivity.this, "Incorrect Password", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                }
            });

    }
}
