package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.comparadores.TituloPorAnoDeLancamento;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

import java.util.*;

public class PrincipalComListas {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("Jurassic Park", 1992);
        meuFilme.avalia(9);
        Filme outroFilme = new Filme("Avatar", 2023);
        meuFilme.avalia(6);
        var filmeDoPaulo = new Filme("Dogville", 2003);
        meuFilme.avalia(10);
        Serie lost = new Serie("Lost", 2000);

        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(filmeDoPaulo);
        lista.add(meuFilme);
        lista.add(outroFilme);
        lista.add(lost);

        for (Titulo item: lista) {
            System.out.println(item.getNome());
/*
            Forma Legada de ser feita (Pode ser feito o cast direto com instanceof e já pode ser usado para outras
            verificações
            if (item instanceof Filme filme && filme.getClassificacao() > 2) {
                System.out.println("Classificação " + filme.getClassificacao());
            }
*/
            if(item.getClass() == Filme.class) {
                System.out.println("Classificação " + ((Filme)item).getClassificacao());
            }
        }
        System.out.println(lista);

        List<String> buscaPorArtista = new LinkedList<>();
        buscaPorArtista.add("Adam Sandler");
        buscaPorArtista.add("Paulo");
        buscaPorArtista.add("Jacqueline");

        System.out.println(buscaPorArtista);

        Collections.sort(buscaPorArtista);

        System.out.println("Depois da ordenacao: " + buscaPorArtista);

        Collections.sort(lista);
        System.out.println("Lista de titulos ordenados por nome: " + lista);

        //Criar comparador por anoLancamento
        //Implementação criando class Comparador (Implementaçao Antiga)
        //TituloPorAnoDeLancamento comparador = new TituloPorAnoDeLancamento();
        //lista.sort(comparador);

        //Comparar usando recursos da propria lista com Comparator
        //Usando linguagem lambda
        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));

        System.out.println("Lista de titulos ordenados por ano de lancamento " + lista);
    }
}
