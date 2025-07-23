package org.faketri.mpplayer.model;

import java.io.File;
import java.util.List;

public interface TrackStorage<T extends Track> {
    void add(File file);

    void remove(File name);

    List<File> getTrackList();
}
