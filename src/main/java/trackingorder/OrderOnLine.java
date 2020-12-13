package trackingorder;

public class OrderOnLine extends Order {
    private String futarUzenet;

    private DELIVER_MODE KezbesitesiMod;
    private DELIVER_STATUS statusz;


    public OrderOnLine(Customer customer, DELIVER_MODE kezbesitesiMod, PAY_MODE fizetesimod) {

        super(customer,  kezbesitesiMod, fizetesimod);


        if ( fizetesimod == PAY_MODE.CASH & kezbesitesiMod == DELIVER_MODE.INSHOP){
            statusz= DELIVER_STATUS.DELIVERED;
        }
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
