import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by rsaikia on 8/5/2015.
 */
public class ARITH2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int tt=Integer.parseInt(br.readLine());
        while(tt>0){
            br.readLine();
            StringTokenizer stnz=new StringTokenizer(br.readLine());
            Queue<String> q=new LinkedList<String>();
            while(stnz.hasMoreTokens()){
                q.offer(stnz.nextToken());
            }
            Stack<Long> stack=new Stack<Long>();
            stack.push(Long.parseLong(q.poll()));
            while(true){
                String operator=q.poll().trim();
                long first=stack.pop();
                if(operator.equals("=")){
                    System.out.println(first);
                    break;
                }
                long second=Long.parseLong(q.poll());
                long result=operate(operator, first, second);
                stack.push(result);
            }
            tt--;
        }
    }
    public static long operate(String operator, long first, long second){
        if(operator.equals("+")){
            return first+second;
        }
        if(operator.equals("-")){
            return first-second;
        }
        if(operator.equals("*")){
            return first*second;
        }
        if(operator.equals("/")){
            return first/second;
        }
        return 0;
    }
}
