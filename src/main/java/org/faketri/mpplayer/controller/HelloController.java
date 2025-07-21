package org.faketri.mpplayer.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import org.faketri.mpplayer.core.TrackFactory;
import org.faketri.mpplayer.model.MyMp3Track;

import java.io.File;


public class HelloController {
    private final TrackFactory trackFactory = new TrackFactory();

    @FXML
    private ListView<MyMp3Track> trackList;

    @FXML
    public void initialize() {
        trackFactory.getTrackStorage().add(new File("C:\\Users\\faket\\Downloads\\IOWA - Мальчик (zaycev.net).mp3"));
        trackFactory.getAudioPlayer().getPlayList().getTracks().forEach(System.out::println);

        ObservableList<MyMp3Track> observableTracks = FXCollections.observableArrayList(trackFactory.getAudioPlayer().getPlayList().getTracks());
        System.out.println(observableTracks);
        trackList.setItems(FXCollections.observableArrayList(observableTracks));

        trackList.setCellFactory(listView -> new ListCell<>() {
            @Override
            protected void updateItem(MyMp3Track item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item.getTitle());
                }
            }
        });
    }

    public void onPrevious(ActionEvent actionEvent) {
    }

    public void onPlayPause(ActionEvent actionEvent) {
    }

    public void onNext(ActionEvent actionEvent) {
    }
}