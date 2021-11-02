package lesson1;

import java.util.Objects;

public class Time {
    protected int minutes;
    protected int hour;

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
        if (minutes < 0 || minutes > 60)
        throw new IllegalArgumentException(minutes + " is out of range");
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
        if (hour < 0 || hour > 24)
            throw new IllegalArgumentException(hour + " is out of range");
    }

    public Time(int hour,int minutes) {
        setMinutes(minutes);
        setHour(hour);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Time)) return false;
        Time time = (Time) o;
        return minutes == time.minutes && hour == time.hour;
    }

    @Override
    public int hashCode() {
        return Objects.hash(minutes, hour);
    }

    @Override
    public String toString() {
        return hour +":" + minutes;
    }
}
