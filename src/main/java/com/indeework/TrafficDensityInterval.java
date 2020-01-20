package com.indeework;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TrafficDensityInterval {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ISO_LOCAL_TIME;

    private final LocalTime startTime;
    private final LocalTime endTime;
    private final double speed;

    public TrafficDensityInterval(final String startTime, String endTime, final double speed) {
        this.startTime = LocalTime.parse(startTime, DATE_TIME_FORMATTER);
        this.endTime = LocalTime.parse(endTime, DATE_TIME_FORMATTER);
        this.speed = speed;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public double getSpeed() {
        return speed;
    }
}
