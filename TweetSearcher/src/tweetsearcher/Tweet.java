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

    private int id;
    private String user;
    private String tweet;
    private String location;
    private String device;
    private String dateAdded;
     
    
    public Tweet() {

    }

    public Tweet(String user, String tweet, String location) {
        this.user = user;
        this.tweet = tweet;
        this.location = location;
    }

    public Tweet(int id, String user, String tweet, String location, String device, String dateAdded) {
        this.id = id;
        this.user = user;
        this.tweet = tweet;
        this.location = location;
        this.device = device;
        this.dateAdded = dateAdded;
    }

    public Tweet(String tweet) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getDate() {
        return "";
    }

    public String getTime() {
        return "";
    }
    
    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }


}
