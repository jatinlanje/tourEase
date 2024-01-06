package model;

import org.jatin.model.Activity;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ActivityTest {

    @Test
    public void shouldReturnCorrectValues() {
        // Arrange
        Activity eiffelTower = new Activity("Eiffel Tower", "Visit Eiffel Tower", 50.0, 20);

        // Assert
        assertEquals("Eiffel Tower", eiffelTower.getName());
        assertEquals("Visit Eiffel Tower", eiffelTower.getDescription());
        assertEquals(50.0, eiffelTower.getCost(), 0.01);
        assertEquals(20, eiffelTower.getCapacity());
    }
}
