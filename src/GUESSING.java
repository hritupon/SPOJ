import java.util.Scanner;

/**
 * Created by rsaikia on 8/7/2015.
 */
public class GUESSING {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String target = sc.next();
            String guess = "000000";
            int aCount = 0;
            int bCount = 0;
            for (int i = 0; i < guess.length(); i++) {
                if (target.charAt(i) == guess.charAt(i)) {
                    aCount++;
                }
            }
            for (int i = 0; i < target.length(); i++) {
                for (int j = 0; j < guess.length(); j++) {
                    if (i != j && target.charAt(i) == guess.charAt(j)) {
                        bCount++;
                    }
                }
            }
            System.out.println(aCount + "A" + bCount + "B");
        }
    }
}
