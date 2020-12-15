package trackingorder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StockTest {
    private Stock s;

    @BeforeEach
    void setUp() {
        s = new Stock( new Product( 1,"Name", 100.0) , 2000 );
        assertEquals ( s.getAmount() , 2000 , "Stock:getAmount érték hibás." );
    }

    @Test
    void setAmount() {
        s.setAmount( 100 );
        assertEquals ( s.getAmount() , 100 , "Stock:setAmount érték hibás." );
    }

    @Test
    void tesztFoglalva() {
        assertEquals ( s.getFoglalva() , 0 , "Stock:Foglalva induló érték hibás." );
        s.setFoglalva(99);
        assertEquals ( s.getFoglalva() , 99 , "Stock:Foglalva setFoglalva hibás." );
    }

}