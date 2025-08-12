
package AlgorithmCode;

import java.util.*;

class Factorial{
    long Recfactorial(long n){
        if(n==1||n==0) return 1;
        else
            return n*Recfactorial(n-1);
    }
}
public class RecursiveFactorial {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Factorial f = new Factorial();
        
        System.out.println(".....Factorial Calculator......");
        System.out.print("\nEnter The Number: ");
        long number = s.nextLong();
        System.out.println("Factorial of "+number+" is = "+ f.Recfactorial(number));
    }
}
