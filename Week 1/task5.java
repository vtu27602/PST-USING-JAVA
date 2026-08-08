import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40, 50};

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the index");

        int a = sc.nextInt();

        if (a >= 0 && a < arr.length) {
            System.out.println("Element at the index is " + arr[a]);
        } else {
            System.out.println("invalid");
        }

        sc.close();
    }
}

OUTPUT :

Enter the index 3
Element at the index is 40
