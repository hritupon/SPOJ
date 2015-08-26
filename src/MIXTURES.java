import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by rsaikia on 8/12/2015.
 */
public class MIXTURES {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String line=br.readLine();
        while(line!=null && line.length()>0){
            int n=Integer.parseInt(line.trim());
            int V[][]=new int[n][n];
            int C[][]=new int[n][n];
            StringTokenizer stnz=new StringTokenizer(br.readLine().trim());
            for(int i=0;i<n;i++){
                C[i][i]=Integer.parseInt(stnz.nextToken());
            }

            for(int l=2;l<=n;l++){
                for(int i=0;i<n-l+1;i++){
                    int j=i+l-1;
                    V[i][j]=Integer.MAX_VALUE;
                    for(int k=i;k<=j-1;k++){
                        int val=V[i][k]+V[k+1][j]+C[i][k]*C[k+1][j];
                        if(val<V[i][j]){
                            C[i][j]=(C[i][k]+C[k+1][j])%100;
                            V[i][j]=val;
                        }
                    }
                }
            }
            System.out.println(V[0][n-1]);
            line=br.readLine();
        }
    }
}
