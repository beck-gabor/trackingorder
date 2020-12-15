package trackingorder;

import java.nio.file.attribute.AclFileAttributeView;

public class OrderItem extends Product {
    private final Integer amount;
    static final Integer AFA_percent=   25;

    public OrderItem(Integer id, String name, Double price, Integer amount) {
        super(id, name, price);
        this.amount = amount;
    }

    public OrderItem(Product product, Integer amount) {
        super(product.getId(), product.getName(), product.getPrice());
        this.amount = amount;
    }

    public Integer getAmount() {
        return this.amount;
    }

    public Double getFullPrice(){
        return amount * ( super.getPrice() * ( 1 + ( AFA_percent * .01 ) ));
    }

}
