package org.campusmolndal.demo;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

class WeatherAPITest {
    private WeatherService weatherAPIMock;
    private String mockResponse;


    @BeforeEach
    void setUp() {
        weatherAPIMock = Mockito.mock(WeatherService.class);
        mockResponse = "{\"Temperature\": 20.59, \"WindSpeed\": 5.14, \"Clouds\": 90, \"City\": \"Göteborg\", \"Country\": \"Sweden\"}";
        JSONObject jsonObject = new JSONObject(mockResponse);
        String country = jsonObject.getString("Country");
        String city = jsonObject.getString("City");
        int clouds = jsonObject.getInt("Clouds");
        double temperature = jsonObject.getDouble("Temperature");
        double windSpeed = jsonObject.getDouble("WindSpeed");
        Weather mockWeather = new Weather(country, city, clouds, temperature, windSpeed);
        when(weatherAPIMock.showWeather("Göteborg")).thenReturn(mockWeather);
        when(weatherAPIMock.showWeather("")).thenReturn(null);
        when(weatherAPIMock.showWeather(null)).thenReturn(null);

    }


    @Test
    public void testGetAllInfoWeather() {
        // Arrange
        String expectedWeather = "{\"Temperature\" = 20.59, \"WindSpeed\" = 5.14, \"Clouds\" = \"90\", \"City\" = \"Göteborg\", \"Country\" = \"Sweden\"}";

        // Act
        String actualWeather = weatherAPIMock.showWeather("Göteborg").fromJSON();

        // Assert
        assertEquals(expectedWeather, actualWeather);
    }

    @Test
    public void testIfEmptyCity() {

        // Act
        Weather actualWeather = weatherAPIMock.showWeather("");

        // Assert
        assertNull(actualWeather);
    }

    @Test
    public void testInvalidCity() {

        // Act
        Weather actualWeather = weatherAPIMock.showWeather("");

        // Assert
        assertNull(actualWeather);
    }

    @Test
    public void testIfCityNull() {
        Weather actualWeather = weatherAPIMock.showWeather(null);
        assertNull(actualWeather);
    }

    @Test
    public void testOnlyCity() {
        // Arrange
        String expectedCity = "Göteborg";

        // Act
        String actualCity = weatherAPIMock.showWeather("Göteborg").getCity();

        // Assert
        assertEquals(expectedCity, actualCity);
    }


    @Test
    public void testGetTemperature() {
        // Arrange
        double expectedTemperature = 20.59;

        // Act
        double actualTemperature = weatherAPIMock.showWeather("Göteborg").getTemperature();

        // Assert
        assertEquals(expectedTemperature, actualTemperature);
    }

    @Test
    public void testGetClouds() {
        // Arrange
        int expectedClouds = 90;

        // Act
        int actualClouds = weatherAPIMock.showWeather("Göteborg").getClouds();

        // Assert
        assertEquals(expectedClouds, actualClouds);
    }

    @Test
    public void testGetWindSpeed() {
        // Arrange
        double expectedWindSpeed = 5.14;

        // Act
        double actualWindSpeed = weatherAPIMock.showWeather("Göteborg").getWindSpeed();

        // Assert
        assertEquals(expectedWindSpeed, actualWindSpeed);
    }
}