package src;

import java.io.Serializable;

public class Artigo implements Serializable {
    private int id;
    private String nome;
    private String tipo;
    private int stock;
    private int idVendedor;
    private boolean estado; //True se for novo, false usado
    private int avaliacaoEstado; // pior 0-10 melhor
    private int donos;
    private String descricao;
    private String marca;
    private double precoBase; //definido pelo cliente
    private double precoDeVenda;
    private int idTransportadora;
    private boolean vendido; // False -> Nao .... True -> Sim

    public Artigo(){
        this.id = 0;
        this.nome = "";
        this.tipo = "";
        this.stock = 0;
        this.idVendedor = 0;
        this.estado = true;
        this.avaliacaoEstado = 0;
        this.donos = 0;
        this.descricao = "";
        this.marca = "";
        this.precoBase = 0.0;
        this.precoDeVenda = 0.0;
        this.idTransportadora = 0;
        this.vendido = false;
    }

    public Artigo(int novoId, String novoNome, String novoTipo , int novoStock, int novoIdVendedor, boolean novoEstado, int novaAvaliacaoEstado, int novoDonos, String novaDescricao, String novaMarca, double novoPrecoBase, double novoPrecoDeVenda, int novoidTransportadora, boolean novoVendido ){
        this.id = novoId;
        this.nome = novoNome;
        this.tipo = novoTipo;
        this.stock = novoStock;
        this.idVendedor = novoIdVendedor;
        this.estado = novoEstado;
        this.avaliacaoEstado = novaAvaliacaoEstado;
        this.donos = novoDonos;
        this.descricao = novaDescricao;
        this.marca = novaMarca;
        this.precoBase = novoPrecoBase;
        this.precoDeVenda = novoPrecoDeVenda;
        this.idTransportadora = novoidTransportadora;
        this.vendido = novoVendido;
    }

    public Artigo(Artigo artigo){
        this.id = artigo.getId();
        this.nome = artigo.getNome();
        this.tipo = artigo.getTipo();
        this.stock = artigo.getStock();
        this.idVendedor = artigo.getIdVendedor();
        this.estado = artigo.getEstado();
        this.avaliacaoEstado = artigo.getAvaliacaoEstado();
        this.donos = artigo.getDonos();
        this.descricao = artigo.getDescricao();
        this.marca = artigo.getMarca();
        this.precoBase = artigo.getPrecoBase();
        this.precoDeVenda = artigo.getPrecoDeVenda();
        this.idTransportadora = artigo.getIdTransportadora();
        this.vendido = artigo.getVendido();
    }

    public int getId(){
        return this.id;
    }

    public String getNome(){
        return this.nome;
    }

    public String getTipo(){
        return this.tipo;
    }

    public int getStock(){
        return this.stock;
    }

    public int getIdVendedor(){
        return this.idVendedor;
    }

    public boolean getEstado(){
        return this.estado;
    }

    public String getEstadoString(){
        if (this.getEstado()) return "Novo";
        else return "Usado";
    }

    public int getAvaliacaoEstado(){
        return this.avaliacaoEstado;
    }

    public String getAvaliacaoEstadoString(){
        if(this.getEstado()) return "";
        else return ("Avaliação do Estado (Péssimo 0-10 Excelente) : " + this.getAvaliacaoEstado() + "\n");
    }

    public int getDonos(){
        return this.donos;
    }

    public String getDonosString(){
        if (this.getEstado()) return "";
        else return ("Nº de donos anteriores : " + this.getDonos() + "\n");
    }

    public String getDescricao(){
        return this.descricao;
    }

    public String getMarca(){
        return this.marca;
    }

    public double getPrecoBase(){
        return this.precoBase;
    }

    public double getPrecoDeVenda(){
        return this.precoDeVenda;
    }

    public int getIdTransportadora(){
        return this.idTransportadora;
    }

    public boolean getVendido(){
        return this.vendido;
    }

    public String getVendidoString(){
        if(this.getVendido()) return "\u001B[31mVENDIDO\u001B[0m \n";
        else return "";
    }

    public void setId(int novoId){
        this.id = novoId;
    }

    public void setNome(String novoNome){
        this.nome = novoNome;
    }

    public void setTipo(String novoTipo){
        this.tipo = novoTipo;
    }

    public void setStock(int novoStock){
        this.stock = novoStock;
    }

    public void setIdVendedor(int novoIdVendedor){
        this.idVendedor = novoIdVendedor;
    }

    public void setEstado(boolean novoEstado){
        this.estado = novoEstado;
    }

    public void setAvaliacaoEstado(int novaAvaliacaoEstado){
        this.avaliacaoEstado = novaAvaliacaoEstado;
    }

    public void setDonos(int novoDonos){
        this.donos = novoDonos;
    }

    public void setDescricao(String novaDescricao){
        this.descricao = novaDescricao;
    }

    public void setMarca(String novaMarca){
        this.marca = novaMarca;
    }

    public void setPrecoBase(double novoPrecoBase){
        this.precoBase = novoPrecoBase;
    }

    public void setPrecoDeVenda(double novoPrecoDeVenda){
        this.precoDeVenda = novoPrecoDeVenda;
    }

    public void setIdTransportadora(int novoIdTransportadora){
        this.idTransportadora = novoIdTransportadora;
    }

    public void setVendido(boolean novoVendido){
        this.vendido = novoVendido;
    }


    /*public String toString () {
        String format = this.getVendidoString() +
                        "Artigo nº : " + this.getId() + "\n" +
                        "Nome : " + this.getNome() + "\n" +
                        "Tipo : " + this.getTipo() + "\n" +
                        "Marca : " + this.getMarca() + "\n" +
                        "Descrição : " + this.getDescricao() + "\n" +
                        "Estado : " + this.getEstadoString() + "\n" +
                        this.getAvaliacaoEstadoString() +
                        this.getDonosString() +
                        "Preço : " + this.getPrecoDeVenda() + "\n" +
                        "Stock : " + this.getStock() + "\n" +
                        "ID Transportadora : " + this.getIdTransportadora() + "\n" +
                        "ID Vendedor : " + this.getIdVendedor() + "\n";
        return format;
    }*/
}
