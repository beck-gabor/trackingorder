package trackingorder;

public class TrackingOrder {


    public static void main(String[] args) {

        TrackingOrder to = new TrackingOrder();
        to.OnlineVasarol();
        to.ShopbanVasarol();

    }

    private void ShopbanVasarol(){

        System.out.println("----- ShopbanVasarol -----------------------------------------");

        WareHouse wh = new WareHouse();
        OrderInShop sorder;

        wh.addTermek( new Product( 1,"Neve-1" , 1.0 ),1  );
        wh.addTermek( new Product( 2,"Neve-22" , 12.0 ),14  );
        wh.addTermek( new Product( 3,"Neve-333" , 22.0 ),24  );

        //------------------------

        Customer customer = new Customer("Lakcím" , "72/666-111" , "Kalamer Grigor" , "valaki@valah.ol");

        Cart cart = new Cart( wh , customer );


        cart.addOrderItem(1 , 1 );
        cart.addOrderItem(2 , 2 );
        cart.addOrderItem(3 , 1 );

        System.out.println( cart);
        cart.delOrderItem(3);
        System.out.println( cart);

        sorder = (OrderInShop) cart.createOrder( payMode.BANKCARD , deliveryMode.INSHOP);

        System.out.println( sorder );

    }

    private void OnlineVasarol(){

        System.out.println("---- OnlineVasarol ------------------------------------------");

        WareHouse whz = new WareHouse();
        OrderOnLine olorder;

        whz.addTermek( new Product( 1,"Neve-1" , 1.0 ),1  );
        whz.addTermek( new Product( 2,"Neve-22" , 12.0 ),14  );
        whz.addTermek( new Product( 3,"Neve-333" , 22.0 ),24  );

        //------------------------

        Customer c = new Customer("Lakcím" , "72/666-111" , "Kalamer Grigor" , "valaki@valah.ol");

        Cart kosar = new Cart( whz , c );

        kosar.addOrderItem(1 , 1 );
        kosar.addOrderItem(2 , 2 );
        kosar.addOrderItem(3 , 1 );

        System.out.println( kosar);
        kosar.delOrderItem(3);
        System.out.println( kosar);

        olorder = (OrderOnLine) kosar.createOrder( payMode.BANKCARD , deliveryMode.HOUSE);

        System.out.println( olorder );

        olorder.addToFutar();

        System.out.println( olorder );

        olorder.sikertelenKezbesites("SeholSenki");

        System.out.println( olorder );

        System.out.println( olorder.getStatusz() + " - " + olorder.getFutarUzenet());

//        try {
//        }catch ( Exception e ){
//
//        }

    }

}
