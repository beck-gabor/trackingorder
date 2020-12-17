package trackingorder;

import java.util.HashMap;

public class OrderOnLine extends Order {
    private String futarUzenet;

    public OrderOnLine(HashMap<Integer,OrderItem> orderItems , Customer customer, deliveryMode kezbesitesiMod, payMode fizetesimod) {
        super(orderItems, customer,  kezbesitesiMod, fizetesimod);
        this.setStatusz( deliveryStatus.BOOKED);
    }

    public String getFutarUzenet() {
        return futarUzenet;
    }

    public void addToFutar(){
        this.setStatusz( deliveryStatus.IN_PROGRESS );
    }

    public void sikeresKezbesites(){
        this.setStatusz( deliveryStatus.DELIVERED);
    }

    public void sikertelenKezbesites( String message){
        this.setStatusz( deliveryStatus.FAILED_DELIVERY);
        this.futarUzenet = message;
    }

}
