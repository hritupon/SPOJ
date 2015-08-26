import java.util.Scanner;

public class TEST {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int budget=sc.nextInt();
        int parties=sc.nextInt();
        while(budget!=0 && parties!=0) {
            int[] weights = new int[parties + 1];
            int[] values = new int[parties + 1];
            for (int i = 1; i <= parties; i++) {
                values[i] = sc.nextInt();
                weights[i] = sc.nextInt();

            }
            int matrix[][] = new int[100][100];
            System.out.printf("Max value = %dn", knapsack(parties - 1, budget, weights, values, matrix));
            budget=sc.nextInt();
            parties=sc.nextInt();
        }
    }

    public static int knapsack(int index, int size, int weights[], int values[], int matrix[][]) {
        int take, dontTake;

        take = dontTake = 0;

        if (matrix[index][size] != 0)
            return matrix[index][size];

        if (index == 0) {
            if (weights[0] <= size) {
                matrix[index][size] = values[0];
                return values[0];
            } else {
                matrix[index][size] = 0;
                return 0;
            }
        }

        if (weights[index] <= size) {
            take = values[index] + knapsack(index - 1, size - weights[index], weights, values, matrix);
        }
        dontTake = knapsack(index - 1, size, weights, values, matrix);

        matrix[index][size] = Math.max(take, dontTake);

        return matrix[index][size];
    }
}