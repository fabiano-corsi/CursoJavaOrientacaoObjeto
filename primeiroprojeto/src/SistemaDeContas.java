import Contas.Conta;
import Contas.SemSaldoSuficienteException;
import Contas.TipoConta;

import java.util.Scanner;

public class SistemaDeContas {
    public static void main(String[] args) {
        Conta conta = new Conta("Fabiano Ribeiro de Souza", TipoConta.ContaCorrente, 5000);

        imprimirDadosCliente(conta);
        executarOperações(new Scanner(System.in), conta);

        System.out.println("Finalizando sistema. Obrigado e volte sempre");
    }

    static void imprimirDadosCliente(Conta conta) {
        System.out.println("""
                *************************************************************************
                Dados do cliente:
                *************************************************************************
                Nome: %s
                Tipo: %s
                Saldo Inicial: R$%.2f
                """.formatted(conta.getNomeCliente(), conta.getTipoConta(), conta.getSaldo()));
    }

    static void executarOperações(Scanner leitura, Conta conta) {
        System.out.println("""
                Operações
                
                1- Consultar saldo
                2- Depositar valor
                3- Sacar valor
                4- Sair
                
                Digite a opção desejada:""");

        while (!leitura.hasNextInt()) {
            System.out.println("Opção Inválida. Tente novamente");
        }
        int operacao = leitura.nextInt();
        if (operacao > 4) {
            System.out.println("Opção Inválida. Selecione de 1 a 4");
            executarOperações(leitura, conta);
        } else {
            switch (operacao) {
                case 1:
                    consultarSaldo(conta);
                    break;
                case 2:
                    depositar(leitura, conta);
                    break;
                case 3:
                    sacar(leitura, conta);
                    break;
                case 4:
                    return;
            }
            executarOperações(leitura, conta);
        }
    }

    static void consultarSaldo(Conta conta) {
        System.out.printf("""
                *********************************
                *Seu saldo atual é: R$%.2f
                *********************************%n""", conta.getSaldo());
    }

    static void depositar(Scanner leitura, Conta conta) {
        System.out.println("Digite o valor a depositar: ");

        if (!leitura.hasNextDouble()) {
            System.out.println("Valor inválido, tente novamente");
            depositar(leitura, conta);
        } else {
            double valor = leitura.nextDouble();
            conta.depositar(valor);
            System.out.println("Valor depositado com sucesso");
        }
    }

    static void sacar(Scanner leitura, Conta conta) {
        System.out.println("Digite o valor a sacar: ");

        if (!leitura.hasNextDouble()) {
            System.out.println("Valor inválido, tente novamente");
            depositar(leitura, conta);
        } else {
            double valor = leitura.nextDouble();
            try {
                conta.sacar(valor);
                System.out.println("Valor sacado com sucesso");
            }catch (SemSaldoSuficienteException ex) {
                System.out.println("Saldo insuficiente");
            }
        }
    }
}
