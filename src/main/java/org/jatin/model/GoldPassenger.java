package org.jatin.model;


import org.jatin.exception.ActivityFullException;
import org.jatin.exception.InsufficientBalanceException;

// GoldPassenger Class representing a gold passenger with balance and discount
public class GoldPassenger extends Passenger {
    private double balance;
    private static double discountRate = 0.9;

    public GoldPassenger(String name, int passengerNumber, double balance) {
        super(name, passengerNumber);
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    // Overridden method to sign up a gold passenger for an activity with a discount
    @Override
    public void signUpForActivity(Activity activity) throws InsufficientBalanceException, ActivityFullException {
        if (activity.getCapacity()<=signedUpActivities.size()) {
            throw new ActivityFullException("Activity capacity is full for: " + activity.getName());
        }
        double discountedCost = activity.getCost() * (1 - discountRate);

        if (balance < discountedCost) {
            throw new InsufficientBalanceException("Insufficient balance for activity: " + activity.getName());
        }
        balance -= discountedCost;
        signedUpActivities.add(activity);

    }
}
