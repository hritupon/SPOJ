import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by rsaikia on 8/17/2015.
 */
public class ABCDEF {
    public static void main(String[] args) throws Exception{
        Parser in=new Parser(System.in);
        PrintWriter out=new PrintWriter(System.out);
        int n=in.nextInt();
        int size=n*n*n;
        int[] arr=new int[n];
        for (int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        int[] ff=new int[size];
        int[] count=new int[size];
        int counter=0;
        for(int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    int val=(arr[i]*arr[j])+arr[k];
                    ff[counter++]=val;
                }
            }
        }
        Arrays.sort(ff);
        int first=ff[0];
        int total=1;
        for(int i=1;i<size;i++){
            if(ff[i]==first){
                total++;
            }else{
                for(int j=i-1;j>=i-total;j--){
                    count[j]=total;
                }
                total=1;
                first=ff[i];
            }
        }

        for(int i=size-1;i>=size-total;i--){
            count[i]=total;
        }

        int result=0;
        for(int i=0;i<n;i++){
            if(arr[i]==0){
                continue;
            }
            for (int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    int val=arr[i]*(arr[j]+arr[k]);
                    int idx=Arrays.binarySearch(ff,val);
                    if(idx>=0){
                     result+=count[idx];
                    }
                }
            }
        }
        out.println(result);
        out.flush();
    }

    public static int getCount(Integer[] arr, int low, int high, int val){
        int first=getFirst(arr,low,high,val);
        int last=getLast(arr, low, high,val);
        if(first!=-1 && last!=-1){
            return last-first+1;
        }
        return 0;
    }
    public static int getFirst(Integer[] arr,int low, int high, int val){
        if(high<low)return -1;

        int mid=(low+high)/2;
        if(  (   (mid==0) || (val>arr[mid-1])   )  &&  (arr[mid]==val)  ){
            return mid;
        }
        else if(val>arr[mid]){
            return getFirst(arr,mid+1,high,val);
        }else{
            return getFirst(arr,low,mid-1,val);
        }
    }

    public static int getLast(Integer[] arr, int low, int high, int val){
        if(high<low)return -1;
        int mid=(low+high)/2;
        if(((mid==arr.length-1)||(val<arr[mid+1]) )&&(arr[mid]==val)){
            return mid;
        }else if(val>=arr[mid]){
            return getLast(arr,mid+1,high,val);
        }else{
            return getLast(arr, low,mid-1,val);
        }
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
