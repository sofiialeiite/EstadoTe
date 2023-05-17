package src;

import java.io.Serializable;

public class Utilizador implements Serializable {
    private int id; // 0 para o admin
    private String email;
    private String nome;
    private String morada;
    private long nFiscal;

    public Utilizador(){
        this.id = 0;
        this.email = "";
        this.nome = "";
        this.morada = "";
        this.nFiscal = 0;
    }

    public Utilizador(int novoId, String novoEmail, String novoNome, String novaMorada, long novoNFiscal){
        this.id = novoId;
        this.email = novoEmail;
        this.nome = novoNome;
        this.morada = novaMorada;
        this.nFiscal = novoNFiscal;
    }

    public Utilizador(Utilizador utilizador){
        this.id = utilizador.getId();
        this.email = utilizador.getEmail();
        this.nome = utilizador.getNome();
        this.morada = utilizador.getMorada();
        this.nFiscal = utilizador.getNFiscal();
    }

    public int getId(){
        return this.id;
    }

    public String getEmail(){
        return this.email;
    }

    public String getNome(){
        return this.nome;
    }

    public String getMorada(){
        return this.morada;
    }

    public long getNFiscal(){
        return this.nFiscal;
    }

    public void setId(int novoId){
        this.id = novoId;
    }

    public void setEmail(String novoEmail){
        this.email = novoEmail;
    }

    public void setNome(String novoNome){
        this.nome = novoNome;
    }

    public void setMorada(String novaMorada){
        this.morada = novaMorada;
    }

    public void setNFiscal(long novoNFiscal){
        this.nFiscal = novoNFiscal;
    }

    public String toString () {
        String format = "Utilizador nº: " + this.getId() + "\n" +
                        "Nome: " + this.getNome() + "\n" +
                        "Email: " + this.getEmail() + "\n" +
                        "Morada: " + this.getMorada() + "\n" +
                        "Nº Fiscal: " + this.getNFiscal() + "\n";
        return format;
    }

}
