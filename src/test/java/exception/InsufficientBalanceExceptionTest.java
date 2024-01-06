package exception;

import org.jatin.exception.InsufficientBalanceException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InsufficientBalanceExceptionTest {

    @Test
    public void testInsufficientBalanceExceptionMessage() {
        String errorMessage = "Insufficient balance for the activity";
        InsufficientBalanceException exception = new InsufficientBalanceException(errorMessage);

        assertEquals(errorMessage, exception.getMessage());
    }

    @Test(expected = InsufficientBalanceException.class)
    public void testThrowInsufficientBalanceException() throws InsufficientBalanceException {
        throw new InsufficientBalanceException("Testing InsufficientBalanceException");
    }
}
