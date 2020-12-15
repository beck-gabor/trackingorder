package trackingorder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WareHouseTest {
    private WareHouse wh = new WareHouse();

    @BeforeEach
    void setUp() {
        wh.addTermek(new Product(1, "Termék neve", 10.0), 2);

        assertEquals( wh.getKeszlet( 1 ) , 2 ,
                "WareHouse:AddTermek - A raktár készlet eltér " );

    }

    @Test
    void addTermek() {
    }

    @Test
    void plusKeszlet() {

        wh.addTermek(new Product(2, "Termék neve", 10.0), 2);

        wh.plusKeszlet(2,8);
        assertEquals( wh.getKeszlet( 2 ) , 10 ,
                "WareHouse:plusKeszlet - A raktár készlet eltér " );
    }

    @Test
    void minusKeszlet() {

        wh.addTermek(new Product(3, "Termék neve", 10.0), 2);

        wh.minusKeszlet(3,1);
        assertEquals( wh.getKeszlet( 3 ) , 1 ,
                "WareHouse:minusKeszlet - A raktár készlet eltér " );
    }

    @Test
    void getKeszlet() {
itt hagytam abba
        try {
            // Mennyi a készlet abból ami nincs is?
            wh.getKeszlet(99);
            fail("WareHouse:addOrderItem - Hiányzó ITEMALREADYINCART Exception ");
        }
        catch (  CartError ce ) {
            assertEquals(ce.getErrorCode(), CartErrorCode.ITEMALREADYINCART ,
                    "addOrderItem nem ITEMALREADYINCART hibakóddal tért vissza.");
        }


    }



    @Test
    void foglal() {
    }

    @Test
    void felszabadit() {
    }
}