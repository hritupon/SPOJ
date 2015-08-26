import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by rsaikia on 7/30/2015.
 */
public class CANDY3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t>0){
            int n=sc.nextInt();
            BigInteger sum=BigInteger.ZERO;
            for(int i=0;i<n;i++){
                BigInteger next=sc.nextBigInteger();
                sum=sum.add(next);
            }
            if(sum.mod(BigInteger.valueOf(n)).equals(BigInteger.ZERO)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
            t--;
        }
    }
}
