package br.com.alura.consultacep.adapter;

import br.com.alura.consultacep.exception.CepNaoEncontradoException;
import br.com.alura.consultacep.exception.FormatoDeCepInvalidoException;
import br.com.alura.consultacep.exception.FormatoUFInvalidoException;
import br.com.alura.consultacep.exception.ServicoNaoDisponivelException;
import br.com.alura.consultacep.modelos.ConsultaCepService;
import br.com.alura.consultacep.modelos.Endereco;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ConsultaCepTxtFileDecorator extends ConsultaCepDecorator{
    public ConsultaCepTxtFileDecorator(ConsultaCepService wrapper) {
        super(wrapper);
    }

    @Override
    public Endereco buscar(String cep) throws FormatoDeCepInvalidoException, CepNaoEncontradoException, ServicoNaoDisponivelException {
        Endereco endereco = super.buscar(cep);

        try {
            salvar(endereco.toString());
        }
        catch (IOException e) {

        }

        return endereco;
    }

    @Override
    public List<Endereco> localizar(String uf, String localidade, String logradouro) throws ServicoNaoDisponivelException, CepNaoEncontradoException, FormatoUFInvalidoException {
        List<Endereco> enderecos = super.localizar(uf, localidade, logradouro);

        try {
            salvar(enderecos.toString());
        }
        catch (IOException e) {

        }

        return enderecos;
    }

    private void salvar(String data) throws IOException {
        FileWriter writer = new FileWriter("historico.txt", true);
        writer.write(data);
        writer.close();
    }
}