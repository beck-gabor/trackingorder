package trackingorder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderOnLineTest {
    private Cart c;
    private OrderOnLine order;
    private WareHouse wh = new WareHouse();

    @BeforeEach
    void setUp() {
        wh.addTermek( new Product( 1,"Neve-1" , 10.0 ),1  );
        wh.addTermek( new Product( 2,"Neve-22" , 22.0 ),24  );

        c = new Cart( wh, new Customer( "Cim" , "'Telefon" , "nev", "email") );
        c.addOrderItem( 1,1 );

        order = (OrderOnLine) c.createOrder( payMode.BANKCARD , deliveryMode.HOUSE );
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
        assertEquals (deliveryMode.HOUSE , order.getKezbesitesiMod(),
                "OrderOnLine:getKezbesitesiMod Értéke hibás." );
    }

    @Test
    void getFizetesimod() {
        assertEquals (payMode.BANKCARD , order.getFizetesimod(),
                "OrderOnLine:getFizetesimod Értéke hibás." );
    }

    @Test
    void addToFutar() {
        order.addToFutar();
        assertEquals (deliveryStatus.IN_PROGRESS , order.getStatusz(),
                "OrderOnLine:addToFutar Státusz értéke hibás." );
    }

    @Test
    void sikeresKezbesites() {
        order.sikeresKezbesites();
        assertEquals (deliveryStatus.DELIVERED , order.getStatusz(),
                "OrderOnLine:sikeresKezbesites Státusz értéke hibás." );
    }

    @Test
    void sikertelenKezbesites() {
        order.sikertelenKezbesites("Kamu üzenet");
        assertEquals (deliveryStatus.FAILED_DELIVERY , order.getStatusz(),
                "OrderOnLine:sikertelenKezbesites Státusz értéke hibás." );
        assertEquals ("Kamu üzenet" , order.getFutarUzenet(),
                "OrderOnLine:sikertelenKezbesites Futár üzenet értéke hibás." );
    }

    @Test
    void fullLife() {
        WareHouse whz = new WareHouse();
        OrderOnLine olorder;

        whz.addTermek( new Product( 1,"Neve-1" , 1.0 ),1  );
        whz.addTermek( new Product( 2,"Neve-22" , 12.0 ),14  );
        whz.addTermek( new Product( 3,"Neve-333" , 22.0 ),24  );

        //------------------------

        Customer c = new Customer("Lakcím" , "72/666-111" , "Kalamer Grigor" , "valaki@valah.ol");

        Cart kosar = new Cart( whz , c );

        kosar.addOrderItem(1 , 1 );
        kosar.addOrderItem(2 , 2 );
        kosar.addOrderItem(3 , 1 );

        olorder = (OrderOnLine) kosar.createOrder( payMode.BANKCARD , deliveryMode.HOUSE);

        olorder.addToFutar();
        olorder.sikertelenKezbesites("SeholSenki");


    }

}