package br.com.alura.audiomatch.modelos;

public class MinhasPreferidas {
    public void inclui(Audio audio) {
        if (audio.getClassificacao() >= 9) {
            System.out.println("%s é considerado sucesso absoluto e preferido por todos".formatted(audio.getTitulo()));

        } else {
            System.out.println("%s tambem é um dos titulos que todo mundo está curtindo".formatted(audio.getTitulo()));
        }
    }
}
