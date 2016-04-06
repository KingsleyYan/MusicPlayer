package com.android.kingyan.musicplayer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by yanj on 16/04/06.
 */
public class MusicPlayerFragment extends Fragment {
    AudioPlayer mAudioPlayer = new AudioPlayer();
    private Button mPlayButton;
    private Button mPauseButton;
    private Button mStopButton;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_musicplayer, container, false);
        mPlayButton = (Button) view.findViewById(R.id.button_play);
        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAudioPlayer.play(getActivity());
            }
        });
        mPauseButton = (Button) view.findViewById(R.id.button_pause);
        mPauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAudioPlayer.pause();
            }
        });
        mStopButton = (Button) view.findViewById(R.id.button_stop);
        mStopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAudioPlayer.stop();
            }
        });
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mAudioPlayer.stop();
    }
}
