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
public class teste {

    public static void main(String[] args) {
//        Conexao conn = new Conexao("localhost", "APS", "postgres", "1234");
//        String res = conn.executeCommand("select * from publishers");
//        if(res.equals("Sucesso")){
//            ResultSet result = conn.getResult();
//            try{
//                while (result.next()) {
//                    System.out.println(result.getString("name"));
//                }
//            }catch(SQLException e){
//                System.out.println(e.getMessage());
//            }
//        }else{
//            
//        }
        String str = "123454,3452312,2123,34234235,35463565,7678,34525,32536,6446,4";
        str.replaceAll("\\([0-9]+)", "'$1'");
        System.out.println(str);
//        Editora edit = new Editora();
//        boolean verdade = edit.getList("select * from publishers");
//        ResultSet result = edit.result;
        
    }
}
