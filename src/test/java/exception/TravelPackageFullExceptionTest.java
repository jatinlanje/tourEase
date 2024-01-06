package exception;

import org.jatin.exception.TravelPackageFullException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TravelPackageFullExceptionTest {

    @Test
    public void testTravelPackageFullExceptionMessage() {
        String errorMessage = "Travel package is full";
        TravelPackageFullException exception = new TravelPackageFullException(errorMessage);

        assertEquals(errorMessage, exception.getMessage());
    }

    @Test(expected = TravelPackageFullException.class)
    public void testThrowTravelPackageFullException() throws TravelPackageFullException {
        throw new TravelPackageFullException("Testing TravelPackageFullException");
    }
}
