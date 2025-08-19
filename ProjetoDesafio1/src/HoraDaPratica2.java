public class HoraDaPratica2 {
    public static void main(String[] args) {
        //Crie um programa que realize a média de duas notas decimais e exiba o resultado.
        double nota1 = 10;
        double nota2 = 5;
        double media = (nota1 + nota2) / 2;
        System.out.printf("A média das notas %.0f e %.0f é %.1f%n", nota1, nota2, media);

        //Declare uma variável do tipo double e uma variável do tipo int. Faça o casting da variável double para int e imprima o resultado.
        double d1 = 18.7;
        int i1 = (int)d1;
        System.out.printf("Casting da variavel %d%n", i1);

        //Declare uma variável do tipo double precoProduto e uma variável do tipo int (quantidade). Calcule o valor total multiplicando o preço do produto pela quantidade e apresente o resultado em uma mensagem.
        double precoProduto = 29.99;
        int qtd = 10;
        System.out.printf("""
                O preço unitario do produto é de R$%.2f
                O total de %d pedidos é de R$%.2f%n""", precoProduto, qtd, qtd * precoProduto);

        //Declare uma variável do tipo double valorEmDolares. Atribua um valor em dólares a essa variável. Considere que o valor de 1 dólar é equivalente a 4.94 reais. Realize a conversão do valor em dólares para reais e imprima o resultado formatado.
        double valorEmDolares = 459.99;
        double taxaConversao = 4.94;
        System.out.println("A conversão do valor U$%.2f em real é R$%.2f".formatted(valorEmDolares, valorEmDolares * taxaConversao));
        //Declare uma variável do tipo double precoOriginal. Atribua um valor em reais a essa variável, representando o preço original de um produto. Em seguida, declare uma variável do tipo double percentualDesconto e atribua um valor percentual de desconto ao produto (por exemplo, 10 para 10%). Calcule o valor do desconto em reais, aplique-o ao preço original e imprima o novo preço com desconto.
        double precoOriginal = 59.99;
        double percentualDesconto = 100;
        precoOriginal = precoOriginal - (precoOriginal * (percentualDesconto / 100));
        System.out.println("O valor com desconto é %.2f".formatted(precoOriginal));

    }
}
