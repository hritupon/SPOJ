import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by rsaikia on 8/4/2015.
 */
public class MAXLN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tt=sc.nextInt();
        int i=1;
        while(tt>0){
            double r=sc.nextDouble();
            double result=4*r*r+0.25;
            System.out.printf("Case %d: %.2f\n",i,result);
            tt--;
            i++;
        }
    }
}
