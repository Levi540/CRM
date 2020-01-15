package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import model.Funcionario;
import util.Conexao;

public class FuncionarioDAO {
    private static final String INSERT = "INSERT INTO TB_FUNCIONARIO(FK_ID_PESSOA, "
            + "LOGIN_FUNCIONARIO, SENHA_FUNCIONARIO, ATIVADO, ADMIN) VALUES(?,?,?,?,?)";
    
    private  static final String UPDATE = "UPDATE TB_FUNCIONARIO SET LOGIN_FUNCIONARIO = ?, "
            + "SENHA_FUNCIONARIO = ?, ATIVADO = ?, ADMIN = ? WHERE ID = ?";
    
    private static final String DELETE = "DELETE FROM TB_FUNCIONARIO "
            + "WHERE ID = ?";
    
    private static final String FIND_ALL = "SELECT ID, FK_ID_PESSOA, LOGIN_FUNCIONARIO, "
            + "SENHA_FUNCIONARIO, ATIVADO, ADMIN FROM TB_FUNCIONARIO";
    
    private static final String FIND_BY_ID = "SELECT ID, FK_ID_PESSOA, LOGIN_FUNCIONARIO, "
            + "SENHA_FUNCIONARIO, ATIVADO, ADMIN FROM TB_FUNCIONARIO WHERE ID = ?";
    
    private static final String MAX = "SELECT ID FROM TB_FUNCIONARIO ORDER BY "
            + "ID DESC LIMIT 1";
    
    private static final String FIND_BY_LOGIN = "SELECT ID, FK_ID_PESSOA, LOGIN_FUNCIONARIO, "
            + "SENHA_FUNCIONARIO, ATIVADO, ADMIN FROM TB_FUNCIONARIO WHERE LOGIN_FUNCIONARIO = ?";
    
    private static final String FIND_ALL_LOGIN = "SELECT LOGIN_FUNCIONARIO FROM "
            + "TB_FUNCIONARIO WHERE ATIVADO = TRUE";
    
    private static final String FIND_ALL_RES = "SELECT p.nome, p.telefone, p.email, p.endereco, "
            + "f.login_funcionario, f.ativado, f.admin FROM tb_funcionario f, tb_pessoa p "
            + "where p.id = f.fk_id_pessoa";
    
    private static final String SEARCH = "SELECT p.nome, p.telefone, p.email, p.endereco, "
            + "f.login_funcionario, f.ativado, f.admin FROM tb_funcionario f, tb_pessoa p "
            + "where p.id = f.fk_id_pessoa and (select distinct p.nome like ? or "
            + "f.login_funcionario like ?)";
    
    private static final String SEARCH_LIST = "SELECT f.id, f.fk_id_pessoa, f.login_funcionario, "
            + "f.senha_funcionario, f.ativado, f.admin FROM tb_funcionario f, tb_pessoa p "
            + "where p.id = f.fk_id_pessoa and (select distinct p.nome like ? or "
            + "f.login_funcionario like ?)";
    
    private final Connection conn = Conexao.conectar();
    private PreparedStatement pstm;
    private ResultSet res;
    
    public void salvar(Funcionario f) {
        try {
            if(f.getId() <= 0) {
                pstm = conn.prepareStatement(INSERT);
                pstm.setInt(1, f.getFkIdPessoa());
                pstm.setString(2, f.getLogin());
                pstm.setString(3, f.getSenha());
                pstm.setBoolean(4, f.isAtivado());
                pstm.setBoolean(5, f.isAdmin());
                
            } else {
                pstm = conn.prepareStatement(UPDATE);
                pstm.setString(1, f.getLogin());
                pstm.setString(2, f.getSenha());
                pstm.setBoolean(3, f.isAtivado());
                pstm.setBoolean(4, f.isAdmin());
                pstm.setInt(5, f.getId());
            }
            pstm.execute();
            pstm.close();
        } catch(SQLException s) {
            System.out.println("Ocorreu um erro ao tentar "
                    + "salvar uma pessoa. Erro: " + s.getMessage());
        }
    }
    
    public List<Funcionario> getFuncionarios(boolean search, String txt) {
        List<Funcionario> funcionarios = new ArrayList<>();
        try {
            if(search) {
                pstm = conn.prepareStatement(SEARCH_LIST);
                pstm.setString(1, '%'+txt+'%');
                pstm.setString(2, '%'+txt+'%');
            } else {
                pstm = conn.prepareStatement(FIND_ALL);
            }
            res = pstm.executeQuery();
            
            while(res.next()) {
                Funcionario f = new Funcionario();
                f.setId(res.getInt("ID"));
                f.setFkIdPessoa(res.getInt("FK_ID_PESSOA"));
                f.setLogin(res.getString("LOGIN_FUNCIONARIO"));
                f.setSenha(res.getString("SENHA_FUNCIONARIO"));
                f.setAtivado(res.getBoolean("ATIVADO"));
                f.setAdmin(res.getBoolean("ADMIN"));
                funcionarios.add(f);
            }
        } catch(SQLException s) {
            System.out.println("Ocorreu um erro ao tentar "
                    + "recuperar as pessoas do banco. Erro: " + s.getMessage());
        }
        return funcionarios;
    }
    
    public ResultSet getFuncionariosRes() {
        try {
            pstm = conn.prepareStatement(FIND_ALL_RES);
            return pstm.executeQuery();
        } catch(SQLException s) {
            System.out.println("Ocorreu um erro ao tentar "
                    + "recuperar as pessoas do banco. Erro: " + s.getMessage());
        }
        return null;
    }
    
    public ResultSet searchFuncionariosRes(String txt) {
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
    
    public Funcionario getFuncionarioId(int id) {
        Funcionario f = new Funcionario();
        try {
            pstm = conn.prepareStatement(FIND_BY_ID);
            pstm.setInt(1, id);
            res = pstm.executeQuery();
            
            while(res.next()) {
                f.setId(res.getInt("ID"));
                f.setFkIdPessoa(res.getInt("FK_ID_PESSOA"));
                f.setLogin(res.getString("LOGIN_FUNCIONARIO"));
                f.setSenha(res.getString("SENHA_FUNCIONARIO"));
                f.setAtivado(res.getBoolean("ATIVADO"));
                f.setAdmin(res.getBoolean("ADMIN"));
            }
        } catch(SQLException s) {
            System.out.println("Ocorreu um erro ao tentar "
                    + "recuperar uma pessoa do banco. Erro: " + s.getMessage());
        }
        return f;
    }
    
    public Funcionario getFuncionarioLogin(String login) {
        Funcionario f = new Funcionario();
        try {
            pstm = conn.prepareStatement(FIND_BY_LOGIN);
            pstm.setString(1, login);
            res = pstm.executeQuery();
            
            while(res.next()) {
                f.setId(res.getInt("ID"));
                f.setFkIdPessoa(res.getInt("FK_ID_PESSOA"));
                f.setLogin(res.getString("LOGIN_FUNCIONARIO"));
                f.setSenha(res.getString("SENHA_FUNCIONARIO"));
                f.setAtivado(res.getBoolean("ATIVADO"));
                f.setAdmin(res.getBoolean("ADMIN"));
            }
        } catch(SQLException s) {
            System.out.println("Ocorreu um erro ao tentar "
                    + "recuperar uma pessoa do banco. Erro: " + s.getMessage());
        }
        return f;
    }
    
    public void getFuncionariosLogin(JComboBox<String> cmb) {
        
        try {
            pstm = conn.prepareStatement(FIND_ALL_LOGIN);
            res = pstm.executeQuery();
            
            while(res.next()) {
                cmb.addItem(res.getString("LOGIN_FUNCIONARIO"));
                
            }
        } catch(SQLException s) {
            System.out.println("Ocorreu um erro ao tentar "
                    + "recuperar as pessoas do banco. Erro: " + s.getMessage());
        }
    }
}
