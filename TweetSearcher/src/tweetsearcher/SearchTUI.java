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
public class SearchTUI {
    String filename = "";
    TweetData tweetData ;
    
     public void showReadingFile(String filename, TweetData tweetData){
        System.out.println("Reading the File name : " + filename);
        tweetData = new TweetData(filename);
        
        System.out.println("File name " + filename + " finish reading.");
        
    }
    
}
