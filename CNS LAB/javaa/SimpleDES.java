package javaa;

import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;



public class SimpleDES {
    public static void main(String[] args) throws Exception {
        String plainText = "HelloDES"; // Must be 8 bytes for simple DES
        
        // 1. Generate a DES Key
        SecretKey key = KeyGenerator.getInstance("DES").generateKey();
        
        // 2. Initialize the Cipher for Encryption
        Cipher desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        desCipher.init(Cipher.ENCRYPT_MODE, key);
        
        // 3. Encrypt
        byte[] encryptedBytes = desCipher.doFinal(plainText.getBytes());
        String encryptedText = Base64.getEncoder().encodeToString(encryptedBytes);
        
        // 4. Initialize for Decryption
        desCipher.init(Cipher .DECRYPT_MODE, key);
        
        // 5. Decrypt
        byte[] decryptedBytes = desCipher.doFinal(Base64.getDecoder().decode(encryptedText));
        String decryptedText = new String(decryptedBytes);

        // Output Results
        System.out.println("Original: " + plainText);
        System.out.println("Encrypted (Base64): " + encryptedText);
        System.out.println("Decrypted: " + decryptedText);
    }
}