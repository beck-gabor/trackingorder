package trackingorder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderInShopTest {
    private Cart c;
    private OrderInShop order;

    @BeforeEach
    void setUp() {
        c = new Cart( new Customer( "Cim" , "'Telefon" , "nev", "email") );
        c.addOrderItem( new OrderItem( 1 , "TermékNév" , 10.0 , 1 ) );

        order = (OrderInShop) c.createOrder( PAY_MODE.BANKCARD , DELIVER_MODE.INSHOP );
    }

    @Test
    void getStatusz() {
        assertEquals( DELIVER_STATUS.DELIVERED, order.getStatusz(),
                "OrderInShop:getStatusz - A státusz nem megfelelő" );
    }

}