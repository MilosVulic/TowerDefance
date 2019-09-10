package helpingPackage;

import org.junit.Test;
import static org.junit.Assert.*;


public class ClockTest {

    public ClockTest() {
    }


    @Test
    public void testDelta() {
        assertEquals(0, Clock.delta(), 0.0);
        Clock.paused = true;
        assertEquals(0, Clock.delta(), 0.0);
        Clock.paused = false;
    }


    @Test
    public void testGetTotalTime() {
        assertEquals(0L, Clock.getTotalTime());
    }


    @Test
    public void testGetMultiplier() {
        assertEquals(1, Clock.getMultiplier(), 0.0);
    }


    @Test
    public void testChangeMultiplier() {
        double value = 2;
        Clock.changeMultiplier(value);
        assertEquals(3, Clock.multiplier, 0.0);
    }


    @Test
    public void testPause() {
        Clock.pause();
        assertEquals(true, Clock.paused);
    }
}
