package Contas;

public class SemSaldoSuficienteException extends Exception {
    public SemSaldoSuficienteException(String message) {
        super(message);
    }
}
