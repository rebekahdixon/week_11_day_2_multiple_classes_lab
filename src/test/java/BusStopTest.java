import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BusStopTest {

    BusStop busStop;
    Person person;

    @Before
    public void before(){
        busStop = new BusStop("Edinburgh");
        person = new Person();
    }

    @Test
    public void canAddToQueue(){
        busStop.addPerson(person);
        assertEquals(1, busStop.queueLength());
    }

    @Test
    public void canRemoveFromQueue(){
        busStop.addPerson(person);
        assertEquals(1, busStop.queueLength());
        busStop.removePerson();
        assertEquals(0, busStop.queueLength());
    }
}
