package com.example.gonzalo.escueladeaventuras.metadata;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by Rain on 23/04/2016.
 */
public class Music {
    private MediaPlayer track;

    public Music(){
        track = new MediaPlayer();
    }

    public MediaPlayer loadMusic(Context context, int idMusic){

        this.setTrack(MediaPlayer.create(context, idMusic));
        track.setVolume(100, 100);
        track.start();
        return track;
    }

    public void changeTrack(Context context, int idMusic){
        track.stop();
        this.loadMusic(context, idMusic);
    }

    public MediaPlayer getTrack(){
        return track;
    }

    public void stop(){
        track.stop();
    }

    public void setTrack(MediaPlayer TRack) {
        this.track = TRack;
    }
}
