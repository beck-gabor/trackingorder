package trackingorder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WareHouse {
    private HashMap<Integer,Stock> stock = new HashMap<>();

    private Stock findStockById(Integer id){
        Stock s;

        s = stock.get( id);

        return null;
    }

    public void addTermek( Product product , Integer amount ){
        stock.put( product.getId() ,  new Stock( product, amount ) );
    }

    public void plusKeszlet( Integer id, Integer darab ){
    }

    public void minusKeszlet( Integer id, Integer darab ){

    }

    public Integer getKeszlet( Integer id ){
        return findStockById( id ).getAmount();
    }

    public void foglal( Integer id, Integer darab){

    }

    public void felszabadit( Integer id, Integer darab){

    }

}
