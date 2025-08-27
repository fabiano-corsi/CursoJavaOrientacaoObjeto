package br.com.alura.audiomatch.modelos;

public class Audio {
    private int duracaoEmMinutos;
    private String titulo;
    private int totalDeReproducao;
    private int curtidas;
    private int classificacao;

    public Audio(String titulo, int duracaoEmMinutos, int classificacao) {
        this.duracaoEmMinutos = duracaoEmMinutos;
        this.titulo = titulo;
        this.classificacao = classificacao;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getTotalDeReproducao() {
        return totalDeReproducao;
    }

    public int getTotalDeCurtidas() {
        return curtidas;
    }

    public int getClassificacao() {
        return classificacao;
    }

    public void curtir() {
        this.curtidas++;
    }

    public void reproduz() {
        this.totalDeReproducao++;
    }

    @Override
    public String toString() {
        return this.titulo;
    }
}
