package ru.netology.radio;

public class Radio {
    private int currentStation;
    private int currentVolume;

    public int getCurrentStation() {
        return currentStation;
    }

    public void setCurrentStation(int stationNumber) {
        if (stationNumber < 0) {
            return;
        }
        if (stationNumber > 9) {
            return;
        }
        currentStation = stationNumber;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(int volume) {
        if (volume > 100) {
            return;
        }
        if (volume < 0) {
            return;
        }
        currentVolume = volume;
    }

    public void nextStation() {
        int station = getCurrentStation();
        if (station < 9) {
            setCurrentStation(station + 1);
        } else {
            setCurrentStation(0);
        }
    }

    public void prevStation() {
        int station = getCurrentStation();
        if (station > 0) {
            setCurrentStation(station - 1);
        } else {
            setCurrentStation(9);
        }
    }

    public void volumeUp() {
        int vol = getCurrentVolume();
        if (vol < 100) {
            setCurrentVolume(vol + 1);
        }
    }

    public void volumeDown() {
        int vol = getCurrentVolume();
        if (vol > 0) {
            setCurrentVolume(vol - 1);
        }
    }
}
