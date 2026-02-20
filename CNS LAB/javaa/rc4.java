package javaa;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class rc4 {

    public static void main(String[] args) throws Exception {
        String text = "hello world";
        String keyStr = "standard_key_128"; // 16 bytes for 128-bit key

        // 1. Blowfish Logic
        SecretKeySpec blowfishKey = new SecretKeySpec(keyStr.getBytes(), "Blowfish");
        Cipher bfCipher = Cipher.getInstance("Blowfish");
        bfCipher.init(Cipher.ENCRYPT_MODE, blowfishKey);
        byte[] bfEnc = bfCipher.doFinal(text.getBytes());

        // 2. RC4 Logic
        SecretKeySpec rc4Key = new SecretKeySpec(keyStr.getBytes(), "RC4");
        Cipher rc4Cipher = Cipher.getInstance("RC4");
        rc4Cipher.init(Cipher.ENCRYPT_MODE, rc4Key);
        byte[] rc4Enc = rc4Cipher.doFinal(text.getBytes());

        // Output results
        System.out.print("Blowfish (Base64): " + Base64.getEncoder().encodeToString(bfEnc));
        System.out.println();
        System.out.print("RC4 (Base64):      " + Base64.getEncoder().encodeToString(rc4Enc));
    }
}
    