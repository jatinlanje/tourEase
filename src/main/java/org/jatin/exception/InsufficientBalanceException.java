package org.jatin.exception;
/*
InsufficientBalanceException is a custom exception class to represent an exception
that is thrown when a passenger attempts to sign up for an activity with an insufficient balance.
*/
public class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}
