package br.com.alura.consultacep.adapter;

import br.com.alura.consultacep.exception.CepNaoEncontradoException;
import br.com.alura.consultacep.exception.FormatoDeCepInvalidoException;
import br.com.alura.consultacep.exception.FormatoUFInvalidoException;
import br.com.alura.consultacep.exception.ServicoNaoDisponivelException;
import br.com.alura.consultacep.modelos.ConsultaCepService;
import br.com.alura.consultacep.modelos.Endereco;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ConsultaCepHistoricoJsonDecorator extends ConsultaCepDecorator {

    public ConsultaCepHistoricoJsonDecorator(ConsultaCepService consulaCepService) {
        super(consulaCepService);
    }

    private List<Endereco> salvarHistorico(List<Endereco> enderecos){
        salvarJson(enderecos);
        return enderecos;
    }

    private Endereco salvarHistorico(Endereco endereco) {
        salvarJson(endereco);
        return endereco;
    }

    private static void salvarJson(Object obj) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            FileWriter writer = new FileWriter("historico-de-pesquisa.json");
            writer.write(gson.toJson(obj));
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar arquivo de historico");
        }
    }

    @Override
    public Endereco buscar(String cep) throws FormatoDeCepInvalidoException, CepNaoEncontradoException, ServicoNaoDisponivelException {
        return salvarHistorico(super.buscar(cep));

    }

    @Override
    public List<Endereco> localizar(String uf, String localidade, String logradouro) throws ServicoNaoDisponivelException, CepNaoEncontradoException, FormatoUFInvalidoException {
        return salvarHistorico(super.localizar(uf, localidade, logradouro));
    }
}
