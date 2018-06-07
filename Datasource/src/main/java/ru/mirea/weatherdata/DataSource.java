package ru.mirea.weatherdata;

import ru.mirea.weatherapi.DataSourceAPI;

import java.util.Date;
import java.util.Random;

import static java.lang.Math.abs;

public class DataSource implements DataSourceAPI {

    public boolean connectionAlive;

    Random r;

    @Override
    public void init() {
        r = new Random();
        r.setSeed(0);
        connectionAlive = true;
    }

    @Override
    public String fetchWeather(String location, Date t) {
        String result = "";

        int i = (location + String.valueOf(t)).hashCode() % 4;

        switch (abs(i)) {
            case 0: result = "Sunny " + (Math.abs(r.nextInt()) % 20 + 10) + " degrees"; break;
            case 1: result = "Cloudy " + (Math.abs(r.nextInt()) % 15 + 10) + " degrees"; break;
            case 2: result = "Rain " + (Math.abs(r.nextInt()) % 15 + 10) + " degrees"; break;
            case 3: result = "Snow -" + (Math.abs(r.nextInt()) % 25 + 5) + " degrees"; break;
        }
        return result;
    }

    @Override
    public void exit() {
        connectionAlive = false;

    }
}
