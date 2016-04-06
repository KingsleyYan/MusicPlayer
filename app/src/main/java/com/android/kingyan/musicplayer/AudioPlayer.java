package com.android.kingyan.musicplayer;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by yanj on 16/04/06.
 */
public class AudioPlayer {
    private MediaPlayer mMediaPlayer;

    public void stop() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }

    public void play(Context context) {
        stop();
        mMediaPlayer = MediaPlayer.create(context, R.raw.one_small_step);
        mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stop();
            }
        });
        mMediaPlayer.start();
    }

    public void pause() {
        if (mMediaPlayer.isPlaying()) {
            mMediaPlayer.pause();
        } else {
            mMediaPlayer.start();
        }
    }


}
