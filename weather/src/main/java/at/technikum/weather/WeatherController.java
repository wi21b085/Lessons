package at.technikum.weather;

import org.springframework.web.bind.annotation.*;

@RestController
public class WeatherController {

    /**
     * This endpoint returns the latest temperature of the city.
     */
    @GetMapping("/temp/city/{name}")
    public double getTemp(@PathVariable String name) {
        //placeholder
        return 0.0;
    }

    /**
     * This endpoint receives new data by weather stations.
     */
    @PostMapping("/temp/send/{city}/{temp}")
    public void addTemp(@PathVariable String city, @PathVariable double temp) {
        //placeholder
    }

    /**
     * This endpoint updates data of a city sent by a weather station.
     */
    @PutMapping("/temp/update/{city}/{temp}")
    public void updateTemp(@PathVariable String city, @PathVariable double temp) {
        //placeholder
    }
}
