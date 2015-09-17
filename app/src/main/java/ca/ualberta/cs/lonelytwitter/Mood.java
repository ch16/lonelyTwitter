package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by chen1 on 9/16/15.
 */
public abstract class Mood {
    private String mood;
    protected Date date;

    public Mood(Date date) {
        this.date = date;
    }

    public Mood(String mood) {
        this.mood = mood;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public abstract Boolean isHappy();
}
