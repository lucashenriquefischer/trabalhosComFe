/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;

/**
 *
 * @author fischer
 */
public class Livros{
    
    private ResultSet result;
    private String title;
    private String isbn;
    private int publisherId;
    private double price;
    private Conexao conn;

    public ResultSet getResult() {
        return result;
    }

    public void setResult(ResultSet result) {
        this.result = result;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Conexao getConn() {
        return conn;
    }

    public void setConn(Conexao conn) {
        this.conn = conn;
    }
    
    
    
    public String Validate(String title,String isbn){
        if(title.length() > 60){
            return "O título do livro deve ter no máximo 60 caracters";
        }
        if(isbn.length() > 13){
            return "O ISBN do livro deve ter no máximo 13 caracters";
        }
        
        return "Sucesso";
    }
    
    public String insert(Conexao conn, String title, String isbn, int publisherId, double price){
        String res;
        
        res = Validate(title, isbn);
        
        if(res.equals("Sucesso")){
            res = conn.executeCommand("insert into books (title,isbn,publisher_id,price) "
                    + "values ('" + title + "','" + isbn + "'," + publisherId + "," + price + ");");
        }
        
        return res;
    
    }
    
    public String delete(Conexao conn,String whereClause){
        String res;
        if(whereClause.equals("")){
            res = conn.executeCommand("delete from books");
        }else{
            res = conn.executeCommand("delete from books where "+ whereClause);
        }
        
        return res;
        
    }
    
    public String update(Conexao conn,String setClause,String whereClause){
        String res;
        if(whereClause.equals("")){
            res = conn.executeCommand("update books set "+setClause);
        }else{
            res = conn.executeCommand("update books set "+setClause+" where "+ whereClause) + ";";
        }
        return res;
        
    }
    
    public String select(Conexao conn,String whereClause){
        String res;
        if(whereClause.equals("")){
            res = conn.executeCommand("select * from books");
        }else{
            res = conn.executeCommand("select * from books where "+whereClause);
        }
        
        if(res.equals("Sucesso")){
            ResultSet result = conn.getResult();
            this.result = result;
            
        }
        return res;
    }
    
    
    
    
    
    
    
}
