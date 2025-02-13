package esercizio1;

public interface Contenitore {
    int inserisci(String s) throws Pieno, InterruptedException;
    String recupera(int n) throws Inesistente;
    void cancella(int n) throws Inesistente;
}
