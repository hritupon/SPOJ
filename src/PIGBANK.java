import java.util.Scanner;

/**
 * Created by rsaikia on 8/11/2015.
 */
public class PIGBANK {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int tt=sc.nextInt();
        while (tt>0){
            int emptyWeight=sc.nextInt();
            int filledWeight=sc.nextInt();
            int maxWeight=filledWeight-emptyWeight;
            int n=sc.nextInt();
            int W[]=new int[n];
            int P[]=new int[n];

            for(int i=0;i<n;i++){
                P[i]=sc.nextInt();
                W[i]=sc.nextInt();
            }
            int max[]=new int[maxWeight+1];
            max[0]=0;
            for(int i=0;i<max.length;i++){
               max[i]=Integer.MAX_VALUE;
            }
            for(int i=1;i<=maxWeight;i++){
                for(int j=0;j<n;j++){
                    if(W[j]==i) {
                        max[i] = Math.min(max[i],P[j]);
                    }else if(i>W[j] && max[i-W[j]]!=Integer.MAX_VALUE){
                        max[i]=Math.min(max[i],max[i - W[j]]+P[j]);
                    }
                }
            }
            if(max[maxWeight]!=Integer.MAX_VALUE){
                System.out.println("The minimum amount of money in the piggy-bank is "+max[maxWeight]+".");
            }else{
                System.out.println("This is impossible.");
            }
            tt--;
        }
    }
}
