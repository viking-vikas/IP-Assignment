class BankAccount {
  private int accountNumber;
  private String accountHolder;
  private double balance;

  public BankAccount(int accountNumber, String accountHolder, double balance) {
    this.accountNumber = accountNumber;
    this.accountHolder = accountHolder;
    this.balance = balance;
  }

  public double getBalance() { return balance; }

  public void deposit(double amount) {
    if (amount > 0) {
      balance += amount;
      System.out.println("Deposited: " + amount);
      System.out.println("Updated Balance: " + balance);
    } else {
      System.out.println("Invalid deposit amount");
    }
  }

  public boolean withdraw(double amount) {
    if (amount > 0 && amount <= balance) {
      balance -= amount;
      System.out.println("Withdrawn: " + amount);
      System.out.println("Updated Balance: " + balance);
      return true;
    } else {
      System.out.println("Withdrawal failed: Insufficient balance");
      return false;
    }
  }

  public void checkBalance() {
    System.out.println("Current Balance: " + balance);
  }

  public static void main(String[] args) {
    BankAccount acc1 = new BankAccount(1001, "Amit", 5000);
    BankAccount acc2 = new BankAccount(1002, "Neha", 3000);

    System.out.println("Account 1 Transactions");
    acc1.deposit(1500);
    acc1.withdraw(2000);
    acc1.withdraw(6000);
    acc1.checkBalance();

    System.out.println("\nAccount 2 Transactions");
    acc2.deposit(1000);
    acc2.withdraw(2500);
    acc2.checkBalance();
  }
}
