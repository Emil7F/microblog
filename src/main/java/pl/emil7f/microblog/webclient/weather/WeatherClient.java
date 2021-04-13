package pl.emil7f.microblog.webclient.weather;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.emil7f.microblog.model.WeatherDto;
import pl.emil7f.microblog.webclient.weatherDto.WeatherRootDto;

@Component
public class WeatherClient {

    public static final String URL_ADDRESS = "http://api.openweathermap.org/data/2.5/";
    public static final String API_KEY = "cbadd1e2fac6a5084c2c34b65afbe179";
    private final RestTemplate restTemplate = new RestTemplate();

    public WeatherDto getWeatherForCity(String city) {
        WeatherRootDto weatherRootDto = restTemplate.getForObject(URL_ADDRESS + "weather?q={city}&appid=" + API_KEY
                        + "&units=metric"
                , WeatherRootDto.class, city);


            return mapWeatherDto(weatherRootDto);

    }

    private WeatherDto mapWeatherDto( WeatherRootDto weatherRootDto) {
        WeatherDto weatherDto = new WeatherDto();
        weatherDto.setTemp(weatherRootDto.getMain().getTemp());
        weatherDto.setPressure(weatherRootDto.getMain().getPressure());
        weatherDto.setHumidity(weatherRootDto.getMain().getHumidity());
        weatherDto.setSpeed(weatherRootDto.getWind().getSpeed());
        return weatherDto;
    }


}
