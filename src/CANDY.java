import java.util.Scanner;

/**
 * Created by rsaikia on 7/30/2015.
 */
public class CANDY {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t!=-1){
            int[] arr=new int[t];
            int sum=0;
            for(int j=0;j<t;j++){
                arr[j]=sc.nextInt();
                sum+=arr[j];
            }
            if(sum%t!=0){
                System.out.println(-1);
            }
            else{
                int avg=sum/t;
                int move=0;
                for(int i=0;i<t;i++){
                    if(arr[i]>avg){
                        move+=arr[i]-avg;
                    }
                }
                System.out.println(move);

            }
            t=sc.nextInt();
        }
    }
}
