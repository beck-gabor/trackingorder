package trackingorder;

public class Stock extends Product {
    private Integer amount;

    public Stock(Integer id, String name, Double price, Integer amount) {
        super(id, name, price);
        this.amount = amount;
    }

    public Stock( Product product,  Integer amount) {
        super( product.getId(),product.getName(), product.getPrice());
        this.amount = amount;
    }
}
