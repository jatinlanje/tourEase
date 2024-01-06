package service;

import org.jatin.exception.TravelPackageFullException;
import org.jatin.model.Destination;
import org.jatin.model.Passenger;
import org.jatin.service.TravelPackage;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TravelPackageTest {

    @Test
    public void shouldAddDestinationToItinerary() {
        // Arrange
        TravelPackage europe = new TravelPackage("Euro Tour", 50);
        Destination paris = new Destination("Paris");

        // Act
        europe.addDestination(paris);

        // Assert
        assertTrue(europe.getItinerary().contains(paris));
    }

    @Test
    public void shouldAddPassengerToPassengersList() throws TravelPackageFullException {
        // Arrange
        TravelPackage europe = new TravelPackage("Euro Tour", 50);
        Passenger jatin = new Passenger("Jatin", 101);

        // Act
        europe.addPassenger(jatin);

        // Assert
        assertTrue(europe.getPassengers().contains(jatin));
    }
}
