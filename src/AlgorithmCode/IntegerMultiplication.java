package AlgorithmCode;
import java.util.*;

class INTMultiplication {
    int count = 0;

    long GeneralMultiplication(long x, long y, int n) {
        count++;
        long m, p, q, r, s, a, b, c, d;

        if (n == 1) return x * y;

        if (n % 2 == 0) {
            m = n / 2;
        } else {
            m = (n + 1) / 2;
        }

        a = x / (long) Math.pow(10, m);
        b = x % (long) Math.pow(10, m);
        c = y / (long) Math.pow(10, m);
        d = y % (long) Math.pow(10, m);

        p = GeneralMultiplication(a, c, (int) m);
        q = GeneralMultiplication(a, d, (int) m);
        r = GeneralMultiplication(b, c, (int) m);
        s = GeneralMultiplication(b, d, (int) m);

        return (long) Math.pow(10, 2 * m) * p + (long) Math.pow(10, m) * (q + r) + s;
    }

    long EffeciantMultiplication(long x, long y, int n) {
        count++;
        long m, p, s, a, b, c, d;

        if (n == 1) return x * y;

        if (n % 2 == 0) {
            m = n / 2;
        } else {
            m = (n + 1) / 2;
        }

        a = x / (long) Math.pow(10, m);
        b = x % (long) Math.pow(10, m);
        c = y / (long) Math.pow(10, m);
        d = y % (long) Math.pow(10, m);

        p = EffeciantMultiplication(a, c, (int) m);
        s = EffeciantMultiplication(b, d, (int) m);
        long t = EffeciantMultiplication(a - b, c - d, (int) m);

        return (long) Math.pow(10, 2 * m) * p + (long) Math.pow(10, m) * (p + s - t) + s;
    }
}

public class IntegerMultiplication {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter first number (x): ");
        long x = s.nextLong();

        System.out.print("Enter second number (y): ");
        long y = s.nextLong();

        int n = Math.max(Long.toString(x).length(), Long.toString(y).length());

        INTMultiplication M1 = new INTMultiplication();
        long result1 = M1.GeneralMultiplication(x, y, n);
        System.out.println("..........General Multiplication............");
        System.out.println("Result: " + result1);
        System.out.println("Recursive Calls: " + M1.count);

        INTMultiplication M2 = new INTMultiplication();
        long result2 = M2.EffeciantMultiplication(x, y, n);
        System.out.println("\n.........Efficient Multiplication...........");
        System.out.println("Result: " + result2);
        System.out.println("Recursive Calls: " + M2.count);
    }
}
