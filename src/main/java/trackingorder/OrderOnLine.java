package trackingorder;

import java.util.HashMap;

public class OrderOnLine extends Order {
    private String futarUzenet;

//    private DELIVER_MODE KezbesitesiMod;
    private DELIVER_STATUS statusz;


    public OrderOnLine(HashMap<Integer,OrderItem> orderItems , Customer customer, DELIVER_MODE kezbesitesiMod, PAY_MODE fizetesimod) {
        super(orderItems, customer,  kezbesitesiMod, fizetesimod);
        statusz= DELIVER_STATUS.BOOKED;
    }


    public String getFutarUzenet() {
        return futarUzenet;
    }

    public void setFutarUzenet(String futarUzenet) {
        this.futarUzenet = futarUzenet;
    }

    public DELIVER_STATUS getStatusz() {
        return statusz;
    }

    public void setStatusz(DELIVER_STATUS statusz) {
        this.statusz = statusz;
    }




}
