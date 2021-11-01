package lesson1;

import java.util.Comparator;

public class Seance {
    protected Movie movie;
    protected Time startTime;
    protected Time endTime;

    public Seance(Movie movie, Time startTime) {
        this.movie = movie;
        this.startTime = startTime;
        this.endTime = addTime(movie.duration, startTime);
    }

    public Movie getMovie() {
        return movie;
    }

    public Time getStartTime() {
        return startTime;
    }

    public int timeToMinutes(Time time) {
        return time.hour * 60 + time.minutes;
    }

    public Time minutesToTime(int min) {
        int h = (int) (Math.floor(min / 60));
        int m = min % 60;
        return new Time(h, m);
    }

    public Time addTime(Time t1, Time t2) {
        int res = timeToMinutes(t1) + timeToMinutes(t2);
        return minutesToTime(res);
    }

    @Override
    public String toString() {
        return "Seance: " + movie +
                ", starts at " + startTime +
                ", ends at " + endTime + "\n";
    }
}

class SeanceComparator implements Comparator<Seance> {

    @Override
    public int compare(Seance o1, Seance o2) {
        if (o1.getMovie().getTitle().compareTo(o2.getMovie().getTitle()) > 0) {
            return 1;
        } else if (o1.getMovie().getTitle().compareTo(o2.getMovie().getTitle()) < 0) {
            return -1;
        } else return 0;
    }
}
