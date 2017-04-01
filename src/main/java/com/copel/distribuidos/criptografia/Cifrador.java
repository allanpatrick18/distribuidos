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


import javax.crypto.Cipher;

/**
 *
 * @author allan
 */
public class Cifrador {
   
    
        public byte[][] cifra (PublicKey pub, byte[] textoClaro) throws NoSuchAlgorithmException,   
        NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException,  
        BadPaddingException, InvalidAlgorithmParameterException {  
        byte[] textoCifrado = null;  
        byte[] chaveCifrada = null;  
          
        //-- A) Gerando uma chave simétrica de 128 bits  
        KeyGenerator kg = KeyGenerator.getInstance ("AES");  
        kg.init (128);  
        SecretKey sk = kg.generateKey ();  
        byte[] chave = sk.getEncoded();  
        //-- B) Cifrando o texto com a chave simétrica gerada  
        Cipher aescf = Cipher.getInstance ("AES/CBC/PKCS5Padding");  
        IvParameterSpec ivspec = new IvParameterSpec (new byte[16]);  
        aescf.init (Cipher.ENCRYPT_MODE, new SecretKeySpec (chave, "AES"), ivspec);  
        textoCifrado = aescf.doFinal (textoClaro);  
        //-- C) Cifrando a chave com a chave pública  
        Cipher rsacf = Cipher.getInstance ("RSA");  
        rsacf.init (Cipher.ENCRYPT_MODE, pub);  
        chaveCifrada = rsacf.doFinal (chave);  
          
        return new byte[][] { textoCifrado, chaveCifrada };  
} 
}
