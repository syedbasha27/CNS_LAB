package javaa;
import java.io.*;

public class cns2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.print("Enter any string: ");
        String str = br.readLine();
        StringBuilder result = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (Character.isLowerCase(c)) {
                // Formula: 'z' - (current - 'a')
                result.append((char) ('z' - (c - 'a')));
            } else if (Character.isUpperCase(c)) {
                // Formula: 'Z' - (current - 'A')
                result.append((char) ('Z' - (c - 'A')));
            } else {
                result.append(c);
            }
        }

        System.out.println("The encrypted data is: " + result);
    }
}