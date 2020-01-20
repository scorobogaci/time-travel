package com.indeework;

public class PointOfInterest {

    private static final double EARTH_EQUATORIAL_RADIUS = 6378.1370D;
    private static final double CONVERT_DEGREES_TO_RADIANS = Math.PI / 180D;

    final private double longitude;
    final private double latitude;
    final private String name;

    public PointOfInterest(final double longitude, final double latitude, final String name) {
        this.longitude = longitude * CONVERT_DEGREES_TO_RADIANS;
        this.latitude = latitude * CONVERT_DEGREES_TO_RADIANS;
        this.name = name;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public String getName() {
        return name;
    }

    public double distanceTo(final PointOfInterest pointOfInterest) {

        double deltaLongitude = (pointOfInterest.getLongitude() - this.getLongitude());
        double deltaLatitude = (pointOfInterest.getLatitude() - this.getLatitude());
        double a = Math.pow(Math.sin(deltaLatitude / 2D), 2D) +
                Math.cos(this.getLatitude()) * Math.cos(pointOfInterest.getLatitude()) * Math.pow(Math.sin(deltaLongitude / 2D), 2D);
        return EARTH_EQUATORIAL_RADIUS * 2D * Math.atan2(Math.sqrt(a), Math.sqrt(1D - a));
    }
}
