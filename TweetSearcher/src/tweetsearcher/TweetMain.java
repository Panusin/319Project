/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tweetsearcher;

//import twitter4j.TwitterException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;




/**
 *
 * @author Dell
 */
public class TweetMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //SearchTUI tui = new SearchTUI(); 
         //GUI1 gui = new GUI1();
    }
    
    public static Connection getConnection(){
        String connectionURL = "jdbc:mysql://mysql.ilab.sit.kmutt.ac.th:3306/twitter_data?zeroDateTimeBehavior=convertToNull";
        //ConnectionURL, username and password should be specified in getConnection()
        try {
            Connection conn = DriverManager.getConnection(connectionURL,"dodo",".=hxitdv[vk=urwfh");
            System.out.println("Connect successful ! ");
            return conn; 
            //conn.close();
        } catch (SQLException ex) {
            System.out.println("Connect failed !!! ");
        }
        return null;
    }
   
}
