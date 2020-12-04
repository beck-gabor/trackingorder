package trackingorder;

import java.util.ArrayList;
import java.util.List;

public class WareHouse {
    private List<Product> products = new ArrayList<Product>();

    private Product findTermekById(Integer id){
        return null;
    }

    public void addTermek( Integer id, String name ){
        products.add( id , new Product(  ) );
    }

    public void plusKeszlet( Integer id, Integer darab ){

    }

    public Integer getKeszlet( Integer id ){
        return 0;
    }

    public void minusKeszlet( Integer id, Integer darab ){

    }

}
