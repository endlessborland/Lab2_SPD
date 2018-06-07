package ru.mirea.weatherservice;

import java.util.Date;

public class Task {

    public final int getID() {
        return this.id;
    }

    public final String getCity() {
        return this.city;
    }

    public final Date getDate() {
        return this.date;
    }

    public final Integer getWeather() {
        return this.weather;
    }

    private String city;
    private Date date;
    private Integer weather;
    private int id;

    public Task(int id) {
        this.id = id;
        this.weather = null;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public void setWeather(Integer weather) {
        this.weather = weather;
    }
}