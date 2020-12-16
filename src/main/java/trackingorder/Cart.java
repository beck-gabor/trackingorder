package trackingorder;

import java.util.HashMap;

public class Cart {
    private HashMap<Integer,OrderItem> orderItems = new HashMap<>();
    private Customer customer;

    public Cart(Customer customer) {
        this.customer = customer;
    }

    private OrderItem findOrderItemById(Integer id) throws CartError {

        if (!orderItems.containsKey(id))
            throw new CartError(  "Item not found in cart, ID:" + id  ,  CartErrorCode.ITEMNOTINCART ) ;

        return orderItems.get( id);
    }

    public void addOrderItem( OrderItem orderItem) throws CartError{

        if (orderItems.containsKey(orderItem.getId()))
            throw new CartError( "Item found in cart, can not add, ID:" + orderItem.getId() , CartErrorCode.ITEMALREADYINCART ) ;

        orderItems.put(orderItem.getId(),orderItem);
    }

    public void delOrderItem( Integer id) throws CartError{

        if (!orderItems.containsKey(id)){
            throw new CartError( "Item not found in cart, can not delete, ID:" + id , CartErrorCode.ITEMNOTFOUNDINCART ) ;
        }else{
            orderItems.remove(id);
        }

    }

    public Integer countCartItem(){
        return orderItems.size();
    }


    public Order createOrder( PAY_MODE payMode , DELIVER_MODE deliveriMode ){
        Order order;

        if( deliveriMode == DELIVER_MODE.INSHOP ){
            order = new OrderInShop( orderItems , customer , payMode );
        }else{
            order = new OrderOnLine( orderItems , customer, deliveriMode, payMode);
        }

        return order;
    }


}
