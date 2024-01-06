package org.jatin;

import org.jatin.exception.ActivityFullException;
import org.jatin.exception.InsufficientBalanceException;
import org.jatin.exception.TravelPackageFullException;
import org.jatin.model.*;
import org.jatin.service.TravelPackage;

// Main class representing the Travel Agency System
public class TravelAgencySystem {
    public static void main(String[] args) throws InsufficientBalanceException, TravelPackageFullException, ActivityFullException {

        // Create travel package
        TravelPackage incredibleIndia = new TravelPackage("India Tour", 50);

        // Create destinations and add activities
        Destination jaipur = new Destination("Jaipur");
        Activity amerFort = new Activity("Amer Fort Exploration", "Discover the majestic Amer Fort", 50.0, 20);
        Activity cityPalace = new Activity("City Palace Visit", "Explore the historic City Palace", 30.0, 15);
        jaipur.addActivity(amerFort);
        jaipur.addActivity(cityPalace);

        Destination delhi = new Destination("Delhi");
        Activity redFort = new Activity("Red Fort", "Explore the Red Fort", 50.0, 20);
        Activity lotusTemple = new Activity("Lotus Temple", "Explore Lotus Temple", 30.0, 15);
        delhi.addActivity(redFort);
        delhi.addActivity(lotusTemple);

        // Create travel package and add destinations
        incredibleIndia.addDestination(jaipur);
        incredibleIndia.addDestination(delhi);

        // Create passengers add passengers to the travel package
        StandardPassenger jay = new StandardPassenger("Jay", 101, 100.0);
        incredibleIndia.addPassenger(jay);
        GoldPassenger jatin = new GoldPassenger("Jatin", 102, 150.0);
        incredibleIndia.addPassenger(jatin);
        PremiumPassenger jainam = new PremiumPassenger("Jainam", 103);
        incredibleIndia.addPassenger(jainam);

        // Sign up passengers for activities
        jay.signUpForActivity(amerFort);
        jay.signUpForActivity(redFort);
        jatin.signUpForActivity(amerFort);
        jainam.signUpForActivity(redFort);

        // Print itinerary
        System.out.println();
        incredibleIndia.printItinerary();
        System.out.println();

        // Print passenger list
        incredibleIndia.printPassengerList();
        System.out.println();

        // Print individual passenger details
        incredibleIndia.printIndividualPassengerDetails(jainam);
        System.out.println();

        // Print available activities
        incredibleIndia.printAvailableActivities();
    }
}