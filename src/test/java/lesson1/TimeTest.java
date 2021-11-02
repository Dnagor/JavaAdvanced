package lesson1;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TimeTest {
    private final int hour;
    private final int minutes;
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

    public TimeTest(int hour, int minutes) {
        this.hour = hour;
        this.minutes = minutes;
    }

    @Parameterized.Parameters
    public static Collection primeNumbers() {
        return Arrays.asList(new Object[][]{
                {25, 10}, {-1, 50}, {100, 6}, {10, -1}, {2, 61}, {4, 100}
        });
    }

    @Test(expected = IllegalArgumentException.class)
    public void catchTimeExceptionTest() {
        Time time = new Time(hour, minutes);
    }
}
