import java.util.Scanner;

/**
 * Created by rsaikia on 8/4/2015.
 */
public class CRDS {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int tt=sc.nextInt();
        while (tt>0){
            long n=sc.nextLong();
            long result=(3*n*n+n)/2;
            result=result%1000007;
            System.out.println(result);
            tt--;
        }
    }
}
