package br.com.alura.DesafioAplicacaoCompras.modelos;

import java.util.ArrayList;
import java.util.List;

public class CartaoDeCredito {
    private double limiteCartao;
    private double saldo;
    private List<Compra> listaDeCompras;


    public CartaoDeCredito(double limiteCartao) {
        this.limiteCartao = limiteCartao;
        this.saldo = limiteCartao;
        listaDeCompras = new ArrayList<>();
    }

    public double getLimiteCartao() {

        return limiteCartao;
    }

    public double getSaldo() {
        return saldo;
    }

    public void comprar(Compra compra) throws SaldoInsuficienteException {
        if (compra.getValor() > this.getSaldo()) {
            throw new SaldoInsuficienteException("Saldo insuficiente para realizar essa compra.");
        } else {
            this.listaDeCompras.add(compra);
            saldo -= compra.getValor();
        }
    }

    public List<Compra> getListaDeCompras() {
        return this.listaDeCompras;
    }
}
