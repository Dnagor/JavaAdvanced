package lesson1;

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
        this.minutes = minutes;
        this.hour = hour;
    }

    @Override
    public String toString() {
        return hour +":" + minutes;
    }
}
