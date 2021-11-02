import lesson1.ScheduleTest;
import lesson1.SeanceTest;
import lesson1.TimeTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({SeanceTest.class, TimeTest.class, ScheduleTest.class})
public class CinemaSuite {

}
