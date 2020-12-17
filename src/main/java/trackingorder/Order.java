package trackingorder;

import java.util.HashMap;
import java.util.Map;

import java.util.Iterator;
import java.util.Map.Entry;


public class Order {
    private final Customer customer;
    private HashMap<Integer,OrderItem> orderItems  = new HashMap<>();

    private final payMode fizetesimod;
    private final deliveryMode kezbesitesiMod;
    private deliveryStatus statusz;


    public Order(HashMap<Integer,OrderItem> orderItems, Customer customer, deliveryMode kezbesitesiMod, payMode fizetesimod) {
        this.orderItems = orderItems;
        this.customer = customer;
        this.kezbesitesiMod = kezbesitesiMod;
        this.fizetesimod = fizetesimod;
        this.statusz = deliveryStatus.BOOKED;
    }

    public Integer countOrderItem(){
        return orderItems.size();
    }

    public Double getOrderFullPrice(){
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

    public deliveryMode getKezbesitesiMod() {
        return kezbesitesiMod;
    }

    public payMode getFizetesimod() {
        return fizetesimod;
    }

    public deliveryStatus getStatusz() {
        return statusz;
    }

    public void setStatusz(deliveryStatus statusz) {
        this.statusz = statusz;
    }

    @Override
    public String toString() {
        return "Order{" +
                "customer=" + getVevo().getNev()  +
                ", ItemsCount=" + countOrderItem()+
                ", FullPrice =" + getOrderFullPrice() +
                ", fizetesimod=" + getFizetesimod() +
                ", kezbesitesiMod=" + getKezbesitesiMod() +
                ", statusz=" + getStatusz() +
                '}';
    }
}
