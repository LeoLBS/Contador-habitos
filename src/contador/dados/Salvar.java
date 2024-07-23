package contador.dados;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Salvar {

    public void salvarContadores(String dadosContador, String nomeArquivo){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true))){
            writer.write(dadosContador);
            writer.newLine();
            System.out.println("Salvou!");
        }catch (IOException e){
            System.out.println("Verifique se o arquvio esta certo!!" + e);
        }
    }
}
