package com.example.dimas.omondesign;

/**
 * Created by Dimas on 03/08/2017.
 */

public class Slave {
    private String name;
    private int temp;
    private int soilMoist;
    private int humidity;
    private int thumbnail;

    public Slave() {
    }

    public Slave(String name, int temp, int soilMoist, int humidity) {
        this.name = name;
        this.temp = temp;
        this.soilMoist = soilMoist;
        this.humidity = humidity;
        //this.thumbnail= thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp= temp;
    }

    public int getSoilMoist() {
        return soilMoist;
    }

    public void setSoilMoist(int soilMoist) {
        this.soilMoist= soilMoist;
    }
    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }
    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
