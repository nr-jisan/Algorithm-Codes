package AlgorithmCode;
import java.util.*;

class Power {
    int count1 = 0;
    int count2 = 0;

    long GeneralPower(long base, long pow) {
        count1++;
        if (pow == 0) return 1L;
        if (pow == 1) return base;
        return base * GeneralPower(base, pow - 1);
    }

    long EfficientPower(long base, long pow) {
        count2++;
        if (pow == 0) return 1L;
        if (pow == 1) return base;

        long half = EfficientPower(base, pow / 2);
        if (pow % 2 == 0) {
            return half * half;
        } else {
            return base * half * half;
        }
    }
}

public class PowerProblem {
    public static void main(String[] args) {
        Power p = new Power();
        Scanner s = new Scanner(System.in);

        System.out.println("......Power Calculator........");

        System.out.print("Enter Base: ");
        long base = s.nextLong();

        System.out.print("Enter Power: ");
        long pow = s.nextLong();

        System.out.println("\nIn General Formula: ");
        System.out.println("Result: " + p.GeneralPower(base, pow));
        System.out.println("Recursive Call: " + p.count1 + " Times");

        System.out.println("\nIn Efficient Formula: ");
        System.out.println("Result: " + p.EfficientPower(base, pow));
        System.out.println("Recursive Call: " + p.count2 + " Times");

        s.close();
    }
}
