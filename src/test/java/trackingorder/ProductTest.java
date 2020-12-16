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

        assertEquals ( 3 ,cp.getId() ,
                "Product ID érték beállítása hibás." );
        assertEquals ( "CreateProd" ,cp.getName() ,
                "Product Name érték beállítása hibás." );
        assertEquals ( 999.1 ,cp.getPrice() ,
                "Product Price érték beállítása hibás." );
    }

    @Test
    void setId() {
        p.setId(10);
        assertEquals (10 , this.p.getId() ,
                "Product SetID hibás." );
    }

    @Test
    void setName() {
        p.setName("RókaRudi");
        assertEquals ("RókaRudi" , this.p.getName() ,
                "Product SetName hibás." );
    }

    @Test
    void setPrice() {
        p.setPrice(33.2);
        assertEquals (33.2 , this.p.getPrice() ,
                "Product SetPrice hibás." );
    }
}
