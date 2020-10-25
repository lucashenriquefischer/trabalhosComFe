/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;

/**
 *
 * @author vinicius
 */
public class Autor{
    
    private ResultSet result;
    private String fname;
    private String name;
    private int authorId;
    
    

    
    
    public ResultSet getResult() {
        return result;
    }

    public void setResult(ResultSet result) {
        this.result = result;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname ) {
        this.fname = fname;
    }

    
    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Conexao getConn() {
        return conn;
    }

    public void setConn(Conexao conn) {
        this.conn = conn;
    }
    
    
    
    public String Validate(String name,String fname){
        if(name.length() > 30){
            return "O sobre nome do autor do livro deve ter no máximo 30 caracters";
        }
        if(fname.length() > 30){
            return "O nome do autor deve ter no máximo 30 caracters";
        }
        
        return "Sucesso";
    }
    
    public String insert(Conexao conn, String name, String fname, int authorId){
        String res;
        
        res = Validate(name, fname);
        
        if(res.equals("Sucesso")){
            conn.executeCommand("insert into author (name,fname,author_id) "
                    + "values ('" + name + "','" + fname + "'," + authorId + ");");
            return "Sucesso";
            
        }
        
        return res;
    
    }
    
    public String delete(Conexao conn,String whereClause){
        String res;
        if(whereClause.equals("")){
            res = conn.executeCommand("delete from author");
        }else{
            res = conn.executeCommand("delete from author where "+ whereClause);
        }
        
        return res;
        
    }
    
    public String update(Conexao conn,String setClause,String whereClause){
        String res;
        if(whereClause.equals("")){
            res = conn.executeCommand("update author set "+setClause);
        }else{
            res = conn.executeCommand("update author set "+setClause+" where "+ whereClause) + ";";
        }
        return res;
        
    }
    
    public String select(Conexao conn,String whereClause){
        String res;
        if(whereClause.equals("")){
            res = conn.executeCommand("select * from author");
        }else{
            res = conn.executeCommand("select * from author where "+whereClause);
        }
        
        if(res.equals("Sucesso")){
            ResultSet result = conn.getResult();
            this.result = result;
            
        }
        return res;
    }
    
    
    
    
    
    
    
}
