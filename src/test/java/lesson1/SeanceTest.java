package lesson1;

import org.junit.*;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class SeanceTest {
    Seance seance;
    Time time1 = new Time(1, 50);
    Time time2 = new Time(3, 10);
    Time expected = new Time(5, 0);

    @Rule
    public TestWatcher testWatcher = new TestWatcher() {
        @Override
        protected void succeeded(Description description) {
            System.out.println(description.getMethodName() + " passed.");
        }

        @Override
        protected void failed(Throwable e, Description description) {
            System.out.println(description.getMethodName() + " failed.");
        }

    };
    @Before
    public void setup() {
        seance = new Seance(new Movie("Test movie", new Time(2, 00)), new Time(20, 00));
    }

    @After
    public void teardown() {
        seance = null;
    }

    @Test
    public void addTimeTest() {
        Time actual = seance.addTime(time1, time2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void minutesToTimeTest() {
        Time actual = seance.minutesToTime(300);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void timeToMinutesTest() {
        int actual = seance.timeToMinutes(time1);
        Assert.assertEquals(110, actual);
    }
}
