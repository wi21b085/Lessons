package at.technikum.weatherfx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HelloController {

    @FXML
    private Label wD;

    @FXML
    protected void getData() throws URISyntaxException, IOException, InterruptedException {
        //call the joke with api
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("http://localhost:8080/temp/city/1"))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        String joke = response.body();

        wD.setText(joke);
    }
}