import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by rsaikia on 8/10/2015.
 */
public class QUADAREA {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int tt=Integer.parseInt(br.readLine());
        while (tt>0){
            StringTokenizer stnz=new StringTokenizer(br.readLine());
            double a=Double.parseDouble(stnz.nextToken());
            double b=Double.parseDouble(stnz.nextToken());
            double c=Double.parseDouble(stnz.nextToken());
            double d=Double.parseDouble(stnz.nextToken());
            double s=(a+b+c+d)/2;
            double area=Math.sqrt((s-a)*(s-b)*(s-c)*(s-d));
            System.out. printf("%.2f\n", area);
            tt--;
        }

    }
}
