package model;

import org.jatin.model.Activity;
import org.jatin.model.Destination;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DestinationTest {

    @Test
    public void shouldAddActivityToActivitiesList() {
        // Arrange
        Destination europe = new Destination("Euro Tour");
        Activity eiffelTower = new Activity("Eiffel Tower", "vist Eiffel Tower", 50.0, 20);

        // Act
        europe.addActivity(eiffelTower);

        // Assert
        assertTrue(europe.getActivities().contains(eiffelTower));
    }
}
