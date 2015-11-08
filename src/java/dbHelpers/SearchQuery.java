/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbHelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Actors;

public class SearchQuery {
    
    private Connection conn;
    private ResultSet results;
    
    public SearchQuery(){
        
        Properties props = new Properties(); //MWC
        InputStream instr = getClass().getResourceAsStream("dbConn.properties");
        
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    String driver = props.getProperty("driver.name");
    String url = props.getProperty("server.name");
    String username = props.getProperty("user.name");
    String passwd = props.getProperty("user.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void doSearch(String actorName){
        
            String query = "Select * From actors WHERE UPPER(actorName) LIKE ? ORDER BY actorID ASC";
            
            PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(query);
        } catch (SQLException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ps.setString(1, "%" + actorName.toUpperCase() + "%");
        } catch (SQLException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            this.results = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public String getHTMLtable(){
        
        String table = "";
        table += "<table>";
                 table += "<th>";
                table += "Actor ID";
                table += "</th>";
                
                table += "<th>";
                table += "Actor Name";
                table += "</th>";
                
                table += "<th>";
                table += "Nationality";
                table += "</th>";
                
                table += "<th>";
                table += "Age";
                table += "</th>";
                
                table += "<th>";
                table += "Birthday";
                table += "</th>";
                
                table += "<th>";
                table += "";
                table += "</th>";
        try {
            while(this.results.next()){
                
                Actors actor = new Actors();
                actor.setActorID(this.results.getInt("actorID"));
                actor.setActorName(this.results.getString("actorName"));
                actor.setNationality(this.results.getString("nationality"));
                actor.setAge(this.results.getInt("age"));
                actor.setBirthday(this.results.getString("birthday"));
                
                table += "<tr>";
                
                table += "<td>";
                table += actor.getActorID();
                table += "</td>";
                
                table += "<td>";
                table += actor.getActorName();
                table += "</td>";
                
                table += "<td>";
                table += actor.getNationality();
                table += "</td>";
                
                table += "<td>";
                table += actor.getAge();
                table += "</td>";
                
                table += "<td>";
                table += actor.getBirthday();
                table += "</td>";
                
                table += "<td>";
                table += "<a href=update?actorID=" + actor.getActorID() + "> Update </a>" + "<a href=delete?actorID=" + actor.getActorID() + "> Delete </a>";
                table += "</td>";
                
                table += "</tr>";
            }
        } catch (SQLException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        table += "</table>";
                
                return table;
    
    }
    
}
