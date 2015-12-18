package cn.wegoteam.shop.util;
import java.io.IOException;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
 
public class Aes
{
	 public static final String ZFMPWD="Shopig_&wego2013";
	 public static final String iv="SHOWG_@W8#_19#10";
	 public static String encrypt(String data){
         try {
             Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
             int blockSize = cipher.getBlockSize();
 
             byte[] dataBytes = data.getBytes();
             int plaintextLength = dataBytes.length;
             if (plaintextLength % blockSize != 0) {
                 plaintextLength = plaintextLength + (blockSize - (plaintextLength % blockSize));
             }
 
             byte[] plaintext = new byte[plaintextLength];
             System.arraycopy(dataBytes, 0, plaintext, 0, dataBytes.length);
              
             SecretKeySpec keyspec = new SecretKeySpec(ZFMPWD.getBytes(), "AES");
             IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes());
 
             cipher.init(Cipher.ENCRYPT_MODE, keyspec, ivspec);
             byte[] encrypted = cipher.doFinal(plaintext);
 
             return new BASE64Encoder().encode(encrypted);
 
         } catch (Exception e) {
             e.printStackTrace();
             return null;
         }
     }
 
     public static String desEncrypt(String data){
         try
         {
        	 if(data==null||data.equals("")){
        		 return "";
        	 }
        	 data=data.trim();
             byte[] encrypted1 = new BASE64Decoder().decodeBuffer(data);
              
             Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
             SecretKeySpec keyspec = new SecretKeySpec(ZFMPWD.getBytes(), "AES");
             IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes());
              
             cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);
 
             byte[] original = cipher.doFinal(encrypted1);
             String originalString = new String(original);
             return originalString.trim();
         }
         catch (Exception e) {
             e.printStackTrace();
             return null;
         }
     }   
     public static void main(String args[]) throws IOException{
    	 for(int i=0;i<100;i++){
    		 String a = ZfmBase64.encode((Aes.encrypt(System.currentTimeMillis()+"").getBytes()));
    		 String b = Aes.desEncrypt(ZfmBase64.decode(a));
    		 System.out.println(a+"--------"+b);
    	 }
     }
		
 }