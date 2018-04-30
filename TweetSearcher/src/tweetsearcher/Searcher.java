/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tweetsearcher;

import java.util.ArrayList;
import java.util.Iterator;
import twitter4j.TwitterException;

/**
 *
 * @author Dell
 */
public class Searcher {
    String word ="";
    int option;
    ArrayList<Tweet> searchData;
    ArrayList<Tweet> searchResult;

    public Searcher(){
        
    }
    
    public Searcher(int op, String w) throws TwitterException{
        this.word = w;
        this.option = op;
        
        searchData = new TweetData().getSearchData();
        
        if(option == 1){
            searchByUsername(word);
        } else if(option == 2){
            searchByTweet(word);
        } else if(option == 3){
            searchByDate(word);
        } else if(option == 4){
            searchByTime(word);
        }    
    }
    
    public void setSearchData(ArrayList<Tweet> searchData){
        this.searchData = searchData;
    }

    public void search(String word){
        //maybe we can return the result in this method.
        this.word = word;
        Tweet t;
        // use the iterator to take out the Tweet in the arraylit by using for each loop
        // then store the result that searched to the arraylist of "searchResult"
    }

    public ArrayList<Tweet> getSearchData(){
        // maybe we dont need this method.
        return searchData;
    }
    
    public ArrayList<Tweet> getSearchResult(){
        // maybe we dont need this method.
        return searchResult;
    }
    
    public void searchByUsername(String word){
        searchResult = new ArrayList<>();
        Iterator it = searchData.iterator();
        while(it.hasNext()){
            Tweet tw = (Tweet) it.next();
            for(int i=0; i<tw.getUser().length()-word.length()+1; i++){
                int j;
                for(j=0; j<word.length(); j++){
                    if(tw.getUser().charAt(i+j) != word.charAt(j)){
                        break;
                    }
                }
                if(j == word.length()){
                    searchResult.add(tw);
                    break;
                }
            }
        }
    }
    
    public void searchByTweet(String word){
        searchResult = new ArrayList<>();
        Iterator it = searchData.iterator();
        while(it.hasNext()){
            Tweet tw = (Tweet) it.next();
            for(int i=0; i<tw.getTweet().length()-word.length()+1; i++){
                int j;
                for(j=0; j<word.length(); j++){
                    if(tw.getTweet().charAt(i+j) != word.charAt(j)){
                        break;
                    }
                }
                if(j == word.length()){
                    searchResult.add(tw);
                    break;
                }
            }
        }
    }
    
    public void searchByDate(String word){
        System.out.println(word);
    }
    
    public void searchByTime(String word){
        System.out.println(word);
    }

}