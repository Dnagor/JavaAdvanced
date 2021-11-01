package homework;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

public class Cinema {
    TreeMap<Days, Schedule> schedules = new TreeMap<>();
    ArrayList<Movie> moviesLibrary = new ArrayList<>();
    Time open = new Time(9, 00);
    Time close = new Time(23, 00);

    public Cinema() {
        this.open = new Time(9, 00);
        this.close = new Time(23, 00);
    }

    public static void main(String[] args) {
        Cinema cinema = new Cinema();

        Time startTime = new Time(9, 00);
        Time startTime2 = new Time(12, 00);
        Time startTime3 = new Time(21, 20);
        Time durationTime = new Time(1, 30);
        Time durationTime2 = new Time(2, 00);
        Movie movie1 = new Movie("T1", durationTime);
        Movie movie2 = new Movie("T2", durationTime);
        Movie movie3 = new Movie("T3", durationTime2);
        Movie movie4 = new Movie("T4", durationTime);
        Movie movie5 = new Movie("T5", durationTime);
        Movie movie6 = new Movie("T6", durationTime);
        Seance seance1 = new Seance(movie2, startTime3);
        Seance seance2 = new Seance(movie1, startTime2);
        Seance seance3 = new Seance(movie4, startTime);
        Seance seance4 = new Seance(movie3, startTime3);
        Seance seance5 = new Seance(movie5, startTime);
        Seance seance6 = new Seance(movie6, startTime2);

        cinema.addMovie(movie1);

        cinema.addSeance(seance1, "MONDAY");
        cinema.addSeance(seance2, "MONDAY");
        cinema.addSeance(seance3, "MONDAY");
        cinema.addSeance(seance4, "MONDAY");
        cinema.addSeance(seance5, "MONDAY");
        cinema.addSeance(seance6, "MONDAY");
        cinema.addSeance(seance1, "TUESDAY");
        cinema.addSeance(seance2, "TUESDAY");
        cinema.addSeance(seance3, "TUESDAY");
        cinema.addSeance(seance1, "WEDNESDAY");
        System.out.println(cinema);

        cinema.removeMovie("T1");
        System.out.println(cinema);


    }

    public void addMovie(Movie movie) {
        moviesLibrary.add(movie);
    }

    public void removeMovie(String name) {
        moviesLibrary.removeIf(movie -> movie.title.equalsIgnoreCase(name));
        System.out.println("Movie " + name + " was removed from movies library");
        removeSeance(name);
    }

    private void removeSeance(String name) {
        Collection<Schedule> schedule = schedules.values();
        schedule.forEach(seances -> seances.deleteSeanceByName(name));
        System.out.println("Seance with movie - "+ name+" was removed from all schedules.");
    }

    public void addSeance(Seance seance, String day) {
        if (!schedules.containsKey(Days.valueOf(day))) {
            Schedule schedule = new Schedule();
            schedule.addSeance(seance);
            schedules.put(Days.valueOf(day), schedule);
        } else {
            schedules.get(Days.valueOf(day)).addSeance(seance);
        }
    }


    @Override
    public String toString() {
        return "Shedules:\n" + printSchedules();
    }

    public String printSchedules() {
        String sc = "";
        for (Map.Entry s : schedules.entrySet()) {
            sc = sc + s.toString() + "\n";
        }
        return sc;
    }
}