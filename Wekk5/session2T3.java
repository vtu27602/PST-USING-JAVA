import java.io.*;
import java.util.*;

public class Solution {

    public static int[] maxSubarray(int[] arr) {

        int maxSubarray = arr[0];
        int currentSum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            maxSubarray = Math.max(maxSubarray, currentSum);
        }
        int maxSubsequence = 0;
        int largestNegative = arr[0];
        boolean hasPositive = false;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] > 0) {
                maxSubsequence += arr[i];
                hasPositive = true;
            }

            largestNegative = Math.max(largestNegative, arr[i]);
        }

        if (!hasPositive) {
            maxSubsequence = largestNegative;
        }

        return new int[]{maxSubarray, maxSubsequence};
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();

            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int[] result = maxSubarray(arr);

            System.out.println(result[0] + " " + result[1]);
        }

        sc.close();
    }
}

INPUT :
2
4
1 2 3 4
6
2 -1 2 3 4 -5
  OUTPUT :
10 10
10 11
