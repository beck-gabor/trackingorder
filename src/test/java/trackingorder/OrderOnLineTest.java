package trackingorder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class OrderOnLineTest {
    private Cart c;
    private OrderOnLine order;

    @BeforeEach
    void setUp() {
        c = new Cart( new Customer( "Cim" , "'Telefon" , "nev", "email") );
        c.addOrderItem( new OrderItem( 1 , "TermékNév" , 10.0 , 1 ) );

        order = (OrderOnLine) c.createOrder( PAY_MODE.BANKCARD , DELIVER_MODE.HOUSE );
    }

    @Test
    void countOrderItem() {
        assertEquals ( 1 , order.countOrderItem(),
                "OrderOnLine: countOrderItem Elemek darabszáma hibás." );
    }

    @Test
    void getOrderFullPrice() {
        assertEquals (12.5 , order.getOrderFullPrice(),
                "OrderOnLine:getOrderFullPrice Elemek össz értéke hibás." );
    }

    @Test
    void getKezbesitesiMod() {
        assertEquals (DELIVER_MODE.HOUSE , order.getKezbesitesiMod(),
                "OrderOnLine:getKezbesitesiMod Értéke hibás." );
    }

    @Test
    void getFizetesimod() {
        assertEquals (PAY_MODE.BANKCARD , order.getFizetesimod(),
                "OrderOnLine:getFizetesimod Értéke hibás." );
    }

    @Test
    void addToFutar() {
        order.addToFutar();
        assertEquals (DELIVER_STATUS.IN_PROGRESS , order.getStatusz(),
                "OrderOnLine:addToFutar Státusz értéke hibás." );
    }

    @Test
    void sikeresKezbesites() {
        order.sikeresKezbesites();
        assertEquals (DELIVER_STATUS.DELIVERED , order.getStatusz(),
                "OrderOnLine:sikeresKezbesites Státusz értéke hibás." );
    }

    @Test
    void sikertelenKezbesites() {
        order.sikertelenKezbesites("Kamu üzenet");
        assertEquals (DELIVER_STATUS.FAILED_DELIVERY , order.getStatusz(),
                "OrderOnLine:sikertelenKezbesites Státusz értéke hibás." );
        assertEquals ("Kamu üzenet" , order.getFutarUzenet(),
                "OrderOnLine:sikertelenKezbesites Futár üzenet értéke hibás." );
    }

}