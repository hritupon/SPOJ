import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by rsaikia on 7/30/2015.
 */
public class FASHION {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t>0){
            int n=sc.nextInt();
            int x[]=new int[n];
            int y[]=new int[n];
            for(int i=0;i<n;i++){
                x[i]=sc.nextInt();
            }
            for(int i=0;i<n;i++){
                y[i]=sc.nextInt();
            }
            Arrays.sort(x);
            Arrays.sort(y);
            long sum=0;
            for(int i=0;i<n;i++){
                sum+=x[i]*y[i];
            }
            System.out.println(sum);
            t--;
        }
    }
}
