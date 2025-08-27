package br.com.alura.DesafioAplicacaoCompras.principal;
import br.com.alura.DesafioAplicacaoCompras.modelos.CartaoDeCredito;
import br.com.alura.DesafioAplicacaoCompras.modelos.Compra;
import br.com.alura.DesafioAplicacaoCompras.modelos.SaldoInsuficienteException;

import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(""" 
                ************************************************
                *LISTA DE COMPRAS
                ************************************************
                """);

        Scanner leitura = new Scanner(System.in);

        int limiteCartao = lerValorInteiroNoTerminal(leitura, "Digite o limite do cartão!");

        CartaoDeCredito cartaoDeCredito = new CartaoDeCredito(limiteCartao);

        do {
            System.out.println("Digite a descrição da compra");
            leitura.nextLine(); //Liberar o next anterior para ler a linha correta
            String item = leitura.nextLine();
            int valorDoItem = lerValorInteiroNoTerminal(leitura, "Digite o valor da compra");

            try {
                cartaoDeCredito.comprar(new Compra(valorDoItem, item));
                System.out.println("Compra realizada com sucesso!");
            }
            catch (SaldoInsuficienteException ex) {
                System.out.println(ex.getMessage());
                System.out.println("Saldo disponivel: " + cartaoDeCredito.getSaldo());
            }
        } while (continuarOperacao(leitura));

        imprimirNotaDeCompra(cartaoDeCredito);

        System.out.println("Sistema finalizado");
    }

    public static int lerValorInteiroNoTerminal(Scanner scanner, String mensagem) {
        System.out.println(mensagem);
        while (!scanner.hasNextInt()) {
            System.out.println("Valor deve ser um numero inteiro!");

        }

        return scanner.nextInt();
    }

    public static Boolean continuarOperacao(Scanner scanner) {
        System.out.println("Digite 0 para sair ou 1 para continuar");
        String ret = scanner.next();
        while (!ret.equals("0") && !ret.equals("1")) {
            System.out.println("Valor deve ser 0 ou 1! Digite novamente");
            ret = scanner.next();
        }
        if (ret.equals("1")) {
            return true;
        } else {
            return false;
        }
    }

    public static void imprimirNotaDeCompra(CartaoDeCredito cartaoDeCredito) {
        System.out.println("""
                ==============================================
                COMPRAS REALIZADAS:""");
        Collections.sort(cartaoDeCredito.getListaDeCompras());
        cartaoDeCredito.getListaDeCompras().forEach(compra -> System.out.println(compra.toString()));
        System.out.println("Saldo disponivel R$%.2f".formatted(cartaoDeCredito.getSaldo()));
        System.out.println("==============================================");
    }
}