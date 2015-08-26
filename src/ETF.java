import java.io.*;
import java.util.HashMap;

/**
 * Created by rsaikia on 8/10/2015.
 */
public class ETF {

    public  static int phi(int n)
    {
        int result = n;   // Initialize result as n

        // Consider all prime factors of n and subtract their
        // multiples from result
        for (int p=2; p*p<=n; ++p)
        {
            // Check if i is a prime factor.
            if (n % p == 0)
            {
                // If yes, then update n and result
                while (n % p == 0)
                    n /= p;
                result -= result / p;
            }
        }

        // If n has a prime factor greater than sqrt(n)
        // (There can be at-most one such prime factor)
        if (n > 1)
            result -= result / n;
        return result;
    }

    // Driver program to test above function
    public static void main(String[] args) throws Exception{
        Parser in = new Parser(System.in);
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int tt=in.nextInt();
        while (tt>0){
            out.println(phi(in.nextInt()));
            tt--;
        }
        out.flush();
    }

    static class Parser {
        final private int BUFFER_SIZE = 1 << 20;  // 2^16, a good compromise for some problems
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
         * @throws IOException
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
