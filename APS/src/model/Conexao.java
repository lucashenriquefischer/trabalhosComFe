/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;


/**
 *
 * @author fischer
 */
public class Conexao {
    private String host;
    private String database;
    private String user;
    private String pwd;
    private ResultSet result;

    public String getHost() {
        return host;
    }

    public String getDatabase() {
        return database;
    }

    public String getUser() {
        return user;
    }

    public String getPwd() {
        return pwd;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setResult(ResultSet result) {
        this.result = result;
    }

    public ResultSet getResult() {
        return result;
    }

    public Conexao(String host, String database, String user, String pwd) {
        this.host = host;
        this.database = database;
        this.user = user;
        this.pwd = pwd;
    }
    
    public  Connection getConnection()throws SQLException,ClassNotFoundException {
        try{
            Class.forName("org.postgresql.Driver");
        
            String url = "jdbc:postgresql://"+getHost()+"/"+getDatabase();
            Properties prop = new Properties();
            prop.setProperty("user", getUser());
            prop.setProperty("password",getPwd());
            return DriverManager.getConnection(url,prop);
        }catch (SQLException e){
            throw new SQLException("Erro de conexão:\t" + e.getMessage());
        }catch (ClassNotFoundException e){
            throw new SQLException("ClassNotFound:\t" + e.getMessage());
        }
    }
    
//    public static Connection getConnection()throws SQLException,ClassNotFoundException {
//        try{
//            Class.forName("org.postgresql.Driver");
//        
//            String url = "jdbc:postgresql://localhost/APS";
//            Properties prop = new Properties();
//            prop.setProperty("user", "postgres");
//            prop.setProperty("password","1234");
//            return DriverManager.getConnection(url,prop);
//        }catch (SQLException e){
//            throw new SQLException("Erro de conexão:\t" + e.getMessage());
//        }catch (ClassNotFoundException e){
//            throw new SQLException("ClassNotFound:\t" + e.getMessage());
//        }
//    }
    
     public String executeCommand (String SQL){
        try{
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(SQL);
            ResultSet result = stmt.executeQuery();
            setResult(result);
            conn.close();
            return "Sucesso";
        }catch(SQLException e){
            return "SQLException:\t"+e.getMessage();
        }catch(ClassNotFoundException e){
            return "ClassNotFoundException:\t"+e.getMessage();
        }
     }
}
