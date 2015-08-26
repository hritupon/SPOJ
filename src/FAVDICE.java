import java.util.Scanner;

/**
 * Created by rsaikia on 8/26/2015.
 */
public class FAVDICE {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int tt=sc.nextInt();
        while (tt-->0){
            int n=sc.nextInt();
            double sum=0;
            for(int i=1;i<=n;i++){
                sum+=((double)(n)/(double)(i));
            }
            System.out.printf("%.2f\n",sum);
        }
    }
}
