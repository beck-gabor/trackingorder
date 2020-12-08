package trackingorder;

import java.util.ArrayList;
import java.util.List;

public class WareHouse {
    private List<Stock> stock = new ArrayList<>();

    private Stock findStockById(Integer id){
        return null;
    }

    public void addTermek( Product product , Integer amount ){
        stock.add(  new Stock( product, amount ) );
    }

    public void plusKeszlet( Integer id, Integer darab ){

    }

    public Integer getKeszlet( Integer id ){
        return 0;
    }

    public void minusKeszlet( Integer id, Integer darab ){

    }

}
