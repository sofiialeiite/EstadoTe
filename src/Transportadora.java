package src;

import java.io.Serializable;

public class Transportadora implements Serializable {

    private int id;
    private String nome;
    private double precoPequeno;
    private double precoMedio;
    private double precoGrande;
    private double imposto;
    private boolean premium; //true -> faz transporte de premium
    private boolean ativa; //true -> Sim

    public Transportadora(){
        this.id = 0;
        this.nome = "";
        this.precoPequeno = 0.0;
        this.precoMedio = 0.0;
        this.precoGrande = 0.0;
        this.imposto = 0.0;
        this.premium = false;
        this.ativa = true;
    }

    public Transportadora(int id, String nome, double precoPequeno, double precoMedio, double precoGrande, double imposto, boolean premium){
        this.id = id;
        this.nome = nome;
        this.precoPequeno = precoPequeno;
        this.precoMedio = precoMedio;
        this.precoGrande = precoGrande;
        this.imposto = imposto;
        this.premium = premium;
        this.ativa = true;
    }

    public Transportadora(Transportadora transportadora){
        this.id = transportadora.getId();
        this.nome = transportadora.getNome();
        this.precoPequeno = transportadora.getPrecoPequeno();
        this.precoMedio = transportadora.getPrecoMedio();
        this.precoGrande = transportadora.getPrecoGrande();
        this.imposto = transportadora.getImposto();
        this.premium = transportadora.getPremium();
        this.ativa = true;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPrecoPequeno() {
        return precoPequeno;
    }

    public double getPrecoMedio() {
        return precoMedio;
    }

    public double getPrecoGrande() {
        return precoGrande;
    }

    public double getImposto() {
        return imposto;
    }

    public boolean getPremium(){
        return premium;
    }

    public String getPremiumString(){
        if (getPremium()) return "Sim\n";
        else return "Não\n";
    }

    public boolean getAtiva(){
        return ativa;
    }

    public String getAtivaString(){
        if (getAtiva()) return "\033[32m-->ESTÁ ATIVA\033[0m\n";
        else return "\033[31m-->NÃO ESTÁ ATIVA\033[0m\n";
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPrecoPequeno(double precoPequeno) {
        this.precoPequeno = precoPequeno;
    }

    public void setPrecoMedio(double precoMedio) {
        this.precoMedio = precoMedio;
    }

    public void setPrecoGrande(double precoGrande) {
        this.precoGrande = precoGrande;
    }

    public void setImposto(double imposto) {
        this.imposto = imposto;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    public String toString () {
        String format = getAtivaString() +
                        "ID da Transportadora: " + this.getId() + "\n" +
                        "Nome da Transportadora: " + this.getNome() + "\n" +
                        "Preço de Encomenda Pequena: " + this.getPrecoPequeno() + "\n" +
                        "Preço de Encomenda Média: " + this.getPrecoMedio() + "\n" +
                        "Preço de Encomenda Grande: " + this.getPrecoGrande() + "\n" +
                        "Taxa de Imposto: " + this.getImposto() + "\n" +
                        "Faz entregas de artigos Premium? " + this.getPremiumString() + "\n";
        return format;
    }
}

