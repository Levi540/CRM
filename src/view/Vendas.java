package view;

import dao.ClienteDAO;
import dao.ProdutoDAO;
import dao.VendaDAO;
import dao.VendaProdutoDAO;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Cliente;
import model.Produto;
import model.Venda;
import model.VendaProduto;

public class Vendas extends javax.swing.JFrame {

    private ClienteDAO cdao = new ClienteDAO();
    private ProdutoDAO pdao = new ProdutoDAO();
    private Cliente c = new Cliente();
    private Produto p = new Produto();
    private Venda v = new Venda();
    private VendaDAO vdao = new VendaDAO();
    private VendaProduto vp = new VendaProduto();
    private VendaProdutoDAO vpdao = new VendaProdutoDAO();
    private List<VendaProduto> vendaProdutos = new ArrayList<>();
    private List<Produto> qtdeEstoque = new ArrayList<>();
    private double valorTotal = 0.0;
    private int i = 0;
    private DefaultTableModel model = new DefaultTableModel();
    
    public Vendas() {
        initComponents();
        cdao.getClientesCPF(cmbCliente);
        pdao.getProdutosNome(cmbProduto);
        model.addColumn("Produto");
        model.addColumn("Quantidade");
        model.addColumn("Valor unidade");
        tblProdutos.setDefaultEditor(Object.class, null);
        HistoricoVendas.vendasDialog.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        HistoricoVendas.vendasDialog.setTitle("Venda");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCliente = new javax.swing.JLabel();
        cmbCliente = new javax.swing.JComboBox<>();
        lblProduto = new javax.swing.JLabel();
        cmbProduto = new javax.swing.JComboBox<>();
        lblQuantidade = new javax.swing.JLabel();
        txtQtde = new javax.swing.JTextField();
        btnAdicionar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProdutos = new javax.swing.JTable();
        btnRemover = new javax.swing.JButton();
        btnFinalizarVenda = new javax.swing.JButton();
        lblTotal = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Vendas");
        setResizable(false);

        lblCliente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblCliente.setText("CPF Cliente:");

        cmbCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbClienteActionPerformed(evt);
            }
        });

        lblProduto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblProduto.setText("Produto:");

        lblQuantidade.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblQuantidade.setText("Quantidade:");

        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        tblProdutos.setModel(model);
        tblProdutos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblProdutos);

        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        btnFinalizarVenda.setText("Finalizar Venda");
        btnFinalizarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarVendaActionPerformed(evt);
            }
        });

        lblTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTotal.setText("Total: ");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblQuantidade)
                            .addComponent(lblProduto)
                            .addComponent(lblCliente))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtQtde, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnAdicionar)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(cmbProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemover)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTotal)
                            .addComponent(btnFinalizarVenda))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCliente)
                    .addComponent(cmbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProduto)
                    .addComponent(cmbProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQuantidade)
                    .addComponent(txtQtde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdicionar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRemover)
                    .addComponent(btnFinalizarVenda)
                    .addComponent(btnCancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTotal)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmbClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbClienteActionPerformed
        
    }//GEN-LAST:event_cmbClienteActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        if(verificarCampos()) {
            try {
                VendaProduto vpNovo = new VendaProduto();
                Produto pNovo = new Produto();
                pNovo.setNome(cmbProduto.getSelectedItem().toString());
                pdao.getProdutoNome(pNovo);
                boolean estaNaLista = false;
                
                if(!qtdeEstoque.isEmpty()) {
                    for(int index = 0; index < qtdeEstoque.size(); index++) {
                        Produto pNovo2;
                        pNovo2 = qtdeEstoque.get(index);
                        if(pNovo2.getId() == pNovo.getId()) {
                            estaNaLista = true;
                            break;
                        }
                    }
                }

                vpNovo.setQtdeVendida(Integer.parseInt(txtQtde.getText()));
                
                if((pNovo.getQtdEstoque() - Integer.parseInt(txtQtde.getText()) >= 0) && 
                        vpNovo.getQtdeVendida() > 0 && !estaNaLista) {
                    
                    if(i == 0) {
                        c.setCpf(cmbCliente.getSelectedItem().toString());
                        c = cdao.getClienteCPF(c);
                        v.setFkIdCliente(c.getId());
                        cmbCliente.setEnabled(false);
                    }
                    
                    pNovo.setQtdEstoque(pNovo.getQtdEstoque() - Integer.parseInt(txtQtde.getText()));
                    qtdeEstoque.add(pNovo);
                    
                    valorTotal += pNovo.getPrecoVenda() * vpNovo.getQtdeVendida();
                    lblTotal.setText("Total: " + String.format("%.2f", valorTotal));
                    vpNovo.setFkIdProduto(pNovo.getId());

                    if(i == 0) {
                        vdao.salvar(v);
                        v.setId(vdao.getMaxId());
                    }
                    vpNovo.setFkIdVenda(v.getId());
                    vpNovo.setPrecoUnidade(pNovo.getPrecoVenda());

                    vendaProdutos.add(vpNovo);

                    model.insertRow(i, new Object[] {pNovo.getNome(), vpNovo.getQtdeVendida(), pNovo.getPrecoVenda()});
                    tblProdutos.setModel(model);
                    txtQtde.setText(null);
                    i++;
                } else if(vpNovo.getQtdeVendida() <= 0) {
                    JOptionPane.showMessageDialog(rootPane, "Quantidade pedida está <= 0!");
                } else if(estaNaLista) {
                    JOptionPane.showMessageDialog(rootPane, "Não foi possivel adicionar!\n"
                            + "O produto já está na lista");
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Quantidade pedida está acima da "
                            + "quantidade de estoque!\n" + pNovo.getQtdEstoque());
                }
                
            } catch(NumberFormatException e) {
                JOptionPane.showMessageDialog(rootPane, "Informe apenas números!" + 
                        e.getMessage());
            }
            
        } else {
            JOptionPane.showMessageDialog(rootPane, "Todos os campos são obrigatórios!!");
        }
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnFinalizarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarVendaActionPerformed
        if(i <= 0) {
            JOptionPane.showMessageDialog(rootPane, "A venda não pode ser finalizada\n"
                    + "sem item na lista");
        } else {
            Date date = new Date(System.currentTimeMillis());
            SimpleDateFormat formatarDate = new SimpleDateFormat("yyyy-MM-dd");

            v.setValor(valorTotal);
            v.setDataVenda(formatarDate.format(date));
            vdao.salvar(v);
            for(int j = 0; j < vendaProdutos.size(); j++) {
                vp = vendaProdutos.get(j);
                vpdao.salvar(vp);
            }
            for(int cont = 0; cont < qtdeEstoque.size(); cont++) {
                p = qtdeEstoque.get(cont);
                pdao.salvar(p);
            }
            HistoricoVendas.vendasDialog.dispose();
            this.dispose();
        }
        
        
    }//GEN-LAST:event_btnFinalizarVendaActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        try {
            int selectedRow = tblProdutos.getSelectedRow();
            vp = vendaProdutos.get(selectedRow);
            p = pdao.getProdutoId(vp.getFkIdProduto());
            valorTotal -= (vp.getQtdeVendida() * p.getPrecoVenda());
            
            vendaProdutos.remove(selectedRow);
            qtdeEstoque.remove(selectedRow);
            model.removeRow(selectedRow);
            lblTotal.setText("Total: " + String.format("%.2f", valorTotal));
            i = model.getRowCount();
        } catch(ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(rootPane, "Nenhum item selecionado");
        } catch(IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(rootPane, "Lista está vazia");
        }
        
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if(v.getId() > 0) {
            vdao.excluir(v);
        }
        HistoricoVendas.vendasDialog.dispose();
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed
    
    public boolean verificarCampos() {
        boolean podeSalvar = true;

        if (cmbCliente.getSelectedItem().toString().isEmpty()) {
            podeSalvar = false;
        } else if (cmbProduto.getSelectedItem().toString().isEmpty()) {
            podeSalvar = false;
        } else if (txtQtde.getText().isEmpty()) {
            podeSalvar = false;
        }
        return podeSalvar;
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
            java.util.logging.Logger.getLogger(Vendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vendas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnFinalizarVenda;
    private javax.swing.JButton btnRemover;
    private javax.swing.JComboBox<String> cmbCliente;
    private javax.swing.JComboBox<String> cmbProduto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblProduto;
    private javax.swing.JLabel lblQuantidade;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tblProdutos;
    private javax.swing.JTextField txtQtde;
    // End of variables declaration//GEN-END:variables
}
