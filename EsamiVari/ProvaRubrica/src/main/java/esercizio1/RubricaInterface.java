package esercizio1;

public interface RubricaInterface {
    void aggiungiNumero(String nome, String num) throws GiaPresente;
    void eliminaNumero(String nome) throws Inesistente;
    boolean inRubrica(String nome) throws Inesistente;
    String trova(String nome) throws Inesistente;
}
