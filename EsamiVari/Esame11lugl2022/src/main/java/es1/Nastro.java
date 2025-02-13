package es1;

public interface Nastro {
    void write(String s) throws noWrite;
    String read() throws noRead;
    void rewind();
    boolean empty();

    int getCurrentPosition();
}
