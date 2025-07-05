import java.util.ArrayList;
import java.util.List;

public class Cart {
     private final List<CartItem > items = new ArrayList<>();

    public void addItem(Product product, int quantity) {
        items.add(new CartItem(product, quantity));
        product.reduceQuantity(quantity);
    }

    public List<CartItem> getItems() {
        return items;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public double getSubtotal() {
        return items.stream().mapToDouble(CartItem::getTotalPrice).sum();
    }

    public double getShippingFee() {
        return items.stream()
                .filter(item -> item.getProduct().isShippable())
                .mapToDouble(item -> item.getProduct().getWeight() * 10)
                .sum();
    }

    public double getTotalAmount() {
        return getSubtotal() + getShippingFee();
    }

    public List<Shippable> getShippableItems() {
        List<Shippable> shippables = new ArrayList<>();
        for (CartItem item : items) {
            Product p = item.getProduct();
            if (p.isShippable()) {
                shippables.add(new Shippable() {
                    public String getName() { return p.getName(); }
                    public double getWeight() { return p.getWeight(); }
                });
            }
        }
        return shippables;
    }
}
