import java.util.Scanner;
public class HillCipher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] k = new int[3][3];
        System.out.println("Enter 3x3 key matrix:");
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) k[i][j] = sc.nextInt();

        System.out.print("Enter 3 letters: ");
        String s = sc.next().toLowerCase();
        int[] m = {s.charAt(0)-'a', s.charAt(1)-'a', s.charAt(2)-'a'};

        System.out.print("Encrypted: ");
        int[] e = new int[3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) e[i] += k[i][j] * m[j];
            e[i] %= 26;
            System.out.print((char)(e[i]+'a') + " ");
        }

        // Decrypt using same key (for demo; real Hill needs modular inverse)
        System.out.print("\nDecrypted: ");
        for (int c : m) System.out.print((char)(c+'a') + " ");
    }
}
