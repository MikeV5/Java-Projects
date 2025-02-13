package org.example;

public class App{
    public static final int dim = 8;
    public static final int numThread = 3;
    public static void main( String[] args ) throws InterruptedException {
        Contenitore c = new ContenitoreImpl(dim);
        for (int i = 1; i <= numThread; i++) {
            Utente u = new Utente(i,c);
            u.start();
            Thread.sleep(500);
        }
    }
}
//Devono esserci 27 iterazioni(ciclo da 0 a 26=(9*3thread))
//Si può verificare deadlock quando un utente prova ad inserire il nono num nel contenitore
//e invece haa dim max 8
//Nel migliore nei casi per non verificarsi il deadlock un utente dovrebbe
//eseguire il metodo cancello() cosi' il contenitore si azzerà e non blocca l'utente.