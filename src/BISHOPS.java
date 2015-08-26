import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by rsaikia on 8/4/2015.
 */
public class BISHOPS {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            BigInteger n=sc.nextBigInteger();
            if(n.equals(BigInteger.ONE)){
                System.out.println("1");
            }else{
                System.out.println(n.subtract(BigInteger.ONE).multiply(BigInteger.valueOf(2)));
            }
        }
    }
}
