import java.io.IOException;
import java.io.InputStream;

/**
 * Created by rsaikia on 8/17/2015.
 */
public class ARRAYSUB {
    public static void main(String[] args) throws Exception{
        Parser in=new Parser(System.in);
        int n=in.nextInt();
        int[] arr=new int[n];
        int[] segmentTree=new int[4000000];
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        int size=in.nextInt();
        build(arr,segmentTree,0,0,n-1);
        boolean first=true;
        for(int i=0;i<=n-size;i++){
            int start=i;
            int end=i+size-1;
            if(!first){
                System.out.print(" ");
            }
            System.out.print(largest(0,0,n-1,start,end,segmentTree));
            first=false;
        }
    }

    public static int largest(int index, int left, int right, int qLeft, int qRight,  int[] segmentTree){
        if(qLeft>qRight){
            return 0;
        }
        if(qLeft<=left && qRight>=right){
            return segmentTree[index];
        }
        if (right < qLeft || left > qRight)
            return Integer.MIN_VALUE;

        int mid=(left+right)/2;
        return Math.max(
                largest(2*index+1, left ,mid  ,qLeft, qRight   ,segmentTree),
                largest(2*index+2, mid+1,right,qLeft,qRight ,segmentTree)
        );

    }
    public static int build(int[] arr, int[] segmentTree,int index,int left, int right){
            if(left==right){
                segmentTree[index]=arr[left];
            }else{
                int mid=(left+right)/2;
                int leftVal=build(arr,segmentTree,2*index+1,left,mid);
                int rightVal=build(arr,segmentTree,2*index+2,mid+1,right);
                segmentTree[index]=Math.max(leftVal,rightVal);
            }
        return segmentTree[index];
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
