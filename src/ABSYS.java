import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by rsaikia on 7/30/2015.
 */
public class ABSYS {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String ttStr=br.readLine();
        int tt=Integer.parseInt(ttStr);
        boolean isFirst=true;
        while(tt>0){
                String str=br.readLine();
                if(str.trim().length()<=0){
                    continue;
                }
                int i=0;
                char ch=str.charAt(i);
                StringBuilder sb1=new StringBuilder();
                while(i<str.length() && ch!='+'){
                    sb1.append(ch);
                    ch=str.charAt(++i);
                }
                String firstArgument=sb1.toString().trim();

                i++;
                ch=str.charAt(i);
                StringBuilder sb2=new StringBuilder();
                while(i<str.length() && ch!='='){
                    sb2.append(ch);
                    ch=str.charAt(++i);
                }
                String secondArgument=sb2.toString().trim();

                i++;
                ch=str.charAt(i);
                StringBuilder sb3=new StringBuilder();
                sb3.append(ch);

                while(i<str.length()){
                    ch=str.charAt(i);
                    sb3.append(ch);
                    i++;
                }
                String resultStr=sb3.toString().trim();

                if(isAllDigit(firstArgument) && isAllDigit(secondArgument)){
                    int first=Integer.parseInt(firstArgument);
                    int second=Integer.parseInt(secondArgument);
                    int result=first+second;
                    if(!isFirst){
                        System.out.println();
                    }else{
                        isFirst=false;
                    }
                    System.out.print(first+" + "+second+" = "+result);
                }
                else if(isAllDigit(firstArgument) && isAllDigit(resultStr)){
                    int first=Integer.parseInt(firstArgument);
                    int result=Integer.parseInt(resultStr);
                    int second=result-first;
                    if(!isFirst){
                        System.out.println();
                    }else{
                        isFirst=false;
                    }
                    System.out.print(first + " + " + second + " = " + result);
                }
                else if(isAllDigit(secondArgument) && isAllDigit(resultStr)){
                    int second =Integer.parseInt(secondArgument);
                    int result=Integer.parseInt(resultStr);
                    int first=result-second;
                    if(!isFirst){
                        System.out.println();
                    }else{
                        isFirst=false;
                    }
                    System.out.print(first+" + "+second+" = "+result);
                }
            tt--;
        }
    }

    public static boolean isAllDigit(String str) {
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - '0';
            if (val < 0 || val > 9) {
                return false;
            }
        }
        return true;
    }
}
