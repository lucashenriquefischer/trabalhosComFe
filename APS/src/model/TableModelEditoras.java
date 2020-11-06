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

/**
 *
 * @author F Will
 */
public class TableModelEditoras extends AbstractTableModel{
    // ---- Classe para gerar um modelo abstrato de tabela ---- //
    
    private static List<Editora> dados = new ArrayList<>(); //ArrayList armazenando as editoras
    private String valorAnterior = ""; //Variável para se armazenara cláusula WHERE
    private String valorNovo = ""; //Variável para se armazenar a cláusula SET
    private String[] colunas = {"Nome","URL"}; //Nome das colunas do JTable
    private String[] colunasBD = {"publisher_id", "name", "url"};//Array de Strings com os nomes das colunas no BD

    
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
                return dados.get(linha).getNome();
            case 1:
                return dados.get(linha).getUrl();
        }
        return null;
    }
    
    public void addRow(Editora editora2){
        //Método para adicionar linhas na tabela. Mas aqui ele realmente adiciona no arrayList e 
        //o método getValueAt() que faz o trabalho de adicionar, retornando os dados do arryList para a tabela
        this.dados.add(editora2);
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
        this.valorAnterior = this.colunasBD[coluna+1] + " = " + "'" + (String)this.getValueAt(linha, coluna) + "'";
        this.valorNovo = this.colunasBD[coluna+1] + " = " + "'" + (String)valor + "'";
        //--------------------------//
        
        if( valor == null){ return;} //verifica se o parametro a ser alterado é nulo. Se for, não permite alteração
        
        //JOptionPane, gera uma tela de confirmação do valor a ser alterado
        int verificacao = JOptionPane.showConfirmDialog(null, "O "+ this.colunas[coluna] + " \"" + this.getValueAt(linha, coluna) + "\" será alterado"
                + " para \"" + valor + "\"\nConfirmar?","AVISO!", JOptionPane.YES_NO_OPTION);
        if(verificacao == 0){ 
            //Faz a verificação caso a confirmação no JOptionPane seja positiva. Se for, ele altera a célula atravéso Switch Case.
            switch(coluna){
            case 0:  
                dados.get(linha).setNome( (String) valor);
                break;
            case 1:  
                dados.get(linha).setUrl((String) valor);
                break;
        }
            dados.get(linha).update(dados.get(linha).getConn(), valorNovo, valorAnterior);//Executa o comando update no BD
            this.fireTableRowsUpdated(linha, linha); //Atualiza as linhas do JTable. Mas acho que está sendo inútil
            
        }
        else{
            //Caso a confirmação no JOptionPane for negativa, ele não executa a alteração
            return;
        }
    }
    
    public void Deletar(Conexao conn, String nome, String url, int linha){
        for(int i = 0; i < dados.size(); i++){
            if(nome.equals(dados.get(i).getNome()) && url.equals(dados.get(i).getUrl())){
                String res = dados.get(i).delete(conn, "name = '"+ nome + "' AND url = '" + url + "';");
                if(res.contains("ERROR")){
                    JOptionPane.showMessageDialog(null, "Não foi possível excluir a Editora");
                }else{
                    dados.remove(i);
                }
            }
        }
        this.fireTableRowsDeleted(linha, linha);
    }

    public static List<Editora> getDados() {
        //Retorna o arraylist. Caso alguma outra classe necessite dos dados de editoras
        return dados;
    }
    
    
    
    
}
