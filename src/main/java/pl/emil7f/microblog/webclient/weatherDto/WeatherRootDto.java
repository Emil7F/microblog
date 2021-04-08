package pl.emil7f.microblog.webclient.weatherDto;

public class WeatherRootDto {

    private WeatherMainDto main;
    private WeatherWindDto wind;

    public WeatherMainDto getMain() {
        return main;
    }

    public WeatherWindDto getWind() {
        return wind;
    }
}
