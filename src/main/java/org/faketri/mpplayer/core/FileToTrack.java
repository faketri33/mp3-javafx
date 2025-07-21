package org.faketri.mpplayer.core;

import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;
import org.faketri.mpplayer.model.MyMp3Track;
import org.faketri.mpplayer.model.Track;
import org.faketri.mpplayer.model.TrackStorage;

import java.io.File;
import java.io.IOException;

public class FileToTrack {
    public static MyMp3Track format(File file){
        if (!file.isFile())
            return null;
        MyMp3Track track = new MyMp3Track();
        try {
            Mp3File mp3file = new Mp3File(file.getPath());
            ID3v1 id3v1 = mp3file.getId3v1Tag();

            track.setTitle(file.getName());

        }
        catch (InvalidDataException ex){

        }
        catch (UnsupportedTagException ex){

        }
        catch (IOException e){

        }

        return track;
    }
}
