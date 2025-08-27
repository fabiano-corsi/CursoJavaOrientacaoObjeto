package br.com.alura.consultacep.adapter;

import br.com.alura.consultacep.modelos.Endereco;

public record EnderecoViaCep(String cep,
                             String logradouro,
                             String bairro,
                             String localidade,
                             String uf,
                             String estado,
                             String regiao,
                             String ddd,
                             String siafi) {
}
