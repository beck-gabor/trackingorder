package trackingorder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {
    private Product p;

    @BeforeEach
    void setUp() {
        p = new Product( 1, "Valami" , 22.0   );
    }

    @Test
    void getId() {
        assertEquals ( this.p.getId() , 1 , "Product ID érték beállítása hibás." );
    }

    @Test
    void setId() {
        Integer saveId = p.getId();
        p.setId(10);

        assertEquals ( this.p.getId() , 10 , "Product SetID hibás." );

        p.setId(saveId);
    }

    @Test
    void getName() {
        assertEquals ( this.p.getName() , "Valami" , "Product Name érték beállítása hibás." );
    }

    @Test
    void setName() {
        String saveName = p.getName();
        p.setName("RókaRudi");

        assertEquals ( this.p.getName() , "RókaRudi" , "Product SetName hibás." );

        p.setName(saveName);
    }

    @Test
    void getPrice() {
        assertEquals ( this.p.getPrice() , 22.0 , "Product Price érték beállítása hibás." );
    }

    @Test
    void setPrice() {
        Double savePrice = p.getPrice();
        p.setPrice(33.2);

        assertEquals ( this.p.getPrice() , 33.2 , "Product SetPrice hibás." );

        p.setPrice(savePrice);

    }
}
