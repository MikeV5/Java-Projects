package esercizio1;

import java.util.LinkedList;
import java.util.List;

public class NastroImpl implements Nastro{

    private LinkedList<String> nastro;
    private int posCorrente;
    public NastroImpl() {
        nastro = new LinkedList<String>();
        posCorrente = 0;
    }

    @Override
    public synchronized void write(String s) throws noWrite {
        //if(!nastro.get(posCorrente).isEmpty()) throw new noWrite();
        if(nastro.size() > posCorrente)  throw new noWrite();
        nastro.addLast(s);
        posCorrente++;
    }

    @Override
    public synchronized String read() throws noRead {
        if(nastro.size() == posCorrente) throw new noRead();
        return nastro.get(posCorrente++);
    }

    @Override
    public synchronized void rewind() {
        posCorrente = 0;
    }

    @Override
    public synchronized boolean empty() {
        return nastro.isEmpty();
    }
}
