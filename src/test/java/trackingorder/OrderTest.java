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
        assertEquals( order.countOrderItem() , 1 ,
                "Order:countOrderItem - A kosár elemeinek száma eltér " );
    }

    @Test
    void getOrderFullPrice() {
        assertEquals( order.getOrderFullPrice() , 12.5 ,
                "Order:getOrderFullPrice - A kosár elemeinek értéke eltér " );
    }

    @Test
    void getVevo() {

        assertEquals( order.getVevo() , customer,
                "Order:getVevo - A tárolt vevő nem azonos" );

    }

    @Test
    void getKezbesitesiMod() {
        assertEquals( order.getKezbesitesiMod() , DELIVER_MODE.INSHOP,
                "Order:getKezbesitesiMod - A tárolt kézbesítési mód nem azonos" );
    }

    @Test
    void getFizetesimod() {
        assertEquals( order.getFizetesimod() , PAY_MODE.BANKCARD,
                "Order:getFizetesimod - A tárolt fizetési mód nem azonos" );
    }

    @Test
    void getStatusz() {
        assertEquals( order.getStatusz() , DELIVER_STATUS.BOOKED,
                "Order:getStatusz - A tárolt státusz nem azonos" );
    }
}