package es1.eccezioni;

import es1.Msg;

public class DestinatarioPieno extends Exception {
    public int dest;
    public DestinatarioPieno(int dest) {
    this.dest=dest;
    }
}
