import java.time.LocalDate;

public class Main {

    public static void main(String [] args){
        Product tv = new Product("TV", 5000, 2, false, null, true, 10);
        Product cheese = new Product("Cheese", 100, 5, true, LocalDate.now().plusDays(5), true, 2);
        Product scratchCard = new Product("Mobile Card", 50, 10, false, null, false, 0);

        Customer customer = new Customer("Michael", 10000);
        Cart cart = new Cart();

        cart.addItem(tv, 1);
        cart.addItem(cheese, 2);
        cart.addItem(scratchCard, 1);

        CheckoutService checkoutService = new CheckoutService(new ShippingService());
        checkoutService.checkout(customer, cart);

    }
}
