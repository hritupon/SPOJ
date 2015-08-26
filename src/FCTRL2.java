import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by rsaikia on 7/30/2015.
 */
public class FCTRL2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t>0){
            int n=sc.nextInt();
            BigInteger result=factorial(BigInteger.valueOf(n));
            System.out.println(result.toString());
               t--;
        }
    }
    public static BigInteger factorial(BigInteger n){
        if(n.compareTo(BigInteger.ONE)<=0) {
            return BigInteger.ONE;
        }
        return n.multiply(factorial(n.subtract(BigInteger.ONE)));

    }
}
