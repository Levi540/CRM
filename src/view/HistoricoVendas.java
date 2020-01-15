package view;

import dao.ClienteDAO;
import dao.VendaDAO;
import java.text.SimpleDateFormat;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import model.Venda;
import net.proteanit.sql.DbUtils;

public class HistoricoVendas extends javax.swing.JFrame {

    VendaDAO vdao = new VendaDAO();
    ClienteDAO cdao = new ClienteDAO();
    static JDialog vendasDialog = new JDialog();
    
    public HistoricoVendas() {
        initComponents();
        cmbCliente.addItem("Selecionar cliente (opcional)");
        cdao.getClientesCPF(cmbCliente);
        
        tblVendas.setDefaultEditor(Object.class, null);
        vendasDialog.setModal(true);
        vendasDialog.setUndecorated(false);
        vendasDialog.setResizable(false);
        Menu.menuDialog.setTitle("Histórico de Vendas");
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tblVendas = new javax.swing.JTable();
        btnVerDetalhes = new javax.swing.JButton();
        lblClientePesquisa = new javax.swing.JLabel();
        cmbCliente = new javax.swing.JComboBox<>();
        lblDataVenda = new javax.swing.JLabel();
        btnPesquisar = new javax.swing.JButton();
        dchDataVenda = new com.toedter.calendar.JDateChooser();
        btnTodasVendas = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Histórico de vendas");
        setResizable(false);

        tblVendas.setModel(DbUtils.resultSetToTableModel(vdao.getVendasRes()));
        tblVendas.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblVendas);

        btnVerDetalhes.setText("Ver detalhes");
        btnVerDetalhes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerDetalhesActionPerformed(evt);
            }
        });

        lblClientePesquisa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblClientePesquisa.setText("Cliente:");

        cmbCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbClienteActionPerformed(evt);
            }
        });

        lblDataVenda.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDataVenda.setText("Data venda:");

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        dchDataVenda.setDateFormatString("yyyy-MM-dd");

        btnTodasVendas.setText("Todos");
        btnTodasVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTodasVendasActionPerformed(evt);
            }
        });

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
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnPesquisar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnTodasVendas))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblDataVenda)
                                    .addComponent(lblClientePesquisa))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbCliente, 0, 191, Short.MAX_VALUE)
                                    .addComponent(dchDataVenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 268, Short.MAX_VALUE)
                        .addComponent(btnVerDetalhes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNovo)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblClientePesquisa)
                    .addComponent(cmbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDataVenda)
                    .addComponent(dchDataVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPesquisar)
                    .addComponent(btnTodasVendas))
                .addGap(19, 19, 19)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVerDetalhes)
                    .addComponent(btnNovo))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmbClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbClienteActionPerformed

    private void btnTodasVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTodasVendasActionPerformed
        tblVendas.setModel(DbUtils.resultSetToTableModel(vdao.getVendasRes()));
    }//GEN-LAST:event_btnTodasVendasActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        Vendas v = new Vendas();
        vendasDialog.setContentPane(v.getContentPane());
        vendasDialog.setBounds(v.getBounds());
        vendasDialog.setVisible(true);
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnVerDetalhesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerDetalhesActionPerformed
        try {
            Venda v = new Venda();
            int selectedRow = tblVendas.getSelectedRow();
            v.setId(Integer.parseInt(tblVendas.getValueAt(selectedRow, 0).toString()));
            v = vdao.getVendaId(v.getId());
            DetalhesVenda verDetalhes = new DetalhesVenda(v, tblVendas.getValueAt(selectedRow, 1).toString(), 
            tblVendas.getValueAt(selectedRow, 3).toString());
            vendasDialog.setContentPane(verDetalhes.getContentPane());
            vendasDialog.setBounds(verDetalhes.getBounds());
            vendasDialog.setVisible(true);
            verDetalhes.dispose();
        } catch(ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(rootPane, "Nenhum item selecionado");
        }
        
    }//GEN-LAST:event_btnVerDetalhesActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date;
        try {
            date = sdf.format(dchDataVenda.getDate());
        } catch(NullPointerException e) {
            date = "";
        }
        if(cmbCliente.getSelectedItem().toString().equals("Selecionar cliente (opcional)") || 
                date.equals("")) {
            tblVendas.setModel(DbUtils.resultSetToTableModel(vdao.searchVendasRes
            (cmbCliente.getSelectedItem().toString(), date, true)));
        } else {
            tblVendas.setModel(DbUtils.resultSetToTableModel(vdao.searchVendasRes
            (cmbCliente.getSelectedItem().toString(), date, false)));
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
            java.util.logging.Logger.getLogger(HistoricoVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HistoricoVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HistoricoVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HistoricoVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HistoricoVendas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnTodasVendas;
    private javax.swing.JButton btnVerDetalhes;
    private javax.swing.JComboBox<String> cmbCliente;
    private com.toedter.calendar.JDateChooser dchDataVenda;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblClientePesquisa;
    private javax.swing.JLabel lblDataVenda;
    private javax.swing.JTable tblVendas;
    // End of variables declaration//GEN-END:variables
}
