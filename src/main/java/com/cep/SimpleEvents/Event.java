package com.cep.SimpleEvents;

import java.time.LocalTime;

public class Event {
    private String  station;
    private LocalTime timestamp;
    private float value;

    public Event(String station, LocalTime timestamp, float value){
        this.station = station;
        this.timestamp = timestamp;
        this.value = value;
    }

    public String getStation() { return this.station; }
    public LocalTime getTimestamp() {
        return timestamp;
    }
    public float getValue() {
        return value;
    }
}
