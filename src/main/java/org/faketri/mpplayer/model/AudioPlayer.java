package org.faketri.mpplayer.model;

public interface AudioPlayer<T extends Track> {
    void play(T track);
    void pause();
    void stop();
    PlayList<T> getPlayList();
}
