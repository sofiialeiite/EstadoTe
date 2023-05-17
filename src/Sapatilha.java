package src;

import java.text.DecimalFormat;

public class Sapatilha extends Artigo {
    private int tamanho;
    private boolean atacadores; // True se tem, False se nao tem
    private String cor;
    private int anoDeLancamento;
    private boolean premium; //True -> Sim .... False -> Nao

    public Sapatilha(){
        this.tamanho = 0;
        this.atacadores = true;
        this.cor = "";
        this.anoDeLancamento = 0;
        this.premium = false;
    }

    public Sapatilha(int novoTamanho, boolean novoAtacadores, String novaCor, int novoAnoDeLancamento, boolean novoPremium){
        this.tamanho = novoTamanho;
        this.atacadores = novoAtacadores;
        this.cor = novaCor;
        this.anoDeLancamento = novoAnoDeLancamento;
        this.premium = novoPremium;
    }
    public Sapatilha(Sapatilha sapatilha){
        this.tamanho = sapatilha.getTamanho();
        this.atacadores = sapatilha.getAtacadores();
        this.cor = sapatilha.getCor();
        this.anoDeLancamento = sapatilha.getAnoDeLancamento();
        this.premium = sapatilha.getPremium();
    }

    public int getTamanho() {
        return this.tamanho;
    }

    public boolean getAtacadores(){
        return this.atacadores;
    }

    public String getAtacadoresString(){
        if (this.getAtacadores()) return "Sim \n";
        else return "Não \n";
    }

    public String getCor(){
        return this.cor;
    }

    public int getAnoDeLancamento(){
        return this.anoDeLancamento;
    }

    public boolean getPremium(){
        return this.premium;
    }

    public String getPremiumString(){
        if (this.getPremium()) return "Sim \n";
        else return "Não \n";
    }

    public void setTamanho(int novoTamanho){
        this.tamanho = novoTamanho;
    }

    public void setAtacadores(boolean novoAtacadores){
        this.atacadores = novoAtacadores;
    }

    public void setCor(String novaCor){
        this.cor = novaCor;
    }

    public void setAnoDeLancamento(int novoAnoDeLancamento){
        this.anoDeLancamento = novoAnoDeLancamento;
    }

    public void setPremium(boolean novoPremium){
        this.premium = novoPremium;
    }

    public double calculaPrecoUsada(Sapatilha sapatilha, double preco){
        if (!(sapatilha.getEstado())) preco =  preco * (1.0/Double.valueOf(sapatilha.getDonos()));
        return preco;
    }

    public double calculaPrecoAnoDeLancamento(Sapatilha sapatilha, double preco){
        preco = preco * (1.0/Double.valueOf(2023 - sapatilha.getAnoDeLancamento()));
        return preco;
    }

    public double calculaPreco45(Sapatilha sapatilha, double preco){
        if (sapatilha.getTamanho() >= 45) preco = preco * 0.8;
        return preco;
    }

    public double calculaPrecoPremium(Sapatilha sapatilha, double preco){
        preco = preco + (preco * (Double.valueOf(2023 - sapatilha.getAnoDeLancamento()) / 5));
        return preco;
    }

    public double calculaPreco(Sapatilha sapatilha){
        double precoCalculado = 0.1 * sapatilha.getPrecoBase();
        if(sapatilha.getPremium()) {
            precoCalculado = calculaPrecoUsada(sapatilha, precoCalculado);
            precoCalculado = calculaPreco45(sapatilha, precoCalculado);
            precoCalculado = calculaPrecoPremium(sapatilha, precoCalculado);
        }
        else{
            precoCalculado = calculaPrecoUsada(sapatilha, precoCalculado);
            precoCalculado = calculaPreco45(sapatilha, precoCalculado);
            precoCalculado = calculaPrecoAnoDeLancamento(sapatilha, precoCalculado);
        }

        precoCalculado = sapatilha.getPrecoBase() + precoCalculado;

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
                        "Tamanho : " + getTamanho() + "\n" +
                        "Tem Atacadores? : " + getAtacadoresString() +
                        "Cor : " + getCor()+ "\n"+
                        "Ano de lançamento : " + getAnoDeLancamento() + "\n" +
                        "Edição limitada (Premium) ? : " + getPremiumString() ;
        return format;
    }
}
