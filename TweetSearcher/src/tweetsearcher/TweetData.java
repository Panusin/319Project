/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tweetsearcher;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
//import twitter4j.Query;
//import twitter4j.QueryResult;
//import twitter4j.Status;
//import twitter4j.TwitterException;
//import twitter4j.TwitterFactory;
//import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author Dell
 */
public class TweetData {

    String fileName;
    //File file;
    ArrayList<Tweet> dataCollection;
    
    public TweetData() {
        //setSearchData();
        //getTweetFromWeb();
        dataCollection = new ArrayList<>();
        
    }

//   
    public TweetData(String filename) {
        this.fileName = filename;
    }

    public void setSearchData() {

    }

   

    public ArrayList<Tweet> getDataCollection() {
        return dataCollection;
    }
}
