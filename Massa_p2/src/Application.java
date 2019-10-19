public class Application {
    public static void main(String args[]) {
        SavingsAccount saver1 = new SavingsAccount();
        SavingsAccount saver2 = new SavingsAccount();
        double interest;

        saver1.setSavingsBalance(2000.00);
        saver2.setSavingsBalance(3000.00);

        saver1.modifyInterestRate(0.04);
        saver2.modifyInterestRate(0.04);

        interest = saver1.calculateMonthlyInterest(saver1.getSavingsBalance());

        saver1.printBothMonthlyWithInterest(interest, saver1, saver2);

        System.out.println();

        saver1.modifyInterestRate(0.05);
        saver2.modifyInterestRate(0.05);

        interest = saver1.calculateMonthlyInterest(saver1.getSavingsBalance());

        saver1.printBothMonthlyWithInterest(interest, saver1, saver2);
    }
}

