package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by chen1 on 9/16/15.
 */
public class Joy extends Mood{
    public Joy(Date date) {
        super(date);
    }

    @Override
    public String getMood(){
        return "Happy";
    }


    public Boolean isHappy(){
        return Boolean.TRUE;
    }


}
