# E-Commerce-System
Java-based e-commerce system for internship challenge. Supports product expiration, shipping calculation, cart management, and customer checkout with validations.
#  E-Commerce System - Internship Challenge



##  Features

- Product Definition
  - Each product has a name, price, quantity, and may optionally have:
    - An expiry date (e.g., Cheese, Biscuits)
    - Shippable weight (e.g., TV, Cheese)
- Cart Management
  - Customers can add products to their cart in specific quantities.
  - Prevents adding more items than available or expired products.
- Checkout Flow
  - Validates:
    - Cart is not empty
    - Products are in stock and not expired
    - Customer has enough balance
  - Calculates and displays:
    - Subtotal of items
    - Shipping fee (based on weight)
    - Total amount paid
    - Remaining customer balance
- Shipping Service
  - Collects all shippable items and prints a shipping summary via a `ShippingService`.
  - Uses a custom `Shippable` interface as required in the assignment.

##  Technologies

- Language: Java
- Concepts: OOP (Encapsulation, Abstraction, Inheritance, Polymorphism), Interface-based design

##  Business Logic

- Products with expiry are not allowed in cart if expired.
- Shipping cost = `10 currency units per kg`
- Products that require shipping implement or are wrapped as `Shippable`.

##  Example Execution

```java
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
