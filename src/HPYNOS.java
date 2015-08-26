import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by rsaikia on 8/5/2015.
 */
public class HPYNOS {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long tt=sc.nextLong();
        HashMap<Long,Long>memoize=new HashMap<Long,Long>();
        long sum=digSqSum(tt);
        long counter=1;
        while(sum!=1){
            counter++;
            if(memoize.containsKey(sum)){
                System.out.println("-1");
                return;
            }
            long result=digSqSum(sum);
            memoize.put(sum,result);
            sum=result;
        }
        System.out.println(counter);
    }
    private static long digSqSum(long num){
        long sum=0;
        while(num>0){
            long digit=num%10;
            sum+=digit*digit;
            num=num/10;
        }
        return sum;
    }
}
