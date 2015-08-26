import java.util.Scanner;

/**
 * Created by rsaikia on 8/7/2015.
 */
public class PARTY {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int budget=sc.nextInt();
        int parties=sc.nextInt();
        while(budget!=0 && parties!=0){
            int[] weight=new int[parties+1];
            int[] value=new int[parties+1];
            for(int i=1;i<=parties;i++){
                weight[i]=sc.nextInt();
                value[i]=sc.nextInt();
            }
            int[][]map=new int[parties+1][budget+1];
            int[][]picks=new int[parties+1][budget+1];
            for(int j=0;j<=budget;j++){
                map[0][j] = 0;
            }

            for(int i=1;i<=parties;i++){
                for(int j=0;j<=budget;j++){
                    if(weight[i]<=j){
                        map[i][j]=Math.max(map[i-1][j],map[i-1][j-weight[i]]+value[i]);
                        if(map[i-1][j-weight[i]]+value[i] >map[i-1][j]){
                            picks[i][j]=1;
                        }else{
                            picks[i][j]=-1;
                        }
                    }else{
                        map[i][j]=map[i-1][j];
                        picks[i][j]=-1;
                    }
                }
            }

            //printPicks(parties, budget, weight, picks);

            int i = budget;
            while(map[parties][i-1] == map[parties][i]) {
                i--;
            }
            System.out.println(i+" "+map[parties][i]);

            //System.out.println(map[parties][budget]);
            budget=sc.nextInt();
            parties=sc.nextInt();
        }
    }
}
