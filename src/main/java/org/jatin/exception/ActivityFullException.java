package org.jatin.exception;
/*
ActivityFullException is a custom exception class to represent an exception
that is thrown when an Activity package is full.
*/
public class ActivityFullException extends Exception {
    public ActivityFullException(String message) {
        super(message);
    }
}