/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tweetsearcher;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
//import twitter4j.TwitterException;

/**
 *
 * @author Dell
 */
public class Searcher {

    String word = "";
    int option;
    private HashMap<String, ArrayList<Tweet>> mapName;
    private HashMap<String, ArrayList<Tweet>> mapWord;
    private HashMap<String, ArrayList<Tweet>> mapLocation;
    ArrayList<Tweet> searchData;
    ArrayList<Tweet> searchResult;
    private int SIZE = 200;
    private int[] shiftTable = new int[SIZE];
    ResultSet tweetSet;

    public Searcher() {
        mapName = new HashMap<>();
        mapWord = new HashMap<>();
        mapLocation = new HashMap<>();
    }

//    public Searcher(int op, String w) {
//        this.word = w;
//        this.option = op;
//
//        //searchData = new TweetData().getDataCollection();
//        if (option == 1) {
//            searchByUsername(word);
//        } else if (option == 2) {
//            searchByTweet(word);
//        } else if (option == 3) {
//            searchByDate(word);
//        } else if (option == 4) {
//            searchByTime(word);
//        }
//    }
    public void setSearchData(ArrayList<Tweet> searchData) {
        this.searchData = searchData;
    }

    public void search(String word) {
        //maybe we can return the result in this method.
        this.word = word;
        Tweet t;
        // use the iterator to take out the Tweet in the arraylit by using for each loop
        // then store the result that searched to the arraylist of "searchResult"

    }

    public ArrayList<Tweet> searchByName(String uName) { //done 
        //System.out.println("in here");
        searchResult = new ArrayList<>();
        if (mapName.containsKey(uName)) {//check in Hash Map first 
            // return value of that key in HashMap name mapName <String,TweetData>
            System.out.println("found in Hash map");
            return searchResult = mapName.get(uName);
        } else {
            String sql = "select * from twitter_tweet where screen_name = '" + uName + "'";
            Connection con = TweetMain.getConnection();

            try {
                Statement stm = con.createStatement();
                tweetSet = stm.executeQuery(sql);
                while (tweetSet.next()) {
                    int id = tweetSet.getInt(1);
                    String name = tweetSet.getString(2);
                    String text_tweet = tweetSet.getString(3);
                    String location = tweetSet.getString(4);
                    String device = tweetSet.getString(5);
                    String addedDate = tweetSet.getString(6);
                    Tweet tw = new Tweet(id, name, text_tweet, location, device, addedDate);
                    searchResult.add(tw);
                    //System.out.println("tweet id : " + id + " owner is " + uName + " is added");
                }
                mapName.put(uName, searchResult);
            } catch (SQLException ex) {
                Logger.getLogger(Searcher.class.getName()).log(Level.SEVERE, null, ex);
            }
            return searchResult;
        }
    }

    public ArrayList<Tweet> searchByTweet(String word) {//uses horspool algorithm for searching String pattern
        searchResult = new ArrayList<>();
        if (mapWord.containsKey(word)) {//check in Hash Map first 
            // return value of that key in HashMap name mapName <String,TweetData>
            System.out.println("found in Hash map");
            return searchResult = mapWord.get(word);
        } else {
            //create shift shiftTable for horspool algorithm
            this.shifttable(word);
            //method slow caused by this below sql
            String sql = "select * from twitter_tweet";
            Connection con = TweetMain.getConnection();

            try {
                Statement stm = con.createStatement();
                tweetSet = stm.executeQuery(sql);
                while (tweetSet.next()) {
                    int id = tweetSet.getInt(1);
                    String name = tweetSet.getString(2);
                    String text_tweet = tweetSet.getString(3);
                    String location = tweetSet.getString(4);
                    String device = tweetSet.getString(5);
                    String addedDate = tweetSet.getString(6);
                    //horspool algorithm
                    int positionFound = this.horspool(text_tweet, word);
                    if (positionFound == -1) {
                        System.out.println("ID : " + id + " is NOT FOUND!!");
                    } else {
                        Tweet tw = new Tweet(id, name, text_tweet, location, device, addedDate);
                        searchResult.add(tw);
                    }
                    //System.out.println("tweet id : " + id + " owner is " + uName + " is added");
                }
                mapWord.put(word, searchResult);
            } catch (SQLException ex) {
                Logger.getLogger(Searcher.class.getName()).log(Level.SEVERE, null, ex);
            }
            return searchResult;
        }

    }

    public ArrayList<Tweet> getSearchData() {
        // maybe we dont need this method.
        return searchData;
    }

    public ArrayList<Tweet> getSearchResult() {
        // maybe we dont need this method.
        return searchResult;
    }

    public void searchByUsername(String word) {
        searchResult = new ArrayList<>();
        Iterator it = searchData.iterator();
        while (it.hasNext()) {
            Tweet tw = (Tweet) it.next();
            for (int i = 0; i < tw.getUser().length() - word.length() + 1; i++) {
                int j;
                for (j = 0; j < word.length(); j++) {
                    if (tw.getUser().charAt(i + j) != word.charAt(j)) {
                        break;
                    }
                }
                if (j == word.length()) {
                    searchResult.add(tw);
                    break;
                }
            }
        }
    }

    public void searchByTweetOldVer(String word) {
        searchResult = new ArrayList<>();
        Iterator it = searchData.iterator();
        while (it.hasNext()) {
            Tweet tw = (Tweet) it.next();
            for (int i = 0; i < tw.getTweet().length() - word.length() + 1; i++) {
                int j;
                for (j = 0; j < word.length(); j++) {
                    if (tw.getTweet().charAt(i + j) != word.charAt(j)) {
                        break;
                    }
                }
                if (j == word.length()) {
                    searchResult.add(tw);
                    break;
                }
            }
        }
    }

    public void searchByDate(String word) {
        System.out.println(word);
    }

    public void searchByTime(String word) {
        System.out.println(word);
    }

    private void shifttable(String pattern) {

        int i, j, m;
        char p[] = pattern.toCharArray();
        m = pattern.length();

        for (i = 0; i < SIZE; i++) {
            shiftTable[i] = m;
        }
        for (j = 0; j < m; j++) {
            shiftTable[p[j]] = m - 1 - j;
        }
    }

    private int horspool(String source, String pattern) {
        int i, k, pos, m;
        char s[] = source.toCharArray();
        char p[] = pattern.toCharArray();
        m = pattern.length();

        for (i = m - 1; i < source.length();) {
            k = 0;
            while ((k < m) && (p[m - 1 - k] == s[i - k])) {
                k++;
            }
            if (k == m) {
                pos = i - m + 2;
                return pos;
            } else {
                i += shiftTable[s[i]];
            }
        }
        return -1;
    }
}
