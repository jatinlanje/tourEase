package exception;

import org.jatin.exception.ActivityFullException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ActivityFullExceptionTest {

    @Test
    public void testActivityFullExceptionMessage() {
        String errorMessage = "Activity capacity is full";
        ActivityFullException exception = new ActivityFullException(errorMessage);

        assertEquals(errorMessage, exception.getMessage());
    }

    @Test(expected = ActivityFullException.class)
    public void testThrowActivityFullException() throws ActivityFullException {
        throw new ActivityFullException("Testing ActivityFullException");
    }
}
