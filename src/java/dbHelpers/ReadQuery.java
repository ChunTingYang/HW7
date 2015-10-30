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

public class ReadQuery {
    
    private Connection conn;
    private ResultSet results;
    
    public ReadQuery(){
        
    Properties props = new Properties(); //MWC
    InputStream instr = getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    String driver = props.getProperty("driver.name");
    String url = props.getProperty("server.name");
    String username = props.getProperty("user.name");
    String passwd = props.getProperty("user.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void doRead(){
        
        try {
            String query = "Select * from actors";
            
            PreparedStatement ps = conn.prepareStatement(query);
            this.results = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getHTMLtable(){
        
        String table = "";
        table += "<table border=1>";
        
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
                
                table += "</tr>";
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        table += "</table>";
                
                return table;
    
    
    }
    
}
