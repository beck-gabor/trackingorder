package trackingorder;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Cart {
    private HashMap<Integer,OrderItem> orderItems = new HashMap<>();
    private Customer customer;
    private WareHouse wh;

    public Cart( WareHouse wh, Customer customer) {
        this.customer = customer;
        this.wh = wh;
    }

    private OrderItem findOrderItemById(Integer id) throws CartError {

        if (!orderItems.containsKey(id))
            throw new CartError(  "Item not found in cart, ID:" + id  ,  CartErrorCode.ITEMNOTINCART ) ;

        return orderItems.get( id);
    }

    public void addOrderItem( Integer id, Integer darab ) throws CartError , WareHouseError {
        Stock s;
        if (orderItems.containsKey(id))
            throw new CartError( "Item found in cart, can not add, ID:" + id , CartErrorCode.ITEMALREADYINCART ) ;

        try {
            wh.foglal(id, darab);
            s = wh.getProdukt( id );

            orderItems.put(id, new OrderItem( id , s.getName() , s.getPrice() , darab  ) );

        }catch ( WareHouseError whe ){
        }
    }

    public void delOrderItem( Integer id) throws CartError{

        if (!orderItems.containsKey(id)){
            throw new CartError( "Item not found in cart, can not delete, ID:" + id , CartErrorCode.ITEMNOTFOUNDINCART ) ;
        }else{
            wh.felszabadit(id, findOrderItemById(id).getAmount());
            orderItems.remove(id);
        }

    }

    public Integer countCartItem(){
        return orderItems.size();
    }

    public Order createOrder(payMode payMode , deliveryMode deliveriMode ){
        Order order;

        Iterator<Map.Entry<Integer,OrderItem>> orderItemsIterator = orderItems.entrySet().iterator();
        while (orderItemsIterator.hasNext()) {
            Map.Entry<Integer, OrderItem> set = (Map.Entry<Integer, OrderItem>) orderItemsIterator.next();

            // Amit lefoglaltam felszabadítom és rögtönk csökkentem is vele a raktár készletet.
            wh.felszabadit( set.getValue().getId() , set.getValue().getAmount() );
            wh.minusKeszlet( set.getValue().getId() , set.getValue().getAmount() );
        }


        if( deliveriMode == deliveryMode.INSHOP ){
            order = new OrderInShop( orderItems , customer , payMode );
        }else{
            order = new OrderOnLine( orderItems , customer, deliveriMode, payMode);
        }

        return order;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "Items count=" + countCartItem() +
                ", customer =" + customer.getNev() +
                '}';
    }
}
