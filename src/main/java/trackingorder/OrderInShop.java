package trackingorder;

import java.util.HashMap;

public class OrderInShop extends Order {


    public OrderInShop(HashMap<Integer, OrderItem> orderItems, Customer customer, payMode payMode) {
        super(orderItems, customer, deliveryMode.INSHOP, payMode);
    }

    @Override
    public deliveryStatus getStatusz() {
        return deliveryStatus.DELIVERED;
    }

}