import java.util.List;

public class ShippingService {
    public void shipItems(List<Shippable> items) {
        System.out.println("Shipping the following items:");
        for (Shippable item : items) {
            System.out.println("- " + item.getName() + " (" + item.getWeight() + " kg)");
        }
    }
}
