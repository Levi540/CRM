package model;

public class Atendimento {
    private int id;
    private int fkIdCliente;
    private int fkIdFuncionario;
    private int fkIdProduto;
    private String dataAtendimento;
    private String titulo;
    private String detalhes;
    private boolean concluido;

    public Atendimento() {
    }

    public Atendimento(int fkIdCliente, int fkIdFuncionario, String dataAtendimento, String titulo, String detalhes, boolean concluido) {
        this.fkIdCliente = fkIdCliente;
        this.fkIdFuncionario = fkIdFuncionario;
        this.dataAtendimento = dataAtendimento;
        this.titulo = titulo;
        this.detalhes = detalhes;
        this.concluido = concluido;
    }

    public int getFkIdProduto() {
        return fkIdProduto;
    }

    public void setFkIdProduto(int fkIdProduto) {
        this.fkIdProduto = fkIdProduto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFkIdCliente() {
        return fkIdCliente;
    }

    public void setFkIdCliente(int fkIdCliente) {
        this.fkIdCliente = fkIdCliente;
    }

    public int getFkIdFuncionario() {
        return fkIdFuncionario;
    }

    public void setFkIdFuncionario(int fkIdFuncionario) {
        this.fkIdFuncionario = fkIdFuncionario;
    }

    public String getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(String dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    public boolean isConcluido() {
        return concluido;
    }

    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
    }
    
}
