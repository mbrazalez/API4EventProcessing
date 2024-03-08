package com.cep.SimpleEvents;

import java.time.LocalTime;

public class WindSpeedEvent extends Event{
    public WindSpeedEvent(String station, LocalTime timestamp, float value){
        super(station, timestamp, value);
    }

    @Override
    public String toString() {
        return "WindSpeedEvent [" + this.getValue() + "]";
    }
}
