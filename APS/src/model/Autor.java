/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author vinicius
 */
public class Autor{
    
    private ResultSet result;
    private String fname;
    private String name;
    private int authorId;
    private Conexao conn;
    

    
    
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
    
    
    
    public String Validate(String name, String fname){
        Convert validar = new Convert();
        
        if(name.length() > 25){
            JOptionPane.showMessageDialog(null, "O nome do autor deve ter no máximo 25 caracters!");
            return "O nome do autor deve ter no máximo 25 caracters";
        }
        if(fname.length() > 25){
            JOptionPane.showMessageDialog(null, "O sobrenome do autor do livro deve ter no máximo 25 caracters!");
            return "O sobrenome do autor do livro deve ter no máximo 25 caracters";
        }
        if(validar.isOnlyString(name) == false || validar.isOnlyString(fname) == false){
            JOptionPane.showMessageDialog(null, "Nome ou sobrenome Inválido!");
            return "Nome ou sobrenome Inválido!";
        }
        
        return "Sucesso";
    }
    
    public String insert(Conexao conn, String name, String fname){
        String res;
        
        res = Validate(name, fname);
        
        if(res.equals("Sucesso")){
            conn.executeCommand("insert into authors (name,fname) "
                    + "values ('" + name + "','" + fname + "');");
            return "Sucesso";
            
        }
        
        return res;
    
    }
    
    public String delete(Conexao conn,String whereClause){
        String res;
        if(whereClause.equals("")){
            res = conn.executeCommand("delete from authors");
        }else{
            res = conn.executeCommand("delete from authors where "+ whereClause);
        }
        
        return res;
        
    }
    
    public String update(Conexao conn,String setClause,String whereClause){
        String res;
        if(whereClause.equals("")){
            res = conn.executeCommand("update authors set "+setClause);
        }else{
            res = conn.executeCommand("update authors set "+setClause+" where "+ whereClause) + ";";
        }
        return res;
        
    }
    
    public String select(Conexao conn,String whereClause){
        String res;
        if(whereClause.equals("")){
            res = conn.executeCommand("select * from authors");
        }else{
            res = conn.executeCommand("select * from authors where "+whereClause);
        }
        
        if(res.equals("Sucesso")){
            ResultSet result = conn.getResult();
            this.result = result;
            
        }
        return res;
    }
    
    
    
    
    
    
    
}
