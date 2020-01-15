package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Pessoa;
import util.Conexao;

public class PessoaDAO {

    private static final String INSERT = "INSERT INTO TB_PESSOA(NOME, "
            + "TELEFONE, EMAIL, ENDERECO) VALUES(?,?,?,?)";

    private static final String UPDATE = "UPDATE TB_PESSOA SET "
            + "NOME = ?, TELEFONE = ?, EMAIL = ?, ENDERECO = ? "
            + "WHERE ID = ?";

    private static final String DELETE = "DELETE FROM TB_PESSOA "
            + "WHERE ID = ?";

    private static final String FIND_ALL = "SELECT ID, NOME, "
            + "TELEFONE, EMAIL, ENDERECO FROM TB_PESSOA";

    private static final String FIND_BY_ID = "SELECT ID, NOME, "
            + "TELEFONE, EMAIL, ENDERECO FROM TB_PESSOA "
            + "WHERE ID = ?";
    
    private static final String MAX = "SELECT ID FROM TB_PESSOA ORDER BY "
            + "ID DESC LIMIT 1";

    private final Connection conn = Conexao.conectar();
    private PreparedStatement pstm;
    private ResultSet res;

    public void salvar(Pessoa p) {
        try {
            if (p.getId() <= 0) {
                //cadastrando uma nova pessoa
                pstm = conn.prepareStatement(INSERT);
                pstm.setString(1, p.getNome());
                pstm.setString(2, p.getTelefone());
                pstm.setString(3, p.getEmail());
                pstm.setString(4, p.getEndereco());
            } else {
                //alterando uma pessoa existente
                pstm = conn.prepareStatement(UPDATE);
                pstm.setString(1, p.getNome());
                pstm.setString(2, p.getTelefone());
                pstm.setString(3, p.getEmail());
                pstm.setString(4, p.getEndereco());
                pstm.setInt(5, p.getId());
            }
            pstm.execute();
            pstm.close();
        } catch (SQLException s) {
            System.out.println("Ocorreu um erro ao tentar"
                    + "salvar uma pessoa. Erro: " + s.getMessage());
        }
    }

    public void excluir(Pessoa p) {
        try {
            pstm = conn.prepareStatement(DELETE);
            pstm.setInt(1, p.getId());
            pstm.execute();
            pstm.close();
        } catch (SQLException s) {
            System.out.println("Ocorreu um erro ao tentar"
                    + "excluir uma pessoa. Erro: " + s.getMessage());
        }
    }

    public List<Pessoa> getPessoas() {
        List<Pessoa> pessoas = new ArrayList<>();
        try {
            pstm = conn.prepareStatement(FIND_ALL);
            res = pstm.executeQuery();

            while (res.next()) {
                Pessoa p = new Pessoa();
                p.setId(res.getInt("ID"));
                p.setNome(res.getString("NOME"));
                p.setTelefone(res.getString("TELEFONE"));
                p.setEmail(res.getString("EMAIL"));
                p.setEndereco(res.getString("ENDERECO"));
                pessoas.add(p);
            }

        } catch (SQLException s) {
            System.out.println("Ocorreu um erro ao tentar"
                    + "recuperar as pessoas do banco. Erro: " + s.getMessage());
        }
        return pessoas;
    }

    public Pessoa getPessoaId(int id) {
        Pessoa p = new Pessoa();
        try {
            pstm = conn.prepareStatement(FIND_BY_ID);
            pstm.setInt(1, id);
            res = pstm.executeQuery();

            while (res.next()) {
                p.setId(res.getInt("ID"));
                p.setNome(res.getString("NOME"));
                p.setTelefone(res.getString("TELEFONE"));
                p.setEmail(res.getString("EMAIL"));
                p.setEndereco(res.getString("ENDERECO"));                
            }

        } catch (SQLException s) {
            System.out.println("Ocorreu um erro ao tentar"
                    + "recuperar uma pessoa do banco. Erro: " + s.getMessage());
        }
        return p;
    }
    
    public int getMaxId() {
        Pessoa p = new Pessoa();
        try {
            pstm = conn.prepareStatement(MAX);
            res = pstm.executeQuery();
            
            while(res.next()) {
                p.setId(res.getInt("ID"));
            }
        } catch(SQLException s) {
            System.out.println("Ocorreu um erro ao tentar"
                    + "recuperar uma pessoa do banco. Erro: " + s.getMessage());
        }
        return p.getId();
    }
}
