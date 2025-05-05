package com.nigdroid.sangeet;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class Song_player extends AppCompatActivity {


    private SeekBar seekBar;
    private Button play;

    private MediaPlayer mediaPlayer;
    private Handler handler = new Handler(Looper.getMainLooper());
    private Runnable updateSeekBarRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_song_player);

        play=findViewById(R.id.Play);

        seekBar=findViewById(R.id.SeekBar);
//        mediaPlayer=MediaPlayer.create(this, R.raw.music_app_song);

//        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//            @Override
//            public void onPrepared(MediaPlayer mp) {
//                Toast.makeText(MainActivity.this, "GEt ready TO PLay", Toast.LENGTH_SHORT).show();
//
//                mp.start();
//            }
//        });
//        mediaPlayer.prepareAsync();


        int []song={
                R.raw.song_1,
                R.raw.song_2,
                R.raw.song_3,
                R.raw.song_4,
                R.raw.song_5,
                R.raw.song_6,
                R.raw.song_7,
                R.raw.song_8,
                R.raw.song_9,
                R.raw.song_10,
                R.raw.song_11,
                R.raw.song_12,
                R.raw.song_13,
                R.raw.song_14,
                R.raw.song_15,
                R.raw.song_16,
                R.raw.song_17,
                R.raw.song_18,
                R.raw.song_19,
                R.raw.song_20,
                R.raw.song_21,
                R.raw.song_22,
                R.raw.song_23,
                R.raw.song_24,

        };


        Intent intent=getIntent();
        int position=intent.getIntExtra("Song_Name_position",0);
        mediaPlayer=MediaPlayer.create(this,song[position]);

        seekBar.setMax(mediaPlayer.getDuration());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser){

                    mediaPlayer.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.getThumb().setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        updateSeekBarRunnable = new Runnable() {
            @Override
            public void run() {
                if (mediaPlayer.isPlaying()) {
                    int currentPosition = mediaPlayer.getCurrentPosition();
                    seekBar.setProgress(currentPosition);
                    // Schedule the update again after a delay
                    handler.postDelayed(updateSeekBarRunnable, 1000); // Update every 1 second (adjust as needed)
                }
            }
        };

        // Start playing the media when ready
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mediaPlayer.start();
                // Start updating the SeekBar
                handler.post(updateSeekBarRunnable);
            }
        });
        // handle mediaplayer completion
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mediaPlayer.seekTo(0);
                seekBar.setProgress(0);
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()){

                    mediaPlayer.pause();
                    play.setText("PLAY");
                }else{
                    mediaPlayer.start();
                    play.setText("PAUSE");
                }
            }
        });

    }
    @Override
    protected void onPause() {
        super.onPause();
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.release();
        handler.removeCallbacks(updateSeekBarRunnable);
    }
}