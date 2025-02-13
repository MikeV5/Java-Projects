package es1;
public class Prova {
public static final int maxCons = 5;
        public static void main(String[] args) {
            GestoreM g = new GestoreM();
            Produttore p = new Produttore(g);
            for (int i=0; i<maxCons; i++) {
                Consumatore c = new Consumatore(i,g);
                c.start();
            }
            p.start();
        }
}

