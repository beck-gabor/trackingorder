package trackingorder;

import java.util.HashMap;

public class WareHouse {
    private HashMap<Integer,Stock> stock = new HashMap<>();

    private Stock findStockById(Integer id){

        if (!stock.containsKey(id))
            throw new WareHouseError( "Stock not found in WareHouse, ID:" + id , WareHouseErrorCode.STOCK_NOTFOUND ) ;

        return stock.get( id);
    }

    public void addTermek( Product product , Integer amount ) throws WareHouseError{

        if (stock.containsKey(product.getId()))
            throw new WareHouseError( "Stock can not add, found in WareHouse, ID:" + product.getId() , WareHouseErrorCode.STOCK_ALREADY ) ;

        stock.put( product.getId() ,  new Stock( product, amount ) );
    }

    public void plusKeszlet( Integer id, Integer darab ){
        Stock s = findStockById(id);
        s.setAmount( s.getAmount()+darab);
    }

    public void minusKeszlet( Integer id, Integer darab ) throws WareHouseError{
        Stock s = findStockById(id);
        if( darab > s.getAmount() ){
            throw new WareHouseError( "Stock not enought, ID:" + id , WareHouseErrorCode.STOCK_LOW ) ;
        }
        s.setAmount( s.getAmount()-darab);
    }

    public Integer getKeszlet( Integer id ){
        return this.findStockById( id ).getAmount();
    }

    public Integer getFoglalt( Integer id ){
        return this.findStockById( id ).getFoglalva();
    }

    public void foglal( Integer id, Integer darab) throws WareHouseError{
        Stock s = null;

        try {
            s = this.findStockById(id);

            if( s.getAmount() < darab ){
                throw new WareHouseError( "Unable to reserve, not amount: " + id, WareHouseErrorCode.STOCK_LOW );
            }else{
                s.setAmount( s.getAmount()-darab);
                s.setFoglalva( s.getFoglalva() + darab);
            }

        }
        catch( WareHouseError whe  ){
            throw new WareHouseError( "Unable to reserve, not found: " + id, whe.getErrorCode());
        }

    }

    public void felszabadit( Integer id, Integer darab) throws WareHouseError  {
        Stock s = null;

        s = this.findStockById(id);

        if( s.getFoglalva() < darab ){
            throw new WareHouseError( "Unable to reserve, not amount: " + id, WareHouseErrorCode.STOCK_NOTRESERVED );
        }else{
            s.setAmount( s.getAmount()+darab);
            s.setFoglalva( s.getFoglalva() - darab);
        }

    }

}
