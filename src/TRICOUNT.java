import java.io.BufferedReader;
import java.io.InputStreamReader;
public class TRICOUNT {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int tt=Integer.parseInt(br.readLine());
        for(int i=0;i<tt;i++){
            long n=Long.parseLong(br.readLine());
            System.out.println((n*(n+2)*(2*n+1))>>3);
        }
    }
}
