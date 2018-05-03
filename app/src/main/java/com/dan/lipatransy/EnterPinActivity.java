package com.dan.lipatransy;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.dan.lipatransyapp.R;

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
//                    Account dan = new Account();
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
        AlertDialog about = new AlertDialog.Builder(EnterPinActivity.this).create();
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
