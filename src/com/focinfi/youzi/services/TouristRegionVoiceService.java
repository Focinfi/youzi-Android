package com.focinfi.youzi.services;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

import java.io.IOException;

/**
 * Created by Antony on 16/1/29.
 */
public class TouristRegionVoiceService extends Service {
    private MediaPlayer player;

    public static final int PLAY = 0;
    public static final int PAUSE = 1;
    public static final int STOP = 2;

    public void createNewPlayer(String musicUrl) {
        if (player == null && !musicUrl.isEmpty()) {
            player = MediaPlayer.create(TouristRegionVoiceService.this, Uri.parse(musicUrl));
            player.setLooping(false);
        }
    }

    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        if (player != null) {
            player.stop();
            player.release();
            player = null;
        }
        super.onDestroy();
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Bundle b = intent.getExtras();
        int op = b.getInt("command");

        switch (op) {
            case PLAY:
                play();
                break;
            case PAUSE:
                pause();
                break;
            case STOP:
                stop();
                break;
            default:
                break;
        }
        String voiceUrl = b.getString("voice_url");

        if (voiceUrl != "") {
            createNewPlayer(voiceUrl);
        }
        return super.onStartCommand(intent, flags, startId);
    }


    private void stop() {

        if (player != null) {
            player.seekTo(0);
            player.stop();
            try {
                player.prepare();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private void pause() {

        if (player.isPlaying() && player != null) {
            player.pause();
        }
    }


    private void play() {

        if (player != null && !player.isPlaying()) {
            player.start();
        }
    }
}
