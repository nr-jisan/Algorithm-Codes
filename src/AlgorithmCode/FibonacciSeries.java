package AlgorithmCode;
import java.util.*;

class Fibonacci {
    int[] memo;
    int count = 0; 

    Fibonacci(int size) {
        memo = new int[size + 1];
        Arrays.fill(memo, -1);
    }

    int GenaralFibonacci(int n) {
        count++;
        if (n <= 0) return 0;
        if (n == 1) return 1;

        int t1 = GenaralFibonacci(n - 1);
        int t2 = GenaralFibonacci(n - 2);
        return t1 + t2;
    }

    int MemoizedFibonacci(int n) {
        count++;
        if (memo[n] >= 0) return memo[n];

        if (n == 0) {
            memo[0] = 0;
            return 0;
        }
        if (n == 1) {
            MemoizedFibonacci(0); 
            memo[1] = 1;
            return 1;
        }

        int t1 = (memo[n - 1] >= 0) ? memo[n - 1] : MemoizedFibonacci(n - 1);
        int t2 = (memo[n - 2] >= 0) ? memo[n - 2] : MemoizedFibonacci(n - 2);

        memo[n] = t1 + t2;
        return memo[n];
    }
}

public class FibonacciSeries {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = s.nextInt();

        Fibonacci F1 = new Fibonacci(n);
        int result1 = F1.GenaralFibonacci(n);
        System.out.println("..........General Fibonacci............");
        System.out.println("Result: " + result1);
        System.out.println("Recursive Calls: " + F1.count);


        Fibonacci F2 = new Fibonacci(n);
        int result2 = F2.MemoizedFibonacci(n);
        System.out.println("\n.........Memoized Fibonacci...........");
        System.out.println("Result: " + result2);
        System.out.println("Recursive Calls: " + F2.count);
        System.out.print("\nSeries: ");
        for (int i = 0; i <= n; i++) {
            System.out.print(F2.MemoizedFibonacci(i) + " ");
        }
        System.out.println();
    }
}
