import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by rsaikia on 8/18/2015.
 */
public class ANARC05B {
    public static void main(String[] args) throws Exception{
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        while (n!=0){
            int[] arr1=new int[n];
            long[] sum1=new long[n];
            for(int i=0;i<n;i++){
                arr1[i]=in.nextInt();
                if(i==0){
                    sum1[i]=arr1[i];
                }else {
                    sum1[i] =sum1[i-1]+ arr1[i];
                }
            }
            int m=in.nextInt();
            int[] arr2=new int[m];
            long[] sum2=new long[m];
            sum2[0]=0;
            for(int j=0;j<m;j++){
                arr2[j]=in.nextInt();
                if(j==0){
                    sum2[j]=arr2[j];
                }else {
                    sum2[j] =sum2[j-1]+ arr2[j];
                }

            }
            int firstPoint=-1;
            int secondPoint=-1;
            int prevFirstPoint=-1;
            int prevSecondPoint=-1;
            List<obj> ll=new ArrayList<obj>();
            for(int i=0;i<n ; i++){
                for(int j=0;j<m;j++){
                    int firstVal=arr1[i];
                    int secondVal=arr2[j];
                    long firstSum=0;
                    long secondSum=0;
                    if(firstVal==secondVal){
                        firstPoint=i;
                        secondPoint=j;
                        if(prevFirstPoint==-1 && prevSecondPoint==-1){
                            firstSum=sum1[i];
                            secondSum=sum2[j];
                            prevFirstPoint=firstPoint;
                            prevSecondPoint=secondPoint;
                        }else{

                            firstSum=sum1[i]-sum1[prevFirstPoint];
                            secondSum=sum2[j]-sum2[prevSecondPoint];
                            prevFirstPoint=firstPoint;
                            prevSecondPoint=secondPoint;
                        }
                        obj o=new obj();
                        o.setAPoint(firstPoint);
                        o.setBPoint(secondPoint);
                        o.setVal(arr1[firstPoint]);
                        o.setfirstSum(firstSum);
                        o.setSecondSum(secondSum);
                        ll.add(o);
                    }
                }
            }
            int sum=0;
            for(obj o:ll){
                sum+=o.getMaxSum();
            }
            if(ll.size()==0){
                long result=sum1[n-1]>sum2[m-1]?sum1[n-1]:sum2[m-1];
                System.out.println(result);
            }
            else{
                obj lastMatchPoint=ll.get(ll.size()-1);
                int tmp1=0;
                for(int i=lastMatchPoint.getAPoint()+1;i<arr1.length;i++){
                    tmp1+=arr1[i];
                }
                int tmp2=0;
                for(int i=lastMatchPoint.getBPoint()+1;i<arr2.length;i++){
                    tmp2+=arr2[i];
                }
                sum+=tmp1>tmp2?tmp1:tmp2;
                System.out.println(sum);
            }
            n=in.nextInt();
        }

    }
    static class obj{
        int val;
        int aPoint;
        int bPoint;
        long firstSum;
        long secondSum;
        public void setVal(int x){
            val=x;
        }
        public void setfirstSum(long x){
            firstSum=x;
        }
        public void setSecondSum(long x){
            secondSum=x;
        }
        public void setAPoint(int index){
         this.aPoint=index;
        }
        public void setBPoint(int index){
            this.bPoint=index;
        }
        public int getAPoint(){
            return this.aPoint;
        }
        public int getBPoint(){
            return this.bPoint;
        }
        public  long getMaxSum(){
            return firstSum>secondSum?firstSum:secondSum;
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
