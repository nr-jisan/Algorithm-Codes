package AlgorithmCode;
import java.util.*;

class LCS {
    int count = 0;
    int[][] l;
    int[][] dp;

    LCS(int m, int n) {
        l = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) Arrays.fill(l[i], -1);
    }

    int GeneralLCS(char[] A, char[] B, int m, int n) {
        count++;
        if (m == 0 || n == 0) return (l[m][n] = 0);
        if (A[m - 1] == B[n - 1]) {
            return 1 + GeneralLCS(A, B, m - 1, n - 1);
        } else {
            int t2 = GeneralLCS(A, B, m, n - 1);
            int t3 = GeneralLCS(A, B, m - 1, n);
            return Math.max(t2, t3);
        }
    }

    int MemoizedLCS(char[] A, char[] B, int m, int n) {
        count++;
        if (l[m][n] != -1) return l[m][n];
        if (m == 0 || n == 0) return (l[m][n] = 0);

        if (A[m - 1] == B[n - 1]) {
            return l[m][n] = 1 + MemoizedLCS(A, B, m - 1, n - 1);
        } else {
            int t2 = MemoizedLCS(A, B, m, n - 1);
            int t3 = MemoizedLCS(A, B, m - 1, n);
            return l[m][n] = Math.max(t2, t3);
        }
    }

    // Build DP table and keep it in the field `dp`
    int DynamicLCS(char[] A, char[] B, int m, int n) {
        dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;  
                } else if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    void printLCSString(char[] A, char[] B, int m, int n) {
        int total = DynamicLCS(A, B, m, n); 
        char[] lcsChars = new char[total];
        int i = m, j = n, k = total;

        while (i > 0 && j > 0) {
            if (A[i - 1] == B[j - 1]) {
                lcsChars[k - 1] = A[i - 1]; 
                i--; j--; k--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        System.out.print("LCS String: ");
        for (char c : lcsChars) System.out.print(c);
        System.out.println();
    }
}

public class LongestCommonSubSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String s1 = sc.nextLine();
        System.out.print("Enter second string: ");
        String s2 = sc.nextLine();

        char[] A = s1.toCharArray();
        char[] B = s2.toCharArray();
        int m = A.length, n = B.length;

        // ----- General LCS -----
        LCS L1 = new LCS(m, n);
        int result1 = L1.GeneralLCS(A, B, m, n);
        System.out.println("..........General LCS............");
        System.out.println("Length: " + result1);
        System.out.println("Recursive Calls: " + L1.count);

        // ----- Memoized LCS -----
        LCS L2 = new LCS(m, n);
        int result2 = L2.MemoizedLCS(A, B, m, n);
        System.out.println("\n.........Memoized LCS...........");
        System.out.println("Length: " + result2);
        System.out.println("Recursive Calls: " + L2.count);

        // ----- Dynamic Programming (bottom-up) + LCS string -----
        LCS L3 = new LCS(m, n);
        int result3 = L3.DynamicLCS(A, B, m, n);
        System.out.println("\n.........Dynamic LCS (Bottom-up)...........");
        System.out.println("Length: " + result3);
        L3.printLCSString(A, B, m, n);
    }
}
