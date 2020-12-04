package trackingorder;

public class OrderItem extends Product {
    private Integer amount;

    public OrderItem(Integer id, String name, Double price, Integer amount) {
        super(id, name, price);
        this.amount = amount;
    }

    public OrderItem(Product product, Integer amount) {
        super(product.getId(), product.getName(), product.getPrice());
        this.amount = amount;
    }

}
