package trackingorder;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private Vevo vevo;
    private List<Termek> termekek = new ArrayList<Termek>();
    private String futarUzenet;

    private DELIVER_MODE KezbesitesiMod;
    private DELIVER_STATUS statusz;
    private PAY_MODE fizetesimod;


    public Order(Vevo vevo, DELIVER_MODE kezbesitesiMod, PAY_MODE fizetesimod) {
        this.vevo = vevo;
        KezbesitesiMod = kezbesitesiMod;
        this.fizetesimod = fizetesimod;
    }

    public String getFutarUzenet() {
        return futarUzenet;
    }

    public void setFutarUzenet(String futarUzenet) {
        this.futarUzenet = futarUzenet;
    }

    public Vevo getVevo() {
        return vevo;
    }

    public void setVevo(Vevo vevo) {
        this.vevo = vevo;
    }

    public DELIVER_MODE getKezbesitesiMod() {
        return KezbesitesiMod;
    }

    public void setKezbesitesiMod(DELIVER_MODE kezbesitesiMod) {
        KezbesitesiMod = kezbesitesiMod;
    }

    public PAY_MODE getFizetesimod() {
        return fizetesimod;
    }

    public void setFizetesimod(PAY_MODE fizetesimod) {
        this.fizetesimod = fizetesimod;
    }

    public DELIVER_STATUS getStatusz() {
        return statusz;
    }

    public void setStatusz(DELIVER_STATUS statusz) {
        this.statusz = statusz;
    }
}
