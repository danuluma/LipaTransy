package com.example.user.lipatransyapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.switchuser:

                return true;
            case R.id.faqs:
                return true;
            case R.id.feedback:
                return true;
            case R.id.about:

                about();

                return true;
            default:

                return super.onOptionsItemSelected(item);
        }


    }

    private void about() {
        AlertDialog about = new AlertDialog.Builder(MainActivity.this).create();
        about.setTitle("About");
        about.setMessage("LipaTransApp\n" +

                "Copyright:2018\nAll Rights Reserved");
        about.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        about.show();
    }
}
