package org.faketri.mpplayer.exception;

public class TrackNotFound extends RuntimeException{
    @Override
    public String getMessage() {
        return "Песня не найдена";
    }
}
