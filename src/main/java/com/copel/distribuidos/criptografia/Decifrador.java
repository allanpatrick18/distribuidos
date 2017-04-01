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
import javax.crypto.KeyGenerator;
/**
 *
 * @author allan
 */
public class Decifrador {
    public byte[] decifra (PrivateKey pvk, byte[] textoCifrado, byte[] chaveCifrada) throws NoSuchAlgorithmException,   
    NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException,  
    BadPaddingException, InvalidAlgorithmParameterException  {  
        byte[] textoDecifrado = null;  
          
        //-- A) Decifrando a chave simétrica com a chave privada  
        Cipher rsacf = Cipher.getInstance ("RSA");  
        rsacf.init (Cipher.DECRYPT_MODE, pvk);  
        byte[] chaveDecifrada = rsacf.doFinal (chaveCifrada);  
        //-- B) Decifrando o texto com a chave simétrica decifrada  
        Cipher aescf = Cipher.getInstance ("AES/CBC/PKCS5Padding");  
        IvParameterSpec ivspec = new IvParameterSpec (new byte[16]);  
        aescf.init (Cipher.DECRYPT_MODE, new SecretKeySpec (chaveDecifrada, "AES"), ivspec);  
        textoDecifrado = aescf.doFinal (textoCifrado);  
        
        return textoDecifrado; 
}
}
