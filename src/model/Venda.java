package model;

public class Venda {
    private int id;
    private int fkIdCliente;
    private String dataVenda;
    private double valor;

    public Venda() {
    }

    public Venda(int fkIdCliente, String dataVenda, double valor) {
        this.fkIdCliente = fkIdCliente;
        this.dataVenda = dataVenda;
        this.valor = valor;
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

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
}
