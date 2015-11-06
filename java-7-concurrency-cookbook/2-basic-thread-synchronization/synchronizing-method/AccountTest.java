public class AccountTest {

    public static void main(String[] args) {
        // shared account
        Account account = new Account();
        account.setBalance(1000);

        Company company = new Company(account);
        Thread companyThread = new Thread(company);

        Bank bank = new Bank(account);
        Thread bankThread = new Thread(bank);

        System.out.printf("Account: Initial Balance: %f\n", account.getBalance());
        // Start the threads
        companyThread.start();
        bankThread.start();

        try {
            // wait for the finalization of the two threads using the join method
            companyThread.join(); // 100 calls to addAmount
            bankThread.join(); // 100 calls to subtractAmount
            // final and initial balances should be equal
            System.out.printf("Account: Final Balance: %f\n", account.getBalance());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
