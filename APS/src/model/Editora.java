/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author fischer
 */

public class Editora {
    
    private ResultSet result;

    public Editora() {
        
    }

    public ResultSet getResult() {
        return result;
    }
    public void setResult(ResultSet result){
        this.result = result;
    }
    public String Validate(String name,String url){
        if(name.length() > 30){
            return "O nome da editora deve ter no máximo 30 caracters";
        }
        if(url.length() > 80){
            return "a URL da editora deve ter no máximo 80 caracters";
        }
        
        return "Sucesso";
    }
    
    public String insert(Conexao conn,String name,String url){
        String res;
        
        res = Validate(name, url);
        
        if(res.equals("Sucesso")){
            res = conn.executeCommand("insert into publishers (name,url) values ('"+name+"','"+url+"')");
        }
        
        return res;
    
    }
    
    public String delete(Conexao conn,String whereClause){
        String res;
        if(whereClause.equals("")){
            res = conn.executeCommand("delete from publishers");
        }else{
            res = conn.executeCommand("delete from publishers where "+ whereClause);
        }
        
        return res;
        
    }
    
    public String update(Conexao conn,String setClause,String whereClause){
        String res;
        if(whereClause.equals("")){
            res = conn.executeCommand("update publishers set "+setClause);
        }else{
            res = conn.executeCommand("update publishers set "+setClause+" where "+ whereClause);
        }
        return res;
        
    }
    
    public String select(Conexao conn,String whereClause){
        String res;
        if(whereClause.equals("")){
            res = conn.executeCommand("select * from publishers");
        }else{
            res = conn.executeCommand("select * from publishers where "+whereClause);
        }
        
        if(res.equals("Sucesso")){
            ResultSet result = conn.getResult();
            this.result = result;
            
        }
        return res;
    }
}
