package org.faketri.mpplayer.core;

import org.faketri.mpplayer.events.EventDispatcher;
import org.faketri.mpplayer.events.EventListener;
import org.faketri.mpplayer.events.StorageUpdateEvent;
import org.faketri.mpplayer.model.Track;
import org.faketri.mpplayer.model.TrackStorage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class LocalTrackStorage<T extends Track> implements TrackStorage<T> {
    private final List<File> dirList;
    private final List<File> trackList;
    private final EventDispatcher eventDispatcher;

    public LocalTrackStorage(EventDispatcher eventDispatcher) {
        this.eventDispatcher = eventDispatcher;
        dirList = new ArrayList<>();
        trackList = new ArrayList<>();
    }

    @Override
    public void add(File file) {
        if (file == null)
            return;

        eventDispatcher.post(new StorageUpdateEvent());


        if (file.isFile()) {
            trackList.add(file);
            eventDispatcher.dispatch();
            return;
        }

        dirList.add(file);
        File[] files = getAllFilesMp3(file);
        for (File f : files) add(f);
    }

    @Override
    public void remove(File name) {
        if (name == null)
            return;

        if (name.isFile()) {
            trackList.remove(name);
            return;
        }

        dirList.remove(name);
        File[] files = getAllFilesMp3(name);
        for (File f : files) remove(f);

    }

    private File[] getAllFilesMp3(File dir){
        return dir.listFiles(pathname -> pathname.getName().toLowerCase().endsWith(".mp3"));
    }

    public List<File> getTrackList() {
        return trackList;
    }
}
