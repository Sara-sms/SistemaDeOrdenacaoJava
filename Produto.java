//import javax.xml.crypto.Data;

public class Produto{
    private String nomeDoProduto;
    private String fabricante;
    private double preço;
    private String dataDeValidade;
    //private String tipo;

    public  Produto(String nomeDoProduto, String fabricante, double preço, String dataDeValidade,String tipo){
        this.nomeDoProduto = nomeDoProduto;
        this.fabricante = fabricante;
        this.preço = preço;
        this.dataDeValidade = dataDeValidade;
        //this.tipo = tipo;
    }

    public String getNomeDoProduto() {
        return nomeDoProduto;
    }

    public String getFabricante() {
        return fabricante;
    }

    public double getPreço() {
        return preço;
    }

    public void setNomeDoProduto(String nomeDoProduto) {
        this.nomeDoProduto = nomeDoProduto;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public void setPreço(double preço) {
        this.preço = preço;
    }

    public void setDataDeValidade(String dataDeValidade) {
        this.dataDeValidade = dataDeValidade;
    }

    //public void setTipo(String tipo) {
        //this.tipo = tipo;
    //}

    public String getDataDeValidade() {
        return dataDeValidade;
    }

    
}