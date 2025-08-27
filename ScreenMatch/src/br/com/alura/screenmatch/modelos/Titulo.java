package br.com.alura.screenmatch.modelos;
import br.com.alura.screenmatch.modelos.excecao.ErroDeConversaoDeAnoException;
import com.google.gson.annotations.SerializedName;
import org.jetbrains.annotations.NotNull;

public class Titulo implements Comparable<Titulo>{
    private String nome;
    private int anoDeLancamento;
    private boolean incluidoNoPlano;
    private double somaDasAvaliacoes;
    private int totalDeAvaliacoes;
    private int duracaoEmMinutos;

    public Titulo(String nome, int anoDeLancamento) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
    }

    public Titulo(TituloOmdb meuTituloOmdn) {
        this.nome = meuTituloOmdn.title();

        if (meuTituloOmdn.year().length() > 4) {
            throw new ErroDeConversaoDeAnoException("Não foi possivel converter o ano pois tem mais de 4 caracteres.");
        }
        this.anoDeLancamento = Integer.valueOf(meuTituloOmdn.year());
        this.duracaoEmMinutos = Integer.valueOf(meuTituloOmdn.runtime().replaceAll(" min", ""));
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public boolean isIncluidoNoPlano() {
        return incluidoNoPlano;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public int getTotalDeAvaliacoes() {
        return totalDeAvaliacoes;
    }

    public void exibeFichaTecnica() {
        System.out.println("Nome do filme: " + nome);
        System.out.println("Ano de lançamento: " + anoDeLancamento);
    }

    public void avalia(double nota) {
        this.somaDasAvaliacoes += nota;
        this.totalDeAvaliacoes++;
    }

    public double pegaMedia() {
        if (totalDeAvaliacoes > 0) {
            return somaDasAvaliacoes / totalDeAvaliacoes;
        } else {
            return 0;
        }
    }

    @Override
    public int compareTo(@NotNull Titulo outro) {
        //Usar outro Titulo compareTo da String
        return this.getNome().compareTo(outro.getNome());
    }

    @Override
    public String toString() {
        return "(nome=" + nome +
                ", anoDeLancamento=" + anoDeLancamento +
                ", duração em minutos=" + duracaoEmMinutos + ")";
    }
}
