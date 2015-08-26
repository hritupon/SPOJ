import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by rsaikia on 8/3/2015.
 */
public class PT07Y {
    static int count=0;
    static boolean[] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String firstLine=br.readLine();
        StringTokenizer stnz=new StringTokenizer(firstLine);

        int n=Integer.parseInt(stnz.nextToken());
        int m=Integer.parseInt(stnz.nextToken());
        ArrayList[] grid=new ArrayList[n+1];

        int vertex=-1;
        for(int i=1;i<=n;i++){
            grid[i]=new ArrayList<Integer>();
        }
        for(int i=0;i<m;i++){
            firstLine=br.readLine();
            stnz=new StringTokenizer(firstLine);
            int from=Integer.parseInt(stnz.nextToken());
            int to=Integer.parseInt(stnz.nextToken());
            if(vertex==-1){
                vertex=from;
            }
            grid[from].add(to);
            grid[to].add(from);
        }
        visited=new boolean[n+1];
        count=0;
        boolean isTree= ((!hasCycle( grid, vertex, -1, visited)) && (count==n));

        if(isTree){
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }

    public static boolean hasCycle(ArrayList[] grid, int vertex, int parent,boolean[] visited){
        if(visited[vertex]){
            return true;
        }
        visited[vertex]=true;
        count++;
        List<Integer> adjacents=grid[vertex];
        for(Integer adjVertex:adjacents){
            if(adjVertex==parent){
                continue;
            }
            if(visited[adjVertex]){
                return true;
            }
            boolean result= hasCycle(grid, adjVertex, vertex, visited);
            if(result)return true;
        }
        return false;
    }
}