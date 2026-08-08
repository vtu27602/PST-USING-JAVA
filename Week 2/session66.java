public class Main {
    public static void main(String[] args) {

        int[][] accounts = {
            {1, 2, 3},
            {3, 2, 1}
        };

        int richest = 0;

        for (int i = 0; i < accounts.length; i++) {

            int wealth = 0;

            for (int j = 0; j < accounts[i].length; j++) {
                wealth = wealth + accounts[i][j];
            }

            if (wealth > richest) {
                richest = wealth;
            }
        }

        System.out.println("Richest Customer Wealth: " + richest);
    }
}

Input: accounts = [[1,5],[7,3],[3,5]]
Output: 10
