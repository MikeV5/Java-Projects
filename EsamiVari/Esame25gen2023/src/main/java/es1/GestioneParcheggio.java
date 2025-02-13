package es1;

public interface GestioneParcheggio {
    void ingresso();
    void uscita();
    void parcheggia(int piano) throws StalliNonLiberi, PianoInesistente;
    void partenza(int piano) throws PianoInesistente;
     int postiLiberi();
    int stalliLiberi(int piano) throws PianoInesistente;
}
