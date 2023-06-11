package ru.netology.radio;

public class Radio {
    private int numberOfStations = 10;
    private int firstStation = 0;
    private int lastStation = numberOfStations - 1;
    private int currentStation = firstStation;
    private int currentVolume;
    private int minVolume = 0;
    private int maxVolume = 100;

    public Radio(int numberOfStations) { //конструктор с одним параметром, принимающим желаемое количество радиостанций и сохраняющим это значение у себя в поле
        this.numberOfStations = numberOfStations;
        lastStation = this.numberOfStations - 1;
    }

    public Radio() { //конструктор без параметров, оставляет кол-во станций по умолчанию (не поняла, зачем он нужен, ведь поля уже проинициализированы этими значениями)
    }

    public int getLastStation() {
        return lastStation;
    }

    public int getCurrentStation() {
        return currentStation;
    }

    public void setCurrentStation(int stationNumber) {
        if (stationNumber < firstStation) {
            return;
        }
        if (stationNumber > getLastStation()) {
            return;
        }
        currentStation = stationNumber;
    }

    public int getCurrentVolume() {
        return currentVolume;
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
