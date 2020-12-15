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
    void createProduct() {
        Product cp = new Product( 3, "CreateProd" , 999.1   );

        assertEquals ( cp.getId() , 3 , "Product ID érték beállítása hibás." );
        assertEquals ( cp.getName() , "CreateProd" , "Product Name érték beállítása hibás." );
        assertEquals ( cp.getPrice() , 999.1 , "Product Price érték beállítása hibás." );
    }

    @Test
    void setId() {
        p.setId(10);
        assertEquals ( this.p.getId() , 10 , "Product SetID hibás." );
    }

    @Test
    void setName() {
        p.setName("RókaRudi");
        assertEquals ( this.p.getName() , "RókaRudi" , "Product SetName hibás." );
    }

    @Test
    void setPrice() {
        p.setPrice(33.2);
        assertEquals ( this.p.getPrice() , 33.2 , "Product SetPrice hibás." );
    }
}
