package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.VendaProduto;
import util.Conexao;

public class VendaProdutoDAO {
    private static final String INSERT = "INSERT INTO TB_VENDA_PRODUTO(FK_ID_VENDA, "
            + "FK_ID_PRODUTO, QTDE_VENDIDA, PRECO_UNIDADE) VALUES(?,?,?,?)";
    
    private static final String FIND_BY_ID = "select p.nome_produto, vp.qtde_vendida, "
            + "vp.preco_unidade from tb_venda_produto vp, tb_produto p where p.id = vp.fk_id_produto "
            + "and fk_id_venda = ?";
    
    private final Connection conn = Conexao.conectar();
    private PreparedStatement pstm;
    private ResultSet res;
    
    public void salvar(VendaProduto v) {
        try {
            if(v.getId() <= 0) {
                pstm = conn.prepareStatement(INSERT);
                pstm.setInt(1, v.getFkIdVenda());
                pstm.setInt(2, v.getFkIdProduto());
                pstm.setInt(3, v.getQtdeVendida());
                pstm.setDouble(4, v.getPrecoUnidade());
            }
            pstm.execute();
            pstm.close();
        } catch(SQLException s) {
            System.out.println("Ocorreu um erro ao tentar "
                    + "salvar uma venda. Erro: " + s.getMessage());
        }
    }
    
    public ResultSet getClientesRes(int id) {
        try {
            pstm = conn.prepareStatement(FIND_BY_ID);
            pstm.setInt(1, id);
            return pstm.executeQuery();
            
        } catch(SQLException s) {
            System.out.println("Ocorreu um erro ao tentar "
                    + "recuperar as pessoas do banco. Erro: " + s.getMessage());
        }
        return null;
    }
}
