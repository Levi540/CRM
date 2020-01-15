package view;

import dao.FuncionarioDAO;
import dao.PessoaDAO;
import javax.swing.JOptionPane;
import model.Funcionario;
import model.Pessoa;

public class CadastrarFuncionario extends javax.swing.JFrame {

    private Funcionario f = new Funcionario();
    private Funcionario fVerificar = new Funcionario();
    private Pessoa p = new Pessoa();
    private PessoaDAO pdao = new PessoaDAO();

    public CadastrarFuncionario(Funcionario funcEditar, Funcionario fVerificar) {
        this();
        this.f = funcEditar;
        this.fVerificar = fVerificar;
        carregaFuncionario();
    }
    
    public CadastrarFuncionario(Funcionario fVerificar) {
        this();
        this.fVerificar = fVerificar;
    }
    
    public void carregaFuncionario() {
        p = pdao.getPessoaId(f.getFkIdPessoa());
        txtNome.setText(p.getNome());
        txtEndereco.setText(p.getEndereco());
        txtEmail.setText(p.getEmail());
        txtLogin.setText(f.getLogin());
        txtTelefone.setText(p.getTelefone());
        pswSenha.setText(f.getSenha());

        rbnAdminSim.setSelected(f.isAdmin());
        rbnAtivadoSim.setSelected(f.isAtivado());
        
        rbnAdimnNao.setSelected(!f.isAdmin());
        rbnAtivadoNao.setSelected(!f.isAtivado());
        if(!fVerificar.isAdmin()) {
            rbnAdminSim.setVisible(false);
            rbnAtivadoSim.setVisible(false);
            rbnAdimnNao.setVisible(false);
            rbnAtivadoNao.setVisible(false);
            txtNome.setEditable(false);
            lblAdmin.setVisible(false);
            lblAtivado.setVisible(false);
        }
    }

    public CadastrarFuncionario() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        txtEmail = new javax.swing.JTextField();
        rbnAdminSim = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        rbnAdimnNao = new javax.swing.JRadioButton();
        lblEndereco = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JFormattedTextField();
        txtEndereco = new javax.swing.JTextField();
        pswSenha = new javax.swing.JPasswordField();
        btnCancelar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        txtNome = new javax.swing.JTextField();
        lblAtivado = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        rbnAtivadoSim = new javax.swing.JRadioButton();
        lblEmail = new javax.swing.JLabel();
        rbnAtivadoNao = new javax.swing.JRadioButton();
        txtLogin = new javax.swing.JTextField();
        lblAdmin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buttonGroup2.add(rbnAdminSim);
        rbnAdminSim.setText("Sim");
        rbnAdminSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbnAdminSimActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Senha:");

        buttonGroup2.add(rbnAdimnNao);
        rbnAdimnNao.setText("Não");
        rbnAdimnNao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbnAdimnNaoActionPerformed(evt);
            }
        });

        lblEndereco.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblEndereco.setText("Endereço:");

        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Telefone:");

        lblNome.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblNome.setText("Nome:");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        lblAtivado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblAtivado.setText("Ativado:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Login:");

        buttonGroup1.add(rbnAtivadoSim);
        rbnAtivadoSim.setText("Sim");
        rbnAtivadoSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbnAtivadoSimActionPerformed(evt);
            }
        });

        lblEmail.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblEmail.setText("Email:");

        buttonGroup1.add(rbnAtivadoNao);
        rbnAtivadoNao.setText("Não");
        rbnAtivadoNao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbnAtivadoNaoActionPerformed(evt);
            }
        });

        lblAdmin.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblAdmin.setText("Admin:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(lblEndereco)
                    .addComponent(lblEmail)
                    .addComponent(lblNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(pswSenha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLogin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelefone, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblAdmin)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rbnAdminSim)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rbnAdimnNao))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblAtivado)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rbnAtivadoSim)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rbnAtivadoNao)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEndereco)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblAtivado)
                                .addComponent(rbnAtivadoSim)
                                .addComponent(rbnAtivadoNao))
                            .addGap(17, 17, 17))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(rbnAdimnNao)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblAdmin)
                        .addComponent(rbnAdminSim)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCancelar)
                        .addComponent(btnSalvar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(pswSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rbnAdminSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbnAdminSimActionPerformed
        f.setAdmin(true);
    }//GEN-LAST:event_rbnAdminSimActionPerformed

    private void rbnAdimnNaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbnAdimnNaoActionPerformed
        f.setAdmin(false);
    }//GEN-LAST:event_rbnAdimnNaoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limparCampos();
        if(fVerificar.isAdmin()) {
            Funcionarios.funcionarioDialog.dispose();
        } else {
            DetalhesFuncionario.detalhesFuncionarioDialog.dispose();
        }
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if(verificarCampos()) {
            Funcionario verificarLogin;
            FuncionarioDAO fdao = new FuncionarioDAO();
            verificarLogin = fdao.getFuncionarioLogin(txtLogin.getText());

            p.setNome(txtNome.getText());
            p.setEmail(txtEmail.getText());
            p.setEndereco(txtEndereco.getText());
            p.setTelefone(txtTelefone.getText());
            
            f.setSenha(String.valueOf(pswSenha.getPassword()));
            boolean ativado = rbnAtivadoSim.isSelected();
            boolean admin = rbnAdminSim.isSelected();
            
            f.setAtivado(ativado);
            f.setAdmin(admin);
            
            if(!(verificarLogin.getLogin()+"").equals(txtLogin.getText()+"") && f.getId()<=0) {
                pdao.salvar(p);
                f.setFkIdPessoa(pdao.getMaxId());
                f.setLogin(txtLogin.getText());
                fdao.salvar(f);
                limparCampos();
                if(fVerificar.isAdmin()) {
                    Funcionarios.funcionarioDialog.dispose();
                } else {
                    DetalhesFuncionario.detalhesFuncionarioDialog.dispose();
                }
                this.dispose();
            } else if(f.getId() > 0 && (verificarLogin.getLogin()+"").equals(txtLogin.getText()+"")) {
                pdao.salvar(p);
                f.setLogin(txtLogin.getText());
                fdao.salvar(f);
                limparCampos();
                if(fVerificar.isAdmin()) {
                    Funcionarios.funcionarioDialog.dispose();
                } else {
                    DetalhesFuncionario.detalhesFuncionarioDialog.dispose();
                }
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Este login já existe!");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Todos os campos são obrigatórios!!");
        }

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void rbnAtivadoSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbnAtivadoSimActionPerformed
        f.setAtivado(true);
    }//GEN-LAST:event_rbnAtivadoSimActionPerformed

    private void rbnAtivadoNaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbnAtivadoNaoActionPerformed
        f.setAtivado(false);
    }//GEN-LAST:event_rbnAtivadoNaoActionPerformed

    public boolean verificarCampos() {
        boolean podeSalvar = true;

        try {
            if(buttonGroup1.getSelection().isSelected() && buttonGroup2.getSelection().isSelected()) {
                podeSalvar = true;
            }
            if (txtNome.getText().isEmpty()) {
                podeSalvar = false;
            }
            if (txtEmail.getText().isEmpty()) {
                podeSalvar = false;
            }
            if (txtEndereco.getText().isEmpty()) {
                podeSalvar = false;
            }
            if (txtTelefone.getText().isEmpty()) {
                podeSalvar = false;
            }
            if (txtLogin.getText().isEmpty()) {
                podeSalvar = false;
            }
            if (String.valueOf(pswSenha.getPassword()).isEmpty()) {
                podeSalvar = false;
            }
        } catch(NullPointerException e) {
            podeSalvar = false;
        }
        
        return podeSalvar;
    }
    
    public void limparCampos() {
        txtNome.setText(null);
        txtEmail.setText(null);
        txtTelefone.setText(null);
        txtEndereco.setText(null);
        txtLogin.setText(null);
        pswSenha.setText(null);
        buttonGroup1.clearSelection();
        buttonGroup2.clearSelection();
        txtNome.grabFocus();
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
            java.util.logging.Logger.getLogger(CadastrarFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastrarFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastrarFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastrarFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastrarFuncionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblAdmin;
    private javax.swing.JLabel lblAtivado;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblNome;
    private javax.swing.JPasswordField pswSenha;
    private javax.swing.JRadioButton rbnAdimnNao;
    private javax.swing.JRadioButton rbnAdminSim;
    private javax.swing.JRadioButton rbnAtivadoNao;
    private javax.swing.JRadioButton rbnAtivadoSim;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtNome;
    private javax.swing.JFormattedTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
