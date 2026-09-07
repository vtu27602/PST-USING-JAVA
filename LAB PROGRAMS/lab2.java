import java.util.*;

public class StreamAnalytics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = 0;
        double sum = 0;

        System.out.println("Real-Time Stream Analytics");

        while (true) {
            System.out.print("Enter value (-1 to stop): ");
            double value = sc.nextDouble();

            if (value == -1) {
                break;
            }

            count++;
            sum += value;

            System.out.println("Count: " + count);
            System.out.println("Average: " + (sum / count));
        }

        System.out.println("Total Events: " + count);
        System.out.println("Final Average: " + (sum / count));

        sc.close();
    }
}

OUTPUT :
Real-Time Stream Analytics
Enter value (-1 to stop): 3
Count: 1
Average: 3.0
Enter value (-1 to stop): -1
Total Events: 1
Final Average: 3.0
