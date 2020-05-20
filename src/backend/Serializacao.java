package backend;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Bruno Ferreira (bruno@dsi.uminho.pt)
 */
public class Serializacao {

    private final File ficheiro;

    public Serializacao(String ficheiro) {
        this.ficheiro = new File(ficheiro);
    }

    public File getFicheiro() {
        return ficheiro;
    }

    //Carrega/lê o sistema de ficheiro
    public Aplicacao carregar() {
        try (FileInputStream fileIn = new FileInputStream(ficheiro);
                ObjectInputStream in = new ObjectInputStream(fileIn)) {
            Aplicacao aplicacao = (Aplicacao) in.readObject();
            return aplicacao;
        } catch (FileNotFoundException ex) {
            guardar(new Aplicacao());
            return carregar();
        } catch (IOException | ClassNotFoundException ex) {
            throw new RuntimeException(String.format(
                    "Ocorreu um erro ao ler o ficheiro de dados: %s",
                    ex.getLocalizedMessage()), ex);
        }
    }

    //Guarda o sistema em ficheiro
    public void guardar(Aplicacao sistema) {
        try (FileOutputStream fileOut = new FileOutputStream(ficheiro);
                ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            try {
                out.writeObject(sistema);
            } catch (IOException ex) {
                throw new RuntimeException(String.format(
                        "Ocorreu um erro ao guardar o ficheiro de dados: %s",
                        ex.getLocalizedMessage()), ex);
            }
        } catch (IOException ex) {
            throw new RuntimeException(String.format(
                    "Ocorreu um erro ao guardar o ficheiro de dados: %s",
                    ex.getLocalizedMessage()), ex);
        }
    }

}
