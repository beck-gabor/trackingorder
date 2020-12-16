package trackingorder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {
    private Cart c;

    @BeforeEach
    void setUp() {
        c = new Cart( new Customer( "Cim" , "'Telefon" , "nev", "email") );
        assertEquals ( c.countCartItem() , 0 , "Cart: Elemek induló értéke hibás." );

    }

    @Test
    void addOrderItem() {

        c.addOrderItem( new OrderItem( 1 , "Neve-1" , 10.0 , 1 ));
        assertEquals (  1 , c.countCartItem() ,
                "Cart:addOrderItem - Elem hozzáadása hibás." );

        try {
            // Ez az orderItem.Id már szerepel a kosárban, megpróbáljuk újra hozzá adni.
            c.addOrderItem( new OrderItem( 1 , "Neve-1" , 10.0 , 1 ));
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

        c.addOrderItem( new OrderItem( 4 , "Törlendő" , 100.0 , 10 ));

        Integer countItem = c.countCartItem();
        c.delOrderItem( 4 );

        assertNotEquals ( countItem ,c.countCartItem() ,
                "delOrderItem: Elem törlése nem történt meg." );

    }

    // Vásárlás a Shop-ban
    @Test
    void createOrderInShop() {
        Order o;
        o = c.createOrder( PAY_MODE.BANKCARD , DELIVER_MODE.INSHOP );

        assertEquals(PAY_MODE.BANKCARD , o.getFizetesimod(),
                "Cart:CreateOrder - (InShop) FizetésiMód nem a megadott. " );
        assertEquals(DELIVER_MODE.INSHOP , o.getKezbesitesiMod(),
                "Cart:CreateOrder - (InShop) Szállítási mód nem a megadott. " );
        assertEquals(o.countOrderItem() , c.countCartItem() ,
                "Cart:CreateOrder - (InShop) Rendelés és kosár elemeinek száma eltér " );
    }

    @Test
    void createOrderOnLine() {
        Order o;
        o = c.createOrder( PAY_MODE.CASH , DELIVER_MODE.HOUSE );

        assertEquals(PAY_MODE.CASH , o.getFizetesimod(),
                "Cart:CreateOrder - (OnLine) FizetésiMód nem a megadott. " );
        assertEquals(DELIVER_MODE.HOUSE , o.getKezbesitesiMod(),
                "Cart:CreateOrder - (OnLine) Szállítási mód nem a megadott. " );
        assertEquals(o.countOrderItem() , c.countCartItem() ,
                "Cart:CreateOrder - (OnLine) Rendelés és kosár elemeinek száma eltér " );
    }


}