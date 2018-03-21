package weather;

import java.util.Date;

public class Task {
    public String getCity() {
        return city;
    }

    public Date getDate() {
        return date;
    }

    public Integer getWeather() {
        return weather;
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
