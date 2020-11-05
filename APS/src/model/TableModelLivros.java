/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import view.formIncluir;

/**
 *
 * @author F Will
 */
public class TableModelLivros extends AbstractTableModel{
    //Criação da Tabela livros
    
    // ---- Classe para gerar um modelo abstrato de tabela ---- //
    
    private static final List<Livros> dados = new ArrayList<>(); //ArrayList armazenando as livros
    private String valorAnterior = ""; //Variável para se armazenara cláusula WHERE
    private String valorNovo = ""; //Variável para se armazenar a cláusula SET
    private String[] colunas = {"Titulo","ISBN","Preço"}; //Nome das colunas do JTable
    private String[] colunasBD = {"title" , "isbn", "price"};//Array de Strings com os nomes das colunas no BD

    
    @Override
    public String getColumnName(int column) {
        //Adiciona nomes as colunas. Os nomes ficaram armazenados no array de String[] colunas
        return colunas[column]; 
    }
    
    @Override
    public int getRowCount() {
        //Adiciona o número de Linhas na Tabela. A quantidade de linhas é definidas pela quantidade de dados no ArrayList<> dados
        //Esse é um método do AbstractTableModel onde sua implementação é obrigatória
        return dados.size(); 
    }

    @Override
    public int getColumnCount() {
        //Adiciona o número de colunas na tabela. A quantidade de colunas é definida pelo tamanho do Array de String[] colunas
        //Esse é um método do AbstractTableModel onde sua implementação é obrigatória
        return colunas.length;
    }
    
    
    
    @Override
    public Object getValueAt(int linha, int coluna) {
        //Adiciona os valores do ArrayList dados na tabela. Esse é um método do AbstractTableModel onde sua implementação é obrigatória
        // o switch funciona QUASE como um for. Não sei explicar na escrita, mas funciona :)
        switch(coluna){
            case 0:
//                System.out.println("teste01");
                return dados.get(linha).getTitle();
            case 1:
//                System.out.println("test02");
                return dados.get(linha).getIsbn();
            case 2:
//                System.out.println("teste03");
                return dados.get(linha).getPrice();
        }
        this.fireTableRowsInserted(linha, linha);
        return null;
    }
    
    public void addRow(Livros livro2){
        //Método para adicionar linhas na tabela. Mas aqui ele realmente adiciona no arrayList e 
        //o método getValueAt() que faz o trabalho de adicionar, retornando os dados do arryList para a tabela
        this.dados.add(livro2);
        this.fireTableDataChanged(); //Atualiza a tabela 
        
    }
    
        
    
    @Override
    public boolean isCellEditable(int linha, int coluna) {
        //metodo que permite alguma coluna ser editavel
        //metódo do próprio AbstractTableModel
        
        if(coluna == 0 || coluna == 1 || coluna == 2){
            return true;
        }
 
        return false;
    }
    
   
    @Override
    public void setValueAt(Object valor, int linha, int coluna){
        //Metodo para alterar dados da tabela diretamente nela
        //metódo do próprio AbstractTableModel
        
        //Cláusulas para modificar os valores no BD
        this.valorAnterior = this.colunasBD[coluna] + " = " + "'" + this.getValueAt(linha, coluna) + "'";
        this.valorNovo = this.colunasBD[coluna] + " = " + "'" + valor + "'";
        //--------------------------//
        
        System.out.println("Valor Novo: " + valorNovo);//Apagar posteriormente
        
        if( valor == null){ return;} //verifica se o parametro a ser alterado é nulo. Se for, não permite alteração
        
        //JOptionPane, gera uma tela de confirmação do valor a ser alterado
        int verificacao = JOptionPane.showConfirmDialog(null, "O valor: " + valor + " será alterado. Confirmar?");
        if(verificacao == 0){ 
            //Faz a verificação caso a confirmação no JOptionPane seja positiva. Se for, ele altera a célula atravéso Switch Case.
            boolean verifica = VerificaIsbn(valor.toString());//Verifica se existe o isbn a ser modificado existe no BD
            if(verifica == false){
                switch(coluna){
                case 0:  
                    dados.get(linha).setTitle((String) valor);
                    break;
                case 1:  
                    dados.get(linha).setIsbn((String) valor);
                    break;
                case 2:  
                    dados.get(linha).setPrice(Double.parseDouble((String) valor));
                    break;
                }
            
                dados.get(linha).update(dados.get(linha).getConn(), valorNovo, valorAnterior);//Executa o comando update no BD
                this.fireTableRowsUpdated(linha, linha); //Atualiza as linhas do JTable. Mas acho que está sendo inútil
            }else{
                JOptionPane.showMessageDialog(null, "Esse ISBN já Existe!");
            }
        }
        else{
            //Caso a confirmação no JOptionPane for negativa, ele não executa a alteração
            return;
        }
        
        System.out.println("Valor antigo: " + valorAnterior);//Apagar posteriormente.
         
        
    }
    
    public void Deletar(Conexao conn, String isbn, int linha){
        
        for(int i = 0; i < dados.size(); i++){
            if(isbn.equals(dados.get(i).getIsbn())){
                String res = dados.get(i).delete(conn, "isbn = '"+ isbn + "';");
                if(res.contains("ERROR")){
                    JOptionPane.showMessageDialog(null, "Não foi possivel excluir o livro");
                }else{
                    dados.remove(i);
                }
            }
        }
        this.fireTableRowsDeleted(linha, linha);
    }
    
    public boolean VerificaIsbn(String isbn){
        //Trata a existencia de ISBN's iguais
        for(Livros book: this.dados){
            if(book.getIsbn().equals(isbn)){
                return true;
            }
        }
        return false;
    }
    
        
    public static List<Livros> getDados() {
        //Retorna o arraylist. Caso alguma outra classe necessite dos dados de editoras
        return dados;
    }
}
