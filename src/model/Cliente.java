package model;

public class Cliente {
    private int id;
    private int fkIdPessoa;
    private String cpf;

    public Cliente() {
    }

    public Cliente(int fkIdPessoa, String cpf) {
        this.fkIdPessoa = fkIdPessoa;
        this.cpf = cpf;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
}
