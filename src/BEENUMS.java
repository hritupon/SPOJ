import java.util.Scanner;

/**
 * Created by rsaikia on 8/4/2015.
 */
public class BEENUMS {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long n=sc.nextLong();
        while(n!=-1){
            if(n==1){
                System.out.println("Y");
            }else{
                int i=2;
                long prevSum=1;
                while(true){
                    long tn=6*(i-1)+prevSum;
                    i++;
                    if(tn>n){
                        System.out.println("N");
                        break;
                    }
                    if(tn==n){
                        System.out.println("Y");
                        break;
                    }
                    prevSum=tn;
                }
            }
            n=sc.nextLong();
        }
    }
}
