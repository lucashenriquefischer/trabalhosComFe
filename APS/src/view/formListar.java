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
import model.Autor;
import model.Editora;
import model.Livros;
import model.TableModelEditoras;
import model.TableModelAutores;
import model.TableModelLivros;

/**
 *
 * @author fischer
 */
public class formListar extends javax.swing.JFrame {
    //Instancia as classes TableModelEditoras, com o modelo de tabela definida de acordo com nossa necessidade
    private static TableModelEditoras modelo = new TableModelEditoras(); //Instancia o modelo de tabela para editora
    private static TableModelLivros modeloLivros = new TableModelLivros(); //Instancia um modelo de tabela para Livros
    private static TableModelAutores modeloAutores = new TableModelAutores();
    private static formBdconection conexao = new formBdconection();//Instancia um objeto de conexão com o BD
    // ------------------------------- //
   
    /**
     * Creates new form formListar
     */
    
    public formListar() {
        initComponents();
        TableEditoras.setCellSelectionEnabled(true); //Torna uma única célula da Table selecionável
        TableEditoras.setModel(modelo); // Seta o modelo o criado na classe TableModelEditoras.java na tabela (JTable)
        
        TableLivros.setCellSelectionEnabled(true); //Torna uma única célula da Table selecionável
        TableLivros.setModel(modeloLivros); // Seta o modelo o criado na classe TableModelEditoras.java na tabela (JTable)
        
        TableLivros.setCellSelectionEnabled(true);
        tableAutores.setModel(modeloAutores);
        
        PreencherTable();
        
    }
    
    public static void PreencherTable(){
        // --- Listar as Editoras --- //
        Editora editora = new Editora(); 
        String res;
        res = editora.select(conexao.getConn(), ""); //executa o comando select no BD
        if (res.equals("Sucesso")) {
            ResultSet result = editora.getResult(); // Pega os resultados do select
            try {
                while (result.next()) { 

                    Editora editora2 = new Editora(); // Cria um novo objeto do tipo editora com os resultados do select, para popular a tabela através desse objeto
                    editora2.setId(Integer.parseInt(result.getString("publisher_id")));
                    editora2.setNome(result.getString("name").trim()); 
                    editora2.setUrl(result.getString("url").trim());
                    editora2.setConn(conexao.getConn());
                    modelo.addRow(editora2); //Metodo chamada para popular as tabelas
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(formListar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        // --- Listar Livros --- //
        Livros livro = new Livros(); 
        String res2;
        res2 = livro.select(conexao.getConn(), ""); //executa o comando select no BD
        if (res2.equals("Sucesso")) {
            ResultSet result = livro.getResult(); // Pega os resultados do select
            try {
                while (result.next()) { 

                    Livros livro2 = new Livros(); // Cria um novo objeto do tipo Livro com os resultados do select, para popular a tabela através desse objeto
                    livro2.setTitle(result.getString("title").trim());
                    livro2.setIsbn(result.getString("isbn").trim()); 
                    livro2.setPublisherId(Integer.parseInt(result.getString("publisher_id")));
                    livro2.setPrice(Double.parseDouble(result.getString("price").trim()));
                    livro2.setConn(conexao.getConn());
                    modeloLivros.addRow(livro2); //Metodo chamada para popular as tabelas
                }
            }catch (SQLException ex) {
                Logger.getLogger(formListar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        // --- Listar autores --- //
        Autor autor = new Autor(); 
        String resAutor;
        resAutor = autor.select(conexao.getConn(), ""); //executa o comando select no BD
        if (resAutor.equals("Sucesso")) {
            ResultSet result = autor.getResult(); // Pega os resultados do select
            try {
                while (result.next()) { 

                    Autor autor2 = new Autor(); // Cria um novo objeto do tipo autor com os resultados do select, para popular a tabela através desse objeto
                    autor2.setAuthorId(result.getInt("author_id"));
                    autor2.setName(result.getString("name").trim());
                    autor2.setFname(result.getString("fname").trim()); 
                    autor2.setConn(conexao.getConn());
                    modeloAutores.addRow(autor2); //Metodo chamada para popular as tabelas
                }
            }catch (SQLException ex) {
                Logger.getLogger(formListar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        new formIncluir().AtualizaDadosSeqNo();
    }
   
    public void AtualizaTable(){
        TableModelEditoras.getDados().clear();//Limpa os dados do Array
        TableModelLivros.getDados().clear();
        TableModelAutores.getDados().clear();
        
        modelo.fireTableDataChanged();//Atualiza alterações na tabela
        modeloLivros.fireTableDataChanged();
        modeloAutores.fireTableDataChanged();
        
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
        buttonExcluirEditora = new javax.swing.JButton();
        ButtonInserirEditora = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableEditoras = new javax.swing.JTable();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        ButtonExcluirLivro = new javax.swing.JButton();
        buttonInserirLivro = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableLivros = new javax.swing.JTable();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        buttonExcluirAutor = new javax.swing.JButton();
        buttonIncluirAutor = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableAutores = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Livraria Amazonas");

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
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonExcluirEditora, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
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
                        .addComponent(ButtonInserirEditora)
                        .addGap(18, 18, 18)
                        .addComponent(buttonExcluirEditora)
                        .addGap(14, 14, 14)))
                .addContainerGap(215, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("", jPanel3);

        jTabbedPane1.addTab("Editora", jTabbedPane3);

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
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ButtonExcluirLivro, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
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
                        .addComponent(buttonInserirLivro)
                        .addGap(18, 18, 18)
                        .addComponent(ButtonExcluirLivro)
                        .addGap(17, 17, 17)))
                .addContainerGap(215, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("", jPanel2);

        jTabbedPane1.addTab("Livro", jTabbedPane4);

        buttonExcluirAutor.setText("Excluir");
        buttonExcluirAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExcluirAutorActionPerformed(evt);
            }
        });

        buttonIncluirAutor.setText("Incluir");
        buttonIncluirAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonIncluirAutorActionPerformed(evt);
            }
        });

        tableAutores.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tableAutores);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonExcluirAutor, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(buttonIncluirAutor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(35, 35, 35))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(buttonIncluirAutor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonExcluirAutor)))
                .addContainerGap(215, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("", jPanel1);

        jTabbedPane1.addTab("Autor", jTabbedPane2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
        setLocationRelativeTo(null);
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
            modeloLivros.Deletar(this.conexao.getConn(), (String)TableLivros.getValueAt(TableLivros.getSelectedRow(), 1), TableLivros.getSelectedRow());
            AtualizaTable();
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
            modelo.Deletar(this.conexao.getConn(), (String)TableEditoras.getValueAt(TableEditoras.getSelectedRow(), 0),
                    (String)TableEditoras.getValueAt(TableEditoras.getSelectedRow(), 1), TableEditoras.getSelectedRow());
            AtualizaTable();
        }

        // -- Explicação do método -- //
        //O comando TableEditoras.getValueAt(int,int) pega o valor da celula especificada nos parâmetros.
        //O comando TableEditoras.getSelectedRow() pega o índice da celula selecionada na tabela.
        //Na comparação está verificando se há alguma linha selecionada. O valor -1 indica que não há nenhuma linha selecionada.
        //Como o comando getSelectedRow retorna o índice da célula selecionada, ele está sendo passado
        //como parâmetro para o comando getValueAt para pegar o valor da celula selecionada e assim o valor ser passado
        //como parâmetro do método Deletar.
    }//GEN-LAST:event_buttonExcluirEditoraActionPerformed

    private void buttonIncluirAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonIncluirAutorActionPerformed
        // Botão Incluir autores

        formIncluir form = new formIncluir();
        form.setVisible(true); //Abre o form de incluir
        form.getTabbedPane().setSelectedIndex(0);//Seleciona a aba de incluir novo Autor
    }//GEN-LAST:event_buttonIncluirAutorActionPerformed

    private void buttonExcluirAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExcluirAutorActionPerformed
        // Botão excluir Autores

        if(tableAutores.getSelectedRow() != -1){
            modeloAutores.Deletar(this.conexao.getConn(), (String)tableAutores.getValueAt(tableAutores.getSelectedRow(), 0),
                (String)tableAutores.getValueAt(tableAutores.getSelectedRow(), 1), tableAutores.getSelectedRow());
            AtualizaTable();
        }
    }//GEN-LAST:event_buttonExcluirAutorActionPerformed

   
    
    
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
    private javax.swing.JButton buttonExcluirAutor;
    private javax.swing.JButton buttonExcluirEditora;
    private javax.swing.JButton buttonIncluirAutor;
    private javax.swing.JButton buttonInserirLivro;
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
    private javax.swing.JTable tableAutores;
    // End of variables declaration//GEN-END:variables
}
