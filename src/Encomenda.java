package src;

import java.io.Serializable;
import java.util.ArrayList;

public class Encomenda implements Serializable {
    private int id;
    private int idVendedor;
    private int idComprador;
    private int idArtigo;
    private double precoPago;
    private double precoDePortes;
    private double precoInicial;
    //private ArrayList<Artigo> artigosEncomenda;

    public Encomenda(){
        this.id = 0;
        this.idVendedor = 0;
        this.idComprador = 0;
        this.idArtigo = 0;
        this.precoPago = 0.0;
        this.precoDePortes = 0.0;
        this.precoInicial = 0.0;
        //this.artigosEncomenda = new ArrayList<>();
    }

    public Encomenda(int id, int idVendedor, int idComprador, int idArtigo, double precoPago, double precoDePortes, double precoInicial){
        this.id = id;
        this.idVendedor = idVendedor;
        this.idComprador = idComprador;
        this.idArtigo = idArtigo;
        this.precoPago = precoPago;
        this.precoDePortes = precoDePortes;
        this.precoInicial = precoInicial;
    }

    public Encomenda(Encomenda encomenda){
        this.id = encomenda.getId();
        this.idVendedor = encomenda.getIdVendedor();
        this.idComprador = encomenda.getIdComprador();
        this.idArtigo = encomenda.getIdArtigo();
        this.precoPago = encomenda.getPrecoPago();
        this.precoDePortes = encomenda.getPrecoDePortes();
        this.precoInicial = encomenda.getPrecoInicial();
    }

    public int getId() {
        return id;
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public int getIdComprador() {
        return idComprador;
    }

    public int getIdArtigo() {
        return idArtigo;
    }

    public double getPrecoPago() {
        return precoPago;
    }

    public double getPrecoDePortes() {
        return precoDePortes;
    }

    public double getPrecoInicial() {
        return precoInicial;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    public void setIdComprador(int idComprador) {
        this.idComprador = idComprador;
    }

    public void setIdArtigo(int idArtigo) {
        this.idArtigo = idArtigo;
    }

    public void setPrecoPago(double precoPago) {
        this.precoPago = precoPago;
    }

    public void setPrecoDePortes(double precoDePortes) {
        this.precoDePortes = precoDePortes;
    }

    public void setPrecoInicial(double precoInicial) {
        this.precoInicial = precoInicial;
    }

    public String toString(){
        String format = "ID da encomenda : " + getId() + "\n" +
                        "ID do vendedor : " + getIdVendedor() +"\n" +
                        "ID do comprador : " + getIdComprador() +"\n" +
                        "ID do artigo : " + getIdArtigo() +"\n" +
                        "Preço do artigo : " + getPrecoInicial() +"\n" +
                        "Preço dos portes : " + getPrecoDePortes() +"\n" +
                        "Total : " + getPrecoPago() +"\n" ;
        return format;
    }
}
