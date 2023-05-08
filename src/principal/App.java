package principal;

import java.io.IOException;
import java.util.List;

import modelos.Guia;
import modelos.Search;

public class App {
    public static void main(String[] args) throws IOException, InterruptedException {
        Search search = new Search();
        search.consult();
        List<Guia> listaGuia = Guia.getListGuia();
        for (Guia guia : listaGuia) {
            System.out.println(guia);
        }

    }

}
