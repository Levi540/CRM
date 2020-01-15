package view;

import dao.VisitaDAO;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import model.Visita;
import net.proteanit.sql.DbUtils;

public class HistoricoVisitas extends javax.swing.JFrame {

    private VisitaDAO vdao = new VisitaDAO();
    static JDialog visitasDialog = new JDialog();
    
    public HistoricoVisitas() {
        initComponents();
        
        tblVisitas.setDefaultEditor(Object.class, null);
        visitasDialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        visitasDialog.setModal(true);
        visitasDialog.setUndecorated(false);
        visitasDialog.setResizable(false);
        Menu.menuDialog.setTitle("Historico de Visitas");
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnVerDetalhes = new javax.swing.JButton();
        btnNovaVisita = new javax.swing.JButton();
        lblClientePesquisa = new javax.swing.JLabel();
        txtPesquisa = new javax.swing.JTextField();
        bntPesquisar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblVisitas = new javax.swing.JTable();
        btnTodos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Histórico de visitas");
        setResizable(false);

        btnVerDetalhes.setText("Ver detalhes/Editar");
        btnVerDetalhes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerDetalhesActionPerformed(evt);
            }
        });

        btnNovaVisita.setText("Nova visita");
        btnNovaVisita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovaVisitaActionPerformed(evt);
            }
        });

        lblClientePesquisa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblClientePesquisa.setText("Cliente:");

        bntPesquisar.setText("Pesquisar");
        bntPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntPesquisarActionPerformed(evt);
            }
        });

        tblVisitas.setModel(DbUtils.resultSetToTableModel(vdao.getVisitasRes()));
        tblVisitas.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblVisitas);

        btnTodos.setText("Todos");
        btnTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTodosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblClientePesquisa)
                        .addGap(18, 18, 18)
                        .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bntPesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTodos)
                        .addGap(0, 134, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVerDetalhes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNovaVisita)
                .addGap(140, 140, 140))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblClientePesquisa)
                    .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntPesquisar)
                    .addComponent(btnTodos))
                .addGap(25, 25, 25)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVerDetalhes)
                    .addComponent(btnNovaVisita))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTodosActionPerformed
        tblVisitas.setModel(DbUtils.resultSetToTableModel(vdao.getVisitasRes()));
    }//GEN-LAST:event_btnTodosActionPerformed

    private void btnNovaVisitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovaVisitaActionPerformed
        VisitasProgramadas visitasProgramadas = new VisitasProgramadas();
        visitasDialog.setContentPane(visitasProgramadas.getContentPane());
        visitasDialog.setBounds(visitasProgramadas.getBounds());
        visitasDialog.setVisible(true);
        visitasProgramadas.dispose();
    }//GEN-LAST:event_btnNovaVisitaActionPerformed

    private void btnVerDetalhesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerDetalhesActionPerformed
        try {
            Visita v = new Visita();
            int selectedRow = tblVisitas.getSelectedRow();
            v.setId(Integer.parseInt(tblVisitas.getValueAt(selectedRow, 0).toString()));
            v = vdao.getVisitaId(v.getId());

            VisitasProgramadas editarVisitas = new VisitasProgramadas(v);
            visitasDialog.setContentPane(editarVisitas.getContentPane());
            visitasDialog.setBounds(editarVisitas.getBounds());
            visitasDialog.setVisible(true);
            editarVisitas.dispose();
        } catch(ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(rootPane, "Nenhum item selecionado");
        }
        
    }//GEN-LAST:event_btnVerDetalhesActionPerformed

    private void bntPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntPesquisarActionPerformed
        if(!txtPesquisa.getText().isEmpty()) {
            tblVisitas.setModel(DbUtils.resultSetToTableModel(vdao.searchVisitasRes(txtPesquisa.getText())));
        }
    }//GEN-LAST:event_bntPesquisarActionPerformed

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
            java.util.logging.Logger.getLogger(HistoricoVisitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HistoricoVisitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HistoricoVisitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HistoricoVisitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HistoricoVisitas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntPesquisar;
    private javax.swing.JButton btnNovaVisita;
    private javax.swing.JButton btnTodos;
    private javax.swing.JButton btnVerDetalhes;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblClientePesquisa;
    private javax.swing.JTable tblVisitas;
    private javax.swing.JTextField txtPesquisa;
    // End of variables declaration//GEN-END:variables
}
