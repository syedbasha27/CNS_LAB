package javaa;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class SimpleBlowfish {
    public static void main(String[] args) throws Exception {
        String data = "BlowfishLogic";

        // 1. Generate a Blowfish Key
        SecretKey key = KeyGenerator.getInstance("Blowfish").generateKey();

        // 2. Initialize Cipher for Encryption
        Cipher cipher = Cipher.getInstance("Blowfish");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        // 3. Encrypt the data
        byte[] encrypted = cipher.doFinal(data.getBytes());
        String encoded = Base64.getEncoder().encodeToString(encrypted);

        // 4. Initialize Cipher for Decryption
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(encoded));

        System.out.println("Original: " + data);
        System.out.println("Encrypted: " + encoded);
        System.out.println("Decrypted: " + new String(decrypted));
    }
}