/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tweetsearcher;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
//import twitter4j.TwitterException;

/**
 *
 * @author PS
 */
public class GUI1 extends javax.swing.JFrame {

    ArrayList<Tweet> searchData = new ArrayList<>();
    ArrayList<Tweet> resultData = new ArrayList<>();
    ResultSet defaultTweet_set;
    ResultSet rs;
    Searcher s = new Searcher();
    int searchCount=0;

    public GUI1() {

        initComponents();
        tweetTable.getTableHeader().setUI(null);
        historyTable.getTableHeader().setUI(null);
        
        TweetData tweet = new TweetData();
        searchData = tweet.getDataCollection();
        //s.setSearchData(searchData);
        //table.setVisible(false);
        //welcome.setVisible(true);
        //showDefaultTweet();
        setHistoryTable();
        history.setVisible(false);
        table.setVisible(false);
       // testQueryAllTweets();
    }
    
    public void testQueryAllTweets(){
        Connection con = TweetMain.getConnection();
        String sql = "select * from twitter_tweet";
        try {
            Statement stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while(rs.next()){
             int id = rs.getInt(1);
             String name = rs.getString(2);
             String tweet = rs.getString(3);
             String location = rs.getString(4);
             String device = rs.getString(5);
             String date = rs.getString(6);
             //Tweet e = new Tweet(id, name, tweet, location, date);
             //searchData.add(e);
             System.out.println("ID : " + id + " added to arrayList");
            }
            System.out.println("All id are added to arraylist named searchData");
           
        } catch (SQLException ex) {
            Logger.getLogger(GUI1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }

    public void showDefaultTweet() {
        Connection con = TweetMain.getConnection();
        try {
            Statement stm = con.createStatement();
            String sql = "select * from twitter_tweet limit 100";
            defaultTweet_set = stm.executeQuery(sql);
            int row = 0;
            while (defaultTweet_set.next()) {
                //user
                String userName = defaultTweet_set.getString(2);
                //tweet
                String tweet = defaultTweet_set.getString(3);
                tweetTable.setValueAt(userName, row, 0);
                tweetTable.setValueAt(tweet, row, 1);

                row++;
            }

        } catch (SQLException ex) {
            Logger.getLogger(GUI1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        result.setText("Tweets");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        TweetSearcher = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        searchBox = new javax.swing.JTextField();
        searchBy = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        searchBut = new javax.swing.JButton();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        table = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tweetTable = new javax.swing.JTable();
        result = new javax.swing.JLabel();
        welcome = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        history = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        historyTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(39, 57, 78));

        jPanel2.setBackground(new java.awt.Color(27, 39, 55));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TweetSearcher.setFont(new java.awt.Font("Sukhumvit Set", 1, 18)); // NOI18N
        TweetSearcher.setForeground(new java.awt.Color(255, 255, 255));
        TweetSearcher.setText("TWITTER SEARCHER");
        TweetSearcher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TweetSearcherMouseClicked(evt);
            }
        });
        jPanel2.add(TweetSearcher, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, 16));

        jPanel3.setBackground(new java.awt.Color(27, 39, 55));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(21, 30, 41), null));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchBox.setBackground(new java.awt.Color(39, 57, 78));
        searchBox.setForeground(new java.awt.Color(255, 255, 255));
        searchBox.setText(" Search...");
        searchBox.setBorder(null);
        searchBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchBoxMouseClicked(evt);
            }
        });
        jPanel3.add(searchBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 146, 20));

        searchBy.setForeground(new java.awt.Color(255, 255, 255));
        searchBy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Username", "Tweet", "Location" }));
        searchBy.setBorder(null);
        jPanel3.add(searchBy, new org.netbeans.lib.awtextra.AbsoluteConstraints(186, 9, 100, 25));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("by");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 13, -1, -1));

        searchBut.setBackground(new java.awt.Color(39, 57, 78));
        searchBut.setBorder(null);
        searchBut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchButMouseClicked(evt);
            }
        });
        searchBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButActionPerformed(evt);
            }
        });
        jPanel3.add(searchBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 20, 20));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 45, 331, 50));

        jLayeredPane1.setBackground(new java.awt.Color(255, 204, 204));

        table.setBackground(new java.awt.Color(39, 57, 78));

        tweetTable.setBackground(new java.awt.Color(39, 57, 78));
        tweetTable.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(39, 57, 78), new java.awt.Color(39, 57, 78)));
        tweetTable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tweetTable.setForeground(new java.awt.Color(255, 255, 255));
        tweetTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        tweetTable.setGridColor(new java.awt.Color(255, 255, 255));
        tweetTable.setInheritsPopupMenu(true);
        tweetTable.setRowHeight(20);
        tweetTable.setSelectionBackground(new java.awt.Color(39, 57, 78));
        tweetTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tweetTable.getTableHeader().setResizingAllowed(false);
        tweetTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tweetTable);

        result.setFont(new java.awt.Font("supermarket", 0, 14)); // NOI18N
        result.setForeground(new java.awt.Color(255, 255, 255));
        result.setText("found count");

        javax.swing.GroupLayout tableLayout = new javax.swing.GroupLayout(table);
        table.setLayout(tableLayout);
        tableLayout.setHorizontalGroup(
            tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
            .addGroup(tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(tableLayout.createSequentialGroup()
                    .addGap(132, 132, 132)
                    .addComponent(result, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(122, Short.MAX_VALUE)))
        );
        tableLayout.setVerticalGroup(
            tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tableLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
            .addGroup(tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(tableLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(result)
                    .addContainerGap(415, Short.MAX_VALUE)))
        );

        welcome.setBackground(new java.awt.Color(39, 57, 78));
        welcome.setPreferredSize(new java.awt.Dimension(330, 200));

        jLabel5.setFont(new java.awt.Font("supermarket", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Welcome to Twitter Searcher application.");

        jLabel2.setFont(new java.awt.Font("supermarket", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("You can search every tweet you want on this application");

        jLabel3.setFont(new java.awt.Font("supermarket", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Ready?");

        jLabel4.setFont(new java.awt.Font("supermarket", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Type a word you want to search !!");

        javax.swing.GroupLayout welcomeLayout = new javax.swing.GroupLayout(welcome);
        welcome.setLayout(welcomeLayout);
        welcomeLayout.setHorizontalGroup(
            welcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(welcomeLayout.createSequentialGroup()
                .addGroup(welcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(welcomeLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel5))
                    .addGroup(welcomeLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel2)))
                .addGap(0, 16, Short.MAX_VALUE))
            .addGroup(welcomeLayout.createSequentialGroup()
                .addGroup(welcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(welcomeLayout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(welcomeLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabel4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        welcomeLayout.setVerticalGroup(
            welcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(welcomeLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap(456, Short.MAX_VALUE))
        );

        history.setBackground(new java.awt.Color(39, 57, 78));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("Recent searches");

        historyTable.setBackground(new java.awt.Color(39, 57, 78));
        historyTable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        historyTable.setForeground(new java.awt.Color(255, 255, 255));
        historyTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        historyTable.setRowHeight(25);
        historyTable.setShowHorizontalLines(false);
        historyTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                historyTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(historyTable);

        javax.swing.GroupLayout historyLayout = new javax.swing.GroupLayout(history);
        history.setLayout(historyLayout);
        historyLayout.setHorizontalGroup(
            historyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(historyLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(historyLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 27, Short.MAX_VALUE))
        );
        historyLayout.setVerticalGroup(
            historyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(historyLayout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(187, Short.MAX_VALUE))
        );

        jLayeredPane1.setLayer(table, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(welcome, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(history, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(history, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addComponent(welcome, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 8, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addComponent(table, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 152, Short.MAX_VALUE)))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(history, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(55, 55, 55)
                    .addComponent(welcome, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(139, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(4, 4, 4)
                    .addComponent(table, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 531, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void searchButMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchButMouseClicked

        search();
        showResult();
        table.setVisible(true);
        welcome.setVisible(false);
    }//GEN-LAST:event_searchButMouseClicked

    private void TweetSearcherMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TweetSearcherMouseClicked
        table.setVisible(false);
        welcome.setVisible(true);
    }//GEN-LAST:event_TweetSearcherMouseClicked

    private void searchButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchButActionPerformed

    private void historyTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_historyTableMouseClicked
        searchFromHistory();
    }//GEN-LAST:event_historyTableMouseClicked

    private void searchBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBoxMouseClicked
        if(searchCount > 0) history.setVisible(true);
    }//GEN-LAST:event_searchBoxMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI1().setVisible(true);
            }
        });
    }

    public void clearTable() {
        tweetTable.clearSelection();
    }
    public void search(){
        searchCount++;
        this.clearTable();
        String word = searchBox.getText();
        String searchByText = (String) searchBy.getSelectedItem();
        if (searchByText.equals("Username")) {
           resultData = s.searchByName(word);
        } else if (searchByText.equals("Tweet")) {
           resultData = s.searchByTweet(word);
           // same as above
        }
    
        
    }

//    public void search() {
//        String word = searchBox.getText();
//        String searchByText = (String) searchBy.getSelectedItem();
//        if (searchByText.equals("Username")) {
//            s.searchByUsername(word);
//        } else if (searchByText.equals("Tweet")) {
//            s.searchByTweet(word);
//        }
//        resultData = s.getSearchResult();
//        showResult();
//    }

    public void showResult() {
        history.setVisible(false);
        tweetTable.setVisible(true);
        setTweetTableRow(resultData.size());
        clearTable(tweetTable);
        Iterator it = resultData.iterator();
        System.out.println(resultData.size());

        int i = 0;
        while (it.hasNext()) {
            int j = 0;
            Tweet tw = (Tweet) it.next();
            tweetTable.setValueAt(tw.getUser(), i, j++);
            tweetTable.setValueAt(tw.getTweet(), i++, j);
        }

        result.setText(resultData.size() + " results");
        
        showHistory();
    }

    public static void clearTable(JTable table) {
        for (int i = 0; i < table.getRowCount(); i++)
            for(int j = 0; j < table.getColumnCount(); j++) {
              table.setValueAt("", i, j);
          }
    }
    
    public void setTweetTableRow(int s) {
        int row = s;

        if (row <= 6) {
            row = 6;
        }

        Object[][] r = new Object[row][2];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < 2; j++) {
                r[i][j] = null;
            }
        }

        tweetTable.setModel(new javax.swing.table.DefaultTableModel(r,
                new String[]{
                    "Username", "Tweet"
                }
        ));

        tweetTable.getColumnModel().getColumn(1).setCellRenderer(new TextAreaRenderer());
        tweetTable.setRowHeight(60);
        tweetTable.getColumnModel().getColumn(0).setMaxWidth(96);
        tweetTable.getColumnModel().getColumn(1).setMaxWidth(240);
        tweetTable.setGridColor(new java.awt.Color(27, 39, 55));
        tweetTable.setShowGrid(true);

    }
    
    public void setHistoryTable(){
        historyTable.getColumnModel().getColumn(0).setMaxWidth(246);
        historyTable.getColumnModel().getColumn(1).setMaxWidth(90);
        historyTable.setGridColor(new java.awt.Color(39,57,78));
        historyTable.setBorder(null);
        //historyTable.setShowGrid(true);
    }
    
    public void showHistory(){
        Set userHis = s.getMapName().keySet();
        Iterator userIt = (Iterator) userHis.iterator();
        int i=0;
        while(userIt.hasNext()){
            int j=0;
            String historyWord = (String) userIt.next();
            historyTable.setValueAt(historyWord, i, j++);
            historyTable.setValueAt("by username", i++, j);
        }
        
        Set wordHis = s.getMapWord().keySet();
        Iterator wordIt = (Iterator) wordHis.iterator();
        while(wordIt.hasNext()){
            int j=0;
            String historyWord = (String) wordIt.next();
            historyTable.setValueAt(historyWord, i, j++);
            historyTable.setValueAt("by tweet", i++, j);
        }
        
        Set locationHis = s.getMapLocation().keySet();
        Iterator locationIt = (Iterator) locationHis.iterator();
        while(locationIt.hasNext()){
            int j=0;
            String historyWord = (String) locationIt.next();
            historyTable.setValueAt(historyWord, i, j++);
            historyTable.setValueAt("by location", i++, j);
        }
    }

    public void searchFromHistory(){
        tweetTable.setVisible(false);
        int row=-1;
        
        if(historyTable.getSelectedRow()>=0){
            row=historyTable.getSelectedRow();
            String chooseWord = (String) historyTable.getValueAt(row, 0);
            
            if(historyTable.getValueAt(row, 1).equals("by username")){
                resultData = s.getMapName().get(chooseWord);
            }else if(historyTable.getValueAt(row, 1).equals("by tweet")){
                resultData = s.getMapWord().get(chooseWord);
            }else if(historyTable.getValueAt(row, 1).equals("by location")){
                resultData = s.getMapLocation().get(chooseWord);
            }
            
            searchBox.setText("");
            showResult();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TweetSearcher;
    private javax.swing.JPanel history;
    private javax.swing.JTable historyTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel result;
    private javax.swing.JTextField searchBox;
    private javax.swing.JButton searchBut;
    private javax.swing.JComboBox<String> searchBy;
    private javax.swing.JPanel table;
    private javax.swing.JTable tweetTable;
    private javax.swing.JPanel welcome;
    // End of variables declaration//GEN-END:variables
}
