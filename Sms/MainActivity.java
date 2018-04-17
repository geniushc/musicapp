package com.example.shivani.smscall;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button call, sms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        call = (Button) findViewById(R.id.callButton);
        sms = (Button) findViewById(R.id.smsButton);

        call.setOnClickListener(this);
        sms.setOnClickListener(this);
    }

    private void checkPermission() {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) !=
                PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, 12);
        }

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) !=
                PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 12);
        }

    }

    @Override
    public void onClick(View view) {

        String number = ((EditText) findViewById(R.id.numberEditText)).getText().toString();
        String sms = ((EditText) findViewById(R.id.smsEditText)).getText().toString();

        switch (view.getId()) {
            case R.id.callButton:

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + number));
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(callIntent);
                break;

            case R.id.smsButton:
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(number, null , sms, null, null);

                Toast.makeText(this, "SMS sent!!", Toast.LENGTH_SHORT).show();
                break;
        }

    }
}
