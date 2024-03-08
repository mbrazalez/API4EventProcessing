package com.cep.SimpleEvents;

import java.time.LocalTime;

public class PM10Event extends Event {
    /*public PM10Event(String station, LocalTime timestamp, float value){
       super(station, timestamp, value);
    }*/

    public PM10Event(String station, String timestamp, float value) {
        super(station, parseTimestamp(timestamp), value);
    }

    private static LocalTime parseTimestamp(String timestamp) {
        return LocalTime.parse(timestamp);
    }

    @Override
    public String toString() {
        return "PM10Event [" + this.getValue() + "]";
    }
}
