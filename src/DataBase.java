package src;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class DataBase implements Serializable {
    private Map<Integer, Utilizador> utilizadores;
    private ArrayList<String> emailUtilizadores;
    private Map<Integer, Transportadora> transportadoras;
    private Map<Integer,Artigo> artigos;
    private Map<Integer,ArrayList<Artigo>> carrinhoPorUtilizador;
    private ArrayList<String> tipoDeProduto;
    private Map<Integer, Encomenda> encomendas;
    private Map<Integer, ArrayList<Encomenda>> encomendasPorUtilizador;
    private  double ganhoVintage;

    public DataBase(){
        utilizadores = new HashMap<>();
        emailUtilizadores = new ArrayList<>();
        transportadoras = new HashMap<>();
        artigos = new HashMap<>();
        carrinhoPorUtilizador = new HashMap<>();
        tipoDeProduto = new ArrayList<>();
        encomendas = new HashMap<>();
        encomendasPorUtilizador = new HashMap<>();
        ganhoVintage = 0;
    }

    public Map<Integer, Utilizador> getUtilizadores(){
        return utilizadores;
    }

    public ArrayList<String> getEmailUtilizadores() {
        return emailUtilizadores;
    }

    public Map<Integer, Transportadora> getTransportadoras(){
        return transportadoras;
    }

    public Map<Integer, Artigo> getArtigos() {
        return artigos;
    }

    public Map<Integer, ArrayList<Artigo>> getCarrinhoPorUtilizador() {
        return carrinhoPorUtilizador;
    }

    public ArrayList<String> getTipoDeProduto() {
        return tipoDeProduto;
    }

    public Map<Integer, Encomenda> getEncomendas() {
        return encomendas;
    }

    public Map<Integer, ArrayList<Encomenda>> getEncomendasPorUtilizador() {
        return encomendasPorUtilizador;
    }

    public double getGanhoVintage() {
        return ganhoVintage;
    }

    public void setUtilizadores(Map<Integer, Utilizador> utilizadores) {
        this.utilizadores = utilizadores;
    }

    public void setTransportadoras(Map<Integer, Transportadora> transportadoras) {
        this.transportadoras = transportadoras;
    }

    public void setEmailUtilizadores(ArrayList<String> emailUtilizadores) {
        this.emailUtilizadores = emailUtilizadores;
    }

    public void setArtigos(Map<Integer, Artigo> artigos) {
        this.artigos = artigos;
    }

    public void setCarrinhoPorUtilizador(Map<Integer, ArrayList<Artigo>> carrinhoPorUtilizador) {
        this.carrinhoPorUtilizador = carrinhoPorUtilizador;
    }

    public void setTipoDeProduto(ArrayList<String> tipoDeProduto) {
        this.tipoDeProduto = tipoDeProduto;
    }

    public void setEncomendas(Map<Integer, Encomenda> encomendas) {
        this.encomendas = encomendas;
    }

    public void setEncomendasPorUtilizador(Map<Integer, ArrayList<Encomenda>> encomendaPorUtilizador) {
        this.encomendasPorUtilizador = encomendaPorUtilizador;
    }

    public void setGanhoVintage(double ganhoVintage) {
        this.ganhoVintage = ganhoVintage;
    }

    public void addUtilizador(Utilizador utilizador){
        Map<Integer, Utilizador> novaUtilizadores = getUtilizadores();
        novaUtilizadores.put(novaUtilizadores.size()+1, utilizador);
        setUtilizadores(novaUtilizadores);
        ArrayList<String> novaEmailUtilizadores = getEmailUtilizadores();
        novaEmailUtilizadores.add(utilizador.getEmail());
        setEmailUtilizadores(novaEmailUtilizadores);
    }

    public void addTransportadora(Transportadora transportadora){
        Map<Integer, Transportadora> novaTransportadoras = getTransportadoras();
        novaTransportadoras.put(novaTransportadoras.size()+1, transportadora);
        setTransportadoras(novaTransportadoras);
    }

    public void addArtigo(Artigo artigo){
        Map<Integer, Artigo> novaArtigos = getArtigos();
        novaArtigos.put(novaArtigos.size()+1, artigo);
        setArtigos(novaArtigos);
    }

    public void addEncomenda(Encomenda encomenda){
        Map<Integer, Encomenda> novaEncomendas = getEncomendas();
        novaEncomendas.put(novaEncomendas.size() + 1, encomenda );
        setEncomendas(novaEncomendas);
    }

    public void addArtigoAoCarrinho(int idUtilizador, Artigo artigo){ //AINDA NAO FOI TESTADO
        Map<Integer, ArrayList<Artigo>> novaCarrinhoPorUtilizador = getCarrinhoPorUtilizador();
        if(novaCarrinhoPorUtilizador.containsKey(idUtilizador)){
            ArrayList<Artigo> novoCarrinho = novaCarrinhoPorUtilizador.get(idUtilizador);
            novoCarrinho.add(artigo);
            novaCarrinhoPorUtilizador.put(idUtilizador, novoCarrinho);
            setCarrinhoPorUtilizador(novaCarrinhoPorUtilizador);
            novaCarrinhoPorUtilizador.put(idUtilizador, novoCarrinho);
            setCarrinhoPorUtilizador(novaCarrinhoPorUtilizador);
        }
        else {
            ArrayList<Artigo> novoCarrinho = new ArrayList<>();
            novoCarrinho.add(artigo);
            novaCarrinhoPorUtilizador.put(idUtilizador, novoCarrinho);
            setCarrinhoPorUtilizador(novaCarrinhoPorUtilizador);
            novaCarrinhoPorUtilizador.put(idUtilizador, novoCarrinho);
            setCarrinhoPorUtilizador(novaCarrinhoPorUtilizador);
        }
    }

    public void addEncomendasPorUtilizador(int idUtilizador, Encomenda encomenda){
        Map<Integer, ArrayList<Encomenda>> novaEncomendasPorUtilizador = getEncomendasPorUtilizador();
        if(novaEncomendasPorUtilizador.containsKey(idUtilizador)) {
            ArrayList<Encomenda> novaEncomendas = novaEncomendasPorUtilizador.get(idUtilizador);
            novaEncomendas.add(encomenda);
            //novaEncomendasPorUtilizador.remove(idUtilizador);
            novaEncomendasPorUtilizador.put(idUtilizador, novaEncomendas);
            setEncomendasPorUtilizador(novaEncomendasPorUtilizador);
        }
        else{
            ArrayList<Encomenda> novaEncomendas = new ArrayList<>();
            novaEncomendas.add(encomenda);
            //novaEncomendasPorUtilizador.remove(idUtilizador);
            novaEncomendasPorUtilizador.put(idUtilizador, novaEncomendas);
            setEncomendasPorUtilizador(novaEncomendasPorUtilizador);        }
    }

    public void removeArtigoDoCarrinho(int idUtilizador, Artigo artigo){
        Map<Integer, ArrayList<Artigo>> novaCarrinhoPorUtilizador = getCarrinhoPorUtilizador();
        ArrayList<Artigo> novoCarrinho = novaCarrinhoPorUtilizador.get(idUtilizador);
        novoCarrinho.remove(artigo);
        novaCarrinhoPorUtilizador.put(idUtilizador, novoCarrinho);
        setCarrinhoPorUtilizador(novaCarrinhoPorUtilizador);
    }

    public void limpaCarrinho(int idUtilizador){
        Map<Integer, ArrayList<Artigo>> novaCarrinhoPorUtilizador = getCarrinhoPorUtilizador();
        novaCarrinhoPorUtilizador.remove(idUtilizador);
        setCarrinhoPorUtilizador(novaCarrinhoPorUtilizador);
    }

    public void tempTipoDeProduto(String tipo){
        ArrayList<String> novatipoDeProduto = getTipoDeProduto();
        novatipoDeProduto.add(tipo);
        setTipoDeProduto(novatipoDeProduto);
    }
}
