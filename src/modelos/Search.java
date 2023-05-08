package modelos;

import java.io.IOException;
import java.util.Scanner;

public class Search extends Guia {

    public void consult() throws IOException, InterruptedException {
        Scanner read = new Scanner(System.in);
        String cep = "";

        while (!cep.equalsIgnoreCase("sair")) {
            System.out.println("Digite um CEP:  ");
            cep = read.nextLine();
            if (cep.equalsIgnoreCase("sair")) {
                break;
            }
            andress(cep);

        }

    }

}