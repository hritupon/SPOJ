import java.util.Scanner;

/**
 * Created by rsaikia on 7/31/2015.
 */
public class WILLITST {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long n=sc.nextLong();
        if((n & (n-1))==0){
            System.out.println("TAK");
        }else{
            System.out.println("NIE");
        }
    }
}
