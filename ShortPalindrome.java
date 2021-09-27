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
        long[] arr1     = new long[LETTER_COUNT];
        long[][] arr2   = new long[LETTER_COUNT][LETTER_COUNT];
        long[][] arr3   = new long[LETTER_COUNT][LETTER_COUNT];

        String vowels   = "aeiou";          // for testing only

        // **** traverse letters in the string - O(n) ****
        for (int i = 0; i < s.length(); i++) {


            // **** select current character ****
            int c = s.charAt(i) - 'a';
            // ???? ????
            System.out.println("<<< i: " + i + " c: " + c);

            // // ???? for testing only ????
            // int c = vowels.indexOf(s.charAt(i));
            // //???? ????
            // System.out.println("<<< i: " + i + " c: " + vowels.charAt(c));


            // **** update answer - O(m) ****
            for (int j = 0; j < LETTER_COUNT; j++) {

                // ???? ????
                if (arr3[c][j] != 0)
                    System.out.println("<<< ans: " + ans + " arr3[" + c + "][" + j + "]: " + arr3[c][j]);

                // **** ****
                ans = (ans + arr3[c][j]) % MOD;
            }


            // ???? ????
            System.out.println("<<< ans: " + ans);
            

            // **** update contents of arrays arr3 and arr2 - O(m) ****
            for (int j = 0; j < LETTER_COUNT; j++) {
                arr3[j][c]  = (arr3[j][c] + arr2[j][c]) % MOD;
                arr2[j][c]  = (arr2[j][c] + arr1[j]) % MOD;
            }


            // // ???? for testing only ????
            // System.out.println("<<< arr3:");
            // for (int k = 0; k < arr3.length; k++)
            //     System.out.println(Arrays.toString(arr3[k]));
            
            // // ???? for testing only ????
            // System.out.println("<<< arr2:");
            // for (int k = 0; k < arr2.length; k++)
            //     System.out.println(Arrays.toString(arr2[k]));


            // **** update contents of array arr1 ****
            arr1[c] += 1;

            // ???? for testing only ????
            // System.out.println("<<< arr1:\n" + Arrays.toString(arr1));
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