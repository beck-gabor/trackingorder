package trackingorder;



public class TrackingOrder {


    public static void main(String[] args) {

        Product product = new Product( 1,"Neve-1" , 10.0 );

        WareHouse wh = new WareHouse();

        wh.addTermek( product,1  );


    }
}
