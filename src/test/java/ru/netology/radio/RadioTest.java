package ru.netology.radio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RadioTest {

    @ParameterizedTest
    @CsvSource({"0", "1", "6", "8", "9"})
    public void shouldSetStationManually(int stationNumber) {
        Radio radio = new Radio();

        radio.setCurrentStation(stationNumber);

        int expected = stationNumber;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({"-1000000", "-1", "10", "11", "2000"})
    public void shouldNotSetStationManually(int stationNumber) {
        Radio radio = new Radio();

        int expected = radio.getCurrentStation();
        radio.setCurrentStation(stationNumber);

        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({"0", "1", "4"})
    public void shouldTurnNextStation(int stationNumber) {
        Radio radio = new Radio();
        radio.setCurrentStation(stationNumber);

        radio.nextStation();

        int expected = stationNumber + 1;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTurnFirstStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(9);

        radio.nextStation();

        int expected = 0;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({"1", "6", "9"})
    public void shouldTurnPreviousStation(int stationNumber) {
        Radio radio = new Radio();
        radio.setCurrentStation(stationNumber);

        radio.prevStation();

        int expected = stationNumber - 1;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTurnLastStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(0);

        radio.prevStation();

        int expected = 9;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({"0", "58", "99"})
    public void shouldTurnUpVolume(int volLevel) {
        Radio radio = new Radio();
        radio.setCurrentVolume(volLevel);

        radio.volumeUp();

        int expected = volLevel + 1;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotTurnUpVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(100);

        radio.volumeUp();

        int expected = 100;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({"1", "37", "100"})
    public void shouldTurnDownVolume(int volLevel) {
        Radio radio = new Radio();
        radio.setCurrentVolume(volLevel);

        radio.volumeDown();

        int expected = volLevel - 1;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotTurnDownVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(0);

        radio.volumeDown();

        int expected = 0;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({"-1500", "-1", "101", "1000"})
    public void shouldNotSetRandomVolume(int volLevel) {
        Radio radio = new Radio();
        int expected = radio.getCurrentVolume();

        radio.setCurrentVolume(volLevel);
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }
}
