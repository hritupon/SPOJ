import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by rsaikia on 8/26/2015.
 */
public class DISUBSTR {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int tt=Integer.parseInt(br.readLine());
        while (tt-->0){
            String str=br.readLine();
            int N=str.length();
            String[] suffixes=new String[N];
            int total=0;
            for(int i=0;i<N;i++){
                suffixes[i]=str.substring(i,N);
                total+=suffixes[i].length();
            }
            Arrays.sort(suffixes);
            int totalLCP=0;
            for(int i=0;i<N-1;i++){
                totalLCP+=lcp(suffixes[i],suffixes[i+1]);
            }
            System.out.println(total-totalLCP);
        }
    }
    private static int lcp(String str1, String str2){
        int len=0;
        for(int i=0;i<str1.length()&& i<str2.length();i++){
            if(str1.charAt(i)==str2.charAt(i)){
                len++;
            }else{
                break;
            }
        }
        return len;
    }
}
