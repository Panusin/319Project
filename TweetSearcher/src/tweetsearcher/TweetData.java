/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tweetsearcher;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author Dell
 */
public class TweetData {
    String fileName;
    File file;
    ArrayList <Tweet> searchData = new ArrayList<>();

    public TweetData() throws TwitterException{
        setSearchData();
        //getTweetFromWeb();
    }
    
    public TweetData(String fileName) {
        //this.searchData = new ArrayList<>();
        this.file = new File(fileName);
    }
    
    public void getTweetFromWeb() throws TwitterException{
        ConfigurationBuilder cf = new ConfigurationBuilder();
        cf.setDebugEnabled(true)
                .setOAuthConsumerKey("liBKWQpZwacKSXwjBQ7Q80GFF")
                .setOAuthConsumerSecret("f5kwnBlvgu0puAJXi97P6w80CV8bA9tyYxklXkE24d7Mq5Yc8F")
                .setOAuthAccessToken("738765736504496130-fwski7JC8IBH0HC2onXxRB0gIsGbpQv")
                .setOAuthAccessTokenSecret("Bnh233RExEb5D7MknT0ef425BIhJgIKX09jY6eYzaIX7p");
        
        TwitterFactory tf = new TwitterFactory(cf.build());
        twitter4j.Twitter twitter = tf.getInstance();
        
        String keyword="bonus";
        Query query = new Query(keyword);
        QueryResult results;
        results = twitter.search(query);
        List<Status> status = results.getTweets();
        for(Status st : status){
            //System.out.println(st.getUser().getName()+" : "+st.getText());
            searchData.add(new Tweet(st.getUser().getName(), st.getText()));
            //System.out.println(st.getUser().getName());
        }
    }
    
    public void readFile() throws IOException{
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line; 
            while((line = reader.readLine()) != null){
                // this is exactly we can do with the line that get from the file
                searchData.add(new Tweet(line));
                
               //is it possible to read spacific column,  no!
                System.out.println(line);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TweetData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setSearchData(){
        searchData.add(new Tweet("aaa1", "bbb1", "ccc1", "ddd1"));
        searchData.add(new Tweet("aaa2", "bbb2", "ccc2", "ddd2"));
        searchData.add(new Tweet("aaa3", "bbb3", "ccc3", "ddd3"));
        searchData.add(new Tweet("aaa4", "bbb4", "ccc4", "ddd4"));
        searchData.add(new Tweet("aaa5", "bbb5", "ccc5", "ddd5"));
        searchData.add(new Tweet("fff6", "bbb6", "ccc6", "ddd6"));
        searchData.add(new Tweet("aaa7", "bbb7", "ccc7", "ddd7"));
        searchData.add(new Tweet("aaa8", "bbb8", "ccc8", "ddd8"));
        searchData.add(new Tweet("aaa9", "bbb9", "ccc9", "ddd9"));
        searchData.add(new Tweet("aaa10", "bbb10", "ccc10", "ddd10"));
    }
    
    public ArrayList<Tweet> getSearchData(){
        return searchData;
    }
}
