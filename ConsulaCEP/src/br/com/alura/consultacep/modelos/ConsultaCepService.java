package br.com.alura.consultacep.modelos;

import br.com.alura.consultacep.exception.CepNaoEncontradoException;
import br.com.alura.consultacep.exception.FormatoDeCepInvalidoException;
import br.com.alura.consultacep.exception.FormatoUFInvalidoException;
import br.com.alura.consultacep.exception.ServicoNaoDisponivelException;

import java.io.UnsupportedEncodingException;
import java.util.List;

public interface ConsultaCepService {
    Endereco buscar(String cep) throws
            FormatoDeCepInvalidoException,
            CepNaoEncontradoException,
            ServicoNaoDisponivelException;
    List<Endereco> localizar(String uf, String localidade, String logradouro) throws
            ServicoNaoDisponivelException,
            CepNaoEncontradoException,
            FormatoUFInvalidoException;
}
