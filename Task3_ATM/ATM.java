import java.util.Scanner;

public class ATM {

    static double balance = 1000;

    public static void checkBalance() {

        System.out.println("Current Balance: " + balance);
    }

    public static void deposit(double amount) {

        balance += amount;
        System.out.println("Amount Deposited Successfully");
    }

    public static void withdraw(double amount) {

        if(amount > balance) {
            System.out.println("Insufficient Balance");
        } else {
            balance -= amount;
            System.out.println("Withdrawal Successful");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int choice;

        do {

            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch(choice) {

                case 1:
                    checkBalance();
                    break;

                case 2:
                    System.out.print("Enter Deposit Amount: ");
                    double deposit = sc.nextDouble();
                    deposit(deposit);
                    break;

                case 3:
                    System.out.print("Enter Withdrawal Amount: ");
                    double withdraw = sc.nextDouble();
                    withdraw(withdraw);
                    break;

                case 4:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while(choice != 4);

        sc.close();
    }
}