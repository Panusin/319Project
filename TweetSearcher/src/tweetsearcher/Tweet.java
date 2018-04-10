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

    public Tweet(String user, String tweet, String date, String time) {
        this.user = user;
        //this.tweet = tweet;
        this.date = date;
        this.time = time;
    }
    public Tweet(String tweet){
        this.tweet = tweet;
    }
    
    public String getTweet(){
        return tweet;
    }
}
