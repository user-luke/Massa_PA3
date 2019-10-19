public class SavingsAccount {

    private static double annualInterestRate;
    private double savingsBalance;


    public static void modifyInterestRate(double newRate) {

        annualInterestRate = newRate;

        return;
    }

    public double calculateMonthlyInterest(double savingsBalance) {
        double interest;

        interest = (savingsBalance * annualInterestRate) / 12;

        return interest;
    }

    public double getSavingsBalance() {

        return this.savingsBalance;

    }

    public void setSavingsBalance(double balance) {
        this.savingsBalance = balance;

    }

    public void addToSavingsBalance(double amount) {
        this.savingsBalance = this.savingsBalance + amount;

    }

    public void printBalance() {
        System.out.printf("%.2f", this.savingsBalance);

        return;
    }

    public void printBothMonthlyWithInterest(double interest, SavingsAccount account1, SavingsAccount account2) {
        for (int i = 1; i <= 12; i++) {
            account1.addToSavingsBalance(interest);
            account2.addToSavingsBalance(interest);
            System.out.printf("At month %d, saver1's savingsBalance is: %.2f and saver2's is: %.2f\n", i, account1.getSavingsBalance(), account2.getSavingsBalance());

        }
    }
}