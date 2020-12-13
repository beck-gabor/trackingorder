package trackingorder;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private Customer customer;
    private List<OrderItem> termekek = new ArrayList<>();
    private PAY_MODE fizetesimod;
    private DELIVER_MODE kezbesitesiMod;


    public Order(Customer customer, DELIVER_MODE kezbesitesiMod, PAY_MODE fizetesimod) {
        this.customer = customer;
        kezbesitesiMod = kezbesitesiMod;
        this.fizetesimod = fizetesimod;

    }

    public Customer getVevo() {
        return customer;
    }

    public void setVevo(Customer customer) {
        this.customer = customer;
    }

    public DELIVER_MODE getKezbesitesiMod() {
        return kezbesitesiMod;
    }

    public void setKezbesitesiMod(DELIVER_MODE kezbesitesiMod) {
        kezbesitesiMod = kezbesitesiMod;
    }

    public PAY_MODE getFizetesimod() {
        return fizetesimod;
    }

    public void setFizetesimod(PAY_MODE fizetesimod) {
        this.fizetesimod = fizetesimod;
    }

}
