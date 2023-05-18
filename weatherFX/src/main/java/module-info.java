module at.technikum.weatherfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires java.net.http;

    opens at.technikum.weatherfx to javafx.fxml;
    exports at.technikum.weatherfx;
}