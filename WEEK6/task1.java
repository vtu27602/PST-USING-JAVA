import java.io.*;
import java.util.*;

public class Solution {

    public static long stringSimilarity(String s) {
        int n = s.length();
        long result = 0;

        for (int i = 0; i < n; i++) {
            int j = 0;

            while (i + j < n && s.charAt(j) == s.charAt(i + j)) {
                j++;
            }

            result += j;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            System.out.println(stringSimilarity(s));
        }

        sc.close();
    }
}
output:
2
ababaa
aa
