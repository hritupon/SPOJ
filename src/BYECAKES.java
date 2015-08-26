import java.util.Scanner;

/**
 * Created by rsaikia on 8/26/2015.
 */
public class BYECAKES {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int e=sc.nextInt();
        while(e!=-1){
            int f=sc.nextInt();
            int s=sc.nextInt();
            int m=sc.nextInt();

            int _e=sc.nextInt();
            int _f=sc.nextInt();
            int _s=sc.nextInt();
            int _m=sc.nextInt();

            int maxPossible=0;

            int eCount=(int)Math.ceil((double)(e)/(double)_e);
            if(eCount>maxPossible){
                maxPossible=eCount;
            }
            int fCount=(int)Math.ceil((double)(f)/(double)_f);
            if(fCount>maxPossible){
                maxPossible=fCount;
            }
            int sCount=(int)Math.ceil((double)(s)/(double)_s);
            if(sCount>maxPossible){
                maxPossible=sCount;
            }
            int mCount=(int)Math.ceil((double)(m)/(double)_m);
            if(mCount>maxPossible){
                maxPossible=mCount;
            }


            int eNeeded=maxPossible*_e-e;
            int fNeeded=maxPossible*_f-f;
            int sNeeded=maxPossible*_s-s;
            int mNeeded=maxPossible*_m-m;

            System.out.println(eNeeded+" "+fNeeded+" "+sNeeded+" "+mNeeded);

            e=sc.nextInt();
        }
    }
}
