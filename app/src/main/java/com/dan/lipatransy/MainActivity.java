package com.dan.lipatransy;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dan.lipatransyapp.R;
import com.twigafoods.daraja.Daraja;
import com.twigafoods.daraja.DarajaListener;
import com.twigafoods.daraja.model.AccessToken;
import com.twigafoods.daraja.model.LNMExpress;
import com.twigafoods.daraja.model.LNMResult;

public class MainActivity extends AppCompatActivity {
    EditText till_number;
    EditText seat_number;
    EditText fare_charge;
    Button pay_button;
    EditText etPhone;

    Daraja daraja;

    String phoneNumber;
    String seat, fare, till;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        till_number = findViewById(R.id.till_number);
//        int till = till_number.getInputType();


        seat_number = findViewById(R.id.seat_number);
        fare_charge = findViewById(R.id.fare_charge);
        pay_button = findViewById(R.id.pay_button);
        etPhone = findViewById(R.id.etPhone);


        daraja = Daraja.with("il98urKhJ2zHaCI8hegtXAXYrmPVC57t", "LuKQAF4Ph69GhEvu", new DarajaListener<AccessToken>() {
            @Override
            public void onResult(@NonNull AccessToken accessToken) {
                Log.i(MainActivity.this.getClass().getSimpleName(), accessToken.getAccess_token());
                Toast.makeText(MainActivity.this, "TOKEN : " + accessToken.getAccess_token(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(String error) {
                Log.e(MainActivity.this.getClass().getSimpleName(), error);
            }
        });


        pay_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//              if (!till_number.getText().toString().trim().replaceAll("[^0-9]", "").equals("") && !seat_number.getText().
// toString().trim().equals("") && !fare_charge.getText().toString().trim().equals("") )
//              {
//
//
//
////                    Intent intent = new Intent(MainActivity.this, EnterPinActivity.class);
////                    startActivity(intent);
//              }
//
//              else
//              {
//                  Toast.makeText(MainActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
//              }

                phoneNumber = etPhone.getText().toString().trim();
                till = till_number.getText().toString().trim();
                seat = seat_number.getText().toString().trim();
                fare = fare_charge.getText().toString().trim();


                LNMExpress lnmExpress = new LNMExpress(
                        till,

                        "bfb279f9aa9bdbcf158e97dd71a467cd2e0c893059b10f78e6b72ada1ed2c919",  //https://developer.safaricom.co.ke/test_credentials
                        fare,
                        "254708374149",
                        "174379",
                        phoneNumber,
                        "http://mycallbackurl.com/checkout.php",
                        seat,
                        "Fare Payment"
                );


                daraja.requestMPESAExpress(lnmExpress,

                        new DarajaListener<LNMResult>() {
                            @Override
                            public void onResult(@NonNull LNMResult lnmResult) {
                                Log.i(MainActivity.this.getClass().getSimpleName(), lnmResult.ResponseDescription);
                            }

                            @Override
                            public void onError(String error) {
                                Log.i(MainActivity.this.getClass().getSimpleName(), error);
                            }
                        }
                );

            }
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
