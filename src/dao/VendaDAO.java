package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Venda;
import util.Conexao;

public class VendaDAO {
    private static final String INSERT = "INSERT INTO TB_VENDA(FK_ID_CLIENTE, "
            + "DATA_VENDA, VALOR_VENDA) VALUES(?,?,?)";
    
    private static final String UPDATE = "UPDATE TB_VENDA SET FK_ID_CLIENTE = ?, "
            + "DATA_VENDA = ?, VALOR_VENDA = ? WHERE ID = ?";
    
    private static final String DELETE = "DELETE FROM TB_VENDA "
            + "WHERE ID = ?";
    
    private static final String FIND_ALL = "select v.id as id_Venda, p.nome, v.data_venda, v.valor_venda "
            + "from tb_pessoa p inner join tb_cliente c, tb_venda v where c.id = v.fk_id_cliente "
            + "and p.id = c.fk_id_pessoa";
    
    private static final String FIND_BY_ID = "SELECT ID, FK_ID_CLIENTE, DATA_VENDA, "
            + "VALOR_VENDA FROM TB_VENDA WHERE ID = ?";
    
    private static final String MAX = "SELECT ID FROM TB_VENDA ORDER BY "
            + "ID DESC LIMIT 1";
    
    private static final String SEARCH = "select v.id as id_Venda, p.nome, v.data_venda, v.valor_venda "
            + "from tb_pessoa p inner join tb_cliente c, tb_venda v where c.id = v.fk_id_cliente "
            + "and p.id = c.fk_id_pessoa and (select distinct c.cpf like ? or v.data_venda like ?)";
    
    private static final String SEARCH_TODOS_CAMPOS = "select v.id as id_Venda, p.nome, v.data_venda, v.valor_venda "
            + "from tb_pessoa p inner join tb_cliente c, tb_venda v where c.id = v.fk_id_cliente "
            + "and p.id = c.fk_id_pessoa and (select distinct c.cpf like ? and v.data_venda like ?)";
    
    private final Connection conn = Conexao.conectar();
    private PreparedStatement pstm;
    private ResultSet res;
    
    public void salvar(Venda v) {
        try {
            if(v.getId() <= 0) {
                pstm = conn.prepareStatement(INSERT);
                pstm.setInt(1, v.getFkIdCliente());
                pstm.setString(2, v.getDataVenda());
                pstm.setDouble(3, v.getValor());
            } else {
                pstm = conn.prepareStatement(UPDATE);
                pstm.setInt(1, v.getFkIdCliente());
                pstm.setString(2, v.getDataVenda());
                pstm.setDouble(3, v.getValor());
                pstm.setInt(4, v.getId());
            }
            pstm.execute();
            pstm.close();
        } catch(SQLException s) {
            System.out.println("Ocorreu um erro ao tentar"
                    + "salvar uma venda. Erro: " + s.getMessage());
        }
    }
    
    public void excluir(Venda v) {
        try {
            pstm = conn.prepareStatement(DELETE);
            pstm.setInt(1, v.getId());
            pstm.execute();
            pstm.close();
        } catch (SQLException s) {
            System.out.println("Ocorreu um erro ao tentar"
                    + "excluir uma venda. Erro: " + s.getMessage());
        }
    }
    
    public ResultSet getVendasRes() {
        try {
            pstm = conn.prepareStatement(FIND_ALL);
            return pstm.executeQuery();
            
        } catch(SQLException s) {
            System.out.println("Ocorreu um erro ao tentar "
                    + "recuperar as vendas do banco. Erro: " + s.getMessage());
        }
        return null;
    }
    
    public ResultSet searchVendasRes(String cpf, String data, boolean or) {
        try {
            if(or) {
                pstm = conn.prepareStatement(SEARCH);
            } else {
                pstm = conn.prepareStatement(SEARCH_TODOS_CAMPOS);
            }
            pstm.setString(1, cpf);
            pstm.setString(2, data);
            return pstm.executeQuery();
            
        } catch(SQLException s) {
            System.out.println("Ocorreu um erro ao tentar "
                    + "recuperar as vendas do banco. Erro: " + s.getMessage());
        }
        return null;
    }
    
    public Venda getVendaId(int id) {
        Venda v = new Venda();
        try {
            pstm = conn.prepareStatement(FIND_BY_ID);
            pstm.setInt(1, id);
            res = pstm.executeQuery();
            
            while(res.next()) {
                v.setId(res.getInt("ID"));
                v.setFkIdCliente(res.getInt("FK_ID_CLIENTE"));
                v.setDataVenda(res.getString("DATA_VENDA"));
                v.setValor(res.getDouble("VALOR_VENDA"));
            }
        } catch(SQLException s) {
            System.out.println("Ocorreu um erro ao tentar "
                    + "recuperar uma venda do banco. Erro: " + s.getMessage());
        }
        return v;
    }
    
    public int getMaxId() {
        Venda v = new Venda();
        try {
            pstm = conn.prepareStatement(MAX);
            res = pstm.executeQuery();
            
            while(res.next()) {
                v.setId(res.getInt("ID"));
            }
        } catch(SQLException s) {
            System.out.println("Ocorreu um erro ao tentar "
                    + "recuperar uma venda do banco. Erro: " + s.getMessage());
        }
        return v.getId();
    }
}
