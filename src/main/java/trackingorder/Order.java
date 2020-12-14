package trackingorder;

import java.util.HashMap;

public class Order {
    private Customer customer;
    private HashMap<Integer,OrderItem> orderItems  = new HashMap<>();

    private PAY_MODE fizetesimod;
    private DELIVER_MODE kezbesitesiMod;
    private DELIVER_STATUS statusz;


    public Order(HashMap<Integer,OrderItem> orderItems, Customer customer, DELIVER_MODE kezbesitesiMod, PAY_MODE fizetesimod) {
        this.orderItems = orderItems;
        this.customer = customer;
        this.kezbesitesiMod = kezbesitesiMod;
        this.fizetesimod = fizetesimod;
        this.statusz = DELIVER_STATUS.BOOKED;
    }

    public Customer getVevo() {
        return customer;
    }

    public DELIVER_MODE getKezbesitesiMod() {
        return kezbesitesiMod;
    }

    public PAY_MODE getFizetesimod() {
        return fizetesimod;
    }

    public DELIVER_STATUS getStatusz() {
        return statusz;
    }
}
