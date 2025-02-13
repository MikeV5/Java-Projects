package es1.common;

import es1.Msg;
import es1.eccezioni.DestinatarioPieno;

public interface ProduttoreMsgInterface {
    void send(Msg m) throws DestinatarioPieno;
}
