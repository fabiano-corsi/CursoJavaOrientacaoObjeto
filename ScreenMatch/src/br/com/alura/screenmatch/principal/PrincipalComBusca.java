package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;
import br.com.alura.screenmatch.modelos.excecao.ErroDeConversaoDeAnoException;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        String busca = "";
        List<Titulo> titulos = new ArrayList<>();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create(); //Usando o builder pode definir como o atributo vem da api de origem

        while (busca.equalsIgnoreCase("sair") == false) {
            System.out.println("Digite um filme para busca:");

            busca = URLEncoder.encode(leitura.nextLine(), StandardCharsets.UTF_8);

            if (busca.equalsIgnoreCase("sair")) {
                break;
            }

            String endereco = "https://www.omdbapi.com/?t=" + busca + "&apikey=1ba4fc07";

            System.out.println(endereco);
            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereco))
                        .build();

                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                System.out.println("Headers: " + response.headers());
                System.out.println("--------------------------------------------------------------");
                System.out.println("Body: " + response.body());

                TituloOmdb meuTituloOmdn = gson.fromJson(response.body(), TituloOmdb.class);

                Titulo meuTitulo = new Titulo(meuTituloOmdn);
                System.out.println("Titulo: " + meuTitulo);

                titulos.add(meuTitulo);
            } catch (NumberFormatException ex) {
                System.out.println("Aconteceu um erro: ");
                System.out.println(ex.getMessage());
            } catch (IllegalArgumentException ex) {
                System.out.println("Algum erro de argumento na busca, verifique o endereço");
            } catch (ErroDeConversaoDeAnoException ex) {
                System.out.println("Erro de conversao de dados: ");
                System.out.println(ex.getMessage());
            }
        }

        System.out.println(titulos);

        FileWriter escrita = new FileWriter("filmes.json");
        escrita.write(gson.toJson(titulos));
        escrita.close();
        System.out.println("Programa finalizou corretamente");
    }
}
