import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by rsaikia on 7/30/2015.
 */
public class JULKA {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<10;i++){
            BigInteger sum=sc.nextBigInteger();
            BigInteger excess=sc.nextBigInteger();
            BigInteger tmp=sum.subtract(excess);
            BigInteger y=tmp.divide(BigInteger.valueOf(2));
            BigInteger x=excess.add(y);
            System.out.println(x+"\n"+y);
        }
    }
}
