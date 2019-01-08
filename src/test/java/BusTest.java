import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BusTest {

    Bus bus;
    Bus fullBus;
    Person person;
    BusStop initialStop;

    @Before
    public void before(){
        bus = new Bus("Istanbul", 120);
        fullBus = new Bus("Istanbul", 0);
        person = new Person();
        initialStop = new BusStop("Edinburgh");
    }

    @Test
    public void checkNumberOfPassengers(){
        assertEquals(0, bus.passengerCount());
    }

    @Test
    public void checkPassengerAdded(){
        bus.addPassenger(person);
        assertEquals(1, bus.passengerCount());
    }

    @Test
    public void checkPassengerCanBeRefused(){
        fullBus.addPassenger(person);
        assertEquals(0, bus.passengerCount());
    }

    @Test
    public void checkPassengerRemoved(){
        bus.addPassenger(person);
        assertEquals(1, bus.passengerCount());
        bus.removePassenger();
        assertEquals(0, bus.passengerCount());
    }

    @Test
    public void canPickUpPersonFromBusStop(){
        initialStop.addPerson(person);
        assertEquals(1, initialStop.queueLength());
        bus.pickUp(initialStop);
        assertEquals(0, initialStop.queueLength());
        assertEquals(1, bus.passengerCount());
    }
}
