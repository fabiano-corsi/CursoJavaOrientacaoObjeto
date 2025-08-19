public class CelsisFahrenheitConverter {
    public static void main(String[] args) {
        int celsius = 15;

        int fahrenheit = (int)(celsius * 1.8) + 32;

        System.out.printf("A temperatura %d em celsius é %d em fahrenheit%n", celsius, fahrenheit);
    }
}
