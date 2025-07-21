package org.faketri.mpplayer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.faketri.mpplayer.core.ArrayPlayList;
import org.faketri.mpplayer.core.LocalTrackStorage;
import org.faketri.mpplayer.core.MyAudioPlayer;
import org.faketri.mpplayer.core.TrackFactory;
import org.faketri.mpplayer.events.EventDispatcher;
import org.faketri.mpplayer.model.*;

import java.io.File;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        EventDispatcher eventDispatcher = new EventDispatcher();

        PlayList<MyMp3Track> playList = new ArrayPlayList<>();
        AudioPlayer<MyMp3Track> audioPlayer = new MyAudioPlayer<>(playList);
        TrackStorage<MyMp3Track> trackStorage = new LocalTrackStorage<>(eventDispatcher);
        TrackFactory trackFactory = new TrackFactory(trackStorage, audioPlayer, eventDispatcher);

        trackFactory.getTrackStorage().add(new File("C:\\Users\\faket\\Downloads\\IOWA - Мальчик (zaycev.net).mp3"));
        trackFactory.getAudioPlayer().getPlayList().getTracks().forEach(System.out::println);

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}