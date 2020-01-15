package model;

public class Produto {
    private int id;
    private int fkIdFornecedor;
    private String nome;
    private int qtdEstoque;
    private double precoCusto;
    private double precoVenda;

    public Produto() {
    }

    public Produto(String nome, int qtdEstoque, double precoCusto, double precoVenda) {
        this.nome = nome;
        this.qtdEstoque = qtdEstoque;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
    }

    public int getFkIdFornecedor() {
        return fkIdFornecedor;
    }

    public void setFkIdFornecedor(int fkIdFornecedor) {
        this.fkIdFornecedor = fkIdFornecedor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(double precoCusto) {
        this.precoCusto = precoCusto;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }
    
}
