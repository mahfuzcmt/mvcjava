package edu.vub.ns.webcore.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

import org.apache.commons.codec.binary.Base64;


public class PasswordCipher {
	public static Cipher dcipher, ecipher;
	//private static Logger logger = Logger.getLogger(PasswordCipher.class);

	public static void cipherMain() 
	{ 
		String passPhrase = "";
		 // 8-bytes Salt
        byte[] salt = { (byte) 0xA9, (byte) 0x9B, (byte) 0xC8, (byte) 0x32,
                     (byte) 0x56, (byte) 0x34, (byte) 0xE3, (byte) 0x03 };

        // Iteration count
        int iterationCount = 19;

        try {
               // Generate a temporary key. In practice, you would save this key
               // Encrypting with DES Using a Pass Phrase
               KeySpec keySpec = new PBEKeySpec(passPhrase.toCharArray(), salt, iterationCount);
               SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(keySpec);

               ecipher = Cipher.getInstance(key.getAlgorithm());
               dcipher = Cipher.getInstance(key.getAlgorithm());

               // Prepare the parameters to the cipthers
               AlgorithmParameterSpec paramSpec = new PBEParameterSpec(salt, iterationCount);

               ecipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
               dcipher.init(Cipher.DECRYPT_MODE, key, paramSpec);

        } catch (InvalidAlgorithmParameterException e) {
           // logger.error("EXCEPTION: InvalidAlgorithmParameterException", e);
        } catch (InvalidKeySpecException e) {
        	//logger.error("EXCEPTION: InvalidKeySpecException", e);
        } catch (NoSuchPaddingException e) {
        	//logger.error("EXCEPTION: NoSuchPaddingException", e);
        } catch (NoSuchAlgorithmException e) {
        	///logger.error("EXCEPTION: NoSuchAlgorithmException", e);
        } catch (InvalidKeyException e) {
        	//logger.error("EXCEPTION: InvalidKeyException", e);
        }
		
	}
	
	// Encrpt Password
    public static String encrypt(String str) {
       cipherMain();
       try {
              // Encode the string into bytes using utf-8
              byte[] utf8 = str.getBytes("UTF8");
              // Encrypt
              byte[] enc = ecipher.doFinal(utf8);
              // Encode bytes to base64 to get a string
              return Base64.encodeBase64String(enc);

       } catch (BadPaddingException e) {
       } catch (IllegalBlockSizeException e) {
       } catch (UnsupportedEncodingException e) {
       }
       return null;
    }

    // Decrpt password
    // To decrypt the encryted password
    public static String decrypt(String str) {
       cipherMain();
       Cipher dcipher = null;
       try {
              byte[] salt = { (byte) 0xA9, (byte) 0x9B, (byte) 0xC8, (byte) 0x32,
                           (byte) 0x56, (byte) 0x34, (byte) 0xE3, (byte) 0x03 };
              int iterationCount = 19;
              try {
                    String passPhrase = "";
                    KeySpec keySpec = new PBEKeySpec(passPhrase.toCharArray(),
                                  salt, iterationCount);
                    SecretKey key = SecretKeyFactory
                                  .getInstance("PBEWithMD5AndDES")
                                  .generateSecret(keySpec);
                    dcipher = Cipher.getInstance(key.getAlgorithm());
                    // Prepare the parameters to the cipthers
                    AlgorithmParameterSpec paramSpec = new PBEParameterSpec(salt,
                                  iterationCount);
                    dcipher.init(Cipher.DECRYPT_MODE, key, paramSpec);
              } catch (InvalidAlgorithmParameterException e) {
            	//  logger.error("EXCEPTION: InvalidAlgorithmParameterException", e);
              } catch (InvalidKeySpecException e) {
            	//  logger.error("EXCEPTION: InvalidKeySpecException", e);
              } catch (NoSuchPaddingException e) {
            	//  logger.error("EXCEPTION: NoSuchPaddingException", e);
              } catch (NoSuchAlgorithmException e) {
            	//  logger.error("EXCEPTION: NoSuchAlgorithmException", e);
              } catch (InvalidKeyException e) {
            	//  logger.error("EXCEPTION: InvalidKeyException", e);
              }
              // Decode base64 to get bytes
              byte[] dec = Base64.decodeBase64(str);
              // Decrypt
              byte[] utf8 = dcipher.doFinal(dec);
              // Decode using utf-8
              return new String(utf8, "UTF8");
       } catch (BadPaddingException e) {
       } catch (IllegalBlockSizeException e) {
       } catch (UnsupportedEncodingException e) {
       } 
       return null;
    }
}
