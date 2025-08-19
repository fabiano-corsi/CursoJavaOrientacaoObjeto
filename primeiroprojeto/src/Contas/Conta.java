package Contas;

public class Conta {

    public Conta(String nomeCliente, TipoConta tipoConta, double saldoInicial) {
        this.nomeCliente = nomeCliente;
        this.tipoConta = tipoConta;
        this.saldo = saldoInicial;
    }

    private String nomeCliente;
    private TipoConta tipoConta;
    private double saldo;

    public String getNomeCliente() {
        return nomeCliente;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public double depositar(double valor) {
        if (valor < 0) {
            valor *= -1;
        }

        this.saldo += valor;
        return  this.saldo;
    }

    public double sacar(double valor) throws SemSaldoSuficienteException {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            return  this.saldo;
        }
        else {
            throw new SemSaldoSuficienteException("Não é possivel sacar o valor %.2f, sem saldo suficiente na conta".formatted(valor));
        }
    }
}
