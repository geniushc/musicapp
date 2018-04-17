package com.example.shivani.download;

import android.Manifest;
import android.app.DownloadManager;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button downloadButton;
    DownloadManager downloadManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE) !=
                PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 12);
        }

        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.INTERNET) !=
                PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET}, 12);
        }

        downloadManager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);

        downloadButton = (Button) findViewById(R.id.downloadButton);

        downloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    Uri uri = Uri.parse("https://pythonprogramming.net/static/favicon.ico");

                    DownloadManager.Request request = new DownloadManager.Request(uri);

                    request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_MOBILE
                            | DownloadManager.Request.NETWORK_WIFI);

                    request.setAllowedOverRoaming(false);
                    request.setTitle("Sample Image");
                    request.setDescription("Image is from pythonprogramming.net");
                    request.setVisibleInDownloadsUi(true);

                    request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "sample.ico");

                    downloadManager.enqueue(request);

                    Toast.makeText(MainActivity.this, "File Downloaded", Toast.LENGTH_SHORT).show();
                }catch(Exception e){
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "Error in downloading", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
