import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by rsaikia on 8/6/2015.
 */
public class JAVAC {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine().trim();
        while(str!=null && str.trim().length()>0){
            boolean isJava=isJava(str);
            boolean isCPP=isCPP(str);
            if(!isJava && !isCPP){
                System.out.println("Error!");
            }
            else if(isJava && !isCPP){
                System.out.println(convertToCPP(str));
            }
            else if(isCPP && !isJava){
                System.out.println(convertToJava(str));
            }
            else{
                System.out.println(str);
            }
            str=br.readLine();
        }
    }
    public static String convertToJava(String str){
        StringBuilder sb=new StringBuilder();
        boolean prevUnderScore=false;
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch=='_'){
                prevUnderScore=true;
                continue;
            }
            else if(ch >= 'a' && ch <= 'z'){
                if(prevUnderScore){
                    String s=""+ch;
                    sb.append(s.toUpperCase());
                    prevUnderScore=false;
                }
                else{
                    sb.append(ch);
                }

            }else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }
    public static String convertToCPP(String str){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch >= 'A' && ch <= 'Z'){
                sb.append("_");
                String s=""+ch;
                sb.append(s.toLowerCase());
            }else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }
    public static boolean isJava(String str){
        //allSmall
        if(isAllSmall(str)){
            return true;
        }
        if (isOneUnderscore(str)){
            return false;
        }
        if(isAllNumber(str)){
            return true;
        }
        if(isAllSpecial(str)){
            return true;
        }
        //atleast one is Capital
        if(isOneCapital(str)){
            if(isCapitalFirstLetter(str)){
                return false;
            }
            return true;
        }
        return false;
    }
    public static boolean isCPP(String str){
        if(isAllNumber(str)){
            return true;
        }
        if(isAllSpecial(str)){
            return true;
        }
        //allSmall
        if(isAllSmall(str)){
            return true;
        }
        if(isOneCapital(str)){
            return false;
        }
        //atleast one is Capital
        if (isOneUnderscore(str)){
            if(isUnderscoreFirstOrLast(str)){
                return false;
            }
            if(isConsecutiveUnderscore(str)){
                return false;
            }
            return true;
        }
        if(isConsecutiveUnderscore(str)){
            return false;
        }
        return false;
    }

    public static boolean isConsecutiveUnderscore(String str){
        for(int i=0;i<str.length()-1;i++){
            if((str.charAt(i)=='_')&&(str.charAt(i+1)=='_')){
                return true;
            }
        }
        return false;
    }
    public static boolean isOneCapital(String str){
        boolean result=false;
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            boolean isUpperCase=(ch>='A' && ch<='Z');
            result=result|isUpperCase;
        }
        return result;
    }
    public static boolean isOneUnderscore(String str){
        boolean result=false;
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            result=result|(ch=='_');
        }
        return result;
    }
    public static boolean isAllSmall(String str){
        boolean result=true;
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(isNumber(ch)){
                continue;
            }
            if(isSpecialCharacter(ch)){
                continue;
            }
            result=result&isLowerCase(ch);
            if(!result){
                return false;
            }
        }
        return result;
    }

    static boolean isLowerCase(char ch) {
        return ch >= 'a' && ch <= 'z';
    }
    static boolean isUnderscoreFirstOrLast(String str){
        if(str.charAt(0)=='_' || str.charAt(str.length()-1)=='_'){
            return true;
        }
        return false;
    }
    static boolean isCapitalFirstLetter(String str){
        char ch=str.charAt(0);
        if(ch>='A' && ch<='Z'){
            return true;
        }
        return false;
    }
    static boolean isAllNumber(String str){
        boolean result=true;
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            result&=isNumber(ch);
        }
        return result;
    }

    static boolean isAllSpecial(String str){
        boolean result=true;
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            result &=isSpecialCharacter(ch);
        }
        return result;
    }
    static boolean isNumber(Character c){
        return (c >= '0' && c <= '9');
    }
    static boolean isSpecialCharacter(Character c){
        if(c=='_'){
            return false;
        }
        if(c>='A' && c<='Z'){
           return false;
        }
        if(c>='a' && c<='z'){
            return false;
        }
        if(c>='0' && c<='9'){
            return false;
        }
        return true;
    }
}
