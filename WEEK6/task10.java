import java.util.*;

public class Solution {

    public static void matrixRotation(List<List<Integer>> matrix, int r) {

        int m = matrix.size();
        int n = matrix.get(0).size();

        int layers = Math.min(m, n) / 2;

        for (int layer = 0; layer < layers; layer++) {

            List<Integer> elements = new ArrayList<>();

            int top = layer;
            int bottom = m - layer - 1;
            int left = layer;
            int right = n - layer - 1;

            // Top row
            for (int j = left; j <= right; j++) {
                elements.add(matrix.get(top).get(j));
            }

            // Right column
            for (int i = top + 1; i <= bottom; i++) {
                elements.add(matrix.get(i).get(right));
            }

            // Bottom row
            for (int j = right - 1; j >= left; j--) {
                elements.add(matrix.get(bottom).get(j));
            }

            // Left column
            for (int i = bottom - 1; i > top; i--) {
                elements.add(matrix.get(i).get(left));
            }

            int len = elements.size();
            int rotation = r % len;

            int index = 0;

            // Top row
            for (int j = left; j <= right; j++) {
                matrix.get(top).set(j,
                        elements.get((rotation + index++) % len));
            }

            // Right column
            for (int i = top + 1; i <= bottom; i++) {
                matrix.get(i).set(right,
                        elements.get((rotation + index++) % len));
            }

            // Bottom row
            for (int j = right - 1; j >= left; j--) {
                matrix.get(bottom).set(j,
                        elements.get((rotation + index++) % len));
            }

            // Left column
            for (int i = bottom - 1; i > top; i--) {
                matrix.get(i).set(left,
                        elements.get((rotation + index++) % len));
            }
        }

        // Print matrix
        for (List<Integer> row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();
        int r = sc.nextInt();

        List<List<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < m; i++) {

            List<Integer> row = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                row.add(sc.nextInt());
            }

            matrix.add(row);
        }

        matrixRotation(matrix, r);

        sc.close();
    }
}
input:
4 4 2
1 2 3 4
5 6 7 8
9 10 11 12
13 14 15 16
output:
3 4 8 12
2 11 10 16
1 7 6 15
5 9 13 14
