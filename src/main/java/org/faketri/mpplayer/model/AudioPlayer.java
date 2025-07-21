package org.faketri.mpplayer.model;

public interface AudioPlayer<T extends Track> {
    void setCurrentTrack(T currentTrack);
    void play();
    void pause();
    void stop();
    PlayList<T> getPlayList();
}
