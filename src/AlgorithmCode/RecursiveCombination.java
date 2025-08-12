
package AlgorithmCode;
import java.util.*;
class Combination{
    int count = 0;
    long[][] c;
    Combination(int maxN) {
        c = new long[maxN + 1][maxN + 1];
        for (int i = 0; i <= maxN; i++) {
            Arrays.fill(c[i], -1L);
        }
    }
    
    long GeneralCombination(int n, int r){
        count++;
        if (r < 0 || r > n) return 0; 
        if(r == 1) return n;
        if (r == 0 || r == n) return 1;
        
        return GeneralCombination(n-1, r-1)+GeneralCombination(n-1, r);
    }
    long MemoizedCombination(int n, int r){
        count++;
        if (r < 0 || r > n) return 0; 
        if(c[n][r]!= -1L) return c[n][r];
        if(r ==1) return c[n][r]= n;
        if(r == 0 || r == n) return c[n][r]=1L;
        
        c[n][r]=MemoizedCombination(n-1, r-1)+MemoizedCombination(n-1, r);
        return c[n][r];
    }
}
class RecursiveCombination {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("n: "); int n = sc.nextInt();
        System.out.print("r: "); int r = sc.nextInt();

        if (r < 0 || r > n) {
            System.out.println("Invalid: 0 ≤ r ≤ n");
            return;
        }

        Combination C1 = new Combination(n);
        long result1 = C1.GeneralCombination(n, r);
        System.out.println("..........General Combination............");
        System.out.println("Result: " + result1);
        System.out.println("Recursive Calls: " + C1.count);
        System.out.println();

        Combination C2 = new Combination(n);
        long result2 = C2.MemoizedCombination(n, r);
        System.out.println("\n.........Memoized Combination...........");
        System.out.println("Result: " + result2);
        System.out.println("Recursive Calls: " + C2.count);


    }
}