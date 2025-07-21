package org.faketri.mpplayer.model;

import java.util.Collection;

public interface PlayList<T extends Track> {
    Collection<T> getTracks();
    void add(T track);
    void add(Collection<T> track);
}
