package model;

public class Fornecedor {
    private int id;
    private int fkIdPessoa;
    private String cnpj;
    private String nome;

    public Fornecedor() {
    }

    public Fornecedor(int fkIdPessoa, String cnpj, String nome) {
        this.fkIdPessoa = fkIdPessoa;
        this.cnpj = cnpj;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFkIdPessoa() {
        return fkIdPessoa;
    }

    public void setFkIdPessoa(int fkIdPessoa) {
        this.fkIdPessoa = fkIdPessoa;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
