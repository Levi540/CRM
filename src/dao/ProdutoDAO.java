package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import model.Produto;
import util.Conexao;

public class ProdutoDAO {
    private static final String INSERT = "INSERT INTO TB_PRODUTO(FK_ID_FORNECEDOR, "
            + "NOME_PRODUTO, QTDE_ESTOQUE, PRECO_CUSTO, PRECO_VENDA) VALUES(?,?,?,?,?)";
    
    private static final String UPDATE = "UPDATE TB_PRODUTO SET FK_ID_FORNECEDOR = ?, "
            + "NOME_PRODUTO = ?, QTDE_ESTOQUE = ?, PRECO_CUSTO = ?, PRECO_VENDA = ? "
            + "WHERE ID = ?";
    
    private static final String DELETE = "DELETE FROM TB_PRODUTO "
            + "WHERE ID = ?";
    
    private static final String FIND_ALL = "select id, nome_produto, qtde_estoque, "
            + "preco_venda from tb_produto";
    
    private static final String FIND_BY_ID = "SELECT ID, FK_ID_FORNECEDOR, NOME_PRODUTO, "
            + "QTDE_ESTOQUE, PRECO_CUSTO, PRECO_VENDA FROM TB_PRODUTO "
            + "WHERE ID = ?";
    
    private static final String FIND_ALL_NOME = "SELECT NOME_PRODUTO FROM TB_PRODUTO";
    
    private static final String FIND_BY_NOME = "SELECT ID, FK_ID_FORNECEDOR, "
            + "NOME_PRODUTO, QTDE_ESTOQUE, PRECO_CUSTO, PRECO_VENDA FROM TB_PRODUTO "
            + "WHERE NOME_PRODUTO = ?";
    
    private static final String SEARCH = "select id, nome_produto, qtde_estoque, "
            + "preco_venda from tb_produto where nome_produto like ? or id = ?";
    
    private final Connection conn = Conexao.conectar();
    private PreparedStatement pstm;
    private ResultSet res;
    
    public void salvar(Produto p) {
        try {
            if(p.getId() <= 0) {
                pstm = conn.prepareStatement(INSERT);
                pstm.setInt(1, p.getFkIdFornecedor());
                pstm.setString(2, p.getNome());
                pstm.setInt(3, p.getQtdEstoque());
                pstm.setDouble(4, p.getPrecoCusto());
                pstm.setDouble(5, p.getPrecoVenda());
            } else {
                pstm = conn.prepareStatement(UPDATE);
                pstm.setInt(1, p.getFkIdFornecedor());
                pstm.setString(2, p.getNome());
                pstm.setInt(3, p.getQtdEstoque());
                pstm.setDouble(4, p.getPrecoCusto());
                pstm.setDouble(5, p.getPrecoVenda());
                pstm.setInt(6, p.getId());
            }
            pstm.execute();
            pstm.close();
        } catch(SQLException s) {
            System.out.println("Ocorreu um erro ao tentar"
                    + "salvar um produto. Erro: " + s.getMessage());
        }
    }
    
    public ResultSet getProdutosRes() {
        try {
            pstm = conn.prepareStatement(FIND_ALL);
            return pstm.executeQuery();
            
        } catch(SQLException s) {
            System.out.println("Ocorreu um erro ao tentar "
                    + "recuperar os produtos do banco. Erro: " + s.getMessage());
        }
        return null;
    }
    
    public ResultSet searchProdutosRes(String txt, int id) {
        try {
            pstm = conn.prepareStatement(SEARCH);
            pstm.setString(1, "%"+txt+"%");
            pstm.setInt(2, id);
            return pstm.executeQuery();
            
        } catch(SQLException s) {
            System.out.println("Ocorreu um erro ao tentar "
                    + "recuperar os produtos do banco. Erro: " + s.getMessage());
        }
        return null;
    }
    
    public Produto getProdutoId(int id) {
        Produto p = new Produto();
        try {
            pstm = conn.prepareStatement(FIND_BY_ID);
            pstm.setInt(1, id);
            res = pstm.executeQuery();
            
            while(res.next()) {
                p.setId(res.getInt("ID"));
                p.setFkIdFornecedor(res.getInt("FK_ID_FORNECEDOR"));
                p.setNome(res.getString("NOME_PRODUTO"));
                p.setQtdEstoque(res.getInt("QTDE_ESTOQUE"));
                p.setPrecoCusto(res.getDouble("PRECO_CUSTO"));
                p.setPrecoVenda(res.getDouble("PRECO_VENDA"));
            }

        } catch(SQLException s) {
            System.out.println("Ocorreu um erro ao tentar"
                    + "recuperar um produto do banco. Erro: " + s.getMessage());
        }
        return p;
    }
    
    public void getProdutosNome(JComboBox<String> cmb) {
        
        try {
            pstm = conn.prepareStatement(FIND_ALL_NOME);
            res = pstm.executeQuery();
            
            while(res.next()) {
                cmb.addItem(res.getString("NOME_PRODUTO"));
                
            }
        } catch(SQLException s) {
            System.out.println("Ocorreu um erro ao tentar "
                    + "recuperar os produtos do banco. Erro: " + s.getMessage());
        }
    }
    
    public void getProdutoNome(Produto p) {
        
        try {
            pstm = conn.prepareStatement(FIND_BY_NOME);
            pstm.setString(1, p.getNome());
            res = pstm.executeQuery();
            
            while(res.next()) {
                p.setId(res.getInt("ID"));
                p.setFkIdFornecedor(res.getInt("FK_ID_FORNECEDOR"));
                p.setNome(res.getString("NOME_PRODUTO"));
                p.setQtdEstoque(res.getInt("QTDE_ESTOQUE"));
                p.setPrecoCusto(res.getDouble("PRECO_CUSTO"));
                p.setPrecoVenda(res.getDouble("PRECO_VENDA"));
                
            }
        } catch(SQLException s) {
            System.out.println("Ocorreu um erro ao tentar "
                    + "recuperar os produtos do banco. Erro: " + s.getMessage());
        }
    }
}
