import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by rsaikia on 8/24/2015.
 */
public class DANGER {
    public static void main(String[] args)throws Exception{
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        String str=in.readLine();
        while (!str.equals("00e0"))
        {
            int firstDigit=str.charAt(0)-'0';
            int secondDigit=str.charAt(1)-'0';
            int val=firstDigit*10+secondDigit;
            int zeros=str.charAt(3)-'0';
            long actualZeros=(long)Math.pow(10,zeros);
            long n=val*actualZeros;
            long tmp=isPowerOfTwo(n)?n:nearestPower2(n);
            long l=n-tmp;
            long result=2*l+1;
            System.out.println(result);
            str=in.readLine();
        }
    }
    private static long nearestPower2(long n){
        int pow=(int)(Math.ceil(Math.log(n)/Math.log(2)));
        long result=(long)Math.pow(2,pow-1);
        return result;
    }
    private static boolean isPowerOfTwo(long n){
        long result=n&(n-1);
        if(result==0) {
            return true;
        }else{
            return false;
        }
    }
}
