package model;

import org.jatin.exception.ActivityFullException;
import org.jatin.exception.InsufficientBalanceException;
import org.jatin.model.Activity;
import org.jatin.model.GoldPassenger;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GoldPassengerTest {

    @Test
    public void shouldApplyFixedDiscountAndDeductCostFromBalance() throws InsufficientBalanceException, ActivityFullException {
        // Arrange
        GoldPassenger jatin = new GoldPassenger("Jatin", 202, 150.0);
        Activity activity = new Activity("Museum Visit", "Explore local history", 40.0, 25);

        // Act
        jatin.signUpForActivity(activity);

        // Assert
        assertEquals(146.0, jatin.getBalance(), 0.01);
        assertTrue(jatin.getSignedUpActivities().contains(activity));
    }
}
