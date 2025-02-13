package es1;

public interface Contenitore {
    void inserisci(int d) throws InterruptedException;
    int somma() throws InterruptedException;
    void cancella() throws SommaNonCalcolata;
}

