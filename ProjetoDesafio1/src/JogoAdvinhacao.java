import java.util.Random;
import java.util.Scanner;

public class JogoAdvinhacao {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);

        int tentativas = 5;
        int chutes = 0;
        boolean acertou = false;
        int numeroSecreto = new Random().nextInt(100);

        System.out.println("""
                ################################################################
                #Jogo do Numero secreto
                ################################################################
                Instruções: Você terá 5 tentativas para acertar o numero secreto
                Lembre-se que apenas numeros inteiros são aceitos
                """);

        while (chutes < tentativas && !acertou)
        {
            System.out.println("Qual é o seu palpite? Digite de 1 a 100");
            int chute = leitura.nextInt();

            if(chute == numeroSecreto) {
                acertou = true;
            }
            else {
                chutes++;
                System.out.printf("Você errou, tente novamente! (Você ainda tem %d tentativa/s)%n", tentativas - chutes);

                if (chute < numeroSecreto) {
                    System.out.println("O numero secreto é maior");
                }
                else {
                    System.out.println("O numero secreto é menor");
                }
            }
        }

        if (acertou)
        {
            System.out.println("Parabéns, você descobriu o numero secreto: " + numeroSecreto + " com " + chutes + "chutes");
        }
        else
        {
            System.out.println("Você perdeu :(. O numero secreto era: " + numeroSecreto);
        }

    }
}
