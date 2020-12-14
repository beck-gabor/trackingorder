package trackingorder;

import java.util.HashMap;

public class OrderInShop extends Order {


    public OrderInShop(HashMap<Integer,OrderItem> orderItems , Customer customer, PAY_MODE payMode){
        super( orderItems , customer , DELIVER_MODE.INSHOP , payMode  );
    }

    @Override
    public DELIVER_STATUS getStatusz(){
        return DELIVER_STATUS.DELIVERED;
    }

}
