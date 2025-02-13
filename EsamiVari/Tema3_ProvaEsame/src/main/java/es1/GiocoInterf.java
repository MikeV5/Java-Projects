package es1;

public interface GiocoInterf {
    void gioca(int id, String mossa);
    boolean partitaFinita();
    int aChiTocca();
    int vincitore();

}
