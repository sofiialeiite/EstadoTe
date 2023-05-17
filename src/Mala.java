package src;

import java.text.DecimalFormat;

public class Mala extends Artigo{
    private String tipoDeMala;
    private String tamanho; // S-M-L
    private String material;
    private int anoDeLancamento;
    private boolean premium;

    public Mala(){
        this.tipoDeMala = "";
        this.tamanho = "";
        this.material = "";
        this.anoDeLancamento = 0;
        this.premium = false;
    }

    public Mala(String novoTipoDeMala, String novoTamanho, String novoMaterial, int novoAnoDeLancamento, boolean novoPremium){
        this.tipoDeMala = novoTipoDeMala;
        this.tamanho = novoTamanho;
        this.material = novoMaterial;
        this.anoDeLancamento = novoAnoDeLancamento;
        this.premium = novoPremium;
    }

    public Mala(Mala mala){
        this.tipoDeMala = mala.getTipoDeMala();
        this.tamanho = mala.getTamanho();
        this.material = mala.getMaterial();
        this.anoDeLancamento = mala.getAnoDeLancamento();
        this.premium = mala.getPremium();
    }

    public String getTipoDeMala(){
        return this.tipoDeMala;
    }

    public String getTamanho(){
        return this.tamanho;
    }

    public String getMaterial(){
        return this.material;
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

    public void setTipoDeMala(String tipoDeMala) {
        this.tipoDeMala = tipoDeMala;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    public double calculaPrecoUsada(Mala mala, double preco){
        if (!(mala.getEstado())) preco =  preco * (1.0/Double.valueOf(mala.getDonos()));
        return preco;
    }

    public double calculaPrecoAnoDeLancamento(Mala mala, double preco){
        preco = preco * (1.0/Double.valueOf(2023 - mala.getAnoDeLancamento()));
        return preco;
    }

    public double calculaPrecoTamanho(Mala mala, double preco){
        if (mala.getTamanho().equals("s") || mala.getTamanho().equals("S")) preco = preco * 0.8;
        else if (mala.getTamanho().equals("m") || mala.getTamanho().equals("M")) preco = preco * 0.9;
        return preco;
    }

    public double calculaPrecoMaterial(Mala mala, double preco){
        if (mala.getMaterial().equals("tecido") || mala.getTamanho().equals("Tecido")) preco = preco * 0.8;
        return preco;
    }

    public double calculaPrecoPremium(Mala mala, double preco){
        preco = preco + (preco * (Double.valueOf(2023 - mala.getAnoDeLancamento()) / 5));
        return preco;
    }

    public double calculaPreco(Mala mala){
        double precoCalculado = 0.15 * mala.getPrecoBase();
        if(mala.getPremium()) {
            precoCalculado = calculaPrecoUsada(mala, precoCalculado);
            precoCalculado = calculaPrecoTamanho(mala, precoCalculado);
            precoCalculado = calculaPrecoMaterial(mala, precoCalculado);
            precoCalculado = calculaPrecoPremium(mala, precoCalculado);
        }
        else{
            precoCalculado = calculaPrecoUsada(mala, precoCalculado);
            precoCalculado = calculaPrecoTamanho(mala, precoCalculado);
            precoCalculado = calculaPrecoMaterial(mala, precoCalculado);
            precoCalculado = calculaPrecoAnoDeLancamento(mala, precoCalculado);
        }

        precoCalculado = mala.getPrecoBase() + precoCalculado;

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
                        "Tipo de mala : " + this.getTipoDeMala() + "\n"+
                        "Tamanho : " + this.getTamanho() + "\n"+
                        "Material : " + this.getMaterial() + "\n"+
                        "Ano de lançamento : " + this.getAnoDeLancamento() + "\n" +
                        "Edição limitada (Premium) ? " + getPremiumString();
        return format;
    }
}
