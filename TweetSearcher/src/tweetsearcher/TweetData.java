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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell
 */
public class TweetData {
    String fileName;
    File file;
    ArrayList <Tweet> tweetData;
    
    public TweetData(String fileName) {
        this.tweetData = new ArrayList<>();
        this.file = new File(fileName);
    }
    
    
    public void readFile() throws IOException{
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line; 
            while((line = reader.readLine()) != null){
                // this is exactly we can do with the line that get from the file
                tweetData.add(new Tweet(line));
                
               //is it possible to read spacific column,  no!
                System.out.println(line);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TweetData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
