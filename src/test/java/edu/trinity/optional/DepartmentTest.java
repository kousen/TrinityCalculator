package edu.trinity.optional;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DepartmentTest {

    private final Manager bart = new Manager("Bart", "J", "Simpson");
    private final Manager lisa = new Manager("Lisa", null, "Simpson");

    private final Department mischief = new Department(bart);
    private final Department studying = new Department(lisa);
    private final Department play = new Department(null);

    @Test
    void getManagerThatExists() {
        assertTrue(mischief.getManager().isPresent());
        assertTrue(studying.getManager().isPresent());

        // Since last name returns string, can use "map"
        Optional<String> bartLastName = mischief.getManager().map(Manager::getLast);
        Optional<String> lisaLastName = studying.getManager().map(Manager::getLast);
        assertTrue(bartLastName.isPresent());
        assertTrue(lisaLastName.isPresent());

        // Since middle name returns optional, must use "flatMap"
        Optional<String> bartMiddleName = mischief.getManager().flatMap(Manager::getMiddle);
        Optional<String> lisaMiddleName = studying.getManager().flatMap(Manager::getMiddle);
        assertTrue(bartMiddleName.isPresent());
        assertTrue(lisaMiddleName.isEmpty());
    }


    @Test
    void getManagerThatDoesNOTExist() {
        // Since last name returns string, can use "map"
        Optional<String> last = play.getManager().map(Manager::getLast);

        // Since middle name returns optional, must use "flatMap"
        Optional<Optional<String>> whatever = play.getManager().map(Manager::getMiddle);
        Optional<String> middle = play.getManager().flatMap(Manager::getMiddle);

        assertNotNull(whatever);
        assertTrue(last.isEmpty());
        assertTrue(middle.isEmpty());
    }

}