package br.com.alura.audiomatch.principal;

import br.com.alura.audiomatch.modelos.IResumivel;
import br.com.alura.audiomatch.modelos.MinhasPreferidas;
import br.com.alura.audiomatch.modelos.Musica;
import br.com.alura.audiomatch.modelos.Podcast;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        var musicas = criarMusicas();
        var podcasts = criarPodcast();

        System.out.println("""
                ***************************************************************************************
                **APRESENTANDO MUSICAS
                ***************************************************************************************""");
        for (IResumivel resumivel: musicas) {
            System.out.println("""
                --------------------------------------
                %s""".formatted(resumivel.retornaResumo()));
        }

        System.out.println("""
                ***************************************************************************************
                **APRESENTANDO PodCasts
                ***************************************************************************************""");
        for (IResumivel resumivel: podcasts) {
            System.out.println("""
                --------------------------------------
                %s""".formatted(resumivel.retornaResumo()));
        }

        MinhasPreferidas preferidas = new MinhasPreferidas();
        preferidas.inclui(musicas.getFirst());
        preferidas.inclui(podcasts.getFirst());

    }

    private static ArrayList<Musica> criarMusicas() {
        ArrayList<Musica> musicaArrayList = new ArrayList<Musica>();

        //Criar musicas e classificar
        Musica dontCry = new Musica("Dont Cry", "Use your illusion",
                "Guns n Roses",
                "Rock",
                5,
                10);

        for (int i = 0; i < 1000; i++) {
            dontCry.curtir();
            dontCry.reproduz();
        }

        //Criar musicas e classificar
        Musica one = new Musica("One", "And Justice for all",
                "Metallica",
                "Rock",
                9,
                10);

        for (int i = 0; i < 900; i++) {
            one.curtir();
            one.reproduz();
        }

        musicaArrayList.add(dontCry);
        musicaArrayList.add(one);

        return musicaArrayList;
    }

    private static ArrayList<Podcast> criarPodcast() {
        ArrayList<Podcast> podcastArrayList = new ArrayList<Podcast>();

        //Criar musicas e classificar
        Podcast peewee1 = new Podcast("Peewee", "Melhores adaptações de jogos",
                75,
                10);

        for (int i = 0; i < 9352; i++) {
            peewee1.curtir();
            peewee1.reproduz();
        }

        //Criar musicas e classificar
        Podcast peewee2 = new Podcast("Peewee", "Piores filmes de 2024",
                54,
                10);

        for (int i = 0; i < 5420; i++) {
            peewee2.curtir();
            peewee2.reproduz();
        }

        podcastArrayList.add(peewee1);
        podcastArrayList.add(peewee2);

        return podcastArrayList;
    }
}