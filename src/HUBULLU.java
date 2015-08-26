import java.util.Scanner;

/**
 * Created by rsaikia on 8/5/2015.
 */
public class HUBULLU {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long tt=sc.nextLong();
        while (tt>0){
            long n=sc.nextLong();
            int x=sc.nextInt();
            if(x==0){
                System.out.println("Airborne wins.");
            }else{
                System.out.println("Pagfloyd wins.");
            }
            tt--;
        }
    }
}
