import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        imprimirLivro();
        imprimeMoeda();
        imprimeReceita();
    }

    private static void imprimirLivro() throws IOException, InterruptedException {

        Scanner scan = new Scanner(System.in);

        System.out.println("Digite o livro que vc quer pesquisar");
        String livro = scan.nextLine();
        livro = livro.replace(' ', '+');

        String enderecoLivro = "https://www.googleapis.com/books/v1/volumes?q=" + livro;
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(enderecoLivro))
                .build();

        HttpResponse response;

        response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("""
            ========================================
            Resposta do livro
            %s
            ========================================
        """.formatted(response.body()));
    }

    private static void imprimeMoeda() throws IOException, InterruptedException {

        Scanner scan = new Scanner(System.in);
        System.out.println("Digite uma cripto moeda para ver a cotação atual");
        String moeda = scan.nextLine();
        moeda = moeda.replace(' ', '+');
        String enderecoCripto = "https://api.coingecko.com/api/v3/simple/price?ids=" + moeda + "&vs_currencies=usd";

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(enderecoCripto))
                .build();

        HttpResponse response;

        response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("""
            ========================================
            Resposta da cotação da Moeda
            %s
            ========================================
        """.formatted(response.body()));
    }

    private static void imprimeReceita() throws IOException, InterruptedException {

        Scanner scan = new Scanner(System.in);
        System.out.println("Digite uma receita para exibir informações");
        String receita = scan.nextLine();
        receita = receita.replace(' ', '+');

        String enderecoReceita = "https://www.themealdb.com/api/json/v1/1/search.php?s=" + receita;

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(enderecoReceita))
                .build();

        HttpResponse response;

        response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("""
            ========================================
            Resposta da Receita
            %s
            ========================================
        """.formatted(response.body()));
    }
}
