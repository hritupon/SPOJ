import java.util.Scanner;

/**
 * Created by rsaikia on 8/3/2015.
 */
public class GIRLSNBS {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        int y=sc.nextInt();
        while(x!=-1 && y!=-1){
            int min=x>y?y:x;
            int max=x<=y?y:x;
            int div=max / (min+1) + (max % (min+1) > 0?1:0);
            System.out.println(div);
            x=sc.nextInt();
            y=sc.nextInt();
        }
    }
}
