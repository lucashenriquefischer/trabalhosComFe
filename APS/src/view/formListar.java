/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Conexao;
import model.Editora;
import model.Livros;
import model.TableModel;
import model.TableModelLivros;

/**
 *
 * @author fischer
 */
public class formListar extends javax.swing.JFrame {
    //Instancia as classes TableModel, com o modelo de tabela definida de acordo com nossa necessidade
    private static TableModel modelo = new TableModel(); //Instancia o modelo de tabela para editora
    private static TableModelLivros modeloLivros = new TableModelLivros(); //Instancia um modelo de tabela para Livros
    private static Conexao conn = new Conexao("localhost", "APS", "postgres", "Will"); // faz a conexão com o BD
    // ------------------------------- //
    /**
     * Creates new form formListar
     */
    public formListar() {
        initComponents();
        TableEditoras.setCellSelectionEnabled(true); //Torna uma única célula da Table selecionável
        TableEditoras.setModel(modelo); // Seta o modelo o criado na classe TableModel.java na tabela (JTable)
        
        TableLivros.setCellSelectionEnabled(true); //Torna uma única célula da Table selecionável
        TableLivros.setModel(modeloLivros); // Seta o modelo o criado na classe TableModel.java na tabela (JTable)
        
        PreencherTable();
        
    }
    
    public static void PreencherTable(){
        // --- Listar as Editoras --- //
        
        Editora editora = new Editora(); 
        String res;
        res = editora.select(conn, ""); //executa o comando select no BD
        if (res.equals("Sucesso")) {
            ResultSet result = editora.getResult(); // Pega os resultados do select
            try {
                while (result.next()) { 

                    Editora editora2 = new Editora(); // Cria um novo objeto do tipo editora com os resultados do select, para popular a tabela através desse objeto
                    editora2.setId(Integer.parseInt(result.getString("publisher_id")));
                    editora2.setNome(result.getString("name").trim()); 
                    editora2.setUrl(result.getString("url").trim());
                    editora2.setConn(conn);
                    modelo.addRow(editora2); //Metodo chamada para popular as tabelas
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(formListar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        // --- Listar Livros --- //
        
        Livros livro = new Livros(); 
        String res2;
        res2 = livro.select(conn, ""); //executa o comando select no BD
        if (res2.equals("Sucesso")) {
            ResultSet result = livro.getResult(); // Pega os resultados do select
            try {
                while (result.next()) { 

                    Livros livro2 = new Livros(); // Cria um novo objeto do tipo Livro com os resultados do select, para popular a tabela através desse objeto
                    livro2.setTitle(result.getString("title").trim());
                    livro2.setIsbn(result.getString("isbn").trim()); 
                    livro2.setPublisherId(Integer.parseInt(result.getString("publisher_id")));
                    livro2.setPrice(Double.parseDouble(result.getString("price").trim()));
                    livro2.setConn(conn);
                    modeloLivros.addRow(livro2); //Metodo chamada para popular as tabelas
                }
            }catch (SQLException ex) {
                Logger.getLogger(formListar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
   
    public void AtualizaTable(){
        TableModel.getDados().clear();//Limpa os dados do Array
        TableModelLivros.getDados().clear();
        
        modelo.fireTableDataChanged();//Atualiza alterações na tabela
        modeloLivros.fireTableDataChanged();
        
        PreencherTable();//Chama o método para preencher novamente as tabelas
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        buttonExcluirEditora = new javax.swing.JButton();
        ButtonInserirEditora = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableEditoras = new javax.swing.JTable();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        ButtonExcluirLivro = new javax.swing.JButton();
        buttonInserirLivro = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableLivros = new javax.swing.JTable();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton10 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton4.setText("Modificar");

        buttonExcluirEditora.setText("Excluir");
        buttonExcluirEditora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExcluirEditoraActionPerformed(evt);
            }
        });

        ButtonInserirEditora.setText("Incluir");
        ButtonInserirEditora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonInserirEditoraActionPerformed(evt);
            }
        });

        TableEditoras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TableEditoras.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(TableEditoras);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonExcluirEditora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButtonInserirEditora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(35, 35, 35))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addGap(4, 4, 4)
                        .addComponent(ButtonInserirEditora)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonExcluirEditora)))
                .addContainerGap(215, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("tab1", jPanel3);

        jTabbedPane1.addTab("Editora", jTabbedPane3);

        jButton7.setText("Modificar");

        ButtonExcluirLivro.setText("Excluir");
        ButtonExcluirLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonExcluirLivroActionPerformed(evt);
            }
        });

        buttonInserirLivro.setText("Incluir");
        buttonInserirLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInserirLivroActionPerformed(evt);
            }
        });

        TableLivros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(TableLivros);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ButtonExcluirLivro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonInserirLivro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(35, 35, 35))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton7)
                        .addGap(4, 4, 4)
                        .addComponent(buttonInserirLivro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ButtonExcluirLivro)))
                .addContainerGap(215, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("tab1", jPanel2);

        jTabbedPane1.addTab("Livro", jTabbedPane4);

        jButton1.setText("Modificar");

        jButton2.setText("Excluir");

        jButton3.setText("Incluir");

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(35, 35, 35))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(4, 4, 4)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)))
                .addContainerGap(215, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("tab1", jPanel1);

        jTabbedPane1.addTab("Autor", jTabbedPane2);

        jButton10.setText("jButton10");
        jTabbedPane1.addTab("tab4", jButton10);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonInserirLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInserirLivroActionPerformed
        //Botão Inserir Livro
        formIncluir form = new formIncluir();
        form.setVisible(true); //Abre o form de incluir 
        form.getTabbedPane().setSelectedIndex(2);//Seleciona a aba de incluir um novo livro

    }//GEN-LAST:event_buttonInserirLivroActionPerformed

    private void ButtonExcluirLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonExcluirLivroActionPerformed
        // Botão Excluir livro

        if(TableLivros.getSelectedRow() != -1){
            modeloLivros.Deletar(conn, (String)TableLivros.getValueAt(TableLivros.getSelectedRow(), 1), TableLivros.getSelectedRow());
            
        }
    }//GEN-LAST:event_ButtonExcluirLivroActionPerformed

    private void ButtonInserirEditoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonInserirEditoraActionPerformed
        // Botão inserir Editora
        formIncluir form = new formIncluir();
        form.setVisible(true); //Abre o form de incluir 
        form.getTabbedPane().setSelectedIndex(1);//Seleciona a aba de incluir nova Editora

//        this.dispose();
    }//GEN-LAST:event_ButtonInserirEditoraActionPerformed

    private void buttonExcluirEditoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExcluirEditoraActionPerformed
        // Botão excluir Editora
        // OBS: Se a editora estiver como chave estrangeira em algum livro no BD, ela não sera excluída. (Criar Tratamento)
        if(TableEditoras.getSelectedRow() != -1){
            modelo.Deletar(conn, (int)TableEditoras.getValueAt(TableEditoras.getSelectedRow(), 0), TableEditoras.getSelectedRow());
            
        }
        
        // -- Explicação do método -- //
        //O comando TableEditoras.getValueAt(int,int) pega o valor da celula especificada nos parâmetros.
        //O comando TableEditoras.getSelectedRow() pega o índice da celula selecionada na tabela.
        //Na comparação está verificando se há alguma linha selecionada. O valor -1 indica que não há nenhuma linha selecionada.
        //Como o comando getSelectedRow retorna o índice da célula selecionada, ele está sendo passado 
        //como parâmetro para o comando getValueAt para pegar o valor da celula selecionada e assim o valor ser passado
        //como parâmetro do método Deletar.
    }//GEN-LAST:event_buttonExcluirEditoraActionPerformed

   
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(formListar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formListar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formListar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formListar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new formListar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonExcluirLivro;
    private javax.swing.JButton ButtonInserirEditora;
    private javax.swing.JTable TableEditoras;
    private javax.swing.JTable TableLivros;
    private javax.swing.JButton buttonExcluirEditora;
    private javax.swing.JButton buttonInserirLivro;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTable jTable3;
    // End of variables declaration//GEN-END:variables
}
