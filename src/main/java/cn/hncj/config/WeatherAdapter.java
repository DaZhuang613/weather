package cn.hncj.config;

import cn.hncj.service.Impl.GaoDeWeatherService;
import cn.hncj.service.Impl.HeFengWeatherService;
import cn.hncj.pojo.BaseWeather;
import cn.hncj.pojo.Weather;
import cn.hncj.pojo.WeatherFuture;
import cn.hncj.service.WeatherService;

import java.util.List;
import java.util.Objects;

public class WeatherAdapter implements WeatherService {

    private final WeatherService weatherService;

    public WeatherAdapter(){
        Integer weatherSourceType = WeatherConfig.weatherSourceType;
        if (Objects.equals(0,weatherSourceType)){
            weatherService = new GaoDeWeatherService();
        }else {
            weatherService = new HeFengWeatherService();
        }
    }


    @Override
    public List<Weather> getWeather(String address, String city) throws Exception {

        return weatherService.getWeather(address,city);
    }

    @Override
    public BaseWeather getWeatherNow(String address, String city) throws Exception {
        return weatherService.getWeatherNow(address,city);
    }

    @Override
    public List<WeatherFuture> getWeatherFuture(String address, String city) throws Exception {
        return weatherService.getWeatherFuture(address,city);
    }

    @Override
    public String getWeatherType(Integer type) {
        return weatherService.getWeatherType(type);
    }

    @Override
    public String getCityCode(String address, String city) throws Exception {
        return weatherService.getCityCode(address,city);
    }
}
