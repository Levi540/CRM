package model;

public class Funcionario {
    private int id;
    private int fkIdPessoa;
    private String login;
    private String senha;
    private boolean ativado;
    private boolean admin;

    public Funcionario() {
    }

    public Funcionario(int fkIdPessoa, String login, String senha) {
        this.fkIdPessoa = fkIdPessoa;
        this.login = login;
        this.senha = senha;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean isAtivado() {
        return ativado;
    }

    public void setAtivado(boolean ativado) {
        this.ativado = ativado;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
