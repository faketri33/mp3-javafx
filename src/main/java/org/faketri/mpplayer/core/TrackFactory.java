package org.faketri.mpplayer.core;

import org.faketri.mpplayer.events.EventDispatcher;
import org.faketri.mpplayer.events.StorageUpdateEvent;
import org.faketri.mpplayer.model.AudioPlayer;
import org.faketri.mpplayer.model.MyMp3Track;
import org.faketri.mpplayer.model.TrackStorage;

import java.util.List;
import java.util.Objects;

public class TrackFactory {
    private final EventDispatcher eventDispatcher;
    private final AudioPlayer<MyMp3Track> audioPlayer;
    private final TrackStorage<MyMp3Track> trackStorage;

    public TrackFactory() {
        eventDispatcher = new EventDispatcher();
        audioPlayer = new MyAudioPlayer<>(new LinkedPlayList<>());
        trackStorage = new LocalTrackStorage<>(eventDispatcher);

        eventSubscribe();
    }

    public TrackStorage<MyMp3Track> getTrackStorage() {
        return trackStorage;
    }

    public AudioPlayer<MyMp3Track> getAudioPlayer() {
        return audioPlayer;
    }

    private void updatePlayList() {
        List<MyMp3Track> existingTracks = getAudioPlayer().getPlayList().getTracks();

        List<MyMp3Track> newTracks = getTrackStorage()
                .getTrackList()
                .stream()
                .map(FileToTrack::format)
                .filter(Objects::nonNull)
                .filter(track -> existingTracks.stream().noneMatch(e -> e.getPath().equals(track.getPath())))
                .toList();

        if (!newTracks.isEmpty())
            getAudioPlayer().getPlayList().add(newTracks);

    }

    private void eventSubscribe() {
        eventDispatcher.register(StorageUpdateEvent.class, event -> {
            updatePlayList();
        });
    }
}
