/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tweetsearcher;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
//import twitter4j.TwitterException;

public class SearchTUI {
    String filename = "";
    TweetData tweetData ;
    ArrayList<Tweet> searchData;
    int option;
    String word = "";
    Scanner sc = new Scanner(System.in);
    
    public SearchTUI()  {
        TweetData tweet = new TweetData();
        searchData = tweet.getSearchData();
        printWelcome();
    }
    
    public SearchTUI(String filename){ //have't used yet. We need to get the file first.
        this.filename = filename;
        //showReadingFile(filename);
        printWelcome();
    }
    
    public void showReadingFile(String filename){
        System.out.println("Reading the File name : " + filename);
        tweetData = new TweetData(filename);
        
        System.out.println("File name " + filename + " finish reading.");
    }
     
     public void printWelcome(){
         System.out.println("         Welcome to Tweet Searcher application.");
         System.out.println("You can search every tweet you want in this application!");
         System.out.println("       You can select mode that you want to search");
         printSelectOption();
     }
     
     public void printSelectOption(){
         System.out.println("          - type '1' for search by : username");
         System.out.println("          - type '2' for search by : tweet");
         System.out.println("          - type '3' for search by : date");
         System.out.println("          - type '4' for search by : time");
         System.out.print("Please type in a mode number : ");
         option = sc.nextInt();
         while(option != 1 && option != 2 && option != 3 && option != 4){
             System.out.println("The mode number is wrong!");
             System.out.println("Please try again.");
             System.out.print("Please type in a mode number : ");
             option = sc.nextInt();
         }
         printAskForWord();
     }
     
     public void printAskForWord(){
         System.out.print("Please type in a word you want search : ");
         word = sc.next();
         Searcher s = new Searcher(option,word);
         printTweetData(s.getSearchResult());
         
     }
     
     public void printTweetData(ArrayList<Tweet> arrayL){
         Iterator it = arrayL.iterator();
         while(it.hasNext()){
             Tweet tw = (Tweet) it.next();
             System.out.println(tw.getUser() + " " + tw.getTweet() + " " + tw.getDate() + " " + tw.getTime());
         }
         printAskToCont();
     }
     
     public void printAskToCont(){
         System.out.print("Do you want to continue searching? (y/n) : ");
         String yn = sc.next();
         while(!yn.toLowerCase().equals("y") && !yn.toLowerCase().equals("n")){
             System.out.println("Please type the correct answer.");
             System.out.print("Do you want to continue searching? (y/n) : ");
             yn = sc.next();
         }
         if(yn.toLowerCase().equals("y")){
             System.out.print("Continus with the same mode? (y/n) : ");
             String yn2 = sc.next();
             while(!yn2.toLowerCase().equals("y") && !yn2.toLowerCase().equals("n")){
                System.out.print("Please type the correct answer.");
                yn2 = sc.next();
             }
             if(yn2.toLowerCase().equals("y")){
                 printAskForWord();
             }else if(yn2.toLowerCase().equals("n")){
                 printSelectOption();
             }
         }else if(yn.toLowerCase().equals("n")){
             printThankYou();
         }
     }
     
     public void printThankYou(){
         System.out.println("            Thank you for your visiting.");
         System.out.println("               Come back again! xoxo");
     }
    
}
