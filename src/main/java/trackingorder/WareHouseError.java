package trackingorder;

public class WareHouseError extends RuntimeException  {
    private WareHouseErrorCode wareHouseErrorCode;

    public WareHouseError(WareHouseErrorCode wareHouseErrorCode) {
        this.wareHouseErrorCode = wareHouseErrorCode;
    }

    public WareHouseError(String message, WareHouseErrorCode wareHouseErrorCode) {
        super(message);
        this.wareHouseErrorCode = wareHouseErrorCode;

    }

    public WareHouseErrorCode getErrorCode() {
        return this.wareHouseErrorCode;
    }

}
