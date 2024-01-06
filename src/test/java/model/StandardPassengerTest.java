package model;

import org.jatin.exception.ActivityFullException;
import org.jatin.exception.InsufficientBalanceException;
import org.jatin.model.Activity;
import org.jatin.model.StandardPassenger;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StandardPassengerTest {

    @Test
    public void signUpForActivity_shouldDeductCostFromBalance() throws InsufficientBalanceException, ActivityFullException {
        // Arrange
        StandardPassenger jatin = new StandardPassenger("Jatin", 201, 100.0);
        Activity activity = new Activity("Hiking", "Nature walk and exploration", 30.0, 15);

        // Act
        jatin.signUpForActivity(activity);

        // Assert
        assertEquals(70.0, jatin.getBalance(), 0.01); // Assuming precision of 0.01 for double comparison
    }
}
