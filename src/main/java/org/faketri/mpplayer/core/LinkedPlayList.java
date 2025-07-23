package org.faketri.mpplayer.core;

import org.faketri.mpplayer.model.PlayList;
import org.faketri.mpplayer.model.Track;

import java.util.LinkedList;
import java.util.List;

public class LinkedPlayList<T extends Track> implements PlayList<T> {
    private final LinkedList<T> tracks;

    public LinkedPlayList() {
        tracks = new LinkedList<>();
    }

    @Override
    public LinkedList<T> getTracks() {
        return tracks;
    }

    @Override
    public void add(T track) {
        if (track == null) return;
        tracks.add(track);
    }

    @Override
    public void add(List<T> track) {
        tracks.addAll(track);
    }

    @Override
    public void remove(T track) {
        tracks.remove(track);
    }

    @Override
    public T nextTrackFind(T current) {
        int currentIndex = getTracks().indexOf(current);
        currentIndex = getTracks().size() - 1 == currentIndex ? 0 : currentIndex + 1;
        return getTracks().get(currentIndex);
    }

    public T previousTrackFind(T current) {
        int currentIndex = getTracks().indexOf(current);
        currentIndex = currentIndex == 0 ? 0 : currentIndex - 1;
        return getTracks().get(currentIndex);
    }
}
