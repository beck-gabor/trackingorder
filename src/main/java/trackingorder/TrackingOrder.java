package trackingorder;



public class TrackingOrder {


    public static void main(String[] args) {

        Product product = new Product( 1,"Neve-1" , 1.0 );

        WareHouse wh = new WareHouse();

        wh.addTermek( product,1  );
        wh.addTermek( new Product( 2,"Neve-22" , 22.0 ),24  );

        System.out.println( wh.getKeszlet(2) );
        System.out.println( wh.getKeszlet(1) );





    }
}
