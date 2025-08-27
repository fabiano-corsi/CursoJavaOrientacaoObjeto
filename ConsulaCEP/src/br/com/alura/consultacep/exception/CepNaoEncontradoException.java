package br.com.alura.consultacep.exception;

public class CepNaoEncontradoException extends Exception {
    public CepNaoEncontradoException(String message) {
        super(message);
    }
}
