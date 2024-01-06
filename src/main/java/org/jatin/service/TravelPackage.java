package org.jatin.service;

import org.jatin.exception.TravelPackageFullException;
import org.jatin.model.*;

import java.util.ArrayList;
import java.util.List;

// TravelPackage Class representing a travel package with a name, passenger capacity, itinerary, and list of passengers
public class TravelPackage {
    private String name;
    private int passengerCapacity;
    private List<Destination> itinerary;
    private List<Passenger> passengers;

    public TravelPackage(String name, int passengerCapacity) {
        this.name = name;
        this.passengerCapacity = passengerCapacity;
        this.itinerary = new ArrayList<>();
        this.passengers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public List<Destination> getItinerary() {
        return itinerary;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void addDestination(Destination destination) {
        itinerary.add(destination);
    }

    public void addPassenger(Passenger passenger) throws TravelPackageFullException {
        if (passengers.size() < passengerCapacity) {
            passengers.add(passenger);
        } else {
            throw new TravelPackageFullException("Travel package is at full capacity. Cannot add more passengers.");
        }
    }

    // Method to print the itinerary of the travel package.
    public void printItinerary() {
        System.out.println("Travel Package: " + name);
        for (Destination destination : itinerary) {
            System.out.println("Destination: " + destination.getName());
            for (Activity activity : destination.getActivities()) {
                System.out.println("Activity: " + activity.getName() +
                        ", Cost: " + activity.getCost() +
                        ", Capacity: " + activity.getCapacity() +
                        ", Description: " + activity.getDescription());
            }
        }
    }

    // Method to print the passenger list of the travel package.
    public void printPassengerList() {
        System.out.println("Passenger List for Travel Package: " + name);
        System.out.println("Capacity: " + passengerCapacity);
        System.out.println("Number of Passengers: " + passengers.size());
        for (Passenger passenger : passengers) {
            System.out.println("Passenger: " + passenger.getName() +
                    ", Number: " + passenger.getPassengerNumber());
        }
    }

    // Method to print details of an individual passenger.
    public void printIndividualPassengerDetails(Passenger passenger) {
        System.out.println("Individual Passenger Details");
        System.out.println("Name: " + passenger.getName());
        System.out.println("Number: " + passenger.getPassengerNumber());
        if (passenger instanceof StandardPassenger || passenger instanceof GoldPassenger) {
            System.out.println("Balance: " + ((StandardPassenger) passenger).getBalance());
        }
        System.out.println("Signed Up Activities:");
        for (Activity activity : passenger.getSignedUpActivities()) {
            System.out.println("Activity: " + activity.getName() +
                    ", Destination: " + findDestinationForActivity(activity) +
                    ", Price Paid: " + calculatePricePaid(passenger, activity));
        }
    }

    // Method to find the destination for a given activity.
    private String findDestinationForActivity(Activity activity) {
        for (Destination destination : itinerary) {
            if (destination.getActivities().contains(activity)) {
                return destination.getName();
            }
        }
        return "Destination not found";
    }

    // Method to calculate the price paid by a passenger for a given activity.
    private double calculatePricePaid(Passenger passenger, Activity activity) {
        if (passenger instanceof GoldPassenger) {
            GoldPassenger goldPassenger = (GoldPassenger) passenger;
            return activity.getCost() * 0.9;
        } else if (passenger instanceof StandardPassenger) {
            return activity.getCost();
        } else {
            return 0; // Premium passenger pays nothing
        }
    }

    // Method to print details of available activities.
    public void printAvailableActivities() {
        System.out.println("Available Activities for Travel Package: " + name);
        for (Destination destination : itinerary) {
            for (Activity activity : destination.getActivities()) {
                int availableSpaces = activity.getCapacity() - countPassengersForActivity(activity);
                System.out.println("Activity: " + activity.getName() +
                        ", Destination: " + destination.getName() +
                        ", Available Spaces: " + availableSpaces);
            }
        }
    }

    // Method to count the number of passengers signed up for a given activity.
    private int countPassengersForActivity(Activity activity) {
        int count = 0;
        for (Passenger passenger : passengers) {
            if (passenger.getSignedUpActivities().contains(activity)) {
                count++;
            }
        }
        return count;
    }
}