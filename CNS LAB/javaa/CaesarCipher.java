package javaa;
import java.util.Scanner;
public class CaesarCipher {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter a string: ");
            String str = sc.nextLine();
            System.out.print("Enter key: ");
            int key = sc.nextInt();
            String encrypted = caesarCipher(str, key, true);
            System.out.println("Encrypted: " + encrypted);

            String decrypted = caesarCipher(encrypted, key, false);
            System.out.println("Decrypted: " + decrypted);
        }
    }
    public static String caesarCipher(String str, int key, boolean encrypt) {
        StringBuilder result = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                int shift = encrypt ? key : -key;  
                result.append((char) ((c - base + shift + 26) % 26 + base));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}
