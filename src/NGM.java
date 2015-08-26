import java.util.Scanner;

/**
 * Created by rsaikia on 8/3/2015.
 */
public class NGM {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int moves=n%10;
        if(moves!=0){
            System.out.println("1\n"+moves);
        }else{
            System.out.println("2");
        }
    }
}
