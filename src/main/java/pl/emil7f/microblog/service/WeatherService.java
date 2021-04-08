package pl.emil7f.microblog.service;


import org.springframework.stereotype.Service;
import pl.emil7f.microblog.model.WeatherDto;
import pl.emil7f.microblog.webclient.weather.WeatherClient;

@Service
public class WeatherService {

    private final WeatherClient weatherClient;

    public WeatherService(WeatherClient weatherClient) {
        this.weatherClient = weatherClient;
    }

    public WeatherDto getWeather(String city){
        return weatherClient.getWeatherForCity(city);
    }
}
