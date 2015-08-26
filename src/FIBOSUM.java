import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by rsaikia on 8/20/2015.
 */
public class FIBOSUM {
    private static long MOD=1000000007;
    public static void main(String[] args) throws Exception {
        FastScanner in=new FastScanner();
        int tt=in.nextInt();
        while (tt>0){
            long a=in.nextLong();
            long b=in.nextLong();
            System.out.println((getNthFibonacci(b + 2) -getNthFibonacci(a+1)+MOD)%MOD);
            tt--;
        }
    }
    private static long getNthFibonacci(long n){
        if (n == 0)
            return 0;
        long F[][] = {{1,1},{1,0}};
        pow(F,n-1);
        return F[0][0];
    }
    private static void pow(long[][] F,long n){
        if( n == 0 || n == 1)
            return;

        long M[][] = {{1,1},{1,0}};
        pow(F,n/2);
        mult(F,F);
        if(n%2!=0){
            mult(F,M);
        }
    }
    private static void mult(long[][]F,long[][]M){
        long[][]result=new long[2][2];
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                for(int k=0;k<2;k++){
                    result[i][j]=(result[i][j]+F[i][k]*M[k][j])%MOD;
                }
            }
        }
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                F[i][j]=result[i][j];
            }
        }
    }

    static class FastScanner{
        BufferedReader s;
        StringTokenizer st;


        public FastScanner(){
            st = new StringTokenizer("");
            s = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastScanner(File f) throws FileNotFoundException {
            st = new StringTokenizer("");
            s = new BufferedReader (new FileReader(f));
        }

        public int nextInt() throws IOException{
            if(st.hasMoreTokens())
                return Integer.parseInt(st.nextToken());
            else{
                st = new StringTokenizer(s.readLine());
                return nextInt();
            }
        }

        public double nextDouble() throws IOException{
            if(st.hasMoreTokens())
                return Double.parseDouble(st.nextToken());
            else{
                st = new StringTokenizer(s.readLine());
                return nextDouble();
            }
        }

        public long nextLong() throws IOException{
            if(st.hasMoreTokens())
                return Long.parseLong(st.nextToken());
            else{
                st = new StringTokenizer(s.readLine());
                return nextLong();
            }
        }

        public String nextString() throws IOException{
            if(st.hasMoreTokens())
                return st.nextToken();
            else{
                st = new StringTokenizer(s.readLine());
                return nextString();
            }

        }
        public String readLine() throws IOException{
            return s.readLine();
        }

        public void close() throws IOException{
            s.close();
        }

    }
}
