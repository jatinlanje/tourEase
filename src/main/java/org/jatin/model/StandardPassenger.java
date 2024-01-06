package org.jatin.model;

import org.jatin.exception.ActivityFullException;
import org.jatin.exception.InsufficientBalanceException;

// StandardPassenger Class representing a standard passenger with balance
public class StandardPassenger extends Passenger {
    private double balance;

    public StandardPassenger(String name, int passengerNumber, double balance) {
        super(name, passengerNumber);
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    // Overridden method to sign up a standard passenger for an activity
    @Override
    public void signUpForActivity(Activity activity) throws InsufficientBalanceException, ActivityFullException {
        if (activity.getCapacity()<=signedUpActivities.size()) {
            throw new ActivityFullException("Activity capacity is full for: " + activity.getName());
        }
        double activityCost = activity.getCost();

        if (balance < activityCost) {
            throw new InsufficientBalanceException("Insufficient balance for activity: " + activity.getName());
        }
        balance -= activity.getCost();
        signedUpActivities.add(activity);
    }
}
