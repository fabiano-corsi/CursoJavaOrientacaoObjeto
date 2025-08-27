package br.com.alura.consultacep.adapter;
import br.com.alura.consultacep.exception.CepNaoEncontradoException;
import br.com.alura.consultacep.exception.FormatoDeCepInvalidoException;
import br.com.alura.consultacep.exception.FormatoUFInvalidoException;
import br.com.alura.consultacep.exception.ServicoNaoDisponivelException;
import br.com.alura.consultacep.modelos.ConsultaCepService;
import br.com.alura.consultacep.modelos.Endereco;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class ConsultaCepViaCepImp implements ConsultaCepService {
    private HttpClient httpCliente;

    public ConsultaCepViaCepImp() {
        this.httpCliente = HttpClient.newHttpClient();
    }

    @Override
    public Endereco buscar(String cep) throws FormatoDeCepInvalidoException, CepNaoEncontradoException, ServicoNaoDisponivelException {
        //Substitui tudo que não é digito por vazio
        String cepFormatado = cep.replaceAll("[^0-9]", "");

        //Verifica se o CEP tem 8 digitos, se não tiver, lança exceção
        if (cepFormatado.length() != 8) {
            throw new FormatoDeCepInvalidoException("""
                    O cep precisa ter exatamente 8 dígitos.
                    O Cep informado %s é inválido.""".formatted(cep));
        }

        String endpoint = "https://viacep.com.br/ws/%s/json/".formatted(cepFormatado);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endpoint))
                .build();
        try {
            HttpResponse<String> response = httpCliente.send(
                    request,
                    HttpResponse.BodyHandlers.ofString());

            Gson gSon =  new Gson();
            EnderecoViaCep endereco = gSon.fromJson(response.body(), EnderecoViaCep.class);

            if (endereco.cep() ==null) {
                throw new CepNaoEncontradoException("""
                        O Cep não pode ser encontrado.
                        """);
            }

            return new EnderecoViaCepImp(endereco);
        } catch (IOException | InterruptedException e) {
            throw new ServicoNaoDisponivelException("""
                    O serviço de pesquisar cep está indisponível
                    """ + e.getMessage());
        }
    }

    @Override
    public List<Endereco> localizar(String uf, String localidade, String logradouro) throws
            ServicoNaoDisponivelException,
            CepNaoEncontradoException,
            FormatoUFInvalidoException {

        if (!uf.matches("[A-Za-z]{2}")) {
            throw new FormatoUFInvalidoException("""
                    UF %s não é valido. UF deve ter dois caracteres e somente texto
                    """.formatted(uf));
        }

        String endpoint = "https://viacep.com.br/ws/%s/%s/%s/json/"
                .formatted(uf,
                        localidade.replace(" ", "%20"),
                        logradouro.replace(" ", "+"));

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endpoint))
                .build();

        try {
            HttpResponse<String> response = httpCliente.send(
                    request,
                    HttpResponse.BodyHandlers.ofString());

            TypeToken<ArrayList<EnderecoViaCep>> collectionType = new TypeToken<>(){};

            Gson gSon =  new Gson();

            if (response.statusCode() == 404) {
                throw new CepNaoEncontradoException("""
                        Não é possivel encontrar nenhum endereço com as informações fornecidas
                        """);
            }
            String json = response.body();
            List<EnderecoViaCep> enderecos = gSon.fromJson(json, collectionType);

            if (enderecos == null || enderecos.size() == 0) {
                throw new CepNaoEncontradoException("""
                        Cep para o endereço
                        UF - %s
                        Cidade - %s
                        Logradouro - %s
                        Não encontrado
                        """.formatted(uf, localidade, logradouro));
            }

            return EnderecoViaCepImp.converter(enderecos);
        } catch (IOException | InterruptedException e) {
            throw new ServicoNaoDisponivelException("""
                    O serviço de pesquisar cep está indisponível
                    """ + e.getMessage());
        }
    }
}
