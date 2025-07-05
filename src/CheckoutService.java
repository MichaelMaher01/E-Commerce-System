import java.util.List;

public class CheckoutService {
    private final ShippingService shippingService;

    public CheckoutService(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    public void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) throw new IllegalStateException("Cart is empty.");

        double totalAmount = cart.getTotalAmount();
        if (customer.getAccountBalance() < totalAmount) throw new IllegalStateException("Customer has insufficient balance.");

        customer.deductBalance(totalAmount);

        List<Shippable> toShip = cart.getShippableItems();
        if (!toShip.isEmpty()) {
            shippingService.shipItems(toShip);
        }

        System.out.println("--- Checkout Summary ---");
        System.out.println("Subtotal: " + cart.getSubtotal());
        System.out.println("Shipping Fee: " + cart.getShippingFee());
        System.out.println("Total Paid: " + totalAmount);
        System.out.println("Remaining Balance: " + customer.getAccountBalance());


    }
}
