import br.com.alura.screenmatch.calculos.CalculadoraDeTempo;
import br.com.alura.screenmatch.calculos.FiltroRecomendacao;
import br.com.alura.screenmatch.modelos.Episodio;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("O Poderoso Chefão", 1970);
        meuFilme.setDuracaoEmMinutos(180);

        meuFilme.exibeFichaTecnica();
        meuFilme.avalia(9);
        meuFilme.avalia(6);
        meuFilme.avalia(10);
        meuFilme.avalia(5);
        System.out.println("Total de avaliações: " + meuFilme.getTotalDeAvaliacoes());
        System.out.println(meuFilme.pegaMedia());

        Serie lost = new Serie("Lost", 2000);
        lost.exibeFichaTecnica();
        lost.setTemporadas(10);
        lost.setEpisodiosPorTemporada(10);
        lost.setMinutosPorEpisodio(50);

        System.out.println("A duração para maratonar Lost é: " + lost.getDuracaoEmMinutos());

        Filme outroFilme = new Filme("Avatar", 2021);
        outroFilme.setDuracaoEmMinutos(200);

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(meuFilme);
        calculadora.inclui(outroFilme);
        calculadora.inclui(lost);
        System.out.println(calculadora.getTempoTotal());


        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtra(meuFilme);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(lost);
        episodio.setTotalVisualizacoes(250);
        filtro.filtra(episodio);


        var filmeDoWagner = new Filme("A família Belier", 2020);
        // filmeDoWagner.setNome();
        filmeDoWagner.setDuracaoEmMinutos(120);
        filmeDoWagner.avalia(10);

        ArrayList<Filme> listaDeFilme = new ArrayList<>();
        listaDeFilme.add(filmeDoWagner);
        listaDeFilme.add(meuFilme);
        listaDeFilme.add(outroFilme);
        System.out.println("Tamamho da lista: " + listaDeFilme.size());
        System.out.println("Primeiro Filme: " + listaDeFilme.get(0).getNome());
        System.out.println(listaDeFilme);

    }
}