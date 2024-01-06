package org.jatin.exception;
/*
TravelPackageFullException is a custom exception class to represent an exception
that is thrown when a Travel package is full.
*/
public class TravelPackageFullException extends Exception{
    public TravelPackageFullException(String message) {
        super(message);
    }
}
