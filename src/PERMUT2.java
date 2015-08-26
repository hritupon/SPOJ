import java.util.Scanner;

/**
 * Created by rsaikia on 7/31/2015.
 */
public class PERMUT2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int tt=sc.nextInt();
        while(tt!=0){
            int arr[]=new int[tt+1];
            for(int i=1;i<=tt;i++){
                arr[i]=sc.nextInt();
            }
            boolean notAmbiguous=false;
            for(int i=1;i<=tt;i++){
                if(arr[arr[i]]!=i){
                    notAmbiguous=true;
                }
            }
            if(notAmbiguous){
                System.out.println("not ambiguous");
            }else{
                System.out.println("ambiguous");
            }
            tt=sc.nextInt();
        }
    }
}
