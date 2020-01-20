package com.indeework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

public class TravelTimeProcedureTest {

    //assuming that densityIntervals is sorted and speed is represented as m/s
    private static final TrafficDensityInterval[] trafficDensityIntervals = {
            new TrafficDensityInterval("00:00:00", "02:00:00", 50),
            new TrafficDensityInterval("02:00:00", "04:00:00", 50),
            new TrafficDensityInterval("04:00:00", "05:00:00", 50),
            new TrafficDensityInterval("06:00:00", "07:00:00", 35),
            new TrafficDensityInterval("08:00:00", "09:00:00", 30),
            new TrafficDensityInterval("09:00:00", "10:00:00", 35),
            new TrafficDensityInterval("10:00:00", "11:00:00", 40),
            new TrafficDensityInterval("11:00:00", "12:00:00", 45),
            new TrafficDensityInterval("12:00:00", "15:00:00", 35),
            new TrafficDensityInterval("15:00:00", "16:00:00", 60),
            new TrafficDensityInterval("16:00:00", "18:00:00", 35),
            new TrafficDensityInterval("18:00:00", "19:00:00", 30),
            new TrafficDensityInterval("19:00:00", "20:00:00", 50),
            new TrafficDensityInterval("20:00:00", "22:00:00", 60),
            new TrafficDensityInterval("22:00:00", "23:00:00", 50),
            new TrafficDensityInterval("23:00:00", "00:00:00", 50),
    };

    @Test
    void travelTimeTest() {

        TravelTimeProcedure travelTimeProcedure = new TravelTimeProcedure(trafficDensityIntervals);
        PointOfInterest germany = new PointOfInterest(10.018343, 51.133481, "Germany");
        PointOfInterest switzerland = new PointOfInterest(8.2275124, 46.8181877, "Switzerland");
        PointOfInterest netherlands = new PointOfInterest(4.895168, 52.370216, "Netherlands");
        PointOfInterest france = new PointOfInterest(2.618787, 47.824905, "France");
        PointOfInterest luxembourg = new PointOfInterest(6.131935, 49.611622, "Luxembourg");
        PointOfInterest austria = new PointOfInterest(16.363449, 48.210033, "Austria");


        Assertions.assertEquals(15145, travelTimeProcedure.travelTimeFor(germany, switzerland, LocalTime.parse("06:00:00")));
        Assertions.assertEquals(8116, travelTimeProcedure.travelTimeFor(germany, netherlands, LocalTime.parse("10:15:00")));
        Assertions.assertEquals(15844, travelTimeProcedure.travelTimeFor(germany, france, LocalTime.parse("16:15:00")));
        Assertions.assertEquals(4795, travelTimeProcedure.travelTimeFor(germany, luxembourg, LocalTime.parse("19:00:00")));
        Assertions.assertEquals(14146, travelTimeProcedure.travelTimeFor(germany, austria, LocalTime.parse("11:20:00")));

    }
}
