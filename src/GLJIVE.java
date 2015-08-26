import java.util.Scanner;

/**
 * Created by rsaikia on 8/24/2015.
 */
public class GLJIVE {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] vals=new int[11];
        for(int i=0;i<10;i++){
            vals[i]=sc.nextInt();
        }
        int sum=0;
        int prev=0;
        boolean foundResult=false;
        for(int i=0;i<10;i++){
            prev=sum;
            sum+=vals[i];
            if(sum>=100){
                int firstDiff=100-prev;
                int curDiff=sum-100;
                if(firstDiff==curDiff){
                    System.out.println(sum);
                }
                else if(firstDiff<curDiff){
                    System.out.println(prev);
                }else{
                    System.out.println(sum);
                }
                foundResult=true;
                break;
            }
        }
        if(!foundResult){
            System.out.println(sum);
        }

    }
}
