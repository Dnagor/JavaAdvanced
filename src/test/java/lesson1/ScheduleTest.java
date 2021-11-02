package lesson1;

import org.junit.*;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class ScheduleTest {
    Schedule schedule;
    String movie_name1 = "Test name one";
    String movie_name2 = "Test name two";
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
    public void setup(){
        schedule = new Schedule();
        schedule.addSeance(new Seance(new Movie(movie_name1, new Time(2, 00)), new Time(20, 00)));
        schedule.addSeance(new Seance(new Movie(movie_name2, new Time(2, 00)), new Time(20, 00)));
    }
    @After
    public void teardown(){
        schedule = null;
    }
    @Test
    public void addSeanceTest(){
        Boolean flag = schedule.seances.stream().anyMatch(seance -> seance.movie.title.equalsIgnoreCase(movie_name1));
        Assert.assertTrue(flag);
    }
    @Test
    public void removeSeanceTest(){
        schedule.deleteSeanceByName(movie_name1);
        Boolean flag = schedule.seances.stream().anyMatch(seance -> seance.movie.title.equalsIgnoreCase(movie_name1));
        Assert.assertFalse(flag);
    }
    @Test
    public void catchIncorrectTimeExceptionTest(){
        schedule.addSeance(new Seance(new Movie("AAA",new Time(2,00)),new Time(22,30)));
        Boolean flag = schedule.seances.stream().anyMatch(seance -> seance.movie.title.equalsIgnoreCase("AAA"));
        Assert.assertFalse(flag);
    }
}
