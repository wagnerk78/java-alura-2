package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.excecao.ErroConversaodeAno;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        String busca = " ";
        List<Titulo> titulos = new ArrayList<>();
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();

        while (!(busca.equalsIgnoreCase("sair"))) {

            System.out.println("Digite um filme para busca: ");
            busca = leitura.nextLine();

                if ((busca.equalsIgnoreCase("sair"))){
                    break;
                }

            String endereco = "http://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=2d7286ca";

            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereco))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();
                System.out.println(json);



               TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
                //System.out.println(meuTituloOmdb);
                //try {
                Titulo meuTitulo = new Titulo(meuTituloOmdb);
                //System.out.println("Título já convertido: ");
                //System.out.println(meuTitulo);

                titulos.add(meuTitulo);

            } catch (NumberFormatException e) {
                System.out.println("Aconteceu um erro: ");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Algum erro no argumento da busca. Verifique a plavra digitada");
            } catch (ErroConversaodeAno e) {
                System.out.println(e.getMessage());
            }
        }
        FileWriter escrita = new FileWriter("newfilmesa.json");
        escrita.write(gson.toJson(titulos));
        escrita.close();
        System.out.println("O programa terminou!");
    }
}
