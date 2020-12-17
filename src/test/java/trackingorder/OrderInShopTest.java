package trackingorder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderInShopTest {
    private Cart c;
    private OrderInShop order;
    private WareHouse wh = new WareHouse();

    @BeforeEach
    void setUp() {
        wh.addTermek( new Product( 1,"Neve-1" , 1.0 ),1  );
        wh.addTermek( new Product( 2,"Neve-22" , 22.0 ),24  );
        c = new Cart( wh, new Customer( "Cim" , "'Telefon" , "nev", "email") );
        c.addOrderItem( 1,1 );

        order = (OrderInShop) c.createOrder( payMode.BANKCARD , deliveryMode.INSHOP );
    }

    @Test
    void getStatusz() {
        assertEquals( deliveryStatus.DELIVERED, order.getStatusz(),
                "OrderInShop:getStatusz - A státusz nem megfelelő" );
    }

    @Test
    void fullLife() {
        WareHouse whz = new WareHouse();
        OrderInShop isorder;

        whz.addTermek( new Product( 1,"Neve-1" , 1.0 ),1  );
        whz.addTermek( new Product( 2,"Neve-22" , 12.0 ),14  );
        whz.addTermek( new Product( 3,"Neve-333" , 22.0 ),24  );

        //------------------------

        Customer c = new Customer("Lakcím" , "72/666-111" , "Kalamer Grigor" , "valaki@valah.ol");

        Cart kosar = new Cart( whz , c );

        kosar.addOrderItem(1 , 1 );
        kosar.addOrderItem(2 , 2 );
        kosar.addOrderItem(3 , 1 );

        isorder = (OrderInShop) kosar.createOrder( payMode.BANKCARD , deliveryMode.INSHOP);



    }


}