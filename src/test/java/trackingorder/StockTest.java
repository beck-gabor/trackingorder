package trackingorder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StockTest {
    private Stock s;

    @BeforeEach
    void setUp() {
        s = new Stock( new Product( 1,"Name", 100.0) , 2000 );
        assertEquals (2000 , s.getAmount() ,
                "Stock:getAmount érték hibás." );
    }

    @Test
    void setAmount() {
        s.setAmount( 100 );
        assertEquals (100 , s.getAmount() ,
                "Stock:setAmount érték hibás." );
    }

    @Test
    void tesztFoglalva() {
        assertEquals (0 , s.getFoglalva() ,
                "Stock:Foglalva induló érték hibás." );
        s.setFoglalva(99);
        assertEquals ( 99 , s.getFoglalva()  ,
                "Stock:Foglalva setFoglalva hibás." );
    }

}