package trackingorder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderItemTest {
    private OrderItem o;

    @BeforeEach
    void setUp() {
        o = new OrderItem( new Product( 1,"Name", 100.0) , 10 );
        assertEquals (10 , o.getAmount() ,
                "Orderitem:getAmount érték hibás." );
    }

    @Test
    void getFullPrice(){
        assertEquals (1250.0 , o.getFullPrice() ,
                "Orderitem:getFullPrice érték hibás." );
    }
}