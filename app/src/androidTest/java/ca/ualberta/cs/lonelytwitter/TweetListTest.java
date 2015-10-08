package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;

import junit.framework.TestCase;

import java.util.ArrayList;

/**
 * Created by chen1 on 9/30/15.
 */
public class TweetListTest extends ActivityInstrumentationTestCase2 implements MyObserver {

    private boolean wasNotified = false;


    public TweetListTest(){
        super(LonelyTwitterActivity.class);
    }


    //public something myHelperForTesting()

    public void testRemoveTweet(){
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("hihihihi");
        tweetList.add(tweet);
        //int tweetCount = tweetList.getTweetCount();
        tweetList.remove(tweet);
        //int newTweetCount = tweetList.getTweetCount();
        //assertTrue((tweetCount-1) == newTweetCount);
        assertFalse(tweetList.hasTweet(tweet));
    }

    public void testAddTweet() {
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("hihihihi");
        assertFalse(tweetList.hasTweet(tweet));
        tweetList.add(tweet);
        assertTrue(tweetList.hasTweet(tweet));

    }
    //testSetup
    //teststuff
    //testTeardown

    public void testTweetCount(){
        TweetList tweetList = new TweetList();

        for (int i = 1; i<10; i++){
            Tweet tweet = new NormalTweet(Integer.toString(i));
            tweetList.add(tweet);
            assertEquals(tweetList.getCount(),i);
        }

    }

    public void testGetTweet(){
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("hihihihi");
        tweetList.add(tweet);
        //Tweet returnedTweet = tweetList.getTweet(0);
        //assertTrue(tweet.date.equals(returnedTweet.date) && tweet.getText() == returnedTweet.getText());
    }

    public void testGetTweetType(){

    }

    public void testDuplicate(){
        boolean exist = false;
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("hihihihi");
        tweetList.add(tweet);
        try {
            tweetList.add(tweet);
        }catch (IllegalArgumentException e){
            exist = true;
        }
        assertTrue(exist);
    }

    /*
    private ArrayList<MyObservable> observables = new ArrayList<MyObservable>();
    public void addObservable(MyObservable myObservable){
    }
*/

    public void testTweetListChanged(){
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("hihihihi");
        tweetList.addObserver(this);
        wasNotified = false;
        assertFalse(wasNotified);
        tweetList.add(tweet);
        assertTrue(wasNotified);
    }

    public void myNotify(){
        wasNotified = true;
    }

    public void addObservable(MyObservable o) {

    }
}