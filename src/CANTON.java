import java.util.Scanner;

/**
 * Created by rsaikia on 7/31/2015.
 */
public class CANTON {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int tt=sc.nextInt();
        while(tt>0){
            long n=sc.nextLong();
            long diag=(long)Math.ceil((Math.sqrt(8*n+1)-1)/2);
            long endPoint=((diag*diag)+diag)/2;
            long diff=0;
            if(n>endPoint){
                diff=n-endPoint;
            }else{
                diff=endPoint-n;
            }

            if(diag%2==0){
                System.out.println("TERM "+n+" IS "+(diag-diff)+"/"+(1+diff));
            }else{
                System.out.println("TERM "+n+" IS "+(1+diff)+"/"+(diag-diff));

            }
            tt--;
        }
    }
}
