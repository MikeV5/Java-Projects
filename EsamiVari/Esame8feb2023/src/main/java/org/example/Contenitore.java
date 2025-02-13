package org.example;

public interface Contenitore {
        //Contenitore
    void inserisci(int num) throws InterruptedException;

    int somma() throws InterruptedException;
    void cancella() throws SommaNonCalcolata;
}
