package br.com.alura.screenmatch.comparadores;

import br.com.alura.screenmatch.modelos.Titulo;

import java.util.Comparator;

public class TituloPorAnoDeLancamento implements Comparator<Titulo> {
    public int compare(Titulo titulo, Titulo outroTitulo) {
        return titulo.getAnoDeLancamento() - outroTitulo.getAnoDeLancamento();
    }
}
