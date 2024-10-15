import java.util.Scanner;

public class Knapsack {

    // Method to solve the 0-1 Knapsack problem
    public static int knapsack(int capacity, int[] weights, int[] values, int n) {
        // Create a 2D array to store the maximum value for each capacity
        int[][] dp = new int[n + 1][capacity + 1];

        // Build the dp array
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= capacity; w++) {
                // If the weight of the current item is less than or equal to the capacity
                if (weights[i - 1] <= w) {
                    // Choose the maximum value between including the item and excluding it
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weights[i - 1]] + values[i - 1]);
                } else {
                    // Exclude the current item
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        
        // The last cell contains the maximum value that can be achieved with the given capacity
        return dp[n][capacity];
    }

    // Main method to take user input and execute the Knapsack algorithm
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the number of items from the user
        System.out.print("Enter the number of items: ");
        int n = scanner.nextInt();

        // Get the weights and values of the items
        int[] weights = new int[n];
        int[] values = new int[n];

        System.out.println("Enter the weights of the items:");
        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextInt();
        }

        System.out.println("Enter the values of the items:");
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
        }

        // Get the capacity of the knapsack
        System.out.print("Enter the capacity of the knapsack: ");
        int capacity = scanner.nextInt();

        // Calculate the maximum value that can be achieved
        int maxValue = knapsack(capacity, weights, values, n);

        // Output the result
        System.out.println("The maximum value that can be achieved is: " + maxValue);

        // Closing the scanner
        scanner.close();
    }
}
