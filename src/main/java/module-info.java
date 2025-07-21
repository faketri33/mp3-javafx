module org.faketri.mpplayer {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;
    requires mp3agic;
    requires javafx.media;

    opens org.faketri.mpplayer to javafx.fxml;
    exports org.faketri.mpplayer;
    exports org.faketri.mpplayer.controller;
    opens org.faketri.mpplayer.controller to javafx.fxml;
}