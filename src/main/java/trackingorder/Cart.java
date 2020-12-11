package trackingorder;

import java.util.HashMap;

public class Cart {
    private HashMap<Integer,OrderItem> orderItems = new HashMap<>();

    private OrderItem findOrderItemById(Integer id){

        if (!orderItems.containsKey(id))
            throw new CartError(  "Item not found in cart, ID:" + id  ,  CartErrorCode.ITEMNOTINCART ) ;

        return orderItems.get( id);
    }

    public void addOrderItem( OrderItem orderItem){

        if (orderItems.containsKey(orderItem.getId()))
            throw new CartError( "Item found in cart, can not add, ID:" + orderItem.getId() , CartErrorCode.ITEMALREADYINCART ) ;

        orderItems.put(orderItem.getId(),orderItem);
    }

    public void delOrderItem( OrderItem orderItem){

        if (!orderItems.containsKey(orderItem.getId())){
            throw new CartError( "Item not found in cart, can not delete, ID:" + orderItem.getId() , CartErrorCode.ITEMNOTFOUNDINCART ) ;
        }else{
            orderItems.remove(orderItem.getId());
        }

    }

    public void createOnLineOrder(){

    }

    public void createInShopOrder(){

    }

}
