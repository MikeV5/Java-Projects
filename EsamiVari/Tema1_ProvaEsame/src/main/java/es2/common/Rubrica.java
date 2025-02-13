package es2.common;

import es1.GiaPresente;
import es1.NomeNonEsistente;
import java.io.IOException;

public interface Rubrica {
    void aggiungiNumero(String nome, String num) throws GiaPresente, IOException;
    void eliminaNumero(String nome) throws NomeNonEsistente, IOException;
    boolean inRubrica(String nome) throws IOException;
    String trova(String nome) throws InterruptedException, IOException;
}
