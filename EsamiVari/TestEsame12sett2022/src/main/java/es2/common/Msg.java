package es2.common;

import java.io.Serializable;

public class Msg implements Serializable {
    //Serve a garantire che le versioni serializzate e deserializzate
    //siano compatibili
    private static final long serialVersionUID = 1L; //identifica in modo univoco la struttura della classe
    public int dest;
    public String txt;
    public Msg(int t, String tt) {
        this.dest = t;
        this.txt = tt;
    }
}

