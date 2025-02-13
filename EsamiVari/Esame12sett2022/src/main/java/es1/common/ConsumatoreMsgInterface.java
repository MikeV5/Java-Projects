package es1.common;

import es1.Msg;
import es1.eccezioni.ConsumatoreSconosciuto;
import es1.eccezioni.GiaRegistrato;

public interface ConsumatoreMsgInterface {
    void signUp(int id) throws GiaRegistrato;
    Msg receive(int id) throws InterruptedException, ConsumatoreSconosciuto;
}
