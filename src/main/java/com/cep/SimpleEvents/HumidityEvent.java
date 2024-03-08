package com.cep.SimpleEvents;

import java.time.LocalTime;

public class HumidityEvent extends Event {
    public HumidityEvent(String station, LocalTime timestamp, float value){
       super(station, timestamp, value);
    }

    @Override
    public String toString() {
        return "HumidityEvent [" + this.getValue() + "]";
    }
}
