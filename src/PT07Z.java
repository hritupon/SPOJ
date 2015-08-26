import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by rsaikia on 8/4/2015.
 */
public class PT07Z {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n+1];
        ArrayList[] adj=new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            adj[i]=new ArrayList<Integer>();
        }
        int startVertex=-1;
        for(int i=1;i<n;i++){
            int from=sc.nextInt();
            int to=sc.nextInt();
            if(startVertex==-1){
                startVertex=from;
            }
            adj[from].add(to);
            adj[to].add(from);
        }
        int max=Integer.MIN_VALUE;
        int[] dist=new int[n+1];
        boolean[] visited=new boolean[n+1];
        visit(startVertex,adj,dist,visited);
        int tmpMaxIndex=max(dist);
        startVertex=tmpMaxIndex;
        dist=new int[n+1];
        visited=new boolean[n+1];
        visit(startVertex,adj,dist,visited);
        int maxIndex=max(dist);
        System.out.println(dist[maxIndex]);
    }
    private static void visit(int root, ArrayList[] adj,int[] dist,boolean[] visited){
        dist[root]=0;
        Queue<Integer> q=new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            int visiting=q.poll();
            if(visited[visiting]){
                continue;
            }
            visited[visiting]=true;
            ArrayList<Integer> adjList=adj[visiting];
            for(int child:adjList){
                if(visited[child]){
                    continue;
                }
                dist[child]=dist[visiting]+1;
                q.offer(child);
            }
        }
    }
    private static int max(int[] dist){
        int max=Integer.MIN_VALUE;
        int index=-1;
        for(int i=0;i<dist.length;i++){
            if(dist[i]>max){
                max=dist[i];
                index=i;
            }
        }
        return index;
    }
}
