package view;

import dao.AtendimentoDAO;
import dao.ClienteDAO;
import dao.ProdutoDAO;
import java.text.SimpleDateFormat;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import model.Atendimento;
import model.Funcionario;
import net.proteanit.sql.DbUtils;

public class HistoricoAtendimentos extends javax.swing.JFrame {

    private AtendimentoDAO adao = new AtendimentoDAO();
    private ClienteDAO cdao = new ClienteDAO();
    private ProdutoDAO ddao = new ProdutoDAO();
    private Funcionario f = new Funcionario();
    static JDialog atendimentoDialog = new JDialog();
    
    public HistoricoAtendimentos(Funcionario f) {
        this();
        this.f = f;
    }
    
    public HistoricoAtendimentos() {
        initComponents();
        cmbCliente.addItem("Selecionar cliente (opcional)");
        cmbProduto.addItem("Selecionar produto (opcional)");
        cdao.getClientesCPF(cmbCliente);
        ddao.getProdutosNome(cmbProduto);
        
        tblAtendimentos.setDefaultEditor(Object.class, null);
        atendimentoDialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        atendimentoDialog.setModal(true);
        atendimentoDialog.setUndecorated(false);
        atendimentoDialog.setResizable(false);
        Menu.menuDialog.setTitle("Histórico de Atendimentos");
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnMostrarTudo = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAtendimentos = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        txtTituloOcorrenciaPesquisa = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        cmbCliente = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        cmbProduto = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        btnPesquisar = new javax.swing.JButton();
        dchDataOcorrencia = new com.toedter.calendar.JDateChooser();
        btnNovo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Histórico de atendimentos");
        setResizable(false);

        btnMostrarTudo.setText("Mostrar todos");
        btnMostrarTudo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarTudoActionPerformed(evt);
            }
        });

        tblAtendimentos.setModel(DbUtils.resultSetToTableModel(adao.getAtendimentosRes()));
        tblAtendimentos.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblAtendimentos);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Título da ocorrência:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Cliente:");

        btnEditar.setText("Ver detalhes/Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Produto:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Data ocorrência:");

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        dchDataOcorrencia.setDateFormatString("yyyy-MM-dd");

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel10)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnPesquisar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnMostrarTudo))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(dchDataOcorrencia, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel11)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtTituloOcorrenciaPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnEditar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNovo))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtTituloOcorrenciaPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(cmbProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(dchDataOcorrencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(cmbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPesquisar)
                    .addComponent(btnMostrarTudo))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar)
                    .addComponent(btnNovo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMostrarTudoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarTudoActionPerformed
        tblAtendimentos.setModel(DbUtils.resultSetToTableModel(adao.getAtendimentosRes()));
    }//GEN-LAST:event_btnMostrarTudoActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        Atendimentos atendimentos = new Atendimentos(f);
        atendimentoDialog.setContentPane(atendimentos.getContentPane());
        atendimentoDialog.setBounds(atendimentos.getBounds());
        atendimentoDialog.setVisible(true);
        atendimentos.dispose();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        try {
            Atendimento a = new Atendimento();
            int selectedRow = tblAtendimentos.getSelectedRow();
            a.setId(Integer.parseInt(tblAtendimentos.getValueAt(selectedRow, 0).toString()));
            Atendimentos atendimento = new Atendimentos(a);
            atendimentoDialog.setContentPane(atendimento.getContentPane());
            atendimentoDialog.setBounds(atendimento.getBounds());
            atendimentoDialog.setVisible(true);
            atendimento.dispose();
        } catch(ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(rootPane, "Nenhum item selecionado");
        }
        
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date, titulo, produto, cliente;
        
        try {
            date = sdf.format(dchDataOcorrencia.getDate());
        } catch(NullPointerException e) {
            date = "";
        }
        produto = cmbProduto.getSelectedItem().toString();
        cliente = cmbCliente.getSelectedItem().toString();
        
        if(txtTituloOcorrenciaPesquisa.getText().isEmpty()) {
            titulo = "Campo txtTituloOcorrenciaPesquisa vazio";
        } else {
            titulo = txtTituloOcorrenciaPesquisa.getText();
        }
        if((cliente.equals("Selecionar cliente (opcional)") && date.equals("")) && 
                (!titulo.equals("Campo txtTituloOcorrenciaPesquisa vazio") && 
                !produto.equals("Selecionar produto (opcional)"))) {
            
            tblAtendimentos.setModel(DbUtils.resultSetToTableModel(adao.searchDoisCamposAtendimentosRes
            (titulo, produto, 1)));
            
        } else if((!titulo.equals("Campo txtTituloOcorrenciaPesquisa vazio") && 
                !cliente.equals("Selecionar cliente (opcional)")) && 
                (produto.equals("Selecionar produto (opcional)") && date.equals(""))) {
            
            tblAtendimentos.setModel(DbUtils.resultSetToTableModel(adao.searchDoisCamposAtendimentosRes
            (titulo, cliente, 2)));
            
        } else if((!titulo.equals("Campo txtTituloOcorrenciaPesquisa vazio") && !date.equals("")) && 
                (cliente.equals("Selecionar cliente (opcional)") && 
                produto.equals("Selecionar produto (opcional)"))) {
            
            tblAtendimentos.setModel(DbUtils.resultSetToTableModel(adao.searchDoisCamposAtendimentosRes
            (titulo, date, 3)));
            
        } else if(!produto.equals("Selecionar produto (opcional)") && 
                !cliente.equals("Selecionar cliente (opcional)") && 
                titulo.equals("Campo txtTituloOcorrenciaPesquisa vazio") && date.equals("")) {
            
            tblAtendimentos.setModel(DbUtils.resultSetToTableModel(adao.searchDoisCamposAtendimentosRes
            (produto, cliente, 4)));
            
        } else if(!produto.equals("Selecionar produto (opcional)") && !date.equals("") && 
                titulo.equals("Campo txtTituloOcorrenciaPesquisa vazio") && 
                cliente.equals("Selecionar cliente (opcional)")) {
            
            tblAtendimentos.setModel(DbUtils.resultSetToTableModel(adao.searchDoisCamposAtendimentosRes
            (produto, date, 5)));
            
        } else if(!cliente.equals("Selecionar cliente (opcional)") && !date.equals("") && 
                titulo.equals("Campo txtTituloOcorrenciaPesquisa vazio") && 
                produto.equals("Selecionar produto (opcional)")) {
            
            tblAtendimentos.setModel(DbUtils.resultSetToTableModel(adao.searchDoisCamposAtendimentosRes
            (cliente, date, 6)));
            
        } else if(!titulo.equals("Campo txtTituloOcorrenciaPesquisa vazio") && 
                !produto.equals("Selecionar produto (opcional)") && 
                !cliente.equals("Selecionar cliente (opcional)") && date.equals("")) {
            
            tblAtendimentos.setModel(DbUtils.resultSetToTableModel(adao.searchTresCamposAtendimentosRes
            (titulo, produto, cliente, 7)));
            
        } else if(!titulo.equals("Campo txtTituloOcorrenciaPesquisa vazio") && !date.equals("") && 
                !cliente.equals("Selecionar cliente (opcional)") && 
                produto.equals("Selecionar produto (opcional)")) {
            
            tblAtendimentos.setModel(DbUtils.resultSetToTableModel(adao.searchTresCamposAtendimentosRes
            (titulo, cliente, date, 8)));
            
        } else if(!titulo.equals("Campo txtTituloOcorrenciaPesquisa vazio") && !date.equals("") &&
                !produto.equals("Selecionar produto (opcional)") && cliente.equals("Selecionar cliente (opcional)")) {
            
            tblAtendimentos.setModel(DbUtils.resultSetToTableModel(adao.searchTresCamposAtendimentosRes
            (titulo, produto, date, 9)));
            
        } else if(!produto.equals("Selecionar produto (opcional)") && !date.equals("") && 
                !cliente.equals("Selecionar cliente (opcional)") && 
                titulo.equals("Campo txtTituloOcorrenciaPesquisa vazio")) {
            
            tblAtendimentos.setModel(DbUtils.resultSetToTableModel(adao.searchTresCamposAtendimentosRes
            (produto, cliente, date, 10)));
            
        } else if(!produto.equals("Selecionar produto (opcional)") && !date.equals("") && 
                !cliente.equals("Selecionar cliente (opcional)") && 
                !titulo.equals("Campo txtTituloOcorrenciaPesquisa vazio")) {
            
            tblAtendimentos.setModel(DbUtils.resultSetToTableModel(adao.searchAtendimentosRes
            (titulo, produto, cliente, date, false)));
            
        } else {
            tblAtendimentos.setModel(DbUtils.resultSetToTableModel(adao.searchAtendimentosRes
            (titulo, produto, cliente, date, true)));
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    
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
            java.util.logging.Logger.getLogger(HistoricoAtendimentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HistoricoAtendimentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HistoricoAtendimentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HistoricoAtendimentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HistoricoAtendimentos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnMostrarTudo;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JComboBox<String> cmbCliente;
    private javax.swing.JComboBox<String> cmbProduto;
    private com.toedter.calendar.JDateChooser dchDataOcorrencia;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblAtendimentos;
    private javax.swing.JTextField txtTituloOcorrenciaPesquisa;
    // End of variables declaration//GEN-END:variables
}
