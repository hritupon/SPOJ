import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * Created by rsaikia on 8/6/2015.
 */
public class EGYPIZZA {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        int tt=Integer.parseInt(br.readLine());

        int[] amounts = new int[3];
        while (tt>0){
            amounts[sliceIndex(br.readLine())]++;
            tt--;
        }

        //three quarters need one complete pizza
        int total=amounts[0]+1;

        //quarters can be balanced with threeQuarters
        if(amounts[0]<=amounts[2]){
            amounts[2]=amounts[2]-amounts[0];
        }else{
            amounts[2]=0;

        }

        //halfs can balance itself with other halfs
        total+=((amounts[1]+1)/2);


        //if halfs were in odd atleast one half will be left and it can be balanced with 2 quarters if available
        if((amounts[1]&1)==1){
            amounts[2]=(amounts[2]>=2)?amounts[2]-2:0;
        }

        //remaining quarters will need
        total+=( (amounts[2]+3)/4);
        out.println(total);
        out.flush();

    }
    public static int sliceIndex(String slice) {
        if (slice.charAt(2) == '2')  // 1/2
            return 1;
        if (slice.charAt(0) == '1')     // 1/4
            return 2;
        return 0;   // 3/4
    }
}
