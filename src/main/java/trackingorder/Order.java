package trackingorder;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private Customer customer;
    private List<OrderItem> termekek = new ArrayList<OrderItem>();
    private String futarUzenet;

    private DELIVER_MODE KezbesitesiMod;
    private DELIVER_STATUS statusz;
    private PAY_MODE fizetesimod;


    public Order(Customer customer, DELIVER_MODE kezbesitesiMod, PAY_MODE fizetesimod) {
        this.customer = customer;
        KezbesitesiMod = kezbesitesiMod;
        this.fizetesimod = fizetesimod;

        if ( fizetesimod == PAY_MODE.CASHE & kezbesitesiMod == DELIVER_MODE.INSHOP){
            statusz= DELIVER_STATUS.DELIVERED;
        }
    }

    public String getFutarUzenet() {
        return futarUzenet;
    }

    public void setFutarUzenet(String futarUzenet) {
        this.futarUzenet = futarUzenet;
    }

    public Customer getVevo() {
        return customer;
    }

    public void setVevo(Customer customer) {
        this.customer = customer;
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
