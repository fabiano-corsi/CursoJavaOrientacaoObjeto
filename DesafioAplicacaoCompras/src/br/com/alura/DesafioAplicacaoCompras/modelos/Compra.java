package br.com.alura.DesafioAplicacaoCompras.modelos;

public class Compra implements Comparable<Compra>{
    private double valor;
    private String descricao;

    public Compra(double valor, String descricao) {
        this.valor = valor;
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public int compareTo(Compra outroCompra) {
        return (int)(this.getValor() - outroCompra.getValor());
    }

    @Override
    public String toString() {
        return "%s - R$%.2f".formatted(this.getDescricao(), this.getValor());
    }
}
