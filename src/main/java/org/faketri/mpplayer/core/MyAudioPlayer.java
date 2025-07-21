package org.faketri.mpplayer.core;

import org.faketri.mpplayer.model.AudioPlayer;
import org.faketri.mpplayer.model.PlayList;
import org.faketri.mpplayer.model.Track;

public class MyAudioPlayer<T extends Track> implements AudioPlayer<T> {
    private final PlayList<T> playList;
    public T currentTrack;

    public MyAudioPlayer(PlayList<T> playList) {
        this.playList = playList;
    }

    @Override
    public void play(T track) {
        currentTrack = track;
    }

    @Override
    public void pause() {

    }

    @Override
    public void stop() {

    }

    public PlayList<T> getPlayList() {
        return playList;
    }
}
