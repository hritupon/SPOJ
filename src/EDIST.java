import java.util.Scanner;

/**
 * Created by rsaikia on 8/4/2015.
 */
public class EDIST {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int tt=sc.nextInt();
        while (tt>0){
            String a=sc.next();
            String b=sc.next();
            int[][]matrix=new int[a.length()+1][b.length()+1];
            matrix[0][0]=0;
            for(int i=1;i<=a.length();i++){
                matrix[i][0]=i;
            }
            for(int i=1;i<=b.length();i++){
                matrix[0][i]=i;
            }
            for(int i=1;i<=a.length();i++){
                for(int j=1;j<=b.length();j++){
                    if(a.charAt(i-1)==b.charAt(j-1)){
                        matrix[i][j]=matrix[i-1][j-1];
                    }else{
                        matrix[i][j]=Math.min(Math.min(matrix[i][j-1],matrix[i-1][j]),matrix[i-1][j-1])+1;
                    }
                }
            }
            System.out.println(matrix[a.length()][b.length()]);
            tt--;
        }
    }
}
