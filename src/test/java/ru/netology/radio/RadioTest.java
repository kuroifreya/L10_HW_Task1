package ru.netology.radio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RadioTest {

    Radio customRadio = new Radio(104);

    @Test
    public void shouldSetDefaultStations() {
        Radio radio = new Radio();

        Assertions.assertEquals(9, radio.getLastStation());
    }

    @ParameterizedTest
    @CsvSource({"0", "1", "10", "58", "102", "103"})
    public void shouldSetStationManually(int stationNumber) {
        customRadio.setCurrentStation(stationNumber);

        int expected = stationNumber;
        int actual = customRadio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({"-1000000", "-1", "104", "105", "2000"})
    public void shouldNotSetStationManually(int stationNumber) {

        int expected = customRadio.getCurrentStation();
        customRadio.setCurrentStation(stationNumber);

        int actual = customRadio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({"0", "1", "34", "102"})
    public void shouldTurnNextStation(int stationNumber) {
        customRadio.setCurrentStation(stationNumber);

        customRadio.nextStation();

        int expected = stationNumber + 1;
        int actual = customRadio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTurnFirstStation() {
        customRadio.setCurrentStation(103);

        customRadio.nextStation();

        int expected = 0;
        int actual = customRadio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({"1", "6", "10", "103"})
    public void shouldTurnPreviousStation(int stationNumber) {
        customRadio.setCurrentStation(stationNumber);

        customRadio.prevStation();

        int expected = stationNumber - 1;
        int actual = customRadio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTurnLastStation() {
        customRadio.setCurrentStation(0);

        customRadio.prevStation();

        int expected = 103;
        int actual = customRadio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({"0", "58", "99"})
    public void shouldTurnUpVolume(int volLevel) {
        customRadio.setCurrentVolume(volLevel);

        customRadio.volumeUp();

        int expected = volLevel + 1;
        int actual = customRadio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotTurnUpVolume() {
        customRadio.setCurrentVolume(100);

        customRadio.volumeUp();

        int expected = 100;
        int actual = customRadio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({"1", "37", "100"})
    public void shouldTurnDownVolume(int volLevel) {
        customRadio.setCurrentVolume(volLevel);

        customRadio.volumeDown();

        int expected = volLevel - 1;
        int actual = customRadio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotTurnDownVolume() {
        customRadio.setCurrentVolume(0);

        customRadio.volumeDown();

        int expected = 0;
        int actual = customRadio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({"-1500", "-1", "101", "1000"})
    public void shouldNotSetRandomVolume(int volLevel) {
        int expected = customRadio.getCurrentVolume();

        customRadio.setCurrentVolume(volLevel);
        int actual = customRadio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }
}
