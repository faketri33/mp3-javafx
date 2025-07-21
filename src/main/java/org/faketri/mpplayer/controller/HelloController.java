package org.faketri.mpplayer.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;


public class HelloController {
    @FXML private StackPane rootPane;
    @FXML private ImageView albumArt;
    @FXML private ImageView backgroundImage;

    @FXML
    protected void onHelloButtonClick() {
        backgroundImage.fitWidthProperty().bind(rootPane.widthProperty());
        backgroundImage.fitHeightProperty().bind(rootPane.heightProperty());

        albumArt.fitWidthProperty().bind(rootPane.widthProperty().multiply(0.3));
        albumArt.fitHeightProperty().bind(rootPane.heightProperty().multiply(0.3));
    }

    public void onPrevious(ActionEvent actionEvent) {
    }

    public void onPlayPause(ActionEvent actionEvent) {
    }

    public void onNext(ActionEvent actionEvent) {
    }
}