package src;

import java.util.Scanner;

public class Menu {
 /*   public int menuUtilizador(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("\u001B[33m---------------> Vintage <----------------\u001B[0m");
        System.out.println();
        System.out.println();
        System.out.println("\u001B[36m  MENU   \u001B[0m");
        System.out.println();
        System.out.println("    1  ->  Comprar produtos");
        System.out.println("    2  ->  O meu carrinho");
        System.out.println("    3  ->  Vender produtos");
        System.out.println("    4  ->  A minha página");
        System.out.println();
        System.out.print("   Selecione uma opção:  ");
        return 0;
    }*/

    public String menuInicial(){
        return "\n+----------------------------------------------------------+\n" +
                "|                   \033[33mBEM-VINDO À VINTAGE!\033[0m                   |\n" +
                "+----------------------------------------------------------+\n" +
                "|        \u001B[38;5;208mEscolha uma opção:\033[0m                                |\n" +
                "+----------------------------------------------------------+\n" +
                "|        1 - \033[36mCriar Conta de Usuário\033[0m                        |\n" +
                "|        2 - \033[36mCriar Conta de Transportadora\033[0m                 |\n" +
                "|        3 - \033[33mLogin de Usuário\033[0m                              |\n" +
               // "|        4 - \033[33mLogin de Transportadora\033[0m                       |\n" +
                "|        0 - \033[31mSair\033[0m                                          |\n" +
                "+----------------------------------------------------------+\n" +
                " Selecione uma opção: ";
    }

    public String menuUtilizador(){
        return  "\n+----------------------------------------------------------+\n" +
                "|                   \033[33mBEM-VINDO À VINTAGE!\033[0m                   |\n" +
                "+----------------------------------------------------------+\n" +
                "|        \u001B[38;5;208mEscolha uma opção:\033[0m                                |\n" +
                "+----------------------------------------------------------+\n" +
                "|        1 - \033[36mComprar produtos\033[0m                              |\n" +
                "|        2 - \033[36mO meu carrinho\033[0m                                |\n" +
                "|        3 - \033[33mVender produtos\033[0m                               |\n" +
                "|        4 - \033[33mAs minhas encomendas\033[0m                          |\n" +
                "|        5 - \033[33mOs meus produtos\033[0m                              |\n" +
                "|        0 - \033[31mSair\033[0m                                          |\n" +
                "+----------------------------------------------------------+\n" +
                " Selecione uma opção: ";
    }

    /*public String menuTransportadora(){
        return  "\n+----------------------------------------------------------+\n" +
                "|                   \033[33mBEM-VINDO À VINTAGE!\033[0m                   |\n" +
                "+----------------------------------------------------------+\n" +
                "|        \u001B[38;5;208mEscolha uma opção:\033[0m                                |\n" +
                "+----------------------------------------------------------+\n" +
                "|        1 - \033[36mAlterar preços de entrega\033[0m                     |\n" +
                "|        2 - \033[36mAlterar taxa de imposto\033[0m                       |\n" +
                "|        3 - \033[33mAlterar entregas Premium\033[0m                      |\n" +
                "|        4 - \033[33mConsultar preços atuais\033[0m                       |\n" +
                "|        5 - \033[33mEliminar transportadora\033[0m                       |\n" +
                "|        0 - \033[31mSair\033[0m                                          |\n" +
                "+----------------------------------------------------------+\n" +
                " Selecione uma opção: ";
    }*/

    public String menuComprarProduto(){
        return  "\n+----------------------------------------------------------+\n" +
                "|                   \033[33mBEM-VINDO À VINTAGE!\033[0m                   |\n" +
                "+----------------------------------------------------------+\n" +
                "|        \u001B[38;5;208mEscolha uma opção:\033[0m                                |\n" +
                "+----------------------------------------------------------+\n" +
                "|        1 - \033[36mAdicionar produto ao carrinho\033[0m                 |\n" +
                "|        2 - \033[36mVer carrinho\033[0m                                  |\n" +
                "|        3 - \033[33mProcurar por tipo\033[0m                             |\n" +
                "|        0 - \033[31mSair\033[0m                                          |\n" +
                "+----------------------------------------------------------+\n" +
                " Selecione uma opção: ";
    }

    public String menuCarrinho(){
        return  "\n+----------------------------------------------------------+\n" +
                "|                   \033[33mBEM-VINDO À VINTAGE!\033[0m                   |\n" +
                "+----------------------------------------------------------+\n" +
                "|        \u001B[38;5;208mEscolha uma opção:\033[0m                                |\n" +
                "+----------------------------------------------------------+\n" +
                "|        1 - \033[36mProsseguir para pagamento\033[0m                     |\n" +
                "|        2 - \033[36mRemover artigo\033[0m                                |\n" +
                "|        3 - \033[36mLimpar Carrinho\033[0m                               |\n" +
                "|        0 - \033[31mVoltar atrás\033[0m                                  |\n" +
                "+----------------------------------------------------------+\n" +
                " Selecione uma opção: ";
    }
}
