package br.com.alura.consultacep.adapter;
import br.com.alura.consultacep.exception.CepNaoEncontradoException;
import br.com.alura.consultacep.exception.FormatoDeCepInvalidoException;
import br.com.alura.consultacep.exception.FormatoUFInvalidoException;
import br.com.alura.consultacep.exception.ServicoNaoDisponivelException;
import br.com.alura.consultacep.modelos.ConsultaCepService;
import br.com.alura.consultacep.modelos.Endereco;

import java.util.List;

public abstract class ConsultaCepDecorator implements ConsultaCepService {
    private ConsultaCepService wrapper;

    public ConsultaCepDecorator(ConsultaCepService wrapper) {
        this.wrapper = wrapper;
    }

    @Override
    public Endereco buscar(String cep) throws FormatoDeCepInvalidoException, CepNaoEncontradoException, ServicoNaoDisponivelException {
        return wrapper.buscar(cep);
    }

    @Override
    public List<Endereco> localizar(String uf, String localidade, String logradouro) throws ServicoNaoDisponivelException, CepNaoEncontradoException, FormatoUFInvalidoException {
        return wrapper.localizar(uf, localidade, logradouro);
    }
}
