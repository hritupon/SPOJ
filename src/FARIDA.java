import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by rsaikia on 8/14/2015.
 */
public class FARIDA {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int tt=Integer.parseInt(br.readLine().trim());
        int caseCounter=1;
        while (tt>0){
            String str=br.readLine().trim();
            while(str==null || str.length()<=0){
                str=br.readLine().trim();
            }
            int n=Integer.parseInt(str);
            if(n==0){
                br.readLine();
                System.out.println("Case "+caseCounter+": 0");
                tt--;
                caseCounter++;
            }else{
                long[] arr=new long[n];
                long[] maxVal=new long[n];

                StringTokenizer stnz=new StringTokenizer(br.readLine().trim());
                for(int i=0;i<n;i++){
                    arr[i]=Long.parseLong(stnz.nextToken());
                }
                maxVal[0]=arr[0];
                if(n>1){
                    maxVal[1]=Math.max(arr[0],arr[1]);
                    for(int i=2;i<n;i++) {
                        maxVal[i]=Math.max(maxVal[i-2]+arr[i],maxVal[i-1]);
                    }
                }
                System.out.println("Case "+caseCounter+": "+maxVal[n-1]);
                tt--;
                caseCounter++;
            }
        }
    }
}
