package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by chen1 on 9/16/15.
 */
public class NormalTweet extends Tweet {
    public NormalTweet(String tweet, Date date) throws TweeTooLongException{
        super(date, tweet);
    }

    public NormalTweet(String tweet) throws TweeTooLongException{
        super(tweet);
    }

    public Boolean isImportant() {
        return Boolean.TRUE;
    }
}