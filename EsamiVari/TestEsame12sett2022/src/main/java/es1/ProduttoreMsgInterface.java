package es1;

public interface ProduttoreMsgInterface {
    void send(Msg m) throws DestinatarioPieno;
}
