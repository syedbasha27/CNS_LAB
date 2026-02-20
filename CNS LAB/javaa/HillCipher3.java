package javaa;
import java.util.Scanner;
public class HillCipher3 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            double[][] a = new double[3][3], b = new double[3][3], c = new double[3][3], m = new double[3][1], r = new double[3][1];

            System.out.println("Enter 3x3 matrix:");
            for (int i = 0; i < 9; i++) a[i/3][i%3] = c[i/3][i%3] = sc.nextDouble();

            System.out.print("Enter 3 letters: ");
            String s = sc.next();
            System.out.print("Encrypted (Numbers): ");
            for (int i = 0; i < 3; i++) {
                m[i][0] = s.charAt(i) - 97;
                b[i][i] = 1;
                for (int k = 0; k < 3; k++) r[i][0] += a[i][k] * m[k][0];
                System.out.print((int)(Math.round(r[i][0]) % 26) + " ");
            }
            for (int k = 0; k < 3; k++)
                for (int i = 0; i < 3; i++)
                    if (i != k) {
                        double p = c[i][k], q = c[k][k];
                        for (int j = 0; j < 3; j++) {
                            c[i][j] = c[i][j] * q - p * c[k][j];
                            b[i][j] = b[i][j] * q - p * b[k][j];
                        }
                    }
            System.out.println("\nInverse Matrix:");
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) System.out.printf("%.4f ", b[i][j] /= c[i][i]);
                System.out.println();
            }

            System.out.print("Decrypted (Numbers): ");
            String decText = "";
            for (int i = 0; i < 3; i++) {
                double res = 0;
                for (int k = 0; k < 3; k++) res += b[i][k] * r[k][0];
                int num = (int)((Math.round(res) % 26 + 26) % 26);
                System.out.print(num + " ");
                decText += (char)(num + 97);
            }
            System.out.println("\nFinal Decrypted Text: " + decText);
        }
    }
}