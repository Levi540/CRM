package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import model.Cliente;
import util.Conexao;

public class ClienteDAO {
    private static final String INSERT = "INSERT INTO TB_CLIENTE(FK_ID_PESSOA, "
            + "CPF) VALUES(?,?)";
    
    private static final String UPDATE = "UPDATE TB_CLIENTE SET "
            + "CPF = ? WHERE ID = ?";
    
    
    private  static final String FIND_ALL = "select 		p.nome,\n" +
                                "				p.email,\n" +
                                "				p.telefone,\n" +
                                "				p.endereco,\n" +
                                "				c.cpf\n" +
                                            "from			tb_pessoa p \n" +
                                            "inner join 	tb_cliente c on p.id = c.fk_id_pessoa";
    
    private  static final String FIND_BY_ID = "SELECT ID, FK_ID_PESSOA, CPF "
            + "FROM TB_CLIENTE WHERE ID = ?";
    
    private  static final String FIND_ALL_CPF = "SELECT CPF FROM TB_CLIENTE";
    
    private  static final String FIND_BY_CPF = "SELECT ID, FK_ID_PESSOA, CPF "
            + "FROM TB_CLIENTE WHERE CPF = ?";
    
    private static final String SEARCH = "select p.nome, p.email, p.telefone, p.endereco, "
            + "c.cpf from tb_pessoa p, tb_cliente c where p.id = c.fk_id_pessoa and "
            + "(select distinct p.nome like ? or c.cpf like ?)";
    
    private final Connection conn = Conexao.conectar();
    private PreparedStatement pstm;
    private ResultSet res;
    
    public void salvar(Cliente c) {
        try {
            if(c.getId() <= 0) {
                pstm = conn.prepareCall(INSERT);
                pstm.setInt(1, c.getFkIdPessoa());
                pstm.setString(2, c.getCpf());
            } else {
                pstm = conn.prepareCall(UPDATE);
                pstm.setString(1, c.getCpf());
                pstm.setInt(2, c.getId());
            }
            pstm.execute();
            pstm.close();
        } catch(SQLException s) {
            System.out.println("Ocorreu um erro ao tentar"
                    + "salvar uma pessoa. Erro: " + s.getMessage());
        }
    }
    
    public ResultSet getClientesRes() {
        try {
            pstm = conn.prepareStatement(FIND_ALL);
            return pstm.executeQuery();
            
        } catch(SQLException s) {
            System.out.println("Ocorreu um erro ao tentar "
                    + "recuperar as pessoas do banco. Erro: " + s.getMessage());
        }
        return null;
    }
    
    public ResultSet searchClientesRes(String txt) {
        try {
            pstm = conn.prepareStatement(SEARCH);
            pstm.setString(1, '%'+txt+'%');
            pstm.setString(2, '%'+txt+'%');
            return pstm.executeQuery();
            
        } catch(SQLException s) {
            System.out.println("Ocorreu um erro ao tentar "
                    + "recuperar as pessoas do banco. Erro: " + s.getMessage());
        }
        return null;
    }
    
    public Cliente getClienteId(int id) {
        Cliente c = new Cliente();
        try {
            pstm = conn.prepareStatement(FIND_BY_ID);
            pstm.setInt(1, id);
            res = pstm.executeQuery();
            
            while(res.next()) {
                c.setId(res.getInt("ID"));
                c.setFkIdPessoa(res.getInt("FK_ID_PESSOA"));
                c.setCpf(res.getString("CPF"));
            }
        } catch(SQLException s) {
            System.out.println("Ocorreu um erro ao tentar "
                    + "recuperar uma pessoa do banco. Erro: " + s.getMessage());
        }
        return c;
    }
    
    public void getClientesCPF(JComboBox<String> cmb) {
        
        try {
            pstm = conn.prepareStatement(FIND_ALL_CPF);
            res = pstm.executeQuery();
            
            while(res.next()) {
                cmb.addItem(res.getString("CPF"));
                
            }
        } catch(SQLException s) {
            System.out.println("Ocorreu um erro ao tentar "
                    + "recuperar as pessoas do banco. Erro: " + s.getMessage());
        }
    }
    
    public Cliente getClienteCPF(Cliente c) {
        
        try {
            pstm = conn.prepareStatement(FIND_BY_CPF);
            pstm.setString(1, c.getCpf());
            res = pstm.executeQuery();
            
            while(res.next()) {
                c.setId(res.getInt("ID"));
                c.setFkIdPessoa(res.getInt("FK_ID_PESSOA"));
                c.setCpf(res.getString("CPF"));
            }
        } catch(SQLException s) {
            System.out.println("Ocorreu um erro ao tentar "
                    + "recuperar as pessoas do banco. Erro: " + s.getMessage());
        }
        return c;
    }
}
