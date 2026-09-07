import java.util.Scanner;

public class BankingTransactionSystem {

    static double balance = 0;

    static void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount deposited successfully.");
            System.out.println("Current Balance: ₹" + balance);
        } else {
            System.out.println("Invalid amount.");
        }
    }

  
    static void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("Amount withdrawn successfully.");
            System.out.println("Current Balance: ₹" + balance);
        }
    }

    static void checkBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int choice;

        do {
            System.out.println("\n===== BANKING TRANSACTION SYSTEM =====");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter deposit amount: ₹");
                    double depositAmount = sc.nextDouble();
                    deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter withdrawal amount: ₹");
                    double withdrawAmount = sc.nextDouble();
                    withdraw(withdrawAmount);
                    break;

                case 3:
                    checkBalance();
                    break;

                case 4:
                    System.out.println("Thank you for using Banking Transaction System.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 4);

        sc.close();
    }
}




OUTPUT :
===== BANKING TRANSACTION SYSTEM =====
1. Deposit Money
2. Withdraw Money
3. Check Balance
4. Exit
Enter your choice: 1
Enter deposit amount: ?3000
Amount deposited successfully.
Current Balance: ?3000.0

===== BANKING TRANSACTION SYSTEM =====
1. Deposit Money
2. Withdraw Money
3. Check Balance
4. Exit
Enter your choice: 2
Enter withdrawal amount: ?150
Amount withdrawn successfully.
Current Balance: ?2850.0

===== BANKING TRANSACTION SYSTEM =====
1. Deposit Money
2. Withdraw Money
3. Check Balance
4. Exit
Enter your choice: 
