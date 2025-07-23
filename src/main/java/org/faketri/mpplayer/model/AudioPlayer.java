package org.faketri.mpplayer.model;

public interface AudioPlayer<T extends Track> {
    void setCurrentTrack(T currentTrack);
    T getCurrentTrack();
    void play();
    void pause();
    void stop();
    void next();
    void previous();
    Boolean isPlaying();
    PlayList<T> getPlayList();
}
