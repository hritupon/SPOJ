import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by rsaikia on 8/5/2015.
 */
public class NY10A {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int tCount=1;
        int tt=sc.nextInt();
        String[] tokens={"TTT", "TTH", "THT", "THH", "HTT", "HTH", "HHT","HHH"};
        boolean first=true;
        while(tt>0){
            int n=sc.nextInt();
            String s=sc.next();
            HashMap<String, Integer>counter=new HashMap<String,Integer>();
            for(int i=0;i<38;i++){
                StringBuilder sb=new StringBuilder();
                sb.append(s.charAt(i));
                sb.append(s.charAt(i+1));
                sb.append(s.charAt(i+2));
                String key=sb.toString();
                int count=0;
                if(counter.containsKey(key)){
                    count=counter.get(key);
                }
                count++;
                counter.put(key,count);
            }
            if(!first){
                System.out.println("");
            }
            first=false;
            System.out.print(tCount);
            for(String str:tokens){
                 Integer val=counter.get(str);
                if(val==null){
                    System.out.print(" "+0);
                }else{
                    System.out.print(" "+val);
                }
            }
            tt--;
            tCount++;
        }
    }
}
