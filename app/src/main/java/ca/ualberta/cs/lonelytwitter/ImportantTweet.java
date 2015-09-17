package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by chen1 on 9/16/15.
 */
public class ImportantTweet extends Tweet{
    public ImportantTweet(Date date, String tweet) throws TweeTooLongException{
        super(date, tweet);
        this.setText(tweet);
        this.date =date;
    }

    public ImportantTweet(String tweet) throws TweeTooLongException{
        super(tweet);
    }

    public Boolean isImportant() {
        return Boolean.TRUE;
    }

    @Override   //this is for checking if you are actually overriding
    public String getText(){
        //overriding superclass method
        return "!!!" + super.getText();
    }
}
