package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Atendimento;
import util.Conexao;

public class AtendimentoDAO {
    private static final String INSERT = "INSERT INTO TB_ATENDIMENTO(FK_ID_CLIENTE, "
            + "FK_ID_FUNCIONARIO, FK_ID_PRODUTO, DATA_ATENDIMENTO, TITULO_ATENDIMENTO, "
            + "DETALHES_ATENDIMENTO, CONCLUIDO) VALUES(?,?,?,?,?,?,?)";
    
    private static final String UPDATE = "UPDATE TB_ATENDIMENTO SET TITULO_ATENDIMENTO = ?, "
            + "DETALHES_ATENDIMENTO = ?, CONCLUIDO = ? WHERE ID = ?";
    
    
    private static final String FIND_ALL = "select a.id, a.titulo_atendimento, pdt.nome_produto, "
            + "pe.nome, a.data_atendimento from tb_atendimento a inner join tb_pessoa pe, "
            + "tb_produto pdt, tb_cliente c where pe.id = c.fk_id_pessoa and c.id = a.fk_id_cliente"
            + " and pdt.id = a.fk_id_produto";
    
    private static final String FIND_BY_ID = "SELECT ID, FK_ID_CLIENTE, FK_ID_FUNCIONARIO, "
            + "FK_ID_PRODUTO, DATA_ATENDIMENTO, TITULO_ATENDIMENTO, DETALHES_ATENDIMENTO, CONCLUIDO "
            + "FROM TB_ATENDIMENTO WHERE ID = ?";
    
    private static final String SEARCH = "select a.id, a.titulo_atendimento, pdt.nome_produto, "
            + "pe.nome, a.data_atendimento from tb_atendimento a, tb_pessoa pe, "
            + "tb_produto pdt, tb_cliente c where pe.id = c.fk_id_pessoa and c.id = a.fk_id_cliente"
            + " and pdt.id = a.fk_id_produto and (select distinct a.titulo_atendimento like ? or "
            + "pdt.nome_produto like ? or c.cpf like ? or a.data_atendimento like ?)";
    
    private static final String SEARCH_TITULO_PRODUTO = "select a.id, a.titulo_atendimento, pdt.nome_produto, "
            + "pe.nome, a.data_atendimento from tb_atendimento a, tb_pessoa pe, "
            + "tb_produto pdt, tb_cliente c where pe.id = c.fk_id_pessoa and c.id = a.fk_id_cliente"
            + " and pdt.id = a.fk_id_produto and (select distinct a.titulo_atendimento like ? and "
            + "pdt.nome_produto like ?)";
    
    private static final String SEARCH_TITULO_CPF = "select a.id, a.titulo_atendimento, pdt.nome_produto, "
            + "pe.nome, a.data_atendimento from tb_atendimento a, tb_pessoa pe, "
            + "tb_produto pdt, tb_cliente c where pe.id = c.fk_id_pessoa and c.id = a.fk_id_cliente"
            + " and pdt.id = a.fk_id_produto and (select distinct a.titulo_atendimento like ? and "
            + "c.cpf like ?)";
    
    private static final String SEARCH_TITULO_DATA = "select a.id, a.titulo_atendimento, pdt.nome_produto, "
            + "pe.nome, a.data_atendimento from tb_atendimento a, tb_pessoa pe, "
            + "tb_produto pdt, tb_cliente c where pe.id = c.fk_id_pessoa and c.id = a.fk_id_cliente"
            + " and pdt.id = a.fk_id_produto and (select distinct a.titulo_atendimento like ? and "
            + "a.data_atendimento like ?)";
    
    private static final String SEARCH_PRODUTO_CPF = "select a.id, a.titulo_atendimento, pdt.nome_produto, "
            + "pe.nome, a.data_atendimento from tb_atendimento a, tb_pessoa pe, "
            + "tb_produto pdt, tb_cliente c where pe.id = c.fk_id_pessoa and c.id = a.fk_id_cliente"
            + " and pdt.id = a.fk_id_produto and (select distinct pdt.nome_produto like ? and c.cpf like ?)";
    
    private static final String SEARCH_PRODUTO_DATA = "select a.id, a.titulo_atendimento, pdt.nome_produto, "
            + "pe.nome, a.data_atendimento from tb_atendimento a, tb_pessoa pe, "
            + "tb_produto pdt, tb_cliente c where pe.id = c.fk_id_pessoa and c.id = a.fk_id_cliente"
            + " and pdt.id = a.fk_id_produto and (select distinct pdt.nome_produto like ? and "
            + "a.data_atendimento like ?)";
    
    private static final String SEARCH_CPF_DATA = "select a.id, a.titulo_atendimento, pdt.nome_produto, "
            + "pe.nome, a.data_atendimento from tb_atendimento a, tb_pessoa pe, "
            + "tb_produto pdt, tb_cliente c where pe.id = c.fk_id_pessoa and c.id = a.fk_id_cliente"
            + " and pdt.id = a.fk_id_produto and (select distinct c.cpf like ? and a.data_atendimento like ?)";
    
    private static final String SEARCH_TITULO_PRODUTO_CPF = "select a.id, a.titulo_atendimento, pdt.nome_produto, "
            + "pe.nome, a.data_atendimento from tb_atendimento a, tb_pessoa pe, "
            + "tb_produto pdt, tb_cliente c where pe.id = c.fk_id_pessoa and c.id = a.fk_id_cliente"
            + " and pdt.id = a.fk_id_produto and (select distinct a.titulo_atendimento like ? and "
            + "pdt.nome_produto like ? and c.cpf like ?)";
    
    private static final String SEARCH_TITULO_CPF_DATA = "select a.id, a.titulo_atendimento, pdt.nome_produto, "
            + "pe.nome, a.data_atendimento from tb_atendimento a, tb_pessoa pe, "
            + "tb_produto pdt, tb_cliente c where pe.id = c.fk_id_pessoa and c.id = a.fk_id_cliente"
            + " and pdt.id = a.fk_id_produto and (select distinct a.titulo_atendimento like ? and "
            + "c.cpf like ? and a.data_atendimento like ?)";
    
    private static final String SEARCH_TITULO_PRODUTO_DATA = "select a.id, a.titulo_atendimento, pdt.nome_produto, "
            + "pe.nome, a.data_atendimento from tb_atendimento a, tb_pessoa pe, "
            + "tb_produto pdt, tb_cliente c where pe.id = c.fk_id_pessoa and c.id = a.fk_id_cliente"
            + " and pdt.id = a.fk_id_produto and (select distinct a.titulo_atendimento like ? and "
            + "pdt.nome_produto like ? and a.data_atendimento like ?)";
    
    private static final String SEARCH_PRODUTO_CPF_DATA = "select a.id, a.titulo_atendimento, pdt.nome_produto, "
            + "pe.nome, a.data_atendimento from tb_atendimento a, tb_pessoa pe, "
            + "tb_produto pdt, tb_cliente c where pe.id = c.fk_id_pessoa and c.id = a.fk_id_cliente"
            + " and pdt.id = a.fk_id_produto and (select distinct pdt.nome_produto like ? and c.cpf like ? "
            + "and a.data_atendimento like ?)";
    
    private static final String SEARCH_TODOS_CAMPOS = "select a.id, a.titulo_atendimento, pdt.nome_produto, "
            + "pe.nome, a.data_atendimento from tb_atendimento a, tb_pessoa pe, "
            + "tb_produto pdt, tb_cliente c where pe.id = c.fk_id_pessoa and c.id = a.fk_id_cliente"
            + " and pdt.id = a.fk_id_produto and (select distinct a.titulo_atendimento like ? and "
            + "pdt.nome_produto like ? and c.cpf like ? and a.data_atendimento like ?)";
    
    private final Connection conn = Conexao.conectar();
    private PreparedStatement pstm;
    private ResultSet res;
    
    public void salvar(Atendimento a) {
        try {
            if(a.getId() <= 0) {
                pstm = conn.prepareStatement(INSERT);
                pstm.setInt(1, a.getFkIdCliente());
                pstm.setInt(2, a.getFkIdFuncionario());
                pstm.setInt(3, a.getFkIdProduto());
                pstm.setString(4, a.getDataAtendimento());
                pstm.setString(5, a.getTitulo());
                pstm.setString(6, a.getDetalhes());
                pstm.setBoolean(7, a.isConcluido());
            } else {
                pstm = conn.prepareStatement(UPDATE);
                pstm.setString(1, a.getTitulo());
                pstm.setString(2, a.getDetalhes());
                pstm.setBoolean(3, a.isConcluido());
                pstm.setInt(4, a.getId());
            }
            pstm.execute();
            pstm.close();
        } catch(SQLException s) {
            System.out.println("Ocorreu um erro ao tentar"
                    + "salvar o atendimento. Erro: " + s.getMessage());
        }
    }
    
    public ResultSet getAtendimentosRes() {
        try {
            pstm = conn.prepareStatement(FIND_ALL);
            return pstm.executeQuery();
            
        } catch(SQLException s) {
            System.out.println("Ocorreu um erro ao tentar "
                    + "recuperar os atendimentos do banco. Erro: " + s.getMessage());
        }
        return null;
    }
    
    public ResultSet searchAtendimentosRes(String txtTitulo, String txtProduto, String txtCliente, String txtData, boolean or) {
        try {
            if(or) {
                pstm = conn.prepareStatement(SEARCH);
            } else {
                pstm = conn.prepareStatement(SEARCH_TODOS_CAMPOS);
            }
            pstm.setString(1, "%"+txtTitulo+"%");
            pstm.setString(2, txtProduto);
            pstm.setString(3, txtCliente);
            pstm.setString(4, txtData);
            return pstm.executeQuery();
            
        } catch(SQLException s) {
            System.out.println("Ocorreu um erro ao tentar "
                    + "recuperar os atendimentos do banco. Erro: " + s.getMessage());
        }
        return null;
    }
    
    public ResultSet searchDoisCamposAtendimentosRes(String txt1, String txt2, int n) {
        try {
            if(n == 1) {
                pstm = conn.prepareStatement(SEARCH_TITULO_PRODUTO);
            } else if(n == 2) {
                pstm = conn.prepareStatement(SEARCH_TITULO_CPF);
            } else if(n == 3) {
                pstm = conn.prepareStatement(SEARCH_TITULO_DATA);
            } else if(n == 4) {
                pstm = conn.prepareStatement(SEARCH_PRODUTO_CPF);
            } else if(n == 5) {
                pstm = conn.prepareStatement(SEARCH_PRODUTO_DATA);
            } else {
                pstm = conn.prepareStatement(SEARCH_CPF_DATA);
            }
            pstm.setString(1, "%"+txt1+"%");
            pstm.setString(2, txt2);
            return pstm.executeQuery();
            
        } catch(SQLException s) {
            System.out.println("Ocorreu um erro ao tentar "
                    + "recuperar os atendimentos do banco. Erro: " + s.getMessage());
        }
        return null;
    }
    
    public ResultSet searchTresCamposAtendimentosRes(String txt1, String txt2, String txt3, int n) {
        try {
            if(n == 7) {
                pstm = conn.prepareStatement(SEARCH_TITULO_PRODUTO_CPF);
            } else if(n == 8) {
                pstm = conn.prepareStatement(SEARCH_TITULO_CPF_DATA);
            } else if(n == 9) {
                pstm = conn.prepareStatement(SEARCH_TITULO_PRODUTO_DATA);
            } else if(n == 10) {
                pstm = conn.prepareStatement(SEARCH_PRODUTO_CPF_DATA);
            }
            pstm.setString(1, "%"+txt1+"%");
            pstm.setString(2, txt2);
            pstm.setString(3, txt3);
            return pstm.executeQuery();
            
        } catch(SQLException s) {
            System.out.println("Ocorreu um erro ao tentar "
                    + "recuperar os atendimentos do banco. Erro: " + s.getMessage());
        }
        return null;
    }
    
    public Atendimento getAtendimentoId(int id) {
        Atendimento a = new Atendimento();
        try {
            pstm = conn.prepareStatement(FIND_BY_ID);
            pstm.setInt(1, id);
            res = pstm.executeQuery();
            
            while(res.next()) {
                a.setId(res.getInt("ID"));
                a.setFkIdCliente(res.getInt("FK_ID_CLIENTE"));
                a.setFkIdFuncionario(res.getInt("FK_ID_FUNCIONARIO"));
                a.setFkIdProduto(res.getInt("FK_ID_PRODUTO"));
                a.setDataAtendimento(res.getString("DATA_ATENDIMENTO"));
                a.setTitulo(res.getString("TITULO_ATENDIMENTO"));
                a.setDetalhes(res.getString("DETALHES_ATENDIMENTO"));
                a.setConcluido(res.getBoolean("CONCLUIDO"));
            }
        } catch(SQLException s) {
            System.out.println("Ocorreu um erro ao tentar "
                    + "recuperar um atendimento do banco. Erro: " + s.getMessage());
        }
        return a;
    }
}
