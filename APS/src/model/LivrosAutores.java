/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;

/**
 *
 * @author F Will
 */
public class LivrosAutores {
    private String isbn;
    private int autor_id;
    private int seq_no;
    
    private Conexao conn;
    private ResultSet result;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getAutor_id() {
        return autor_id;
    }

    public void setAutor_id(int autor_id) {
        this.autor_id = autor_id;
    }

    public Conexao getConn() {
        return conn;
    }

    public void setConn(Conexao conn) {
        this.conn = conn;
    }

    public ResultSet getResult() {
        return result;
    }

    public void setResult(ResultSet result) {
        this.result = result;
    }
    public int getSeq_no() {
        return seq_no;
    }

    public void setSeq_no(int seq_no) {
        this.seq_no = seq_no;
    }
    
    
    
    
    
    public String insert(Conexao conn,String isbn,int autor_id, int seq_no){
        String res;
        
        res = conn.executeCommand("insert into BooksAuthors (isbn,author_id,seq_no) values ('"+isbn+"','"+autor_id+"','"+seq_no+"');");
        
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

        

