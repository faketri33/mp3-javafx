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
        trackFactory.getTrackStorage().add(new File("C:\\Users\\faket\\Downloads\\Дмитрий Гревцев & Алексей Кракин - Танцуем В Стиле Девяностых (Original Mix).mp3"));

        ObservableList<MyMp3Track> observableTracks = FXCollections.observableArrayList(trackFactory.getAudioPlayer().getPlayList().getTracks());
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

        trackList.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                trackFactory.getAudioPlayer().setCurrentTrack(newVal);
            }
        });
    }

    public void onPrevious(ActionEvent actionEvent) {
    }

    public void onPlayPause(ActionEvent actionEvent) {
        trackFactory.getAudioPlayer().play();
    }

    public void onNext(ActionEvent actionEvent) {
    }
}