package org.faketri.mpplayer.core;

import org.faketri.mpplayer.events.EventDispatcher;
import org.faketri.mpplayer.model.Track;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class LocalTrackStorageTest {

    private LocalTrackStorage<Track> storage;
    private EventDispatcher mockDispatcher;

    @BeforeEach
    public void setup() {
        mockDispatcher = mock(EventDispatcher.class);
        storage = new LocalTrackStorage<>(mockDispatcher);
    }

    @Test
    public void testAddSingleMp3File() throws IOException {
        File file = File.createTempFile("track_", ".mp3");
        file.deleteOnExit();

        storage.add(file);

        List<File> tracks = storage.getTrackList();
        assertEquals(1, tracks.size());
        assertEquals(file, tracks.get(0));

        verify(mockDispatcher).post(any());
        verify(mockDispatcher).dispatch();
    }

    @Test
    public void testAddNullFile() {
        storage.add(null);
        assertTrue(storage.getTrackList().isEmpty());

        verify(mockDispatcher, never()).post(any());
        verify(mockDispatcher, never()).dispatch();
    }

    @Test
    public void testRemoveFile() throws IOException {
        File file = File.createTempFile("remove_", ".mp3");
        file.deleteOnExit();

        storage.add(file);
        assertTrue(storage.getTrackList().contains(file));

        storage.remove(file);
        assertFalse(storage.getTrackList().contains(file));
    }

    @Test
    public void testAddDirectoryWithMp3Files() throws IOException {
        File dir = new File(System.getProperty("java.io.tmpdir"), "test-mp3-dir");
        dir.mkdir();
        dir.deleteOnExit();

        File mp3File = new File(dir, "song.mp3");
        mp3File.createNewFile();
        mp3File.deleteOnExit();

        File txtFile = new File(dir, "note.txt");
        txtFile.createNewFile();
        txtFile.deleteOnExit();

        storage.add(dir);
        List<File> tracks = storage.getTrackList();

        assertEquals(1, tracks.size());
        assertEquals(mp3File.getAbsolutePath(), tracks.get(0).getAbsolutePath());
    }

    @Test
    public void testRemoveNullDoesNothing() {
        storage.remove(null);
        assertTrue(storage.getTrackList().isEmpty());
    }
}
