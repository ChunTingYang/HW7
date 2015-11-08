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

/**
 *
 * @author Chun-Ting Yang
 */
public class ReadRecord {
    
    private Connection conn;
    private ResultSet results;
    
    private Actors actor = new Actors();
    private int actorID;
    
    public ReadRecord(int actorID){
    
    Properties props = new Properties(); //MWC
    InputStream instr = getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    String driver = props.getProperty("driver.name");
    String url = props.getProperty("server.name");
    String username = props.getProperty("user.name");
    String passwd = props.getProperty("user.password");
    
    this.actorID = actorID;
    
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void doRead(){
        
        try {
            String query = "SELECT * FROM actors WHERE actorID = ?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setInt(1, actorID);
            
            this.results = ps.executeQuery();
            
            this.results.next();
            
            actor.setActorID(this.results.getInt("actorID"));
            actor.setActorName(this.results.getString("actorName"));
            actor.setNationality(this.results.getString("nationality"));
            actor.setAge(this.results.getInt("age"));
            actor.setBirthday(this.results.getString("birthday"));
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        }
    
    public Actors getActor(){
        
        return this.actor;
    }
    }
