package modelos;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Guia {

    private String search;
    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    static List<Guia> listGuia = new ArrayList<>();

    public Guia(ViaCep viaCep) {
        this.cep = viaCep.cep();
        this.bairro = viaCep.bairro();
        this.localidade = viaCep.localidade();
        this.logradouro = viaCep.logradouro();

    }

    public Guia() {
        // construtor padrão sem argumentos
    }

    public void andress(String search) throws IOException, InterruptedException {
        this.search = search;
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_DOTS).setPrettyPrinting()
                .create();

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://viacep.com.br/ws/" + search + "/json/"))
                .build();

        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String json = response.body();

        ViaCep viaCep = gson.fromJson(json, ViaCep.class);

        listGuia.add(new Guia(viaCep));
    }

    @Override
    public String toString() {
        return "CEP: " + this.cep + "  Logradouro:  " + this.logradouro + "  Bairro: " + this.bairro + "  Localidade: "
                + this.localidade;
    }

    public static List<Guia> getListGuia() {
        return listGuia;
    }

}
