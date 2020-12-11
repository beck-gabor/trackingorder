package trackingorder;

public class CartError extends RuntimeException  {
    private CartErrorCode cartErrorCode;

    public CartError(CartErrorCode cartErrorCode) {
        this.cartErrorCode = cartErrorCode;
    }

    public CartError(String message, CartErrorCode cartErrorCode) {
        super(message);
        this.cartErrorCode = cartErrorCode;

    }

    public CartErrorCode getErrorCode() {
        return this.cartErrorCode;
    }

}
