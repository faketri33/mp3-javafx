package org.faketri.mpplayer.model;

import java.util.List;

public interface PlayList<T extends Track> {
    List<T> getTracks();
    void add(T track);
    void add(List<T> track);
    void remove(T track);
    T nextTrackFind(T current);
    T previousTrackFind(T current);
}
