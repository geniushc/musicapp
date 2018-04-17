package com.example.shivani.musicplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Song extends AppCompatActivity implements View.OnClickListener{

    TextView songNameTextView;
    Button play, pause, resume, stop;
    MediaPlayer mediaPlayer;
    int songId, position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);


        String songName = getIntent().getExtras().getString("songName");

        songNameTextView = (TextView) findViewById(R.id.songNameTextView);
        songNameTextView.setText(songName);

        play = (Button) findViewById(R.id.playButton);
        pause = (Button) findViewById(R.id.pauseButton);
        stop = (Button) findViewById(R.id.stopButton);
        resume = (Button) findViewById(R.id.resumeButton);

        switch(songName){
            case "baarish":
                songId = R.raw.baarish;
                break;
            case "samjhawan":
                songId = R.raw.samjhawan;
                break;
            case "raabta":
                songId = R.raw.raabta;
                break;
        }

        mediaPlayer = MediaPlayer.create(this, songId);


        play.setOnClickListener(this);
        resume.setOnClickListener(this);
        pause.setOnClickListener(this);
        stop.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {


        switch (view.getId()){
            case R.id.playButton:
                if(mediaPlayer.isPlaying())
                    mediaPlayer.stop();
                mediaPlayer = MediaPlayer.create(this, songId);
                mediaPlayer.start();
                break;
            case R.id.pauseButton:
                if (mediaPlayer.isPlaying()) {
                    position = mediaPlayer.getCurrentPosition();
                    mediaPlayer.pause();
                }
                break;
            case R.id.resumeButton:
                mediaPlayer = MediaPlayer.create(this, songId);
                mediaPlayer.start();
                mediaPlayer.seekTo(position);
                break;
            case R.id.stopButton:
                mediaPlayer.stop();
                break;
        }


    }


    @Override
    protected void onStop() {
        super.onStop();

        mediaPlayer.release();
    }
}
