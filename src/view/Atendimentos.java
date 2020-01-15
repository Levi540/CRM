package view;

import dao.AtendimentoDAO;
import dao.ClienteDAO;
import dao.FuncionarioDAO;
import dao.ProdutoDAO;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import model.Atendimento;
import model.Cliente;
import model.Funcionario;
import model.Produto;

public class Atendimentos extends javax.swing.JFrame {

    private ClienteDAO cdao = new ClienteDAO();
    private ProdutoDAO pdao = new ProdutoDAO();
    private FuncionarioDAO fdao = new FuncionarioDAO();
    private Atendimento a = new Atendimento();
    private AtendimentoDAO adao = new AtendimentoDAO();
    private Produto p = new Produto();
    private Cliente c = new Cliente();
    private Funcionario f;
    
    
    public Atendimentos(Atendimento a) {
        initComponents();
        
        this.a = adao.getAtendimentoId(a.getId());
        this.txtTituloOcorrencia.setText(this.a.getTitulo());
        this.txtObservacoes.setText(this.a.getDetalhes());
        if(this.a.isConcluido()) {
            rbtSim.setSelected(true);
        } else {
            rbtNao.setSelected(true);
        }
        
        p = pdao.getProdutoId(this.a.getFkIdProduto());
        this.cmbProduto.addItem(p.getNome());
        
        c = cdao.getClienteId(this.a.getFkIdCliente());
        this.cmbCliente.addItem(c.getCpf());
        
        f = fdao.getFuncionarioId(this.a.getFkIdFuncionario());
        lblLoginFuncionario.setText(f.getLogin());
        HistoricoAtendimentos.atendimentoDialog.setTitle("Editar atendimento");
    }
    
    public Atendimentos(Funcionario f) {
        this();
        this.f = f;
        lblLoginFuncionario.setText(f.getLogin());
    }
    
    public Atendimentos() {
        initComponents();
        setLocationRelativeTo(null);
        pdao.getProdutosNome(cmbProduto);
        cdao.getClientesCPF(cmbCliente);
        HistoricoAtendimentos.atendimentoDialog.setTitle("Novo atendimento");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        txtTituloOcorrencia = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cmbProduto = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cmbCliente = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        rbtSim = new javax.swing.JRadioButton();
        rbtNao = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtObservacoes = new javax.swing.JTextArea();
        btnSalvar = new javax.swing.JButton();
        lblLoginFuncionario = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Atendimento");
        setResizable(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Titulo da ocorrência:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Produto:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Cliente:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Funcionário responsável:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Concluida?");

        buttonGroup1.add(rbtSim);
        rbtSim.setText("Sim");
        rbtSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtSimActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbtNao);
        rbtNao.setText("Não");
        rbtNao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtNaoActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Observações:");

        txtObservacoes.setColumns(20);
        txtObservacoes.setRows(5);
        jScrollPane1.setViewportView(txtObservacoes);

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/salvar.png"))); // NOI18N
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        lblLoginFuncionario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblLoginFuncionario.setText("Login");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(rbtSim)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(rbtNao))
                        .addComponent(jScrollPane1)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTituloOcorrencia, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblLoginFuncionario))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTituloOcorrencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(cmbProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblLoginFuncionario))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(rbtSim)
                    .addComponent(rbtNao))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if(verificarCampos()) {
            if(a.getId() <= 0) {
                Date d = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                c.setCpf(cmbCliente.getSelectedItem().toString());
                p.setNome(cmbProduto.getSelectedItem().toString());
                pdao.getProdutoNome(p);

                c = cdao.getClienteCPF(c);
                a.setFkIdCliente(c.getId());
                a.setFkIdProduto(p.getId());
                a.setFkIdFuncionario(f.getId());
                a.setTitulo(txtTituloOcorrencia.getText());
                a.setDataAtendimento(sdf.format(d));
                a.setDetalhes(txtObservacoes.getText());
                adao.salvar(a);
                limparCampos();
            } else {
                a.setTitulo(txtTituloOcorrencia.getText());
                a.setDetalhes(txtObservacoes.getText());
                adao.salvar(a);
                HistoricoAtendimentos.atendimentoDialog.dispose();
                this.dispose();
            }
            
            
        } else {
            JOptionPane.showMessageDialog(rootPane, "Todos os campos são obrigatórios!!");
        }
        
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void rbtSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtSimActionPerformed
        a.setConcluido(true);
    }//GEN-LAST:event_rbtSimActionPerformed

    private void rbtNaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtNaoActionPerformed
        a.setConcluido(false);
    }//GEN-LAST:event_rbtNaoActionPerformed

    public void limparCampos() {
        txtTituloOcorrencia.setText(null);
        txtObservacoes.setText(null);
        txtTituloOcorrencia.grabFocus();
    }
    
    public boolean verificarCampos() {
        boolean podeSalvar = true;

        if (cmbCliente.getSelectedItem().toString().isEmpty()) {
            podeSalvar = false;
        } else if (cmbProduto.getSelectedItem().toString().isEmpty()) {
            podeSalvar = false;
        } else if (txtTituloOcorrencia.getText().isEmpty()) {
            podeSalvar = false;
        }
        return podeSalvar;
    }
    
    
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
            java.util.logging.Logger.getLogger(Atendimentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Atendimentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Atendimentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Atendimentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Atendimentos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cmbCliente;
    private javax.swing.JComboBox<String> cmbProduto;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblLoginFuncionario;
    private javax.swing.JRadioButton rbtNao;
    private javax.swing.JRadioButton rbtSim;
    private javax.swing.JTextArea txtObservacoes;
    private javax.swing.JTextField txtTituloOcorrencia;
    // End of variables declaration//GEN-END:variables
}
