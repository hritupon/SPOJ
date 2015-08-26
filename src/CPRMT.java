import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by rsaikia on 8/20/2015.
 */
public class CPRMT {
    public static void main(String[] args) throws Exception{
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        String str=in.readLine().trim();

        while (str!=null && str.trim().length()>0){
            String str2=in.readLine();
            int[] map=new int[1111];
            for(int i=0;i<26;i++){
                map['a'+i]=0;
            }
            for(int i=0;i<str.length();i++){
                char ch=str.charAt(i);
                map[ch]=map[ch]+1;
            }
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<str2.length();i++){
                char ch=str2.charAt(i);
                if(map[ch]>0){
                    sb.append(ch);
                }
                map[ch]=map[ch]-1;
            }
            if(sb.length()>0){
                char[] chars = sb.toString().toCharArray();
                Arrays.sort(chars);
                System.out.println( new String(chars));
            }else{
                System.out.println("");
            }
            str=in.readLine();
        }
    }
}
