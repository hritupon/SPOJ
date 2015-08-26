import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by rsaikia on 7/31/2015.
 */
public class ARMY {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int tt = Integer.parseInt(br.readLine());
        boolean first = true;
        while (tt > 0) {
            String str=br.readLine();
            if(str.trim().length()<=0)continue;
            String[] strSplitter=str.split(" ");
            int ng = Integer.parseInt(strSplitter[0]);
            int nm = Integer.parseInt(strSplitter[1]);

            str=br.readLine();
            String[] nmVals=str.split(" ");
            int maxa=Integer.MIN_VALUE;
            for (int i = 0; i < ng; i++) {
                int val=Integer.parseInt(nmVals[i]);
                if(val>maxa)maxa=val;
            }

            str=br.readLine();
            String[] ngVals=str.split(" ");
            int maxb=Integer.MIN_VALUE;
            for (int i = 0; i < nm; i++) {
                int val=Integer.parseInt(ngVals[i]);
                if(val>maxb)maxb=val;
            }
            if(!first){
                System.out.println("");
            }
            first=false;
            if(maxa >= maxb){
                System.out.print("Godzilla");
            }
            else if(maxb> maxa){
                System.out.print("MechaGodzilla");
            }
            else{
                System.out.print("uncertain");
            }

            tt--;
        }
    }
}