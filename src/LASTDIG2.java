import java.math.BigInteger;
import java.util.Scanner;
public class LASTDIG2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int tt=sc.nextInt();
        int[][]map={{0,0,0,0},{1,1,1,1},{2,4,8,6},{3,9,7,1},{4,6,4,6},{5,5,5,5},{6,6,6,6},{7,9,3,1},{8,4,2,6},{9,1,9,1}};
        while(tt>0){
            String str=sc.next();int d=str.charAt(str.length() -1)-'0';BigInteger b = sc.nextBigInteger();
            if(b.compareTo(BigInteger.ZERO)==0){System.out.println("1");}
            else {int index = (b.mod(BigInteger.valueOf(4))).intValue();index = (index == 0 ? 4 : index);System.out.println(map[d][index - 1]);}tt--;}}}
