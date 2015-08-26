import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by rsaikia on 8/4/2015.
 */
public class OFFSIDE {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int A=sc.nextInt();
        int D=sc.nextInt();
        while(A!=0 && D!=0){
            int[] As=new int[A];
            int[] Ds=new int[D];
            for(int i=0;i<A;i++){
                As[i]=sc.nextInt();
            }
            for(int i=0;i<D;i++){
                Ds[i]=sc.nextInt();
            }
            Arrays.sort(As);
            Arrays.sort(Ds);

            if(As[0]<Ds[1]){
                System.out.println("Y");
            }else{
                System.out.println("N");
            }

            A=sc.nextInt();
            D=sc.nextInt();
        }

    }
}
