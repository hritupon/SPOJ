import java.util.Scanner;

/**
 * Created by rsaikia on 7/30/2015.
 */
public class PALIN {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int tt=sc.nextInt();
        boolean first=true;
        while(tt>0){
            String str=sc.next();
            int[] arr=new int[str.length()];
            for(int i=0;i<str.length();i++){
                arr[i]=str.charAt(i)-'0';
            }
            generateNextPalindrome(arr, str.length(),first);
            first=false;
            tt--;
        }
    }

    public static void generateNextPalindromeUtil(int num[], int n, boolean first) {
        // find the index of mid digit
        int mid = n / 2;

        // A bool variable to check if copy of left side to right is sufficient or not
        boolean leftsmaller = false;

        // end of left side is always 'mid -1'
        int i = mid - 1;

        // Begining of right side depends if n is odd or even
        int j = ((n % 2)==0) ? mid : mid +1;

        // Initially, ignore the middle same digits
        while (i >= 0 && num[i] == num[j]) {
            i--;
            j++;
        }

        // Find if the middle digit(s) need to be incremented or not (or copying left
        // side is not sufficient)
        if (i < 0 || num[i] < num[j])
            leftsmaller = true;

        // Copy the mirror of left to tight
        while (i >= 0 && j<n) {
            num[j] = num[i];
            j++;
            i--;
        }

        // Handle the case where middle digit(s) must be incremented.
        // This part of code is for CASE 1 and CASE 2.2
        if (leftsmaller == true) {
            int carry = 1;
            i = mid - 1;

            // If there are odd digits, then increment
            // the middle digit and store the carry
            if (n % 2 == 1) {
                num[mid] += carry;
                carry = num[mid] / 10;
                num[mid] %= 10;
                j = mid + 1;
            } else
                j = mid;

            // Add 1 to the rightmost digit of the left side, propagate the carry
            // towards MSB digit and simultaneously copying mirror of the left side
            // to the right side.
            while (i >= 0) {
                num[i] += carry;
                carry = num[i] / 10;
                num[i] %= 10;
                num[j++] = num[i--]; // copy mirror to right
            }
        }
    }


    // The function that prints next palindrome of a given number num[]
// with n digits.
    public static void generateNextPalindrome(int num[], int n,boolean first) {
        int i;

       // System.out.print("\nNext palindrome is:\n");

        // Input type 1: All the digits are 9, simply o/p 1
        // followed by n-1 0's followed by 1.
        if (AreAll9s(num, n)) {
            if(!first) System.out.println("");
            System.out.print("1");
            for (i = 1; i < n; i++)
                System.out.print("0");
            System.out.print("1");
        }

        // Input type 2 and 3
        else {
            generateNextPalindromeUtil(num, n,first);

            // print the result
            printArray(num, n,first);
        }
    }

    // A utility function to check if num has all 9s
    public static boolean AreAll9s(int[] num, int n) {
        int i;
        for (i = 0; i < n; ++i)
            if (num[i] != 9)
                return false;
        return true;
    }

    /* Utility that prints out an array on a line */
   public static void printArray(int arr[], int n,boolean first) {
        int i;
        if(!first)System.out.print("\n");
        for (i = 0; i < n; i++)
            System.out.print(arr[i]);

    }
}




