package br.com.alura.consultacep.adapter;

import br.com.alura.consultacep.modelos.Endereco;

import java.util.ArrayList;
import java.util.List;

public class EnderecoViaCepImp extends Endereco {
    public EnderecoViaCepImp(EnderecoViaCep endereco) {
        super(
                endereco.cep(),
                endereco.logradouro(),
                endereco.bairro(),
                endereco.localidade(),
                endereco.uf(),
                endereco.estado());
        setDdd(endereco.ddd());
        setRegiao(endereco.regiao());
        setSiafi(endereco.siafi());
    }

    public static List<Endereco> converter(List<EnderecoViaCep> enderecos) {
        List<Endereco> enderecosConvertidos = new ArrayList<>(enderecos.size());
        for (EnderecoViaCep endereco: enderecos) {
            enderecosConvertidos.add(new EnderecoViaCepImp(endereco));
        }

        return enderecosConvertidos;
    }
}
