public class Customer {
    private final String name;
    private double accountBalance;

    public Customer(String name, double accountBalance) {
        this.name = name;
        this.accountBalance = accountBalance;
    }

    public String getName() {
        return name;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        if (accountBalance < 0){
                throw new IllegalArgumentException("Balance must be positive");
        }
        this.accountBalance = accountBalance;
    }
    public void deductBalance(double amount) {
        if (accountBalance < amount){
            throw new IllegalStateException("Not enough money ");
        }

        accountBalance -= amount;
    }


}
