package esercizio2;

import esercizio1.Inesistente;


public interface Contenitore {
    int inserisci(String s) throws InterruptedException;
    String recupera(int n) throws Inesistente;
    void cancella(int n) throws Inesistente;
}
