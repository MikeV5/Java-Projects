package esercizio1;

public interface ConsumatoreMsgInterface {
    void signUp(int id) throws GiaRegistrato;
    Msg receive(int id) throws InterruptedException,
            ConsumatoreSconosciuto;
}
