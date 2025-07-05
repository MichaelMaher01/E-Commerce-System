import java.time.LocalDate;

public class Product {
    private final String name ;
    private double price ;
    private int quantity ;
    private final boolean expirable ;
    private LocalDate expiryDate ;

    private final boolean shippable ;
    private double weight ;


    public Product(String name, double price, int quantity, boolean expirable,
                   LocalDate expiryDate, boolean shippable, double weight) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.expirable = expirable;
        this.expiryDate = expiryDate;
        this.shippable = shippable;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isExpirable() {
        return expirable;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public boolean isShippable() {
        return shippable;
    }

    public double getWeight() {
        return weight;
    }


    public void setPrice(double price) {
        if (price <= 0) throw new IllegalArgumentException("Price must be greater than 0.");
        this.price = price;
    }

    public void setWeight(double weight) {
        if (weight < 0) throw new IllegalArgumentException("Weight must be positive.");
        this.weight = weight;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void increaseQuantity(int amount) {
        if (amount < 0) throw new IllegalArgumentException("Amount must be positive.");
        this.quantity += amount;
    }

    public void reduceQuantity(int amount) {
        if (quantity >= amount){
            quantity -= amount;
        }
        else throw new IllegalArgumentException("Not enough stock for this product: " + name);
    }
    public boolean isExpired() {
        if (!expirable || expiryDate == null){
            return false;
        }
        return expiryDate.isBefore(LocalDate.now());
    }
}
