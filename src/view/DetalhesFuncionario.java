package view;

import dao.FuncionarioDAO;
import dao.PessoaDAO;
import javax.swing.JDialog;
import model.Funcionario;
import model.Pessoa;

public class DetalhesFuncionario extends javax.swing.JFrame {

    private Funcionario f;
    private Pessoa p = new Pessoa();
    private PessoaDAO pdao = new PessoaDAO();
    private FuncionarioDAO fdao = new FuncionarioDAO();
    static JDialog detalhesFuncionarioDialog = new JDialog();
    
    public DetalhesFuncionario(Funcionario f) {
        this();
        this.f = f;
        p = pdao.getPessoaId(this.f.getFkIdPessoa());
        
        lblNome.setText("Nome: " + p.getNome());
        lblTelefone.setText("Telefone: " + p.getTelefone());
        lblEmail.setText("Email: " + p.getEmail());
        lblEndereco.setText("Endereço: " + p.getEndereco());
        lblLogin.setText("Login: " + this.f.getLogin());
        Menu.menuDialog.setTitle("Detalhes Funcionario");
    }
    
    public DetalhesFuncionario() {
        initComponents();
        detalhesFuncionarioDialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        detalhesFuncionarioDialog.setModal(true);
        detalhesFuncionarioDialog.setUndecorated(false);
        detalhesFuncionarioDialog.setResizable(false);
        detalhesFuncionarioDialog.setTitle("Editar Funcionario");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNome = new javax.swing.JLabel();
        lblTelefone = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblEndereco = new javax.swing.JLabel();
        lblLogin = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblNome.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblNome.setText("Nome:");

        lblTelefone.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTelefone.setText("Telefone:");

        lblEmail.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblEmail.setText("Email:");

        lblEndereco.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblEndereco.setText("Endereço:");

        lblLogin.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblLogin.setText("Login:");

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNome)
                    .addComponent(lblTelefone)
                    .addComponent(lblEmail)
                    .addComponent(lblEndereco)
                    .addComponent(lblLogin))
                .addContainerGap(330, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEditar)
                .addGap(18, 18, 18)
                .addComponent(btnAtualizar)
                .addGap(69, 69, 69))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTelefone)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblEndereco)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar)
                    .addComponent(btnAtualizar))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        CadastrarFuncionario AlterarFuncionario = new CadastrarFuncionario(f, f);
            detalhesFuncionarioDialog.setContentPane(AlterarFuncionario.getContentPane());
            detalhesFuncionarioDialog.setBounds(AlterarFuncionario.getBounds());
            detalhesFuncionarioDialog.setVisible(true);
            AlterarFuncionario.dispose();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        f = fdao.getFuncionarioId(f.getId());
        p = pdao.getPessoaId(this.f.getFkIdPessoa());
        lblNome.setText("Nome: " + p.getNome());
        lblTelefone.setText("Telefone: " + p.getTelefone());
        lblEmail.setText("Email: " + p.getEmail());
        lblEndereco.setText("Endereço: " + p.getEndereco());
        lblLogin.setText("Login: " + this.f.getLogin());
    }//GEN-LAST:event_btnAtualizarActionPerformed

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
            java.util.logging.Logger.getLogger(DetalhesFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetalhesFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetalhesFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetalhesFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DetalhesFuncionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblTelefone;
    // End of variables declaration//GEN-END:variables
}
