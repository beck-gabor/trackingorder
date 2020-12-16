package trackingorder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    private Order order;
    private Customer customer = new Customer( "Lacím" , "Telefonszám" , "VevőNeve" ,"Email@cim.hu" );;
    private HashMap<Integer,OrderItem> orderItems  = new HashMap<>();

    @BeforeEach
    void setUp() {
        orderItems.put( 1 , new OrderItem( 1, "ElemNeve" , 10.0 , 1) );
        order = new Order( orderItems, customer, DELIVER_MODE.INSHOP, PAY_MODE.BANKCARD );
    }

    @Test
    void countOrderItem() {
        assertEquals(1 ,order.countOrderItem() ,
                "Order:countOrderItem - A kosár elemeinek száma eltér " );
    }

    @Test
    void getOrderFullPrice() {
        assertEquals(12.5 , order.getOrderFullPrice() ,
                "Order:getOrderFullPrice - A kosár elemeinek értéke eltér " );
    }

    @Test
    void getVevo() {
        assertEquals(customer, order.getVevo() ,
                "Order:getVevo - A tárolt vevő nem azonos" );
    }

    @Test
    void getKezbesitesiMod() {
        assertEquals(DELIVER_MODE.INSHOP, order.getKezbesitesiMod() ,
                "Order:getKezbesitesiMod - A tárolt kézbesítési mód nem azonos" );
    }

    @Test
    void getFizetesimod() {
        assertEquals(PAY_MODE.BANKCARD, order.getFizetesimod() ,
                "Order:getFizetesimod - A tárolt fizetési mód nem azonos" );
    }

    @Test
    void setStatusz() {
        order.setStatusz(DELIVER_STATUS.BOOKED);
        assertEquals( DELIVER_STATUS.BOOKED, order.getStatusz(),
                "Order:setStatusz - A tárolt státusz nem azonos" );
    }
}