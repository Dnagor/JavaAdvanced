package lesson1;

import java.util.Set;
import java.util.TreeSet;

public class Schedule {
    Set<Seance> seances = new TreeSet<>(new SeanceComparator());

    public void addSeance(String name, Time duration, Time start) {
        seances.add(new Seance(new Movie(name, duration), start));
    }

    public void removeSeance(Seance seance) {
        seances.remove(seance);
    }

    public void addSeance(Seance seance) {
        if (seance.timeToMinutes(seance.endTime) < 1380 && seance.timeToMinutes(seance.startTime) >= 540) {
            seances.add(seance);
        } else try {
            throw new IncorrectTimeException("Schedule time is not in working hours");
        } catch (IncorrectTimeException e) {
            e.printStackTrace();
        }

    }

    public void deleteSeanceByName(String movieName) {
        seances.removeIf(seance -> seance.movie.title.equalsIgnoreCase(movieName));
    }

    @Override
    public String toString() {
        return "Schedule:\n" + printSeances();
    }

    public String printSeances() {
        String sc = "";
        for (Seance s : seances) {
            sc = sc + s;
        }
        return sc;
    }
}
