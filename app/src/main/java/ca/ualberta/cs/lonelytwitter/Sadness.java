package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

import javax.xml.parsers.SAXParser;

/**
 * Created by chen1 on 9/16/15.
 */
public class Sadness extends Mood{
    public Sadness(Date date) {
        super(date);
    }

    @Override
    public String getMood(){
        return "Sad";
    }

    public Boolean isHappy(){
        return Boolean.FALSE;
    }

}
