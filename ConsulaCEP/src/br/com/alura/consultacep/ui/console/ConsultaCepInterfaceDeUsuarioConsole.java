package br.com.alura.consultacep.ui.console;
import br.com.alura.consultacep.adapter.ConsultaCepHistoricoJsonDecorator;
import br.com.alura.consultacep.exception.CepNaoEncontradoException;
import br.com.alura.consultacep.exception.FormatoDeCepInvalidoException;
import br.com.alura.consultacep.exception.FormatoUFInvalidoException;
import br.com.alura.consultacep.exception.ServicoNaoDisponivelException;
import br.com.alura.consultacep.factory.SingletonFactory;
import br.com.alura.consultacep.modelos.ConsultaCepInterfaceDeUsuario;
import br.com.alura.consultacep.modelos.ConsultaCepService;
import br.com.alura.consultacep.modelos.Endereco;

import java.util.List;
import java.util.Scanner;

public class ConsultaCepInterfaceDeUsuarioConsole implements ConsultaCepInterfaceDeUsuario {

    @Override
    public void Execute() {
        Scanner leitura = new Scanner(System.in);

        System.out.println("""
                ------------------------------------------
                - CONSULTA CEP
                ------------------------------------------
                """);

        boolean continuar = true;
        while (continuar) {
            System.out.println("""
                1 - Buscar por CEP
                2 - Não sei meu CEP, localizar por endereço
                * Digite sair para encerrar o programa
                """);

            String opcaoSelecionada = leitura.nextLine();
            switch (opcaoSelecionada) {
                case "1":
                    this.buscarPorCep();
                    break;
                case "2":
                    this.buscarPorEndereco();
                    break;
                case "sair":
                    continuar = false;
                    break;
            }
        }

        System.out.println("Programa encerrado!");
    }

    private void buscarPorCep() {
        ConsultaCepService consultaCepService = SingletonFactory.getInstance().getConsultaCepService();
        Scanner leitura = new Scanner(System.in);

        System.out.println("Digite o cep para pesquisar: ");
        String cep = leitura.nextLine();
        try {
            Endereco endereco = consultaCepService.buscar(cep);

            System.out.printf(endereco.toString());
            System.out.println("""
                    --------------------------------------------------------------
                    """);
        } catch (FormatoDeCepInvalidoException | CepNaoEncontradoException | ServicoNaoDisponivelException e) {
            System.out.println("""
                    --------ERRO--------
                    """ + e.getMessage());
        }
    }

    private void buscarPorEndereco() {
        ConsultaCepService consultaCepService = SingletonFactory.getInstance().getConsultaCepService();
        Scanner leitura = new Scanner(System.in);

        System.out.println("Digite o UF para pesquisar: ");
        String uf = leitura.nextLine();

        System.out.println("Digite a Cidade para pesquisar: ");
        String localizacao = leitura.nextLine();

        System.out.println("Digite o logradouro (rua, avenida, etc...) para pesquisar: ");
        String logradouro = leitura.nextLine();
        try {
            List<Endereco> enderecos = consultaCepService.localizar(uf, localizacao, logradouro);

            System.out.println(enderecos);
        } catch (CepNaoEncontradoException |
                 ServicoNaoDisponivelException |
                 FormatoUFInvalidoException e) {
            System.out.println("""
                    --------ERRO--------
                    """ + e.getMessage() + """
                    --------------------
                    """);
        }
    }
}