package trackingorder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {
    private Cart c;
    private WareHouse wh = new WareHouse();

    @BeforeEach
    void setUp() {
        wh.addTermek( new Product( 1,"Neve-1" , 1.0 ),1  );
        wh.addTermek( new Product( 2,"Neve-22" , 22.0 ),24  );

        c = new Cart( wh,  new Customer( "Cim" , "'Telefon" , "nev", "email") );
        assertEquals ( c.countCartItem() , 0 , "Cart: Elemek induló értéke hibás." );
    }

    @Test
    void addOrderItem() {

        Integer saveKeszlet = wh.getKeszlet(1);
        Integer saveFoglalas = wh.getFoglalt( 1);

        c.addOrderItem( 1,1);

        assertEquals (  1 , c.countCartItem() ,
                "Cart:addOrderItem - Elem hozzáadása hibás." );

        assertEquals( saveKeszlet -1 ,wh.getKeszlet(1),
                "addOrderItem Készlet változás hibás.");
        assertEquals( saveFoglalas +1 ,wh.getFoglalt(1),
                "addOrderItem Foglalás változás hibás.");


        try {
            // Ez az orderItem.Id már szerepel a kosárban, megpróbáljuk újra hozzá adni.
            c.addOrderItem( 1,1);
            fail("Cart:addOrderItem - Hiányzó ITEMALREADYINCART Exception ");
        }
        catch (  CartError ce ) {
            assertEquals(CartErrorCode.ITEMALREADYINCART ,ce.getErrorCode(),
                        "addOrderItem nem ITEMALREADYINCART hibakóddal tért vissza.");
        }

    }

    @Test
    void delOrderItem() {

        try {
            // Ez az orderItem.Id nem szerepel a kosárban
            c.delOrderItem( 4 );
            fail("Cart:delOrderItem - Hiányzó .ITEMNOTINCART Exception ");
        }
        catch (  CartError ce ) {
            assertEquals(CartErrorCode.ITEMNOTFOUNDINCART ,ce.getErrorCode(),
                    "delOrderItem nem ITEMNOTFOUNDINCART hibakóddal tért vissza.");
        }

        c.addOrderItem( 2, 10);

        Integer saveKeszlet = wh.getKeszlet(2);
        Integer saveFoglalas = wh.getFoglalt( 2);

        Integer countItem = c.countCartItem();

        c.delOrderItem( 2 );

        assertNotEquals ( countItem ,c.countCartItem() ,
                "delOrderItem: Elem törlése nem történt meg." );

        assertEquals( saveKeszlet +10 ,wh.getKeszlet(2),
                "delOrderItem Készlet változás hibás.");
        assertEquals( saveFoglalas -10 ,wh.getFoglalt(2),
                "delOrderItem Foglalás változás hibás.");

    }

    // Vásárlás a Shop-ban
    @Test
    void createOrderInShop() {
        OrderInShop o;

        o = (OrderInShop) c.createOrder( payMode.BANKCARD , deliveryMode.INSHOP );

        assertEquals(payMode.BANKCARD , o.getFizetesimod(),
                "Cart:CreateOrder - (InShop) FizetésiMód nem a megadott. " );
        assertEquals(deliveryMode.INSHOP , o.getKezbesitesiMod(),
                "Cart:CreateOrder - (InShop) Szállítási mód nem a megadott. " );
        assertEquals(o.countOrderItem() , c.countCartItem() ,
                "Cart:CreateOrder - (InShop) Rendelés és kosár elemeinek száma eltér " );

        assertEquals( deliveryStatus.DELIVERED , o.getStatusz() ,
                "Cart:CreateOrder - (InShop) A stárusz nem automatikusan DELIVERED." );

    }

    @Test
    void createOrderOnLine() {
        // Order o;
        OrderOnLine o;
        o = (OrderOnLine) c.createOrder( payMode.CASH , deliveryMode.HOUSE );

        assertEquals(payMode.CASH , o.getFizetesimod(),
                "Cart:CreateOrder - (OnLine) FizetésiMód nem a megadott. " );
        assertEquals(deliveryMode.HOUSE , o.getKezbesitesiMod(),
                "Cart:CreateOrder - (OnLine) Szállítási mód nem a megadott. " );
        assertEquals(o.countOrderItem() , c.countCartItem() ,
                "Cart:CreateOrder - (OnLine) Rendelés és kosár elemeinek száma eltér " );

        assertEquals( deliveryStatus.BOOKED , o.getStatusz() ,
                "Cart:CreateOrder - (InShop) A stárusz nem automatikusan BOOKED." );


    }

}