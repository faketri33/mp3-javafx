package org.faketri.mpplayer.core;

import org.faketri.mpplayer.exception.TrackNotFound;
import org.faketri.mpplayer.model.MyMp3Track;

import java.io.File;

public class FileToTrack {
    public static MyMp3Track format(File file) {
        if (!file.isFile() | !file.exists())
            throw new TrackNotFound();

        MyMp3Track track = new MyMp3Track();

        track.setTitle(file.getName());
        track.setPath(file.toURI().toString());

        return track;
    }
}
