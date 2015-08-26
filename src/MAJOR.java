import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by rsaikia on 8/13/2015.
 */
public class MAJOR {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tt = Integer.parseInt(br.readLine().trim());
        while (tt > 0) {
            boolean occured = false;
            int occur[] = new int[2006];

            int result = -1;
            int n = Integer.parseInt(br.readLine().trim());

            int half = n / 2;
            if (n == 0) {
                System.out.println("NO");
                tt--;
                continue;
            }

            String str=br.readLine().trim();
            String[] numSplt=str.split(" ");
            for (int i = 0; i < n; i++) {
                int key = Integer.parseInt(numSplt[i]);
                key = 1005 + key;
                int val = occur[key] + 1;
                if (val > half) {
                    occured = true;
                    result = key;
                    break;
                }
                occur[key] = val;
            }
            if (occured) {
                result = result - 1005;
                System.out.println("YES " + result);

            } else {
                System.out.println("NO");
            }
            tt--;
        }
    }
}
