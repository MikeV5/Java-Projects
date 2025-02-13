package esercizio2;

import java.io.Serializable;

public class Msg implements Serializable {
    static final long serialVersionUID = 1L;
    public int dest;
    public String txt;
    public Msg(int t, String tt) {
        dest = t;
        txt = tt;
    }
}
