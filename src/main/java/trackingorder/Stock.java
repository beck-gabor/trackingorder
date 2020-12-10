package trackingorder;

public class Stock extends Product {
    private Integer amount;
    private Integer foglalva;

    public Stock(Integer id, String name, Double price, Integer amount) {
        super(id, name, price);
        this.amount = amount;
    }

    public Stock( Product product,  Integer amount) {
        super( product.getId(),product.getName(), product.getPrice());
        this.amount = amount;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getFoglalva() {
        return foglalva;
    }

    public void setFoglalva(Integer foglalva) {
        this.foglalva = foglalva;
    }

}
