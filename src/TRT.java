import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by rsaikia on 8/10/2015.
 */
public class TRT {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int tt=Integer.parseInt(br.readLine());
        int size=tt;
        int[] arr=new int[tt];
        int i=0;
        while (tt>0){
            arr[i++]=Integer.parseInt(br.readLine());
            tt--;
        }
        int[][] memory=new int[size][size];
        for(i=0;i<size;i++){
            for(int j=0;j<size;j++){
                memory[i][j]=-1;
            }
        }
        int result=compute(arr,0,size-1,memory,size,1);
        System.out.println(result);
    }
    private static int compute(int[] arr,int startIndex, int endIndex, int[][] memory,int n,int d){
        if(startIndex>endIndex){
            return 0;
        }
        if(memory[startIndex][endIndex]!=-1){
            return memory[startIndex][endIndex];
        }
        int day=d;
        int result=Math.max(compute(arr,startIndex+1,endIndex,memory,n,d+1)+day*arr[startIndex],compute(arr,startIndex,endIndex-1,memory,n,d+1)+day*arr[endIndex]);
        memory[startIndex][endIndex]=Math.max(result,memory[startIndex][endIndex]);
        return result;
    }

}
