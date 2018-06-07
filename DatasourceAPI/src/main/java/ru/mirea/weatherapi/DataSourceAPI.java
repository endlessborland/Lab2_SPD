package ru.mirea.weatherapi;

import java.util.Date;

public interface DataSourceAPI {
    public void init();
    public String fetchWeather(String location, Date t);
    public void exit();
}
