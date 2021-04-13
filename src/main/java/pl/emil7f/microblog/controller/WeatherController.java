package pl.emil7f.microblog.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.emil7f.microblog.model.WeatherDto;
import pl.emil7f.microblog.service.WeatherService;

@RestController
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/weather/{city}")
    public ResponseEntity<WeatherDto> getWeather(@PathVariable String city) {
        WeatherDto  weather = weatherService.getWeather(city);
        if(weather.getHumidity() == 0){
         return    ResponseEntity.status(404).body(weather);
        }
        return   ResponseEntity.status(200).body(weather);
    }
}
