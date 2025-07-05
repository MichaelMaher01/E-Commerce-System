public class CartItem {

    private final Product product ;
    private final int quantity ;



    public CartItem(Product product, int quantity) {
        if (quantity <= 0 || quantity > product.getQuantity()) {
            throw new IllegalArgumentException("Invalid quantity for product: " + product.getName());
        }
        if (product.isExpirable() && product.isExpired()) {
            throw new IllegalStateException("Cannot add expired product: " + product.getName());
        }
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
    public double getTotalPrice() {
        return product.getPrice() * quantity;
    }


}
