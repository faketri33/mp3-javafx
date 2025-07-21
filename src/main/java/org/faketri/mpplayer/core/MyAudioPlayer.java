package org.faketri.mpplayer.core;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import org.faketri.mpplayer.model.AudioPlayer;
import org.faketri.mpplayer.model.PlayList;
import org.faketri.mpplayer.model.Track;


public class MyAudioPlayer<T extends Track> implements AudioPlayer<T> {
    private final PlayList<T> playList;
    private MediaPlayer mediaPlayer;
    public T currentTrack;

    public MyAudioPlayer(PlayList<T> playList) {
        this.playList = playList;
    }

    public void setCurrentTrack(T currentTrack) {
        this.currentTrack = currentTrack;
        mediaPlayer = new MediaPlayer(new Media(currentTrack.getPath()));
    }

    @Override
    public void play() {
        if (mediaPlayer != null)
            mediaPlayer.play();
    }

    @Override
    public void pause() {
        if (mediaPlayer != null)
            mediaPlayer.pause();
    }

    @Override
    public void stop() {
        if (mediaPlayer != null)
            mediaPlayer.stop();
    }

    public PlayList<T> getPlayList() {
        return playList;
    }
}
