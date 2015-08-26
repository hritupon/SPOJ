import java.io.*;
import java.util.Stack;

/**
 * Created by rsaikia on 8/12/2015.
 */
public class ANARC09A {
    public static void main(String[] args) throws Exception{
        BufferedReader  in=new BufferedReader(new InputStreamReader(System.in));
        String str=in.readLine().trim();
        int caseNum=0;
        Stack<Character> stack=new Stack<Character>();
        while((str!=null) && (str.length()>0) && (str.charAt(0)!='-')){
            caseNum++;
            stack.clear();
            for(int i=0;i<str.length();i++){
                char ch=str.charAt(i);
                if (ch != '{' && ch != '}') {
                    continue;
                }
                if(stack.size()==0){
                    stack.push(ch);
                }
                else{
                    if( (ch=='}') && (stack.peek()=='{')){
                        stack.pop();
                    }
                    else{
                        stack.push(ch);
                    }
                }
            }
            int openCounter=0;
            int closeCounter=0;
            for(Character ch:stack){
                if(ch=='{'){
                    openCounter++;
                }
                else {
                    closeCounter++;
                }
            }
            int result=(openCounter+closeCounter)/2;
            if(openCounter%2 !=0 && closeCounter%2!=0){
                result=result+1;
            }
            System.out.println(caseNum+". "+result);

            str=in.readLine().trim();
        }
    }
}
