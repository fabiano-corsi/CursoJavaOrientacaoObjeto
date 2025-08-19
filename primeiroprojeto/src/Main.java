//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Esse é o Screen Match");
        System.out.println("Filme: Top Gun: Maverick");

        int anoDeLancamento = 2022;

        System.out.println("Ano De Lançamento: " + anoDeLancamento);
        boolean incluidoNoPlano = true;
        double notaDoFilme = 1.1;

        double media = (9.8 + 6.3 + 8.0) / 3; //Divisão
        System.out.println(media);

        String sinopse;

        //Usando TEXT-BLOCKS com concatenação usando formatted
        sinopse = """ 
                Filme Top Gun
                Filme de aventura com galã dos anos 80
                Muito Bom!
                Ano de lançamento %d
                """.formatted(anoDeLancamento);
        System.out.printf(sinopse);

        int classificacao = (int) media / 2;
        System.out.println(classificacao);
    }
}