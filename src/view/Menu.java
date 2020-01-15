package view;

import javax.swing.JDialog;
import model.Funcionario;

public class Menu extends javax.swing.JFrame {

    static JDialog menuDialog = new JDialog();
    Funcionario f = new Funcionario();
    
    public Menu(Funcionario f) {
        this();
        this.f = f;
    }
    
    public Menu() {
        initComponents();
        menuDialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        menuDialog.setModal(true);
        menuDialog.setUndecorated(false);
        menuDialog.setResizable(false);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnClientes = new javax.swing.JButton();
        btnVisitasProgramadas = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        btnFornecedores = new javax.swing.JButton();
        btnVendas = new javax.swing.JButton();
        btnAtendimentos = new javax.swing.JButton();
        btnFuncionarios = new javax.swing.JButton();
        btnProdutos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("menu inicial");
        setResizable(false);

        btnClientes.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cliente.png"))); // NOI18N
        btnClientes.setText("Clientes");
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });
        btnClientes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnClientesKeyPressed(evt);
            }
        });

        btnVisitasProgramadas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnVisitasProgramadas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/visita programada_1.png"))); // NOI18N
        btnVisitasProgramadas.setText("Visitas Programadas");
        btnVisitasProgramadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisitasProgramadasActionPerformed(evt);
            }
        });

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/sair.png"))); // NOI18N
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnFornecedores.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnFornecedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fornecedor_1.png"))); // NOI18N
        btnFornecedores.setText("Fornecedores");
        btnFornecedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFornecedoresActionPerformed(evt);
            }
        });

        btnVendas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnVendas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/vendas.png"))); // NOI18N
        btnVendas.setText("Vendas");
        btnVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVendasActionPerformed(evt);
            }
        });

        btnAtendimentos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAtendimentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/atendimento.png"))); // NOI18N
        btnAtendimentos.setText("Atendimentos");
        btnAtendimentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtendimentosActionPerformed(evt);
            }
        });

        btnFuncionarios.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnFuncionarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/funcionarios.png"))); // NOI18N
        btnFuncionarios.setText("Funcionarios");
        btnFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFuncionariosActionPerformed(evt);
            }
        });

        btnProdutos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnProdutos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/produto.jpg"))); // NOI18N
        btnProdutos.setText("Produtos");
        btnProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdutosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVisitasProgramadas, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAtendimentos, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVendas, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(22, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(btnVendas, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnVisitasProgramadas, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAtendimentos, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSair))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
        RelacaoClientes relacaoClientes = new RelacaoClientes();
        menuDialog.setContentPane(relacaoClientes.getContentPane());
        menuDialog.setBounds(relacaoClientes.getBounds());
        menuDialog.setVisible(true);
        relacaoClientes.dispose();
    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnVisitasProgramadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisitasProgramadasActionPerformed
        HistoricoVisitas historicoVisitas = new HistoricoVisitas();
        menuDialog.setContentPane(historicoVisitas.getContentPane());
        menuDialog.setBounds(historicoVisitas.getBounds());
        menuDialog.setVisible(true);
        historicoVisitas.dispose();
    }//GEN-LAST:event_btnVisitasProgramadasActionPerformed

    private void btnVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVendasActionPerformed
        HistoricoVendas historicoVendas = new HistoricoVendas();
        menuDialog.setContentPane(historicoVendas.getContentPane());
        menuDialog.setBounds(historicoVendas.getBounds());
        menuDialog.setVisible(true);
        historicoVendas.dispose();
    }//GEN-LAST:event_btnVendasActionPerformed

    private void btnFornecedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFornecedoresActionPerformed
        Fornecedores fornecedores = new Fornecedores();
        menuDialog.setContentPane(fornecedores.getContentPane());
        menuDialog.setBounds(fornecedores.getBounds());
        menuDialog.setVisible(true);
        fornecedores.dispose();
    }//GEN-LAST:event_btnFornecedoresActionPerformed

    private void btnProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdutosActionPerformed
        Produtos produtos = new Produtos();
        menuDialog.setContentPane(produtos.getContentPane());
        menuDialog.setBounds(produtos.getBounds());
        menuDialog.setVisible(true);
        produtos.dispose();
    }//GEN-LAST:event_btnProdutosActionPerformed

    private void btnAtendimentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtendimentosActionPerformed
        HistoricoAtendimentos historicoAtendimentos = new HistoricoAtendimentos(f);
        menuDialog.setContentPane(historicoAtendimentos.getContentPane());
        menuDialog.setBounds(historicoAtendimentos.getBounds());
        menuDialog.setVisible(true);
        historicoAtendimentos.dispose();
    }//GEN-LAST:event_btnAtendimentosActionPerformed

    private void btnFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFuncionariosActionPerformed
        if(f.isAdmin()) {
            Funcionarios funcionarios = new Funcionarios(f);
            menuDialog.setContentPane(funcionarios.getContentPane());
            menuDialog.setBounds(funcionarios.getBounds());
            menuDialog.setVisible(true);
            funcionarios.dispose();
        } else {
            DetalhesFuncionario detalhesFuncionario = new DetalhesFuncionario(f);
            menuDialog.setContentPane(detalhesFuncionario.getContentPane());
            menuDialog.setBounds(detalhesFuncionario.getBounds());
            menuDialog.setVisible(true);
            detalhesFuncionario.dispose();
        }
        
    }//GEN-LAST:event_btnFuncionariosActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnClientesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnClientesKeyPressed
         if(evt.getKeyCode() == 27) {
            this.dispose();
        }
    }//GEN-LAST:event_btnClientesKeyPressed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtendimentos;
    private javax.swing.JButton btnClientes;
    private javax.swing.JButton btnFornecedores;
    private javax.swing.JButton btnFuncionarios;
    private javax.swing.JButton btnProdutos;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnVendas;
    private javax.swing.JButton btnVisitasProgramadas;
    // End of variables declaration//GEN-END:variables
}
