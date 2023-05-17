package src;

import java.text.DecimalFormat;

public class Tshirt extends Artigo{
    private String tamanho;
    private String padrao;

    public Tshirt(){
        this.tamanho = "";
        this.padrao = "";
    }

    public Tshirt(String tamanho, String padrao){
        this.tamanho = tamanho;
        this.padrao = padrao;
    }

    public Tshirt(Tshirt tshirt){
        this.tamanho = tshirt.getTamanho();
        this.padrao = tshirt.getPadrao();
    }

    public String getTamanho() {
        return tamanho;
    }

    public String getPadrao() {
        return padrao;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public void setPadrao(String padrao) {
        this.padrao = padrao;
    }

    public double calculaPreco(Tshirt tshirt){
        double precoCalculado = 0.1 * tshirt.getPrecoBase();
        if(!(tshirt.getPadrao().equals("Liso")) && !tshirt.getEstado()){
            precoCalculado = precoCalculado * 0.5;
        }

        precoCalculado = tshirt.getPrecoBase() + precoCalculado;

        return precoCalculado;
    }

    public String toString(){
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        String format = this.getVendidoString() +
                        "Artigo nº : " + this.getId() + "\n" +
                        "Nome : " + this.getNome() + "\n" +
                        "Tipo : " + this.getTipo() + "\n" +
                        "Marca : " + this.getMarca() + "\n" +
                        "Descrição : " + this.getDescricao() + "\n" +
                        "Estado : " + this.getEstadoString() + "\n" +
                        this.getAvaliacaoEstadoString() +
                        this.getDonosString() +
                        "Preço : " + decimalFormat.format(this.getPrecoDeVenda()) + "\n" +
                        "Stock : " + this.getStock() + "\n" +
                        "ID Transportadora : " + this.getIdTransportadora() + "\n" +
                        "ID Vendedor : " + this.getIdVendedor() + "\n"+
                        "Tamanho: " + getTamanho() + "\n" +
                        "Padrão: " + getPadrao() + "\n";
        return format;
    }
}
