import java.util.Scanner;

/**
 * Created by rsaikia on 8/13/2015.
 */
public class PIR {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int tt=sc.nextInt();
        while (tt>0){
            int ab=sc.nextInt();
            int ac=sc.nextInt();
            int ad=sc.nextInt();
            int bc=sc.nextInt();
            int bd=sc.nextInt();
            int cd=sc.nextInt();

            double cosa=cosine(ad, cd, ac);
            double cosb=cosine(bd, cd, bc);
            double cosc=cosine(ad, bd, ab);
            double result=Math.sqrt(1 + 2 * cosa * cosb * cosc - cosa * cosa - cosb * cosb - cosc * cosc);
            result=ad*bd*cd*result/6;
            System.out.printf("%.4f\n",result);
            tt--;
        }
    }
    public static double cosine(int a, int b, int c){
        return (double)(a*a+b*b-c*c)/(2.0*a*b);
    }
}
