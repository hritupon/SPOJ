import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by rsaikia on 8/5/2015.
 */
public class AGGRCOW {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int tt=sc.nextInt();
        while (tt>0){
            int n=sc.nextInt();
            int c=sc.nextInt();
            int[] arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            Arrays.sort(arr);

            tt--;
        }
    }
}
