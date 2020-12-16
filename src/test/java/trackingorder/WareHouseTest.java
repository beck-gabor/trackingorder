package trackingorder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WareHouseTest {
    private WareHouse wh = new WareHouse();

    @BeforeEach
    void setUp() {
        wh.addTermek(new Product(1, "Termék neve", 10.0), 2);
        assertEquals(2 , wh.getKeszlet( 1 ) ,
                "WareHouse:AddTermek - A raktár készlet eltér " );
    }

    @Test
    void plusKeszlet() {
        wh.addTermek(new Product(2, "Termék neve", 10.0), 2);
        wh.plusKeszlet(2,8);
        assertEquals(10 , wh.getKeszlet( 2 ) ,
                "WareHouse:plusKeszlet - A raktár készlet eltér " );
    }

    @Test
    void minusKeszlet() {
        wh.addTermek(new Product(3, "Termék neve", 10.0), 2);
        wh.minusKeszlet(3,1);
        assertEquals( 1 , wh.getKeszlet( 3 ) ,
                "WareHouse:minusKeszlet - A raktár készlet eltér " );
    }

    @Test
    void getKeszlet() {
        try {
            // Mennyi a készlet abból ami nincs is?
            wh.getKeszlet(99);
            fail("WareHouse:getKeszlet - Hiányzó WareHouseErrorCode.STOCK_NOTFOUND Exception ");
        }
        catch (  WareHouseError whe ) {
            assertEquals(WareHouseErrorCode.STOCK_NOTFOUND , whe.getErrorCode(),
                    "getKeszlet nem STOCK_NOTFOUND hibakóddal tért vissza.");
        }
    }

    @Test
    void foglal() {
        Integer saveKeszlet = wh.getKeszlet(1);
        Integer saveFoglalt = wh.getFoglalt(1);
        wh.foglal(1,1);
        assertEquals(saveKeszlet-1 , wh.getKeszlet(1),
                "WareHouse:Foglal A készlet csökkenés hibás.");
        assertEquals(saveFoglalt+1 , wh.getFoglalt(1),
                "WareHouse:Foglal A foglalás növekedés hibás.");

        try {
            // Foglalok abból ami nem létezik
            wh.foglal(100,1);
            fail("WareHouse:foglal - Hiányzó WareHouseErrorCode.STOCK_NOTFOUND Exception ");
        }
        catch (  WareHouseError whe ) {
            assertEquals(WareHouseErrorCode.STOCK_NOTFOUND ,whe.getErrorCode(),
                    "WareHouse:foglal nem .STOCK_NOTFOUND hibakóddal tért vissza.");
        }

        try {
            // Foglalok annyit amennyi nem létezik
            wh.foglal(1,100);
            fail("WareHouse:foglal - Hiányzó WareHouseErrorCode.STOCK_LOW Exception ");
        }
        catch (  WareHouseError whe ) {
            assertEquals(WareHouseErrorCode.STOCK_LOW , whe.getErrorCode(),
                    "WareHouse:foglal nem .STOCK_LOW hibakóddal tért vissza.");
        }
    }

    @Test
    void felszabadit() {

        wh.foglal(1,1);

        Integer saveKeszlet = wh.getKeszlet(1);
        Integer saveFoglalt = wh.getFoglalt(1);

        wh.felszabadit(1,1);

        assertEquals(saveKeszlet+1 , wh.getKeszlet(1),
                "WareHouse:felszabadit A készlet csökkenés hibás.");
        assertEquals(saveFoglalt-1 , wh.getFoglalt(1),
                "WareHouse:felszabadit A foglalás növekedés hibás.");


        try {
            // Felszabadítok abból ami nem létezik
            wh.felszabadit(100,1);
            fail("WareHouse:felszabadit - Hiányzó WareHouseErrorCode.STOCK_NOTFOUND Exception ");
        }
        catch (  WareHouseError whe ) {
            assertEquals(WareHouseErrorCode.STOCK_NOTFOUND , whe.getErrorCode(),
                    "WareHouse:felszabadit nem .STOCK_NOTFOUND hibakóddal tért vissza.");
        }

        try {
            // Felszabadítok annyit amennyi nem létezik
            wh.felszabadit(1,100);
            fail("WareHouse:felszabadit - Hiányzó WareHouseErrorCode.STOCK_NOTRESERVED Exception ");
        }
        catch (  WareHouseError whe ) {
            assertEquals(WareHouseErrorCode.STOCK_NOTRESERVED , whe.getErrorCode(),
                    "WareHouse:felszabadit Nem .STOCK_NOTRESERVED hibakóddal tért vissza.");
        }
    }
}