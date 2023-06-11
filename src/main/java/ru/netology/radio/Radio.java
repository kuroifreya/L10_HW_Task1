package ru.netology.radio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Radio {
    private int numberOfStations = 10;
    private int firstStation = 0;
    private int lastStation = numberOfStations - 1;
    private int currentStation = firstStation;
    private int minVolume = 0;
    private int maxVolume = 100;
    private int currentVolume;

    public Radio(int numberOfStations) { //конструктор с одним параметром остается
        this.numberOfStations = numberOfStations;
        lastStation = this.numberOfStations - 1;
    }

    public void setCurrentStation(int stationNumber) { //сеттер для выбора станции остается
        if (stationNumber < firstStation) {
            return;
        }
        if (stationNumber > getLastStation()) {
            return;
        }
        currentStation = stationNumber;
    }

    public void setCurrentVolume(int volume) {
        if (volume > maxVolume) {
            return;
        }
        if (volume < minVolume) {
            return;
        }
        currentVolume = volume;
    }

    public void nextStation() {
        int station = getCurrentStation();
        if (station < getLastStation()) {
            setCurrentStation(station + 1);
        } else {
            setCurrentStation(firstStation);
        }
    }

    public void prevStation() {
        int station = getCurrentStation();
        if (station > firstStation) {
            setCurrentStation(station - 1);
        } else {
            setCurrentStation(getLastStation());
        }
    }

    public void volumeUp() {
        int vol = getCurrentVolume();
        if (vol < maxVolume) {
            setCurrentVolume(vol + 1);
        }
    }

    public void volumeDown() {
        int vol = getCurrentVolume();
        if (vol > minVolume) {
            setCurrentVolume(vol - 1);
        }
    }
}
