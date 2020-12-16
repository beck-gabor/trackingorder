package trackingorder;

import java.util.HashMap;

public class OrderOnLine extends Order {
    private String futarUzenet;
    //private DELIVER_STATUS statusz;

    public OrderOnLine(HashMap<Integer,OrderItem> orderItems , Customer customer, DELIVER_MODE kezbesitesiMod, PAY_MODE fizetesimod) {
        super(orderItems, customer,  kezbesitesiMod, fizetesimod);
        this.setStatusz( DELIVER_STATUS.BOOKED);
    }

    public String getFutarUzenet() {
        return futarUzenet;
    }

    public void addToFutar(){
        this.setStatusz( DELIVER_STATUS.IN_PROGRESS );
    }

    public void sikeresKezbesites(){
        this.setStatusz( DELIVER_STATUS.DELIVERED);
    }

    public void sikertelenKezbesites( String message){
        this.setStatusz( DELIVER_STATUS.FAILED_DELIVERY);
        this.futarUzenet = message;
    }

}
