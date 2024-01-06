package org.jatin.model;

import org.jatin.exception.ActivityFullException;

// PremiumPassenger Class representing a premium passenger
public class PremiumPassenger extends Passenger {
    public PremiumPassenger(String name, int passengerNumber) {
        super(name, passengerNumber);
    }

    // Overridden method to sign up a premium passenger for an activity (free)
    @Override
    public void signUpForActivity(Activity activity) throws ActivityFullException {
        if (activity.getCapacity()<=signedUpActivities.size()) {
            throw new ActivityFullException("Activity capacity is full for: " + activity.getName());
        }
        signedUpActivities.add(activity);
    }
}
