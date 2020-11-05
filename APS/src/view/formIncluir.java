/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import model.Autor;
import model.Editora;
import model.Livros;
import model.LivrosAutores;
import model.TableModelEditoras;
import model.TableModelAutores;
import model.TableModelLivros;

/**
 *
 * @author fischer
 */
public class formIncluir extends javax.swing.JFrame {

    /**
     * Creates new form formIncluir
     */
    private List<Editora> editoras = TableModelEditoras.getDados(); //recebe as editoras antes já listadas
    private List<Autor> autores = TableModelAutores.getDados(); //recebe os autores antes já listados do BD
    private DefaultListModel modelList = new DefaultListModel();//Instancia um modelo de lista(modelList) do tipo Default
    private formBdconection conexao = new formBdconection();//Instancia um objeto de conexão com o BD
    
    private static List<LivrosAutores> seq_noBd = new ArrayList<>();//foi feito uma incremetação pra essa variável
    
    public formIncluir() {
        initComponents();
        
        PopularComboBox(); //Preenche o ComboBox
    }
    
    public void PopularComboBox(){
        
        comboBoxAutor.removeAllItems(); //Acho que o nome do método já é meio sugestivo, né? @Will
        comboBoxAutor.addItem("--- Escolha uma Editora ---");
        
        for(int i = 0; i < editoras.size(); i++){  //O for percorre o arrayList com as editoras
            comboBoxAutor.addItem(editoras.get(i).getNome()); //Aqui é adicionado ao comboBox os nomes das editoras
        }
        
        comboBoxAutor.setSelectedItem(0); //Deixa o comboBox selecionado com a primeira opção. No Caso "Escolha um editora"
            
        //ComboBox Autores
        comboBoxAutores.removeAllItems(); //Acho que o nome do método já é meio sugestivo, né? @Will
        comboBoxAutores.addItem("--- Escolha um Autor ---");
        for(int i = 0; i < autores.size(); i++){  //O for percorre o arrayList com os autores
            comboBoxAutores.addItem(autores.get(i).getName() + " " + autores.get(i).getFname()); //Aqui é adicionado ao comboBox os nomes dos autores
        }
//        comboBoxAutores.setSelectedItem(0); //Deixa o comboBox selecionado com a primeira opção. No Caso "Escolha um autor"
            
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedPane = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        textFieldNomeAuthors = new javax.swing.JTextField();
        textFieldSobrenomeAuthors = new javax.swing.JTextField();
        buttonInserirAuthor = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        textFieldNome = new javax.swing.JTextField();
        textFieldURL = new javax.swing.JTextField();
        buttonInserir = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        textFieldTitulo = new javax.swing.JTextField();
        textFieldIsbn = new javax.swing.JTextField();
        textFieldPreco = new javax.swing.JTextField();
        buttonCadastrar = new javax.swing.JButton();
        comboBoxAutor = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        listAutores = new javax.swing.JList<>();
        jLabel9 = new javax.swing.JLabel();
        comboBoxAutores = new javax.swing.JComboBox<>();
        buttonRemoverAutor = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro");

        jLabel7.setText("Nome:");

        jLabel8.setText("Sobrenome:");

        buttonInserirAuthor.setText("Inserir");
        buttonInserirAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInserirAuthorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttonInserirAuthor)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textFieldNomeAuthors)
                            .addComponent(textFieldSobrenomeAuthors, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE))))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(textFieldNomeAuthors, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(textFieldSobrenomeAuthors, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addComponent(buttonInserirAuthor)
                .addGap(65, 65, 65))
        );

        tabbedPane.addTab("Autor", jPanel1);

        jLabel5.setText("Nome");

        jLabel6.setText("URL");

        buttonInserir.setText("Inserir");
        buttonInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInserirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttonInserir)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(48, 48, 48)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textFieldNome)
                            .addComponent(textFieldURL, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(textFieldURL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(buttonInserir)
                .addContainerGap(137, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Editora", jPanel2);

        jLabel1.setText("Título:");

        jLabel2.setText("ISBN:");

        jLabel3.setText("Preço");

        jLabel4.setText("Editoras");

        textFieldPreco.setToolTipText("");

        buttonCadastrar.setText("Cadastrar");
        buttonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCadastrarActionPerformed(evt);
            }
        });

        comboBoxAutor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        listAutores.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listAutores);

        jLabel9.setText("Autores");

        comboBoxAutores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxAutores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxAutoresActionPerformed(evt);
            }
        });

        buttonRemoverAutor.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        buttonRemoverAutor.setText("-");
        buttonRemoverAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRemoverAutorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textFieldPreco, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                    .addComponent(comboBoxAutor, 0, 160, Short.MAX_VALUE)
                                    .addComponent(comboBoxAutores, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(31, 31, 31)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(textFieldTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textFieldIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(buttonRemoverAutor)
                                .addGap(9, 9, 9))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonCadastrar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(textFieldTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(textFieldIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(textFieldPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(comboBoxAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(comboBoxAutores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonRemoverAutor)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(buttonCadastrar)
                .addContainerGap())
        );

        tabbedPane.addTab("Livro", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInserirActionPerformed
        // --- Inserir Editora --- //
        String nome = textFieldNome.getText(); //Pega o valor do textField nome
        String url = textFieldURL.getText();   //Pega o valor do textField URL
        
        Editora editora = new Editora(); //Instancia um novo objeto do tipo Editora
        
        String res = editora.insert(this.conexao.getConn(), nome, url); // executa o comando insert into do BD para inserir uma nova editora
        
        if(res.equals("Sucesso")){
            JOptionPane.showMessageDialog(null, "A Editora foi inserida com Sucesso!");
            new formListar().AtualizaTable(); //Atualiza a tabela editora para inserir uma nova editora
            
            textFieldNome.setText("");
            textFieldURL.setText("");
            
        }else{
            textFieldNome.setText("");
            textFieldURL.setText("");
        }
        
        
        PopularComboBox();
    }//GEN-LAST:event_buttonInserirActionPerformed

    private void buttonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCadastrarActionPerformed
        // --- Cadastrar Livro --- //
        String title = textFieldTitulo.getText(); //Pega o valor do TextField Titulo
        String isbn = textFieldIsbn.getText(); //Pega o valor do TextField ISBN
        int publisherId = 0; //Pega o valor selecionado no ComboBox
        String price = textFieldPreco.getText(); // Pega o valor do TextField Preço
        
        for(int i=0; i < editoras.size(); i++){
            if(comboBoxAutor.getSelectedItem().equals(editoras.get(i).getNome())){ //Verifica a editora selecionada no comboBox como a do ArrayList para pegar o Id da editora
                publisherId = editoras.get(i).getId(); //Pega o ID da Editora antes verificada
            }
        }
        
        Livros livro = new Livros(); //Instancia um objeto do tipo Livro
        LivrosAutores livroAutor = new LivrosAutores();
        
        System.out.println("Title: " + title); //Apagar dps todos esses print
        System.out.println("ISBN: " + isbn);
        System.out.println("ID: " + publisherId);
        System.out.println("Preço: " + price);
        
        TableModelLivros book = new TableModelLivros();
        boolean verifica = book.VerificaIsbn(isbn);//Verifica se o isbn a ser inserido existe no BD
        
        if(verifica == false){
            String res = livro.insert(this.conexao.getConn(), title, isbn, publisherId, price); // Executa o comando insert into no BD para inserir um novo livro
        
            if(res.equals("Sucesso")){
                for(int i=0; i < modelList.getSize(); i++){
                    for(int y = 0; y < autores.size();y++){
                        if(modelList.getElementAt(i).equals(autores.get(y).getName()+" "+autores.get(y).getFname())){
                            /*Essa iteração faz uma comparação entre os autores selecionados na modelList com os
                            autores no arrayList do BD. A cada autor do modelList encotrado no BD, ele pega o Author_id
                            e associa o livro a ser cadastrado à esse autor pelo authors_id e o isbn*/

                            int seq_no = 0;
                            for(int j = 0; j < seq_noBd.size(); j++){ //Iteração para incrementar a variável seq_no e adicioná-la ao BD

                                if(seq_noBd.get(j).getSeq_no() >= seq_no){
                                    seq_no = seq_noBd.get(j).getSeq_no() + 1;
                                    AtualizaDadosSeqNo();
                                }
                            }

                            String r = livroAutor.insert(this.conexao.getConn(), isbn, autores.get(y).getAuthorId(), seq_no); //Faz associação do autor com o livro, através da tabela booksAuthors
                        }
                    }
                }


                JOptionPane.showMessageDialog(null, "O livro foi cadastrado com Sucesso!");
                new formListar().AtualizaTable();//Atualiza a tabela livros após cadastrar um novo livro

                limpaCamposLivros();
                
            }else{
                limpaCamposLivros();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Esse ISBN já existe!");
            limpaCamposLivros();
        }
        
    }//GEN-LAST:event_buttonCadastrarActionPerformed

    private void buttonInserirAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInserirAuthorActionPerformed
        // Botão inserir Autores

        String nomeAutor = textFieldNomeAuthors.getText(); //Pega o valor do textField nome
        String sobrenomeAutor = textFieldSobrenomeAuthors.getText();   //Pega o valor do textField Sobrenome

        Autor author = new Autor(); //Instancia um novo objeto do tipo Autor

        String res = author.insert(this.conexao.getConn(), nomeAutor, sobrenomeAutor); // executa o comando insert into do BD para inserir um novo autor

        if(res.equals("Sucesso")){
            JOptionPane.showMessageDialog(null, "O Autor foi inserido com Sucesso!");
            new formListar().AtualizaTable(); //Atualiza a tabela editora para inserir um novo autor
            
            textFieldNomeAuthors.setText("");
            textFieldSobrenomeAuthors.setText("");
            PopularComboBox();
        }else{
            textFieldNomeAuthors.setText("");
            textFieldSobrenomeAuthors.setText("");
        }
        
    }//GEN-LAST:event_buttonInserirAuthorActionPerformed

    private void comboBoxAutoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxAutoresActionPerformed
        
        this.listAutores.setModel(modelList); //seta o modelo da lista para o Jlist listAutores
        
        modelList.addElement(comboBoxAutores.getSelectedItem());//Adiciona os autores do ArrayList de autores no modelList
        
        for(int i = 0; i < modelList.size(); i++){
            if(comboBoxAutores.getItemAt(i) == null || modelList.getElementAt(i).equals("--- Escolha um Autor ---")){
                modelList.removeElementAt(i);
                
            }
        }
        
    }//GEN-LAST:event_comboBoxAutoresActionPerformed

    private void buttonRemoverAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRemoverAutorActionPerformed
        //Botão Remover Autor do modelList
        
        int index = listAutores.getSelectedIndex();
        modelList.remove(index);
    }//GEN-LAST:event_buttonRemoverAutorActionPerformed

    public JTabbedPane getTabbedPane() {
        return tabbedPane;
    }

    public List<LivrosAutores> getSeq_noBd() {
        return seq_noBd;
    }

    public void setSeq_noBd(List<LivrosAutores> seq_noBd) {
        this.seq_noBd = seq_noBd;
    }
    
    public void limpaCamposLivros(){
        textFieldTitulo.setText("");
        textFieldIsbn.setText("");
        textFieldPreco.setText("");
        modelList.clear();//Limpa o modelList
        PopularComboBox();
    }
    
    

    public void AtualizaDadosSeqNo(){
        //Método puxa o dado seq_no da tabela booksauthors do BD para fazer a incrementação
        LivrosAutores livroAutor = new LivrosAutores();
        livroAutor.select(conexao.getConn());
        ResultSet result = livroAutor.getResult(); // Pega os resultados do select
            try {
                while (result.next()) { 
                    LivrosAutores livroAutor2 = new LivrosAutores();
                    livroAutor2.setSeq_no(result.getInt("seq_no"));
                    seq_noBd.add(livroAutor2);
                }
            }catch (SQLException ex) {
                Logger.getLogger(formListar.class.getName()).log(Level.SEVERE, null, ex);
            }
   }

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
            java.util.logging.Logger.getLogger(formIncluir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formIncluir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formIncluir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formIncluir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formIncluir().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCadastrar;
    private javax.swing.JButton buttonInserir;
    private javax.swing.JButton buttonInserirAuthor;
    private javax.swing.JButton buttonRemoverAutor;
    private javax.swing.JComboBox<String> comboBoxAutor;
    private javax.swing.JComboBox<String> comboBoxAutores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listAutores;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JTextField textFieldIsbn;
    private javax.swing.JTextField textFieldNome;
    private javax.swing.JTextField textFieldNomeAuthors;
    private javax.swing.JTextField textFieldPreco;
    private javax.swing.JTextField textFieldSobrenomeAuthors;
    private javax.swing.JTextField textFieldTitulo;
    private javax.swing.JTextField textFieldURL;
    // End of variables declaration//GEN-END:variables
}
