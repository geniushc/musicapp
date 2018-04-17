package com.example.shivani.onoff;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    Button wifiOn, wifiOff;
    Button mobileDataOn, mobileDataOff;
    Button hotspotOn, hotspotOff;
    Button bluetoothOn, bluetoothOff;

    WifiManager wifi;
    BluetoothAdapter bluetoothAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wifiOn = (Button) findViewById(R.id.wifiOnButton);
        wifiOff = (Button) findViewById(R.id.wifiOffButton);

        mobileDataOn = (Button) findViewById(R.id.mobileDataOnButton);
        mobileDataOff = (Button) findViewById(R.id.mobileDataOffButton);

        hotspotOn = (Button) findViewById(R.id.hotspotOnButton);
        hotspotOff = (Button) findViewById(R.id.hotspotOffButton);

        bluetoothOn = (Button) findViewById(R.id.hotspotOnButton);
        bluetoothOff = (Button)  findViewById(R.id.bluetoothOffButton);

        wifiOn.setOnClickListener(this);
        wifiOff.setOnClickListener(this);
        mobileDataOn.setOnClickListener(this);
        mobileDataOff.setOnClickListener(this);
        hotspotOn.setOnClickListener(this);
        hotspotOff.setOnClickListener(this);
        bluetoothOn.setOnClickListener(this);
        bluetoothOff.setOnClickListener(this);

//
//        wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
//        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
//

        wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.wifiOnButton:
                wifi.setWifiEnabled(true);
                break;
            case R.id.wifiOffButton:
                wifi.setWifiEnabled(false);
                break;
            case R.id.hotspotOnButton:
                break;
            case R.id.hotspotOffButton:
                break;
            case R.id.mobileDataOnButton:
                break;
            case R.id.mobileDataOffButton:
                break;
            case R.id.bluetoothOnButton:
                bluetoothAdapter.enable();
                break;
            case R.id.bluetoothOffButton:
                bluetoothAdapter.disable();
                break;
        }

    }


}
