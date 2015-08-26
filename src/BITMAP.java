import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by rsaikia on 8/5/2015.
 */
public class BITMAP {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tt = Integer.parseInt(br.readLine().trim());
        while (tt > 0) {
            StringTokenizer stnz = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(stnz.nextToken());
            int n = Integer.parseInt(stnz.nextToken());
            Queue<Obj> q=new LinkedList<Obj>();
            int[][] arr = new int[m][n];
            int[][] score = new int[m][n];
            for (int i = 0; i < m; i++) {
                String line = br.readLine();
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt("" + line.charAt(j));
                    score[i][j] = Integer.MAX_VALUE;
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] == 1) {
                        Obj obj=new Obj(arr, score, i, j, i, j);
                        q.offer(obj);
                        //propagate(arr, score, i, j, i, j);
                        bfs(q);
                    }
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (j != 0) {
                        System.out.print(" ");
                    }
                    System.out.print(score[i][j]);
                }
                System.out.println("");
            }
            br.readLine();
            tt--;
        }
    }

    //public static void propagate(int[][] arr, int[][] score, int i, int j, int from_i, int from_j) {
    public static void bfs(Queue<Obj> q) {
        while (!q.isEmpty()){
            Obj obj=q.poll();
            if (obj.i < 0 || obj.i >= obj.score.length) {
                return;
            }
            if (obj.j < 0 || obj.j >= obj.score[0].length) {
                return;
            }
            obj.score[obj.i][obj.j] = Math.abs(obj.i - obj.from_i) + Math.abs(obj.j - obj.from_j);
            if (obj.arr[obj.i][obj.j] == 1) {
                obj.score[obj.i][obj.j] = 0;
            }
            int x[] = {1, 0, -1, 0};
            int y[] = {0, -1, 0, 1};
            for (int k = 0; k < 4; k++) {
                int next_i = obj.i + x[k];
                int next_j = obj.j + y[k];

                if (next_i >= 0 && next_j >= 0 && next_i < obj.score.length && next_j < obj.score[0].length) {
                    if (obj.arr[next_i][next_j] == 1) {
                        continue;
                    }
                    int newScoreForNext = Math.abs(next_i - obj.from_i) + Math.abs(next_j - obj.from_j);
                    if (newScoreForNext < obj.score[next_i][next_j]) {
                        obj.score[next_i][next_j] = newScoreForNext;
                        //propagate(arr, score, next_i, next_j, from_i, from_j);
                        Obj objN=new Obj(obj.arr, obj.score, next_i, next_j, obj.from_i, obj.from_j);
                        q.offer(objN);
                    }
                }
            }
        }
    }
}
class Obj{
    int[][] arr;
    int[][] score;
    int i;
    int j;
    int from_i;
    int from_j;
    public Obj(int[][] arr, int[][] score, int i, int j, int from_i, int from_j){
        this.arr=arr;
        this.score=score;
        this.i=i;
        this.j=j;
        this.from_i=from_i;
        this.from_j=from_j;
    }
}