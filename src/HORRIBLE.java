import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by rsaikia on 8/18/2015.
 */
public class HORRIBLE {
    public static  int MAX =   100007;

    public static void main(String[] args) throws Exception{
        long B1[] = new long[ MAX];
        long B2[] = new long[MAX];
        FastScanner scan = new FastScanner();
        int tt=scan.nextInt();
        while (tt>0){
            int n = scan.nextInt();
            Arrays.fill(B1, 0);
            Arrays.fill(B2,0);

            int c=scan.nextInt();
            for(int i=0;i<c;i++){
                int type=scan.nextInt();
                int p=scan.nextInt();
                int q=scan.nextInt();
                if(type==0){
                    long v=scan.nextLong();
                    update(B1,B2,p,q,v);
                }else{
                        long sum = query(B1,B2, p,q);
                        System.out.println(sum);
                }
            }
            tt--;
        }

    }

    public static void update(long[] ft,int idx, long val){
        while(idx<=MAX-1){
            ft[idx]+=val;
            idx+=idx&(-idx);
        }
    }
    public static long query(long[] ft, int idx){
        long sum=0;
        while(idx>0){
            sum+=ft[idx];
            idx-=idx&(-idx);
        }
        return sum;
    }
    public static void update(long[] B1,long[] B2,int l, int r, long v){
        update(B1,l,v);
        update(B1,r+1,-v);
        update(B2,l,(long)(v*(l-1)));
        update(B2,r+1,(long)-v*r);
    }


    public static long query(long[]B1, long[] B2, int b){
        return query(B1,b)*b-query(B2,b);
    }
    public static long query(long[]B1, long[] B2,int l, int r){
        return query(B1,B2,r)-query(B1,B2,l-1);
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
