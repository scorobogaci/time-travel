package com.indeework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class POITest {

    @ParameterizedTest
    @MethodSource("pointsOfInterestProvider")
    void distanceCalculationTest(final String scenario, final PointOfInterest startPOI, final PointOfInterest destinationPOI, final double expectedDistance) {
        Assertions.assertEquals(expectedDistance, startPOI.distanceTo(destinationPOI));
    }

    public static Stream<Arguments> pointsOfInterestProvider() {

        return Stream.of(
                Arguments.of(
                        "Germany - Switzerland",
                        new PointOfInterest(10.018343, 51.133481, "Germany"),
                        new PointOfInterest(8.2275124, 46.8181877, "Switzerland"),
                        497.8378476453514D
                ),
                Arguments.of(
                        "Germany - Netherlands",
                        new PointOfInterest(10.018343, 51.133481, "Germany"),
                        new PointOfInterest(4.895168, 52.370216, "Netherlands"),
                        378.84837695492536D
                ),
                Arguments.of(
                        "Germany - France",
                        new PointOfInterest(10.018343, 51.133481, "Germany"),
                        new PointOfInterest(2.618787, 47.824905, "France"),
                        649.1845036015062D
                ),
                Arguments.of(
                        "Germany - Luxembourg",
                        new PointOfInterest(10.018343, 51.133481, "Germany"),
                        new PointOfInterest(6.131935, 49.611622, "Luxembourg"),
                        323.7232867296599D
                ),
                Arguments.of(
                        "Germany - Austria",
                        new PointOfInterest(10.018343, 51.133481, "Germany"),
                        new PointOfInterest(16.363449, 48.210033, "Austria"),
                        560.8075284515306D
                )
        );
    }
}