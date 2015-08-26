import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by rsaikia on 8/24/2015.
 */
public class SILVER {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        while (n!=0){
            int result=(int)(Math.log(n)/Math.log(2));
            System.out.println(result);
            n=Integer.parseInt(br.readLine());
        }

    }
}
