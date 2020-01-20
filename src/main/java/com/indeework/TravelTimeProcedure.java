package com.indeework;

import java.time.LocalTime;

public class TravelTimeProcedure {

    private int index = 0;

    private final TrafficDensityInterval[] trafficDensityIntervals;

    public TravelTimeProcedure(final TrafficDensityInterval[] trafficDensityIntervals) {
        this.trafficDensityIntervals = trafficDensityIntervals;
    }


    public long travelTimeFor(final PointOfInterest startPOI, final PointOfInterest destinationPOI, final LocalTime departureTime) {

        final double totalDistance = startPOI.distanceTo(destinationPOI) * 1000;

        TrafficDensityInterval densityInterval = findIntervalFor(departureTime);

        double speed = densityInterval.getSpeed();
        long endTimeForInterval = densityInterval.getEndTime().toSecondOfDay();

        final long startTime = departureTime.toSecondOfDay();

        long currentTime = startTime;
        double distance = totalDistance;
        double eta = currentTime + (distance / speed);

        while (eta > endTimeForInterval) {
            distance = distance - speed * (endTimeForInterval - currentTime);
            speed = trafficDensityIntervals[index].getSpeed();
            currentTime = endTimeForInterval;
            endTimeForInterval = trafficDensityIntervals[index].getEndTime().toSecondOfDay();
            eta = currentTime + (distance / speed);
            trackIndex();
        }

        return (long) (eta - startTime);

    }

    private void trackIndex() {
        if (index == trafficDensityIntervals.length - 1) {
            index = 0;
        } else {
            index++;
        }
    }

    private TrafficDensityInterval findIntervalFor(final LocalTime departureTime) {
        for (TrafficDensityInterval interval : trafficDensityIntervals) {
            trackIndex();
            if (departureTime.compareTo(interval.getStartTime()) >= 0 && departureTime.compareTo(interval.getEndTime()) < 0) {
                return interval;
            }
        }
        return null;
    }


}
