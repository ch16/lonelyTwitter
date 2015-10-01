package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

/**
 * Created by chen1 on 9/30/15.
 */
public class TweetList {
    public ArrayList tweets = new ArrayList<Tweet>();
    public void deletetweet(Tweet tweet){
        //important codes here

        return;
    }

    public void add(Tweet tweet) {
        if (tweets.contains(tweet)) {
            throw new IllegalArgumentException("Already Exists");
        } else {
            tweets.add(tweet);
        }
    }

    public void remove(Tweet tweet){
        tweets.remove(tweet);
    }

    public boolean hasTweet(Tweet tweet){
        return tweets.contains(tweet);
    }

    public Tweet getTweet(int index){
        return (Tweet) tweets.get(index);
    }

    public ArrayList<Tweet> getTweets(){
        return tweets;
    }

    public int getCount(){
        return tweets.size();
    }
}
