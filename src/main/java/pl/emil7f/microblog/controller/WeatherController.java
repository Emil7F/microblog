package pl.emil7f.microblog.controller;

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
    public WeatherDto getWeather(@PathVariable String city) {
        return weatherService.getWeather(city);
    }
}
