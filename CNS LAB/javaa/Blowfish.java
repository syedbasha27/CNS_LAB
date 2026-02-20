package javaa;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
public class Blowfish {
    public static void main(String[] args) throws Exception {
        String input = "Hello World";
        byte[] ivBytes = Base64.getDecoder().decode("dI1MXzW97oQ=");
        byte[] keyBytes = "1234567812345678".getBytes(); // Simple 16-byte key
        SecretKeySpec key = new SecretKeySpec(keyBytes, "Blowfish");
        IvParameterSpec iv = new IvParameterSpec(ivBytes);
        Cipher cipher = Cipher.getInstance("Blowfish/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key, iv);
        byte[] encrypted = cipher.doFinal(input.getBytes());
        System.out.println("Input: " + input);
        System.out.println("Output: " + new String(encrypted)); // Raw mapping to characters
    }
}