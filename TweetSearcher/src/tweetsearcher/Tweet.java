/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tweetsearcher;

/**
 *
 * @author Dell
 */
public class Tweet {
    private String user;
    private String tweet;
    private String date;
    private String time;
    private String test;

    public Tweet(){
        
    }
    
    public Tweet(String user, String tweet){
        this.user = user;
        this.tweet = tweet;
    }
    
    public Tweet(String user, String tweet, String date, String time) {
        this.user = user;
        this.tweet = tweet;
        this.date = date;
        this.time = time;
    }
    
    public Tweet(String tweet){
        this.tweet = tweet;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTweet() {
        return tweet;
    }

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
    
    
    
}
