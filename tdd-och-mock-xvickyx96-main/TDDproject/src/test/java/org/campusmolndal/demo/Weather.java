package org.campusmolndal.demo;

public class Weather {
    private double temperature;
    private double windSpeed;
    private int clouds;
    private String city;
    private String country;

    public Weather(String country, String city, int clouds, double temperature, double windSpeed) {
        this.country = country;
        this.city = city;
        this.clouds = clouds;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public int getClouds() {
        return clouds;
    }

    public void setClouds(int clouds) {
        this.clouds = clouds;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    @Override
    public String toString() {
        return "Temperature = " + temperature + ", WindSpeed = " + windSpeed + ", Clouds = " + clouds + ", City = " + city + ", Country = " + country;
    }

    public String fromJSON() {
        String json = "{";
        json += "\"Temperature\" = " + temperature + ", ";
        json += "\"WindSpeed\" = " + windSpeed + ", ";
        json += "\"Clouds\" = \"" + clouds + "\", ";
        json += "\"City\" = \"" + city + "\", ";
        json += "\"Country\" = \"" + country + "\"";
        json += "}";
        return json;
    }

}
