package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import model.Fornecedor;
import util.Conexao;

public class FornecedorDAO {
    private static final String INSERT = "INSERT INTO TB_FORNECEDOR(FK_ID_PESSOA, "
            + "CNPJ_FORNECEDOR, NOME_CONTATO) VALUES(?,?,?)";
    
    private static final String UPDATE = "UPDATE TB_FORNECEDOR SET CNPJ_FORNECEDOR = ?, "
            + "NOME_CONTATO = ? WHERE ID = ?";
    
    private static final String DELETE = "DELETE FROM TB_FORNECEDOR "
            + "WHERE ID = ?";
    
    private static final String FIND_ALL = "select f.nome_contato, p.email, p.telefone, "
            + "p.endereco, f.cnpj_fornecedor from tb_pessoa p "
            + "inner join tb_fornecedor f on p.id = f.fk_id_pessoa";
    
    private static final String FIND_BY_ID = "SELECT ID, FK_ID_PESSOA, CNPJ_FORNECEDOR, "
            + "NOME_CONTATO FROM TB_FORNECEDOR WHERE ID = ?";
    
    private static final String FIND_BY_CNPJ = "SELECT ID, FK_ID_PESSOA, CNPJ_FORNECEDOR, "
            + "NOME_CONTATO FROM TB_FORNECEDOR WHERE CNPJ_FORNECEDOR = ?";
    
    private static final String FIND_ALL_CNPJ = "SELECT CNPJ_FORNECEDOR FROM TB_FORNECEDOR";
    
    private static final String SEARCH = "select f.nome_contato, p.email, p.telefone, "
            + "p.endereco, f.cnpj_fornecedor from tb_pessoa p, "
            + "tb_fornecedor f where p.id = f.fk_id_pessoa and (select distinct f.cnpj_fornecedor like ? or "
            + "f.nome_contato like ?)";
    
    private final Connection conn = Conexao.conectar();
    private PreparedStatement pstm;
    private ResultSet res;
    
    public void salvar(Fornecedor f) {
        try {
            if(f.getId() <= 0) {
                pstm = conn.prepareStatement(INSERT);
                pstm.setInt(1, f.getFkIdPessoa());
                pstm.setString(2, f.getCnpj());
                pstm.setString(3, f.getNome());
            } else {
                pstm = conn.prepareStatement(UPDATE);
                pstm.setString(1, f.getCnpj());
                pstm.setString(2, f.getNome());
                pstm.setInt(3, f.getId());
            }
            pstm.execute();
            pstm.close();
        } catch(SQLException s) {
            System.out.println("Ocorreu um erro ao tentar"
                    + "salvar um fornecedor. Erro: " + s.getMessage());
        }
    }
    
    public ResultSet getFornecedoresRes() {
        try {
            pstm = conn.prepareStatement(FIND_ALL);
            return pstm.executeQuery();
            
        } catch(SQLException s) {
            System.out.println("Ocorreu um erro ao tentar "
                    + "recuperar as pessoas do banco. Erro: " + s.getMessage());
        }
        return null;
    }
    
    public ResultSet searchFornecedoresRes(String txt) {
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
    
    public Fornecedor getFornecedor(int id) {
        Fornecedor f = new Fornecedor();
        try {
            pstm = conn.prepareStatement(FIND_BY_ID);
            pstm.setInt(1, id);
            res = pstm.executeQuery();
            
            while(res.next()) {
                f.setId(res.getInt("ID"));
                f.setFkIdPessoa(res.getInt("FK_ID_PESSOA"));
                f.setCnpj(res.getString("CNPJ_FORNECEDOR"));
                f.setNome(res.getString("NOME_CONTATO"));
            }
        } catch(SQLException s) {
            System.out.println("Ocorreu um erro ao tentar "
                    + "recuperar um fornecedor do banco. Erro: " + s.getMessage());
        }
        return f;
    }
    
    public Fornecedor getFornecedorCNPJ(String Cnpj) {
        Fornecedor f = new Fornecedor();
        try {
            pstm = conn.prepareStatement(FIND_BY_CNPJ);
            pstm.setString(1, Cnpj);
            res = pstm.executeQuery();
            
            while(res.next()) {
                f.setId(res.getInt("ID"));
                f.setFkIdPessoa(res.getInt("FK_ID_PESSOA"));
                f.setCnpj(res.getString("CNPJ_FORNECEDOR"));
                f.setNome(res.getString("NOME_CONTATO"));
            }
        } catch(SQLException s) {
            System.out.println("Ocorreu um erro ao tentar "
                    + "recuperar um fornecedor do banco. Erro: " + s.getMessage());
        }
        return f;
    }
    
    public void getForndecedoresCNPJ(JComboBox<String> cmb) {
        
        try {
            pstm = conn.prepareStatement(FIND_ALL_CNPJ);
            res = pstm.executeQuery();
            
            while(res.next()) {
                cmb.addItem(res.getString("CNPJ_FORNECEDOR"));
                
            }
        } catch(SQLException s) {
            System.out.println("Ocorreu um erro ao tentar "
                    + "recuperar os fornecedores do banco. Erro: " + s.getMessage());
        }
    }
}
