package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

import java.util.ArrayList;

public class PrincipalComListas {

    public static void main(String[] args) {
        Serie lost = new Serie("Lost", 2000);
        Filme outroFilme = new Filme("Avatar", 2021);
        outroFilme.avalia(9);
        Filme meuFilme = new Filme("O Poderoso Chefão", 1970);
        meuFilme.avalia(6);
        var filmeDoWagner = new Filme("A Família Belier", 2020);
        filmeDoWagner.avalia(10);



        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(filmeDoWagner);
        lista.add(meuFilme);
        lista.add(outroFilme);
        lista.add(lost);
        for (Titulo item: lista) {
            System.out.println(item.getNome());
            if(item instanceof Filme filme && filme.getClassificacao()>2){
                System.out.println("Classificação: " + filme.getClassificacao());
            }



            
        }

    }
}
