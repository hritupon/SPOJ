import javax.security.sasl.SaslServer;
import java.util.Scanner;

/**
 * Created by rsaikia on 7/31/2015.
 */
public class FENCE1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        boolean first=true;
        while(n!=0){
            Double result=0.5*n*n*(1/3.14159);
            if(!first) System.out.println("");
            first=false;
            System.out.printf("%.2f",result);
            n=sc.nextInt();
        }
    }
}
