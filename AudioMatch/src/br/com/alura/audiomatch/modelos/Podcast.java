package br.com.alura.audiomatch.modelos;

public class Podcast extends Audio implements IResumivel {
    private String apresentador;
    private String descricao;

    public Podcast(String apresentador, String titulo, int duracaoEmMinutos, int classificacao) {
        super(titulo, duracaoEmMinutos, classificacao);
        this.apresentador = apresentador;
    }

    public String getApresentador() {
        return apresentador;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int getClassificacao() {
        if (this.getTotalDeCurtidas() > 500) {
            return 10;
        } else {
            return 7;
        }
    }

    @Override
    public String retornaResumo() {
        return """
                Apresentador: %s
                Titulo: %s
                Duraçao em minutos: %d min
                Classificação: %d
                Total de curtidas: %d
                Total de reprodução: %d
                """.formatted(
                    this.getApresentador(),
                    this.getTitulo(),
                    this.getDuracaoEmMinutos(),
                    this.getClassificacao(),
                    this.getTotalDeCurtidas(),
                    this.getTotalDeReproducao());
    }
}
