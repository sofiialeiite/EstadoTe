package src;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Vintage {//--
    public static void main(String[] args) throws IOException, InterruptedException { //--

        Menu menu = new Menu();
        LimpaEcra limpa_ecra = new LimpaEcra();
        GuardaEstadoDB estadoDB = new GuardaEstadoDB();
        DataBase data_base = estadoDB.carregaEstadoDB("./Estado/estado.obj");
        System.out.println(menu.menuInicial());

        //data_base.tempTipoDeProduto(); //TEMPORAIO

        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");

        int opcao = sc.nextInt();
        System.out.println("\n");

        while(opcao!=0) {//--

            if (opcao == 1) {//Criar Utilizador
                limpa_ecra.clear_screen();
                System.out.println("Insira o seu Nome: ");
                String nome = sc.next();
                System.out.println("Insira o seu E-mail: ");
                String email = sc.next();
                System.out.println("Insira a sua Morada: ");
                String morada = sc.next();
                System.out.println("Insira o seu nº Fiscal: ");
                long nif = sc.nextLong();
                Utilizador utilizador = new Utilizador(data_base.getUtilizadores().size() + 1, email, nome, morada, nif);
                data_base.addUtilizador(utilizador);
                limpa_ecra.clear_screen();
                estadoDB.guardaEstadoDB("./Estado/estado.obj", data_base);
                System.out.println("Utilizador adicionado com sucesso!\n");
                System.out.println(data_base.getUtilizadores());
                System.out.println("\n");
            }//--
            else if (opcao == 2) {//Criar Transportadora
                limpa_ecra.clear_screen();
                System.out.println("Insira o nome da Transportadora: ");
                String nome = sc.next();
                System.out.println("Insira o preço de entrega da encomenda pequena: ");
                double precoPequeno = sc.nextDouble();
                System.out.println("Insira o preço de entrega da encomenda média: ");
                double precoMedio = sc.nextDouble();
                System.out.println("Insira o preço de entrega da encomenda grande: ");
                double precoGrande = sc.nextDouble();
                System.out.println("Insira o imposto de entrega: ");
                double imposto = sc.nextDouble();
                System.out.println("Faz entregas de artigos Premium? Sim[S] Não[N]");
                String premium = sc.next();
                boolean premiumBool;
                if(premium.equals("S") || premium.equals("s")) premiumBool = true;
                else premiumBool = false;
                Transportadora transportadora = new Transportadora(data_base.getTransportadoras().size() + 1, nome, precoPequeno, precoMedio, precoGrande, imposto, premiumBool);
                data_base.addTransportadora(transportadora);
                limpa_ecra.clear_screen();
                estadoDB.guardaEstadoDB("./Estado/estado.obj", data_base);
                System.out.println("Transportadora adicionada com sucesso!\n");
                System.out.println(data_base.getTransportadoras());
                System.out.println("\n");
            }//Efetuar Login de Utilizador
            else if (opcao == 3) {
                limpa_ecra.clear_screen();
                System.out.println("Insira o seu email para efetuar o login: ");
                String emailLogin = sc.next();
                if(data_base.getEmailUtilizadores().contains(emailLogin)){
                    int keyUtilizador = data_base.getEmailUtilizadores().indexOf(emailLogin) + 1;
                    System.out.println("Login efetuado com sucesso!\n");
                    System.out.println(menu.menuUtilizador());
                    int opcaoMenuUtilizador = sc.nextInt();
                    System.out.println("\n");
                    while(opcaoMenuUtilizador != 0){
                        if(opcaoMenuUtilizador==1){ //Comprar Produto
                            limpa_ecra.clear_screen();
                            int i = 1;
                            while (i<=data_base.getArtigos().size()){
                                System.out.println(data_base.getArtigos().get(i));
                                i++;
                            }

                            //for(Artigo artigo : ) Tenho como dar print com o for?

                            System.out.println(menu.menuComprarProduto());
                            int opcaoMenuComprarProduto = sc.nextInt();
                            System.out.println("\n");
                            while (opcaoMenuComprarProduto != 0){
                               if(opcaoMenuComprarProduto == 1){ // Adicionar artigo ao carrinho
                                   System.out.println("Insira o ID do artigo a adicionar ao carrinho: \n");
                                   int idArtigo = sc.nextInt();
                                   if (data_base.getArtigos().get(idArtigo).getVendido()) {
                                       limpa_ecra.clear_screen();
                                       System.out.println("Este artigo já foi vendido!\n");
                                   }
                                   else {
                                       data_base.addArtigoAoCarrinho(keyUtilizador, data_base.getArtigos().get(idArtigo));
                                       limpa_ecra.clear_screen();
                                       System.out.println("Artigo adicinado com sucesso!\n");
                                   }
                               }
                               else if(opcaoMenuComprarProduto == 2){ // Ver Carrinho
                                   opcaoMenuUtilizador = 2;
                                   opcaoMenuComprarProduto = 0;
                                   break;
                               }
                               else if(opcaoMenuComprarProduto == 3){ //Procurar artigos por tipo (Mala, Tshirt, Sapatilhas)
                                   ///////////para depois
                                   System.out.println("Pesquisa por tipo");
                               }
                               else System.out.println("Opcao Inválida");
                                i = 1;
                                while (i<=data_base.getArtigos().size()){
                                    System.out.println(data_base.getArtigos().get(i));
                                    i++;
                                }
                                System.out.println(menu.menuComprarProduto());
                                opcaoMenuComprarProduto = sc.nextInt();
                                System.out.println("\n");
                            }
                        }
                        else if(opcaoMenuUtilizador==2){
                            limpa_ecra.clear_screen();
                            if(data_base.getCarrinhoPorUtilizador().containsKey(keyUtilizador)){
                                for (Artigo artigo : data_base.getCarrinhoPorUtilizador().get(keyUtilizador)){
                                    System.out.println(artigo);
                                }
                            }
                            else System.out.println("O seu carrinho está vazio!");
                            System.out.println(menu.menuCarrinho());
                            int opcaoMenuCarrinho = sc.nextInt();
                            System.out.println("\n");
                            while(opcaoMenuCarrinho != 0){
                                if(opcaoMenuCarrinho == 1 && data_base.getCarrinhoPorUtilizador().containsKey(keyUtilizador)){ // Prosseguir para pagamento do carrinho
                                    double totalPagar = 0.0;
                                    System.out.println(" Artigo         Preço        Portes");
                                    for (Artigo artigo : data_base.getCarrinhoPorUtilizador().get(keyUtilizador)){
                                        System.out.println(artigo.getNome() + " -> " + artigo.getPrecoDeVenda() + " -> " + data_base.getTransportadoras().get(artigo.getIdTransportadora()).getPrecoPequeno());
                                        totalPagar = totalPagar + artigo.getPrecoDeVenda() + data_base.getTransportadoras().get(artigo.getIdTransportadora()).getPrecoPequeno();
                                    }
                                    System.out.println("\n");
                                    DecimalFormat decimalFormat = new DecimalFormat("#0.00");
                                    System.out.println(" Total a pagar : " + decimalFormat.format(totalPagar) ); ///////+ funcao que calcula total a pagar
                                    System.out.println("\n");
                                    System.out.println("Pressione     -[1] para pagar");
                                    System.out.println("              -[2] para cancelar esta operação");
                                    int pago = sc.nextInt();
                                    if(pago ==1) {
                                        for (Artigo artigo : data_base.getCarrinhoPorUtilizador().get(keyUtilizador)){
                                            Encomenda encomenda = new Encomenda(data_base.getEncomendas().size()+1, artigo.getIdVendedor(), keyUtilizador, artigo.getId(), artigo.getPrecoDeVenda(), 2.0, artigo.getPrecoBase() );
                                            data_base.addEncomenda(encomenda);
                                            data_base.addEncomendasPorUtilizador(keyUtilizador, encomenda);
                                            artigo.setStock(artigo.getStock()-1);
                                            if (artigo.getStock() == 0) artigo.setVendido(true);
                                            data_base.setGanhoVintage(data_base.getGanhoVintage() + (artigo.getPrecoDeVenda() - artigo.getPrecoBase()));
                                        }
                                        data_base.limpaCarrinho(keyUtilizador);
                                        System.out.println("Pagamento efetuado com sucesso!\n");
                                        System.out.println("Pode ver a sua encomenda em 'As minhas encomendas'.");
                                        /////////adicionar funcao que cria encomenda
                                        /////////adicionar funcao que altera stock e estado vendido
                                        /////////funcao que limpa o carrinho
                                    }
                                    else {
                                        limpa_ecra.clear_screen();
                                        System.out.println("Operação cancelada com sucesso!");
                                        for (Artigo artigo : data_base.getCarrinhoPorUtilizador().get(keyUtilizador)){
                                            System.out.println(artigo);
                                        }
                                    }
                                }
                                else if(opcaoMenuCarrinho == 1 && !(data_base.getCarrinhoPorUtilizador().containsKey(keyUtilizador))){
                                    System.out.println("O seu carrinho está vazio!");
                                    System.out.println("Escolha outra opção.");
                                }
                                else if (opcaoMenuCarrinho == 2){ //remover artigo do carrinho
                                    System.out.println("Insira o Id do artigo a remover: ");
                                    int idArtigoARemover = sc.nextInt();
                                    data_base.removeArtigoDoCarrinho(keyUtilizador, data_base.getArtigos().get(idArtigoARemover));
                                    limpa_ecra.clear_screen();
                                    System.out.println("Artigo removido com sucesso!");
                                    for (Artigo artigo : data_base.getCarrinhoPorUtilizador().get(keyUtilizador)){
                                        System.out.println(artigo);
                                    }
                                }
                                else if(opcaoMenuCarrinho ==3){ // eliminar todos os itens do carrinho
                                    limpa_ecra.clear_screen();
                                    System.out.println("Tem a certeza que deseja limpar o carrinho? Sim[s] Não[n]");
                                    String querLimparCarrinho = sc.next();
                                    if (querLimparCarrinho.equals("s")||querLimparCarrinho.equals("S"))
                                    {
                                        data_base.limpaCarrinho(keyUtilizador);
                                        limpa_ecra.clear_screen();
                                        System.out.println("Carrinho limpo com sucesso!");
                                    }
                                    else {
                                        limpa_ecra.clear_screen();
                                        System.out.println("Operação cancelada com sucesso!");
                                        for (Artigo artigo : data_base.getCarrinhoPorUtilizador().get(keyUtilizador)){
                                            System.out.println(artigo);
                                        }
                                    }
                                }
                                else System.out.println("Opcao Inválida");
                                if(data_base.getCarrinhoPorUtilizador().containsKey(keyUtilizador)){
                                    for (Artigo artigo : data_base.getCarrinhoPorUtilizador().get(keyUtilizador)){
                                        System.out.println(artigo);
                                    }
                                }
                                else System.out.println("O seu carrinho está vazio!");
                                System.out.println(menu.menuCarrinho());
                                opcaoMenuCarrinho= sc.nextInt();
                                System.out.println("\n");
                            }
                        }
                        else if(opcaoMenuUtilizador==3){//Vender Produtos
                            limpa_ecra.clear_screen();
                            System.out.println("\033[32m   Vender Produto\033[0m \n");
                            System.out.println("Que tipo de produto deseja vender?");
                            int numeraTipo = 1;
                            for (String tipo : data_base.getTipoDeProduto()){
                                System.out.println(numeraTipo+" -> " + tipo + "\n");
                                numeraTipo++;
                            }
                            int tipoSelecionado = sc.nextInt();
                            String tipoSelecionadoString = "";
                            System.out.println("Nome do Produto: ");
                            String nomeDoProduto = sc.next();
                            System.out.println("Stock do Produto: ");
                            int stockDoProduto = sc.nextInt();
                            System.out.println("O Produto é novo[n] ou usado[u]?");
                            String estadoString = sc.next();
                            boolean estado = true;
                            int avaliacaoDoEstado = 10;
                            int donos = 0;
                            if (estadoString.equals("n")||estadoString.equals("N")) estado = true;
                            else if (estadoString.equals("u")||estadoString.equals("U")){
                                estado = false;
                                System.out.println("Avaliação do estado do produto(péssimo 0-10 excelente): ");
                                avaliacaoDoEstado = sc.nextInt();
                                System.out.println("Quantos donos teve o produto?");
                                donos = sc.nextInt();
                            }
                            else {
                                System.out.println("Opcao invalida");
                                opcaoMenuUtilizador = 20;
                            }
                            System.out.println("Descrição do Produto: ");
                            String descricaoProduto = sc.next();
                            System.out.println("Marca do Produto: ");
                            String marcaProduto = sc.next();
                            System.out.println("Preço do Produto: ");
                            double precoBaseDoProduto = sc.nextDouble();
                            if(tipoSelecionado == 1){
                                tipoSelecionadoString = data_base.getTipoDeProduto().get(tipoSelecionado-1);
                                System.out.println("É edição limitada? Sim[s]  Não[n]");
                                String premuimString = sc.next();
                                boolean premium = false ;
                                if(premuimString.equals("s")||premuimString.equals("S")){
                                    premium = true;
                                    limpa_ecra.clear_screen();
                                    int contaTransportadora = 1;
                                    while (contaTransportadora<=data_base.getTransportadoras().size()){
                                        if(data_base.getTransportadoras().get(contaTransportadora).getPremium()==true){
                                            System.out.println(data_base.getTransportadoras().get(contaTransportadora));
                                        }
                                        contaTransportadora++;
                                    }
                                }
                                else if(premuimString.equals("n")||premuimString.equals("N")){
                                    premium = false;
                                    limpa_ecra.clear_screen();
                                    int contaTransportadora = 1;
                                    while (contaTransportadora<=data_base.getTransportadoras().size()){
                                        System.out.println(data_base.getTransportadoras().get(contaTransportadora));
                                        contaTransportadora++;
                                    }
                                }
                                System.out.println("Escolha uma transportadora: ");
                                int idTransportadoraEscolhido = sc.nextInt();
                                if(premium && data_base.getTransportadoras().get(idTransportadoraEscolhido).getPremium()==false){
                                    System.out.println("Esta transportadora não faz entregas premium!");
                                    opcaoMenuUtilizador = 20;
                                }
                                System.out.println("Insira o tamanho das sapatilhas: ");
                                int tamanho = sc.nextInt();
                                System.out.println("Possuem atacadores? Sim[s] Não[n]");
                                String atacadoresString = sc.next();
                                boolean atacadores = true;
                                if(atacadoresString.equals("n")||atacadoresString.equals("N")) atacadores = false;
                                else atacadores = true;
                                System.out.println("Insira a cor das sapatilhas:");
                                String cor = sc.next();
                                System.out.println("Insira o ano de lançamento das sapatilhas:");
                                int anoDeLancamento = sc.nextInt();
                                 //////////////////Calcular preco
                                Sapatilha sapatilha = new Sapatilha(tamanho,atacadores,cor,anoDeLancamento,premium);
                                sapatilha.setId(data_base.getArtigos().size()+1);
                                sapatilha.setNome(nomeDoProduto);
                                sapatilha.setTipo(tipoSelecionadoString);
                                sapatilha.setStock(stockDoProduto);
                                sapatilha.setIdVendedor(keyUtilizador);
                                sapatilha.setEstado(estado);
                                sapatilha.setAvaliacaoEstado(avaliacaoDoEstado);
                                sapatilha.setDonos(donos);
                                sapatilha.setDescricao(descricaoProduto);
                                sapatilha.setMarca(marcaProduto);
                                sapatilha.setPrecoBase(precoBaseDoProduto);
                                double precoVenda = sapatilha.calculaPreco(sapatilha);
                                sapatilha.setPrecoDeVenda(precoVenda);
                                sapatilha.setIdTransportadora(idTransportadoraEscolhido);
                                sapatilha.setVendido(false);
                                data_base.addArtigo(sapatilha);
                                limpa_ecra.clear_screen();
                                estadoDB.guardaEstadoDB("./Estado/estado.obj", data_base);
                                System.out.println("Produto adicionado com sucesso!");
                                System.out.println(sapatilha);
                            }
                            else if(tipoSelecionado == 2){
                                tipoSelecionadoString = data_base.getTipoDeProduto().get(tipoSelecionado-1);
                                System.out.println("Insira o tipo de mala(ex. mochila): ");
                                String tipoDeMala = sc.next();
                                System.out.println("Insira o tamanho da mala(S/M/L): ");
                                String tamanhoDaMala = sc.next();
                                if(!(tamanhoDaMala.equals("s") || tamanhoDaMala.equals("S") || tamanhoDaMala.equals("m") || tamanhoDaMala.equals("M") || tamanhoDaMala.equals("l") || tamanhoDaMala.equals("L"))){
                                    System.out.println("Tamanho inválido!");
                                    opcaoMenuUtilizador = 20;
                                }
                                System.out.println("Insira o material da mala(ex. couro): ");
                                String materialDaMala = sc.next();
                                System.out.println("Insira o ano de lançamento da mala: ");
                                int anoDeLançamento = sc.nextInt();
                                System.out.println("É edição limitada? Sim[s]  Não[n]");
                                String premuimString = sc.next();
                                boolean premium = false ;
                                if(premuimString.equals("s")||premuimString.equals("S")){
                                    premium = true;
                                    limpa_ecra.clear_screen();
                                    int contaTransportadora = 1;
                                    while (contaTransportadora<=data_base.getTransportadoras().size()){
                                        if(data_base.getTransportadoras().get(contaTransportadora).getPremium()==true){
                                            System.out.println(data_base.getTransportadoras().get(contaTransportadora));
                                        }
                                        contaTransportadora++;
                                    }
                                }
                                else if(premuimString.equals("n")||premuimString.equals("N")){
                                    premium = false;
                                    limpa_ecra.clear_screen();
                                    int contaTransportadora = 1;
                                    while (contaTransportadora<=data_base.getTransportadoras().size()){
                                        System.out.println(data_base.getTransportadoras().get(contaTransportadora));
                                        contaTransportadora++;
                                    }
                                }
                                System.out.println("Escolha uma transportadora: ");
                                int idTransportadoraEscolhido = sc.nextInt();
                                if(premium && data_base.getTransportadoras().get(idTransportadoraEscolhido).getPremium()==false){
                                    System.out.println("Esta transportadora não faz entregas premium!");
                                    opcaoMenuUtilizador = 20;
                                }
                                /////////Funcao que calcula o preco
                                Mala mala = new Mala(tipoDeMala, tamanhoDaMala, materialDaMala, anoDeLançamento, premium);
                                mala.setId(data_base.getArtigos().size()+1);
                                mala.setNome(nomeDoProduto);
                                mala.setTipo(tipoSelecionadoString);
                                mala.setStock(stockDoProduto);
                                mala.setIdVendedor(keyUtilizador);
                                mala.setEstado(estado);
                                mala.setAvaliacaoEstado(avaliacaoDoEstado);
                                mala.setDonos(donos);
                                mala.setDescricao(descricaoProduto);
                                mala.setMarca(marcaProduto);
                                mala.setPrecoBase(precoBaseDoProduto);
                                double precoVenda = mala.calculaPreco(mala);
                                mala.setPrecoDeVenda(precoVenda);
                                mala.setIdTransportadora(idTransportadoraEscolhido);
                                mala.setVendido(false);
                                data_base.addArtigo(mala);
                                limpa_ecra.clear_screen();
                                estadoDB.guardaEstadoDB("./Estado/estado.obj", data_base);
                                System.out.println("Produto adicionado com sucesso!");
                                System.out.println(mala);
                            }
                            else if(tipoSelecionado ==3){
                                String padraoDaTshirtString = "";
                                System.out.println("Insira o tamanho da T-shirt(XS/S/M/L/XL): ");
                                String tamanhoDaTshirt = sc.next();
                                if(!(tamanhoDaTshirt.equals("xs") || tamanhoDaTshirt.equals("XS") || tamanhoDaTshirt.equals("Xs") || tamanhoDaTshirt.equals("s") || tamanhoDaTshirt.equals("S") || tamanhoDaTshirt.equals("m") || tamanhoDaTshirt.equals("M") || tamanhoDaTshirt.equals("l") || tamanhoDaTshirt.equals("L") || tamanhoDaTshirt.equals("XL") || tamanhoDaTshirt.equals("xl") || tamanhoDaTshirt.equals("Xl") )){
                                    System.out.println("Tamanho inválido!");
                                    opcaoMenuUtilizador = 20;
                                }
                                System.out.println("Selecione o padrão da Tshirt: ");
                                System.out.println("1 - Liso");
                                System.out.println("2 - Riscas");
                                System.out.println("3 - Palmeiras");
                                int padraoDaTshirt = sc.nextInt();
                                if(padraoDaTshirt!=1 && padraoDaTshirt!=2 && padraoDaTshirt!=3){
                                    System.out.println("Opção inválida!");
                                    opcaoMenuUtilizador = 20;
                                }
                                else {
                                    if(padraoDaTshirt==1) padraoDaTshirtString = "Liso";
                                    else if(padraoDaTshirt==2) padraoDaTshirtString = "Riscas";
                                    else padraoDaTshirtString = "Palmeiras";
                                }
                                limpa_ecra.clear_screen();
                                int contaTransportadora = 1;
                                while (contaTransportadora<=data_base.getTransportadoras().size()){
                                    System.out.println(data_base.getTransportadoras().get(contaTransportadora));
                                    contaTransportadora++;
                                }
                                System.out.println("Escolha uma transportadora: ");
                                int idTransportadoraEscolhido = sc.nextInt();
                                Tshirt tshirt = new Tshirt(tamanhoDaTshirt,padraoDaTshirtString);
                                tshirt.setId(data_base.getArtigos().size()+1);
                                tshirt.setNome(nomeDoProduto);
                                tshirt.setTipo(tipoSelecionadoString);
                                tshirt.setStock(stockDoProduto);
                                tshirt.setIdVendedor(keyUtilizador);
                                tshirt.setEstado(estado);
                                tshirt.setAvaliacaoEstado(avaliacaoDoEstado);
                                tshirt.setDonos(donos);
                                tshirt.setDescricao(descricaoProduto);
                                tshirt.setMarca(marcaProduto);
                                tshirt.setPrecoBase(precoBaseDoProduto);
                                double precoVenda = tshirt.calculaPreco(tshirt);
                                tshirt.setPrecoDeVenda(precoVenda);
                                tshirt.setIdTransportadora(idTransportadoraEscolhido);
                                tshirt.setVendido(false);
                                data_base.addArtigo(tshirt);
                                limpa_ecra.clear_screen();
                                estadoDB.guardaEstadoDB("./Estado/estado.obj", data_base);
                                System.out.println("Produto adicionado com sucesso!");
                                System.out.println(tshirt);
                            }
                            else {
                                opcaoMenuUtilizador = 20;
                                System.out.println("Opcao Invalida");
                            }
                        }
                        else if(opcaoMenuUtilizador==4){
                            int contaEncomendas = 0;
                            while (contaEncomendas<data_base.getEncomendasPorUtilizador().get(keyUtilizador).size()){
                                System.out.println(data_base.getEncomendasPorUtilizador().get(keyUtilizador).get(contaEncomendas));
                                contaEncomendas++;
                            }
                        }
                        else if(opcaoMenuUtilizador==5){
                            int contaArtigos = 1;
                            while (contaArtigos<data_base.getArtigos().size()){
                                if (data_base.getArtigos().get(contaArtigos).getIdVendedor() == keyUtilizador){
                                    System.out.println(data_base.getArtigos().get(contaArtigos));
                                }
                                contaArtigos++;
                            }
                        }
                        else System.out.println("Opcao Invalida");
                        System.out.println(menu.menuUtilizador());
                        opcaoMenuUtilizador = sc.nextInt();
                        System.out.println("\n");
                    }
                }
                //for(String email : data_base.getEmailUtilizadores() ){
                //    System.out.println(email);
                //}
            }
            /*else if(opcao == 4) {
                limpa_ecra.clear_screen();
                System.out.println("Insira o seu ID para efetuar o login: ");
                int idLogin = sc.nextInt();
                if(data_base.getTransportadoras().containsKey(idLogin)){
                    System.out.println("Login efetuado com sucesso!");
                    System.out.println(menu.menuTransportadora());
                    int opcaoUtilizador = sc.nextInt();
                    while(opcaoUtilizador != 0){
                        if(opcaoUtilizador==1){}
                        else if(opcaoUtilizador==2){}
                        else if(opcaoUtilizador==3){}
                        else if(opcaoUtilizador==4){}
                        else if(opcaoUtilizador==5){}
                        else System.out.println("Opcao Invalida");
                        System.out.println(menu.menuUtilizador());
                        opcaoUtilizador = sc.nextInt();
                    }
                }
                for(String email : data_base.getEmailUtilizadores() ){
                    System.out.println(email);
                }
            }*/
            else if(opcao == 4) {
                limpa_ecra.clear_screen();
                String opsair = "sc";
                while(!opsair.equals("0")){
                    System.out.println("Insira o nome do tipo que quer inserir: ");
                    opsair = sc.next();
                    if (!opsair.equals("0")) data_base.tempTipoDeProduto(opsair);
                }
                estadoDB.guardaEstadoDB("./Estado/estado.obj", data_base);
            }
            else System.out.println("Opcao Invalida");
            System.out.println(menu.menuInicial());
            opcao = sc.nextInt();
            System.out.println("\n");
        }//--
    }//--
}//--
