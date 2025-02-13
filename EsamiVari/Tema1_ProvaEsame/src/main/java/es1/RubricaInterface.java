package es1;

public interface RubricaInterface {
    void aggiungiNumero(String nome, String num) throws GiaPresente;
    void eliminaNumero(String nome) throws NomeNonEsistente;
    boolean inRubrica(String nome);
    String trova(String nome) throws InterruptedException;

}
