import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
  
    private static final Scanner scanner = new Scanner(System.in);
    static int x[][] = new int [21][21];
  	private static long uniquePaths(int m, int n) {
        if(m == 1 || n == 1)
            return 1;
        m--;
        n--;
        if(m < n) {              // m must be bigger, so swap
            m = m + n;
            n = m - n;
            m = m - n;
        }
        long result = 1;
        int z = 1;
        for(int i = m+1; i <= m+n; i++, z++){       // weird way of taking factorial
            result *= i;
            result /= z;
        }
            
        return result;
    }
       
    
  
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int m = Integer.parseInt(scanner.nextLine());
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int n = Integer.parseInt(scanner.nextLine());
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        long result = uniquePaths(m, n);
        bufferedWriter.write(Long.toString(result));

        bufferedWriter.close();

        scanner.close();
    }
}