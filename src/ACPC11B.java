import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by rsaikia on 8/13/2015.
 */
public class ACPC11B {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int tt=Integer.parseInt(br.readLine().trim());
        while (tt>0){
            String str1=br.readLine();
            String str2=br.readLine();



            StringTokenizer stnz=new StringTokenizer(str1);
            int n=Integer.parseInt(stnz.nextToken());
            int[] arr1=new int[n];


            int i=0;
            while(stnz.hasMoreTokens()){
                arr1[i++]=Integer.parseInt(stnz.nextToken());
            }
            stnz=new StringTokenizer(str2);
            int m=Integer.parseInt(stnz.nextToken());
            int[] arr2=new int[m];
            i=0;
            while(stnz.hasMoreTokens()){
                arr2[i++]=Integer.parseInt(stnz.nextToken());
            }

            int min=Integer.MAX_VALUE;
            for(i=0;i<arr1.length;i++){
                for(int j=0;j<arr2.length;j++){
                    int diff=Math.abs(arr1[i]-arr2[j]);
                    if(diff<min){
                        min=diff;
                    }
                }
            }
            System.out.println(min)

    ;
            tt--;
        }
    }
}
