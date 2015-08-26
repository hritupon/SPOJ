import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by rsaikia on 8/12/2015.
 */
public class AIBOHP {
    public static void main(String[] args) throws Exception{

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int tt=Integer.parseInt(br.readLine().trim());
        while (tt>0){
            String str=br.readLine().trim();
            String rev=revers(str);
            int val=lcs(str,rev);
            System.out.println(str.length()-val);
            tt--;
        }
    }
    private static String revers(String str){
        StringBuilder sb=new StringBuilder(str);
        return sb.reverse().toString();
    }
    private static int lcs(String str1,String str2){
        int[][]dp=new int[str1.length()+1][str2.length()+1];
        for(int i=0;i<=str1.length();i++){
            for(int j=0;j<=str2.length();j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }
                else{
                    if(str1.charAt(i-1)==str2.charAt(j-1)){
                        dp[i][j]=dp[i-1][j-1]+1;
                    }else{
                        dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                    }
                }
            }
        }
        return dp[str1.length()][str2.length()];
    }
}
