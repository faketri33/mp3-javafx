package org.faketri.mpplayer.core;

import org.faketri.mpplayer.events.EventDispatcher;
import org.faketri.mpplayer.events.StorageUpdateEvent;
import org.faketri.mpplayer.model.AudioPlayer;
import org.faketri.mpplayer.model.MyMp3Track;
import org.faketri.mpplayer.model.TrackStorage;

import java.util.Collection;

public class TrackFactory {
    private final TrackStorage<MyMp3Track> trackStorage;
    private final AudioPlayer<MyMp3Track> audioPlayer;
    private final EventDispatcher eventDispatcher;

    public TrackFactory(TrackStorage<MyMp3Track> trackStorage, AudioPlayer<MyMp3Track> audioPlayer, EventDispatcher eventDispatcher) {
        this.trackStorage = trackStorage;
        this.audioPlayer = audioPlayer;
        this.eventDispatcher = eventDispatcher;

        eventSubscribe();
    }

    public TrackStorage<MyMp3Track> getTrackStorage() {
        return trackStorage;
    }

    public AudioPlayer<MyMp3Track> getAudioPlayer() {
        return audioPlayer;
    }

    private void updatePlayList(){
        Collection<MyMp3Track> collection = getTrackStorage().getTrackList().stream().map(FileToTrack::format).toList();
        getAudioPlayer()
                .getPlayList()
                .add(collection);
    }

    private void eventSubscribe(){
        eventDispatcher.register(StorageUpdateEvent.class, event -> {
            updatePlayList();
        });
    }
}
