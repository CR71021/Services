package com.example.myapplication;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import android.view.View;
import android.widget.Toast;


public class MyService extends Service {
    private MediaPlayer player;

    @Override
    public void onCreate() {
        super.onCreate();

    }


    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "services started..", Toast.LENGTH_LONG);
        player = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);
        player.setLooping(true);
        player.start();
        return START_STICKY;
    }


    public void onDestroy() {
        player.stop();
        Toast.makeText(this, "services stopped..", Toast.LENGTH_LONG);

    }

    public IBinder onBind(Intent intent) {
        return null;
    }


}

