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
        assertEquals ( c.countCartItem() , 1 , "Cart:addOrderItem - Elem hozzáadása hibás." );

        try {
            // Ez az orderItem.Id már szerepel a kosárban, megpróbáljuk újra hozzá adni.
            c.addOrderItem( new OrderItem( 1 , "Neve-1" , 10.0 , 1 ));
            fail("Cart:addOrderItem - Hiányzó ITEMALREADYINCART Exception ");
        }
        catch (  CartError ce ) {
            assertEquals(ce.getErrorCode(), CartErrorCode.ITEMALREADYINCART ,
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
            assertEquals(ce.getErrorCode(), CartErrorCode.ITEMNOTFOUNDINCART ,
                    "delOrderItem nem ITEMNOTFOUNDINCART hibakóddal tért vissza.");
        }

        c.addOrderItem( new OrderItem( 4 , "Törlendő" , 100.0 , 10 ));

        Integer countItem = c.countCartItem();
        c.delOrderItem( 4 );

        assertNotEquals ( c.countCartItem() , countItem , "delOrderItem: Elem törlése nem történt meg." );

    }

    // Vásárlás a Shop-ban
    @Test
    void createOrderInShop() {
        Order o;

        o = c.createOrder( PAY_MODE.BANKCARD , DELIVER_MODE.INSHOP );

        assertEquals(o.getFizetesimod(), PAY_MODE.BANKCARD ,
                "Cart:CreateOrder - (InShop) FizetésiMód nem a megadott. " );
        assertEquals(o.getKezbesitesiMod(), DELIVER_MODE.INSHOP ,
                "Cart:CreateOrder - (InShop) Szállítási mód nem a megadott. " );
        assertEquals( c.countCartItem() ,  o.countOrderItem() ,
                "Cart:CreateOrder - (InShop) Rendelés és kosár elemeinek száma eltér " );


    }

    @Test
    void createOrderOnLine() {
        Order o;

        o = c.createOrder( PAY_MODE.CASH , DELIVER_MODE.HOUSE );

        assertEquals(o.getFizetesimod(), PAY_MODE.CASH ,
                "Cart:CreateOrder - (OnLine) FizetésiMód nem a megadott. " );
        assertEquals(o.getKezbesitesiMod(), DELIVER_MODE.HOUSE ,
                "Cart:CreateOrder - (OnLine) Szállítási mód nem a megadott. " );
        assertEquals( c.countCartItem() ,  o.countOrderItem() ,
                "Cart:CreateOrder - (OnLine) Rendelés és kosár elemeinek száma eltér " );


    }


}