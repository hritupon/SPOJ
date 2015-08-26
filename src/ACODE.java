import java.util.Scanner;

/**
 * Created by rsaikia on 7/30/2015.
 */
public class ACODE {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        boolean first=true;
        while((str.charAt(0)-'0')!=0){
            if(!first) System.out.println("");
            first=false;
            long[] ways=new long[str.length()];
            ways[0]=1;
            for(int i=1;i<str.length();i++){
                int curDigit=str.charAt(i)-'0';
                int prevDigit=str.charAt(i-1)-'0';
                int duelDigit=10*prevDigit+curDigit;
                if(curDigit>0){
                    ways[i]=ways[i-1];
                }
                if(duelDigit<=26 && duelDigit>9){
                    ways[i]+=(i<2?1:ways[i-2]);
                }

            }
            System.out.print(ways[str.length()-1]);
            str=sc.next();
        }
    }
}
