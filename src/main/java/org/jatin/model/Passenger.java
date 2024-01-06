package org.jatin.model;

import org.jatin.exception.ActivityFullException;
import org.jatin.exception.InsufficientBalanceException;

import java.util.ArrayList;
import java.util.List;

// Base class representing a Passenger
public class Passenger {
    protected String name;
    protected int passengerNumber;
    protected List<Activity> signedUpActivities;

    public Passenger(String name, int passengerNumber) {
        this.name = name;
        this.passengerNumber = passengerNumber;
        this.signedUpActivities = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getPassengerNumber() {
        return passengerNumber;
    }

    public List<Activity> getSignedUpActivities() {
        return signedUpActivities;
    }

    public void signUpForActivity(Activity activity) throws InsufficientBalanceException, ActivityFullException {
        signedUpActivities.add(activity);
    }
}
