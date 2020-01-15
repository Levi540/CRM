package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Visita;
import util.Conexao;

public class VisitaDAO {
    private static final String INSERT = "INSERT INTO TB_VISITA(FK_ID_FUNCIONARIO, "
            + "FK_ID_CLIENTE, DATA_VISITA, CONCLUIDO, DETALHES) VALUES(?,?,?,?,?)";
    
    private static final String UPDATE = "UPDATE TB_VISITA SET DATA_VISITA = ?, CONCLUIDO = ?,"
            + " DETALHES = ? WHERE ID = ?";
    
    private static final String DELETE = "DELETE FROM TB_VISITA WHERE ID = ?";
    
    private static final String FIND_ALL = "select v.id as ID_Visita, p.nome, v.data_visita, v.concluido "
            + "from tb_pessoa p inner join tb_visita v, tb_cliente c where p.id = c.fk_id_pessoa "
            + "and c.id = v.fk_id_cliente";
    
    private static final String FIND_BY_ID = "SELECT ID, FK_ID_FUNCIONARIO, FK_ID_CLIENTE,"
            + " DATA_VISITA, CONCLUIDO, DETALHES FROM TB_VISITA WHERE ID = ?";
    
    private static final String SEARCH = "select v.id as ID_Visita, p.nome, v.data_visita, v.concluido "
            + "from tb_pessoa p inner join tb_visita v, tb_cliente c where p.id = c.fk_id_pessoa "
            + "and c.id = v.fk_id_cliente and (select distinct p.nome like ? or c.cpf like ?)";
    
    private final Connection conn = Conexao.conectar();
    private PreparedStatement pstm;
    private ResultSet res;
    
    public void salvar(Visita v) {
        try {
            if(v.getId() <= 0) {
                pstm = conn.prepareStatement(INSERT);
                pstm.setInt(1, v.getFkIdFuncionario());
                pstm.setInt(2, v.getFkIdCliente());
                pstm.setString(3, v.getData());
                pstm.setString(4, String.valueOf(v.getConcluido()));
                pstm.setString(5, v.getDetalhes());
            } else {
                pstm = conn.prepareStatement(UPDATE);
                pstm.setString(1, v.getData());
                pstm.setString(2, String.valueOf(v.getConcluido()));
                pstm.setString(3, v.getDetalhes());
                pstm.setInt(4, v.getId());
            }
            pstm.execute();
            pstm.close();
        } catch(SQLException s) {
            System.out.println("Ocorreu um erro ao tentar"
                    + "salvar uma visita. Erro: " + s.getMessage());
        }
    }
    
    public ResultSet getVisitasRes() {
        try {
            pstm = conn.prepareStatement(FIND_ALL);
            return pstm.executeQuery();
            
        } catch(SQLException s) {
            System.out.println("Ocorreu um erro ao tentar "
                    + "recuperar as pessoas do banco. Erro: " + s.getMessage());
        }
        return null;
    }
    
    public ResultSet searchVisitasRes(String txt) {
        try {
            pstm = conn.prepareStatement(SEARCH);
            pstm.setString(1, "%"+txt+"%");
            pstm.setString(2, "%"+txt+"%");
            return pstm.executeQuery();
            
        } catch(SQLException s) {
            System.out.println("Ocorreu um erro ao tentar "
                    + "recuperar as pessoas do banco. Erro: " + s.getMessage());
        }
        return null;
    }
    
    public Visita getVisitaId(int id) {
        Visita v = new Visita();
        try {
            pstm = conn.prepareStatement(FIND_BY_ID);
            pstm.setInt(1, id);
            res = pstm.executeQuery();
            
            while(res.next()) {
                v.setId(res.getInt("ID"));
                v.setFkIdFuncionario(res.getInt("FK_ID_FUNCIONARIO"));
                v.setFkIdCliente(res.getInt("FK_ID_CLIENTE"));
                v.setData(res.getString("DATA_VISITA"));
                v.setConcluido(res.getString("CONCLUIDO"));
                v.setDetalhes(res.getString("DETALHES"));
            }
        } catch(SQLException s) {
            System.out.println("Ocorreu um erro ao tentar "
                    + "recuperar uma visita do banco. Erro: " + s.getMessage());
        }
        return v;
    }
}
