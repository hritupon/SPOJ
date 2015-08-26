import java.io.*;
import java.util.*;

/**
 * Created by rsaikia on 8/14/2015.
 */
public class BUGLIFE {
    public static void main(String[] args) throws Exception{
        Parser in=new Parser(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int tt=in.nextInt();
        int count=0;
        while (tt>0){
            tt--;
            count++;
            int n=in.nextInt();
            ArrayList<Integer>[] adj=new ArrayList[n+1];
            boolean[] visited=new boolean[n+1];
            int color[]=new int[n+1];

            for(int i=1;i<=n;i++){
                adj[i]=new ArrayList<Integer>();
                visited[i]=false;
                color[i]=-1;
            }
            int m=in.nextInt();

            while (m>0){
                int i=in.nextInt();
                int j=in.nextInt();
                adj[i].add(j);
                adj[j].add(i);
                m--;
            }


            boolean error=false;
            for(int startPoint=1;startPoint<=n;startPoint++){
                if(!visited[startPoint]){
                    color[startPoint]=1;
                    error=bfs(startPoint,adj,color,visited);
                    if(error){
                        break;
                    }
                }
            }
            out.println("Scenario #"+count+":");
            if(error){
                out.println("Suspicious bugs found!");
            }else{
                out.println("No suspicious bugs found!");
            }
        }
        out.flush();
    }

    public static boolean bfs(int start,ArrayList<Integer>[] adj,int[] color,boolean[] visited){
        Queue<Integer> q=new LinkedList<>();
        q.offer(start);
        while (!q.isEmpty()){
            int current=q.remove();
            visited[current]=true;
            List<Integer> adjs=adj[current];
            for(Integer ad:adjs){
                if(!visited[ad]){
                    visited[ad]=true;
                    color[ad]=1-color[current];
                    q.offer(ad);
                }else{
                    if(color[current]==color[ad]){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    static class Parser {
        final private int BUFFER_SIZE = 65536;  // 2^16, a good compromise for some problems
        private InputStream din;    // Underlying input stream
        private byte[] buffer;      // Self-maintained buffer
        private int bufferPointer;  // Current read position in the buffer
        private int bytesRead;      // Effective bytes in the buffer read from the input stream

        public Parser(InputStream in) {
            din = in;
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        /**
         * Read the next integer from the input stream.
         * @return The next integer.
         * @throws java.io.IOException
         */
        public int nextInt() throws IOException {
            int result = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            while (c >= '0' && c <= '9') {
                result = result * 10 + c - '0';
                c = read();
            }
            if (neg) return -result;
            return result;
        }

        /**
         * Read a line of data from the input stream.
         * @return the next line of data.
         * @throws IOException if an I/O error occurs.
         */
        public String readLine() throws IOException {
            StringBuilder line = new StringBuilder();
            char c;
            while ((c = (char)(read())) != '\n') {
                line.append(c);
            }
            return line.toString();
        }

        /**
         * Read the next byte of data from the input stream.
         * @return the next byte of data, or -1 if the end of the stream is reached.
         * @throws IOException if an I/O error occurs.
         */
        public byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        /**
         * Read data from the input stream into the buffer
         * @throws IOException if an I/O error occurs.
         */
        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }
    }
}
