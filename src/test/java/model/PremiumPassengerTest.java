package model;

import org.jatin.exception.ActivityFullException;
import org.jatin.model.Activity;
import org.jatin.model.PremiumPassenger;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PremiumPassengerTest {

    @Test
    public void shouldAddActivityToSignedUpActivities() throws ActivityFullException {
        // Arrange
        PremiumPassenger jatin = new PremiumPassenger("Jatin", 203);
        Activity activity = new Activity("Shopping", "Visit local markets", 20.0, 30);

        // Act
        jatin.signUpForActivity(activity);

        // Assert
        assertTrue(jatin.getSignedUpActivities().contains(activity));
    }
}
