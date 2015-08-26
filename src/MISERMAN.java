import java.util.Scanner;

/**
 * Created by rsaikia on 8/26/2015.
 */
public class MISERMAN {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int[][] val=new int[m][n];
        int[][]comp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++) {
                comp[i][j]=Integer.MAX_VALUE;
            }
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                val[i][j]=sc.nextInt();
                if(i==0){
                    comp[i][j]=val[i][j];
                }else{
                    if(j-1>=0 && j+1<n){
                        comp[i][j]=Math.min(comp[i][j],val[i][j]+min(comp[i - 1][j],comp[i - 1][j - 1], comp[i-1][j+1]));
                    } else if(j-1>0){
                        comp[i][j]=Math.min(comp[i][j],val[i][j]+Math.min(comp[i-1][j],comp[i-1][j-1]));
                    }
                    else if(j+1<n){
                        comp[i][j]=Math.min(comp[i][j],val[i][j]+Math.min(comp[i-1][j],comp[i-1][j+1]));
                    }
                }

                if(i==m-1){
                    if(comp[i][j]<min){
                        min=comp[i][j];
                    }
                }
            }
        }
        System.out.println(min);
    }
    private static int min(int a, int b, int c){
        return Math.min(a,Math.min(b,c));
    }
}
