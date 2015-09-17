package ca.ualberta.cs.lonelytwitter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * Created by chen1 on 9/16/15.
 */
public abstract class Tweet /* extends Object */extends Object implements Tweetable {
    private String text;
    protected Date date;
    private ArrayList<Mood> moodList;

    //constructor       code -> generate -> constructor
    public Tweet(Date date, String tweet) throws TweeTooLongException{
        this.date = date;
        text = tweet;
        //this.text = tweet (dont need "this" if the variables dont have the same name)
    }

    public Tweet(String tweet) throws TweeTooLongException{
        //
        this.setText(tweet);
        this.date = new Date();
    }

    //code -> generate -> getter and setter
    public String getText() {
        return text;
    }

    public void setText(String text) throws TweeTooLongException{
        if (text.length() <= 140) {
            this.text = text;
        }else{
            throw new TweeTooLongException();
        }
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public abstract Boolean isImportant();


}
