/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tweetsearcher;

import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class Searcher {
    String word;
    ArrayList<Tweet> searchData;
    ArrayList<Tweet> searchResult;

public void setDataToBeSearch( ArrayList<Tweet> searchData){
    this.searchData = searchData;
}
public void search(String word){
    //maybe we can return the result in this method.
    this.word = word;
    Tweet t;
    // use the iterator to take out the Tweet in the arraylit by using for each loop
    // then store the result that searched to the arraylist of "searchResult"
    
   
}
public ArrayList<Tweet> getSearchResult(){
 // maybe we dont need this method.
    
    return null;
}
}