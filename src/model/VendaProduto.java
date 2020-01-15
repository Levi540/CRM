package model;

public class VendaProduto {
    private int id;
    private int fkIdVenda;
    private int fkIdProduto;
    private int QtdeVendida;
    private double precoUnidade;

    public VendaProduto() {
    }

    public VendaProduto(int fkIdVenda, int fkIdProduto, int QtdeVendida) {
        this.fkIdVenda = fkIdVenda;
        this.fkIdProduto = fkIdProduto;
        this.QtdeVendida = QtdeVendida;
    }

    public double getPrecoUnidade() {
        return precoUnidade;
    }

    public void setPrecoUnidade(double precoVenda) {
        this.precoUnidade = precoVenda;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFkIdVenda() {
        return fkIdVenda;
    }

    public void setFkIdVenda(int fkIdVenda) {
        this.fkIdVenda = fkIdVenda;
    }

    public int getFkIdProduto() {
        return fkIdProduto;
    }

    public void setFkIdProduto(int fkIdProduto) {
        this.fkIdProduto = fkIdProduto;
    }

    public int getQtdeVendida() {
        return QtdeVendida;
    }

    public void setQtdeVendida(int QtdeVendida) {
        this.QtdeVendida = QtdeVendida;
    }
    
}
