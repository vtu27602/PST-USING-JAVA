
import java.util.Scanner;

public class MaxProfitAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter buying price: ");
        double buy = sc.nextDouble();

        System.out.print("Enter selling price: ");
        double sell = sc.nextDouble();

        double profit = sell - buy;

        if (profit > 0) {
            System.out.println("Maximum Profit: " + profit);
        } else if (profit < 0) {
            System.out.println("Loss: " + (-profit));
        } else {
            System.out.println("No Profit No Loss");
        }

        sc.close();
    }
}

OUTPUT :
Enter buying price: 2000
Enter selling price: 2600
Maximum Profit: 600.0
