package trackingorder;

import java.util.HashMap;
import java.util.Map;

import java.util.Iterator;
import java.util.Map.Entry;


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

    public Integer countOrderItem(){
        return orderItems.size();
    }

    public double getOrderFullPrice(){
        Double price = 0.0;

        Iterator<Entry<Integer,OrderItem>> orderItemsIterator = orderItems.entrySet().iterator();
        while (orderItemsIterator.hasNext()) {
            Map.Entry<Integer, OrderItem> set = (Map.Entry<Integer, OrderItem>) orderItemsIterator.next();
            price += set.getValue().getFullPrice();
        }

        return price;
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

    public void setStatusz(DELIVER_STATUS statusz) {
        this.statusz = statusz;
    }
}
