package com.example.reprovs;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class repro extends AppCompatActivity {


    private VideoView vv1;

    Button playv;
    Button pausav;
    Button plays;
    Button pausas;
    MediaPlayer mp;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repro);

        plays= findViewById(R.id.btnPlays);
        pausas = findViewById(R.id.btnPausas);

        playv = findViewById(R.id.btnplayv);
        pausav = findViewById(R.id.btnpausav);
        mp= MediaPlayer.create(this,R.raw.vd);

        playv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
            }
        });
        pausav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.pause();
            }
        });

        vv1 = findViewById(R.id.vv1);
        vv1.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.vd));
        MediaController mc = new MediaController(this);
        vv1.setMediaController(mc);
        mc.setAnchorView(vv1);

        plays.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                vv1.start();
            }});


        pausas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vv1.pause();
            }
        }  );

    }
}