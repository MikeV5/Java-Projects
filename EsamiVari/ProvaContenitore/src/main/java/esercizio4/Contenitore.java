package esercizio4;
public interface Contenitore {
    void inserisci(int num);
    int somma();
    void cancella() throws SommanNonFatta;
}
