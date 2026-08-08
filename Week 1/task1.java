BINARY SEARCH


import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter the elements:");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter the element to search: ");
        int key = sc.nextInt();

        int low = 0;
        int high = arr.length - 1;
        int found = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == key) {
                found = mid;
                break;
            } else if (key < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        if (found != -1) {
            System.out.println("Element found at index " + found);
        } else {
            System.out.println("Element not found");
        }

        sc.close();
    }
}


OUTPUT
Enter the size of array: 4
Enter the elements:
1 2 3  5
Enter the element to search: 3
Element found at index 2
