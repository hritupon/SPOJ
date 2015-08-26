import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by rsaikia on 8/4/2015.
 */
public class BYTESM2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine().trim();
        while(str==null && str.trim().length()<=0){
            str=br.readLine().trim();
        }
        StringTokenizer stnz=new StringTokenizer(str);
        int tt=Integer.parseInt(stnz.nextToken());
        while(tt>0){
            str=br.readLine().trim();;
            while(str==null && str.trim().length()<=0){
                str=br.readLine().trim();
            }
            stnz=new StringTokenizer(str);
            int row=Integer.parseInt(stnz.nextToken());
            int col=Integer.parseInt(stnz.nextToken());
            int[][] mat=new int[row+1][col+2];
            int max=Integer.MIN_VALUE;
            for(int i=1;i<row+1;i++){
                str=br.readLine().trim();
                while(str==null && str.trim().length()<=0){
                    str=br.readLine().trim();
                }
                stnz=new StringTokenizer(str);
                for(int j=1;j<col+1;j++){
                    mat[i][j] = Math.max(mat[i - 1][j], Math.max(mat[i - 1][j - 1], mat[i - 1][j + 1]))+Integer.parseInt(stnz.nextToken());
                    if(i==row){
                        if(mat[i][j]>max){
                            max=mat[i][j];
                        }
                    }
                }
            }
            System.out.println(max);
            tt--;
        }
    }
}
