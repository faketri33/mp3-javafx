package org.faketri.mpplayer.core;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import org.faketri.mpplayer.exception.TrackNotFound;
import org.faketri.mpplayer.model.AudioPlayer;
import org.faketri.mpplayer.model.PlayList;
import org.faketri.mpplayer.model.Track;


public class MyAudioPlayer<T extends Track> implements AudioPlayer<T> {
    private final LinkedPlayList<T> playList;
    private MediaPlayer mediaPlayer;
    public T currentTrack;

    public MyAudioPlayer(LinkedPlayList<T> playList) {
        this.playList = playList;
    }

    public void setCurrentTrack(T currentTrack) {
        this.currentTrack = currentTrack;
        mediaPlayer = new MediaPlayer(new Media(currentTrack.getPath()));
    }

    @Override
    public T getCurrentTrack() {
        return currentTrack;
    }

    @Override
    public void play() {
        if (currentTrack == null)
            throw new TrackNotFound();

        if (isPause()){
            mediaPlayer.play();
            return;
        }

        mediaPlayer = new MediaPlayer(new Media(currentTrack.getPath()));
        mediaPlayer.setOnEndOfMedia(this::next);
        mediaPlayer.play();
    }

    @Override
    public void pause() {
        if (isPlaying())
            mediaPlayer.pause();
    }

    @Override
    public void stop() {
        if (isPlaying())
            mediaPlayer.stop();
    }

    @Override
    public void next() {
        currentTrack = playList.nextTrackFind(currentTrack);
        System.out.println(currentTrack);
        stop();
        play();
    }

    @Override
    public void previous() {
        currentTrack = playList.previousTrackFind(currentTrack);
        System.out.println(currentTrack);
        stop();
        play();
    }

    @Override
    public Boolean isPlaying() {
        return mediaPlayer != null && mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING;
    }

    public Boolean isPause() {
        return mediaPlayer != null && mediaPlayer.getStatus() == MediaPlayer.Status.PAUSED;
    }

    public PlayList<T> getPlayList() {
        return playList;
    }
}
