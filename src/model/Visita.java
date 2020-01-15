package model;

public class Visita {
    private int id;
    private int fkIdFuncionario;
    private int fkIdCliente;
    private String data;
    private String detalhes;
    private String concluido;

    public Visita() {
    }

    public Visita(int fkIdFuncionario, int fkIdCliente, String data, String detalhes) {
        this.fkIdFuncionario = fkIdFuncionario;
        this.fkIdCliente = fkIdCliente;
        this.data = data;
        this.detalhes = detalhes;
    }

    public String getConcluido() {
        return concluido;
    }

    public void setConcluido(String concluido) {
        this.concluido = concluido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFkIdFuncionario() {
        return fkIdFuncionario;
    }

    public void setFkIdFuncionario(int fkIdFuncionario) {
        this.fkIdFuncionario = fkIdFuncionario;
    }

    public int getFkIdCliente() {
        return fkIdCliente;
    }

    public void setFkIdCliente(int fkIdCliente) {
        this.fkIdCliente = fkIdCliente;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }
    
}
