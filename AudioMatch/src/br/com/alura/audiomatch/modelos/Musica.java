package br.com.alura.audiomatch.modelos;

public class Musica extends Audio implements IResumivel {
    private String album;
    private String cantor;
    private String genero;

    public Musica(String titulo, String album, String cantor, String genero, int duracaoEmMinutos, int classificacao) {
        super(titulo, duracaoEmMinutos, classificacao);
        this.album = album;
        this.cantor = cantor;
        this.genero = genero;
    }

    public String getAlbum() {
        return album;
    }

    public String getCantor() {
        return cantor;
    }

    public String getGenero() {
        return genero;
    }

    @Override
    public int getClassificacao() {
        if (this.getTotalDeReproducao() > 2000) {
            return 10;
        } else {
            return 8;
        }
    }

    @Override
    public String retornaResumo() {
        return """
                Titulo: %s
                Album: %s
                Cantor: %s
                Genero: %s
                Duraçao em minutos: %d min
                Classificação: %d
                Total de curtidas: %d
                Total de reprodução: %d
                """.formatted(
                        this.getTitulo(),
                        this.getAlbum(),
                        this.getCantor(),
                        this.getGenero(),
                        this.getDuracaoEmMinutos(),
                        this.getClassificacao(),
                        this.getTotalDeCurtidas(),
                        this.getTotalDeReproducao());
    }
}
