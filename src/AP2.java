import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by rsaikia on 7/31/2015.
 */
public class AP2 {
    public static void main(String[] args) throws  Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        int tt=Integer.parseInt(br.readLine());
        while (tt>0){
            String str=br.readLine();
            StringTokenizer st=new StringTokenizer(str);
            long t3=Long.parseLong(st.nextToken());
            long tl3=Long.parseLong(st.nextToken());
            long s=Long.parseLong(st.nextToken());

            long n=(2*s)/(tl3+t3);
            long d=(tl3-t3)/(n-5);
            long a=t3-2*d;

            out.println(n);
            for(int i=0;i<n;i++){
                out.print((a+i*d)+" ");
            }
            out.println("");
            tt--;
        }
        out.flush();
    }
}
