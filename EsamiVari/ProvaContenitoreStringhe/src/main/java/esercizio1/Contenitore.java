package esercizio1;

interface Contenitore {
    int inserisci(String s) throws Pieno;
    String recupera(int n) throws Inesistente;
    void cancella(int n) throws Inesistente;
}
