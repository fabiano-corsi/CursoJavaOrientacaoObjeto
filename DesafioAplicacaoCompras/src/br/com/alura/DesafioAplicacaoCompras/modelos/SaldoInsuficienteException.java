package br.com.alura.DesafioAplicacaoCompras.modelos;

public class SaldoInsuficienteException extends Exception {
    public SaldoInsuficienteException(String message) {
        super(message);
    }
}
