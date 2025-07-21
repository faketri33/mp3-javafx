package org.faketri.mpplayer.core;

import org.faketri.mpplayer.model.PlayList;
import org.faketri.mpplayer.model.Track;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ArrayPlayList<T extends Track> implements PlayList<T> {
    private List<T> tracks;

    public ArrayPlayList() {
        tracks = new ArrayList<>();
    }

    @Override
    public Collection<T> getTracks() {
        return tracks;
    }

    @Override
    public void add(T track) {
        tracks.add(track);
    }

    @Override
    public void add(Collection<T> track) {
        tracks.addAll(track);
    }
}
