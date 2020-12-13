package trackingorder;

public class OrderInShop {
    private DELIVER_MODE KezbesitesiMod;
    private DELIVER_STATUS statusz;

    public DELIVER_STATUS getStatusz() {
        return statusz;
    }

    public OrderInShop(DELIVER_MODE kezbesitesiMod, DELIVER_STATUS statusz) {
        KezbesitesiMod = kezbesitesiMod;
        this.statusz = DELIVER_STATUS.DELIVERED;
    }

    public void setStatusz(DELIVER_STATUS statusz) {
        this.statusz = statusz;
    }

}
