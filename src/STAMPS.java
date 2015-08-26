import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by rsaikia on 7/31/2015.
 */
public class STAMPS {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int tt=sc.nextInt();
        int counter=1;
        while(tt>0){
            long lucyNeeds=sc.nextLong();
            int friends=sc.nextInt();
            int[] friendArr=new int[friends];
            for(int i=0;i<friends;i++){
                friendArr[i]=sc.nextInt();
            }
            Arrays.sort(friendArr);
            int needFriends=0;
            long sum=0;
            for(int i=friends-1;i>=0;i--){
                sum+=friendArr[i];
                needFriends++;
                if(sum>=lucyNeeds){
                    break;
                }
            }
            System.out.println("Scenario #"+counter+":");
            if(sum<lucyNeeds){
                System.out.println("impossible");
            }else{
                System.out.println(needFriends);

            }
            System.out.println("");
            counter++;
            tt--;
        }
    }
}
