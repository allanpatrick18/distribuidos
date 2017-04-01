/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.copel.distribuidos.criptografia;
import java.io.*;  
import java.util.*;  
import javax.crypto.*;  
import javax.crypto.spec.*;  
import java.security.*;  
import java.security.spec.*;  
import java.security.cert.*; 
import java.util.logging.Level;
import java.util.logging.Logger;
import java.security.spec.X509EncodedKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
/**
 *
 * @author allan
 */
public class KeyGenerator {
    
    private static final int RSAKEYSIZE = 1024;  

    
    
   
     public  String [] gerarChaves()   
        throws IOException, NoSuchAlgorithmException,   
        InvalidAlgorithmParameterException,   
        CertificateException, KeyStoreException { 
              
        KeyPairGenerator kpg = KeyPairGenerator.getInstance ("RSA");  
        kpg.initialize (new RSAKeyGenParameterSpec(RSAKEYSIZE, RSAKeyGenParameterSpec.F4));  
        KeyPair kpr = kpg.generateKeyPair ();  
        PrivateKey priv = kpr.getPrivate();          
        PublicKey pub = kpr.getPublic();  
          
        //-- Gravando a chave pública em formato serializado  
        String [] r = null;
        r [0] = pub.toString();
        r [1] = priv.toString();
     
         return  r; 
          
    }  
   
    
      
    public void geraParChaves(File fPub, File fPvk)   
        throws IOException, NoSuchAlgorithmException,   
        InvalidAlgorithmParameterException,   
        CertificateException, KeyStoreException {  
              
        KeyPairGenerator kpg = KeyPairGenerator.getInstance ("RSA");  
        kpg.initialize (new RSAKeyGenParameterSpec(RSAKEYSIZE, RSAKeyGenParameterSpec.F4));  
        KeyPair kpr = kpg.generateKeyPair ();  
        PrivateKey priv = kpr.getPrivate();          
        PublicKey pub = kpr.getPublic();  
          
        //-- Gravando a chave pública em formato serializado  
        ObjectOutputStream oos = new ObjectOutputStream (new FileOutputStream (fPub));  
        oos.writeObject (pub);  
        oos.close();  
          
        //-- Gravando a chave privada em formato serializado  
        //-- Não é a melhor forma (deveria ser guardada em um keystore, e protegida por senha),   
        //-- mas isto é só um exemplo  
        oos = new ObjectOutputStream (new FileOutputStream (fPvk));  
        oos.writeObject (priv);  
        oos.close();  
          
    }  
    
    public static String savePrivateKey(PrivateKey priv) throws GeneralSecurityException {
    KeyFactory fact = KeyFactory.getInstance("DSA");
    PKCS8EncodedKeySpec spec = fact.getKeySpec(priv,
            PKCS8EncodedKeySpec.class);
    byte[] packed = spec.getEncoded();
    String key64 = base64Encode();

    Arrays.fill(packed, (byte) 0);
    return key64;
}
    
  
} 
    

