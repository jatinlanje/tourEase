package model;

import org.jatin.exception.ActivityFullException;
import org.jatin.exception.InsufficientBalanceException;
import org.jatin.model.Activity;
import org.jatin.model.Passenger;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PassengerTest {

    @Test
    public void shouldAddActivityToSignedUpActivities() throws InsufficientBalanceException, ActivityFullException {
        // Arrange
        Passenger jatin = new Passenger("Jatin", 101);
        Activity activity = new Activity("Sightseeing", "Guided tour of landmarks", 50.0, 20);

        // Act
        jatin.signUpForActivity(activity);

        // Assert
        assertTrue(jatin.getSignedUpActivities().contains(activity));
    }
}
