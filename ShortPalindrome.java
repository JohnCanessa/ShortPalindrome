import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


/**
 * 
 */
public class ShortPalindrome {


    // **** constants ****
    static long MOD         = 1000000007;

    static int LETTER_COUNT = 26;
    // static int LETTER_COUNT = 5;            // for testing only


    /*
     * Complete the 'shortPalindrome' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     * 
     * Execution: O(n * m) - Space: O(m + 2 * m^2)
     */
    public static int shortPalindrome(String s) {

        // **** sanity check(s) ****
        if (s.length() <= 0) return s.length();

        // **** initialization ****
        long ans        = 0;
        long[] first    = new long[LETTER_COUNT];
        long[][] second = new long[LETTER_COUNT][LETTER_COUNT];
        long[][] third  = new long[LETTER_COUNT][LETTER_COUNT];

        String vowels   = "aeiou";          // for testing only

        // **** traverse letters in the string - O(n) ****
        for (int i = 0; i < s.length(); i++) {


            // **** select current character ****
            int c = s.charAt(i) - 'a';
            // ???? ????
            System.out.println("<<< i: " + i + " c: " + c);


            // ???? for testing only ????
            // int c = vowels.indexOf(s.charAt(i));
            // ???? ????
            // System.out.println("<<< i: " + i + " c: " + vowels.charAt(c));


            // **** update answer - O(m) ****
            for (int j = 0; j < LETTER_COUNT; j++)
                ans = (ans + third[c][j]) % MOD;

            // ???? ????
            System.out.println("<<< ans: " + ans);
            
            // **** update contents of third and second arrays - O(m) ****
            for (int j = 0; j < LETTER_COUNT; j++) {
                third[j][c]     = (third[j][c] + second[j][c]) % MOD;
                second[j][c]    = (second[j][c] + first[j]) % MOD;
            }


            // ???? ????
            // System.out.println("<<< third:");
            // for (int k = 0; k < third.length; k++)
            //     System.out.println(Arrays.toString(third[k]));
            
            // ???? ????
            // System.out.println("<<< second:");
            // for (int k = 0; k < second.length; k++)
            //     System.out.println(Arrays.toString(second[k]));


            // **** update contents of first array ****
            first[c] += 1;

            // ???? ????
            System.out.println("<<< first:\n" + Arrays.toString(first));
            // System.out.println("<<< first[" + c + "]: " + first[c]);
        }

        // **** adjust and return answer ****
        return (int)(ans % MOD);
    }


    /**
     * Test scaffold.
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        
        // **** open a buffered reader ****
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // **** read the input string ****
        String s = br.readLine().trim();

        // **** close the buffered reader ****
        br.close();

        // ???? ????
        System.out.println("main <<< s ==>" + s + "<==");

        // **** call the function of interest and display the result ****
        System.out.println("main <<< ans: " + shortPalindrome(s));
    }
}