package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

/**
 * Created by chen1 on 9/30/15.
 */
public class TweetList implements MyObservable {
    private ArrayList<MyObserver> myObservers = new ArrayList<MyObserver>();

    public ArrayList tweets = new ArrayList<Tweet>();
    public void deletetweet(Tweet tweet){
        //important codes here

        return;
    }

    public void addObserver(MyObserver observer){
        myObservers.add(observer);
    }

    public void notifyObservers(){
        for (MyObserver observer : myObservers){
            observer.myNotify();
        }
    }


    public void add(Tweet tweet) {
        if (tweets.contains(tweet)) {
            throw new IllegalArgumentException("Already Exists");
        } else {
            tweets.add(tweet);
        }
        notifyObservers();
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
